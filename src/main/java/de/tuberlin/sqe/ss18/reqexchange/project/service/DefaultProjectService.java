package de.tuberlin.sqe.ss18.reqexchange.project.service;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.common.service.JsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ProjectInfo;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DefaultProjectService implements ProjectService {

    private PathService pathService;
    private JsonSerializerService jsonSerializerService;
    private GitService gitService;

    @Inject
    public DefaultProjectService(
            PathService pathService,
            JsonSerializerService jsonSerializerService,
            GitService gitService) {
        this.jsonSerializerService = jsonSerializerService;
        this.pathService = pathService;
        this.gitService = gitService;
    }

    @Override
    public List<Project> getAll() {
        List<Project> result = new ArrayList<>();

        try {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathService.getProjectInfosPath())) {
                directoryStream.forEach(projectInfoFilePath -> {
                    if (Files.isRegularFile(projectInfoFilePath)) {
                        ProjectInfo projectInfo = loadProjectInfo(projectInfoFilePath.toFile());

                        Project project = getProjectByNameAndFilePath(
                                projectInfo.getName(),
                                Paths.get(projectInfo.getFileName()));
                        //TODO: get information about push and pull?
                        result.add(project);
                    }
                });
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Project create(String name, Path filePath, ReqExchangeFileType reqExchangeFileType) {
        ///TODO: support for all ReqExchangeFileType
        if (reqExchangeFileType != ReqExchangeFileType.ReqIF) {
            return null;
        }

        Project newProject = getProjectByNameAndFilePath(name, filePath);
        if (Files.exists(newProject.getProjectInfoFilePath())) {
            return null;
        }

        if (!gitService.clone(newProject)) {
            return null;
        }

        //TODO: file nach common modell übersetzen
        createDummyFile(newProject);

        if (!gitService.executeAddCommitPushAll(newProject)) {
            return null;
        }

        saveProjectInfo(newProject);

        return newProject;
    }

    @Override
    public Project join(String name, Path filePath, ReqExchangeFileType reqExchangeFileType) {
        //TODO: support for all ReqExchangeFileType
        if (reqExchangeFileType != ReqExchangeFileType.ReqIF) {
            return null;
        }

        Project joinProject = getProjectByNameAndFilePath(name, filePath);
        if (Files.exists(joinProject.getProjectInfoFilePath())) {
            return null;
        }

        if (!gitService.clone(joinProject)) {
            return null;
        }

        //TODO: ersetzen gegen mapper funktion
        createNewFileInPathWithName(filePath.getParent(), filePath.getFileName().toString(), "Ich bin eine neue Datei im gewünschten Format.");

        saveProjectInfo(joinProject);

        return joinProject;
    }

    @Override
    public boolean leave(Project project) {
        //File localGitRepository = pathService.getLocalGitRepositoryPath(projectInfo).toFile();
        if (project.getLocalGitRepositoryPath().toFile().exists()) {
            try {
                FileUtils.deleteDirectory(project.getLocalGitRepositoryPath().toFile());
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        project.getProjectInfoFilePath().toFile().delete();

        return true;
    }

    @Override
    public void refresh(Project project) {
        //TODO: ob das schon funktioniert? also der gitService
        project.setLocalChanged(gitService.canPush(project));
        project.setRemoteChanged(gitService.canPull(project));
    }

    private Project getProjectByNameAndFilePath(String name, Path filePath) {
        Project result = new Project();
        result.setName(name);
        result.setFilePath(filePath);
        result.setLocalGitRepositoryPath(pathService.getLocalGitRepositoryPathByProjectName(name));
        result.setProjectInfoFilePath(pathService.getProjectInfosPath().resolve(name + "json"));

        return result;
    }

    //TODO: remove after mapping works
    private void createDummyFile(Project project) {
        createNewFileInPathWithName(
                project.getLocalGitRepositoryPath(),
                "dummyFile.txt",
                "Diese Datei stellt ein Beispiel dar..");
    }
    //TODO: remove after mapping works
    private void createNewFileInPathWithName(Path path, String fileName, String content) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path.resolve(fileName))) {
            bufferedWriter.write(content);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveProjectInfo(Project project) {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setName(project.getName());
        projectInfo.setFileName(project.getFilePath().toString());

        jsonSerializerService.serializeToFile(projectInfo, project.getProjectInfoFilePath().toFile());
    }

    private ProjectInfo loadProjectInfo(File projectInfoFilePath) {
        return jsonSerializerService.deserializeToObject(projectInfoFilePath, ProjectInfo.class);
    }

}

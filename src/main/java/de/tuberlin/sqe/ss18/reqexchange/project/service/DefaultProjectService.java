package de.tuberlin.sqe.ss18.reqexchange.project.service;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.model.service.ModelTransformationService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.ModelValidationService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.JsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ProjectInfo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
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
    private ModelTransformationService modelTransformationService;
    private ModelValidationService modelValidationService;

    @Inject
    public DefaultProjectService(
            PathService pathService,
            JsonSerializerService jsonSerializerService,
            GitService gitService,
            ModelTransformationService modelTransformationService,
            ModelValidationService modelValidationService) {
        this.jsonSerializerService = jsonSerializerService;
        this.pathService = pathService;
        this.gitService = gitService;
        this.modelTransformationService = modelTransformationService;
        this.modelValidationService = modelValidationService;
    }

    @Override
    public List<Project> getAll() {
        List<Project> result = new ArrayList<>();

        try {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathService.getProjectInfosPath())) {
                directoryStream.forEach(projectInfoFilePath -> {
                    if (Files.isRegularFile(projectInfoFilePath)) {
                        ProjectInfo projectInfo = loadProjectInfo(projectInfoFilePath.toFile());

                        Project project = getProject(
                                projectInfo.getRemoteGitRepositoryName() != null
                                        ? URI.create(projectInfo.getRemoteGitRepositoryName())
                                        : null,
                                projectInfo.getName(),
                                Paths.get(projectInfo.getFileName()));
                        project.setPullNeeded(projectInfo.isPullNeeded());
                        refresh(project);
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
    public Project create(URI remoteGitRepositoryURI, String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType) {
        ///TODO: support for all ReqExchangeFileType
        if (reqExchangeFileType != ReqExchangeFileType.ReqIF) {
            return null;
        }

        Project newProject = getProject(remoteGitRepositoryURI, name, workingFilePath);
        if (Files.exists(newProject.getProjectInfoFilePath())) {
            return null;
        }

        if (!gitService.clone(newProject)) {
            return null;
        }

        if (!modelTransformationService.transform(newProject.getWorkingModelFilePath(), newProject.getCommonModelFilePath())) {
            leave(newProject);
            return null;
        }

        if (!gitService.executeAddCommitPushAll(newProject)) {
            return null;
        }

        saveProjectInfo(newProject);

        return newProject;
    }

    public Project create(String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType) {
        return create(null, name, workingFilePath, reqExchangeFileType);
    }

    @Override
    public Project join(String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType) {
        return join(null, name, workingFilePath, reqExchangeFileType);
    }
    public Project join(URI remoteGitRepositoryURI, String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType) {

        Project joinProject = getProject(remoteGitRepositoryURI, name, workingFilePath);
        if (Files.exists(joinProject.getProjectInfoFilePath())) {
            return null;
        }

        if (!gitService.clone(joinProject)) {
            return null;
        }

        if (!modelTransformationService.transform(joinProject.getCommonModelFilePath(), joinProject.getWorkingModelFilePath())) {
            leave(joinProject);
            return null;
        }

        saveProjectInfo(joinProject);

        return joinProject;
    }

    @Override
    public boolean leave(Project project) {
        if (project.getLocalGitRepositoryPath().toFile().exists()) {
            try {
                FileUtils.deleteDirectory(project.getLocalGitRepositoryPath().toFile());
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        //Files.delete(project.getProjectInfoFilePath());
        if (!project.getProjectInfoFilePath().toFile().delete()) {
            return false;
        }

        return true;
    }

    @Override
    public void refresh(Project project) {
        //TODO: ob das schon funktioniert? also der gitService
        project.setPushNeeded(checkPushNeeded(project));

        if (!project.isPullNeeded()) {
            if (gitService.checkPullNeeded(project)) {
                project.setPullNeeded(true);
                saveProjectInfo(project);
            }
        }
    }

    //private boolean checkPullNeeded(Project project) {

    //    return project.isPullNeeded();
    //}

    private boolean checkPushNeeded(Project project) {
        long userFileLastModified = project.getWorkingModelFilePath().toFile().lastModified();
        long gitFileLastModified = project.getCommonModelFilePath().toFile().lastModified();

        return userFileLastModified > gitFileLastModified;
    }

    @Override
    public boolean synchronize(Project project) {

        if (project.isPushNeeded()) {
            if (!modelValidationService.validate(project.getWorkingModelFilePath())) {
                modelTransformationService.transform(project.getCommonModelFilePath(), project.getWorkingModelFilePath());

                return false;
            }

            modelTransformationService.transform(project.getWorkingModelFilePath(), project.getCommonModelFilePath());
            gitService.commitAll(project);
        }

        //4. pull mit MergeStrategy our
        gitService.pullMergeStrategyOur(project);
        if (modelValidationService.validate(project.getCommonModelFilePath())) {
            gitService.pushAll(project);
        }
        else {
            gitService.resetHard(project);
        }

        project.setPushNeeded(false);
        project.setPullNeeded(false);
        saveProjectInfo(project);
        modelTransformationService.transform(project.getCommonModelFilePath(), project.getWorkingModelFilePath());
        return true;
    }

    @Override
    public boolean export(Project project, Path pathToExport) {
        return modelTransformationService.transform(project.getWorkingModelFilePath(), pathToExport);
        //return false;
    }

    private Project getProject(URI remoteGitRepositoryURI, String name, Path filePath) {
        Project result = new Project();
        result.setRemoteGitRepositoryURI(remoteGitRepositoryURI);
        result.setName(name);
        result.setWorkingModelFilePath(filePath);
        result.setLocalGitRepositoryPath(pathService.getLocalGitRepositoryPathByProjectName(name));
        result.setCommonModelFilePath(pathService.getLocalGitRepositoryPathByProjectName(name).resolve("data.cm"));
        result.setProjectInfoFilePath(pathService.getProjectInfosPath().resolve(name + ".json"));

        return result;
    }

    private void saveProjectInfo(Project project) {
        ProjectInfo projectInfo = new ProjectInfo();
        if (project.getRemoteGitRepositoryURI() != null) {
            projectInfo.setRemoteGitRepositoryName(project.getRemoteGitRepositoryURI().toString());
        }
        projectInfo.setName(project.getName());
        projectInfo.setFileName(project.getWorkingModelFilePath().toString());
        projectInfo.setPullNeeded(project.isPullNeeded());

        jsonSerializerService.serializeToFile(projectInfo, project.getProjectInfoFilePath().toFile());
    }

    private ProjectInfo loadProjectInfo(File projectInfoFilePath) {
        return jsonSerializerService.deserializeToObject(projectInfoFilePath, ProjectInfo.class);
    }

}

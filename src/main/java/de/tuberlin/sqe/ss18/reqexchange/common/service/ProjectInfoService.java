package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.common.service.JsonSerializerService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectInfoService {

    private PathService pathService;
    private JsonSerializerService jsonSerializerService;
    private GitService gitService;

    @Autowired
    public ProjectInfoService(
            PathService pathService,
            JsonSerializerService jsonSerializerService,
            GitService gitService) {
        this.jsonSerializerService = jsonSerializerService;
        this.pathService = pathService;
        this.gitService = gitService;

    }

    public List<ProjectInfo> getAll() {
        List<ProjectInfo> result = new ArrayList<>();

        try {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathService.getProjectInfosPath())) {
                directoryStream.forEach(projectInfo -> {
                     if (Files.isRegularFile(projectInfo)) {
                         result.add(jsonSerializerService.deserialize(projectInfo.toFile(), ProjectInfo.class));
                     }
                });
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean create(String name, Path filePath, ReqExchangeFileType fileType) {
        ///aktuell nur fileType = ReqIF

        //TODO: error handling
        //TODO: git repository anlegen
        //TODO: file nach common modell übersetzen
        //TODO: git dateien auf remote pushen
        File projectInfoFile = getProjectInfoFile(name);

        if (projectInfoFile.exists()) {
            return false;
        }

        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setName(name);
        projectInfo.setFileName(filePath.toFile().getAbsolutePath());

        //TODO: git repository clonen
        if (!gitService.clone(projectInfo)) {
            return false;
        }

        //TODO: file nach common modell übersetzen
        createDummyFile(projectInfo);
        //TODO: git dateien auf remote pushen
        gitService.commit(projectInfo);
        gitService.push(projectInfo);


        jsonSerializerService.serializeToFile(projectInfo, projectInfoFile);

        return true;
    }

    private void createDummyFile(ProjectInfo projectInfo) {
        createNewFileInPathWithName(
                pathService.getLocalGitRepositoryPath(projectInfo),
                "dummyFile.txt",
                "Diese Datei stellt ein Beispiel dar..");
    }

    private void createNewFileInPathWithName(Path path, String fileName, String content) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path.resolve(fileName))) {
            bufferedWriter.write(content);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean join(String name, Path filePath, ReqExchangeFileType fileType) {
        //TODO: implement
        //TODO: git repository clonen
        //TODO: gewünschte Datei aus common modell erstellen
        //TODO: projectInfo speichern
        return false;
    }

    public boolean leave(ProjectInfo projectInfo) {
        //TODO: implement
        //TODO: git lokales repository löschen

        //TODO: requirementsdatei eher nicht löschen
        //TODO: projectinfo löschen
        File projectInfoFile = getProjectInfoFile(projectInfo);
        projectInfoFile.delete();

        return false;
    }

    private File getProjectInfoFile(ProjectInfo projectInfo) {
        return getProjectInfoFile(projectInfo.getName());
    }

    private File getProjectInfoFile(String name) {
        return pathService.getProjectInfosPath().resolve(name + ".json").toFile();
    }



//    public boolean save(ProjectInfo projectInfo) {
//        //TODO: implement create and update
//        Path projectPath = pathService.getProjectsPath().resolve(projectInfo.getName());
//        try {
//            if (!Files.exists(projectPath)) {
//                Files.createDirectory(projectPath);
//            }
//
//            File jsonFile = projectPath.resolve("info.json").toFile();
//            jsonSerializerService.serializeToFile(projectInfo, jsonFile);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

//    public void delete(ProjectInfo projectInfo) {
//        //TODO: delete if exists
//    }


}

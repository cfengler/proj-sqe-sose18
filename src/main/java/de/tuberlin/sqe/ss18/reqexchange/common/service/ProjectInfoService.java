package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.service.JsonSerializerService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectInfoService {

    private JsonSerializerService jsonSerializerService;
    private PathService pathService;

    @Autowired
    public ProjectInfoService(
            JsonSerializerService jsonSerializerService,
            PathService pathService) {
        this.jsonSerializerService = jsonSerializerService;
        this.pathService = pathService;
    }

    public List<ProjectInfo> getAll() {
        List<ProjectInfo> result = new ArrayList<>();

        if (!Files.isDirectory(pathService.getProjectsPath())) {
            return result;
        }

        try {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathService.getProjectsPath())) {
                directoryStream.forEach(path -> {
                     if (Files.isDirectory(path)) {
                         Path infoPath = path.resolve("info.json");
                         if (Files.isRegularFile(infoPath)) {
                             result.add(jsonSerializerService.deserialize(infoPath.toFile(), ProjectInfo.class));
                         }
                     }
                });
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean create(String name, File file) {
        //TODO: implement
        return false;
    }

    public boolean join(String name) {
        //TODO: implement
        return false;
    }

    public boolean delete() {
        //TODO: implement
        return false;
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

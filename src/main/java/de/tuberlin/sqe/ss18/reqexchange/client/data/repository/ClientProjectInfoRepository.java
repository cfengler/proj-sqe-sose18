package de.tuberlin.sqe.ss18.reqexchange.client.data.repository;

import de.tuberlin.sqe.ss18.reqexchange.client.data.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.client.service.ClientPathService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.JsonSerializerService;
import org.apache.commons.io.FileUtils;
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
public class ClientProjectInfoRepository {

    private JsonSerializerService jsonSerializerService;
    private ClientPathService pathService;

    @Autowired
    public ClientProjectInfoRepository(JsonSerializerService jsonSerializerService, ClientPathService pathService) {
        this.jsonSerializerService = jsonSerializerService;
        this.pathService = pathService;

        createTestData();
    }

    private void createTestData() {
        ProjectInfo projectInfo1 = new ProjectInfo();
        projectInfo1.setName("Test Project 1");
        projectInfo1.setPassword("123456");
        projectInfo1.setPullTimestamp(new DateTime());
        projectInfo1.setFilename(null);
        save(projectInfo1);
        ProjectInfo projectInfo2 = new ProjectInfo();
        projectInfo2.setName("Crackdown");
        projectInfo2.setPassword("abcd");
        projectInfo2.setPullTimestamp(new DateTime());
        projectInfo2.setFilename("wordfile.docx");
        save(projectInfo2);
        ProjectInfo projectInfo3 = new ProjectInfo();
        projectInfo3.setName("PeterPan");
        projectInfo3.setPassword("parole");
        projectInfo3.setPullTimestamp(new DateTime());
        projectInfo3.setFilename("exceltest.xls");
        save(projectInfo3);
        ProjectInfo projectInfo4 = new ProjectInfo();
        projectInfo4.setName("SQE Quark");
        projectInfo4.setPassword("12ab12ab");
        projectInfo4.setPullTimestamp(new DateTime());
        projectInfo4.setFilename("reqif_lame.reqifz");
        save(projectInfo4);
    }


    public List<ProjectInfo> findAll() {
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

    public boolean save(ProjectInfo projectInfo) {
        //TODO: implement create and update
        Path projectPath = pathService.getProjectsPath().resolve(projectInfo.getName());
        try {
            if (!Files.exists(projectPath)) {
                Files.createDirectory(projectPath);
            }

            File jsonFile = projectPath.resolve("info.json").toFile();
            jsonSerializerService.serializeToFile(projectInfo, jsonFile);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void delete(ProjectInfo projectInfo) {
        //TODO: delete if exists
    }


}

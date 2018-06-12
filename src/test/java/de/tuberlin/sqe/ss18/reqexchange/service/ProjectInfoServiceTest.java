package de.tuberlin.sqe.ss18.reqexchange.service;


import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.common.service.*;
import junit.framework.TestCase;

import java.nio.file.Path;

public class ProjectInfoServiceTest extends TestCase {

    private String projectName = "proj-sqe-sose18-unittest";
    private Path fileForCreateProjectPath;
    //private Path fileForJoinProjectPath;

    private ProjectInfo projectInfo;

    private PathService pathService;
    private JsonSerializerService jsonSerializerService;

    private GitPropertiesService gitPropertiesService;
    private GitService gitService;

    private ProjectInfoService projectInfoService;

    public ProjectInfoServiceTest() {
        initTestData();

        pathService = new TestPathService();
        jsonSerializerService = new JsonSerializerService();

        gitPropertiesService = new GitPropertiesService(pathService);
        gitService = new GitService(pathService, gitPropertiesService);

        projectInfoService = new ProjectInfoService(pathService, jsonSerializerService, gitService);
    }

    private void initTestData() {
        fileForCreateProjectPath = pathService.getPathOfRunningJar().resolve("samplefiles").resolve("01_minimal_ReqIF").resolve("My.reqif");

    }

    public void test_createProject() {
        //TODO: implement
        projectInfo = projectInfoService.create(projectName, fileForCreateProjectPath, ReqExchangeFileType.ReqIF);
        assertNotNull(projectInfo);
        assertTrue(pathService.getLocalGitRepositoryPath(projectInfo).toFile().exists());
    }

    public void test_joinProject() {
        //TODO: implement
    }

    public void test_leaveProject() {
        //TODO: implement
    }
}

//package de.tuberlin.sqe.ss18.reqexchange.service;
//
//
//import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
//import de.tuberlin.sqe.ss18.reqexchange.common.service.*;
//import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitPropertiesService;
//import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitService;
//import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
//import junit.framework.TestCase;
//
//import java.nio.file.Path;
//
//public class ProjectInfoServiceTest extends TestCase {
//
//    private String projectName = "proj-sqe-sose18-unittest";
//    private Path fileForCreateProjectPath;
//    //private Path fileForJoinProjectPath;
//
//    private ProjectInfo projectInfo;
//
//    private PathService pathService;
//    private DefaultJsonSerializerService jsonSerializerService;
//
//    private DefaultGitPropertiesService gitPropertiesService;
//    private GitService gitService;
//
//    private DefaultProjectInfoService projectInfoService;
//
//    public ProjectInfoServiceTest() {
//        initTestData();
//
//        pathService = new TestPathService();
//        jsonSerializerService = new DefaultJsonSerializerService();
//
//        gitPropertiesService = new DefaultGitPropertiesService(pathService);
//        gitService = new DefaultGitService(pathService, gitPropertiesService);
//
//        projectInfoService = new DefaultProjectInfoService(pathService, jsonSerializerService, gitService);
//    }
//
//    private void initTestData() {
//        fileForCreateProjectPath = pathService.getPathOfRunningJar().resolve("samplefiles").resolve("01_minimal_ReqIF").resolve("My.reqif");
//
//    }
//
//    public void test_createProject() {
//        //TODO: implement
//        projectInfo = projectInfoService.create(projectName, fileForCreateProjectPath, ReqExchangeFileType.ReqIF);
//        assertNotNull(projectInfo);
//        assertTrue(pathService.getLocalGitRepositoryPath(projectInfo).toFile().exists());
//    }
//
//    public void test_joinProject() {
//        //TODO: implement
//    }
//
//    public void test_leaveProject() {
//        //TODO: implement
//    }
//}

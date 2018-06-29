package de.tuberlin.sqe.ss18.reqexchange.project.service;

import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.TestPathService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.DefaultModelTransformationService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.DefaultModelValidationService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.ModelTransformationService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.ModelValidationService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.DefaultJsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.JsonSerializerService;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultProjectServiceTest {

    private static final String TESTPROJECTNAME = "myTestOfAName";

    private static PathService pathService;
    private static GitPropertiesService gitPropertiesService;
    private static GitService gitService;
    private static JsonSerializerService jsonSerializerService;
    private static ModelTransformationService modelTransformationService;
    private static ModelValidationService modelValidationService;
    private static ProjectService projectService;

    private static CredentialsProvider testCredentialsProvider;

    private static Path testPath;
    private static Path unitTestPath;

    private static Path jGitPath;
    private static Path jGitCommonModelFilePath;

    private static Path tempReqifWorkingFilePath;
    private static Path tempSysmlWorkingFilePath;
    private static Path tempXlsxWorkingFilePath;

    private static Path oneRequirementReqifWorkingFilePath;
    private static Path oneRequirementSysmlWorkingFilePath;
    private static Path oneRequirementXlsxWorkingFilePath;

    private static String remoteRepositoryName;

    @BeforeClass
    public static void startUp() throws IOException {
        pathService = new TestPathService();
        gitPropertiesService = new DefaultGitPropertiesService(pathService);
        gitService = new DefaultGitService(pathService, gitPropertiesService);
        jsonSerializerService = new DefaultJsonSerializerService();
        modelTransformationService = new DefaultModelTransformationService();
        modelValidationService = new DefaultModelValidationService();
        projectService = new DefaultProjectService(
                pathService,
                jsonSerializerService,
                gitService,
                modelTransformationService,
                modelValidationService);

        testCredentialsProvider = new UsernamePasswordCredentialsProvider(
                gitPropertiesService.getUsername(),
                gitPropertiesService.getPassword());

        initTestVariables();
    }

    private static void initTestVariables() throws IOException {
        testPath = pathService.getPathOfRunningJar().resolve("test");
        unitTestPath = pathService.getPathOfRunningJar().resolve("unitTest");
        //TODO: oneRequirementXlsxWorkingFilePath
        oneRequirementReqifWorkingFilePath = unitTestPath.resolve("OneRequirementWorkingFile.reqif");
        oneRequirementSysmlWorkingFilePath = unitTestPath.resolve("OneRequirementWorkingFile.uml");
        oneRequirementXlsxWorkingFilePath = unitTestPath.resolve("OneRequirementWorkingFile.xslx");

        jGitPath = testPath.resolve("test_" + TESTPROJECTNAME);
        jGitCommonModelFilePath = jGitPath.resolve("data.cm");

        tempReqifWorkingFilePath = testPath.resolve("TempWorkingFile.reqif");
        tempSysmlWorkingFilePath = testPath.resolve("TempWorkingFile.uml");
        tempXlsxWorkingFilePath = testPath.resolve("TempWorkingFile.xslx");

        //TODO: use common git settings instead of defined url

        remoteRepositoryName = "https://github.com/cfengler/proj-sqe-sose18-unittest.git";
    }

    @AfterClass
    public static void tearDown() throws IOException {
        FileUtils.deleteDirectory(testPath.toFile());
    }

    @Before
    public void prepareTest() {

    }

    @After
    public void tearDownTest() {
    }

    @Test
    public void test_02a_createProject_reqIF() throws GitAPIException, IOException {
        clearRemoteRepository();

        Files.copy(oneRequirementReqifWorkingFilePath, tempReqifWorkingFilePath);
        Project project = projectService.create(URI.create(remoteRepositoryName), TESTPROJECTNAME, tempReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
        Assert.assertNotNull(project);
        Assert.assertTrue(projectService.leave(project));

        cloneLocalRepository();
        Assert.assertTrue(jGitCommonModelFilePath.toFile().exists());
        Assert.assertTrue(FileUtils.contentEquals(
                jGitCommonModelFilePath.toFile(),
                oneRequirementReqifWorkingFilePath.toFile()));

        deleteLocalRepository();
        Files.deleteIfExists(tempReqifWorkingFilePath);
    }

    @Test
    public void test_02b_joinProject() throws GitAPIException, IOException {
        clearRemoteRepository();

        Project project = projectService.join(URI.create(remoteRepositoryName), TESTPROJECTNAME, tempReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
        Assert.assertNull(project);
        Assert.assertFalse(tempReqifWorkingFilePath.toFile().exists());

        addProjectToRemoteRepository();

        project = projectService.join(URI.create(remoteRepositoryName), TESTPROJECTNAME, tempReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
        Assert.assertNotNull(project);
        Assert.assertTrue(tempReqifWorkingFilePath.toFile().exists());
        Assert.assertTrue(projectService.leave(project));

        deleteLocalRepository();
        Files.deleteIfExists(tempReqifWorkingFilePath);
    }

    @Test
    public void test_02c_exportProject() throws GitAPIException, IOException {
        //TODO: implement
        clearRemoteRepository();
        addProjectToRemoteRepository();

        Project project = projectService.join(URI.create(remoteRepositoryName), TESTPROJECTNAME, tempReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
        projectService.export(project, tempSysmlWorkingFilePath);
        projectService.export(project, tempXlsxWorkingFilePath);
        Assert.assertTrue(projectService.leave(project));

        Assert.assertTrue(FileUtils.contentEquals(
                tempReqifWorkingFilePath.toFile(),
                oneRequirementReqifWorkingFilePath.toFile()));

        Assert.assertTrue(FileUtils.contentEquals(
                tempSysmlWorkingFilePath.toFile(),
                oneRequirementSysmlWorkingFilePath.toFile()
        ));

        Assert.assertTrue(FileUtils.contentEquals(
                tempXlsxWorkingFilePath.toFile(),
                oneRequirementXlsxWorkingFilePath.toFile()
        ));

        Files.deleteIfExists(tempReqifWorkingFilePath);
        Files.deleteIfExists(tempSysmlWorkingFilePath);
        Files.deleteIfExists(tempXlsxWorkingFilePath);
        deleteLocalRepository();
    }

    @Test
    public void test_04a_synchronizeProject_localChanges() {
        //TODO: implement
        Assert.assertTrue(false);
    }

    @Test
    public void test_04b_synchronizeProject_remoteChanges() {
        //TODO: implement
        Assert.assertTrue(false);
    }

    @Test
    public void test_04c_synchronizeProject_local_and_remoteChanges_with_conflicts() {
        //TODO: implement
        Assert.assertTrue(false);
    }

    @Test
    public void test_04d_synchronizeProject_local_and_remoteChanges_without_conflicts() {
        //TODO: implement
        Assert.assertTrue(false);
    }

    @Test
    public void test_06_isPushNeeded() throws IOException, GitAPIException {
        //TODO: implement auf Project testen mit projecttService.refresh()
        clearRemoteRepository();

        Files.copy(oneRequirementReqifWorkingFilePath, tempReqifWorkingFilePath);

        Project testProject = projectService.create(URI.create(remoteRepositoryName), TESTPROJECTNAME, tempReqifWorkingFilePath, ReqExchangeFileType.ReqIF);

        projectService.refresh(testProject);
        Assert.assertFalse(testProject.isPushNeeded());

        modifyTempReqifWorkingFilePath();

        projectService.refresh(testProject);
        Assert.assertTrue(testProject.isPushNeeded());

        projectService.leave(testProject);
        Files.deleteIfExists(tempReqifWorkingFilePath);
    }

    @Test
    public void test_07_isPullNeeded() throws GitAPIException, IOException {
        //TODO: implement auf Project testen mit projecttService.refresh()
        clearRemoteRepository();

        addProjectToRemoteRepository();

        Project testProject = projectService.join(URI.create(remoteRepositoryName), TESTPROJECTNAME, tempReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
        projectService.refresh(testProject);
        Assert.assertFalse(testProject.isPullNeeded());

        modifyRemoteRepository();

        projectService.refresh(testProject);
        Assert.assertTrue(testProject.isPullNeeded());
        Assert.assertTrue(projectService.leave(testProject));

        deleteLocalRepository();
        Files.deleteIfExists(tempReqifWorkingFilePath);
    }

    private void clearRemoteRepository() throws GitAPIException, IOException {
        FileUtils.deleteDirectory(jGitPath.toFile());

        try (Git git = Git.cloneRepository()
                .setURI(remoteRepositoryName)
                .setDirectory(jGitPath.toFile())
                .call())
        {
            if (Files.deleteIfExists(jGitPath.resolve("data.cm"))) {
                git.rm().addFilepattern(".").call();
                git.commit().setAll(true).setMessage("DefaultProjectServiceTest.clearRemoteRepository()").call();
                git.push().setPushAll().setCredentialsProvider(testCredentialsProvider).call();
            }
        }

        FileUtils.deleteDirectory(jGitPath.toFile());
    }

    private void addProjectToRemoteRepository() throws GitAPIException, IOException {
        FileUtils.deleteDirectory(jGitPath.toFile());

        try (Git git = Git.cloneRepository().setURI(remoteRepositoryName).setDirectory(jGitPath.toFile()).call()) {
            modelTransformationService.transform(oneRequirementReqifWorkingFilePath, jGitCommonModelFilePath);
            git.add().addFilepattern(".").call();
            git.commit().setAll(true).setMessage("DefaultProjectServiceTest.addProjectToRemoteRepository()").call();
            git.push().setPushAll().setCredentialsProvider(testCredentialsProvider).call();
        }
    }

    private void modifyRemoteRepository() throws IOException, GitAPIException {
        Assert.assertTrue(tempReqifWorkingFilePath.toFile().exists());

        modifyTempReqifWorkingFilePath();

        try (Git git = Git.open(jGitPath.toFile())) {
            git.commit().setAll(true).setMessage("DefaultProjectServiceTest.modifyRemoteRepository()").call();
            git.push().setPushAll().setCredentialsProvider(testCredentialsProvider).call();
        }
    }

    private void cloneLocalRepository() throws GitAPIException {
        try (Git git = Git.cloneRepository()
                .setURI(remoteRepositoryName)
                .setDirectory(jGitPath.toFile())
                .call()) {
        }
    }

    private void deleteLocalRepository() throws IOException {
        FileUtils.deleteDirectory(jGitPath.toFile());
    }

    private void modifyTempReqifWorkingFilePath() throws IOException {
        //TODO: read reqif in object model, make some changes and save back
        Files.write(tempReqifWorkingFilePath, Files.readAllBytes(tempReqifWorkingFilePath));
    }

}

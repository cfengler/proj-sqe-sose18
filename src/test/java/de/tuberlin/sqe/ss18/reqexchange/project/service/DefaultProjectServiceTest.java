package de.tuberlin.sqe.ss18.reqexchange.project.service;

import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
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

    @BeforeClass
    public static void startUp() throws IOException {

    }

    @AfterClass
    public static void tearDown() throws IOException {
        FileUtils.deleteDirectory(UnitTestHelper.getTestPath().toFile());
    }

    @Before
    public void prepareTest() {

    }

    @After
    public void tearDownTest() throws IOException {
        for (Project project : UnitTestHelper.getProjectService().getAll()) {
            UnitTestHelper.getProjectService().leave(project);
        }

        Files.deleteIfExists(UnitTestHelper.getValidateReqifWorkingFilePath());

        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
        Files.deleteIfExists(UnitTestHelper.getTestSysmlWorkingFilePath());
        Files.deleteIfExists(UnitTestHelper.getTestXlsxWorkingFilePath());

        Files.deleteIfExists(UnitTestHelper.getExportReqifFilePath());
        Files.deleteIfExists(UnitTestHelper.getExportSysmlFilePath());
        Files.deleteIfExists(UnitTestHelper.getExportXlsxFilePath());

        UnitTestHelper.deleteLocalRepository();
    }

    @Test
    public void test_02a_createProject() throws GitAPIException, IOException {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Assert.assertTrue(UnitTestHelper.copyFiles(
                UnitTestHelper.getOneRequirementReqifWorkingFilePath(),
                UnitTestHelper.getTestReqifWorkingFilePath()
        ));

        Project testProject = UnitTestHelper.getProjectService().create(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Assert.assertNotNull(testProject);
        Assert.assertTrue(UnitTestHelper.getProjectService().leave(testProject));

        Assert.assertTrue(UnitTestHelper.cloneLocalRepository());

        Assert.assertTrue(UnitTestHelper.getJGitCommonModelFilePath().toFile().exists());
        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getJGitCommonModelFilePath().toFile(),
                UnitTestHelper.getOneRequirementReqifWorkingFilePath().toFile()));
    }

    @Test
    public void test_02b_joinProject() throws GitAPIException, IOException {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Project project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Assert.assertNull(project);
        Assert.assertFalse(UnitTestHelper.getTestReqifWorkingFilePath().toFile().exists());

        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Assert.assertNotNull(project);
        Assert.assertTrue(UnitTestHelper.getTestReqifWorkingFilePath().toFile().exists());
    }

    @Test
    public void test_03a_exportProject_reqIF() throws GitAPIException, IOException {
        //TODO: implement
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().export(project, UnitTestHelper.getExportReqifFilePath());

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getOneRequirementReqifWorkingFilePath().toFile(),
                UnitTestHelper.getExportReqifFilePath().toFile()));
    }


    @Test
    public void test_03b_exportProject_xlsx() throws IOException {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().export(project, UnitTestHelper.getExportXlsxFilePath());

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getOneRequirementXlsxWorkingFilePath().toFile(),
                UnitTestHelper.getExportXlsxFilePath().toFile()));
    }

    @Test
    public void test_03c_exportProject_sysml() throws IOException {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().export(project, UnitTestHelper.getExportSysmlFilePath());

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getOneRequirementSysmlWorkingFilePath().toFile(),
                UnitTestHelper.getExportSysmlFilePath().toFile()));
    }

    @Test
    public void test_02d_renameProject() throws IOException {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project testProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Path oldLocalGitRepositoryPath = testProject.getLocalGitRepositoryPath();
        Path oldProjectInfoFilePath = testProject.getProjectInfoFilePath();
        Path newLocalGitRepositoryPath = UnitTestHelper.getPathService().getLocalGitRepositoryPathByProjectName(UnitTestHelper.RENAMED_PROJECT_NAME);
        Path newProjectInfoFilePath = UnitTestHelper.getPathService().getProjectInfosPath().resolve(UnitTestHelper.RENAMED_PROJECT_NAME + ".json");

        Assert.assertTrue(oldLocalGitRepositoryPath.toFile().exists());
        Assert.assertTrue(oldProjectInfoFilePath.toFile().exists());
        Assert.assertFalse(newLocalGitRepositoryPath.toFile().exists());
        Assert.assertFalse(newProjectInfoFilePath.toFile().exists());

        Assert.assertTrue(UnitTestHelper.getProjectService().renameProject(testProject, UnitTestHelper.RENAMED_PROJECT_NAME));
        Assert.assertEquals(UnitTestHelper.RENAMED_PROJECT_NAME, testProject.getName());

        Assert.assertFalse(oldLocalGitRepositoryPath.toFile().exists());
        Assert.assertFalse(oldProjectInfoFilePath.toFile().exists());
        Assert.assertTrue(newLocalGitRepositoryPath.toFile().exists());
        Assert.assertTrue(newProjectInfoFilePath.toFile().exists());
    }

    @Test
    public void test_04a_synchronizeProject_localChanges() throws IOException {
        //TODO: debug
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Assert.assertTrue(UnitTestHelper.copyFiles(
                UnitTestHelper.getOneRequirementReqifWorkingFilePath(),
                UnitTestHelper.getTestReqifWorkingFilePath()
        ));

        Project testProject = UnitTestHelper.getProjectService().create(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Assert.assertTrue(UnitTestHelper.modifyReqifAddRequirement(UnitTestHelper.getTestReqifWorkingFilePath(), UnitTestHelper.NEW_REQUIREMENT_DESCRIPTION_1));

        UnitTestHelper.getProjectService().refresh(testProject);
        UnitTestHelper.getProjectService().synchronize(testProject);

        UnitTestHelper.cloneLocalRepository();
        //TODO: Model Vergleich fehlerhaft da gleiche Modelle unterschiedliche IDs bekommen
        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getTestReqifWorkingFilePath().toFile(),
                UnitTestHelper.getJGitCommonModelFilePath().toFile()));
    }

    @Test
    public void test_04b_synchronizeProject_remoteChanges() throws IOException {
        //TODO: debug
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project testProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Assert.assertTrue(UnitTestHelper.modifyRemoteRepository());

        UnitTestHelper.getProjectService().refresh(testProject);
        UnitTestHelper.getProjectService().synchronize(testProject);

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getTestReqifWorkingFilePath().toFile(),
                UnitTestHelper.getJGitCommonModelFilePath().toFile()));
    }

    @Test
    public void test_04c_synchronizeProject_local_and_remoteChanges_with_conflicts() {
        //TODO: debug
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project testProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Project validateProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.VALIDATE_PROJECT_NAME,
                UnitTestHelper.getValidateReqifWorkingFilePath());

        Assert.assertTrue(UnitTestHelper.modifyReqifFilesWithConflicts(
                UnitTestHelper.getTestReqifWorkingFilePath(),
                UnitTestHelper.getValidateReqifWorkingFilePath()));

        UnitTestHelper.getProjectService().refresh(testProject);
        UnitTestHelper.getProjectService().refresh(validateProject);

        Assert.assertTrue(UnitTestHelper.getProjectService().synchronize(testProject));
        Assert.assertTrue(UnitTestHelper.getProjectService().synchronize(validateProject));

        //TODO: compare result file with expected file
        Assert.assertTrue(false);
    }

    @Test
    public void test_04d_synchronizeProject_local_and_remoteChanges_without_conflicts() {
        //TODO: debug
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Assert.assertTrue(UnitTestHelper.copyFiles(
                UnitTestHelper.getOneRequirementReqifWorkingFilePath(),
                UnitTestHelper.getTestReqifWorkingFilePath()
        ));

        Project testProject = UnitTestHelper.getProjectService().create(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Project validateProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.VALIDATE_PROJECT_NAME,
                UnitTestHelper.getValidateReqifWorkingFilePath());

        Assert.assertTrue(UnitTestHelper.modifyReqifFilesWithoutConflicts(
                UnitTestHelper.getTestReqifWorkingFilePath(),
                UnitTestHelper.getValidateReqifWorkingFilePath()));

        UnitTestHelper.getProjectService().refresh(testProject);
        UnitTestHelper.getProjectService().refresh(validateProject);

        Assert.assertTrue(UnitTestHelper.getProjectService().synchronize(testProject));
        Assert.assertTrue(UnitTestHelper.getProjectService().synchronize(validateProject));

        //TODO: compare result file with expected file
        Assert.assertTrue(false);

        Assert.assertTrue(UnitTestHelper.getModelValidationService().validate(
                UnitTestHelper.getValidateReqifWorkingFilePath()));

        //TODO: need File to compare with
        Assert.assertTrue(false);
    }

    @Test
    public void test_06_isPushNeeded() {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Assert.assertTrue(UnitTestHelper.copyFiles(
                UnitTestHelper.getOneRequirementReqifWorkingFilePath(),
                UnitTestHelper.getTestReqifWorkingFilePath()
        ));

        Project testProject = UnitTestHelper.getProjectService().create(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertFalse(testProject.isPushNeeded());

        Assert.assertTrue(UnitTestHelper.modifyReqifAddRequirement(UnitTestHelper.getTestReqifWorkingFilePath(), UnitTestHelper.NEW_REQUIREMENT_DESCRIPTION_1));

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertTrue(testProject.isPushNeeded());
    }

    @Test
    public void test_07_isPullNeeded() {
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository(UnitTestHelper.getOneRequirementReqifWorkingFilePath()));

        Project testProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertFalse(testProject.isPullNeeded());

        Assert.assertTrue(UnitTestHelper.modifyRemoteRepository());

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertTrue(testProject.isPullNeeded());
    }
}

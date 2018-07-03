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
    public void tearDownTest() {
    }

    @Test
    public void test_02a_createProject_reqIF() throws GitAPIException, IOException {
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

        UnitTestHelper.deleteLocalRepository();
        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
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

        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository());

        project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        Assert.assertNotNull(project);
        Assert.assertTrue(UnitTestHelper.getTestReqifWorkingFilePath().toFile().exists());
        Assert.assertTrue(UnitTestHelper.getProjectService().leave(project));

        UnitTestHelper.deleteLocalRepository();
        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
    }

    @Test
    public void test_02c_exportProject() throws GitAPIException, IOException {
        //TODO: implement
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository());

        Project project = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().export(project, UnitTestHelper.getTestSysmlWorkingFilePath());
        UnitTestHelper.getProjectService().export(project, UnitTestHelper.getTestXlsxWorkingFilePath());
        Assert.assertTrue(UnitTestHelper.getProjectService().leave(project));

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getTestReqifWorkingFilePath().toFile(),
                UnitTestHelper.getOneRequirementReqifWorkingFilePath().toFile()));

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getTestSysmlWorkingFilePath().toFile(),
                UnitTestHelper.getOneRequirementSysmlWorkingFilePath().toFile()
        ));

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getTestXlsxWorkingFilePath().toFile(),
                UnitTestHelper.getOneRequirementXlsxWorkingFilePath().toFile()
        ));

        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
        Files.deleteIfExists(UnitTestHelper.getTestSysmlWorkingFilePath());
        Files.deleteIfExists(UnitTestHelper.getTestXlsxWorkingFilePath());
        UnitTestHelper.deleteLocalRepository();
    }

    @Test
    public void test_04a_synchronizeProject_localChanges() throws GitAPIException, IOException {
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

        Assert.assertTrue(UnitTestHelper.modifyReqifAddRequirement(UnitTestHelper.getTestReqifWorkingFilePath()));

        UnitTestHelper.getProjectService().refresh(testProject);
        UnitTestHelper.getProjectService().synchronize(testProject);

        UnitTestHelper.cloneLocalRepository();

        Assert.assertTrue(FileUtils.contentEquals(
                UnitTestHelper.getTestReqifWorkingFilePath().toFile(),
                UnitTestHelper.getJGitCommonModelFilePath().toFile()));

        UnitTestHelper.getProjectService().leave(testProject);

        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
        //TODO: wichtig?
        //Files.deleteIfExists(validateReqifWorkingFilePath);
        UnitTestHelper.deleteLocalRepository();
    }

    @Test
    public void test_04b_synchronizeProject_remoteChanges() throws GitAPIException, IOException {
        //TODO: debug
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository());

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

        Assert.assertTrue(UnitTestHelper.getProjectService().leave(testProject));

        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
        //TODO: wichtig?
        //Files.deleteIfExists(validateReqifWorkingFilePath);
        UnitTestHelper.deleteLocalRepository();
    }

    @Test
    public void test_04c_synchronizeProject_local_and_remoteChanges_with_conflicts() throws GitAPIException, IOException {
        //TODO: debug
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());
        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository());

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

        //TODO: compare result file witth expected file
        Assert.assertTrue(false);

        UnitTestHelper.getProjectService().leave(testProject);
        UnitTestHelper.getProjectService().leave(validateProject);
        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
        Files.deleteIfExists(UnitTestHelper.getValidateReqifWorkingFilePath());
    }

    @Test
    public void test_04d_synchronizeProject_local_and_remoteChanges_without_conflicts() throws IOException, GitAPIException {
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

        //TODO: compare result file witth expected file
        Assert.assertTrue(false);

        Assert.assertTrue(UnitTestHelper.getModelValidationService().validate(
                UnitTestHelper.getValidateReqifWorkingFilePath()));

        //TODO: need File to compare with
        Assert.assertTrue(false);

        UnitTestHelper.getProjectService().leave(testProject);
        UnitTestHelper.getProjectService().leave(validateProject);
        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
        Files.deleteIfExists(UnitTestHelper.getValidateReqifWorkingFilePath());
    }

    @Test
    public void test_06_isPushNeeded() throws IOException, GitAPIException {
        //TODO: implement auf Project testen mit projecttService.refresh()
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

        Assert.assertTrue(UnitTestHelper.modifyReqifAddRequirement(
                UnitTestHelper.getTestReqifWorkingFilePath()));

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertTrue(testProject.isPushNeeded());

        UnitTestHelper.getProjectService().leave(testProject);
        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
    }

    @Test
    public void test_07_isPullNeeded() throws GitAPIException, IOException {
        //TODO: implement auf Project testen mit projecttService.refresh()
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Assert.assertTrue(UnitTestHelper.addProjectToRemoteRepository());

        Project testProject = UnitTestHelper.getProjectService().join(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertFalse(testProject.isPullNeeded());

        //modifyRemoteRepository();
        Assert.assertTrue(UnitTestHelper.modifyRemoteRepository());

        UnitTestHelper.getProjectService().refresh(testProject);
        Assert.assertTrue(testProject.isPullNeeded());
        Assert.assertTrue(UnitTestHelper.getProjectService().leave(testProject));

        UnitTestHelper.deleteLocalRepository();
        Files.deleteIfExists(UnitTestHelper.getTestReqifWorkingFilePath());
    }

    //private void modifyRemoteRepository() throws IOException, GitAPIException {

    //}



    //private void deleteLocalRepository() throws IOException {
    //
    //}

//    private boolean modifyReqifAddRequirement(Path reqifFilePath) throws IOException {
//        //TODO: read reqif in object model, make some changes and save back
//        //TODO: have to change something :-)
//
//        return false;
//    }

//    private boolean modifyReqifWithConflicts(File firstReqifFile, File secondReqifFile) {
//
//        return false;
//    }

//    private boolean validateMergeWithConflicts(Path reqifFilePath) {
//        return modelValidationService.validate(reqifFilePath);
//    }

//    private boolean modifyReqifWithoutConflicts(File firstReqifFile, File secondReqifFile) {
//        //TODO: how to create conflicts?
//        return false;
//    }

    //TODO: need more functions for conflicts and other changes
}

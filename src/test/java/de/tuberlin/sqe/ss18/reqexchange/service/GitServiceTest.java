package de.tuberlin.sqe.ss18.reqexchange.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.service.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.TestPathService;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.nio.file.Files;
import java.nio.file.Path;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitServiceTest extends TestCase {

    private String repositoryName = "proj-sqe-sose18-unittest";
    private ProjectInfo projectInfo;
    private Path localGitRepositoryPath;

    private PathService pathService;
    private GitPropertiesService gitPropertiesService;
    private GitService gitService;

    public GitServiceTest() {
        init();


        pathService = new TestPathService();
        gitPropertiesService = new GitPropertiesService(pathService);

        gitService = new GitService(pathService, gitPropertiesService);
    }

    public void test_10_clone() {
        boolean cloneResult = gitService.clone(projectInfo);
        assertEquals(cloneResult, true);
        assertTrue(localGitRepositoryPath.toFile().exists());
        assertTrue(localGitRepositoryPath.resolve(".git").toFile().exists());
    }

    public void test_20_canPull() {
        boolean canPullResult = gitService.canPull(projectInfo);
        assertFalse(canPullResult);
    }

    public void test_30_pull() {
        //kann nur sehr schwer automatisch getestet werden
        assertTrue(true);
    }

//    public void test_41_canCommit_addFile() {
//        boolean canCommitResult = gitService.canCommit(projectInfo);
//        assertFalse(canCommitResult);
//
//        String newFileName = createNewFileInPath(
//                pathService.getProjectPath(testRepositoryName), "new File");
//
//        canCommitResult = gitService.canCommit(testRepositoryName);
//        assertTrue(canCommitResult);
//
//        removeFileInPath(
//                pathService.getProjectPath(testRepositoryName),
//                newFileName);
//
//        canCommitResult = gitService.canCommit(testRepositoryName);
//        assertFalse(canCommitResult);
//    }

//    public void test_42_canCommit_changeFile() {
//        boolean canCommitResult = gitService.canCommit(testRepositoryName);
//        assertFalse(canCommitResult);
//
//        String previousContent = getContentOfFileInPath(
//                pathService.getProjectPath(testRepositoryName),
//                "README.MD");
//
//        changeContentOfFileInPath(pathService.getProjectPath(testRepositoryName),
//                "README.MD");
//
//        canCommitResult = gitService.canCommit(testRepositoryName);
//        assertTrue(canCommitResult);
//
//        changeContentOfFileInPathToContent(
//                pathService.getProjectPath(testRepositoryName),
//                "README.MD",
//                previousContent);
//
//        canCommitResult = gitService.canCommit(testRepositoryName);
//        assertFalse(canCommitResult);
//    }

//    public void test_43_canCommit_removeFile() {
//        boolean canCommitResult = gitService.canCommit(testRepositoryName);
//        assertFalse(canCommitResult);
//
//        String previousContent = getContentOfFileInPath(
//                pathService.getProjectPath(testRepositoryName),
//                "README.MD");
//
//        removeFileInPath(pathService.getProjectPath(testRepositoryName),
//                "README.MD");
//
//        canCommitResult = gitService.canCommit(testRepositoryName);
//        assertTrue(canCommitResult);
//
//        gitService.checkout(testRepositoryName);
//
//        canCommitResult = gitService.canCommit(testRepositoryName);
//        assertFalse(canCommitResult);
//    }

    private void init() {
        projectInfo = new ProjectInfo();
        projectInfo.setName(repositoryName);
        projectInfo.setFileName("unittest-filename");

        localGitRepositoryPath = pathService.getLocalGitRepositoryPath(projectInfo);

        deletePreviousTestData();
    }
    private void deletePreviousTestData() {
        try {
            if (Files.exists(localGitRepositoryPath)) {
                FileUtils.deleteDirectory(localGitRepositoryPath.toFile());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

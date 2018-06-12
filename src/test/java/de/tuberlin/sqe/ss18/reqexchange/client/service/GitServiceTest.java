//package de.tuberlin.sqe.ss18.reqexchange.client.service;
//
//import de.tuberlin.sqe.ss18.reqexchange.common.service.GitPropertiesService;
//import de.tuberlin.sqe.ss18.reqexchange.common.service.GitService;
//import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
//import junit.framework.TestCase;
//import org.apache.commons.io.FileUtils;
//import org.joda.time.DateTime;
//import org.junit.FixMethodOrder;
//import org.junit.runners.MethodSorters;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class GitServiceTest extends TestCase {
//
//    private PathService pathService;
//    private GitPropertiesService gitPropertiesService;
//    private GitService gitService;
//
//    public GitServiceTest() {
//        pathService = new PathService();
//        gitPropertiesService = new GitPropertiesService(pathService);
//        gitService = new GitService(pathService, gitPropertiesService);
//
//        try {
//            if (Files.exists(pathService.getProjectPath(testRepositoryName))) {
//                FileUtils.deleteDirectory(pathService.getProjectPath(testRepositoryName).toFile());
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String testRepositoryName = "proj-sqe-sose18-test";
//
//    public void test_10_cloneRepository() {
//        boolean cloneResult = gitService.clone(testRepositoryName);
//        assertEquals(cloneResult, true);
//        assertTrue(pathService.getProjectPath(testRepositoryName).toFile().exists());
//        assertTrue(pathService.getProjectPath(testRepositoryName).resolve(".git").toFile().exists());
//    }
//
//    public void test_20_canPull() {
//        boolean canPullResult = gitService.canPull(testRepositoryName);
//        assertFalse(canPullResult);
//    }
//
//    public void test_30_pull() {
//        //kann nur sehr schwer automatisch getestet werden
//        assertTrue(true);
//    }
//
//    public void test_41_canCommit_addFile() {
//        boolean canCommitResult = gitService.canCommit(testRepositoryName);
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
//
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
//
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
//
//    public void test_50_push() {
//        boolean canPushResult = gitService.canPush(testRepositoryName);
//        assertFalse(canPushResult);
//
//        boolean pushResult = gitService.push(testRepositoryName);
//        assertFalse(pushResult);
//    }
//
//    public void test_60_commit() {
//        //TODO: implement
//        //gitService.canCommit();
//
//        boolean commitAllResult = gitService.commit(testRepositoryName);
//        assertTrue(commitAllResult);
//        //TODO: change file and commit true
//    }
//
//    public void test_70_push() {
//        boolean canPushResult = gitService.canPush(testRepositoryName);
//        assertTrue(canPushResult);
//
//        boolean pushResult = gitService.push(testRepositoryName);
//        assertTrue(pushResult);
//    }
//
//    //TODO: revert?
//
//    private String getContentOfFileInPath(Path repositoryPath, String fileName) {
//        String result = null;
//
//        try {
//            result = FileUtils.readFileToString(
//                    repositoryPath.resolve(fileName).toFile(),
//                    StandardCharsets.UTF_8);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    private void changeContentOfFileInPath(Path path, String fileName) {
//        String currentContent = getContentOfFileInPath(path, fileName);
//
//        changeContentOfFileInPathToContent(path, fileName, currentContent + " added content");
//    }
//
//    private void changeContentOfFileInPathToContent(Path path, String fileName, String newContent) {
//        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(
//                path.resolve(fileName))) {
//            bufferedWriter.write(newContent);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String createNewFileInPath(Path path, String content) {
//        String fileName = new DateTime().toString("YYYY_MM_dd_HH_mm_ss_SS") + ".txt";
//
//        while (Files.exists(path.resolve(fileName))) {
//            fileName = new DateTime().toString("YYYY_MM_dd_HH_mm_ss_SS") + ".txt";
//        }
//
//        createNewFileInPathWithName(path, fileName, content);
//
//        return fileName;
//    }
//
//    private void createNewFileInPathWithName(Path path, String fileName, String content) {
//        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path.resolve(fileName))) {
//            bufferedWriter.write(content);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void removeFileInPath(Path path, String fileName) {
//        if (Files.exists(path.resolve(fileName))) {
//            try {
//                Files.delete(path.resolve(fileName));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}

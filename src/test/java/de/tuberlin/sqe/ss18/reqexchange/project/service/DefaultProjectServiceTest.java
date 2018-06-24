package de.tuberlin.sqe.ss18.reqexchange.project.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeModule;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultProjectServiceTest {

    private static final String TESTPROJECTNAME = "proj-sqe-sose18-unittest";


    private static Injector injector;
    private static PathService pathService;
    private static  GitPropertiesService gitPropertiesService;
    private static GitService gitService;
    private static ProjectService projectService;

    private static CredentialsProvider testCredentialsProvider;

    private static Path testPath;
    private static Path testWorkingFilePathToCopy;
    private static Path testWorkingFilePath;
    private static File testWorkingFile;
    private static Path testLocalGitRepositoryPath;





    private static URI testURI;

    @BeforeClass
    public static void startUp() throws IOException {
        injector = Guice.createInjector(new ReqExchangeModule());

        pathService = injector.getInstance(PathService.class);
        gitPropertiesService = injector.getInstance(GitPropertiesService.class);
        gitService = injector.getInstance(GitService.class);
        projectService = injector.getInstance(ProjectService.class);

        testCredentialsProvider = new UsernamePasswordCredentialsProvider(
                gitPropertiesService.getUsername(),
                gitPropertiesService.getPassword());

        initTestVariables();
    }

    private static void initTestVariables() throws IOException {
        testPath = pathService.getPathOfRunningJar().resolve("test");
        testPath.toFile().createNewFile();

        testWorkingFilePathToCopy = pathService.getPathOfRunningJar().resolve("samplefiles").resolve("02_ReqIF_oneReq").resolve("My.reqif");
        testWorkingFilePath = testPath.resolve("testWorkingFile.reqif");
        testWorkingFile = testWorkingFilePath.toFile();
        testLocalGitRepositoryPath = testPath.resolve("testRepositories").resolve(TESTPROJECTNAME);

        testURI = URI.create("https://github.com/cfengler/" + TESTPROJECTNAME + ".git");
    }

    private static void copyTestWorkingFile() throws IOException {
        Files.copy(testWorkingFilePathToCopy, testWorkingFilePath);
    }

    @AfterClass
    public static void tearDown() {
        try {
            Files.deleteIfExists(testPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_02a_createProject() {
        //TODO: implement

        //remote repository leeren
        //create project!!! (Test-Datei)
        //lokal löschen
        //repository clonen
        //cm datei vergleichen
        //lokal löschen

        //projectService.create("proj-sqe-sose18-unittest", ???, )

        //projectService.create();
    }

    @Test
    public void test_02b_joinProject() {
        //TODO: implement
        //remote repository leeren
        //cm datei mit gitService pushen
        //lokal löschen
        //join project!!!
        //cm datei vergleichen
        //lokal löschen
    }

    @Test
    public void test_02c_exportProject() {
        //TODO: implement
        //cm datei
        //export
        //reqif test datei vergleich
        //sysml test datei vergleich
    }

    @Test
    public void test_04a_synchronizeProject_localChanges() {
        //TODO: implement
    }

    @Test
    public void test_04b_synchronizeProject_remoteChanges() {
        //TODO: implement
    }

    @Test
    public void test_04c_synchronizeProject_local_and_remoteChanges_with_conflicts() {
        //TODO: implement
    }

    @Test
    public void test_04d_synchronizeProject_local_and_remoteChanges_without_conflicts() {
        //TODO: implement
    }

    @Test
    public void test_06_isPushNeeded() throws IOException, GitAPIException {
        //TODO: implement auf Project testen mit projecttService.refresh()
        copyTestWorkingFile();
        clearRemoteRepository();

        Project testProject = projectService.create(TESTPROJECTNAME, testWorkingFilePath, ReqExchangeFileType.ReqIF);
        projectService.refresh(testProject);
        Assert.assertFalse(testProject.isPullNeeded());
        Assert.assertFalse(testProject.isPushNeeded());

        modifyTestWorkingFile();

        projectService.refresh(testProject);
        Assert.assertFalse(testProject.isPullNeeded());
        Assert.assertTrue(testProject.isPushNeeded());

        projectService.leave(testProject);
    }

    @Test
    public void test_07_isPullNeeded() throws GitAPIException, IOException {
        //TODO: implement auf Project testen mit projecttService.refresh()
        copyTestWorkingFile();
        clearRemoteRepository();

        //create project
        //join project with a second path
        //check join project that pull needed false
        //make changes to created project and push
        //check join project that pull needed true
        //leave both projects
    }

    private void clearRemoteRepository() throws GitAPIException {
        try (Git git = Git.cloneRepository()
                .setURI(testURI.toString())
                .setDirectory(testLocalGitRepositoryPath.toFile())
                .call())
        {
            git.rm().addFilepattern(".").call();
            git.commit().setAll(true).setMessage("Clear Repository caused by unit test").call();
            git.push().setPushAll().setCredentialsProvider(testCredentialsProvider).call();
        }
    }

    private void modifyTestWorkingFile() {
        //TODO: read reqif in object model, make some changes and save back
    }

}

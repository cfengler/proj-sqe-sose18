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

    private static Path resourcesPathToCopy;
    private static Path testPath;

    private static Path testReqifWorkingFilePath;
    private static File testReqifWorkingFile;
    private static Path testLocalGitRepositoryPath;
    private static Path testLocalGitRepositoryPath2;

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
        resourcesPathToCopy = pathService.getPathOfRunningJar().resolve("unitTest");
        testPath = pathService.getPathOfRunningJar().resolve("test");
        //TODO: also cm and uml files needed (for changing, comparision, ...)
        testReqifWorkingFilePath = testPath.resolve("testWorkingFile.reqif");
        testReqifWorkingFile = testReqifWorkingFilePath.toFile();

        testLocalGitRepositoryPath = testPath.resolve("repositories").resolve(TESTPROJECTNAME);
        testLocalGitRepositoryPath2 = testPath.resolve("repositories").resolve(TESTPROJECTNAME + "_2");
        //TODO: use common git settings instead of defined url
        testURI = URI.create("https://github.com/cfengler/" + TESTPROJECTNAME + ".git");
    }

    private static void copyResourcesTestPathToTestPath() throws IOException {
        Files.deleteIfExists(testPath);
        Files.copy(resourcesPathToCopy, testPath);
    }

    @AfterClass
    public static void tearDown() {
        try {
            Files.deleteIfExists(testPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void prepareTest() throws IOException {
        copyResourcesTestPathToTestPath();
    }

    @After
    public void tearDownTest() throws IOException {
        Files.deleteIfExists(testPath);
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
        clearRemoteRepository();

        Project testProject = projectService.create(TESTPROJECTNAME, testReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
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
        clearRemoteRepository();

        createProjectWithJGit();
        Project testProject = projectService.join(TESTPROJECTNAME, testReqifWorkingFilePath, ReqExchangeFileType.ReqIF);
        projectService.refresh(testProject);
        Assert.assertFalse(testProject.isPullNeeded());

        //TODO: implement
        changeProjectWithJGit();

        projectService.refresh(testProject);
        Assert.assertTrue(testProject.isPullNeeded());

        projectService.leave(testProject);
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

    private void createProjectWithJGit() throws GitAPIException {
        try (Git git = Git.cloneRepository()
                .setURI(testURI.toString())
                .setDirectory(testLocalGitRepositoryPath2.toFile())
                .call()) {
            //TODO: copy data.cm file in repository (need cm file)
            //git.add().addFilepattern(".").call();
            //git.commit().setAll(true).setMessage("Initial Commit of data.cm for unit test").call();
            //git.push().setPushAll().setCredentialsProvider(testCredentialsProvider).call();
        }
    }

    private void changeProjectWithJGit() throws IOException, GitAPIException {
        //TODO: change on data.cm
        try (Git git = Git.open(testLocalGitRepositoryPath2.toFile()))
        {
            git.commit().setAll(true).setMessage("Change Commit on data.cm for unit test").call();
            git.push().setPushAll().setCredentialsProvider(testCredentialsProvider).call();
        }
    }

    private void modifyTestWorkingFile() {
        //TODO: read reqif in object model, make some changes and save back
    }

}

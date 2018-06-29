package de.tuberlin.sqe.ss18.reqexchange.git.service;

import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.TestPathService;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultGitPropertiesServiceTest {

    private static PathService pathService;
    private static GitPropertiesService gitPropertiesService;

    @BeforeClass
    public static void startUp() {
        pathService = new TestPathService();
        gitPropertiesService = new DefaultGitPropertiesService(pathService);
    }
    @AfterClass
    public static void tearDown() {

    }

    @Before
    public void prepareTest() {

    }

    @After
    public void tearDownTest() {
    }

    @Test
    public void test_01_loadSettings() {
        Assert.assertNotNull(gitPropertiesService.getUsername());
        Assert.assertNotSame(gitPropertiesService.getUsername().length(), 0);

        Assert.assertNotNull(gitPropertiesService.getPassword());
        Assert.assertNotSame(gitPropertiesService.getPassword().length(), 0);
    }

    @Test
    public void test_02_saveSettings() {
        String newUsername = "newUser";
        String newPassword = "newPassword";

        gitPropertiesService.setUsername(newUsername);
        Assert.assertEquals(newUsername, gitPropertiesService.getUsername());
        gitPropertiesService.setPassword(newPassword);
        Assert.assertEquals(newPassword, gitPropertiesService.getPassword());
        gitPropertiesService.save();

        GitPropertiesService newGitPropertiesService = new DefaultGitPropertiesService(pathService);
        Assert.assertEquals(newUsername, newGitPropertiesService.getUsername());
        Assert.assertEquals(newPassword, newGitPropertiesService.getPassword());
    }

}

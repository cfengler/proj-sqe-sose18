package de.tuberlin.sqe.ss18.reqexchange.common;

import org.apache.commons.io.FileUtils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPathService implements PathService {

    private Path pathOfRunningJar;
    public Path getPathOfRunningJar() {
        return pathOfRunningJar;
    }

    private Path projectInfosPath;
    public Path getProjectInfosPath() {
        return projectInfosPath;
    }

    private Path projectRepositoriesPath;
    public Path getProjectRepositoriesPath() {
        return projectRepositoriesPath;
    }

    private Path settingsPath;
    public Path getSettingsPath() { return settingsPath; }

    public TestPathService() {
        try {
            pathOfRunningJar = Paths.get(DefaultPathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        projectInfosPath = getPathOfRunningJar().resolve("test").resolve("projectInfos");
        projectRepositoriesPath = getPathOfRunningJar().resolve("test").resolve("projectRepositories");
        settingsPath = getPathOfRunningJar().resolve("test").resolve("settings");

        createPaths();
        copyTestData();
    }

    public Path getLocalGitRepositoryPathByProjectName(String projectName) {
        return getProjectRepositoriesPath().resolve(projectName);
    }

    private void createPaths() {
        projectInfosPath.toFile().mkdirs();
        projectRepositoriesPath.toFile().mkdirs();
        settingsPath.toFile().mkdirs();
    }

    private void copyTestData() {
        try {
            FileUtils.copyDirectory(getPathOfRunningJar().resolve("settings").toFile(), settingsPath.toFile());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package de.tuberlin.sqe.ss18.reqexchange.common;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DefaultPathService implements PathService {

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
    public Path getSettingsPath() {
        return settingsPath;
    }

    public DefaultPathService() {
        try {
            pathOfRunningJar = Paths.get(DefaultPathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        projectInfosPath = getPathOfRunningJar().resolve("projectInfos");
        projectRepositoriesPath = getPathOfRunningJar().resolve("projectRepositories");
        settingsPath = getPathOfRunningJar().resolve("settings");

        createPaths();
    }

    public Path getLocalGitRepositoryPathByProjectName(String projectName) {
        return getProjectRepositoriesPath().resolve(projectName);
    }

    private void createPaths() {
        projectInfosPath.toFile().mkdirs();
        projectRepositoriesPath.toFile().mkdirs();
    }
}

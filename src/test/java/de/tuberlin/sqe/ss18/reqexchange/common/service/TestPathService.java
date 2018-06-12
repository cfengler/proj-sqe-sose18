package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;

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

    public TestPathService() {
        try {
            pathOfRunningJar = Paths.get(DefaultPathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        projectInfosPath = getPathOfRunningJar().resolve("test.projectInfos");
        projectRepositoriesPath = getPathOfRunningJar().resolve("test.projectRepositories");

        createPaths();
    }

    public Path getLocalGitRepositoryPath(ProjectInfo projectInfo) {
        return getProjectRepositoriesPath().resolve(projectInfo.getName());
    }

    private void createPaths() {
        projectInfosPath.toFile().mkdir();
        projectRepositoriesPath.toFile().mkdir();
    }
}

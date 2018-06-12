package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PathService {

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

    public PathService() {
        try {
            pathOfRunningJar = Paths.get(PathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        projectInfosPath = getPathOfRunningJar().resolve("projectInfos");
        projectRepositoriesPath = getPathOfRunningJar().resolve("projectRepositories");

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

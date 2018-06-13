package de.tuberlin.sqe.ss18.reqexchange.common.service;

import java.nio.file.Path;

public interface PathService {
    Path getPathOfRunningJar();
    Path getProjectInfosPath();
    Path getProjectRepositoriesPath();
    Path getLocalGitRepositoryPathByProjectName(String projectName);
}

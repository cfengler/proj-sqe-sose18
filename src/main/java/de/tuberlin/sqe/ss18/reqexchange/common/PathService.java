package de.tuberlin.sqe.ss18.reqexchange.common;

import java.nio.file.Path;

public interface PathService {

    Path getPathOfRunningJar();
    Path getSettingsPath();
    Path getProjectInfosPath();
    Path getProjectRepositoriesPath();
    Path getLocalGitRepositoryPathByProjectName(String projectName);
}

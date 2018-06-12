package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;

import java.nio.file.Path;

public interface PathService {
    Path getPathOfRunningJar();
    Path getProjectInfosPath();
    Path getProjectRepositoriesPath();
    Path getLocalGitRepositoryPath(ProjectInfo projectInfo);
}

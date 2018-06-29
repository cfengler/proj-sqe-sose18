package de.tuberlin.sqe.ss18.reqexchange.project.service;

import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;

public interface ProjectService {

    List<Project> getAll();

    Project create(URI remoteGitRepositoryURI, String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType);
    Project create(String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType);
    Project join(URI remoteGitRepositoryURI, String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType);
    Project join(String name, Path workingFilePath, ReqExchangeFileType reqExchangeFileType);
    boolean leave(Project project);

    void refresh(Project project);

    boolean synchronize(Project project);


    boolean export(Project project, Path pathToExport);

}

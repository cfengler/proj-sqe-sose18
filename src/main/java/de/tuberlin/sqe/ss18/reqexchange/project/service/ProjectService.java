package de.tuberlin.sqe.ss18.reqexchange.project.service;

import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;

import java.nio.file.Path;
import java.util.List;

public interface ProjectService {

    List<Project> getAll();

    Project create(String name, Path filePath, ReqExchangeFileType reqExchangeFileType);
    Project join(String name, Path filePath, ReqExchangeFileType reqExchangeFileType);
    boolean leave(Project project);

    void refresh(Project project);

    boolean synchronize(Project project);


    boolean export(Project project, Path pathToExport);

}

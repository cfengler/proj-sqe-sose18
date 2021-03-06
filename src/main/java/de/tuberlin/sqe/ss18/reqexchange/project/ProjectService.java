package de.tuberlin.sqe.ss18.reqexchange.project;

import de.tuberlin.sqe.ss18.reqexchange.project.Project;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;

public interface ProjectService {

    List<Project> getAll();

    Project create(URI remoteGitRepositoryURI, String name, Path workingFilePath);
    Project join(URI remoteGitRepositoryURI, String name, Path workingFilePath);
    boolean renameProject(Project project, String newName);
    boolean leave(Project project);

    void refresh(Project project);
    boolean synchronize(Project project);

    boolean export(Project project, Path pathToExport);

}

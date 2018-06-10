package de.tuberlin.sqe.ss18.reqexchange.client.service;

import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ClientPathService extends PathService {

    private Path clientPath;
    public Path getClientPath() {
        return clientPath;
    }

    private Path projectsPath;
    public Path getProjectsPath() {
        return projectsPath;
    }

    public ClientPathService() {
        super();

        clientPath = getPathOfRunningJar().resolve("client");
        projectsPath = clientPath.resolve("projects");

        createPaths();
    }

    private void createPaths() {
        new File(clientPath.toString()).mkdir();
        new File(projectsPath.toString()).mkdir();
    }

}

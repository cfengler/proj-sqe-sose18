package de.tuberlin.sqe.ss18.reqexchange.client.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Component
public class ClientPathService {

    private Path pathOfRunningJar;
    public Path getPathOfRunningJar() {
        return pathOfRunningJar;
    }

    private Path clientPath;
    public Path getClientPath() {
        return clientPath;
    }

    private Path projectsPath;
    public Path getProjectsPath() {
        return projectsPath;
    }

    public ClientPathService() {
        try {
            pathOfRunningJar = Paths.get(ClientPathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        clientPath = pathOfRunningJar.resolve("client");
        projectsPath = clientPath.resolve("projects");

        new File(clientPath.toString()).mkdir();
        new File(projectsPath.toString()).mkdir();
    }

}

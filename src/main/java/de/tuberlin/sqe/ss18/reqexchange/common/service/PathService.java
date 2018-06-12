package de.tuberlin.sqe.ss18.reqexchange.common.service;

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

    private Path clientPath;
    public Path getClientPath() {
        return clientPath;
    }

    private Path projectsPath;
    public Path getProjectsPath() {
        return projectsPath;
    }

    public PathService() {
        try {
            pathOfRunningJar = Paths.get(PathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        clientPath = getPathOfRunningJar().resolve("client");
        projectsPath = clientPath.resolve("projects");

        createPaths();
    }

    private void createPaths() {
        new File(clientPath.toString()).mkdir();
        new File(projectsPath.toString()).mkdir();
    }

    public Path getProjectPath(String name) {
        return projectsPath.resolve(name);
    }
}

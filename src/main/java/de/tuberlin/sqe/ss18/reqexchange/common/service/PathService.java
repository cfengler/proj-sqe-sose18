package de.tuberlin.sqe.ss18.reqexchange.common.service;

import de.tuberlin.sqe.ss18.reqexchange.client.service.ClientPathService;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class PathService {

    private Path pathOfRunningJar;
    public Path getPathOfRunningJar() {
        return pathOfRunningJar;
    }

    public PathService() {
        try {
            pathOfRunningJar = Paths.get(ClientPathService.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

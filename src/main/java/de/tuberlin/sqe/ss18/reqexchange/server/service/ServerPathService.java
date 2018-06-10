package de.tuberlin.sqe.ss18.reqexchange.server.service;

import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;

@Component
public class ServerPathService extends PathService {

    private Path serverPath;
    public Path getServerPath() {
        return serverPath;
    }
    public void setServerPath(Path serverPath) {
        this.serverPath = serverPath;
    }

    private Path repositoriesPath;
    public Path getRepositoriesPath() {
        return repositoriesPath;
    }
    public void setRepositoriesPath(Path repositoriesPath) {
        this.repositoriesPath = repositoriesPath;
    }

    public ServerPathService() {
        super();

        setServerPath(getPathOfRunningJar().resolve("server"));
        setRepositoriesPath(getServerPath().resolve("repositories"));

        createPaths();
    }

    private void createPaths() {
        new File(getServerPath().toString()).mkdir();
        new File(getRepositoriesPath().toString()).mkdir();
    }
}

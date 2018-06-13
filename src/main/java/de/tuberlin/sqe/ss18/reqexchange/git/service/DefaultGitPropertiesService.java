package de.tuberlin.sqe.ss18.reqexchange.git.service;


import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;

import java.nio.file.Files;
import java.util.Properties;

public class DefaultGitPropertiesService extends Properties implements GitPropertiesService {

    private PathService pathService;

    private String username;
    public String getUsername() {
        return username;
    }

    private String password;
    public String getPassword() {
        return password;
    }

    @Inject
    public DefaultGitPropertiesService(PathService pathService) {
        this.pathService = pathService;
        try {
            load(Files.newInputStream(pathService.getPathOfRunningJar().resolve("git.properties")));

            init();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        username = getProperty("git.username");
        password = getProperty("git.password");
    }
}

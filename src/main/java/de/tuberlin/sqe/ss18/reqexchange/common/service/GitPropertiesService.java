package de.tuberlin.sqe.ss18.reqexchange.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.util.Properties;

@Component
public class GitPropertiesService extends Properties {

    private PathService pathService;

    private String username;
    public String getUsername() {
        return username;
    }

    private String password;
    public String getPassword() {
        return password;
    }

    @Autowired
    public GitPropertiesService(PathService pathService) {
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

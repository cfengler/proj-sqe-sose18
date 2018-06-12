package de.tuberlin.sqe.ss18.reqexchange.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.util.Properties;

@Component
public class GitPropertiesService extends Properties {

    private ClientPathService clientPathService;

    private String username;
    public String getUsername() {
        return username;
    }

    private String password;
    public String getPassword() {
        return password;
    }

    @Autowired
    public GitPropertiesService(ClientPathService clientPathService) {
        this.clientPathService = clientPathService;
        try {
            load(Files.newInputStream(clientPathService.getPathOfRunningJar().resolve("git.properties")));

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

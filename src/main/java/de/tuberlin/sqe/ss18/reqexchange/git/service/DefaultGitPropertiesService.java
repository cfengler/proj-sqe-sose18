package de.tuberlin.sqe.ss18.reqexchange.git.service;


import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DefaultGitPropertiesService extends Properties implements GitPropertiesService {

    private PathService pathService;

    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String newValue) { username = newValue; }

    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String newValue) { password = newValue; }

    private Path gitPropertiesFilePath;

    @Inject
    public DefaultGitPropertiesService(PathService pathService) {
        this.pathService = pathService;

        gitPropertiesFilePath = pathService.getSettingsPath()
                .resolve("settings/git.properties");

        try (InputStream inputStream = Files.newInputStream(gitPropertiesFilePath)) {
            load(inputStream);
            init();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        setUsername(getProperty("git.username"));
        setPassword(getProperty("git.password"));
    }


    public void save() {
        setProperty("git.username", getUsername());
        setProperty("git.password", getPassword());

        try (OutputStream outputStream = Files.newOutputStream(gitPropertiesFilePath)) {
            this.store(outputStream, "");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

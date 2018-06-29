package de.tuberlin.sqe.ss18.reqexchange.git.service;

public interface GitPropertiesService {
    String getUsername();
    void setUsername(String newValue);
    String getPassword();
    void setPassword(String newValue);

    void save();
}

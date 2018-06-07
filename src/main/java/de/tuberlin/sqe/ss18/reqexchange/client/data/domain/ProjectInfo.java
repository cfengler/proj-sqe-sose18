package de.tuberlin.sqe.ss18.reqexchange.client.data.domain;

import org.joda.time.DateTime;

public class ProjectInfo {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String filename;
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    private DateTime pullTimestamp;
    public DateTime getPullTimestamp() {
        return pullTimestamp;
    }
    public void setPullTimestamp(DateTime pullTimestamp) {
        this.pullTimestamp = pullTimestamp;
    }
}

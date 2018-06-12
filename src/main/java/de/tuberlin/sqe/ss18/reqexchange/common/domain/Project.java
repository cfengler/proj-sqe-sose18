package de.tuberlin.sqe.ss18.reqexchange.common.domain;

import org.joda.time.DateTime;

public class Project {

    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //TODO: welche Properties sind hier notwendig? implementieren!
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

    private DateTime pushTimestamp;
    public DateTime getPushTimestamp() {
        return pushTimestamp;
    }
    public void setPushTimestamp(DateTime pushTimestamp) {
        this.pushTimestamp = pushTimestamp;
    }
}

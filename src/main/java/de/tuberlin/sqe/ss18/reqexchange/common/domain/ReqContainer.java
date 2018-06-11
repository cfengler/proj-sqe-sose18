package de.tuberlin.sqe.ss18.reqexchange.common.domain;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReqContainer {

    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private DateTime pushTimestamp;
    public DateTime getPushTimestamp() {
        return pushTimestamp;
    }
    public void setPushTimestamp(DateTime pushTimestamp) {
        this.pushTimestamp = pushTimestamp;
    }
}

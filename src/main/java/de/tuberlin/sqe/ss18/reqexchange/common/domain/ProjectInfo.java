package de.tuberlin.sqe.ss18.reqexchange.common.domain;

public class ProjectInfo {

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String newValue) {
        this.name = newValue;
    }

    private String fileName;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String newValue) {
        this.fileName = newValue;
    }

    private transient boolean localChanged;
    public boolean isLocalChanged() {
        return localChanged;
    }
    public void setLocalChanged(boolean newValue) {
        this.localChanged = newValue;
    }

    private transient boolean remoteChanged;
    public boolean isRemoteChanged() {
        return remoteChanged;
    }
    public void setRemoteChanged(boolean newValue) {
        this.remoteChanged = newValue;
    }

}

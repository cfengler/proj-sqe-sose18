package de.tuberlin.sqe.ss18.reqexchange.project.domain;

public class ProjectInfo {

    private String remoteGitRepositoryName;
    public String getRemoteGitRepositoryName() {
        return remoteGitRepositoryName;
    }
    public void setRemoteGitRepositoryName(String newValue) {
        this.remoteGitRepositoryName = newValue;
    }

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

    private boolean pullNeeded;
    public boolean isPullNeeded() {
        return pullNeeded;
    }
    public void setPullNeeded(boolean pullNeeded) {
        this.pullNeeded = pullNeeded;
    }
}

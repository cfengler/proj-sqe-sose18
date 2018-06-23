package de.tuberlin.sqe.ss18.reqexchange.project.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.nio.file.Path;

public class Project {

    private PropertyChangeSupport propertyChangeSupport;
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String newValue) {
        this.name = newValue;
    }

    private Path workingModelFilePath;
    public Path getWorkingModelFilePath() {
        return workingModelFilePath;
    }
    public void setWorkingModelFilePath(Path newValue) {
        this.workingModelFilePath = newValue;
    }

    private Path commonModelFilePath;
    public Path getCommonModelFilePath() { return commonModelFilePath; }
    public void setCommonModelFilePath(Path newValue) { this.commonModelFilePath = newValue; }

    private Path localGitRepositoryPath;
    public Path getLocalGitRepositoryPath() {
        return localGitRepositoryPath;
    }
    public void setLocalGitRepositoryPath(Path newValue) {
        this.localGitRepositoryPath = newValue;
    }

    private Path projectInfoFilePath;
    public Path getProjectInfoFilePath() {
        return projectInfoFilePath;
    }
    public void setProjectInfoFilePath(Path newValue) {
        this.projectInfoFilePath = newValue;
    }

    private boolean pushNeeded;
    public boolean isPushNeeded() {
        return pushNeeded;
    }
    public void setPushNeeded(boolean newValue) {
        if (pushNeeded != newValue) {
            boolean oldValue = pushNeeded;
            pushNeeded = newValue;
            propertyChangeSupport.firePropertyChange("pushNeeded", oldValue, newValue);
        }
    }

    private boolean pullNeeded;
    public boolean isPullNeeded() {
        return pullNeeded;
    }
    public void setPullNeeded(boolean newValue) {
        if (pullNeeded != newValue) {
            boolean oldValue = pullNeeded;
            pullNeeded = newValue;
            propertyChangeSupport.firePropertyChange("pullNeeded", oldValue, newValue);
        }
    }

    public Project() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

}

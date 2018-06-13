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

    private Path filePath;
    public Path getFilePath() {
        return filePath;
    }
    public void setFilePath(Path newValue) {
        this.filePath = newValue;
    }

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

    private boolean localChanged;
    public boolean isLocalChanged() {
        return localChanged;
    }
    public void setLocalChanged(boolean newValue) {
        if (localChanged != newValue) {
            boolean oldValue = localChanged;
            localChanged = newValue;
            propertyChangeSupport.firePropertyChange("localChanged", oldValue, newValue);
        }
    }

    private boolean remoteChanged;
    public boolean isRemoteChanged() {
        return remoteChanged;
    }
    public void setRemoteChanged(boolean newValue) {
        if (remoteChanged != newValue) {
            boolean oldValue = remoteChanged;
            remoteChanged = newValue;
            propertyChangeSupport.firePropertyChange("remoteChanged", oldValue, newValue);
        }
    }

    public Project() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

}

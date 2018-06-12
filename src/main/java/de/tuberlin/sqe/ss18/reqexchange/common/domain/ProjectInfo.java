package de.tuberlin.sqe.ss18.reqexchange.common.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProjectInfo {

    private transient PropertyChangeSupport propertyChangeSupport;
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public ProjectInfo() {
        propertyChangeSupport = new PropertyChangeSupport(this);
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

    private transient boolean localChanged;
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

    private transient boolean remoteChanged;
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

}

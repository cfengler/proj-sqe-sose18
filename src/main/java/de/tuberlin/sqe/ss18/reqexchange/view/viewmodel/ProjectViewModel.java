package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProjectViewModel {
    //TODO: namen aus dem model übernehmen, nicht local changed und serverchanged
    private SimpleStringProperty name;
    private SimpleBooleanProperty localChanged;
    private SimpleBooleanProperty serverChanged;

    public ProjectViewModel() {
        this(null, false, false);
    }

    public ProjectViewModel(String name) {
        this(name, false, false);
    }

    public ProjectViewModel(String name, boolean localChanged, boolean serverChanged) {
        this.name = new SimpleStringProperty(name);
        this.localChanged = new SimpleBooleanProperty(localChanged);
        this.serverChanged = new SimpleBooleanProperty(serverChanged);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public boolean isLocalChanged() {
        return localChanged.get();
    }

    public SimpleBooleanProperty localChangedProperty() {
        return localChanged;
    }

    public void setLocalChanged(boolean localChanged) {
        this.localChanged.set(localChanged);
    }

    public boolean isServerChanged() {
        return serverChanged.get();
    }

    public SimpleBooleanProperty serverChangedProperty() {
        return serverChanged;
    }

    public void setServerChanged(boolean serverChanged) {
        this.serverChanged.set(serverChanged);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectViewModel that = (ProjectViewModel) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }
}
package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.project.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.project.Project;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProjectViewModel {

    private StringProperty name;
    private ReqExchangeFileType fileType;
    private Project project;
    private BooleanProperty canPull;
    private BooleanProperty canPush;

    public ProjectViewModel(Project project) {
        this.name = new SimpleStringProperty(project.getName());
        this.fileType = ReqExchangeFileType.getFileTypeFromFileName(project.getWorkingModelFilePath().toString());
        this.canPull = new SimpleBooleanProperty(project.isPullNeeded());
        this.canPush = new SimpleBooleanProperty(project.isPushNeeded());
        this.project = project;

        project.addPropertyChangeListener(e -> {
            switch (e.getPropertyName()) {
                case "pushNeeded":
                    setCanPush((Boolean)e.getNewValue());
                    break;
                case "pullNeeded":
                    setCanPull((Boolean)e.getNewValue());
                    break;
                case "name":
                    setName(String.valueOf(e.getNewValue()));
                    break;
                default:
                    break;
            }
        });
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ReqExchangeFileType getFileType() {
        return fileType;
    }

    public void setFileType(ReqExchangeFileType fileType) {
        this.fileType = fileType;
    }

    public boolean isCanPull() {
        return canPull.get();
    }

    public BooleanProperty canPullProperty() {
        return canPull;
    }

    public void setCanPull(boolean canPull) {
        this.canPull.set(canPull);
    }

    public boolean isCanPush() {
        return canPush.get();
    }

    public BooleanProperty canPushProperty() {
        return canPush;
    }

    public void setCanPush(boolean canPush) {
        this.canPush.set(canPush);
    }

    public Project getProject() {
        return project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectViewModel that = (ProjectViewModel) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }
}
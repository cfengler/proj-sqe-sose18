package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProjectInfoViewModel {

    private StringProperty name;
    private ReqExchangeFileType fileType;
    private ProjectInfo projectInfo;
    private BooleanProperty canPull;
    private BooleanProperty canPush;

    public ProjectInfoViewModel() {
        this(null, null, false, false, new ProjectInfo());
    }

    public ProjectInfoViewModel(String name) {
        this(name, null, false, false, new ProjectInfo());
    }

    public ProjectInfoViewModel(String name, ReqExchangeFileType fileType, boolean canPull, boolean canPush, ProjectInfo projectInfo) {
        this.name = new SimpleStringProperty(name);
        this.fileType = fileType;
        this.canPull = new SimpleBooleanProperty(canPull);
        this.canPush = new SimpleBooleanProperty(canPush);
        this.projectInfo = projectInfo;
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

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectInfoViewModel that = (ProjectInfoViewModel) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }
}
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

    public ProjectInfoViewModel(ProjectInfo projectInfo) {
        this.name = new SimpleStringProperty(projectInfo.getName());
        this.fileType = ReqExchangeFileType.getFileTypeFromFileName(projectInfo.getFileName());
        this.canPull = new SimpleBooleanProperty(projectInfo.isRemoteChanged());
        this.canPush = new SimpleBooleanProperty(projectInfo.isLocalChanged());
        this.projectInfo = projectInfo;

        projectInfo.addPropertyChangeListener(e -> {
            switch (e.getPropertyName()) {
                case "name":
                    setName(String.valueOf(e.getNewValue()));
                    break;
                case "fileName":
                    fileType = ReqExchangeFileType.getFileTypeFromFileName(String.valueOf(e.getNewValue()));
                    break;
                case "localChanged":
                    setCanPush((Boolean)e.getNewValue());
                    break;
                case "remoteChanged":
                    setCanPull((Boolean)e.getNewValue());
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

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectInfoViewModel that = (ProjectInfoViewModel) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }
}
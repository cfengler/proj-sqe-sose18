package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProjectInfoViewModel {

    private SimpleStringProperty name;
    private ReqExchangeFileType fileType;
    private ProjectInfo projectInfo;
    private SimpleBooleanProperty localChanged;

    public ProjectInfoViewModel() {
        this(null, null, false, new ProjectInfo());
    }

    public ProjectInfoViewModel(String name) {
        this(name, null, false, new ProjectInfo());
    }

    public ProjectInfoViewModel(String name, ReqExchangeFileType fileType, boolean localChanged, ProjectInfo projectInfo) {
        this.name = new SimpleStringProperty(name);
        this.fileType = fileType;
        this.localChanged = new SimpleBooleanProperty(localChanged);
        this.projectInfo = projectInfo;
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

    public ReqExchangeFileType getFileType() {
        return fileType;
    }

    public void setFileType(ReqExchangeFileType fileType) {
        this.fileType = fileType;
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
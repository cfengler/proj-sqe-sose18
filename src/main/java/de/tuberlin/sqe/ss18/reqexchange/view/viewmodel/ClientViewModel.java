package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.service.ProjectService;
import io.reactivex.Observable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ClientViewModel {

    private ProjectService projectService;

    private SimpleListProperty<ProjectViewModel> projects;
    private BooleanProperty busy;

    @Inject
    public ClientViewModel(ProjectService projectService) {
        this.projectService = projectService;

        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());
        busy = new SimpleBooleanProperty(false);

        this.projectService.getAll().forEach(this::addProjectFromProjectInfo);

        Observable.interval(10, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(i -> {
            projects.forEach(projectViewModel -> projectService.refresh(projectViewModel.getProject()));
        });
    }

    private void addProjectFromProjectInfo(Project project) {
        ProjectViewModel viewModel = new ProjectViewModel(project);
        ReqExchangeFileType determinedFileType  = ReqExchangeFileType.getFileTypeFromFileName(project.getFilePath().toString());
        viewModel.setFileType(determinedFileType == null ? ReqExchangeFileType.ReqIF : determinedFileType);
        projects.add(viewModel);
    }

    public void handleCreateProject(String name, String password, String filepath) {
        busy.set(true);

        Observable.just(1)
            .subscribeOn(Schedulers.newThread())
            .map(i -> projectService.create(name, Paths.get(filepath), ReqExchangeFileType.getFileTypeFromFileName(filepath)))
            .observeOn(JavaFxScheduler.platform())
            .subscribe(projectInfo -> {
                if(projectInfo != null) {
                    addProjectFromProjectInfo(projectInfo);
                }
                busy.set(false);
            });
    }

    public void handleJoinProject(String name, String password, ReqExchangeFileType filetype, String filepath) {
        busy.set(true);
        Observable.just(1)
                .subscribeOn(Schedulers.newThread())
                .map(i -> projectService.join(name, Paths.get(filepath), filetype))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(projectInfo -> {
                    if(projectInfo != null) {
                        addProjectFromProjectInfo(projectInfo);
                    }
                    busy.set(false);
                });
    }

    public void handleLeaveProject(ProjectViewModel projectViewModel) {
        busy.set(true);
        Observable.just(1)
                .subscribeOn(Schedulers.newThread())
                .map(i -> projectService.leave(projectViewModel.getProject()))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(left -> {
                    if(left) {
                        projects.removeIf(project -> project.getProject().equals(projectViewModel.getProject()));
                    }
                    busy.set(false);
                });
    }

    public ObservableList<ProjectViewModel> getProjects() {
        return projects.get();
    }

    public SimpleListProperty<ProjectViewModel> projectsProperty() {
        return projects;
    }

    public BooleanProperty busyProperty() {
        return busy;
    }
}
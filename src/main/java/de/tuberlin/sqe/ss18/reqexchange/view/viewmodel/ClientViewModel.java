package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.service.ProjectService;
import io.reactivex.Observable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ClientViewModel {

    private ProjectService projectService;

    private ListProperty<ProjectViewModel> projects;
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
        ReqExchangeFileType determinedFileType  = ReqExchangeFileType.getFileTypeFromFileName(project.getWorkingModelFilePath().toString());
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

    public void handleSync(ProjectViewModel projectViewModel) {
        busy.set(true);
        Observable.just(1)
                .subscribeOn(Schedulers.newThread())
                .map(i -> projectService.synchronize(projectViewModel.getProject()))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(pulled -> {
                    busy.set(false);
                    if(pulled) {
                        showInformationDialog("Synchronize", "Changes have been successfully synchronized!");
                    } else {
                        showInformationDialog("Synchronize", "No new changes have been synchronized!");
                    }
                });
    }

    public void handleExportProject(ProjectViewModel projectViewModel, String pathToExport) {
        busy.set(true);
        Observable.just(1)
                .subscribeOn(Schedulers.newThread())
                .map(i -> projectService.export(projectViewModel.getProject(), Paths.get(pathToExport)))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(exported -> {
                    busy.set(false);
                    if(exported) {
                        showInformationDialog("Export Project", "Project has been successfully exported!");
                    } else {
                        showInformationDialog("Export Project", "An Error ecurred exporting the project!");
                    }
                });
    }

    public void showInformationDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_information.png"))));
        alert.showAndWait();
    }

    public ObservableList<ProjectViewModel> getProjects() {
        return projects.get();
    }

    public ListProperty<ProjectViewModel> projectsProperty() {
        return projects;
    }

    public BooleanProperty busyProperty() {
        return busy;
    }
}
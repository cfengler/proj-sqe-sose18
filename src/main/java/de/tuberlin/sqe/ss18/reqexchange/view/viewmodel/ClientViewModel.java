package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeApplication;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.common.service.ProjectInfoService;
import de.tuberlin.sqe.ss18.reqexchange.view.controller.ClientController;
import javafx.application.Platform;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ProgressIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ClientViewModel {

    private ProjectInfoService projectInfoService;

    private SimpleListProperty<ProjectInfoViewModel> projects;
    private BooleanProperty busy;

    @Autowired
    public ClientViewModel(ProjectInfoService projectInfoService) {
        this.projectInfoService = projectInfoService;

        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());
        busy = new SimpleBooleanProperty(false);

        /*projectInfoRepository.findAll().forEach(projectInfo -> {
            ProjectInfoViewModel newViewModel = new ProjectInfoViewModel();
            newViewModel.setName(projectInfo.getName());
            ReqExchangeFileType determinedFileType  = null;
            if(projectInfo.getFilename() != null) {
                String[] segments = projectInfo.getFilename().split("\\.");
                String ending = segments[segments.length - 1];
                for(ReqExchangeFileType type: ReqExchangeFileType.values()) {
                    if(type.getFiletypes().contains(ending)) {
                        determinedFileType = type;
                    }
                }
            } else {
                determinedFileType = ReqExchangeFileType.ReqIF;
            }
            newViewModel.setFileType(determinedFileType);
            projects.add(newViewModel);
        });*/
        this.projectInfoService.getAll().forEach(this::addProjectFromProjectInfo);
    }

    private void addProjectFromProjectInfo(ProjectInfo projectInfo) {
        ProjectInfoViewModel viewModel = new ProjectInfoViewModel();
        viewModel.setName(projectInfo.getName());
        viewModel.setProjectInfo(projectInfo);
        ReqExchangeFileType determinedFileType  = ReqExchangeFileType.getFileTypeFromFileName(projectInfo.getFileName());
        viewModel.setFileType(determinedFileType == null ? ReqExchangeFileType.ReqIF : determinedFileType);
        projects.add(viewModel);
    }

    public void handleCreateProject(String name, String password, String filepath) {
        busy.set(true);

        Observable.just(1)
            .subscribeOn(Schedulers.newThread())
            .map(i -> projectInfoService.create(name, Paths.get(filepath), ReqExchangeFileType.getFileTypeFromFileName(filepath)))
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
                .map(i -> projectInfoService.join(name, Paths.get(filepath), filetype))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(projectInfo -> {
                    if(projectInfo != null) {
                        addProjectFromProjectInfo(projectInfo);
                    }
                    busy.set(false);
                });
    }

    public void handleLeaveProject(ProjectInfoViewModel projectInfoViewModel) {
        busy.set(true);
        Observable.just(1)
                .subscribeOn(Schedulers.newThread())
                .map(i -> projectInfoService.leave(projectInfoViewModel.getProjectInfo()))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(left -> {
                    if(left) {
                        projects.removeIf(project -> project.getProjectInfo().equals(projectInfoViewModel.getProjectInfo()));
                    }
                    busy.set(false);
                });
    }

    public ObservableList<ProjectInfoViewModel> getProjects() {
        return projects.get();
    }

    public SimpleListProperty<ProjectInfoViewModel> projectsProperty() {
        return projects;
    }

    public boolean isBusy() {
        return busy.get();
    }

    public BooleanProperty busyProperty() {
        return busy;
    }
}
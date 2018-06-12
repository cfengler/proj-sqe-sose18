package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeApplication;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ProjectInfo;
import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.common.service.ProjectInfoService;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ClientViewModel {

    private ProjectInfoService projectInfoRepository;

    private SimpleListProperty<ProjectInfoViewModel> projects;

    @Autowired
    public ClientViewModel(ProjectInfoService projectInfoRepository) {
        this.projectInfoRepository = projectInfoRepository;

        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());

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
        ReqExchangeApplication.getSpringContext().getBean(ProjectInfoService.class).getAll().forEach(projectInfo -> {
            ProjectInfoViewModel viewModel = new ProjectInfoViewModel();
            viewModel.setName(projectInfo.getName());
            viewModel.setProjectInfo(projectInfo);
            ReqExchangeFileType determinedFileType  = ReqExchangeFileType.getFileTypeFromFileName(projectInfo.getFileName());
            viewModel.setFileType(determinedFileType == null ? ReqExchangeFileType.ReqIF : determinedFileType);
            projects.add(viewModel);
        });
    }

    public void handleCreateProject(String name, String password, String filepath) {
        ReqExchangeApplication.getSpringContext().getBean(ProjectInfoService.class).create(name, Paths.get(filepath), ReqExchangeFileType.getFileTypeFromFileName(filepath));
    }

    public void handleJoinProject(String name, String password, ReqExchangeFileType filetype, String filepath) {
        ReqExchangeApplication.getSpringContext().getBean(ProjectInfoService.class).join(name, Paths.get(filepath), filetype);
    }

    public void handleLeaveProject(ProjectInfoViewModel projectInfoViewModel) {
        ReqExchangeApplication.getSpringContext().getBean(ProjectInfoService.class).leave(projectInfoViewModel.getProjectInfo());
    }

    public ObservableList<ProjectInfoViewModel> getProjects() {
        return projects.get();
    }

    public SimpleListProperty<ProjectInfoViewModel> projectsProperty() {
        return projects;
    }
}
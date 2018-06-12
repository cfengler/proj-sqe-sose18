package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.common.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.common.service.ProjectInfoService;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientViewModel {

    private ProjectInfoService projectInfoRepository;

    private SimpleListProperty<ProjectInfoViewModel> projects;

    @Autowired
    public ClientViewModel(ProjectInfoService projectInfoRepository) {
        this.projectInfoRepository = projectInfoRepository;

        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());

        //TODO binding an die Projekte!?
        projectInfoRepository.findAll().forEach(projectInfo -> {
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
        });
    }

    public void handleCreateProject(String name, String password, String filepath) {
        System.out.println("create project procedure invoked");
        //TODO handle create project
    }

    public void handleJoinProject(String name, String password, ReqExchangeFileType filetype, String filepath) {
        System.out.println("join project procedure invoked");
        //TODO handle join project
    }

    public ObservableList<ProjectInfoViewModel> getProjects() {
        return projects.get();
    }

    public SimpleListProperty<ProjectInfoViewModel> projectsProperty() {
        return projects;
    }
}
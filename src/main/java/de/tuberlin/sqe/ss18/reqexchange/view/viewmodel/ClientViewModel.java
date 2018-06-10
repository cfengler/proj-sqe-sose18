package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import antlr.StringUtils;
import de.tuberlin.sqe.ss18.reqexchange.client.data.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.client.data.repository.ClientProjectInfoRepository;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientViewModel {

    private ClientProjectInfoRepository projectInfoRepository;

    private SimpleListProperty<ProjectInfoViewModel> projects;

    @Autowired
    public ClientViewModel(ClientProjectInfoRepository projectInfoRepository) {
        this.projectInfoRepository = projectInfoRepository;

        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());

        projectInfoRepository.findAll().forEach(projectInfo -> {
            ProjectInfoViewModel newViewModel = new ProjectInfoViewModel();
            newViewModel.setName(projectInfo.getName());
            ReqExchangeFileType determinedFileType  = null;
            if(projectInfo.getFilename() != null) {
                String ending = projectInfo.getFilename().substring(projectInfo.getFilename().lastIndexOf("/") + 1);
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
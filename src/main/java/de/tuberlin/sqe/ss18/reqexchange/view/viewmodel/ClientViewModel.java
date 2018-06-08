package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.client.data.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.client.data.repository.ClientProjectInfoRepository;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientViewModel {

    private ClientProjectInfoRepository projectInfoRepository;

    private SimpleListProperty<ProjectViewModel> projects;

    @Autowired
    public ClientViewModel(ClientProjectInfoRepository projectInfoRepository) {
        this.projectInfoRepository = projectInfoRepository;

        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());
        //TODO: hier muss noch mehr passieren, binding oder manuell
        projectInfoRepository.findAll().stream().forEach(projectInfo -> {
            projects.add(new ProjectViewModel(projectInfo.getName(),false,false));
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
}
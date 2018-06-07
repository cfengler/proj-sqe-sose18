package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientViewModel {

    private StringProperty info;
    private SimpleListProperty<ProjectViewModel> projects;

    public ClientViewModel() {
        System.out.println(getClass().getSimpleName() + " ctor");

        info = new SimpleStringProperty();
        projects = new SimpleListProperty<>();
        projects.set(FXCollections.observableArrayList());

        setInfo("Das ist die Client info.");
    }

    public void handleCreateProject(String name, String password, String filepath) {
        System.out.println("create project procedure invoked");
        //TODO handle create project
    }

    public void handleJoinProject(String name, String password) {
        System.out.println("join project procedure invoked");
        //TODO handle join project
    }

    public final String getInfo() { return info.get(); }
    public final void setInfo(String newValue) { info.set(newValue); }
    public StringProperty infoProperty() { return info; }
}
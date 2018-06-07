package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class ProjectController {

    @FXML private Button buttonLeaveProject;
    @FXML private Button buttonPullCHanges;
    @FXML private Button buttonPushChanges;

    private ProjectViewModel projectViewModel;

    public ProjectController(ProjectViewModel projectViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.projectViewModel = projectViewModel;
    }

    @FXML public void initialize() {

    }

    @FXML protected void handleButtonLeaveProjectAction(ActionEvent event) {

    }

    @FXML protected void handleButtonPullChangesAction(ActionEvent event) {

    }

    @FXML protected void handleButtonPushChangesAction(ActionEvent event) {

    }
}
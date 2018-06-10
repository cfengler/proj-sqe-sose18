package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectInfoViewModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ProjectInfoController extends GridPane {

    @FXML private Button buttonLeaveProject;
    @FXML private Button buttonPullChanges;
    @FXML private Button buttonPushChanges;
    @FXML private Button buttonExportProject;
    @FXML private Label labelProjectName;

    private ProjectInfoViewModel projectInfoViewModel;

    public ProjectInfoController() {

    }

    public ProjectInfoController(ProjectInfoViewModel projectInfoViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");
        this.projectInfoViewModel = projectInfoViewModel;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProjectInfo.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void initialize() {
        labelProjectName.textProperty().bind(projectInfoViewModel.nameProperty());
        buttonPullChanges.disableProperty().bind(projectInfoViewModel.serverChangedProperty().not());
        buttonPushChanges.disableProperty().bind(projectInfoViewModel.localChangedProperty().not());
        buttonExportProject.setText("export " + projectInfoViewModel.getFileType().getName());
    }

    @FXML protected void handleButtonLeaveProjectAction(ActionEvent event) {
        System.out.println("leave project button");
    }

    @FXML protected void handleButtonPullChangesAction(ActionEvent event) {
        System.out.println("pull changes button");
    }

    @FXML protected void handleButtonPushChangesAction(ActionEvent event) {
        System.out.println("push changes button");
    }

    @FXML protected void handleButtonExportProjectAction(ActionEvent event) {
        System.out.println("export project button");
    }

    public void setProjectInfoViewModel(ProjectInfoViewModel projectInfoViewModel) {
        this.projectInfoViewModel = projectInfoViewModel;
    }

    public ProjectInfoViewModel getProjectInfoViewModel() {
        return projectInfoViewModel;
    }
}
package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeApplication;
import de.tuberlin.sqe.ss18.reqexchange.common.service.ProjectInfoService;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectInfoViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

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
    private ClientViewModel clientViewModel;

    public ProjectInfoController() {

    }

    public ProjectInfoController(ProjectInfoViewModel projectInfoViewModel, ClientViewModel clientViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");
        this.projectInfoViewModel = projectInfoViewModel;
        this.clientViewModel = clientViewModel;

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
        buttonPushChanges.disableProperty().bind(projectInfoViewModel.canPushProperty().not());
        buttonPullChanges.disableProperty().bind(projectInfoViewModel.canPullProperty().not());
        buttonExportProject.setText("export " + projectInfoViewModel.getFileType().getName());
        buttonExportProject.prefWidthProperty().bind(this.widthProperty());
        ObjectExpression<Font> fontTracking = Bindings.createObjectBinding(() -> Font.font(getWidth() / 10), widthProperty());
        labelProjectName.fontProperty().bind(fontTracking);
    }

    @FXML protected void handleButtonLeaveProjectAction(ActionEvent event) {
        clientViewModel.handleLeaveProject(projectInfoViewModel);
    }

    @FXML protected void handleButtonPullChangesAction(ActionEvent event) {
        System.out.println("pull changes button");
        //TODO button pull changes action handling
    }

    @FXML protected void handleButtonPushChangesAction(ActionEvent event) {
        System.out.println("push changes button");
        //TODO button push changes action handling
    }

    @FXML protected void handleButtonExportProjectAction(ActionEvent event) {
        System.out.println("export project button");
        //TODO button export project action handling
    }

    public void setProjectInfoViewModel(ProjectInfoViewModel projectInfoViewModel) {
        this.projectInfoViewModel = projectInfoViewModel;
    }

    public ProjectInfoViewModel getProjectInfoViewModel() {
        return projectInfoViewModel;
    }
}
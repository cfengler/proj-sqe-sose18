package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.Optional;

public class ProjectInfoController extends BorderPane {

    @FXML private Button buttonLeaveProject;
    @FXML private Button buttonPullChanges;
    @FXML private Button buttonPushChanges;
    @FXML private Button buttonExportProject;
    @FXML private Label labelProjectName;
    @FXML private Label labelFileType;

    private ProjectViewModel projectViewModel;
    private ClientViewModel clientViewModel;

    public ProjectInfoController() {

    }

    public ProjectInfoController(ProjectViewModel projectViewModel, ClientViewModel clientViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");
        this.projectViewModel = projectViewModel;
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
        labelProjectName.textProperty().bind(projectViewModel.nameProperty());
        buttonPushChanges.disableProperty().bind(projectViewModel.canPushProperty().not());
        buttonPullChanges.disableProperty().bind(projectViewModel.canPullProperty().not());
        ObjectExpression<Font> fontTracking = Bindings.createObjectBinding(() -> Font.font(getWidth() / 10), widthProperty());
        labelProjectName.fontProperty().bind(fontTracking);
        labelFileType.setText(projectViewModel.getFileType().getName());
    }

    @FXML protected void handleButtonLeaveProjectAction(ActionEvent event) {
        clientViewModel.handleLeaveProject(projectViewModel);
    }

    @FXML protected void handleButtonPullChangesAction(ActionEvent event) {
        clientViewModel.handlePullChanges(projectViewModel);
        showFunctionNotImplementedError();
    }

    @FXML protected void handleButtonPushChangesAction(ActionEvent event) {
        clientViewModel.handlePushChanges(projectViewModel);
        showFunctionNotImplementedError();
    }

    @FXML protected void handleButtonExportProjectAction(ActionEvent event) {
        ChoiceDialog<ReqExchangeFileType> dialog = new ChoiceDialog<>(ReqExchangeFileType.ReqIF, ReqExchangeFileType.values());
        dialog.setTitle("Export " + projectViewModel.getName());
        dialog.setHeaderText(null);
        dialog.setContentText("File Type:");
        dialog.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_export_file.png"))));
        Optional<ReqExchangeFileType> result = dialog.showAndWait();
        result.ifPresent(fileType -> clientViewModel.handleExportProject(projectViewModel, fileType));
    }

    public void setProjectViewModel(ProjectViewModel projectViewModel) {
        this.projectViewModel = projectViewModel;
    }

    public ProjectViewModel getProjectViewModel() {
        return projectViewModel;
    }

    private void showFunctionNotImplementedError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Functionality not implemented");
        alert.setHeaderText(null);
        alert.setContentText("Unfortunately, this functionality has not yet been implemented!");
        alert.showAndWait();
    }
}
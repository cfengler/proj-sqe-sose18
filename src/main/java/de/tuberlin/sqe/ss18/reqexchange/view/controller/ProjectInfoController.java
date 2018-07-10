package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.project.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModel;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProjectInfoController extends BorderPane {

    @FXML private Button buttonLeaveProject;
    @FXML private Button buttonSync;
    @FXML private Button buttonExportProject;
    @FXML private Button buttonEditProject;
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
        this.prefHeightProperty().bind(this.prefWidthProperty());

        Button[] buttons = new Button[]{buttonLeaveProject, buttonExportProject, buttonEditProject, buttonSync};
        for(Button b : buttons) {
            b.getGraphic().scaleXProperty().bind(this.prefWidthProperty().divide(this.maxWidthProperty().getValue()));
            b.getGraphic().scaleYProperty().bind(this.prefHeightProperty().divide(this.maxHeightProperty().get()));
            b.prefWidthProperty().bind(this.widthProperty().multiply(0.25));
            b.prefHeightProperty().bind(this.widthProperty().multiply(0.25));
            b.disableProperty().bind(clientViewModel.busyProperty());
        }
        buttonSync.disableProperty().bind(projectViewModel.canPushProperty().not().or(clientViewModel.busyProperty()).or(projectViewModel.canPullProperty().not()));

        labelProjectName.textProperty().bind(projectViewModel.nameProperty());
        ObjectExpression<Font> fontTracking = Bindings.createObjectBinding(() -> Font.font(getWidth() / 10), widthProperty());
        labelProjectName.fontProperty().bind(fontTracking);
        labelFileType.setText(projectViewModel.getFileType().getName());
    }

    @FXML protected void handleButtonLeaveProjectAction(ActionEvent event) {
        clientViewModel.handleLeaveProject(projectViewModel);
    }

    @FXML protected void handleButtonEditProjectAction(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Export Project");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_edit.png"))));

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        TextField name = new TextField(projectViewModel.getName());
        Label error = new Label("Project name already exists!");
        error.setTextFill(Color.RED);
        error.setVisible(false);
        grid.add(new Label("Project Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(error, 0, 1, 2, 1);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(true);
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            ok.setDisable(name.getText().equals(""));
        };
        name.textProperty().addListener(changeListener);
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(name::requestFocus);

        ok.addEventFilter(ActionEvent.ACTION, okEvent -> {
            clientViewModel.getProjects().forEach(project -> {
                if(project.getName().equals(name.getText())) {
                    error.setVisible(true);
                    okEvent.consume();
                }
            });
        });
        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK) {
                return name.getText();
            }
            return null;
        });

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newName -> {
            clientViewModel.handleEditProject(projectViewModel, newName);
        });
    }

    @FXML protected void handleButtonSyncAction(ActionEvent event) {
        clientViewModel.handleSync(projectViewModel);
    }

    @FXML protected void handleButtonExportProjectAction(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Export Project");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_export_file.png"))));

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        ChoiceBox<ReqExchangeFileType> choice = new ChoiceBox<>();
        List<ReqExchangeFileType> choices = Arrays.asList(ReqExchangeFileType.values());
        choice.setItems(FXCollections.observableArrayList(choices));
        BorderPane border = new BorderPane();
        Button file = new Button("...");
        Label filename = new Label();
        border.setCenter(filename);
        border.setRight(file);
        file.setOnAction(fileEvent -> {
            filename.setMaxWidth(border.getBoundsInParent().getMinX());
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Export File To");
            ReqExchangeFileType filetype = choice.getSelectionModel().getSelectedItem();
            List<String> filetypeFilters = new ArrayList<>();
            for(String s: filetype.getFiletypes()) {
                filetypeFilters.add("*." + s);
            }
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(filetype.getName(), filetypeFilters));
            File chosen = chooser.showSaveDialog(grid.getScene().getWindow());
            if(chosen != null) {
                filename.setText(chosen.getAbsolutePath());
            }
        });

        grid.add(new Label("File Type:"), 0, 0);
        grid.add(new Label("Directory:"), 0, 1);
        grid.add(choice, 1, 0);
        grid.add(border, 1, 1);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(true);
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            ok.setDisable(filename.getText().equals("") || choice.getSelectionModel().getSelectedIndex() == -1);
        };
        choice.getSelectionModel().selectedItemProperty().addListener(changeListener);
        filename.textProperty().addListener(changeListener);
        file.disableProperty().bind(Bindings.equal(choice.getSelectionModel().selectedIndexProperty(), -1));
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(choice::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK) {
                return filename.getText();
            }
            return null;
        });

        Optional<String> result = dialog.showAndWait();
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
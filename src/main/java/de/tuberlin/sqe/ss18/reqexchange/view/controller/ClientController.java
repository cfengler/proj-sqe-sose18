package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.client.data.domain.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ClientController {

    @FXML private HBox hBoxActions;
    @FXML private Button buttonCreateProject;
    @FXML private Button buttonJoinProject;
    @FXML private TilePane tilePaneProjects;

    private ClientViewModel clientViewModel;

    @Autowired
    public ClientController(ClientViewModel clientViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.clientViewModel = clientViewModel;
    }

    @FXML
    public void initialize() {
        initializeFlowPaneProjects();
    }

    private EventHandler<ActionEvent> buttonFunction1_onAction = e -> {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nachricht");
        alert.setContentText("Diese Nachricht zeigt an, dass eine Funktion ausgeführt werden sollte...wird es aber noch nicht");
        alert.showAndWait();
    };

    @FXML protected void handleButtonCreateProjectAction(ActionEvent event) {
        Dialog<Pair<String, Pair<String, String>>> dialog = new Dialog<>();
        dialog.setTitle("Create Project");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        TextField name = new TextField();
        PasswordField password = new PasswordField();
        PasswordField confirmPassword = new PasswordField();
        BorderPane border = new BorderPane();
        Button file = new Button("...");
        Label filename = new Label();
        file.setOnAction(fileEvent -> {
            filename.setMaxWidth(border.getBoundsInParent().getMinX());
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choose ReqIF File");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ReqIF File", "*.reqif", "*.reqifz"));
            File chosen = chooser.showOpenDialog(grid.getScene().getWindow());
            if(chosen != null) {
                filename.setText(chosen.getAbsolutePath());
            }
        });
        border.setCenter(filename);
        border.setRight(file);
        Label error = new Label("Passwords do not match!");
        error.setTextFill(Color.RED);
        error.setVisible(false);
        grid.add(new Label("Project Name:"), 0, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(new Label("Confirm Password:"), 0, 2);
        grid.add(new Label("ReqIF File:"), 0, 3);
        grid.add(name, 1, 0);
        grid.add(password, 1, 1);
        grid.add(confirmPassword, 1, 2);
        grid.add(border, 1, 3);
        grid.add(error, 0, 4, 2, 1);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(true);
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            ok.setDisable(name.getText().equals("") || password.getText().equals("")
                    || confirmPassword.getText().equals("") || filename.getText().equals(""));
        };
        name.textProperty().addListener(changeListener);
        password.textProperty().addListener(changeListener);
        confirmPassword.textProperty().addListener(changeListener);
        filename.textProperty().addListener(changeListener);
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(name::requestFocus);
        ok.addEventFilter(ActionEvent.ACTION, okEvent -> {
            if(!password.getText().equals(confirmPassword.getText())) {
                error.setVisible(true);
                okEvent.consume();
            }
        });
        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK && password.getText().equals(confirmPassword.getText())) {
                return new Pair<>(name.getText(), new Pair<>(password.getText(), filename.getText()));
            }
            return null;
        });

        Optional<Pair<String, Pair<String, String>>> result = dialog.showAndWait();
        result.ifPresent(triplet -> {
            clientViewModel.handleCreateProject(triplet.getKey(), triplet.getValue().getKey(), triplet.getValue().getValue());
        });
    }

    @FXML protected void handleButtonJoinProjectAction(ActionEvent event) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Join Project");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        TextField name = new TextField();
        PasswordField password = new PasswordField();
        ChoiceBox choice = new ChoiceBox();
        List<Object> choices = Arrays.asList(ReqExchangeFileType.values());
        choices.add(0, "---");
        choice.setItems(FXCollections.observableArrayList(choices));
        grid.add(new Label("Project Name:"), 0, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(new Label("File Type"), 0, 2);
        grid.add(name, 1, 0);
        grid.add(password, 1, 1);
        grid.add(choice, 1, 2);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(true);
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            ok.setDisable(name.getText().equals("") || password.getText().equals("") || choice.getSelectionModel().getSelectedIndex() == 0);
        };
        name.textProperty().addListener(changeListener);
        password.textProperty().addListener(changeListener);
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(name::requestFocus);
        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK) {
                return new Pair<>(name.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(pair -> {
            clientViewModel.handleJoinProject(pair.getKey(), pair.getValue());
        });
    }

    private void initializeFlowPaneProjects() {
        for (int i = 0; i < 15; i++) {
            Button newButton = new Button();
            newButton.setMinWidth(200);
            newButton.setMinHeight(200);
            tilePaneProjects.getChildren().add(newButton);
        }
    }
}
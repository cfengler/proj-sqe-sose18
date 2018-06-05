package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        ListView<ProjectViewModel> test = new ListView<>();
        TilePane tiles = new TilePane();
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
        //TODO handle create project button action
    }

    @FXML protected void handleButtonJoinProjectAction(ActionEvent event) {
        //TODO handle join project button action
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
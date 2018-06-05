package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientController {

    @FXML private VBox vBoxMenu;
    @FXML private Button buttonFunction1;
    @FXML private Button buttonFunction2;
    @FXML private Button buttonFunction3;

    @FXML private FlowPane flowPaneProjects;

    private ClientViewModel clientViewModel;


    @Autowired
    public ClientController(ClientViewModel clientViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.clientViewModel = clientViewModel;
    }

    @FXML
    public void initialize() {
        initializeEventHandlers();

        initializeFlowPaneProjects();
    }

    private void initializeEventHandlers() {
        buttonFunction1.setOnAction(buttonFunction1_onAction);
        buttonFunction2.setOnAction(buttonFunction1_onAction);
        buttonFunction3.setOnAction(buttonFunction1_onAction);
    }

    private EventHandler<ActionEvent> buttonFunction1_onAction = e -> {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nachricht");
        alert.setContentText("Diese Nachricht zeigt an, dass eine Funktion ausgeführt werden sollte...wird es aber noch nicht");
        alert.showAndWait();
    };

    private void initializeFlowPaneProjects() {
        for (int i = 0; i < 15; i++) {
            Button newButton = new Button();
            newButton.setMinWidth(200);
            newButton.setMinHeight(200);
            flowPaneProjects.getChildren().add(newButton);
        }
    }
}
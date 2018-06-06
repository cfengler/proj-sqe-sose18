package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ServerViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerController {

    @FXML private Button buttonStartPause;

    private ServerViewModel serverViewModel;

    @Autowired
    public ServerController(ServerViewModel serverViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.serverViewModel = serverViewModel;
    }

    @FXML
    public void initialize() {
        serverViewModel.runningProperty().addListener(((observable, oldValue, newValue) -> {
            buttonStartPause.setGraphic(new ImageView(new Image(getClass().getResourceAsStream((newValue ? "/icons/icon_pause.png" : "/icons/icon_start.png")))));
        }));
    }

    @FXML protected void handleButtonStartPauseAction(ActionEvent actionEvent) {
        serverViewModel.handleStartStop();
    }
}
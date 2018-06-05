package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ServerViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerController {

    private ServerViewModel serverViewModel;

    @Autowired
    public ServerController(ServerViewModel serverViewModel) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.serverViewModel = serverViewModel;
    }

    @FXML
    public void initialize() {

    }
}

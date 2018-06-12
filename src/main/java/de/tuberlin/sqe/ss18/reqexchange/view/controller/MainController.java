package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.ViewService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML private ImageView imageViewLogo;
    @FXML private Button buttonClient;
    @FXML private Button buttonServer;


    private ViewService viewService;

    @Autowired
    public MainController(ViewService viewService) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.viewService = viewService;
    }

    @FXML
    public void initialize() {
        initializeLogo();
        initializeEventHandlers();
    }

    private void initializeLogo() {
        Image imageLogo = new Image("images/Logo_ReqExchange.png");
        imageViewLogo.setImage(imageLogo);
    }

    private void initializeEventHandlers() {
        buttonClient.setOnAction(e -> {
            this.viewService.showClient();
        });

//        buttonServer.setOnAction(e -> {
//            this.viewService.showServer();
//        });
    }


}

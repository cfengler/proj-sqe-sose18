package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.MainViewModel;
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


    private MainViewModel mainViewModel;

    @Autowired
    public MainController(MainViewModel mainViewModel) {
        System.out.println("MainController init");

        this.mainViewModel = mainViewModel;
    }



    @FXML
    public void initialize() {
        Image imageLogo = new Image("images/Logo_ReqExchange.png");
        imageViewLogo.setImage(imageLogo);

    }
}

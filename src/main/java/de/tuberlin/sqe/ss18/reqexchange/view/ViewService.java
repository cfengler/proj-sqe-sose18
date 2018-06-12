package de.tuberlin.sqe.ss18.reqexchange.view;

import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ViewService {

    private Stage clientStage;

    public void showMain(Stage primaryStage) {
        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        fxmlLoader.setControllerFactory(t -> ReqExchangeApplication.getSpringContext().getBean(t));

        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("ReqExchange");
        primaryStage.setScene(scene);

        primaryStage.show();*/
        if (clientStage == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Client.fxml"));
            fxmlLoader.setControllerFactory(t -> ReqExchangeApplication.getSpringContext().getBean(t));

            Parent root;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            Scene clientScene = new Scene(root, 800, 600);

            clientStage = new Stage();
            clientStage.setTitle("Client");
            clientStage.setScene(clientScene);
            clientStage.initModality(Modality.NONE);
            clientStage.setOnCloseRequest(event -> {
                clientStage = null;
            });
            clientStage.show();
        }
        else {
            clientStage.toFront();
        }
    }

    public void showClient() {

    }

}

package de.tuberlin.sqe.ss18.reqexchange;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReqExchangeApplication extends Application {

    private Injector injector;

    public ReqExchangeApplication() {
        System.out.println(getClass().getSimpleName() + " ctor");
    }

    @Override
    public void init() {
        injector = Guice.createInjector(new ReqExchangeModule());
    }

    public void start(Stage primaryStage)  {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Client.fxml"));
        fxmlLoader.setControllerFactory(t -> injector.getInstance(t));

        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene clientScene = new Scene(root, 800, 600);

        primaryStage.setTitle("Client");
        primaryStage.setScene(clientScene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {

    }
}

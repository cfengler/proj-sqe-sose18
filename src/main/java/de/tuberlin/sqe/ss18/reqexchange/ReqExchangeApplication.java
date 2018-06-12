package de.tuberlin.sqe.ss18.reqexchange;

import de.tuberlin.sqe.ss18.reqexchange.view.ViewService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ReqExchangeApplication extends Application {

    private static ConfigurableApplicationContext springContext;
    public static  ConfigurableApplicationContext getSpringContext() {
        if (springContext == null) {
            springContext = SpringApplication.run(ReqExchangeApplication.class);
        }
        return springContext;
    }

    private ViewService viewService;

    public ReqExchangeApplication() {
        System.out.println(getClass().getSimpleName() + " ctor");
    }

    @Override
    public void init() throws Exception {

    }

    public void start(Stage primaryStage) throws Exception {
        //this.viewService = getSpringContext().getBean(ViewService.class);
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

        primaryStage.setTitle("Client");
        primaryStage.setScene(clientScene);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        this.getSpringContext().stop();
    }
}

package de.tuberlin.sqe.ss18.reqexchange;

import de.tuberlin.sqe.ss18.reqexchange.view.ViewService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReqExchangeApplication extends Application {

    public static final ConfigurableApplicationContext springContext
            = SpringApplication.run(ReqExchangeApplication.class);

    private ViewService viewService;

    public ReqExchangeApplication() {
        System.out.println(getClass().getSimpleName() + " ctor");
    }

    @Override
    public void init() throws Exception {

    }

    public void start(Stage primaryStage) throws Exception {
        this.viewService = springContext.getBean(ViewService.class);
        this.viewService.showMain(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        this.springContext.stop();
    }
}

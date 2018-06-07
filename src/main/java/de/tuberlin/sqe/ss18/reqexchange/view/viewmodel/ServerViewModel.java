package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.server.service.ServerProjectService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerViewModel {

    private ServerProjectService projectService;


    private BooleanProperty running;
    public boolean isRunning() {
        return running.get();
    }
    public BooleanProperty runningProperty() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running.set(running);
    }


    @Autowired
    public ServerViewModel(ServerProjectService projectService) {
        this.projectService = projectService;

        running = new SimpleBooleanProperty(false);

        addSomeData();
    }

    public void handleStartStop() {
        running.set(!running.get());
    }

    private void addSomeData() {
        //TODO: some testdata?
    }

}
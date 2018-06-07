package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Component;

@Component
public class ServerViewModel {

    private StringProperty info;
    private BooleanProperty running;

    public ServerViewModel() {
        info = new SimpleStringProperty();
        running = new SimpleBooleanProperty(false);

        System.out.println(getClass().getSimpleName() + " ctor");

        setInfo("Das ist die Server info.");
    }

    public void handleStartStop() {
        running.set(!running.get());
    }

    public final String getInfo() {
        return info.get();
    }

    public final void setInfo(String newValue) {
        info.set(newValue);
    }

    public StringProperty infoProperty() {
        return info;
    }

    public boolean isRunning() {
        return running.get();
    }

    public BooleanProperty runningProperty() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running.set(running);
    }
}
package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Component;

@Component
public class ClientViewModel {

    private StringProperty info = new SimpleStringProperty();
    public final String getInfo() { return info.get(); }
    public final void setInfo(String newValue) { info.set(newValue); }
    public StringProperty infoProperty() { return info; }

    public ClientViewModel() {
        System.out.println(getClass().getSimpleName() + " ctor");

        setInfo("Das ist die Client info.");
    }
}

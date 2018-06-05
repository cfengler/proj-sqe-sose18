package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import org.springframework.stereotype.Component;

@Component
public class MainViewModel {

    public MainViewModel() {
        System.out.println(getClass().getSimpleName() + " ctor");
    }
}

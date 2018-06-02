package de.tuberlin.sqe.ss18.reqexchange;

import de.tuberlin.sqe.ss18.reqexchange.view.controller.MainController;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.MainViewModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.tuberlin.sqe.ss18.reqexchange.view.viewmodel")
public class SpringConfiguration {


    @Bean
    public MainController mainController() {
        return new MainController(mainViewModel());
    }

    private MainViewModel _mainViewModel;
    @Bean
    public MainViewModel mainViewModel() {
        if (_mainViewModel == null) {
            _mainViewModel = new MainViewModel();
        }
        return _mainViewModel;
    }
}

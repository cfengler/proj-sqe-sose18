package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.common.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainViewModel {

    private GitService gitService;

    @Autowired
    public MainViewModel(GitService gitService) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.gitService = gitService;

        //String repoName = "proj-sqe-sose18-data";
        //gitService.create(repoName);
        //gitService.commit("proj-sqe-sose18-data");
        //gitService.push("proj-sqe-sose18-data");
        //if (gitService.canPull("proj-sqe-sose18-data")) {
        //    gitService.pull("proj-sqe-sose18-data");
        //}
    }
}

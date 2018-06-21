package de.tuberlin.sqe.ss18.reqexchange;

import com.google.inject.AbstractModule;
import de.tuberlin.sqe.ss18.reqexchange.common.service.DefaultPathService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.DefaultJsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.JsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.*;
import de.tuberlin.sqe.ss18.reqexchange.project.service.DefaultProjectService;
import de.tuberlin.sqe.ss18.reqexchange.project.service.ProjectService;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;

public class ReqExchangeModule extends AbstractModule {
    @Override
    protected void configure() {
        //common
        bind(PathService.class).to(DefaultPathService.class).asEagerSingleton();
        bind(JsonSerializerService.class).to(DefaultJsonSerializerService.class).asEagerSingleton();

        //git
        bind(GitPropertiesService.class).to(DefaultGitPropertiesService.class).asEagerSingleton();
        bind(GitService.class).to(DefaultGitService.class).asEagerSingleton();

        //model
        //bind(ModelService.class).to(DefaultModelService.class).asEagerSingleton();
        bind(ModelTransformationService.class).to(DefaultModelTransformationService.class).asEagerSingleton();
        bind(ModelValidationService.class).to(DefaultModelValidationService.class).asEagerSingleton();

        //project
        bind(ProjectService.class).to(DefaultProjectService.class).asEagerSingleton();

        bind(ClientViewModel.class);
        //configureViewModel();
    }
}

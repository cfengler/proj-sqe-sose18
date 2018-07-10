package de.tuberlin.sqe.ss18.reqexchange;

import com.google.inject.AbstractModule;
import de.tuberlin.sqe.ss18.reqexchange.common.DefaultPathService;
import de.tuberlin.sqe.ss18.reqexchange.model.DefaultModelTransformationService;
import de.tuberlin.sqe.ss18.reqexchange.model.DefaultModelValidationService;
import de.tuberlin.sqe.ss18.reqexchange.model.ModelTransformationService;
import de.tuberlin.sqe.ss18.reqexchange.model.ModelValidationService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.DefaultJsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.JsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.common.PathService;
import de.tuberlin.sqe.ss18.reqexchange.git.DefaultGitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.DefaultGitService;
import de.tuberlin.sqe.ss18.reqexchange.git.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.GitService;
import de.tuberlin.sqe.ss18.reqexchange.project.DefaultProjectService;
import de.tuberlin.sqe.ss18.reqexchange.project.ProjectService;
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
        bind(ModelTransformationService.class).to(DefaultModelTransformationService.class).asEagerSingleton();
        bind(ModelValidationService.class).to(DefaultModelValidationService.class).asEagerSingleton();

        //project
        bind(ProjectService.class).to(DefaultProjectService.class).asEagerSingleton();

        //viewModel
        bind(ClientViewModel.class).asEagerSingleton();
    }
}

package de.tuberlin.sqe.ss18.reqexchange;

import de.tuberlin.sqe.ss18.reqexchange.git.DefaultGitPropertiesServiceTest;
import de.tuberlin.sqe.ss18.reqexchange.model.DefaultModelServiceTest;
import de.tuberlin.sqe.ss18.reqexchange.model.DefaultModelTransformationServiceTest;
import de.tuberlin.sqe.ss18.reqexchange.project.DefaultProjectServiceTest;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModelTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProjectViewModelTest.class,
        DefaultProjectServiceTest.class,
        DefaultGitPropertiesServiceTest.class,
        DefaultModelServiceTest.class,
        DefaultModelTransformationServiceTest.class
})
public class CompleteTestSuite {
}

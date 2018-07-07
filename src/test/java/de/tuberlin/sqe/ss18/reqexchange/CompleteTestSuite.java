package de.tuberlin.sqe.ss18.reqexchange;

import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitPropertiesServiceTest;
import de.tuberlin.sqe.ss18.reqexchange.project.service.DefaultProjectServiceTest;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModelTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProjectViewModelTest.class,
        DefaultProjectServiceTest.class,
        DefaultGitPropertiesServiceTest.class
})
public class CompleteTestSuite {
}

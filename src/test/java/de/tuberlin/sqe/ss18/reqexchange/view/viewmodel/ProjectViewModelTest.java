package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.io.IOException;
import java.nio.file.Files;

public class ProjectViewModelTest extends TestCase {

    @BeforeClass
    public static void startUp() throws IOException {

    }

    public void test_06_HasLocalChanges() {
        //TODO: implement
        Assert.assertTrue(UnitTestHelper.clearRemoteRepository());

        Assert.assertTrue(UnitTestHelper.copyFiles(
                UnitTestHelper.getOneRequirementReqifWorkingFilePath(),
                UnitTestHelper.getTestReqifWorkingFilePath()
        ));

        Project testProject = UnitTestHelper.getProjectService().create(
                UnitTestHelper.getRemoteRepositoryURI(),
                UnitTestHelper.TEST_PROJECT_NAME,
                UnitTestHelper.getTestReqifWorkingFilePath());


        //ProjectViewModel projectViewModel = new ProjectViewModel()
    }

    public void test_07_HasRemoteChanges() {
        //TODO: implement
    }

}

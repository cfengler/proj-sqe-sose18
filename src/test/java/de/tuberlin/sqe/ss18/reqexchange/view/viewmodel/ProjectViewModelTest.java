package de.tuberlin.sqe.ss18.reqexchange.view.viewmodel;

import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
import de.tuberlin.sqe.ss18.reqexchange.project.Project;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectViewModelTest extends TestCase {

    @BeforeClass
    public static void startUp() {

    }

    @Test
    public void test_06_isCanPush() {
        Project mockProject = new Project();
        mockProject.setName("Mock Project");
        mockProject.setRemoteGitRepositoryURI(UnitTestHelper.getRemoteRepositoryURI());
        mockProject.setCommonModelFilePath(UnitTestHelper.getJGitCommonModelFilePath());
        mockProject.setWorkingModelFilePath(UnitTestHelper.getOneRequirementReqifWorkingFilePath());
        mockProject.setLocalGitRepositoryPath(UnitTestHelper.getjGitRepositoryPath());
        mockProject.setPullNeeded(false);
        mockProject.setPushNeeded(false);

        ProjectViewModel projectViewModel = new ProjectViewModel(mockProject);
        Assert.assertFalse(projectViewModel.isCanPush());
        mockProject.setPushNeeded(true);
        Assert.assertTrue(projectViewModel.isCanPush());
    }

    @Test
    public void test_07_isCanPull() {
        Project mockProject = new Project();
        mockProject.setName("Mock Project");
        mockProject.setRemoteGitRepositoryURI(UnitTestHelper.getRemoteRepositoryURI());
        mockProject.setCommonModelFilePath(UnitTestHelper.getJGitCommonModelFilePath());
        mockProject.setWorkingModelFilePath(UnitTestHelper.getOneRequirementReqifWorkingFilePath());
        mockProject.setLocalGitRepositoryPath(UnitTestHelper.getjGitRepositoryPath());
        mockProject.setPullNeeded(false);
        mockProject.setPushNeeded(false);

        ProjectViewModel projectViewModel = new ProjectViewModel(mockProject);
        Assert.assertFalse(projectViewModel.isCanPull());
        mockProject.setPullNeeded(true);
        Assert.assertTrue(projectViewModel.isCanPull());
    }

}

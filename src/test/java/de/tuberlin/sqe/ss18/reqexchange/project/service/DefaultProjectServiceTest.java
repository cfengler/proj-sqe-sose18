package de.tuberlin.sqe.ss18.reqexchange.project.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeModule;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.Project;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultProjectServiceTest {

    private static Injector injector;
    private static ProjectService projectService;

    @BeforeClass
    public static void startUp() {
        injector = Guice.createInjector(new ReqExchangeModule());

        projectService = injector.getInstance(ProjectService.class);
    }

    @AfterClass
    public static void tearDown() {

    }

    @Test
    public void test_02a_CreateProject() {
        //projectService.create("proj-sqe-sose18-unittest", ???, )

        //projectService.create();
    }

    @Test
    public void test_02b_JoinProject() {

    }

    @Test
    public void test_02c_JoinProject() {

    }




}

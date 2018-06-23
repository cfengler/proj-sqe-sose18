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
    public void test_02a_createProject() {
        //TODO: implement

        //remote repository leeren
        //create project!!! (Test-Datei)
        //lokal löschen
        //repository clonen
        //cm datei vergleichen
        //lokal löschen

        //projectService.create("proj-sqe-sose18-unittest", ???, )

        //projectService.create();
    }

    @Test
    public void test_02b_joinProject() {
        //TODO: implement
        //remote repository leeren
        //cm datei mit gitService pushen
        //lokal löschen
        //join project!!!
        //cm datei vergleichen
        //lokal löschen
    }

    @Test
    public void test_02c_exportProject() {
        //TODO: implement
        //cm datei
        //export
        //reqif test datei vergleich
        //sysml test datei vergleich
    }

    @Test
    public void test_04a_synchronizeProject_localChanges() {
        //TODO: implement
    }

    @Test
    public void test_04b_synchronizeProject_remoteChanges() {
        //TODO: implement
    }

    @Test
    public void test_04c_synchronizeProject_local_and_remoteChanges_with_conflicts() {
        //TODO: implement
    }

    @Test
    public void test_04d_synchronizeProject_local_and_remoteChanges_without_conflicts() {
        //TODO: implement
    }

    @Test
    public void test_06_isPushNeeded() {
        //TODO: implement auf Project testen mit projecttService.refresh()
    }

    @Test
    public void test_07_isPullNeeded() {
        //TODO: implement auf Project testen mit projecttService.refresh()
    }

}

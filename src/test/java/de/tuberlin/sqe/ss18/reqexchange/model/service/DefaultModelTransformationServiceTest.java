package de.tuberlin.sqe.ss18.reqexchange.model.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.tuberlin.sqe.ss18.reqexchange.ReqExchangeModule;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.File;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultModelTransformationServiceTest {

    private static Injector injector;
    private static ModelTransformationService modelTransformationService;
    private static final String resourcePath = "src/main/resources/";

    @BeforeClass
    public static void startUp() {
        //injector = Guice.createInjector(new ReqExchangeModule());

        //modelTransformationService = injector.getInstance(ModelTransformationService.class);

        modelTransformationService = new DefaultModelTransformationService();
    }

    @AfterClass
    public static void tearDown() {

    }

    @Test
    public void test_03b1_transformXlsx() {
        //TODO:implement
        //transformation reqif to xlsx
        //füge Requirement hinzu
        //transformattion xlsx to reqif
        //check result of reqif against expected file
    }

    @Test
    public void test_03b2_transformDocx() {
        //TODO: implement
        //transformation reqif to docx
        //füge Requirement hinzu
        //transformattion docx to reqif
        //check result of reqif against expected file
    }

    @Test
    public void test_03c_transformSysML() {
        //TODO:implement
        //transformation reqif to sysml
        //füge Requirement hinzu
        //transformattion sysml to reqif
        //check result of reqif against expected file
    }

    @Test
    public void test_03d_transformSysMLToReqIF() {
        File inSysML = new File(resourcePath + "/samplefiles/04_Papyrus_ReqExchange/04_Papyrus_ReqExchange.uml");
        File outReqIF = new File(resourcePath + "/unitTest/Test_03d.reqif");
        Assert.assertTrue(modelTransformationService.transform(inSysML.toPath(), outReqIF.toPath()));
    }

}

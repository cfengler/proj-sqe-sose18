package de.tuberlin.sqe.ss18.reqexchange.model.service;

import com.google.inject.Injector;
import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
import org.apache.commons.io.FileUtils;
import org.eclipse.rmf.reqif10.ReqIF;
import org.junit.*;
import org.junit.runners.MethodSorters;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultModelTransformationServiceTest {

    private static Injector injector;
    private static ModelTransformationService modelTransformationService;
    private static final Path resourcePath = Paths.get("src/main/resources/");

    @BeforeClass
    public static void startUp() {
        //injector = Guice.createInjector(new ReqExchangeModule());

        //modelTransformationService = injector.getInstance(ModelTransformationService.class);

        modelTransformationService = new DefaultModelTransformationService();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        FileUtils.deleteDirectory(UnitTestHelper.getTestPath().toFile());
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
        Path inSysML = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange.uml");
        Path outReqIF = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_Test.reqif");
        Path validationFile = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("validate").resolve("04_Papyrus_ReqExchange_Test.reqif");
        Assert.assertTrue(modelTransformationService.transform(inSysML, outReqIF));

        ReqIF reqifValidation = DefaultModelService.getReqIFModel(validationFile.toFile());
        ReqIF reqifTest = DefaultModelService.getReqIFModel(outReqIF.toFile());

        Assert.assertEquals(reqifTest.getCoreContent().getSpecObjects().size(), reqifValidation.getCoreContent().getSpecObjects().size());
        Assert.assertEquals(reqifTest.getCoreContent().getSpecifications().size(), reqifValidation.getCoreContent().getSpecifications().size());
        Assert.assertEquals(reqifTest.getCoreContent().getDatatypes().size(), reqifValidation.getCoreContent().getDatatypes().size());
        Assert.assertEquals(reqifTest.getCoreContent().getSpecRelationGroups().size(), reqifValidation.getCoreContent().getSpecRelationGroups().size());
        Assert.assertEquals(reqifTest.getCoreContent().getSpecTypes().size(), reqifValidation.getCoreContent().getSpecTypes().size());

    }

}

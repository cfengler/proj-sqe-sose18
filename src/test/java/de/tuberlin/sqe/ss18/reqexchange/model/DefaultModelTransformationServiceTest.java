package de.tuberlin.sqe.ss18.reqexchange.model;

import com.google.inject.Injector;
import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
import de.tuberlin.sqe.ss18.reqexchange.model.DefaultModelTransformationService;
import de.tuberlin.sqe.ss18.reqexchange.model.ModelTransformationService;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml14.requirements.Requirement;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.SpecObject;
import org.junit.*;
import org.junit.runners.MethodSorters;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    public void test_03d_transformSysMLToReqIFStructure() {
        Path inSysML = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange.uml");
        Path outReqIF = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_Test.reqif");
        Path validationFile = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("validate").resolve("04_Papyrus_ReqExchange_Test.reqif");
        Assert.assertTrue(modelTransformationService.transform(inSysML, outReqIF));

        ReqIF reqifValidation = UnitTestHelper.getModelService().loadReqIFModel(validationFile);
        ReqIF reqifTest = UnitTestHelper.getModelService().loadReqIFModel(outReqIF);

        Assert.assertEquals(reqifTest.getCoreContent().getSpecObjects().size(), reqifValidation.getCoreContent().getSpecObjects().size());
        Assert.assertEquals(reqifTest.getCoreContent().getSpecifications().size(), reqifValidation.getCoreContent().getSpecifications().size());
        Assert.assertEquals(reqifTest.getCoreContent().getDatatypes().size(), reqifValidation.getCoreContent().getDatatypes().size());
        Assert.assertEquals(reqifTest.getCoreContent().getSpecRelationGroups().size(), reqifValidation.getCoreContent().getSpecRelationGroups().size());
        Assert.assertEquals(reqifTest.getCoreContent().getSpecTypes().size(), reqifValidation.getCoreContent().getSpecTypes().size());
    }

    @Test
    public void test_03c_transformSysMLToReqIFContent() {
        Path inSysML = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange.uml");
        Path outReqIF = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_Test.reqif");
        Assert.assertTrue(modelTransformationService.transform(inSysML, outReqIF));

        List<EObject> sysMLIn = UnitTestHelper.getModelService().loadSysMLModel(inSysML);
        ReqIF reqifOut = UnitTestHelper.getModelService().loadReqIFModel(outReqIF);

        List<String> sysMLTextList = new ArrayList<>();
        List<String> sysMLIDList = new ArrayList<>();
        List<String> sysMLNameList = new ArrayList<>();

        List<String> reqifTextList = new ArrayList<>();
        List<String> reqifIDList = new ArrayList<>();
        List<String> reqifNameList = new ArrayList<>();


        for (EObject eObject : sysMLIn) {
            if(eObject instanceof Requirement) {
                Requirement req = (Requirement) eObject;
                sysMLTextList.add(req.getText());
                sysMLIDList.add(req.getId());
                sysMLNameList.add(req.getBase_Class().getName());
            }
        }

        for (SpecObject specObject : reqifOut.getCoreContent().getSpecObjects()) {

            for (AttributeValue attributeValue: specObject.getValues()) {
                AttributeValueString attributeValueString = (AttributeValueString) attributeValue;
                switch (attributeValueString.getDefinition().getLongName()) {
                    case "ID":
                        reqifIDList.add(attributeValueString.getTheValue());
                        break;
                    case "Description":
                        reqifTextList.add(attributeValueString.getTheValue());
                        break;
                    case "Title":
                        reqifNameList.add(attributeValueString.getTheValue());
                        break;
                }
            }
        }

        Assert.assertEquals(sysMLIDList.size(), reqifIDList.size());
        Assert.assertEquals(sysMLNameList.size(), reqifNameList.size());
        Assert.assertEquals(sysMLTextList.size(), reqifTextList.size());



        for (String sysMLID : sysMLIDList) {
            Assert.assertTrue(reqifIDList.remove(sysMLID));
        }
        for (String sysMLText : sysMLTextList) {
            Assert.assertTrue(reqifTextList.remove(sysMLText));
        }
        for (String sysMLName: sysMLNameList) {
            Assert.assertTrue(reqifNameList.remove(sysMLName));
        }

        Assert.assertEquals(reqifIDList.size(), 0);
        Assert.assertEquals(reqifNameList.size(), 0);
        Assert.assertEquals(reqifTextList.size(), 0);

    }


    @Test
    public void test_04_transformSysML2ReqIF2Excel() {
        Path sysML = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange_TreeTable.uml");
        Path reqIF = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.reqif");
        Path excel = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.xlsx");

        Assert.assertTrue(modelTransformationService.transform(sysML, reqIF));
        Assert.assertTrue(modelTransformationService.transform(reqIF, excel));

        Assert.assertTrue(excel.toFile().exists());
    }

}

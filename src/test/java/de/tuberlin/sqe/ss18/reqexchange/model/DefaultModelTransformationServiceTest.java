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
    public void test_01a_TransformReqIFToXls() {
        // TODO: Better Testing @Magnus?
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("validate").resolve("04_Papyrus_ReqExchange_Test.reqif"), UnitTestHelper.getTestPath().resolve("Dummy.xls")));
    }

    @Test
    public void test_01b_TransformReqIFToXlsx() {
        // TODO: Better Testing @Magnus?
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("validate").resolve("04_Papyrus_ReqExchange_Test.reqif"), UnitTestHelper.getTestPath().resolve("Dummy.xlsx")));
    }

    @Test
    public void test_01c_TransformReqIFToDocx() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.reqif"), UnitTestHelper.getTestPath().resolve("Dummy.docx")));
    }

    @Test
    public void test_01d_TransformReqIFToDoc() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.reqif"), UnitTestHelper.getTestPath().resolve("Dummy.doc")));
    }


    @Test
    public void test_02a_TransformXlsxToReqIF() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.xlsx"), UnitTestHelper.getTestPath().resolve("Dummy.reqif")));
    }

    @Test
    public void test_02b_TransformXlsToReqIF() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.xls"), UnitTestHelper.getTestPath().resolve("Dummy.reqif")));
    }

    @Test
    public void test_02a_TransformDocxToReqIF() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.docx"), UnitTestHelper.getTestPath().resolve("Dummy.reqif")));
    }

    @Test
    public void test_02b_TransformDocToReqIF() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.doc"), UnitTestHelper.getTestPath().resolve("Dummy.reqif")));
    }

    @Test
    public void test_2c_TransformSysMLToReqIF() {
        //TODO: implement
        Assert.assertTrue(modelTransformationService.transform(UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange.uml"), UnitTestHelper.getTestPath().resolve("Dummy.reqif")));
    }

    @Test
    public void test_02c1_TransformSysMLToReqIF_Structure() {
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
    public void test_02c2_TransformSysMLToReqIF_Content() {
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
    public void test_03_TransformSysML2ReqIF2Excel() {
        Path sysML = UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange_TreeTable.uml");
        Path reqIF = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.reqif");
        Path excel = UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.xlsx");

        Assert.assertTrue(modelTransformationService.transform(sysML, reqIF));
        Assert.assertTrue(modelTransformationService.transform(reqIF, excel));

        Assert.assertTrue(excel.toFile().exists());
    }

    @Test
    public void test_04a_TransformNullInput() {
        Assert.assertFalse(modelTransformationService.transform(null, null));
        Assert.assertFalse(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.reqif"), null));
    }

    @Test
    public void test_04b_TransformNotFilePath() {
        Assert.assertFalse(modelTransformationService.transform(UnitTestHelper.getTestPath(), null));
        Assert.assertFalse(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.reqif"), UnitTestHelper.getTestPath()));
    }

    @Test
    public void test_04c_TransformNotFromOrToReqIF() {
        Assert.assertFalse(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("04_Papyrus_ReqExchange_TreeTable_Test.xlsx"), UnitTestHelper.getTestPath().getParent().resolve("unitTest").resolve("transformation").resolve("04_Papyrus_ReqExchange.uml")));
    }

    @Test
    public void test_04d_TransformUnknownExtension() {
        //TODO: implement
        Assert.assertFalse(modelTransformationService.transform(UnitTestHelper.getTestPath().resolve("Dummy.reqif"), UnitTestHelper.getTestPath().resolve("Dummy.xxx")));
    }

}

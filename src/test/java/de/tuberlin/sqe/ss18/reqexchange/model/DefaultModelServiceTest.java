package de.tuberlin.sqe.ss18.reqexchange.model;

import de.tuberlin.sqe.ss18.reqexchange.UnitTestHelper;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.sysml14.requirements.Requirement;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.junit.Test;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class DefaultModelServiceTest extends TestCase {

    private Path reqIFFilePath;
    private Path sysMLFilePath;
    //File reqIFFile;
    //File sysMLFile;

    public DefaultModelServiceTest() {

        String resourcePath = "src/main/resources/samplefiles";

        reqIFFilePath = UnitTestHelper.getPathService().getPathOfRunningJar().resolve("samplefiles").resolve("04_ReqIF_ReqExchange").resolve("My.reqif");
        sysMLFilePath = UnitTestHelper.getPathService().getPathOfRunningJar().resolve("samplefiles").resolve("04_Papyrus_ReqExchange").resolve("04_Papyrus_ReqExchange.uml");

        //reqIFFile = new File(resourcePath + "/04_ReqIF_ReqExchange/My.reqif");
        //sysMLFile = new File(resourcePath + "/04_Papyrus_ReqExchange/04_Papyrus_ReqExchange.uml");

    }

    @Test
    public void testLoadReqIFEcoreModellFromFile() {
        assertNotNull(UnitTestHelper.getModelService().loadReqIFModel(reqIFFilePath));
    }

    @Test
    public void testReqIFHasContent() {
        ReqIF reqif = UnitTestHelper.getModelService().loadReqIFModel(reqIFFilePath);
        EList<Specification> specifications = reqif.getCoreContent().getSpecifications();

        EcoreUtil.resolveAll(reqif);
        assertTrue(specifications.size() > 0);

        AttributeValueString attributeValue;
        Specification spec = specifications.get(0);
        attributeValue = (AttributeValueString) spec.getValues().get(0);

        assertTrue(attributeValue.getTheValue().length() > 0);
        assertTrue(spec.getChildren().size() > 0);
        System.out.printf("[%s] %s with %d children \n", spec.getIdentifier(), attributeValue.getTheValue(), spec.getChildren().size());
        for (SpecHierarchy specHi : spec.getChildren()) {
            attributeValue = (AttributeValueString) specHi.getObject().getValues().get(0);
            //EList<EStructuralFeature> eStructuralFeatures = ReqIF10Package.eINSTANCE.eClass().getEStructuralFeatures();

            System.out.printf("\t[%s] %s with %d children\n", specHi.getIdentifier(), attributeValue.getTheValue(), specHi.getChildren().size());

        }
        System.out.println("");
    }
    @Test
    public void testLoadSysMLModelFromFile() {
        assertNotNull(UnitTestHelper.getModelService().loadSysMLModel(sysMLFilePath));
    }

    @Test
    public void testSysMLHasContent() {
        EList<EObject> umlContent = UnitTestHelper.getModelService().loadSysMLModel(sysMLFilePath);
        Package umlModel = (Package) umlContent.get(0);
        List<Requirement> requirements = (List<Requirement>) new LinkedList<Requirement>();

        for (EObject eObj: umlContent) {
            if(eObj instanceof Requirement) {
                requirements.add((Requirement)eObj);

            }
        }

        EcoreUtil.resolveAll(umlModel);

        //System.out.println(umlModel);
        int count = 0;
        for (PackageableElement packageableElement: umlModel.getPackagedElements()) {
            if(packageableElement.getClass() == ClassImpl.class) {
                ClassImpl classImp = (ClassImpl) packageableElement;
                System.out.println(classImp.getName());
                count++;
                EcoreUtil.resolveAll(classImp);

            }
        }

        for (Requirement req: requirements) {
            System.out.println("\t " + req.getText());
        }

        assertTrue(count == 9);



    }

}
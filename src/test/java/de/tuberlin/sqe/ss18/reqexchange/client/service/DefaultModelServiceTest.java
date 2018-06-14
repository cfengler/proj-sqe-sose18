package de.tuberlin.sqe.ss18.reqexchange.client.service;

import de.tuberlin.sqe.ss18.reqexchange.model.service.DefaultModelService;
import junit.framework.TestCase;
import org.apache.http.impl.client.DefaultUserTokenHandler;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

public class DefaultModelServiceTest extends TestCase {

    File file;

    public DefaultModelServiceTest() {

        String filePath = "src/main/resources/samplefiles/04_ReqIF_ReqExchange/My.reqif";
        file = new File(filePath);

    }

    @Test
    public void testLoadReqIFEcoreModellFromFile() {
        assertNotNull(DefaultModelService.getReqIFModel(file));
    }

    @Test
    public void testReqIFHasContent() {
        ReqIF reqif = DefaultModelService.getReqIFModel(file);
        EList<Specification> specifications = reqif.getCoreContent().getSpecifications();

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
    }

    public void testLoadSysMLModelFromFile() {
        assertNotNull(DefaultModelService.getSysMLModel(file));
    }
}

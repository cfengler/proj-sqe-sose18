package de.tuberlin.sqe.ss18.reqexchange.client.service;

import junit.framework.TestCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;
import org.junit.Test;

public class NotAnSerializerServiceTest extends TestCase {

    String filePath;

    public NotAnSerializerServiceTest() {
        filePath = "src/main/resources/samplefiles/04_ReqIF_ReqExchange/My.reqif";
    }

    @Test
    public void testLoadReqIFEcoreModellFromFile() {
        assertNotNull(NotAnSerializerService.loadReqIFEcoreFromFile(filePath));
    }

    @Test
    public void testReqIFHasContent() {
        ReqIF reqif = NotAnSerializerService.loadReqIFEcoreFromFile(filePath);
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
}

package de.tuberlin.sqe.ss18.reqexchange.client.service;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;

import java.util.Map;

public class NotAnSerializerService {

    public static ReqIF loadReqIFEcoreFromFile(String filePath) {
        ReqIF10Package.eINSTANCE.eClass();


        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("reqif", new ReqIF10ResourceFactoryImpl());

        ResourceSet resSet = new ResourceSetImpl();

        Resource resource = resSet.getResource(URI.createURI(filePath), true);

        ReqIF reqif = (ReqIF) resource.getContents().get(0);
        //System.out.println(reqif);

        return reqif;
    }

}

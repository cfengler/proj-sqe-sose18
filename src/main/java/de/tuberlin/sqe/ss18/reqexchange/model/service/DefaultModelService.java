package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.common.CommonModel;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.sysml14.sysmlPackage;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.papyrus.sysml14.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml14.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml14.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml14.requirements.RequirementsPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import java.io.File;
import java.util.Map;

public class DefaultModelService implements ModelService{
    //vielleicht stellt File auch ein Directory dar, falls mehrere Dateien ein Modell darstellen oder File zeigt auf die Hauptdatei zu der relativ dann die weiteren Dateie liegen


    public static ReqIF getReqIFModel(File file) {
        ReqIF10Package.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("reqif", new ReqIF10ResourceFactoryImpl());

        ResourceSet resSet = new ResourceSetImpl();

        Resource resource = resSet.getResource(URI.createURI(file.getAbsolutePath()), true);

        ReqIF reqif = (ReqIF) resource.getContents().get(0);

        return reqif;
    }

    public static void main(String[] args) {
        String filePath = "samplefiles/04_Papyrus_ReqExchange_TreeTable/04_Papyrus_ReqExchange_TreeTable.uml";
        File file = new File(filePath);

        getSysMLModel(file);
    }

    public static SysMLModel getSysMLModel(File file) {

        ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
        Map uriMap = resourceSet.getURIConverter().getURIMap();
        URI uri = URI.createURI("jar:file:/libs/org.eclipse.uml2.uml.resources_5.3.0.v20170605-1616.jar!/"); // for example
        uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
        uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
        uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));



        /*
        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();

        packageRegistry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

        registSysMLPackages(packageRegistry);

        resourceSet.getLoadOptions().put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, true);

        Map<String, Object> extesionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        UMLResourceFactoryImpl umlResourceFactory = new UMLResourceFactoryImpl();
        extesionToFactoryMap.put(XMI2UMLResource.FILE_EXTENSION, umlResourceFactory);


        UMLResourceImpl resource = (UMLResourceImpl) resourceSet.getResource(URI.createURI(file.getAbsolutePath()), true);



        EObject umlResource = resource.getContents().get(0);

        */

        /*

        sysmlPackage.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

        ResourceSet resSet = new ResourceSetImpl();

        Resource resource = resSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);

        Object sysmlModel = resource.getContents().get(0);

        System.out.println(sysmlModel);
        */

        /*
        ResourceSet resSet = new ResourceSetImpl();
        resSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
        resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

        Resource resource = resSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);

        UML
        */
        return new SysMLModel();
    }

    private static void registSysMLPackages(EPackage.Registry packageRegistry) {
        // Register all default SYSML packages
        packageRegistry.put(sysmlPackage.eNS_URI, sysmlPackage.eINSTANCE);
        packageRegistry.put(ActivitiesPackage.eNS_URI, ActivitiesPackage.eINSTANCE);
        packageRegistry.put(AllocationsPackage.eNS_URI, AllocationsPackage.eINSTANCE);
        packageRegistry.put(BlocksPackage.eNS_URI, BlocksPackage.eINSTANCE);
        packageRegistry.put(ModelelementsPackage.eNS_URI, ModelelementsPackage.eINSTANCE);
        packageRegistry.put(RequirementsPackage.eNS_URI, RequirementsPackage.eINSTANCE);

        /*
        packageRegistry.put(ConstraintsPackage.eNS_URI, ConstraintsPackage.eINSTANCE);
        packageRegistry.put(InteractionsPackage.eNS_URI, InteractionsPackage.eINSTANCE);
        packageRegistry.put(PortandflowsPackage.eNS_URI, PortandflowsPackage.eINSTANCE);
        packageRegistry.put(StatemachinesPackage.eNS_URI, StatemachinesPackage.eINSTANCE);
        packageRegistry.put(UsecasesPackage.eNS_URI, UsecasesPackage.eINSTANCE);
        packageRegistry.put(UsecasesPackage.eNS_URI, UsecasesPackage.eINSTANCE);
        */
    }

    public CommonModel getCommonModel(File file) {
        //TODO: implement
        return new CommonModel();
    }

}

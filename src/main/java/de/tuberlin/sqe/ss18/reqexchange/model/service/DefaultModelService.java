package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.ReqIF;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.sysml.SysMLModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.papyrus.sysml14.sysmlPackage;
//import org.eclipse.rmf.reqif10.ReqIF;
//import org.eclipse.rmf.reqif10.ReqIF10Package;
//import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.papyrus.sysml14.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml14.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml14.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml14.requirements.RequirementsPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.internal.resource.UMLResourceImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;


import java.io.File;
import java.util.Map;

public class DefaultModelService { //implements ModelService{
    //vielleicht stellt File auch ein Directory dar, falls mehrere Dateien ein Modell darstellen oder File zeigt auf die Hauptdatei zu der relativ dann die weiteren Dateie liegen


    public static ReqIF getReqIFModel(File file) {
        /*
        ReqIF10Package.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("reqif", new ReqIF10ResourceFactoryImpl());

        ResourceSet resSet = new ResourceSetImpl();

        Resource resource = resSet.getResource(URI.createURI(file.getAbsolutePath()), true);

        ReqIF reqif = (ReqIF) resource.getContents().get(0);

        return reqif;
        */
        return null;
    }

    private static String reqIFECoreFilePath = "C:\\Users\\CFengler\\IdeaProjects\\reqexchange\\src\\main\\resources\\model\\reqif\\reqif10.ecore";
    private static String reqIFFilePath = "C:\\Users\\CFengler\\IdeaProjects\\reqexchange\\src\\main\\resources\\samplefiles\\02_ReqIF_oneReq\\My.reqif";

    public static void main(String[] args) {

        initECore();

        //String filePath = "/home/julian/IdeaProjects/proj-sqe-sose18/src/main/resources/samplefiles/04_Papyrus_ReqExchange_TreeTable/04_Papyrus_ReqExchange_TreeTable.uml";
        //String filePath = "C:\\Users\\CFengler\\IdeaProjects\\reqexchange\\src\\main\\resources\\samplefiles\\02_ReqIF_oneReq\\My.reqif";
        //File file = new File(filePath);

        //Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("library", new XMIResourceFactoryImpl());

        //EObject eobj = getReqIFModel(file);

        //System.out.println(eobj);

    }

    private static EPackage reqIFPackage;

    private static void initECore() {
        /*
         * load existing EPackage
         */
        EcorePackage.eINSTANCE.eClass();
        /*Initialize your EPackage*/
        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put(EcorePackage.eNAME, new XMIResourceFactoryImpl());

        final ResourceSet resSet = new ResourceSetImpl();
        Resource resource = null;
        try {
            resource = resSet.getResource(URI.createFileURI(reqIFECoreFilePath), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*load root and cast to EPackage*/
        reqIFPackage = (EPackage) resource.getContents().get(0);

        //reqIFPackage.eClass();

        //ResourceSet reqIFResourceSet = reqIFPackage.get
    }


    /*
        Example
        https://www.programcreek.com/java-api-examples/?code=ZhengshuaiPENG/org.lovian.eaxmireader/org.lovian.eaxmireader-master/src/org/lovian/eaxmireader/module/InitResourceSet.java#
     */
    public static EObject getSysMLModel(File file) {


        UMLPackage.eINSTANCE.eClass();

        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();

        packageRegistry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

        registSysMLPackages(packageRegistry);

        resourceSet.getLoadOptions().put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, true);

        Map<String, Object> extesionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        UMLResourceFactoryImpl umlResourceFactory = new UMLResourceFactoryImpl();
        extesionToFactoryMap.put("uml", umlResourceFactory);


        UMLResourceImpl resource = (UMLResourceImpl) resourceSet.getResource(URI.createURI(file.getAbsolutePath()), true);



        EObject umlContent = resource.getContents().get(0);

        return umlContent;
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

}

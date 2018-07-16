package de.tuberlin.sqe.ss18.reqexchange.model;

import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelModel2File;
import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelFactory;
import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelPackage;
import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.papyrus.sysml14.sysmlPackage;
import org.eclipse.papyrus.sysml14.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml14.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml14.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml14.requirements.RequirementsPackage;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.internal.resource.UMLResourceImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DefaultModelService implements ModelService{

    /**
     * Register all needed packages on instantiation.
     */
    static {
        registerReqIFPackages();
        //TODO: check register Function for SysML and Xlsx
        registerSysMLPackages();
        registerExcelPackages();
    }

    /**
     * Load a ReqIF Ecore Model from Path.
     * @param filePath - Path to file which contains the ReqIF Model
     * @return ReqIF Object Instance
     */
    public ReqIF loadReqIFModel(Path filePath) {
        if (!Files.exists(filePath)) {
            return null;
        }
        ResourceSet resSet = new ResourceSetImpl();
        Resource resource = resSet.getResource(URI.createFileURI(filePath.toFile().getAbsolutePath()), true);
        return (ReqIF) resource.getContents().get(0);
    }

    /**
     * Saves ReqIF Objects to file via the ResourceFactory.
     * @param reqIFModel ReqIF Object which should be saved
     * @param filePath File in which the ReqIF Model should be saved
     * @return
     */

    public boolean saveReqIFModel(ReqIF reqIFModel, Path filePath) {
        ResourceSet resSet = new ResourceSetImpl();

        Resource resource = resSet.createResource(URI.createFileURI(filePath.toString()));
        resource.getContents().add(reqIFModel);
        try {
            resource.save(Collections.EMPTY_MAP);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public UMLPackage loadUmlModel(Path filePath) {
//        //TODO: implement like getReqIFModel
//        return null;
//    }
//
//    public boolean saveSysMLModel(UMLPackage umlModel, Path filePath) {
//        //TODO: implement
//        return false;
//    }
//
//    public Workbook loadXlsxModel(Path filePath) {
//        //TODO: implement
//
//        //org.eclipse.rmf.reqif10.ReqIF
//        //org.eclipse.uml2.uml.
//
//        return null;
//    }
//
//    public boolean saveXlsxModel(Workbook workbook, Path filePath) {
//        //TODO: implement
//        return false;
//    }


    /*
        Example
        https://www.programcreek.com/java-api-examples/?code=ZhengshuaiPENG/org.lovian.eaxmireader/org.lovian.eaxmireader-master/src/org/lovian/eaxmireader/module/InitResourceSet.java#
     */

    /**
     * Parses a SysML Model in XML representation to a Ecoremodel version from SysML
     * @param filePath - Path to the file which should be loaded and parsed to a SysML Model
     * @return EList of EObjects. EObjects might be Models, Requirements etc.
     */
    public EList<EObject> loadSysMLModel(Path filePath) {
        //TODO initialisierung in stttatic register methode
        UMLPackage.eINSTANCE.eClass();

        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();

        packageRegistry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

        registerSysMLPackages();

        resourceSet.getLoadOptions().put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, true);

        Map<String, Object> extesionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        UMLResourceFactoryImpl umlResourceFactory = new UMLResourceFactoryImpl();
        extesionToFactoryMap.put("uml", umlResourceFactory);

        UMLResourceImpl resource = (UMLResourceImpl) resourceSet.getResource(URI.createFileURI(filePath.toFile().getAbsolutePath()), true);
        return resource.getContents();
    }

    public boolean saveSysMLModel(EList<EObject> umlModel, Path filePath) {
        return saveModelToFile(umlModel, filePath.toFile());
    }


    /**
     * Register all needed Packages for reading, writing and transforming SysML Models.
     */
    public static void registerSysMLPackages() {
        UMLPackage.eINSTANCE.eClass();

        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
        packageRegistry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);


        // Register all default SYSML packages
        packageRegistry.put(sysmlPackage.eNS_URI, sysmlPackage.eINSTANCE);
        packageRegistry.put(ActivitiesPackage.eNS_URI, ActivitiesPackage.eINSTANCE);
        packageRegistry.put(AllocationsPackage.eNS_URI, AllocationsPackage.eINSTANCE);
        packageRegistry.put(BlocksPackage.eNS_URI, BlocksPackage.eINSTANCE);
        packageRegistry.put(ModelelementsPackage.eNS_URI, ModelelementsPackage.eINSTANCE);
        packageRegistry.put(RequirementsPackage.eNS_URI, RequirementsPackage.eINSTANCE);

        UMLResourcesUtil.init(resourceSet);
        OCL.initialize(resourceSet);
        OCLDelegateDomain.initialize(resourceSet);

        /*
        packageRegistry.put(ConstraintsPackage.eNS_URI, ConstraintsPackage.eINSTANCE);
        packageRegistry.put(InteractionsPackage.eNS_URI, InteractionsPackage.eINSTANCE);
        packageRegistry.put(PortandflowsPackage.eNS_URI, PortandflowsPackage.eINSTANCE);
        packageRegistry.put(StatemachinesPackage.eNS_URI, StatemachinesPackage.eINSTANCE);
        packageRegistry.put(UsecasesPackage.eNS_URI, UsecasesPackage.eINSTANCE);
        packageRegistry.put(UsecasesPackage.eNS_URI, UsecasesPackage.eINSTANCE);
        */
    }

    /**
     * Register all needed Packages for reading, writing and transforming ReqIF Models.
     */
    public static void registerReqIFPackages() {
        ReqIF10Package.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("reqif", new ReqIF10ResourceFactoryImpl());
    }

    /**
     * Register all needed Packages for working with and transformations of Excelmodels. Reading and writing are not done via EMF.
     */
    public static void registerExcelPackages() {
        ExcelmodelPackage.eINSTANCE.eClass();
    }


    /**
     * Persistence wrapper method. Save Ecore EObjects in a file.
     * @param outObjects - Ecore Objects which should be saved
     * @param outFile - File in which the Ecore Objects should be saved
     * @return true if successfull, false otherwise
     */
    public boolean saveModelToFile(List<EObject> outObjects, File outFile) {
        if(outObjects.get(0) instanceof Workbook) {
            return saveModelToFile((Workbook) outObjects.get(0), outFile);
        }
        else {
            return saveModelToFileWithEcoreResourceFactory(outObjects, outFile);
        }


    }

    /**
     * Examine File ending and handle saveing of different Ecore Models which cant get saved over their Resource.
     * @param transformedModel - Excel Model of Type Workbook which should be saved
     * @param outFile - File in which the Excel Model should be saved
     * @return true if successfull, false otherwise
     */
    private boolean saveModelToFile(Workbook transformedModel, File outFile){
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = transformedModel;

        //ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        //Workbook excelWorkbook = factory.createWorkbook();



        if (FilenameUtils.getExtension(outFile.getName()).equals("xlsx")) {
            //transform excelModel to xlsxModel
            XSSFWorkbook xlsxWorkbook = ExcelModel2File.transformExcelModelToXlsxModel(excelWorkbook);
            //write xlsxModel to file
            try {
                FileOutputStream fos = new FileOutputStream(outFile);
                xlsxWorkbook.write(fos);
                fos.close();
            } catch (IOException e) {
                System.out.println("DefaultModelTransformationService.transform error writing excel excel file");
                return false;
            }
        }
        else if(FilenameUtils.getExtension(outFile.getName()).equals("xls")) {
            HSSFWorkbook xlsWorkbook = ExcelModel2File.transformExcelModelToXlsModel(excelWorkbook);
            //write xlsxModel to file
            try {
                FileOutputStream fos = new FileOutputStream(outFile);
                xlsWorkbook.write(fos);
                fos.close();
            } catch (IOException e) {
                System.out.println("DefaultModelTransformationService.transform error writing excel xls file");
                return false;
            }
        }
        else {
            System.out.println("Unsupported excel file extension!");
            return true;
        }
        return true;

    }

    /**
     * Saves all Ecore Objects to file which can be saved via their ResourceFactory.
     * @param outObjects - Ecore Objects which should be saved
     * @param outFile - File in which the Ecore Objects should be saved
     * @return true if successfull, false otherwise
     */
    private static boolean saveModelToFileWithEcoreResourceFactory(List<EObject> outObjects, File outFile) {
        // the output objects got captured in the transformedModel extent
        // let's persist them using a resource
        ResourceSet resourceSet2 = new ResourceSetImpl();
        Resource outResource = resourceSet2.createResource(
                URI.createFileURI(outFile.getAbsolutePath()));
        outResource.getContents().addAll(outObjects);
        try {
            outResource.save(Collections.emptyMap());
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

}
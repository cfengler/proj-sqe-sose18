package de.tuberlin.sqe.ss18.reqexchange.model.service;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl.WorkbookImpl;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;

public class DefaultModelTransformationService implements ModelTransformationService {

    private static final Set<String> SUPPORTED_EXTENSIONS = new HashSet<>(
            Arrays.asList("reqif", "uml", "cm")
    );

    public static void main(String[] args) {
        String resourcePath = "src/main/resources";

        /*
         * Register needed EPackages for Parser etc.
         *
         * This example is for ReqIF
         */
        ReqIF10Package.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("reqif", new ReqIF10ResourceFactoryImpl());

        /*
         * Files to be transformed and qvto file
         */

        File inReqIF = new File(resourcePath + "/samplefiles/04_ReqIF_ReqExchange/My.reqif");
        File outReqIF = new File(resourcePath + "/unitTest/MyTransformed.reqif");
        File transformationQVT = new File(resourcePath + "/qvt/ReqIF2ReqIF.qvto");

        boolean result = executeTransformation(inReqIF, outReqIF, transformationQVT);

        System.out.println("Transformation successfull: " + result);

    }

    private static boolean executeTransformation(File inFile, File outFile, File transformationQVTOFile) {
        /*
         * Debug to ensure if file path is correct
         */

        System.out.println(inFile.exists() + " : " +inFile.getAbsolutePath());
        System.out.println(outFile.exists() + " : " +outFile.getAbsolutePath());
        System.out.println(transformationQVTOFile.exists() + " : " +transformationQVTOFile.getAbsolutePath());

        /*
         * Next Part is based on
         * http://wiki.eclipse.org/QVTOML/Examples/InvokeInJava
         */

        // Refer to an existing transformation via URI
        URI transformationURI = URI.createFileURI(transformationQVTOFile.getAbsolutePath());

        // create executor for the given transformation
        TransformationExecutor executor = new TransformationExecutor(transformationURI);

        // define the transformation input
        // Remark: we take the objects from a resource, however
        // a list of arbitrary in-memory EObjects may be passed
        ExecutionContextImpl context = new ExecutionContextImpl();
        ResourceSet resourceSet = new ResourceSetImpl();
        URI uri = URI.createFileURI(inFile.getAbsolutePath());

        Resource inResource = resourceSet.getResource(uri, true);
        EList<EObject> inObjects = inResource.getContents();

        // create the input extent with its initial contents
        ModelExtent input = new BasicModelExtent(inObjects);
        // create an empty extent to catch the output
        ModelExtent output = new BasicModelExtent();

        // setup the execution environment details ->
        // configuration properties, logger, monitor object etc.
        //ExecutionContextImpl context = new ExecutionContextImpl();
        //context.setConfigProperty("keepModeling", true);

        // run the transformation assigned to the executor with the given
        // input and output and execution context -> ChangeTheWorld(in, out)
        // Remark: variable arguments count is supported
        ExecutionDiagnostic result = executor.execute(context, input, output);

        // check the result for success
        if(result.getSeverity() == Diagnostic.OK) {
            // the output objects got captured in the output extent
            List<EObject> outObjects = output.getContents();
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

        } else {
            // turn the result diagnostic into status and send it to error log
            System.out.println("Transformation failed:" + result);
            return false;
        }
        return false;
    }

    @Override
    public boolean transform(Path sourcePath, Path destinationPath) {
        if (sourcePath == null || destinationPath == null) {
            System.out.println("DefaultModelTransformationService.transform parameters null");
            return false;
        }

        String sourcePathExtension = FilenameUtils.getExtension(sourcePath.toString());
        String destinationPathExtension = FilenameUtils.getExtension(destinationPath.toString());

        ReqExchangeFileType sourceFileType = null;
        ReqExchangeFileType destinationFileType = null;
        for(ReqExchangeFileType reft: ReqExchangeFileType.values()) {
            for(String s: reft.getFiletypes()) {
                if(sourcePathExtension.equals(s)) {
                    sourceFileType = reft;
                }
                if(destinationPathExtension.equals(s)) {
                    destinationFileType = reft;
                }
            }
        }
        if(sourceFileType == null || destinationFileType == null) {
            System.out.println("DefaultModelTransformationService.transform files have unsupported extensions");
            return false;
        }

        List<String> reqIfFileExtensions = ReqExchangeFileType.ReqIF.getFiletypes();
        if(!reqIfFileExtensions.contains(sourcePathExtension) &&
                !reqIfFileExtensions.contains(destinationPathExtension) &&
                sourceFileType != destinationFileType) {
            System.out.println("DefaultModelTransformationService.transform no copy or transformation from or to reqif");
            return false;
        }

        if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.SysML.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.SysML.getFiletypes().contains(sourcePathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Excel.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Excel.getFiletypes().contains(sourcePathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Word.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Word.getFiletypes().contains(sourcePathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.SysML.getFiletypes().contains(sourcePathExtension)) {
            return transformReqifToSysml(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.SysML.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension)) {
            return transformSysmlToReqif(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Excel.getFiletypes().contains(sourcePathExtension)) {
            if(sourcePathExtension.equals("xls")) {
                return transformReqifToExcelXls(sourcePath.toFile(), destinationPath.toFile());
            } else {
                return transformReqifToExcelXlsx(sourcePath.toFile(), destinationPath.toFile());
            }
            //return transformReqifToExcel(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Excel.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension)) {
            if(sourcePathExtension.equals("xls")) {
                return transformExcelToReqifXls(sourcePath.toFile(), destinationPath.toFile());
            } else {
                return transformExcelToReqifXlsx(sourcePath.toFile(), destinationPath.toFile());
            }
            //return transformExcelToReqif(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Word.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension)) {
            return transformWordToReqif(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Word.getFiletypes().contains(sourcePathExtension)) {
            return transformReqifToWord(sourcePath.toFile(), destinationPath.toFile());
        } else {
            System.out.println("DefaultModelTransformationService.transform Extension not supported");
            return false;
        }
    }

    private boolean transformReqifToSysml(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformSysmlToReqif(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformReqifToExcelXls(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformReqifToExcelXlsx(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation

        //WorkbookImpl excelmodel = WorkbookImpl();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("test");
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(1, CellType.BOOLEAN);
        cell.setCellValue(false);

        try {
            FileOutputStream fos = new FileOutputStream(destinationFile);
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            System.out.println("DefaultModelTransformationService.transform error writing excel xlsx file");
            return false;
        }

        return copy(sourceFile, destinationFile);
    }

    private boolean transformExcelToReqifXls(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformExcelToReqifXlsx(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(sourceFile);
        } catch (IOException e) {
            System.out.println("DefaultModelTransformationService.transform error reading excel file");
            return false;
        } catch (InvalidFormatException e) {
            System.out.println("DefaultModelTransformationService.transform invalid excel file");
            return false;
        }

        //WorkbookImpl excelmodel = new WorkbookImpl();
        for (Sheet aWorkbook : workbook) {
            XSSFSheet sheet = (XSSFSheet) aWorkbook;
            //TODO do stuff on sheet basis
            for (Row aSheet : sheet) {
                XSSFRow row = (XSSFRow) aSheet;
                //TODO do stuff on row basis
                for (Cell aRow : row) {
                    XSSFCell cell = (XSSFCell) aRow;
                    //TODO do stuff on cell basis
                }
            }
        }

        return copy(sourceFile, destinationFile);
    }

    private boolean transformReqifToWord(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformWordToReqif(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    //TODO: remove when other model transformations work
    private boolean copy(File sourceFile, File destinationFile) {
        if (!sourceFile.exists()) {
            return false;
        }

        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
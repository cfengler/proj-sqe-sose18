package de.tuberlin.sqe.ss18.reqexchange.model.service;

import com.sun.javafx.scene.shape.PathUtils;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.*;
import de.tuberlin.sqe.ss18.reqexchange.project.domain.ReqExchangeFileType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;

public class DefaultModelTransformationService implements ModelTransformationService {

    private static final Set<String> SUPPORTED_EXTENSIONS = new HashSet<>(
            Arrays.asList("reqif", "uml", "cm")
    );


    private String resourcePathForQVTO = "src/main/resources/qvt";

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


        /**
         * Register needed Epackes for UML Parser
         *
         */



        DefaultModelService.registSysMLPackages();
        DefaultModelService.registerReqIFPackages();

        DefaultModelTransformationService dmts = new DefaultModelTransformationService();

        m.put("uml", new UMLResourceFactoryImpl());

        /*
         * Files to be transformed and qvto file
         */

        File inSysML = new File(resourcePath + "/samplefiles/04_Papyrus_ReqExchange/04_Papyrus_ReqExchange.uml");
        File outReqIF = new File(resourcePath + "/unitTest/test.reqif");
        File transformationQVT = new File(resourcePath + "/qvt/SysML2ReqIF.qvto");

        boolean result = dmts.transform(inSysML.toPath(), outReqIF.toPath());

        System.out.println("Transformation successfull: " + result);

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



        if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(destinationPathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.SysML.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.SysML.getFiletypes().contains(destinationPathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Excel.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Excel.getFiletypes().contains(destinationPathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Word.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Word.getFiletypes().contains(destinationPathExtension)) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.SysML.getFiletypes().contains(destinationPathExtension)) {
            return transformReqifToSysml(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.SysML.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(destinationPathExtension)) {
            return transformSysmlToReqif(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Excel.getFiletypes().contains(destinationPathExtension)) {
            if(sourcePathExtension.equals("xls")) {
                return transformReqifToExcelXls(sourcePath.toFile(), destinationPath.toFile());
            } else {
                return transformReqifToExcelXlsx(sourcePath.toFile(), destinationPath.toFile());
            }
            //return transformReqifToExcel(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Excel.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(destinationPathExtension)) {
            if(sourcePathExtension.equals("xls")) {
                return transformExcelToReqifXls(sourcePath.toFile(), destinationPath.toFile());
            } else {
                return transformExcelToReqifXlsx(sourcePath.toFile(), destinationPath.toFile());
            }
            //return transformExcelToReqif(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.Word.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.ReqIF.getFiletypes().contains(destinationPathExtension)) {
            return transformWordToReqif(sourcePath.toFile(), destinationPath.toFile());
        } else if (ReqExchangeFileType.ReqIF.getFiletypes().contains(sourcePathExtension) && ReqExchangeFileType.Word.getFiletypes().contains(destinationPathExtension)) {
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
        /*
        if(!DefaultModelValidationService.validate(sourceFile.toPath())) {
            return false;
        }
        */
        DefaultModelService.registerReqIFPackages();
        DefaultModelService.registSysMLPackages();
        File qvtoFile = new File(resourcePathForQVTO + "/SysML2ReqIF.qvto");
        return executeTransformation(sourceFile, destinationFile, qvtoFile);
    }

    private boolean transformReqifToExcelXls(File sourceFile, File destinationFile) {
        //TODO read reqif from file to reqifModel
        //TODO transform reqifModel to excelModel

        //TODO replace placeholder excelModel
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = factory.createWorkbook();

        //transform excelModel to xlsModel
        HSSFWorkbook xlsWorkbook = transformExcelModelToXlsModel(excelWorkbook);

        //write xlsxModel to file
        try {
            FileOutputStream fos = new FileOutputStream(destinationFile);
            xlsWorkbook.write(fos);
            fos.close();
        } catch (IOException e) {
            System.out.println("DefaultModelTransformationService.transform error writing excel xlsx file");
            return false;
        }

        //return true;
        return copy(sourceFile, destinationFile);
    }

    private boolean transformReqifToExcelXlsx(File sourceFile, File destinationFile) {
        //TODO read reqif from file to reqifModel
        //TODO transform reqifModel to excelModel

        //TODO replace placeholder excelModel
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = factory.createWorkbook();

        //transform excelModel to xlsxModel
        XSSFWorkbook xlsxWorkbook = transformExcelModelToXlsxModel(excelWorkbook);

        //write xlsxModel to file
        try {
            FileOutputStream fos = new FileOutputStream(destinationFile);
            xlsxWorkbook.write(fos);
            fos.close();
        } catch (IOException e) {
            System.out.println("DefaultModelTransformationService.transform error writing excel xlsx file");
            return false;
        }

        //return true;
        return copy(sourceFile, destinationFile);
    }

    private boolean transformExcelToReqifXls(File sourceFile, File destinationFile) {
        //create xlsxModel out of the file
        HSSFWorkbook xlsWorkbook;
        try {
            xlsWorkbook = new HSSFWorkbook(new FileInputStream(sourceFile));
        } catch (IOException e) {
            System.out.println("DefaultModelTransformationService.transform error reading excel file");
            return false;
        }

        //transform xlsModel to excelModel
        Workbook excelWorkbook = transformXlsModelToExcelModel(xlsWorkbook);

        //TODO transform excelModel to reqifModel
        //TODO write reqifModel to file

        return copy(sourceFile, destinationFile);
    }

    private boolean transformExcelToReqifXlsx(File sourceFile, File destinationFile) {
        //create xlsxModel out of the file
        XSSFWorkbook xlsxWorkbook;
        try {
            xlsxWorkbook = new XSSFWorkbook(sourceFile);
        } catch (IOException e) {
            System.out.println("DefaultModelTransformationService.transform error reading excel file");
            return false;
        } catch (InvalidFormatException e) {
            System.out.println("DefaultModelTransformationService.transform invalid excel file");
            return false;
        }

        //transform xlsxModel to excelModel
        Workbook excelWorkbook = transformXlsxModelToExcelModel(xlsxWorkbook);

        //TODO transform excelModel to reqifModel
        //TODO write reqifModel to file

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

    //TODO Anfang des Codes, der besser in einer extra Excel-Hilfs-Klasse sein sollte
    private Workbook transformXlsxModelToExcelModel(XSSFWorkbook xlsxWorkbook) {
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = factory.createWorkbook();

        for (Sheet sheet : xlsxWorkbook) {
            XSSFSheet xlsxSheet = (XSSFSheet) sheet;

            Worksheet excelWorksheet = factory.createWorksheet();
            excelWorksheet.setName(xlsxSheet.getSheetName());
            excelWorkbook.getSheets().add(excelWorksheet);
            for (Row row : xlsxSheet) {
                XSSFRow xlsxRow = (XSSFRow) row;

                de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row excelRow = factory.createRow();
                excelRow.setRowNum(xlsxRow.getRowNum());
                excelWorksheet.getRows().add(excelRow);
                for (Cell cell : xlsxRow) {
                    XSSFCell xlsxCell = (XSSFCell) cell;

                    switch(xlsxCell.getCellTypeEnum()) {
                        case FORMULA:
                        case ERROR:
                        case BLANK:
                        case _NONE:
                        case STRING:
                            de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.StringCell excelStringCell = factory.createStringCell();
                            excelStringCell.setColumnIndex(xlsxCell.getColumnIndex());
                            excelStringCell.setRowIndex(xlsxCell.getRowIndex());
                            excelStringCell.setStringValue(xlsxCell.getStringCellValue());
                            excelRow.getCells().add(excelStringCell);
                            break;
                        case BOOLEAN:
                            de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.BooleanCell excelBooleanCell = factory.createBooleanCell();
                            excelBooleanCell.setColumnIndex(xlsxCell.getColumnIndex());
                            excelBooleanCell.setRowIndex(xlsxCell.getRowIndex());
                            excelBooleanCell.setBoolValue(xlsxCell.getBooleanCellValue());
                            excelRow.getCells().add(excelBooleanCell);
                            break;
                        case NUMERIC:
                            de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.NumericCell excelNumericCell = factory.createNumericCell();
                            excelNumericCell.setColumnIndex(xlsxCell.getColumnIndex());
                            excelNumericCell.setRowIndex(xlsxCell.getRowIndex());
                            excelNumericCell.setNumericValue(xlsxCell.getNumericCellValue());
                            excelRow.getCells().add(excelNumericCell);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return excelWorkbook;
    }

    private Workbook transformXlsModelToExcelModel(HSSFWorkbook xlsWorkbook) {
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = factory.createWorkbook();

        for (Sheet sheet : xlsWorkbook) {
            HSSFSheet xlsSheet = (HSSFSheet) sheet;

            Worksheet modelWorksheet = factory.createWorksheet();
            modelWorksheet.setName(xlsSheet.getSheetName());
            excelWorkbook.getSheets().add(modelWorksheet);
            for (Row row : xlsSheet) {
                HSSFRow xlsRow = (HSSFRow) row;

                de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row modelRow = factory.createRow();
                modelRow.setRowNum(xlsRow.getRowNum());
                modelWorksheet.getRows().add(modelRow);
                for (Cell cell : xlsRow) {
                    HSSFCell xlsCell = (HSSFCell) cell;

                    switch(xlsCell.getCellTypeEnum()) {
                        case FORMULA:
                        case ERROR:
                        case BLANK:
                        case _NONE:
                        case STRING:
                            de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.StringCell excelStringCell = factory.createStringCell();
                            excelStringCell.setColumnIndex(xlsCell.getColumnIndex());
                            excelStringCell.setRowIndex(xlsCell.getRowIndex());
                            excelStringCell.setStringValue(xlsCell.getStringCellValue());
                            modelRow.getCells().add(excelStringCell);
                            break;
                        case BOOLEAN:
                            de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.BooleanCell excelBooleanCell = factory.createBooleanCell();
                            excelBooleanCell.setColumnIndex(xlsCell.getColumnIndex());
                            excelBooleanCell.setRowIndex(xlsCell.getRowIndex());
                            excelBooleanCell.setBoolValue(xlsCell.getBooleanCellValue());
                            modelRow.getCells().add(excelBooleanCell);
                            break;
                        case NUMERIC:
                            de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.NumericCell excelNumericCell = factory.createNumericCell();
                            excelNumericCell.setColumnIndex(xlsCell.getColumnIndex());
                            excelNumericCell.setRowIndex(xlsCell.getRowIndex());
                            excelNumericCell.setNumericValue(xlsCell.getNumericCellValue());
                            modelRow.getCells().add(excelNumericCell);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return excelWorkbook;
    }

    private XSSFWorkbook transformExcelModelToXlsxModel(Workbook excelWorkbook) {
        XSSFWorkbook xlsxWorkbook = new XSSFWorkbook();

        for (Worksheet excelSheet : excelWorkbook.getSheets()) {

            XSSFSheet xlsxSheet = xlsxWorkbook.createSheet(excelSheet.getName());
            for (de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row excelRow : excelSheet.getRows()) {

                XSSFRow xlsxRow = xlsxSheet.createRow(excelRow.getRowNum());
                for (de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell excelCell : excelRow.getCells()) {

                    if(excelCell instanceof StringCell) {
                        xlsxRow.createCell(excelCell.getColumnIndex(), CellType.STRING);
                        xlsxRow.setRowNum(excelCell.getRowIndex());
                    } else if(excelCell instanceof NumericCell) {
                        xlsxRow.createCell(excelCell.getColumnIndex(), CellType.NUMERIC);
                        xlsxRow.setRowNum(excelCell.getRowIndex());
                    } else {
                        xlsxRow.createCell(excelCell.getColumnIndex(), CellType.BOOLEAN);
                        xlsxRow.setRowNum(excelCell.getRowIndex());
                    }
                }
            }
        }
        return xlsxWorkbook;
    }

    private HSSFWorkbook transformExcelModelToXlsModel(Workbook excelWorkbook) {
        HSSFWorkbook xlsWorkbook = new HSSFWorkbook();

        for (Worksheet excelSheet : excelWorkbook.getSheets()) {

            HSSFSheet xlsSheet = xlsWorkbook.createSheet(excelSheet.getName());
            for (de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row excelRow : excelSheet.getRows()) {

                HSSFRow xlsRow = xlsSheet.createRow(excelRow.getRowNum());
                for (de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell excelCell : excelRow.getCells()) {

                    if(excelCell instanceof StringCell) {
                        xlsRow.createCell(excelCell.getColumnIndex(), CellType.STRING);
                        xlsRow.setRowNum(excelCell.getRowIndex());
                    } else if(excelCell instanceof NumericCell) {
                        xlsRow.createCell(excelCell.getColumnIndex(), CellType.NUMERIC);
                        xlsRow.setRowNum(excelCell.getRowIndex());
                    } else {
                        xlsRow.createCell(excelCell.getColumnIndex(), CellType.BOOLEAN);
                        xlsRow.setRowNum(excelCell.getRowIndex());
                    }
                }
            }
        }
        return xlsWorkbook;
    }
    //TODO Ende des Codes, der besser in einer extra Excel-Hilfs-Klasse sein sollte


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
        //context.setConfigProperty("logger", true);
        OutputStreamWriter outStream = new OutputStreamWriter(System.out);
        Log log = new WriterLog(outStream);



        // Uncomment for logging output in console
        //context.setLog(log);

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

}
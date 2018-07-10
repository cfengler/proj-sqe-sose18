package de.tuberlin.sqe.ss18.reqexchange.model.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelModel2File {

    public static Workbook transformXlsxModelToExcelModel(XSSFWorkbook xlsxWorkbook) {
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = factory.createWorkbook();

        for (Sheet sheet : xlsxWorkbook) {
            XSSFSheet xlsxSheet = (XSSFSheet) sheet;

            Worksheet excelWorksheet = factory.createWorksheet();
            excelWorksheet.setName(xlsxSheet.getSheetName());
            excelWorkbook.getSheets().add(excelWorksheet);
            for (org.apache.poi.ss.usermodel.Row row : xlsxSheet) {
                XSSFRow xlsxRow = (XSSFRow) row;

                Row excelRow = factory.createRow();
                excelRow.setRowNum(xlsxRow.getRowNum());
                excelWorksheet.getRows().add(excelRow);
                for (org.apache.poi.ss.usermodel.Cell cell : xlsxRow) {
                    XSSFCell xlsxCell = (XSSFCell) cell;

                    switch(xlsxCell.getCellTypeEnum()) {
                        case FORMULA:
                        case ERROR:
                        case BLANK:
                        case _NONE:
                        case STRING:
                            StringCell excelStringCell = factory.createStringCell();
                            excelStringCell.setColumnIndex(xlsxCell.getColumnIndex());
                            excelStringCell.setRowIndex(xlsxCell.getRowIndex());
                            excelStringCell.setStringValue(xlsxCell.getStringCellValue());
                            excelRow.getCells().add(excelStringCell);
                            break;
                        case BOOLEAN:
                            BooleanCell excelBooleanCell = factory.createBooleanCell();
                            excelBooleanCell.setColumnIndex(xlsxCell.getColumnIndex());
                            excelBooleanCell.setRowIndex(xlsxCell.getRowIndex());
                            excelBooleanCell.setBoolValue(xlsxCell.getBooleanCellValue());
                            excelRow.getCells().add(excelBooleanCell);
                            break;
                        case NUMERIC:
                            NumericCell excelNumericCell = factory.createNumericCell();
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

    public static Workbook transformXlsModelToExcelModel(HSSFWorkbook xlsWorkbook) {
        ExcelmodelFactory factory =  ExcelmodelFactory.eINSTANCE;
        Workbook excelWorkbook = factory.createWorkbook();

        for (Sheet sheet : xlsWorkbook) {
            HSSFSheet xlsSheet = (HSSFSheet) sheet;

            Worksheet modelWorksheet = factory.createWorksheet();
            modelWorksheet.setName(xlsSheet.getSheetName());
            excelWorkbook.getSheets().add(modelWorksheet);
            for (org.apache.poi.ss.usermodel.Row row : xlsSheet) {
                HSSFRow xlsRow = (HSSFRow) row;

                Row modelRow = factory.createRow();
                modelRow.setRowNum(xlsRow.getRowNum());
                modelWorksheet.getRows().add(modelRow);
                for (org.apache.poi.ss.usermodel.Cell cell : xlsRow) {
                    HSSFCell xlsCell = (HSSFCell) cell;

                    switch(xlsCell.getCellTypeEnum()) {
                        case FORMULA:
                        case ERROR:
                        case BLANK:
                        case _NONE:
                        case STRING:
                            StringCell excelStringCell = factory.createStringCell();
                            excelStringCell.setColumnIndex(xlsCell.getColumnIndex());
                            excelStringCell.setRowIndex(xlsCell.getRowIndex());
                            excelStringCell.setStringValue(xlsCell.getStringCellValue());
                            modelRow.getCells().add(excelStringCell);
                            break;
                        case BOOLEAN:
                            BooleanCell excelBooleanCell = factory.createBooleanCell();
                            excelBooleanCell.setColumnIndex(xlsCell.getColumnIndex());
                            excelBooleanCell.setRowIndex(xlsCell.getRowIndex());
                            excelBooleanCell.setBoolValue(xlsCell.getBooleanCellValue());
                            modelRow.getCells().add(excelBooleanCell);
                            break;
                        case NUMERIC:
                            NumericCell excelNumericCell = factory.createNumericCell();
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

    public static XSSFWorkbook transformExcelModelToXlsxModel(Workbook excelWorkbook) {
        XSSFWorkbook xlsxWorkbook = new XSSFWorkbook();

        for (Worksheet excelSheet : excelWorkbook.getSheets()) {

            XSSFSheet xlsxSheet = xlsxWorkbook.createSheet(excelSheet.getName());
            for (Row excelRow : excelSheet.getRows()) {

                XSSFRow xlsxRow = xlsxSheet.createRow(excelRow.getRowNum());
                for (Cell excelCell : excelRow.getCells()) {

                    if(excelCell instanceof StringCell) {
                        XSSFCell xlsxCell = xlsxRow.createCell(excelCell.getColumnIndex(), CellType.STRING);
                        xlsxCell.setCellValue(((StringCell) excelCell).getStringValue());
                        xlsxRow.setRowNum(excelCell.getRowIndex());
                    } else if(excelCell instanceof NumericCell) {
                        XSSFCell xlsxCell = xlsxRow.createCell(excelCell.getColumnIndex(), CellType.NUMERIC);
                        xlsxCell.setCellValue(((NumericCell) excelCell).getNumericValue());
                        xlsxRow.setRowNum(excelCell.getRowIndex());
                    } else {
                        XSSFCell xlsxCell = xlsxRow.createCell(excelCell.getColumnIndex(), CellType.BOOLEAN);
                        xlsxCell.setCellValue(((BooleanCell)excelCell).isBoolValue());
                        xlsxRow.setRowNum(excelCell.getRowIndex());
                    }
                }
            }
        }
        return xlsxWorkbook;
    }

    public static HSSFWorkbook transformExcelModelToXlsModel(Workbook excelWorkbook) {
        HSSFWorkbook xlsWorkbook = new HSSFWorkbook();

        for (Worksheet excelSheet : excelWorkbook.getSheets()) {

            HSSFSheet xlsSheet = xlsWorkbook.createSheet(excelSheet.getName());
            for (Row excelRow : excelSheet.getRows()) {

                HSSFRow xlsRow = xlsSheet.createRow(excelRow.getRowNum());
                for (Cell excelCell : excelRow.getCells()) {

                    if(excelCell instanceof StringCell) {
                        HSSFCell xlsCell = xlsRow.createCell(excelCell.getColumnIndex(), CellType.STRING);
                        xlsCell.setCellValue(((StringCell) excelCell).getStringValue());
                        xlsRow.setRowNum(excelCell.getRowIndex());
                    } else if(excelCell instanceof NumericCell) {
                        HSSFCell xlsCell = xlsRow.createCell(excelCell.getColumnIndex(), CellType.NUMERIC);
                        xlsCell.setCellValue(((NumericCell) excelCell).getNumericValue());
                        xlsRow.setRowNum(excelCell.getRowIndex());
                    } else {
                        HSSFCell xlsCell = xlsRow.createCell(excelCell.getColumnIndex(), CellType.BOOLEAN);
                        xlsCell.setCellValue(((BooleanCell) excelCell).isBoolValue());
                        xlsRow.setRowNum(excelCell.getRowIndex());
                    }
                }
            }
        }
        return xlsWorkbook;
    }
}

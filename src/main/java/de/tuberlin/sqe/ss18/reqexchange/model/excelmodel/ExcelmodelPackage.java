/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.excelmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ExcelmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "excelmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/excelmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "excelmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelmodelPackage eINSTANCE = de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorkbookImpl <em>Workbook</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorkbookImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getWorkbook()
	 * @generated
	 */
	int WORKBOOK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBOOK__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Sheets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBOOK__SHEETS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Workbook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBOOK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Workbook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBOOK_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorksheetImpl <em>Worksheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorksheetImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getWorksheet()
	 * @generated
	 */
	int WORKSHEET = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHEET__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHEET__ROWS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Worksheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHEET_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Worksheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSHEET_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.RowImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 3;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CELLS = 0;

	/**
	 * The feature id for the '<em><b>Row Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__ROW_NUM = 1;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.CellImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 4;

	/**
	 * The feature id for the '<em><b>Column Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__COLUMN_INDEX = 0;

	/**
	 * The feature id for the '<em><b>Row Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__ROW_INDEX = 1;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.StringCellImpl <em>String Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.StringCellImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getStringCell()
	 * @generated
	 */
	int STRING_CELL = 5;

	/**
	 * The feature id for the '<em><b>Column Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CELL__COLUMN_INDEX = CELL__COLUMN_INDEX;

	/**
	 * The feature id for the '<em><b>Row Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CELL__ROW_INDEX = CELL__ROW_INDEX;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CELL__STRING_VALUE = CELL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CELL_FEATURE_COUNT = CELL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CELL_OPERATION_COUNT = CELL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.NumericCellImpl <em>Numeric Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.NumericCellImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getNumericCell()
	 * @generated
	 */
	int NUMERIC_CELL = 6;

	/**
	 * The feature id for the '<em><b>Column Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CELL__COLUMN_INDEX = CELL__COLUMN_INDEX;

	/**
	 * The feature id for the '<em><b>Row Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CELL__ROW_INDEX = CELL__ROW_INDEX;

	/**
	 * The feature id for the '<em><b>Numeric Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CELL__NUMERIC_VALUE = CELL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CELL_FEATURE_COUNT = CELL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Numeric Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_CELL_OPERATION_COUNT = CELL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.BooleanCellImpl <em>Boolean Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.BooleanCellImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getBooleanCell()
	 * @generated
	 */
	int BOOLEAN_CELL = 7;

	/**
	 * The feature id for the '<em><b>Column Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CELL__COLUMN_INDEX = CELL__COLUMN_INDEX;

	/**
	 * The feature id for the '<em><b>Row Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CELL__ROW_INDEX = CELL__ROW_INDEX;

	/**
	 * The feature id for the '<em><b>Bool Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CELL__BOOL_VALUE = CELL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CELL_FEATURE_COUNT = CELL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CELL_OPERATION_COUNT = CELL_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook <em>Workbook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workbook</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook
	 * @generated
	 */
	EClass getWorkbook();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook#getSheets <em>Sheets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sheets</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook#getSheets()
	 * @see #getWorkbook()
	 * @generated
	 */
	EReference getWorkbook_Sheets();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet <em>Worksheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worksheet</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet
	 * @generated
	 */
	EClass getWorksheet();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rows</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet#getRows()
	 * @see #getWorksheet()
	 * @generated
	 */
	EReference getWorksheet_Rows();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cells</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row#getCells()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cells();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row#getRowNum <em>Row Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Row Num</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row#getRowNum()
	 * @see #getRow()
	 * @generated
	 */
	EAttribute getRow_RowNum();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell#getColumnIndex <em>Column Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column Index</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell#getColumnIndex()
	 * @see #getCell()
	 * @generated
	 */
	EAttribute getCell_ColumnIndex();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell#getRowIndex <em>Row Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Row Index</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell#getRowIndex()
	 * @see #getCell()
	 * @generated
	 */
	EAttribute getCell_RowIndex();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.StringCell <em>String Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Cell</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.StringCell
	 * @generated
	 */
	EClass getStringCell();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.StringCell#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.StringCell#getStringValue()
	 * @see #getStringCell()
	 * @generated
	 */
	EAttribute getStringCell_StringValue();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NumericCell <em>Numeric Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Cell</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NumericCell
	 * @generated
	 */
	EClass getNumericCell();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NumericCell#getNumericValue <em>Numeric Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Value</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NumericCell#getNumericValue()
	 * @see #getNumericCell()
	 * @generated
	 */
	EAttribute getNumericCell_NumericValue();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.BooleanCell <em>Boolean Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Cell</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.BooleanCell
	 * @generated
	 */
	EClass getBooleanCell();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.BooleanCell#isBoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool Value</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.BooleanCell#isBoolValue()
	 * @see #getBooleanCell()
	 * @generated
	 */
	EAttribute getBooleanCell_BoolValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExcelmodelFactory getExcelmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorkbookImpl <em>Workbook</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorkbookImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getWorkbook()
		 * @generated
		 */
		EClass WORKBOOK = eINSTANCE.getWorkbook();

		/**
		 * The meta object literal for the '<em><b>Sheets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBOOK__SHEETS = eINSTANCE.getWorkbook_Sheets();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorksheetImpl <em>Worksheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.WorksheetImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getWorksheet()
		 * @generated
		 */
		EClass WORKSHEET = eINSTANCE.getWorksheet();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSHEET__ROWS = eINSTANCE.getWorksheet_Rows();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.RowImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CELLS = eINSTANCE.getRow_Cells();

		/**
		 * The meta object literal for the '<em><b>Row Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW__ROW_NUM = eINSTANCE.getRow_RowNum();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.CellImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Column Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL__COLUMN_INDEX = eINSTANCE.getCell_ColumnIndex();

		/**
		 * The meta object literal for the '<em><b>Row Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL__ROW_INDEX = eINSTANCE.getCell_RowIndex();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.StringCellImpl <em>String Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.StringCellImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getStringCell()
		 * @generated
		 */
		EClass STRING_CELL = eINSTANCE.getStringCell();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_CELL__STRING_VALUE = eINSTANCE.getStringCell_StringValue();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.NumericCellImpl <em>Numeric Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.NumericCellImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getNumericCell()
		 * @generated
		 */
		EClass NUMERIC_CELL = eINSTANCE.getNumericCell();

		/**
		 * The meta object literal for the '<em><b>Numeric Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_CELL__NUMERIC_VALUE = eINSTANCE.getNumericCell_NumericValue();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.BooleanCellImpl <em>Boolean Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.BooleanCellImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.ExcelmodelPackageImpl#getBooleanCell()
		 * @generated
		 */
		EClass BOOLEAN_CELL = eINSTANCE.getBooleanCell();

		/**
		 * The meta object literal for the '<em><b>Bool Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_CELL__BOOL_VALUE = eINSTANCE.getBooleanCell_BoolValue();

	}

} //ExcelmodelPackage

/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.excel.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.excel.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExcelmodelFactoryImpl extends EFactoryImpl implements ExcelmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExcelmodelFactory init() {
		try {
			ExcelmodelFactory theExcelmodelFactory = (ExcelmodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(ExcelmodelPackage.eNS_URI);
			if (theExcelmodelFactory != null) {
				return theExcelmodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExcelmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ExcelmodelPackage.WORKBOOK:
			return createWorkbook();
		case ExcelmodelPackage.WORKSHEET:
			return createWorksheet();
		case ExcelmodelPackage.ROW:
			return createRow();
		case ExcelmodelPackage.BOOLEAN_CELL:
			return createBooleanCell();
		case ExcelmodelPackage.STRING_CELL:
			return createStringCell();
		case ExcelmodelPackage.NUMERIC_CELL:
			return createNumericCell();
		case ExcelmodelPackage.ENUM_CELL:
			return createEnumCell();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workbook createWorkbook() {
		WorkbookImpl workbook = new WorkbookImpl();
		return workbook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Worksheet createWorksheet() {
		WorksheetImpl worksheet = new WorksheetImpl();
		return worksheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Row createRow() {
		RowImpl row = new RowImpl();
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanCell createBooleanCell() {
		BooleanCellImpl booleanCell = new BooleanCellImpl();
		return booleanCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringCell createStringCell() {
		StringCellImpl stringCell = new StringCellImpl();
		return stringCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericCell createNumericCell() {
		NumericCellImpl numericCell = new NumericCellImpl();
		return numericCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCell createEnumCell() {
		EnumCellImpl enumCell = new EnumCellImpl();
		return enumCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelmodelPackage getExcelmodelPackage() {
		return (ExcelmodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExcelmodelPackage getPackage() {
		return ExcelmodelPackage.eINSTANCE;
	}

} //ExcelmodelFactoryImpl

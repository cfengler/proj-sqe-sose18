/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.xlsx;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ExcelmodelPackage
 * @generated
 */
public interface ExcelmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelmodelFactory eINSTANCE = de.tuberlin.sqe.ss18.reqexchange.model.xlsx.impl.ExcelmodelFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Workbook</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workbook</em>'.
	 * @generated
	 */
	Workbook createWorkbook();

	/**
	 * Returns a new object of class '<em>Worksheet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Worksheet</em>'.
	 * @generated
	 */
	Worksheet createWorksheet();

	/**
	 * Returns a new object of class '<em>Row</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Row</em>'.
	 * @generated
	 */
	Row createRow();

	/**
	 * Returns a new object of class '<em>Boolean Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Cell</em>'.
	 * @generated
	 */
	BooleanCell createBooleanCell();

	/**
	 * Returns a new object of class '<em>String Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Cell</em>'.
	 * @generated
	 */
	StringCell createStringCell();

	/**
	 * Returns a new object of class '<em>Numeric Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Cell</em>'.
	 * @generated
	 */
	NumericCell createNumericCell();

	/**
	 * Returns a new object of class '<em>Enum Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Cell</em>'.
	 * @generated
	 */
	EnumCell createEnumCell();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExcelmodelPackage getExcelmodelPackage();

} //ExcelmodelFactory

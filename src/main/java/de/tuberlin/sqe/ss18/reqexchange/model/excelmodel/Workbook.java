/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.excelmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workbook</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook#getSheets <em>Sheets</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelPackage#getWorkbook()
 * @model
 * @generated
 */
public interface Workbook extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Sheets</b></em>' containment reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheets</em>' containment reference list.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelPackage#getWorkbook_Sheets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Worksheet> getSheets();

} // Workbook

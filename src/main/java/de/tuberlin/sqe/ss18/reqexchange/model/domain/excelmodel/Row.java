/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row#getCells <em>Cells</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row#getRowNum <em>Row Num</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getRow()
 * @model
 * @generated
 */
public interface Row extends EObject {
	/**
	 * Returns the value of the '<em><b>Cells</b></em>' containment reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cells</em>' containment reference list.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getRow_Cells()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cell> getCells();

	/**
	 * Returns the value of the '<em><b>Row Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Num</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Num</em>' attribute.
	 * @see #setRowNum(int)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getRow_RowNum()
	 * @model
	 * @generated
	 */
	int getRowNum();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row#getRowNum <em>Row Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row Num</em>' attribute.
	 * @see #getRowNum()
	 * @generated
	 */
	void setRowNum(int value);

} // Row

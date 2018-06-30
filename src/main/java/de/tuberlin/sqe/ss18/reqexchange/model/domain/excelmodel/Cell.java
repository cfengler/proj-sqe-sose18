/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell#getColumnIndex <em>Column Index</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell#getRowIndex <em>Row Index</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getCell()
 * @model abstract="true"
 * @generated
 */
public interface Cell extends EObject {
	/**
	 * Returns the value of the '<em><b>Column Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Index</em>' attribute.
	 * @see #setColumnIndex(int)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getCell_ColumnIndex()
	 * @model
	 * @generated
	 */
	int getColumnIndex();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell#getColumnIndex <em>Column Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Index</em>' attribute.
	 * @see #getColumnIndex()
	 * @generated
	 */
	void setColumnIndex(int value);

	/**
	 * Returns the value of the '<em><b>Row Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Index</em>' attribute.
	 * @see #setRowIndex(int)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getCell_RowIndex()
	 * @model
	 * @generated
	 */
	int getRowIndex();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell#getRowIndex <em>Row Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row Index</em>' attribute.
	 * @see #getRowIndex()
	 * @generated
	 */
	void setRowIndex(int value);

} // Cell

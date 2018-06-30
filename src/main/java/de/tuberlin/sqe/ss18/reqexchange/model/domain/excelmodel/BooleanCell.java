/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.BooleanCell#isBoolValue <em>Bool Value</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getBooleanCell()
 * @model
 * @generated
 */
public interface BooleanCell extends Cell {
	/**
	 * Returns the value of the '<em><b>Bool Value</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bool Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bool Value</em>' attribute.
	 * @see #setBoolValue(boolean)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getBooleanCell_BoolValue()
	 * @model default="false"
	 * @generated
	 */
	boolean isBoolValue();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.BooleanCell#isBoolValue <em>Bool Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool Value</em>' attribute.
	 * @see #isBoolValue()
	 * @generated
	 */
	void setBoolValue(boolean value);

} // BooleanCell

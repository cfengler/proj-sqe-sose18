/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.excel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link StringCell#getStringValue <em>String Value</em>}</li>
 * </ul>
 *
 * @see ExcelmodelPackage#getStringCell()
 * @model
 * @generated
 */
public interface StringCell extends Cell {
	/**
	 * Returns the value of the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Value</em>' attribute.
	 * @see #setStringValue(String)
	 * @see ExcelmodelPackage#getStringCell_StringValue()
	 * @model
	 * @generated
	 */
	String getStringValue();

	/**
	 * Sets the value of the '{@link StringCell#getStringValue <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Value</em>' attribute.
	 * @see #getStringValue()
	 * @generated
	 */
	void setStringValue(String value);

} // StringCell

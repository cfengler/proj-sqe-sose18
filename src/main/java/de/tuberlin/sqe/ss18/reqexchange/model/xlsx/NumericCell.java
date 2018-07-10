/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.xlsx;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link NumericCell#getNumericValue <em>Numeric Value</em>}</li>
 * </ul>
 *
 * @see ExcelmodelPackage#getNumericCell()
 * @model
 * @generated
 */
public interface NumericCell extends Cell {
	/**
	 * Returns the value of the '<em><b>Numeric Value</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numeric Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric Value</em>' attribute.
	 * @see #setNumericValue(double)
	 * @see ExcelmodelPackage#getNumericCell_NumericValue()
	 * @model default="0.0"
	 * @generated
	 */
	double getNumericValue();

	/**
	 * Sets the value of the '{@link NumericCell#getNumericValue <em>Numeric Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numeric Value</em>' attribute.
	 * @see #getNumericValue()
	 * @generated
	 */
	void setNumericValue(double value);

} // NumericCell

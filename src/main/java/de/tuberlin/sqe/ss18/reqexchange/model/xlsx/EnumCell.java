/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.xlsx;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link EnumCell#getEnums <em>Enums</em>}</li>
 *   <li>{@link EnumCell#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 *
 * @see ExcelmodelPackage#getEnumCell()
 * @model
 * @generated
 */
public interface EnumCell extends Cell {
	/**
	 * Returns the value of the '<em><b>Enums</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enums</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enums</em>' attribute.
	 * @see #setEnums(Enumerator)
	 * @see ExcelmodelPackage#getEnumCell_Enums()
	 * @model transient="true"
	 * @generated
	 */
	Enumerator getEnums();

	/**
	 * Sets the value of the '{@link EnumCell#getEnums <em>Enums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enums</em>' attribute.
	 * @see #getEnums()
	 * @generated
	 */
	void setEnums(Enumerator value);

	/**
	 * Returns the value of the '<em><b>Enum Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Value</em>' attribute.
	 * @see #setEnumValue(String)
	 * @see ExcelmodelPackage#getEnumCell_EnumValue()
	 * @model
	 * @generated
	 */
	String getEnumValue();

	/**
	 * Sets the value of the '{@link EnumCell#getEnumValue <em>Enum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Value</em>' attribute.
	 * @see #getEnumValue()
	 * @generated
	 */
	void setEnumValue(String value);

} // EnumCell

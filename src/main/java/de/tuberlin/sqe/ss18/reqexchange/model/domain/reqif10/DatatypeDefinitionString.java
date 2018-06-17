/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datatype Definition String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getDatatypeDefinitionString()
 * @model extendedMetaData="name='DATATYPE-DEFINITION-STRING' kind='elementOnly'"
 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='DATATYPE-DEFINITION-STRING'"
 * @generated
 */
public interface DatatypeDefinitionString extends DatatypeDefinitionSimple {
	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #isSetMaxLength()
	 * @see #unsetMaxLength()
	 * @see #setMaxLength(BigInteger)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getDatatypeDefinitionString_MaxLength()
	 * @model unsettable="true" required="true" ordered="false"
	 *        extendedMetaData="name='MAX-LENGTH' kind='attribute'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='MAX-LENGTH' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='false'"
	 * @generated
	 */
	BigInteger getMaxLength();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #isSetMaxLength()
	 * @see #unsetMaxLength()
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(BigInteger value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxLength()
	 * @see #getMaxLength()
	 * @see #setMaxLength(BigInteger)
	 * @generated
	 */
	void unsetMaxLength();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Length</em>' attribute is set.
	 * @see #unsetMaxLength()
	 * @see #getMaxLength()
	 * @see #setMaxLength(BigInteger)
	 * @generated
	 */
	boolean isSetMaxLength();

} // DatatypeDefinitionString

/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Boolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#isTheValue <em>The Value</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getAttributeValueBoolean()
 * @model extendedMetaData="name='ATTRIBUTE-VALUE-BOOLEAN' kind='elementOnly'"
 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='ATTRIBUTE-VALUE-BOOLEAN'"
 * @generated
 */
public interface AttributeValueBoolean extends AttributeValueSimple {
	/**
	 * Returns the value of the '<em><b>The Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Value</em>' attribute.
	 * @see #isSetTheValue()
	 * @see #unsetTheValue()
	 * @see #setTheValue(boolean)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getAttributeValueBoolean_TheValue()
	 * @model unsettable="true" required="true" ordered="false"
	 *        extendedMetaData="name='THE-VALUE' kind='attribute'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='THE-VALUE' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='false'"
	 * @generated
	 */
	boolean isTheValue();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#isTheValue <em>The Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Value</em>' attribute.
	 * @see #isSetTheValue()
	 * @see #unsetTheValue()
	 * @see #isTheValue()
	 * @generated
	 */
	void setTheValue(boolean value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#isTheValue <em>The Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTheValue()
	 * @see #isTheValue()
	 * @see #setTheValue(boolean)
	 * @generated
	 */
	void unsetTheValue();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#isTheValue <em>The Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>The Value</em>' attribute is set.
	 * @see #unsetTheValue()
	 * @see #isTheValue()
	 * @see #setTheValue(boolean)
	 * @generated
	 */
	boolean isSetTheValue();

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #isSetDefinition()
	 * @see #unsetDefinition()
	 * @see #setDefinition(AttributeDefinitionBoolean)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getAttributeValueBoolean_Definition()
	 * @model unsettable="true" required="true" ordered="false"
	 *        extendedMetaData="name='DEFINITION' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='DEFINITION' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='true' classifierNameSuffix='-REF'"
	 * @generated
	 */
	AttributeDefinitionBoolean getDefinition();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #isSetDefinition()
	 * @see #unsetDefinition()
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(AttributeDefinitionBoolean value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinition()
	 * @see #getDefinition()
	 * @see #setDefinition(AttributeDefinitionBoolean)
	 * @generated
	 */
	void unsetDefinition();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeValueBoolean#getDefinition <em>Definition</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Definition</em>' reference is set.
	 * @see #unsetDefinition()
	 * @see #getDefinition()
	 * @see #setDefinition(AttributeDefinitionBoolean)
	 * @generated
	 */
	boolean isSetDefinition();

} // AttributeValueBoolean

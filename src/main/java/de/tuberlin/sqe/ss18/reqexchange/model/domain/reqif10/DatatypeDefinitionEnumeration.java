/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datatype Definition Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionEnumeration#getSpecifiedValues <em>Specified Values</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getDatatypeDefinitionEnumeration()
 * @model extendedMetaData="name='DATATYPE-DEFINITION-ENUMERATION' kind='elementOnly'"
 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='DATATYPE-DEFINITION-ENUMERATION'"
 * @generated
 */
public interface DatatypeDefinitionEnumeration extends DatatypeDefinition {
	/**
	 * Returns the value of the '<em><b>Specified Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.EnumValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specified Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Values</em>' containment reference list.
	 * @see #isSetSpecifiedValues()
	 * @see #unsetSpecifiedValues()
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getDatatypeDefinitionEnumeration_SpecifiedValues()
	 * @model containment="true" unsettable="true"
	 *        extendedMetaData="name='SPECIFIED-VALUES' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='SPECIFIED-VALUES' featureWrapperElement='true' featureElement='false' classifierWrapperElement='false' classifierElement='true'"
	 * @generated
	 */
	EList<EnumValue> getSpecifiedValues();

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionEnumeration#getSpecifiedValues <em>Specified Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecifiedValues()
	 * @see #getSpecifiedValues()
	 * @generated
	 */
	void unsetSpecifiedValues();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.DatatypeDefinitionEnumeration#getSpecifiedValues <em>Specified Values</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specified Values</em>' containment reference list is set.
	 * @see #unsetSpecifiedValues()
	 * @see #getSpecifiedValues()
	 * @generated
	 */
	boolean isSetSpecifiedValues();

} // DatatypeDefinitionEnumeration

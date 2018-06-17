/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spec Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecType#getSpecAttributes <em>Spec Attributes</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getSpecType()
 * @model abstract="true"
 *        extendedMetaData="name='SPEC-TYPE' kind='elementOnly'"
 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='SPEC-TYPE'"
 * @generated
 */
public interface SpecType extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Spec Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spec Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spec Attributes</em>' containment reference list.
	 * @see #isSetSpecAttributes()
	 * @see #unsetSpecAttributes()
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getSpecType_SpecAttributes()
	 * @model containment="true" unsettable="true" ordered="false"
	 *        extendedMetaData="name='SPEC-ATTRIBUTES' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='SPEC-ATTRIBUTES' featureWrapperElement='true' featureElement='false' classifierWrapperElement='false' classifierElement='true'"
	 * @generated
	 */
	EList<AttributeDefinition> getSpecAttributes();

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecType#getSpecAttributes <em>Spec Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecAttributes()
	 * @see #getSpecAttributes()
	 * @generated
	 */
	void unsetSpecAttributes();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecType#getSpecAttributes <em>Spec Attributes</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Spec Attributes</em>' containment reference list is set.
	 * @see #unsetSpecAttributes()
	 * @see #getSpecAttributes()
	 * @generated
	 */
	boolean isSetSpecAttributes();

} // SpecType

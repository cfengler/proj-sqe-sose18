/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSpecRelations <em>Spec Relations</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getType <em>Type</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSourceSpecification <em>Source Specification</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getTargetSpecification <em>Target Specification</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getRelationGroup()
 * @model extendedMetaData="name='RELATION-GROUP' kind='elementOnly'"
 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='RELATION-GROUP'"
 * @generated
 */
public interface RelationGroup extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Spec Relations</b></em>' reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spec Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spec Relations</em>' reference list.
	 * @see #isSetSpecRelations()
	 * @see #unsetSpecRelations()
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getRelationGroup_SpecRelations()
	 * @model unsettable="true" ordered="false"
	 *        extendedMetaData="name='SPEC-RELATIONS' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='SPEC-RELATIONS' featureWrapperElement='true' featureElement='false' classifierWrapperElement='false' classifierElement='true' classifierNameSuffix='-REF'"
	 * @generated
	 */
	EList<SpecRelation> getSpecRelations();

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSpecRelations <em>Spec Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecRelations()
	 * @see #getSpecRelations()
	 * @generated
	 */
	void unsetSpecRelations();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSpecRelations <em>Spec Relations</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Spec Relations</em>' reference list is set.
	 * @see #unsetSpecRelations()
	 * @see #getSpecRelations()
	 * @generated
	 */
	boolean isSetSpecRelations();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(RelationGroupType)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getRelationGroup_Type()
	 * @model unsettable="true" required="true" ordered="false"
	 *        extendedMetaData="name='TYPE' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='TYPE' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='true' classifierNameSuffix='-REF'"
	 * @generated
	 */
	RelationGroupType getType();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationGroupType value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(RelationGroupType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getType <em>Type</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' reference is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(RelationGroupType)
	 * @generated
	 */
	boolean isSetType();

	/**
	 * Returns the value of the '<em><b>Source Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Specification</em>' reference.
	 * @see #isSetSourceSpecification()
	 * @see #unsetSourceSpecification()
	 * @see #setSourceSpecification(Specification)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getRelationGroup_SourceSpecification()
	 * @model unsettable="true" required="true" ordered="false"
	 *        extendedMetaData="name='SOURCE-SPECIFICATION' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='SOURCE-SPECIFICATION' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='true' classifierNameSuffix='-REF'"
	 * @generated
	 */
	Specification getSourceSpecification();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSourceSpecification <em>Source Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Specification</em>' reference.
	 * @see #isSetSourceSpecification()
	 * @see #unsetSourceSpecification()
	 * @see #getSourceSpecification()
	 * @generated
	 */
	void setSourceSpecification(Specification value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSourceSpecification <em>Source Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSourceSpecification()
	 * @see #getSourceSpecification()
	 * @see #setSourceSpecification(Specification)
	 * @generated
	 */
	void unsetSourceSpecification();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getSourceSpecification <em>Source Specification</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Source Specification</em>' reference is set.
	 * @see #unsetSourceSpecification()
	 * @see #getSourceSpecification()
	 * @see #setSourceSpecification(Specification)
	 * @generated
	 */
	boolean isSetSourceSpecification();

	/**
	 * Returns the value of the '<em><b>Target Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Specification</em>' reference.
	 * @see #isSetTargetSpecification()
	 * @see #unsetTargetSpecification()
	 * @see #setTargetSpecification(Specification)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getRelationGroup_TargetSpecification()
	 * @model unsettable="true" required="true" ordered="false"
	 *        extendedMetaData="name='TARGET-SPECIFICATION' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='TARGET-SPECIFICATION' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='true' classifierNameSuffix='-REF'"
	 * @generated
	 */
	Specification getTargetSpecification();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getTargetSpecification <em>Target Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Specification</em>' reference.
	 * @see #isSetTargetSpecification()
	 * @see #unsetTargetSpecification()
	 * @see #getTargetSpecification()
	 * @generated
	 */
	void setTargetSpecification(Specification value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getTargetSpecification <em>Target Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTargetSpecification()
	 * @see #getTargetSpecification()
	 * @see #setTargetSpecification(Specification)
	 * @generated
	 */
	void unsetTargetSpecification();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup#getTargetSpecification <em>Target Specification</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Specification</em>' reference is set.
	 * @see #unsetTargetSpecification()
	 * @see #getTargetSpecification()
	 * @see #setTargetSpecification(Specification)
	 * @generated
	 */
	boolean isSetTargetSpecification();

} // RelationGroup

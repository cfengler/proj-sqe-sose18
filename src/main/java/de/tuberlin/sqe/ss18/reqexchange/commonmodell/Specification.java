/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Specification#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link Specification#getReqContainer <em>Req Container</em>}</li>
 *   <li>{@link Specification#getPropertySets <em>Property Sets</em>}</li>
 *   <li>{@link Specification#getOtherSpecification <em>Other Specification</em>}</li>
 *   <li>{@link Specification#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link Specification#getRelationTypes <em>Relation Types</em>}</li>
 *   <li>{@link Specification#getRelations <em>Relations</em>}</li>
 *   <li>{@link Specification#getName <em>Name</em>}</li>
 *   <li>{@link Specification#getDescription <em>Description</em>}</li>
 *   <li>{@link Specification#getPropertys <em>Propertys</em>}</li>
 * </ul>
 *
 * @see CommonmodellPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Content Objects</b></em>' reference list.
	 * The list contents are of type {@link ContentObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Objects</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_ContentObjects()
	 * @model
	 * @generated
	 */
	EList<ContentObject> getContentObjects();

	/**
	 * Returns the value of the '<em><b>Req Container</b></em>' reference list.
	 * The list contents are of type {@link ReqContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req Container</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req Container</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_ReqContainer()
	 * @model
	 * @generated
	 */
	EList<ReqContainer> getReqContainer();

	/**
	 * Returns the value of the '<em><b>Property Sets</b></em>' reference list.
	 * The list contents are of type {@link PropertySet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Sets</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_PropertySets()
	 * @model
	 * @generated
	 */
	EList<PropertySet> getPropertySets();

	/**
	 * Returns the value of the '<em><b>Other Specification</b></em>' reference list.
	 * The list contents are of type {@link Specification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Specification</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_OtherSpecification()
	 * @model
	 * @generated
	 */
	EList<Specification> getOtherSpecification();

	/**
	 * Returns the value of the '<em><b>Datatypes</b></em>' reference list.
	 * The list contents are of type {@link DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatypes</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_Datatypes()
	 * @model
	 * @generated
	 */
	EList<DataType> getDatatypes();

	/**
	 * Returns the value of the '<em><b>Relation Types</b></em>' reference list.
	 * The list contents are of type {@link RelationalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Types</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_RelationTypes()
	 * @model
	 * @generated
	 */
	EList<RelationalType> getRelationTypes();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' reference list.
	 * The list contents are of type {@link Relation}.
	 * It is bidirectional and its opposite is '{@link Relation#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_Relations()
	 * @see Relation#getSpecification
	 * @model opposite="specification"
	 * @generated
	 */
	EList<Relation> getRelations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see CommonmodellPackage#getSpecification_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Specification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see CommonmodellPackage#getSpecification_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link Specification#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Propertys</b></em>' reference list.
	 * The list contents are of type {@link Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propertys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propertys</em>' reference list.
	 * @see CommonmodellPackage#getSpecification_Propertys()
	 * @model
	 * @generated
	 */
	EList<Property> getPropertys();

} // Specification

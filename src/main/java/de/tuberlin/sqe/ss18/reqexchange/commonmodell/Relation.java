/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Relation#getPropertys <em>Propertys</em>}</li>
 *   <li>{@link Relation#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link Relation#getSpecification <em>Specification</em>}</li>
 *   <li>{@link Relation#getRelationaltype <em>Relationaltype</em>}</li>
 *   <li>{@link Relation#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link Relation#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see CommonmodellPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends Identifiable {
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
	 * @see CommonmodellPackage#getRelation_Propertys()
	 * @model
	 * @generated
	 */
	EList<Property> getPropertys();

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
	 * @see CommonmodellPackage#getRelation_ContentObjects()
	 * @model
	 * @generated
	 */
	EList<ContentObject> getContentObjects();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.commonmodell.Specification}.
	 * It is bidirectional and its opposite is '{@link de.tuberlin.sqe.ss18.reqexchange.commonmodell.Specification#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference list.
	 * @see CommonmodellPackage#getRelation_Specification()
	 * @see de.tuberlin.sqe.ss18.reqexchange.commonmodell.Specification#getRelations
	 * @model opposite="relations" required="true" upper="2"
	 * @generated
	 */
	EList<Specification> getSpecification();

	/**
	 * Returns the value of the '<em><b>Relationaltype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationaltype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationaltype</em>' reference.
	 * @see #setRelationaltype(RelationalType)
	 * @see CommonmodellPackage#getRelation_Relationaltype()
	 * @model required="true"
	 * @generated
	 */
	RelationalType getRelationaltype();

	/**
	 * Sets the value of the '{@link Relation#getRelationaltype <em>Relationaltype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationaltype</em>' reference.
	 * @see #getRelationaltype()
	 * @generated
	 */
	void setRelationaltype(RelationalType value);

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.commonmodell.Requirement}.
	 * It is bidirectional and its opposite is '{@link de.tuberlin.sqe.ss18.reqexchange.commonmodell.Requirement#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' reference list.
	 * @see CommonmodellPackage#getRelation_Requirements()
	 * @see de.tuberlin.sqe.ss18.reqexchange.commonmodell.Requirement#getRelations
	 * @model opposite="relations" required="true"
	 * @generated
	 */
	EList<Requirement> getRequirements();

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
	 * @see CommonmodellPackage#getRelation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Relation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Relation

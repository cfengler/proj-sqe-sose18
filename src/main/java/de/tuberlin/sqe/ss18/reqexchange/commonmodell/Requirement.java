/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Requirement#getPropertySets <em>Property Sets</em>}</li>
 *   <li>{@link Requirement#getRelations <em>Relations</em>}</li>
 *   <li>{@link Requirement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see CommonmodellPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends Identifiable {
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
	 * @see CommonmodellPackage#getRequirement_PropertySets()
	 * @model
	 * @generated
	 */
	EList<PropertySet> getPropertySets();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' reference list.
	 * The list contents are of type {@link Relation}.
	 * It is bidirectional and its opposite is '{@link Relation#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' reference list.
	 * @see CommonmodellPackage#getRequirement_Relations()
	 * @see Relation#getRequirements
	 * @model opposite="requirements"
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
	 * @see CommonmodellPackage#getRequirement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Requirement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Requirement

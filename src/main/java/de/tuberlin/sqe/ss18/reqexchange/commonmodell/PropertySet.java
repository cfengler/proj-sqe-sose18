/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PropertySet#getPropertys <em>Propertys</em>}</li>
 * </ul>
 *
 * @see CommonmodellPackage#getPropertySet()
 * @model
 * @generated
 */
public interface PropertySet extends Identifiable {
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
	 * @see CommonmodellPackage#getPropertySet_Propertys()
	 * @model required="true"
	 * @generated
	 */
	EList<Property> getPropertys();

} // PropertySet

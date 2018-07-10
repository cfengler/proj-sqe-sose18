/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.xlsx;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worksheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Worksheet#getRows <em>Rows</em>}</li>
 * </ul>
 *
 * @see ExcelmodelPackage#getWorksheet()
 * @model
 * @generated
 */
public interface Worksheet extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
	 * The list contents are of type {@link Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' containment reference list.
	 * @see ExcelmodelPackage#getWorksheet_Rows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Row> getRows();

} // Worksheet

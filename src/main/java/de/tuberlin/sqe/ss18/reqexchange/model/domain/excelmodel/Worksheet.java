/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel;

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
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Worksheet#getRows <em>Rows</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getWorksheet()
 * @model
 * @generated
 */
public interface Worksheet extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
	 * The list contents are of type {@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' containment reference list.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage#getWorksheet_Rows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Row> getRows();

} // Worksheet

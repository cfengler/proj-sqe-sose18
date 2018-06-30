/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.Cell;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl.CellImpl#getColumnIndex <em>Column Index</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl.CellImpl#getRowIndex <em>Row Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CellImpl extends MinimalEObjectImpl.Container implements Cell {
	/**
	 * The default value of the '{@link #getColumnIndex() <em>Column Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColumnIndex() <em>Column Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnIndex()
	 * @generated
	 * @ordered
	 */
	protected int columnIndex = COLUMN_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getRowIndex() <em>Row Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int ROW_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRowIndex() <em>Row Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowIndex()
	 * @generated
	 * @ordered
	 */
	protected int rowIndex = ROW_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelmodelPackage.Literals.CELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumnIndex() {
		return columnIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnIndex(int newColumnIndex) {
		int oldColumnIndex = columnIndex;
		columnIndex = newColumnIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelmodelPackage.CELL__COLUMN_INDEX, oldColumnIndex,
					columnIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRowIndex() {
		return rowIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRowIndex(int newRowIndex) {
		int oldRowIndex = rowIndex;
		rowIndex = newRowIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelmodelPackage.CELL__ROW_INDEX, oldRowIndex,
					rowIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelmodelPackage.CELL__COLUMN_INDEX:
			return getColumnIndex();
		case ExcelmodelPackage.CELL__ROW_INDEX:
			return getRowIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExcelmodelPackage.CELL__COLUMN_INDEX:
			setColumnIndex((Integer) newValue);
			return;
		case ExcelmodelPackage.CELL__ROW_INDEX:
			setRowIndex((Integer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ExcelmodelPackage.CELL__COLUMN_INDEX:
			setColumnIndex(COLUMN_INDEX_EDEFAULT);
			return;
		case ExcelmodelPackage.CELL__ROW_INDEX:
			setRowIndex(ROW_INDEX_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ExcelmodelPackage.CELL__COLUMN_INDEX:
			return columnIndex != COLUMN_INDEX_EDEFAULT;
		case ExcelmodelPackage.CELL__ROW_INDEX:
			return rowIndex != ROW_INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (columnIndex: ");
		result.append(columnIndex);
		result.append(", rowIndex: ");
		result.append(rowIndex);
		result.append(')');
		return result.toString();
	}

} //CellImpl

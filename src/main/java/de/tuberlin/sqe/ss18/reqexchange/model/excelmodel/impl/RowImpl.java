/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell;
import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelPackage;
import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.RowImpl#getCells <em>Cells</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.impl.RowImpl#getRowNum <em>Row Num</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RowImpl extends MinimalEObjectImpl.Container implements Row {
	/**
	 * The cached value of the '{@link #getCells() <em>Cells</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCells()
	 * @generated
	 * @ordered
	 */
	protected EList<Cell> cells;

	/**
	 * The default value of the '{@link #getRowNum() <em>Row Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowNum()
	 * @generated
	 * @ordered
	 */
	protected static final int ROW_NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRowNum() <em>Row Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRowNum()
	 * @generated
	 * @ordered
	 */
	protected int rowNum = ROW_NUM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelmodelPackage.Literals.ROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cell> getCells() {
		if (cells == null) {
			cells = new EObjectContainmentEList<Cell>(Cell.class, this, ExcelmodelPackage.ROW__CELLS);
		}
		return cells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRowNum() {
		return rowNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRowNum(int newRowNum) {
		int oldRowNum = rowNum;
		rowNum = newRowNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelmodelPackage.ROW__ROW_NUM, oldRowNum, rowNum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExcelmodelPackage.ROW__CELLS:
			return ((InternalEList<?>) getCells()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelmodelPackage.ROW__CELLS:
			return getCells();
		case ExcelmodelPackage.ROW__ROW_NUM:
			return getRowNum();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExcelmodelPackage.ROW__CELLS:
			getCells().clear();
			getCells().addAll((Collection<? extends Cell>) newValue);
			return;
		case ExcelmodelPackage.ROW__ROW_NUM:
			setRowNum((Integer) newValue);
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
		case ExcelmodelPackage.ROW__CELLS:
			getCells().clear();
			return;
		case ExcelmodelPackage.ROW__ROW_NUM:
			setRowNum(ROW_NUM_EDEFAULT);
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
		case ExcelmodelPackage.ROW__CELLS:
			return cells != null && !cells.isEmpty();
		case ExcelmodelPackage.ROW__ROW_NUM:
			return rowNum != ROW_NUM_EDEFAULT;
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
		result.append(" (rowNum: ");
		result.append(rowNum);
		result.append(')');
		return result.toString();
	}

} //RowImpl

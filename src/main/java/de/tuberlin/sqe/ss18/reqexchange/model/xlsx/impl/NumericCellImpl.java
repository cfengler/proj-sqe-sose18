/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.xlsx.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.xlsx.ExcelmodelPackage;
import de.tuberlin.sqe.ss18.reqexchange.model.xlsx.NumericCell;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.xlsx.impl.NumericCellImpl#getNumericValue <em>Numeric Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericCellImpl extends CellImpl implements NumericCell {
	/**
	 * The default value of the '{@link #getNumericValue() <em>Numeric Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericValue()
	 * @generated
	 * @ordered
	 */
	protected static final double NUMERIC_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNumericValue() <em>Numeric Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericValue()
	 * @generated
	 * @ordered
	 */
	protected double numericValue = NUMERIC_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericCellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelmodelPackage.Literals.NUMERIC_CELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNumericValue() {
		return numericValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumericValue(double newNumericValue) {
		double oldNumericValue = numericValue;
		numericValue = newNumericValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelmodelPackage.NUMERIC_CELL__NUMERIC_VALUE,
					oldNumericValue, numericValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelmodelPackage.NUMERIC_CELL__NUMERIC_VALUE:
			return getNumericValue();
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
		case ExcelmodelPackage.NUMERIC_CELL__NUMERIC_VALUE:
			setNumericValue((Double) newValue);
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
		case ExcelmodelPackage.NUMERIC_CELL__NUMERIC_VALUE:
			setNumericValue(NUMERIC_VALUE_EDEFAULT);
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
		case ExcelmodelPackage.NUMERIC_CELL__NUMERIC_VALUE:
			return numericValue != NUMERIC_VALUE_EDEFAULT;
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
		result.append(" (NumericValue: ");
		result.append(numericValue);
		result.append(')');
		return result.toString();
	}

} //NumericCellImpl

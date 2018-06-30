/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.EnumCell;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.ExcelmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl.EnumCellImpl#getEnums <em>Enums</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.excelmodel.impl.EnumCellImpl#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumCellImpl extends CellImpl implements EnumCell {
	/**
	 * The default value of the '{@link #getEnums() <em>Enums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnums()
	 * @generated
	 * @ordered
	 */
	protected static final Enumerator ENUMS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnums() <em>Enums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnums()
	 * @generated
	 * @ordered
	 */
	protected Enumerator enums = ENUMS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumValue() <em>Enum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumValue()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumValue() <em>Enum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumValue()
	 * @generated
	 * @ordered
	 */
	protected String enumValue = ENUM_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumCellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelmodelPackage.Literals.ENUM_CELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerator getEnums() {
		return enums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnums(Enumerator newEnums) {
		Enumerator oldEnums = enums;
		enums = newEnums;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelmodelPackage.ENUM_CELL__ENUMS, oldEnums, enums));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnumValue() {
		return enumValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumValue(String newEnumValue) {
		String oldEnumValue = enumValue;
		enumValue = newEnumValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelmodelPackage.ENUM_CELL__ENUM_VALUE, oldEnumValue,
					enumValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelmodelPackage.ENUM_CELL__ENUMS:
			return getEnums();
		case ExcelmodelPackage.ENUM_CELL__ENUM_VALUE:
			return getEnumValue();
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
		case ExcelmodelPackage.ENUM_CELL__ENUMS:
			setEnums((Enumerator) newValue);
			return;
		case ExcelmodelPackage.ENUM_CELL__ENUM_VALUE:
			setEnumValue((String) newValue);
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
		case ExcelmodelPackage.ENUM_CELL__ENUMS:
			setEnums(ENUMS_EDEFAULT);
			return;
		case ExcelmodelPackage.ENUM_CELL__ENUM_VALUE:
			setEnumValue(ENUM_VALUE_EDEFAULT);
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
		case ExcelmodelPackage.ENUM_CELL__ENUMS:
			return ENUMS_EDEFAULT == null ? enums != null : !ENUMS_EDEFAULT.equals(enums);
		case ExcelmodelPackage.ENUM_CELL__ENUM_VALUE:
			return ENUM_VALUE_EDEFAULT == null ? enumValue != null : !ENUM_VALUE_EDEFAULT.equals(enumValue);
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
		result.append(" (Enums: ");
		result.append(enums);
		result.append(", EnumValue: ");
		result.append(enumValue);
		result.append(')');
		return result.toString();
	}

} //EnumCellImpl

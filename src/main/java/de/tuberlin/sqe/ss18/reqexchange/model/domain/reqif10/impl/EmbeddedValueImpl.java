/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.EmbeddedValue;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Embedded Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.EmbeddedValueImpl#getKey <em>Key</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.EmbeddedValueImpl#getOtherContent <em>Other Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmbeddedValueImpl extends MinimalEObjectImpl.Container implements EmbeddedValue {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected BigInteger key = KEY_EDEFAULT;

	/**
	 * This is true if the Key attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean keyESet;

	/**
	 * The default value of the '{@link #getOtherContent() <em>Other Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherContent()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherContent() <em>Other Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherContent()
	 * @generated
	 * @ordered
	 */
	protected String otherContent = OTHER_CONTENT_EDEFAULT;

	/**
	 * This is true if the Other Content attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean otherContentESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmbeddedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Reqif10Package.Literals.EMBEDDED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(BigInteger newKey) {
		BigInteger oldKey = key;
		key = newKey;
		boolean oldKeyESet = keyESet;
		keyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.EMBEDDED_VALUE__KEY, oldKey, key, !oldKeyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKey() {
		BigInteger oldKey = key;
		boolean oldKeyESet = keyESet;
		key = KEY_EDEFAULT;
		keyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.EMBEDDED_VALUE__KEY, oldKey, KEY_EDEFAULT, oldKeyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKey() {
		return keyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOtherContent() {
		return otherContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherContent(String newOtherContent) {
		String oldOtherContent = otherContent;
		otherContent = newOtherContent;
		boolean oldOtherContentESet = otherContentESet;
		otherContentESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.EMBEDDED_VALUE__OTHER_CONTENT, oldOtherContent, otherContent, !oldOtherContentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOtherContent() {
		String oldOtherContent = otherContent;
		boolean oldOtherContentESet = otherContentESet;
		otherContent = OTHER_CONTENT_EDEFAULT;
		otherContentESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.EMBEDDED_VALUE__OTHER_CONTENT, oldOtherContent, OTHER_CONTENT_EDEFAULT, oldOtherContentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOtherContent() {
		return otherContentESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Reqif10Package.EMBEDDED_VALUE__KEY:
				return getKey();
			case Reqif10Package.EMBEDDED_VALUE__OTHER_CONTENT:
				return getOtherContent();
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
			case Reqif10Package.EMBEDDED_VALUE__KEY:
				setKey((BigInteger)newValue);
				return;
			case Reqif10Package.EMBEDDED_VALUE__OTHER_CONTENT:
				setOtherContent((String)newValue);
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
			case Reqif10Package.EMBEDDED_VALUE__KEY:
				unsetKey();
				return;
			case Reqif10Package.EMBEDDED_VALUE__OTHER_CONTENT:
				unsetOtherContent();
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
			case Reqif10Package.EMBEDDED_VALUE__KEY:
				return isSetKey();
			case Reqif10Package.EMBEDDED_VALUE__OTHER_CONTENT:
				return isSetOtherContent();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (key: ");
		if (keyESet) result.append(key); else result.append("<unset>");
		result.append(", otherContent: ");
		if (otherContentESet) result.append(otherContent); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EmbeddedValueImpl

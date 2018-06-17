/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.XhtmlContent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xhtml Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.XhtmlContentImpl#getXhtml <em>Xhtml</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.XhtmlContentImpl#getXhtmlSource <em>Xhtml Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XhtmlContentImpl extends MinimalEObjectImpl.Container implements XhtmlContent {
	/**
	 * The cached value of the '{@link #getXhtml() <em>Xhtml</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXhtml()
	 * @generated
	 * @ordered
	 */
	protected EObject xhtml;

	/**
	 * This is true if the Xhtml containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean xhtmlESet;

	/**
	 * The default value of the '{@link #getXhtmlSource() <em>Xhtml Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXhtmlSource()
	 * @generated
	 * @ordered
	 */
	protected static final String XHTML_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXhtmlSource() <em>Xhtml Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXhtmlSource()
	 * @generated
	 * @ordered
	 */
	protected String xhtmlSource = XHTML_SOURCE_EDEFAULT;

	/**
	 * This is true if the Xhtml Source attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean xhtmlSourceESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XhtmlContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Reqif10Package.Literals.XHTML_CONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getXhtml() {
		return xhtml;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXhtml(EObject newXhtml, NotificationChain msgs) {
		EObject oldXhtml = xhtml;
		xhtml = newXhtml;
		boolean oldXhtmlESet = xhtmlESet;
		xhtmlESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Reqif10Package.XHTML_CONTENT__XHTML, oldXhtml, newXhtml, !oldXhtmlESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXhtml(EObject newXhtml) {
		if (newXhtml != xhtml) {
			NotificationChain msgs = null;
			if (xhtml != null)
				msgs = ((InternalEObject)xhtml).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Reqif10Package.XHTML_CONTENT__XHTML, null, msgs);
			if (newXhtml != null)
				msgs = ((InternalEObject)newXhtml).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Reqif10Package.XHTML_CONTENT__XHTML, null, msgs);
			msgs = basicSetXhtml(newXhtml, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldXhtmlESet = xhtmlESet;
			xhtmlESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.XHTML_CONTENT__XHTML, newXhtml, newXhtml, !oldXhtmlESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetXhtml(NotificationChain msgs) {
		EObject oldXhtml = xhtml;
		xhtml = null;
		boolean oldXhtmlESet = xhtmlESet;
		xhtmlESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, Reqif10Package.XHTML_CONTENT__XHTML, oldXhtml, null, oldXhtmlESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetXhtml() {
		if (xhtml != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)xhtml).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Reqif10Package.XHTML_CONTENT__XHTML, null, msgs);
			msgs = basicUnsetXhtml(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldXhtmlESet = xhtmlESet;
			xhtmlESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.XHTML_CONTENT__XHTML, null, null, oldXhtmlESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetXhtml() {
		return xhtmlESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXhtmlSource() {
		return xhtmlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXhtmlSource(String newXhtmlSource) {
		String oldXhtmlSource = xhtmlSource;
		xhtmlSource = newXhtmlSource;
		boolean oldXhtmlSourceESet = xhtmlSourceESet;
		xhtmlSourceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.XHTML_CONTENT__XHTML_SOURCE, oldXhtmlSource, xhtmlSource, !oldXhtmlSourceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetXhtmlSource() {
		String oldXhtmlSource = xhtmlSource;
		boolean oldXhtmlSourceESet = xhtmlSourceESet;
		xhtmlSource = XHTML_SOURCE_EDEFAULT;
		xhtmlSourceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.XHTML_CONTENT__XHTML_SOURCE, oldXhtmlSource, XHTML_SOURCE_EDEFAULT, oldXhtmlSourceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetXhtmlSource() {
		return xhtmlSourceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Reqif10Package.XHTML_CONTENT__XHTML:
				return basicUnsetXhtml(msgs);
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
			case Reqif10Package.XHTML_CONTENT__XHTML:
				return getXhtml();
			case Reqif10Package.XHTML_CONTENT__XHTML_SOURCE:
				return getXhtmlSource();
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
			case Reqif10Package.XHTML_CONTENT__XHTML:
				setXhtml((EObject)newValue);
				return;
			case Reqif10Package.XHTML_CONTENT__XHTML_SOURCE:
				setXhtmlSource((String)newValue);
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
			case Reqif10Package.XHTML_CONTENT__XHTML:
				unsetXhtml();
				return;
			case Reqif10Package.XHTML_CONTENT__XHTML_SOURCE:
				unsetXhtmlSource();
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
			case Reqif10Package.XHTML_CONTENT__XHTML:
				return isSetXhtml();
			case Reqif10Package.XHTML_CONTENT__XHTML_SOURCE:
				return isSetXhtmlSource();
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
		result.append(" (xhtmlSource: ");
		if (xhtmlSourceESet) result.append(xhtmlSource); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //XhtmlContentImpl

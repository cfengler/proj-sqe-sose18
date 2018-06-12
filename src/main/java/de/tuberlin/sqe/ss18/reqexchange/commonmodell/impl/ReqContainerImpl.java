/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell.impl;

import de.tuberlin.sqe.ss18.reqexchange.commonmodell.CommonmodellPackage;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.ReqContainer;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.Requirement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Req Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ReqContainerImpl#getReqContainerChilds <em>Req Container Childs</em>}</li>
 *   <li>{@link ReqContainerImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link ReqContainerImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReqContainerImpl extends IdentifiableImpl implements ReqContainer {
	/**
	 * The cached value of the '{@link #getReqContainerChilds() <em>Req Container Childs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqContainerChilds()
	 * @generated
	 * @ordered
	 */
	protected EList<ReqContainer> reqContainerChilds;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirements;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReqContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonmodellPackage.Literals.REQ_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReqContainer> getReqContainerChilds() {
		if (reqContainerChilds == null) {
			reqContainerChilds = new EObjectResolvingEList<ReqContainer>(ReqContainer.class, this,
					CommonmodellPackage.REQ_CONTAINER__REQ_CONTAINER_CHILDS);
		}
		return reqContainerChilds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectResolvingEList<Requirement>(Requirement.class, this,
					CommonmodellPackage.REQ_CONTAINER__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonmodellPackage.REQ_CONTAINER__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CommonmodellPackage.REQ_CONTAINER__REQ_CONTAINER_CHILDS:
			return getReqContainerChilds();
		case CommonmodellPackage.REQ_CONTAINER__REQUIREMENTS:
			return getRequirements();
		case CommonmodellPackage.REQ_CONTAINER__NAME:
			return getName();
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
		case CommonmodellPackage.REQ_CONTAINER__REQ_CONTAINER_CHILDS:
			getReqContainerChilds().clear();
			getReqContainerChilds().addAll((Collection<? extends ReqContainer>) newValue);
			return;
		case CommonmodellPackage.REQ_CONTAINER__REQUIREMENTS:
			getRequirements().clear();
			getRequirements().addAll((Collection<? extends Requirement>) newValue);
			return;
		case CommonmodellPackage.REQ_CONTAINER__NAME:
			setName((String) newValue);
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
		case CommonmodellPackage.REQ_CONTAINER__REQ_CONTAINER_CHILDS:
			getReqContainerChilds().clear();
			return;
		case CommonmodellPackage.REQ_CONTAINER__REQUIREMENTS:
			getRequirements().clear();
			return;
		case CommonmodellPackage.REQ_CONTAINER__NAME:
			setName(NAME_EDEFAULT);
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
		case CommonmodellPackage.REQ_CONTAINER__REQ_CONTAINER_CHILDS:
			return reqContainerChilds != null && !reqContainerChilds.isEmpty();
		case CommonmodellPackage.REQ_CONTAINER__REQUIREMENTS:
			return requirements != null && !requirements.isEmpty();
		case CommonmodellPackage.REQ_CONTAINER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ReqContainerImpl

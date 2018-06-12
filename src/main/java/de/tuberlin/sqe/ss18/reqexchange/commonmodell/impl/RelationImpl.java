/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell.impl;

import de.tuberlin.sqe.ss18.reqexchange.commonmodell.CommonmodellPackage;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.ContentObject;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.Property;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.Relation;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.RelationalType;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.Requirement;
import de.tuberlin.sqe.ss18.reqexchange.commonmodell.Specification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link RelationImpl#getPropertys <em>Propertys</em>}</li>
 *   <li>{@link RelationImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link RelationImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link RelationImpl#getRelationaltype <em>Relationaltype</em>}</li>
 *   <li>{@link RelationImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link RelationImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends IdentifiableImpl implements Relation {
	/**
	 * The cached value of the '{@link #getPropertys() <em>Propertys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> propertys;

	/**
	 * The cached value of the '{@link #getContentObjects() <em>Content Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ContentObject> contentObjects;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<Specification> specification;

	/**
	 * The cached value of the '{@link #getRelationaltype() <em>Relationaltype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationaltype()
	 * @generated
	 * @ordered
	 */
	protected RelationalType relationaltype;

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
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonmodellPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getPropertys() {
		if (propertys == null) {
			propertys = new EObjectResolvingEList<Property>(Property.class, this,
					CommonmodellPackage.RELATION__PROPERTYS);
		}
		return propertys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContentObject> getContentObjects() {
		if (contentObjects == null) {
			contentObjects = new EObjectResolvingEList<ContentObject>(ContentObject.class, this,
					CommonmodellPackage.RELATION__CONTENT_OBJECTS);
		}
		return contentObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Specification> getSpecification() {
		if (specification == null) {
			specification = new EObjectWithInverseResolvingEList.ManyInverse<Specification>(Specification.class, this,
					CommonmodellPackage.RELATION__SPECIFICATION, CommonmodellPackage.SPECIFICATION__RELATIONS);
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalType getRelationaltype() {
		if (relationaltype != null && relationaltype.eIsProxy()) {
			InternalEObject oldRelationaltype = (InternalEObject) relationaltype;
			relationaltype = (RelationalType) eResolveProxy(oldRelationaltype);
			if (relationaltype != oldRelationaltype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CommonmodellPackage.RELATION__RELATIONALTYPE, oldRelationaltype, relationaltype));
			}
		}
		return relationaltype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalType basicGetRelationaltype() {
		return relationaltype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationaltype(RelationalType newRelationaltype) {
		RelationalType oldRelationaltype = relationaltype;
		relationaltype = newRelationaltype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonmodellPackage.RELATION__RELATIONALTYPE,
					oldRelationaltype, relationaltype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectWithInverseResolvingEList.ManyInverse<Requirement>(Requirement.class, this,
					CommonmodellPackage.RELATION__REQUIREMENTS, CommonmodellPackage.REQUIREMENT__RELATIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonmodellPackage.RELATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CommonmodellPackage.RELATION__SPECIFICATION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSpecification()).basicAdd(otherEnd, msgs);
		case CommonmodellPackage.RELATION__REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequirements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CommonmodellPackage.RELATION__SPECIFICATION:
			return ((InternalEList<?>) getSpecification()).basicRemove(otherEnd, msgs);
		case CommonmodellPackage.RELATION__REQUIREMENTS:
			return ((InternalEList<?>) getRequirements()).basicRemove(otherEnd, msgs);
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
		case CommonmodellPackage.RELATION__PROPERTYS:
			return getPropertys();
		case CommonmodellPackage.RELATION__CONTENT_OBJECTS:
			return getContentObjects();
		case CommonmodellPackage.RELATION__SPECIFICATION:
			return getSpecification();
		case CommonmodellPackage.RELATION__RELATIONALTYPE:
			if (resolve)
				return getRelationaltype();
			return basicGetRelationaltype();
		case CommonmodellPackage.RELATION__REQUIREMENTS:
			return getRequirements();
		case CommonmodellPackage.RELATION__NAME:
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
		case CommonmodellPackage.RELATION__PROPERTYS:
			getPropertys().clear();
			getPropertys().addAll((Collection<? extends Property>) newValue);
			return;
		case CommonmodellPackage.RELATION__CONTENT_OBJECTS:
			getContentObjects().clear();
			getContentObjects().addAll((Collection<? extends ContentObject>) newValue);
			return;
		case CommonmodellPackage.RELATION__SPECIFICATION:
			getSpecification().clear();
			getSpecification().addAll((Collection<? extends Specification>) newValue);
			return;
		case CommonmodellPackage.RELATION__RELATIONALTYPE:
			setRelationaltype((RelationalType) newValue);
			return;
		case CommonmodellPackage.RELATION__REQUIREMENTS:
			getRequirements().clear();
			getRequirements().addAll((Collection<? extends Requirement>) newValue);
			return;
		case CommonmodellPackage.RELATION__NAME:
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
		case CommonmodellPackage.RELATION__PROPERTYS:
			getPropertys().clear();
			return;
		case CommonmodellPackage.RELATION__CONTENT_OBJECTS:
			getContentObjects().clear();
			return;
		case CommonmodellPackage.RELATION__SPECIFICATION:
			getSpecification().clear();
			return;
		case CommonmodellPackage.RELATION__RELATIONALTYPE:
			setRelationaltype((RelationalType) null);
			return;
		case CommonmodellPackage.RELATION__REQUIREMENTS:
			getRequirements().clear();
			return;
		case CommonmodellPackage.RELATION__NAME:
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
		case CommonmodellPackage.RELATION__PROPERTYS:
			return propertys != null && !propertys.isEmpty();
		case CommonmodellPackage.RELATION__CONTENT_OBJECTS:
			return contentObjects != null && !contentObjects.isEmpty();
		case CommonmodellPackage.RELATION__SPECIFICATION:
			return specification != null && !specification.isEmpty();
		case CommonmodellPackage.RELATION__RELATIONALTYPE:
			return relationaltype != null;
		case CommonmodellPackage.RELATION__REQUIREMENTS:
			return requirements != null && !requirements.isEmpty();
		case CommonmodellPackage.RELATION__NAME:
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

} //RelationImpl

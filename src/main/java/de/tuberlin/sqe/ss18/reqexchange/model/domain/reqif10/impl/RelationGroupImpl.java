/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroup;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.RelationGroupType;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecRelation;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Specification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.RelationGroupImpl#getSpecRelations <em>Spec Relations</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.RelationGroupImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.RelationGroupImpl#getSourceSpecification <em>Source Specification</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.RelationGroupImpl#getTargetSpecification <em>Target Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationGroupImpl extends IdentifiableImpl implements RelationGroup {
	/**
	 * The cached value of the '{@link #getSpecRelations() <em>Spec Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecRelation> specRelations;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected RelationGroupType type;

	/**
	 * This is true if the Type reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * The cached value of the '{@link #getSourceSpecification() <em>Source Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceSpecification()
	 * @generated
	 * @ordered
	 */
	protected Specification sourceSpecification;

	/**
	 * This is true if the Source Specification reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sourceSpecificationESet;

	/**
	 * The cached value of the '{@link #getTargetSpecification() <em>Target Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSpecification()
	 * @generated
	 * @ordered
	 */
	protected Specification targetSpecification;

	/**
	 * This is true if the Target Specification reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean targetSpecificationESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Reqif10Package.Literals.RELATION_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecRelation> getSpecRelations() {
		if (specRelations == null) {
			specRelations = new EObjectResolvingEList.Unsettable<SpecRelation>(SpecRelation.class, this, Reqif10Package.RELATION_GROUP__SPEC_RELATIONS);
		}
		return specRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecRelations() {
		if (specRelations != null) ((InternalEList.Unsettable<?>)specRelations).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecRelations() {
		return specRelations != null && ((InternalEList.Unsettable<?>)specRelations).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationGroupType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (RelationGroupType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Reqif10Package.RELATION_GROUP__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationGroupType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(RelationGroupType newType) {
		RelationGroupType oldType = type;
		type = newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.RELATION_GROUP__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		RelationGroupType oldType = type;
		boolean oldTypeESet = typeESet;
		type = null;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.RELATION_GROUP__TYPE, oldType, null, oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getSourceSpecification() {
		if (sourceSpecification != null && sourceSpecification.eIsProxy()) {
			InternalEObject oldSourceSpecification = (InternalEObject)sourceSpecification;
			sourceSpecification = (Specification)eResolveProxy(oldSourceSpecification);
			if (sourceSpecification != oldSourceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION, oldSourceSpecification, sourceSpecification));
			}
		}
		return sourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification basicGetSourceSpecification() {
		return sourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceSpecification(Specification newSourceSpecification) {
		Specification oldSourceSpecification = sourceSpecification;
		sourceSpecification = newSourceSpecification;
		boolean oldSourceSpecificationESet = sourceSpecificationESet;
		sourceSpecificationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION, oldSourceSpecification, sourceSpecification, !oldSourceSpecificationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSourceSpecification() {
		Specification oldSourceSpecification = sourceSpecification;
		boolean oldSourceSpecificationESet = sourceSpecificationESet;
		sourceSpecification = null;
		sourceSpecificationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION, oldSourceSpecification, null, oldSourceSpecificationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSourceSpecification() {
		return sourceSpecificationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getTargetSpecification() {
		if (targetSpecification != null && targetSpecification.eIsProxy()) {
			InternalEObject oldTargetSpecification = (InternalEObject)targetSpecification;
			targetSpecification = (Specification)eResolveProxy(oldTargetSpecification);
			if (targetSpecification != oldTargetSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION, oldTargetSpecification, targetSpecification));
			}
		}
		return targetSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification basicGetTargetSpecification() {
		return targetSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSpecification(Specification newTargetSpecification) {
		Specification oldTargetSpecification = targetSpecification;
		targetSpecification = newTargetSpecification;
		boolean oldTargetSpecificationESet = targetSpecificationESet;
		targetSpecificationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION, oldTargetSpecification, targetSpecification, !oldTargetSpecificationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetSpecification() {
		Specification oldTargetSpecification = targetSpecification;
		boolean oldTargetSpecificationESet = targetSpecificationESet;
		targetSpecification = null;
		targetSpecificationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION, oldTargetSpecification, null, oldTargetSpecificationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetSpecification() {
		return targetSpecificationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Reqif10Package.RELATION_GROUP__SPEC_RELATIONS:
				return getSpecRelations();
			case Reqif10Package.RELATION_GROUP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION:
				if (resolve) return getSourceSpecification();
				return basicGetSourceSpecification();
			case Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION:
				if (resolve) return getTargetSpecification();
				return basicGetTargetSpecification();
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
			case Reqif10Package.RELATION_GROUP__SPEC_RELATIONS:
				getSpecRelations().clear();
				getSpecRelations().addAll((Collection<? extends SpecRelation>)newValue);
				return;
			case Reqif10Package.RELATION_GROUP__TYPE:
				setType((RelationGroupType)newValue);
				return;
			case Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION:
				setSourceSpecification((Specification)newValue);
				return;
			case Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION:
				setTargetSpecification((Specification)newValue);
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
			case Reqif10Package.RELATION_GROUP__SPEC_RELATIONS:
				unsetSpecRelations();
				return;
			case Reqif10Package.RELATION_GROUP__TYPE:
				unsetType();
				return;
			case Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION:
				unsetSourceSpecification();
				return;
			case Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION:
				unsetTargetSpecification();
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
			case Reqif10Package.RELATION_GROUP__SPEC_RELATIONS:
				return isSetSpecRelations();
			case Reqif10Package.RELATION_GROUP__TYPE:
				return isSetType();
			case Reqif10Package.RELATION_GROUP__SOURCE_SPECIFICATION:
				return isSetSourceSpecification();
			case Reqif10Package.RELATION_GROUP__TARGET_SPECIFICATION:
				return isSetTargetSpecification();
		}
		return super.eIsSet(featureID);
	}

} //RelationGroupImpl

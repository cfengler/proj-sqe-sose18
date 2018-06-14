/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataType;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.PropertySet;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.commonPackage;

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
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getReqContainer <em>Req Container</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getPropertySets <em>Property Sets</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getOtherSpecification <em>Other Specification</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getRelationTypes <em>Relation Types</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl#getPropertys <em>Propertys</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificationImpl extends IdentifiableImpl implements Specification {
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
	 * The cached value of the '{@link #getReqContainer() <em>Req Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ReqContainer> reqContainer;

	/**
	 * The cached value of the '{@link #getPropertySets() <em>Property Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertySets()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertySet> propertySets;

	/**
	 * The cached value of the '{@link #getOtherSpecification() <em>Other Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<Specification> otherSpecification;

	/**
	 * The cached value of the '{@link #getDatatypes() <em>Datatypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> datatypes;

	/**
	 * The cached value of the '{@link #getRelationTypes() <em>Relation Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationalType> relationTypes;

	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relations;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return commonPackage.Literals.SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContentObject> getContentObjects() {
		if (contentObjects == null) {
			contentObjects = new EObjectResolvingEList<ContentObject>(ContentObject.class, this,
					commonPackage.SPECIFICATION__CONTENT_OBJECTS);
		}
		return contentObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReqContainer> getReqContainer() {
		if (reqContainer == null) {
			reqContainer = new EObjectResolvingEList<ReqContainer>(ReqContainer.class, this,
					commonPackage.SPECIFICATION__REQ_CONTAINER);
		}
		return reqContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertySet> getPropertySets() {
		if (propertySets == null) {
			propertySets = new EObjectResolvingEList<PropertySet>(PropertySet.class, this,
					commonPackage.SPECIFICATION__PROPERTY_SETS);
		}
		return propertySets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Specification> getOtherSpecification() {
		if (otherSpecification == null) {
			otherSpecification = new EObjectResolvingEList<Specification>(Specification.class, this,
					commonPackage.SPECIFICATION__OTHER_SPECIFICATION);
		}
		return otherSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDatatypes() {
		if (datatypes == null) {
			datatypes = new EObjectResolvingEList<DataType>(DataType.class, this,
					commonPackage.SPECIFICATION__DATATYPES);
		}
		return datatypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RelationalType> getRelationTypes() {
		if (relationTypes == null) {
			relationTypes = new EObjectResolvingEList<RelationalType>(RelationalType.class, this,
					commonPackage.SPECIFICATION__RELATION_TYPES);
		}
		return relationTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelations() {
		if (relations == null) {
			relations = new EObjectWithInverseResolvingEList.ManyInverse<Relation>(Relation.class, this,
					commonPackage.SPECIFICATION__RELATIONS, commonPackage.RELATION__SPECIFICATION);
		}
		return relations;
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
			eNotify(new ENotificationImpl(this, Notification.SET, commonPackage.SPECIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, commonPackage.SPECIFICATION__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getPropertys() {
		if (propertys == null) {
			propertys = new EObjectResolvingEList<Property>(Property.class, this,
					commonPackage.SPECIFICATION__PROPERTYS);
		}
		return propertys;
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
		case commonPackage.SPECIFICATION__RELATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRelations()).basicAdd(otherEnd, msgs);
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
		case commonPackage.SPECIFICATION__RELATIONS:
			return ((InternalEList<?>) getRelations()).basicRemove(otherEnd, msgs);
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
		case commonPackage.SPECIFICATION__CONTENT_OBJECTS:
			return getContentObjects();
		case commonPackage.SPECIFICATION__REQ_CONTAINER:
			return getReqContainer();
		case commonPackage.SPECIFICATION__PROPERTY_SETS:
			return getPropertySets();
		case commonPackage.SPECIFICATION__OTHER_SPECIFICATION:
			return getOtherSpecification();
		case commonPackage.SPECIFICATION__DATATYPES:
			return getDatatypes();
		case commonPackage.SPECIFICATION__RELATION_TYPES:
			return getRelationTypes();
		case commonPackage.SPECIFICATION__RELATIONS:
			return getRelations();
		case commonPackage.SPECIFICATION__NAME:
			return getName();
		case commonPackage.SPECIFICATION__DESCRIPTION:
			return getDescription();
		case commonPackage.SPECIFICATION__PROPERTYS:
			return getPropertys();
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
		case commonPackage.SPECIFICATION__CONTENT_OBJECTS:
			getContentObjects().clear();
			getContentObjects().addAll((Collection<? extends ContentObject>) newValue);
			return;
		case commonPackage.SPECIFICATION__REQ_CONTAINER:
			getReqContainer().clear();
			getReqContainer().addAll((Collection<? extends ReqContainer>) newValue);
			return;
		case commonPackage.SPECIFICATION__PROPERTY_SETS:
			getPropertySets().clear();
			getPropertySets().addAll((Collection<? extends PropertySet>) newValue);
			return;
		case commonPackage.SPECIFICATION__OTHER_SPECIFICATION:
			getOtherSpecification().clear();
			getOtherSpecification().addAll((Collection<? extends Specification>) newValue);
			return;
		case commonPackage.SPECIFICATION__DATATYPES:
			getDatatypes().clear();
			getDatatypes().addAll((Collection<? extends DataType>) newValue);
			return;
		case commonPackage.SPECIFICATION__RELATION_TYPES:
			getRelationTypes().clear();
			getRelationTypes().addAll((Collection<? extends RelationalType>) newValue);
			return;
		case commonPackage.SPECIFICATION__RELATIONS:
			getRelations().clear();
			getRelations().addAll((Collection<? extends Relation>) newValue);
			return;
		case commonPackage.SPECIFICATION__NAME:
			setName((String) newValue);
			return;
		case commonPackage.SPECIFICATION__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case commonPackage.SPECIFICATION__PROPERTYS:
			getPropertys().clear();
			getPropertys().addAll((Collection<? extends Property>) newValue);
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
		case commonPackage.SPECIFICATION__CONTENT_OBJECTS:
			getContentObjects().clear();
			return;
		case commonPackage.SPECIFICATION__REQ_CONTAINER:
			getReqContainer().clear();
			return;
		case commonPackage.SPECIFICATION__PROPERTY_SETS:
			getPropertySets().clear();
			return;
		case commonPackage.SPECIFICATION__OTHER_SPECIFICATION:
			getOtherSpecification().clear();
			return;
		case commonPackage.SPECIFICATION__DATATYPES:
			getDatatypes().clear();
			return;
		case commonPackage.SPECIFICATION__RELATION_TYPES:
			getRelationTypes().clear();
			return;
		case commonPackage.SPECIFICATION__RELATIONS:
			getRelations().clear();
			return;
		case commonPackage.SPECIFICATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case commonPackage.SPECIFICATION__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case commonPackage.SPECIFICATION__PROPERTYS:
			getPropertys().clear();
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
		case commonPackage.SPECIFICATION__CONTENT_OBJECTS:
			return contentObjects != null && !contentObjects.isEmpty();
		case commonPackage.SPECIFICATION__REQ_CONTAINER:
			return reqContainer != null && !reqContainer.isEmpty();
		case commonPackage.SPECIFICATION__PROPERTY_SETS:
			return propertySets != null && !propertySets.isEmpty();
		case commonPackage.SPECIFICATION__OTHER_SPECIFICATION:
			return otherSpecification != null && !otherSpecification.isEmpty();
		case commonPackage.SPECIFICATION__DATATYPES:
			return datatypes != null && !datatypes.isEmpty();
		case commonPackage.SPECIFICATION__RELATION_TYPES:
			return relationTypes != null && !relationTypes.isEmpty();
		case commonPackage.SPECIFICATION__RELATIONS:
			return relations != null && !relations.isEmpty();
		case commonPackage.SPECIFICATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case commonPackage.SPECIFICATION__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case commonPackage.SPECIFICATION__PROPERTYS:
			return propertys != null && !propertys.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //SpecificationImpl

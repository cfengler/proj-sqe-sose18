/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.AttributeDefinition;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecHierarchy;
import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.SpecObject;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.SpecHierarchyImpl#isTableInternal <em>Table Internal</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.SpecHierarchyImpl#getObject <em>Object</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.SpecHierarchyImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl.SpecHierarchyImpl#getEditableAtts <em>Editable Atts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecHierarchyImpl extends AccessControlledElementImpl implements SpecHierarchy {
	/**
	 * The default value of the '{@link #isTableInternal() <em>Table Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTableInternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TABLE_INTERNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTableInternal() <em>Table Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTableInternal()
	 * @generated
	 * @ordered
	 */
	protected boolean tableInternal = TABLE_INTERNAL_EDEFAULT;

	/**
	 * This is true if the Table Internal attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean tableInternalESet;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected SpecObject object;

	/**
	 * This is true if the Object reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean objectESet;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecHierarchy> children;

	/**
	 * The cached value of the '{@link #getEditableAtts() <em>Editable Atts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditableAtts()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeDefinition> editableAtts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecHierarchyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Reqif10Package.Literals.SPEC_HIERARCHY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTableInternal() {
		return tableInternal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableInternal(boolean newTableInternal) {
		boolean oldTableInternal = tableInternal;
		tableInternal = newTableInternal;
		boolean oldTableInternalESet = tableInternalESet;
		tableInternalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.SPEC_HIERARCHY__TABLE_INTERNAL, oldTableInternal, tableInternal, !oldTableInternalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTableInternal() {
		boolean oldTableInternal = tableInternal;
		boolean oldTableInternalESet = tableInternalESet;
		tableInternal = TABLE_INTERNAL_EDEFAULT;
		tableInternalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.SPEC_HIERARCHY__TABLE_INTERNAL, oldTableInternal, TABLE_INTERNAL_EDEFAULT, oldTableInternalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTableInternal() {
		return tableInternalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecObject getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = (SpecObject)eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Reqif10Package.SPEC_HIERARCHY__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecObject basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(SpecObject newObject) {
		SpecObject oldObject = object;
		object = newObject;
		boolean oldObjectESet = objectESet;
		objectESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Reqif10Package.SPEC_HIERARCHY__OBJECT, oldObject, object, !oldObjectESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObject() {
		SpecObject oldObject = object;
		boolean oldObjectESet = objectESet;
		object = null;
		objectESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Reqif10Package.SPEC_HIERARCHY__OBJECT, oldObject, null, oldObjectESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObject() {
		return objectESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecHierarchy> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList.Unsettable<SpecHierarchy>(SpecHierarchy.class, this, Reqif10Package.SPEC_HIERARCHY__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetChildren() {
		if (children != null) ((InternalEList.Unsettable<?>)children).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetChildren() {
		return children != null && ((InternalEList.Unsettable<?>)children).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeDefinition> getEditableAtts() {
		if (editableAtts == null) {
			editableAtts = new EObjectResolvingEList.Unsettable<AttributeDefinition>(AttributeDefinition.class, this, Reqif10Package.SPEC_HIERARCHY__EDITABLE_ATTS);
		}
		return editableAtts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditableAtts() {
		if (editableAtts != null) ((InternalEList.Unsettable<?>)editableAtts).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditableAtts() {
		return editableAtts != null && ((InternalEList.Unsettable<?>)editableAtts).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Reqif10Package.SPEC_HIERARCHY__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case Reqif10Package.SPEC_HIERARCHY__TABLE_INTERNAL:
				return isTableInternal();
			case Reqif10Package.SPEC_HIERARCHY__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case Reqif10Package.SPEC_HIERARCHY__CHILDREN:
				return getChildren();
			case Reqif10Package.SPEC_HIERARCHY__EDITABLE_ATTS:
				return getEditableAtts();
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
			case Reqif10Package.SPEC_HIERARCHY__TABLE_INTERNAL:
				setTableInternal((Boolean)newValue);
				return;
			case Reqif10Package.SPEC_HIERARCHY__OBJECT:
				setObject((SpecObject)newValue);
				return;
			case Reqif10Package.SPEC_HIERARCHY__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SpecHierarchy>)newValue);
				return;
			case Reqif10Package.SPEC_HIERARCHY__EDITABLE_ATTS:
				getEditableAtts().clear();
				getEditableAtts().addAll((Collection<? extends AttributeDefinition>)newValue);
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
			case Reqif10Package.SPEC_HIERARCHY__TABLE_INTERNAL:
				unsetTableInternal();
				return;
			case Reqif10Package.SPEC_HIERARCHY__OBJECT:
				unsetObject();
				return;
			case Reqif10Package.SPEC_HIERARCHY__CHILDREN:
				unsetChildren();
				return;
			case Reqif10Package.SPEC_HIERARCHY__EDITABLE_ATTS:
				unsetEditableAtts();
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
			case Reqif10Package.SPEC_HIERARCHY__TABLE_INTERNAL:
				return isSetTableInternal();
			case Reqif10Package.SPEC_HIERARCHY__OBJECT:
				return isSetObject();
			case Reqif10Package.SPEC_HIERARCHY__CHILDREN:
				return isSetChildren();
			case Reqif10Package.SPEC_HIERARCHY__EDITABLE_ATTS:
				return isSetEditableAtts();
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
		result.append(" (tableInternal: ");
		if (tableInternalESet) result.append(tableInternal); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SpecHierarchyImpl

/**
 */
package de.tuberlin.sqe.ss18.reqexchange.commonmodell.impl;

import de.tuberlin.sqe.ss18.reqexchange.commonmodell.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonmodellFactoryImpl extends EFactoryImpl implements CommonmodellFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommonmodellFactory init() {
		try {
			CommonmodellFactory theCommonmodellFactory = (CommonmodellFactory) EPackage.Registry.INSTANCE
					.getEFactory(CommonmodellPackage.eNS_URI);
			if (theCommonmodellFactory != null) {
				return theCommonmodellFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonmodellFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonmodellFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CommonmodellPackage.CONTENT_OBJECT:
			return createContentObject();
		case CommonmodellPackage.SPECIFICATION:
			return createSpecification();
		case CommonmodellPackage.RELATIONAL_TYPE:
			return createRelationalType();
		case CommonmodellPackage.RELATION:
			return createRelation();
		case CommonmodellPackage.REQ_CONTAINER:
			return createReqContainer();
		case CommonmodellPackage.REQUIREMENT:
			return createRequirement();
		case CommonmodellPackage.PROPERTY_SET:
			return createPropertySet();
		case CommonmodellPackage.PROPERTY:
			return createProperty();
		case CommonmodellPackage.DATA_VALUE:
			return createDataValue();
		case CommonmodellPackage.DATA_TYPE:
			return createDataType();
		case CommonmodellPackage.PROJECT:
			return createProject();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentObject createContentObject() {
		ContentObjectImpl contentObject = new ContentObjectImpl();
		return contentObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification createSpecification() {
		SpecificationImpl specification = new SpecificationImpl();
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalType createRelationalType() {
		RelationalTypeImpl relationalType = new RelationalTypeImpl();
		return relationalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReqContainer createReqContainer() {
		ReqContainerImpl reqContainer = new ReqContainerImpl();
		return reqContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySet createPropertySet() {
		PropertySetImpl propertySet = new PropertySetImpl();
		return propertySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataValue createDataValue() {
		DataValueImpl dataValue = new DataValueImpl();
		return dataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonmodellPackage getCommonmodellPackage() {
		return (CommonmodellPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommonmodellPackage getPackage() {
		return CommonmodellPackage.eINSTANCE;
	}

} //CommonmodellFactoryImpl

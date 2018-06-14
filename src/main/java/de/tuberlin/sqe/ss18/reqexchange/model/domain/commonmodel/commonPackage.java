/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.commonFactory
 * @model kind="package"
 * @generated
 */
public interface commonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commonmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://reqexchange.ss18.sqe.tu-berlin.de/commonmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "commonmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	commonPackage eINSTANCE = de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.IdentifiableImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__VERSION = 1;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ContentObjectImpl <em>Content Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ContentObjectImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getContentObject()
	 * @generated
	 */
	int CONTENT_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Propertys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__PROPERTYS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__NAME = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Content Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Content Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__CONTENT_OBJECTS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Req Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__REQ_CONTAINER = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__PROPERTY_SETS = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Other Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__OTHER_SPECIFICATION = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Datatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__DATATYPES = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Relation Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__RELATION_TYPES = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__RELATIONS = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__NAME = IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__DESCRIPTION = IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Propertys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__PROPERTYS = IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationalTypeImpl <em>Relational Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationalTypeImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getRelationalType()
	 * @generated
	 */
	int RELATIONAL_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Propertys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TYPE__PROPERTYS = 1;

	/**
	 * The number of structural features of the '<em>Relational Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Relational Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Propertys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__PROPERTYS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__CONTENT_OBJECTS = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SPECIFICATION = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Relationaltype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__RELATIONALTYPE = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__REQUIREMENTS = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ReqContainerImpl <em>Req Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ReqContainerImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getReqContainer()
	 * @generated
	 */
	int REQ_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Req Container Childs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER__REQ_CONTAINER_CHILDS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER__REQUIREMENTS = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER__NAME = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Req Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Req Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_CONTAINER_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RequirementImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Property Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__PROPERTY_SETS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__RELATIONS = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertySetImpl <em>Property Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertySetImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getPropertySet()
	 * @generated
	 */
	int PROPERTY_SET = 7;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SET__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SET__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Propertys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SET__PROPERTYS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SET_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SET_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertyImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 8;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DATATYPE = 0;

	/**
	 * The feature id for the '<em><b>Datavalue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DATAVALUE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataValueImpl <em>Data Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataValueImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getDataValue()
	 * @generated
	 */
	int DATA_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataTypeImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 10;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ProjectImpl
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 11;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__VERSION = IDENTIFIABLE__VERSION;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SPECIFICATIONS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PASSWORD = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ADDRESS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Identifiable#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Identifiable#getID()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_ID();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Identifiable#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Identifiable#getVersion()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_Version();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject <em>Content Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Object</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject
	 * @generated
	 */
	EClass getContentObject();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Propertys</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject#getPropertys()
	 * @see #getContentObject()
	 * @generated
	 */
	EReference getContentObject_Propertys();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ContentObject#getName()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_Name();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification
	 * @generated
	 */
	EClass getSpecification();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getContentObjects <em>Content Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Content Objects</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getContentObjects()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_ContentObjects();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getReqContainer <em>Req Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Req Container</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getReqContainer()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_ReqContainer();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getPropertySets <em>Property Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Sets</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getPropertySets()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_PropertySets();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getOtherSpecification <em>Other Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Other Specification</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getOtherSpecification()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_OtherSpecification();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getDatatypes <em>Datatypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Datatypes</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getDatatypes()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Datatypes();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getRelationTypes <em>Relation Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relation Types</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getRelationTypes()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_RelationTypes();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relations</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getRelations()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Relations();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getName()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getDescription()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_Description();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Propertys</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Specification#getPropertys()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Propertys();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType <em>Relational Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Type</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType
	 * @generated
	 */
	EClass getRelationalType();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType#getName()
	 * @see #getRelationalType()
	 * @generated
	 */
	EAttribute getRelationalType_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Propertys</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.RelationalType#getPropertys()
	 * @see #getRelationalType()
	 * @generated
	 */
	EReference getRelationalType_Propertys();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Propertys</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getPropertys()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Propertys();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getContentObjects <em>Content Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Content Objects</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getContentObjects()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_ContentObjects();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specification</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getSpecification()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Specification();

	/**
	 * Returns the meta object for the reference '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getRelationaltype <em>Relationaltype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relationaltype</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getRelationaltype()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Relationaltype();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirements</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getRequirements()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Relation#getName()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Name();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer <em>Req Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Req Container</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer
	 * @generated
	 */
	EClass getReqContainer();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer#getReqContainerChilds <em>Req Container Childs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Req Container Childs</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer#getReqContainerChilds()
	 * @see #getReqContainer()
	 * @generated
	 */
	EReference getReqContainer_ReqContainerChilds();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirements</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer#getRequirements()
	 * @see #getReqContainer()
	 * @generated
	 */
	EReference getReqContainer_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.ReqContainer#getName()
	 * @see #getReqContainer()
	 * @generated
	 */
	EAttribute getReqContainer_Name();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement#getPropertySets <em>Property Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Sets</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement#getPropertySets()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_PropertySets();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relations</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement#getRelations()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Relations();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Requirement#getName()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Name();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.PropertySet <em>Property Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Set</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.PropertySet
	 * @generated
	 */
	EClass getPropertySet();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.PropertySet#getPropertys <em>Propertys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Propertys</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.PropertySet#getPropertys()
	 * @see #getPropertySet()
	 * @generated
	 */
	EReference getPropertySet_Propertys();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datatype</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property#getDatatype()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Datatype();

	/**
	 * Returns the meta object for the reference '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property#getDatavalue <em>Datavalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datavalue</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property#getDatavalue()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Datavalue();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataValue <em>Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Value</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataValue
	 * @generated
	 */
	EClass getDataValue();

	/**
	 * Returns the meta object for the reference '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataValue#getValue()
	 * @see #getDataValue()
	 * @generated
	 */
	EReference getDataValue_Value();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the reference list '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specifications</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getSpecifications()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Specifications();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getPassword()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Password();

	/**
	 * Returns the meta object for the attribute '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.Project#getAddress()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Address();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	commonFactory getcommonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.IdentifiableImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_ID();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__VERSION = eINSTANCE.getIdentifiable_Version();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ContentObjectImpl <em>Content Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ContentObjectImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getContentObject()
		 * @generated
		 */
		EClass CONTENT_OBJECT = eINSTANCE.getContentObject();

		/**
		 * The meta object literal for the '<em><b>Propertys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT_OBJECT__PROPERTYS = eINSTANCE.getContentObject_Propertys();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__NAME = eINSTANCE.getContentObject_Name();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.SpecificationImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getSpecification()
		 * @generated
		 */
		EClass SPECIFICATION = eINSTANCE.getSpecification();

		/**
		 * The meta object literal for the '<em><b>Content Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__CONTENT_OBJECTS = eINSTANCE.getSpecification_ContentObjects();

		/**
		 * The meta object literal for the '<em><b>Req Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__REQ_CONTAINER = eINSTANCE.getSpecification_ReqContainer();

		/**
		 * The meta object literal for the '<em><b>Property Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__PROPERTY_SETS = eINSTANCE.getSpecification_PropertySets();

		/**
		 * The meta object literal for the '<em><b>Other Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__OTHER_SPECIFICATION = eINSTANCE.getSpecification_OtherSpecification();

		/**
		 * The meta object literal for the '<em><b>Datatypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__DATATYPES = eINSTANCE.getSpecification_Datatypes();

		/**
		 * The meta object literal for the '<em><b>Relation Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__RELATION_TYPES = eINSTANCE.getSpecification_RelationTypes();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__RELATIONS = eINSTANCE.getSpecification_Relations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__NAME = eINSTANCE.getSpecification_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__DESCRIPTION = eINSTANCE.getSpecification_Description();

		/**
		 * The meta object literal for the '<em><b>Propertys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__PROPERTYS = eINSTANCE.getSpecification_Propertys();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationalTypeImpl <em>Relational Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationalTypeImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getRelationalType()
		 * @generated
		 */
		EClass RELATIONAL_TYPE = eINSTANCE.getRelationalType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_TYPE__NAME = eINSTANCE.getRelationalType_Name();

		/**
		 * The meta object literal for the '<em><b>Propertys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_TYPE__PROPERTYS = eINSTANCE.getRelationalType_Propertys();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RelationImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Propertys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__PROPERTYS = eINSTANCE.getRelation_Propertys();

		/**
		 * The meta object literal for the '<em><b>Content Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__CONTENT_OBJECTS = eINSTANCE.getRelation_ContentObjects();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SPECIFICATION = eINSTANCE.getRelation_Specification();

		/**
		 * The meta object literal for the '<em><b>Relationaltype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__RELATIONALTYPE = eINSTANCE.getRelation_Relationaltype();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__REQUIREMENTS = eINSTANCE.getRelation_Requirements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__NAME = eINSTANCE.getRelation_Name();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ReqContainerImpl <em>Req Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ReqContainerImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getReqContainer()
		 * @generated
		 */
		EClass REQ_CONTAINER = eINSTANCE.getReqContainer();

		/**
		 * The meta object literal for the '<em><b>Req Container Childs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQ_CONTAINER__REQ_CONTAINER_CHILDS = eINSTANCE.getReqContainer_ReqContainerChilds();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQ_CONTAINER__REQUIREMENTS = eINSTANCE.getReqContainer_Requirements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_CONTAINER__NAME = eINSTANCE.getReqContainer_Name();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.RequirementImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Property Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__PROPERTY_SETS = eINSTANCE.getRequirement_PropertySets();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__RELATIONS = eINSTANCE.getRequirement_Relations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__NAME = eINSTANCE.getRequirement_Name();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertySetImpl <em>Property Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertySetImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getPropertySet()
		 * @generated
		 */
		EClass PROPERTY_SET = eINSTANCE.getPropertySet();

		/**
		 * The meta object literal for the '<em><b>Propertys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SET__PROPERTYS = eINSTANCE.getPropertySet_Propertys();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.PropertyImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__DATATYPE = eINSTANCE.getProperty_Datatype();

		/**
		 * The meta object literal for the '<em><b>Datavalue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__DATAVALUE = eINSTANCE.getProperty_Datavalue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataValueImpl <em>Data Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataValueImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getDataValue()
		 * @generated
		 */
		EClass DATA_VALUE = eINSTANCE.getDataValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VALUE__VALUE = eINSTANCE.getDataValue_Value();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.DataTypeImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.ProjectImpl
		 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.commonmodel.impl.commonPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Specifications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__SPECIFICATIONS = eINSTANCE.getProject_Specifications();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__PASSWORD = eINSTANCE.getProject_Password();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__ADDRESS = eINSTANCE.getProject_Address();

	}

} //commonPackage

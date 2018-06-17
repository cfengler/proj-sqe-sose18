/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.impl;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class Reqif10FactoryImpl extends EFactoryImpl implements Reqif10Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Reqif10Factory init() {
		try {
			Reqif10Factory theReqif10Factory = (Reqif10Factory)EPackage.Registry.INSTANCE.getEFactory(Reqif10Package.eNS_URI);
			if (theReqif10Factory != null) {
				return theReqif10Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Reqif10FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reqif10FactoryImpl() {
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
			case Reqif10Package.ATTRIBUTE_VALUE_XHTML: return createAttributeValueXHTML();
			case Reqif10Package.ATTRIBUTE_DEFINITION_XHTML: return createAttributeDefinitionXHTML();
			case Reqif10Package.REQ_IF_CONTENT: return createReqIFContent();
			case Reqif10Package.REQ_IF: return createReqIF();
			case Reqif10Package.REQ_IF_HEADER: return createReqIFHeader();
			case Reqif10Package.REQ_IF_TOOL_EXTENSION: return createReqIFToolExtension();
			case Reqif10Package.SPEC_OBJECT: return createSpecObject();
			case Reqif10Package.SPEC_OBJECT_TYPE: return createSpecObjectType();
			case Reqif10Package.SPECIFICATION: return createSpecification();
			case Reqif10Package.SPECIFICATION_TYPE: return createSpecificationType();
			case Reqif10Package.SPEC_HIERARCHY: return createSpecHierarchy();
			case Reqif10Package.SPEC_RELATION: return createSpecRelation();
			case Reqif10Package.SPEC_RELATION_TYPE: return createSpecRelationType();
			case Reqif10Package.RELATION_GROUP: return createRelationGroup();
			case Reqif10Package.RELATION_GROUP_TYPE: return createRelationGroupType();
			case Reqif10Package.DATATYPE_DEFINITION_XHTML: return createDatatypeDefinitionXHTML();
			case Reqif10Package.ALTERNATIVE_ID: return createAlternativeID();
			case Reqif10Package.ATTRIBUTE_DEFINITION_BOOLEAN: return createAttributeDefinitionBoolean();
			case Reqif10Package.DATATYPE_DEFINITION_BOOLEAN: return createDatatypeDefinitionBoolean();
			case Reqif10Package.ATTRIBUTE_VALUE_BOOLEAN: return createAttributeValueBoolean();
			case Reqif10Package.ATTRIBUTE_DEFINITION_DATE: return createAttributeDefinitionDate();
			case Reqif10Package.DATATYPE_DEFINITION_DATE: return createDatatypeDefinitionDate();
			case Reqif10Package.ATTRIBUTE_VALUE_DATE: return createAttributeValueDate();
			case Reqif10Package.ATTRIBUTE_DEFINITION_ENUMERATION: return createAttributeDefinitionEnumeration();
			case Reqif10Package.DATATYPE_DEFINITION_ENUMERATION: return createDatatypeDefinitionEnumeration();
			case Reqif10Package.ENUM_VALUE: return createEnumValue();
			case Reqif10Package.EMBEDDED_VALUE: return createEmbeddedValue();
			case Reqif10Package.ATTRIBUTE_VALUE_ENUMERATION: return createAttributeValueEnumeration();
			case Reqif10Package.ATTRIBUTE_DEFINITION_INTEGER: return createAttributeDefinitionInteger();
			case Reqif10Package.DATATYPE_DEFINITION_INTEGER: return createDatatypeDefinitionInteger();
			case Reqif10Package.ATTRIBUTE_VALUE_INTEGER: return createAttributeValueInteger();
			case Reqif10Package.ATTRIBUTE_DEFINITION_REAL: return createAttributeDefinitionReal();
			case Reqif10Package.DATATYPE_DEFINITION_REAL: return createDatatypeDefinitionReal();
			case Reqif10Package.ATTRIBUTE_VALUE_REAL: return createAttributeValueReal();
			case Reqif10Package.ATTRIBUTE_DEFINITION_STRING: return createAttributeDefinitionString();
			case Reqif10Package.DATATYPE_DEFINITION_STRING: return createDatatypeDefinitionString();
			case Reqif10Package.ATTRIBUTE_VALUE_STRING: return createAttributeValueString();
			case Reqif10Package.XHTML_CONTENT: return createXhtmlContent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Reqif10Package.ID:
				return createIDFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Reqif10Package.ID:
				return convertIDToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueXHTML createAttributeValueXHTML() {
		AttributeValueXHTMLImpl attributeValueXHTML = new AttributeValueXHTMLImpl();
		return attributeValueXHTML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionXHTML createAttributeDefinitionXHTML() {
		AttributeDefinitionXHTMLImpl attributeDefinitionXHTML = new AttributeDefinitionXHTMLImpl();
		return attributeDefinitionXHTML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReqIFContent createReqIFContent() {
		ReqIFContentImpl reqIFContent = new ReqIFContentImpl();
		return reqIFContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReqIF createReqIF() {
		ReqIFImpl reqIF = new ReqIFImpl();
		return reqIF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReqIFHeader createReqIFHeader() {
		ReqIFHeaderImpl reqIFHeader = new ReqIFHeaderImpl();
		return reqIFHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReqIFToolExtension createReqIFToolExtension() {
		ReqIFToolExtensionImpl reqIFToolExtension = new ReqIFToolExtensionImpl();
		return reqIFToolExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecObject createSpecObject() {
		SpecObjectImpl specObject = new SpecObjectImpl();
		return specObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecObjectType createSpecObjectType() {
		SpecObjectTypeImpl specObjectType = new SpecObjectTypeImpl();
		return specObjectType;
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
	public SpecificationType createSpecificationType() {
		SpecificationTypeImpl specificationType = new SpecificationTypeImpl();
		return specificationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecHierarchy createSpecHierarchy() {
		SpecHierarchyImpl specHierarchy = new SpecHierarchyImpl();
		return specHierarchy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecRelation createSpecRelation() {
		SpecRelationImpl specRelation = new SpecRelationImpl();
		return specRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecRelationType createSpecRelationType() {
		SpecRelationTypeImpl specRelationType = new SpecRelationTypeImpl();
		return specRelationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationGroup createRelationGroup() {
		RelationGroupImpl relationGroup = new RelationGroupImpl();
		return relationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationGroupType createRelationGroupType() {
		RelationGroupTypeImpl relationGroupType = new RelationGroupTypeImpl();
		return relationGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionXHTML createDatatypeDefinitionXHTML() {
		DatatypeDefinitionXHTMLImpl datatypeDefinitionXHTML = new DatatypeDefinitionXHTMLImpl();
		return datatypeDefinitionXHTML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeID createAlternativeID() {
		AlternativeIDImpl alternativeID = new AlternativeIDImpl();
		return alternativeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionBoolean createAttributeDefinitionBoolean() {
		AttributeDefinitionBooleanImpl attributeDefinitionBoolean = new AttributeDefinitionBooleanImpl();
		return attributeDefinitionBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionBoolean createDatatypeDefinitionBoolean() {
		DatatypeDefinitionBooleanImpl datatypeDefinitionBoolean = new DatatypeDefinitionBooleanImpl();
		return datatypeDefinitionBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueBoolean createAttributeValueBoolean() {
		AttributeValueBooleanImpl attributeValueBoolean = new AttributeValueBooleanImpl();
		return attributeValueBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionDate createAttributeDefinitionDate() {
		AttributeDefinitionDateImpl attributeDefinitionDate = new AttributeDefinitionDateImpl();
		return attributeDefinitionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionDate createDatatypeDefinitionDate() {
		DatatypeDefinitionDateImpl datatypeDefinitionDate = new DatatypeDefinitionDateImpl();
		return datatypeDefinitionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueDate createAttributeValueDate() {
		AttributeValueDateImpl attributeValueDate = new AttributeValueDateImpl();
		return attributeValueDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionEnumeration createAttributeDefinitionEnumeration() {
		AttributeDefinitionEnumerationImpl attributeDefinitionEnumeration = new AttributeDefinitionEnumerationImpl();
		return attributeDefinitionEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionEnumeration createDatatypeDefinitionEnumeration() {
		DatatypeDefinitionEnumerationImpl datatypeDefinitionEnumeration = new DatatypeDefinitionEnumerationImpl();
		return datatypeDefinitionEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumValue createEnumValue() {
		EnumValueImpl enumValue = new EnumValueImpl();
		return enumValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbeddedValue createEmbeddedValue() {
		EmbeddedValueImpl embeddedValue = new EmbeddedValueImpl();
		return embeddedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueEnumeration createAttributeValueEnumeration() {
		AttributeValueEnumerationImpl attributeValueEnumeration = new AttributeValueEnumerationImpl();
		return attributeValueEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionInteger createAttributeDefinitionInteger() {
		AttributeDefinitionIntegerImpl attributeDefinitionInteger = new AttributeDefinitionIntegerImpl();
		return attributeDefinitionInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionInteger createDatatypeDefinitionInteger() {
		DatatypeDefinitionIntegerImpl datatypeDefinitionInteger = new DatatypeDefinitionIntegerImpl();
		return datatypeDefinitionInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueInteger createAttributeValueInteger() {
		AttributeValueIntegerImpl attributeValueInteger = new AttributeValueIntegerImpl();
		return attributeValueInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionReal createAttributeDefinitionReal() {
		AttributeDefinitionRealImpl attributeDefinitionReal = new AttributeDefinitionRealImpl();
		return attributeDefinitionReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionReal createDatatypeDefinitionReal() {
		DatatypeDefinitionRealImpl datatypeDefinitionReal = new DatatypeDefinitionRealImpl();
		return datatypeDefinitionReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueReal createAttributeValueReal() {
		AttributeValueRealImpl attributeValueReal = new AttributeValueRealImpl();
		return attributeValueReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionString createAttributeDefinitionString() {
		AttributeDefinitionStringImpl attributeDefinitionString = new AttributeDefinitionStringImpl();
		return attributeDefinitionString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypeDefinitionString createDatatypeDefinitionString() {
		DatatypeDefinitionStringImpl datatypeDefinitionString = new DatatypeDefinitionStringImpl();
		return datatypeDefinitionString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueString createAttributeValueString() {
		AttributeValueStringImpl attributeValueString = new AttributeValueStringImpl();
		return attributeValueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XhtmlContent createXhtmlContent() {
		XhtmlContentImpl xhtmlContent = new XhtmlContentImpl();
		return xhtmlContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIDFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIDToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reqif10Package getReqif10Package() {
		return (Reqif10Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Reqif10Package getPackage() {
		return Reqif10Package.eINSTANCE;
	}

} //Reqif10FactoryImpl

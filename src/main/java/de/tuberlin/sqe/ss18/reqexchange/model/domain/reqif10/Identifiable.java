/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getDesc <em>Desc</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLastChange <em>Last Change</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLongName <em>Long Name</em>}</li>
 *   <li>{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getAlternativeID <em>Alternative ID</em>}</li>
 * </ul>
 *
 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getIdentifiable()
 * @model abstract="true"
 *        extendedMetaData="name='IDENTIFIABLE' kind='elementOnly'"
 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='IDENTIFIABLE'"
 * @generated
 */
public interface Identifiable extends EObject {
	/**
	 * Returns the value of the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desc</em>' attribute.
	 * @see #isSetDesc()
	 * @see #unsetDesc()
	 * @see #setDesc(String)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getIdentifiable_Desc()
	 * @model unsettable="true" ordered="false"
	 *        extendedMetaData="name='DESC' kind='attribute'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='DESC' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='false'"
	 * @generated
	 */
	String getDesc();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc</em>' attribute.
	 * @see #isSetDesc()
	 * @see #unsetDesc()
	 * @see #getDesc()
	 * @generated
	 */
	void setDesc(String value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDesc()
	 * @see #getDesc()
	 * @see #setDesc(String)
	 * @generated
	 */
	void unsetDesc();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getDesc <em>Desc</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Desc</em>' attribute is set.
	 * @see #unsetDesc()
	 * @see #getDesc()
	 * @see #setDesc(String)
	 * @generated
	 */
	boolean isSetDesc();

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #isSetIdentifier()
	 * @see #unsetIdentifier()
	 * @see #setIdentifier(String)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getIdentifiable_Identifier()
	 * @model unsettable="true" id="true" dataType="de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.ID" required="true" ordered="false"
	 *        extendedMetaData="name='IDENTIFIER' kind='attribute'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='IDENTIFIER' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='false'"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #isSetIdentifier()
	 * @see #unsetIdentifier()
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentifier()
	 * @see #getIdentifier()
	 * @see #setIdentifier(String)
	 * @generated
	 */
	void unsetIdentifier();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getIdentifier <em>Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Identifier</em>' attribute is set.
	 * @see #unsetIdentifier()
	 * @see #getIdentifier()
	 * @see #setIdentifier(String)
	 * @generated
	 */
	boolean isSetIdentifier();

	/**
	 * Returns the value of the '<em><b>Last Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Change</em>' attribute.
	 * @see #isSetLastChange()
	 * @see #unsetLastChange()
	 * @see #setLastChange(XMLGregorianCalendar)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getIdentifiable_LastChange()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.DateTime" required="true" ordered="false"
	 *        extendedMetaData="name='LAST-CHANGE' kind='attribute'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='LAST-CHANGE' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='false'"
	 * @generated
	 */
	XMLGregorianCalendar getLastChange();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLastChange <em>Last Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Change</em>' attribute.
	 * @see #isSetLastChange()
	 * @see #unsetLastChange()
	 * @see #getLastChange()
	 * @generated
	 */
	void setLastChange(XMLGregorianCalendar value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLastChange <em>Last Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastChange()
	 * @see #getLastChange()
	 * @see #setLastChange(XMLGregorianCalendar)
	 * @generated
	 */
	void unsetLastChange();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLastChange <em>Last Change</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Change</em>' attribute is set.
	 * @see #unsetLastChange()
	 * @see #getLastChange()
	 * @see #setLastChange(XMLGregorianCalendar)
	 * @generated
	 */
	boolean isSetLastChange();

	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #isSetLongName()
	 * @see #unsetLongName()
	 * @see #setLongName(String)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getIdentifiable_LongName()
	 * @model unsettable="true" ordered="false"
	 *        extendedMetaData="name='LONG-NAME' kind='attribute'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='LONG-NAME' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='false'"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #isSetLongName()
	 * @see #unsetLongName()
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	void unsetLongName();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getLongName <em>Long Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Long Name</em>' attribute is set.
	 * @see #unsetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	boolean isSetLongName();

	/**
	 * Returns the value of the '<em><b>Alternative ID</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative ID</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative ID</em>' containment reference.
	 * @see #isSetAlternativeID()
	 * @see #unsetAlternativeID()
	 * @see #setAlternativeID(AlternativeID)
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package#getIdentifiable_AlternativeID()
	 * @model containment="true" unsettable="true" ordered="false"
	 *        extendedMetaData="name='ALTERNATIVE-ID' kind='element' namespace='##targetNamespace'"
	 *        annotation="http:///org/eclipse/sphinx/emf/serialization/XMLPersistenceMappingExtendedMetaData wrapperName='ALTERNATIVE-ID' featureWrapperElement='false' featureElement='true' classifierWrapperElement='false' classifierElement='true'"
	 * @generated
	 */
	AlternativeID getAlternativeID();

	/**
	 * Sets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getAlternativeID <em>Alternative ID</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternative ID</em>' containment reference.
	 * @see #isSetAlternativeID()
	 * @see #unsetAlternativeID()
	 * @see #getAlternativeID()
	 * @generated
	 */
	void setAlternativeID(AlternativeID value);

	/**
	 * Unsets the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getAlternativeID <em>Alternative ID</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAlternativeID()
	 * @see #getAlternativeID()
	 * @see #setAlternativeID(AlternativeID)
	 * @generated
	 */
	void unsetAlternativeID();

	/**
	 * Returns whether the value of the '{@link de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Identifiable#getAlternativeID <em>Alternative ID</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Alternative ID</em>' containment reference is set.
	 * @see #unsetAlternativeID()
	 * @see #getAlternativeID()
	 * @see #setAlternativeID(AlternativeID)
	 * @generated
	 */
	boolean isSetAlternativeID();

} // Identifiable

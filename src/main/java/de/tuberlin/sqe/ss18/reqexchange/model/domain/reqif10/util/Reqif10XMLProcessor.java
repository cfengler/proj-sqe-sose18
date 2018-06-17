/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.util;

import de.tuberlin.sqe.ss18.reqexchange.model.domain.reqif10.Reqif10Package;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Reqif10XMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reqif10XMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		Reqif10Package.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the Reqif10ResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new Reqif10ResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new Reqif10ResourceFactoryImpl());
		}
		return registrations;
	}

} //Reqif10XMLProcessor

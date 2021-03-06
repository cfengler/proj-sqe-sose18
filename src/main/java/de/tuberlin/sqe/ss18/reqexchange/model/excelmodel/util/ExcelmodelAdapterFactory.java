/**
 */
package de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.util;

import de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.ExcelmodelPackage
 * @generated
 */
public class ExcelmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExcelmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExcelmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExcelmodelSwitch<Adapter> modelSwitch = new ExcelmodelSwitch<Adapter>() {
		@Override
		public Adapter caseWorkbook(Workbook object) {
			return createWorkbookAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseWorksheet(Worksheet object) {
			return createWorksheetAdapter();
		}

		@Override
		public Adapter caseRow(Row object) {
			return createRowAdapter();
		}

		@Override
		public Adapter caseCell(Cell object) {
			return createCellAdapter();
		}

		@Override
		public Adapter caseStringCell(StringCell object) {
			return createStringCellAdapter();
		}

		@Override
		public Adapter caseNumericCell(NumericCell object) {
			return createNumericCellAdapter();
		}

		@Override
		public Adapter caseBooleanCell(BooleanCell object) {
			return createBooleanCellAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook <em>Workbook</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Workbook
	 * @generated
	 */
	public Adapter createWorkbookAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet <em>Worksheet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Worksheet
	 * @generated
	 */
	public Adapter createWorksheetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Row
	 * @generated
	 */
	public Adapter createRowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.Cell
	 * @generated
	 */
	public Adapter createCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.StringCell <em>String Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.StringCell
	 * @generated
	 */
	public Adapter createStringCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NumericCell <em>Numeric Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.NumericCell
	 * @generated
	 */
	public Adapter createNumericCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.BooleanCell <em>Boolean Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tuberlin.sqe.ss18.reqexchange.model.excelmodel.BooleanCell
	 * @generated
	 */
	public Adapter createBooleanCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExcelmodelAdapterFactory

/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.NamedElement;

import de.thm.evolvedb.mdde.util.MddeValidator;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.impl.NamedElementImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedElementImpl extends MinimalEObjectImpl.Container implements NamedElement {
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
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MddePackage.Literals.NAMED_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * The cached validation expression for the '{@link #NameNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Name Not Null</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NameNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_NOT_NULL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'Name should not be empty!',\n" +
		"\tstatus : Boolean = self.name->size() > 0\n" +
		"}.status";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NameNotNull(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			MddeValidator.validate
				(MddePackage.Literals.NAMED_ELEMENT,
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 MddePackage.Literals.NAMED_ELEMENT___NAME_NOT_NULL__DIAGNOSTICCHAIN_MAP,
				 NAME_NOT_NULL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 MddeValidator.DIAGNOSTIC_SOURCE,
				 MddeValidator.NAMED_ELEMENT__NAME_NOT_NULL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MddePackage.NAMED_ELEMENT__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MddePackage.NAMED_ELEMENT__NAME:
				setName((String)newValue);
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
			case MddePackage.NAMED_ELEMENT__NAME:
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
			case MddePackage.NAMED_ELEMENT__NAME:
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MddePackage.NAMED_ELEMENT___NAME_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return NameNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NamedElementImpl

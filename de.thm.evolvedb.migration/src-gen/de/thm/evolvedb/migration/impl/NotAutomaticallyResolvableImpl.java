/**
 */
package de.thm.evolvedb.migration.impl;

import de.thm.evolvedb.migration.ComplexResolveOptions;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Automatically Resolvable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.impl.NotAutomaticallyResolvableImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.NotAutomaticallyResolvableImpl#getResolveOptions <em>Resolve Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NotAutomaticallyResolvableImpl extends SchemaModificationOperatorImpl implements NotAutomaticallyResolvable {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final NotAutomaticallyResolvableOperatorType DISPLAY_NAME_EDEFAULT = NotAutomaticallyResolvableOperatorType.MOVE_PRIMARY_KEY;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected NotAutomaticallyResolvableOperatorType displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResolveOptions() <em>Resolve Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolveOptions()
	 * @generated
	 * @ordered
	 */
	protected static final ComplexResolveOptions RESOLVE_OPTIONS_EDEFAULT = ComplexResolveOptions.IGNORE;

	/**
	 * The cached value of the '{@link #getResolveOptions() <em>Resolve Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolveOptions()
	 * @generated
	 * @ordered
	 */
	protected ComplexResolveOptions resolveOptions = RESOLVE_OPTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotAutomaticallyResolvableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.NOT_AUTOMATICALLY_RESOLVABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotAutomaticallyResolvableOperatorType getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(NotAutomaticallyResolvableOperatorType newDisplayName) {
		NotAutomaticallyResolvableOperatorType oldDisplayName = displayName;
		displayName = newDisplayName == null ? DISPLAY_NAME_EDEFAULT : newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexResolveOptions getResolveOptions() {
		return resolveOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolveOptions(ComplexResolveOptions newResolveOptions) {
		ComplexResolveOptions oldResolveOptions = resolveOptions;
		resolveOptions = newResolveOptions == null ? RESOLVE_OPTIONS_EDEFAULT : newResolveOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS, oldResolveOptions, resolveOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME:
				return getDisplayName();
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS:
				return getResolveOptions();
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
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME:
				setDisplayName((NotAutomaticallyResolvableOperatorType)newValue);
				return;
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS:
				setResolveOptions((ComplexResolveOptions)newValue);
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
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS:
				setResolveOptions(RESOLVE_OPTIONS_EDEFAULT);
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
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME:
				return displayName != DISPLAY_NAME_EDEFAULT;
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS:
				return resolveOptions != RESOLVE_OPTIONS_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (displayName: ");
		result.append(displayName);
		result.append(", resolveOptions: ");
		result.append(resolveOptions);
		result.append(')');
		return result.toString();
	}

} //NotAutomaticallyResolvableImpl

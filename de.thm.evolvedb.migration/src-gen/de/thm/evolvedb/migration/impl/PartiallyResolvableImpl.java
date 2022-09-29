/**
 */
package de.thm.evolvedb.migration.impl;

import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvableOperatorType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partially Resolvable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.impl.PartiallyResolvableImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.PartiallyResolvableImpl#getResolveOptions <em>Resolve Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartiallyResolvableImpl extends SchemaModificationOperatorImpl implements PartiallyResolvable {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final PartiallyResolvableOperatorType DISPLAY_NAME_EDEFAULT = PartiallyResolvableOperatorType.DELETE_COLUMN;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected PartiallyResolvableOperatorType displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResolveOptions() <em>Resolve Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolveOptions()
	 * @generated
	 * @ordered
	 */
	protected static final ColumnOptions RESOLVE_OPTIONS_EDEFAULT = ColumnOptions.IGNORE;

	/**
	 * The cached value of the '{@link #getResolveOptions() <em>Resolve Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolveOptions()
	 * @generated
	 * @ordered
	 */
	protected ColumnOptions resolveOptions = RESOLVE_OPTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartiallyResolvableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.PARTIALLY_RESOLVABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartiallyResolvableOperatorType getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(PartiallyResolvableOperatorType newDisplayName) {
		PartiallyResolvableOperatorType oldDisplayName = displayName;
		displayName = newDisplayName == null ? DISPLAY_NAME_EDEFAULT : newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.PARTIALLY_RESOLVABLE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnOptions getResolveOptions() {
		return resolveOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolveOptions(ColumnOptions newResolveOptions) {
		ColumnOptions oldResolveOptions = resolveOptions;
		resolveOptions = newResolveOptions == null ? RESOLVE_OPTIONS_EDEFAULT : newResolveOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS, oldResolveOptions, resolveOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MigrationPackage.PARTIALLY_RESOLVABLE__DISPLAY_NAME:
				return getDisplayName();
			case MigrationPackage.PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS:
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
			case MigrationPackage.PARTIALLY_RESOLVABLE__DISPLAY_NAME:
				setDisplayName((PartiallyResolvableOperatorType)newValue);
				return;
			case MigrationPackage.PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS:
				setResolveOptions((ColumnOptions)newValue);
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
			case MigrationPackage.PARTIALLY_RESOLVABLE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case MigrationPackage.PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS:
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
			case MigrationPackage.PARTIALLY_RESOLVABLE__DISPLAY_NAME:
				return displayName != DISPLAY_NAME_EDEFAULT;
			case MigrationPackage.PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS:
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

} //PartiallyResolvableImpl

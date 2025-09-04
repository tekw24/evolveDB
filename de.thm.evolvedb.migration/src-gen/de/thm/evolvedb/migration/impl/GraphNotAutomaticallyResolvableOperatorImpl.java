/**
 */
package de.thm.evolvedb.migration.impl;

import de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperator;
import de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperatorType;
import de.thm.evolvedb.migration.MigrationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Not Automatically Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.impl.GraphNotAutomaticallyResolvableOperatorImpl#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphNotAutomaticallyResolvableOperatorImpl extends SchemaModificationOperatorImpl implements GraphNotAutomaticallyResolvableOperator {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final GraphNotAutomaticallyResolvableOperatorType DISPLAY_NAME_EDEFAULT = GraphNotAutomaticallyResolvableOperatorType.MOVE_PROPERTY;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected GraphNotAutomaticallyResolvableOperatorType displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphNotAutomaticallyResolvableOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.GRAPH_NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphNotAutomaticallyResolvableOperatorType getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(GraphNotAutomaticallyResolvableOperatorType newDisplayName) {
		GraphNotAutomaticallyResolvableOperatorType oldDisplayName = displayName;
		displayName = newDisplayName == null ? DISPLAY_NAME_EDEFAULT : newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.GRAPH_NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MigrationPackage.GRAPH_NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR__DISPLAY_NAME:
				return getDisplayName();
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
			case MigrationPackage.GRAPH_NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR__DISPLAY_NAME:
				setDisplayName((GraphNotAutomaticallyResolvableOperatorType)newValue);
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
			case MigrationPackage.GRAPH_NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
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
			case MigrationPackage.GRAPH_NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR__DISPLAY_NAME:
				return displayName != DISPLAY_NAME_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //GraphNotAutomaticallyResolvableOperatorImpl

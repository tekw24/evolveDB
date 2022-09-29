/**
 */
package de.thm.evolvedb.migration.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Map;

import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.SchemaModificationOperator;
import de.thm.evolvedb.migration.util.MigrationValidator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.sidiff.difference.symmetric.SemanticChangeSet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Schema
 * Modification Operator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl#getSemanticChangeSets <em>Semantic Change Sets</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl#getProcessStatus <em>Process Status</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl#getMigration <em>Migration</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SchemaModificationOperatorImpl extends MinimalEObjectImpl.Container
		implements SchemaModificationOperator {
	/**
	 * The cached value of the '{@link #getSemanticChangeSets() <em>Semantic Change Sets</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSemanticChangeSets()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticChangeSet> semanticChangeSets;

	/**
	 * The default value of the '{@link #getProcessStatus() <em>Process Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProcessStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ProcessStatus PROCESS_STATUS_EDEFAULT = ProcessStatus.RESOLVED;

	/**
	 * The cached value of the '{@link #getProcessStatus() <em>Process Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProcessStatus()
	 * @generated
	 * @ordered
	 */
	protected ProcessStatus processStatus = PROCESS_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SchemaModificationOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.SCHEMA_MODIFICATION_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SemanticChangeSet> getSemanticChangeSets() {
		if (semanticChangeSets == null) {
			semanticChangeSets = new EObjectResolvingEList<SemanticChangeSet>(SemanticChangeSet.class, this, MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS);
		}
		return semanticChangeSets;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProcessStatus(ProcessStatus newProcessStatus) {
		ProcessStatus oldProcessStatus = processStatus;
		processStatus = newProcessStatus == null ? PROCESS_STATUS_EDEFAULT : newProcessStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS, oldProcessStatus, processStatus));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Migration getMigration() {
		if (eContainerFeatureID() != MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION) return null;
		return (Migration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMigration(Migration newMigration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMigration, MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMigration(Migration newMigration) {
		if (newMigration != eInternalContainer() || (eContainerFeatureID() != MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION && newMigration != null)) {
			if (EcoreUtil.isAncestor(this, newMigration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMigration != null)
				msgs = ((InternalEObject)newMigration).eInverseAdd(this, MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS, Migration.class, msgs);
			msgs = basicSetMigration(newMigration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION, newMigration, newMigration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean validateSMO(DiagnosticChain diagnostics, Map<Object, Object> context) {

		//EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
		//new Object[] { "validateSMO", EObjectValidator.getObjectLabel(this, context) })
		if (diagnostics != null && getProcessStatus().equals(ProcessStatus.UNRESOLVED)) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, MigrationValidator.DIAGNOSTIC_SOURCE,
					MigrationValidator.SCHEMA_MODIFICATION_OPERATOR__VALIDATE_SMO,
					"Warning: Possible data loss.",
					new Object[] { this }));
		}
		return true;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMigration((Migration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				return basicSetMigration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				return eInternalContainer().eInverseRemove(this, MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS, Migration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS:
				return getSemanticChangeSets();
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS:
				return getProcessStatus();
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				return getMigration();
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS:
				getSemanticChangeSets().clear();
				getSemanticChangeSets().addAll((Collection<? extends SemanticChangeSet>)newValue);
				return;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS:
				setProcessStatus((ProcessStatus)newValue);
				return;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				setMigration((Migration)newValue);
				return;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION:
				setDescription((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS:
				getSemanticChangeSets().clear();
				return;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS:
				setProcessStatus(PROCESS_STATUS_EDEFAULT);
				return;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				setMigration((Migration)null);
				return;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS:
				return semanticChangeSets != null && !semanticChangeSets.isEmpty();
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS:
				return processStatus != PROCESS_STATUS_EDEFAULT;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION:
				return getMigration() != null;
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP:
				return validateSMO((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (processStatus: ");
		result.append(processStatus);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} // SchemaModificationOperatorImpl

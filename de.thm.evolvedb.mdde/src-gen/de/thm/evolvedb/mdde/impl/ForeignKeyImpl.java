/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Referential_Action;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.util.MddeValidator;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Foreign
 * Key</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl#getReferencedTable
 * <em>Referenced Table</em>}</li>
 * <li>{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl#getPrimaryForeignKey
 * <em>Primary Foreign Key</em>}</li>
 * <li>{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl#getOnUpdate <em>On
 * Update</em>}</li>
 * <li>{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl#getOnDelete <em>On
 * Delete</em>}</li>
 * <li>{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl#getConstraintName
 * <em>Constraint Name</em>}</li>
 * <li>{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl#getReferencedKeyColumn
 * <em>Referenced Key Column</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForeignKeyImpl extends ColumnImpl implements ForeignKey {
	/**
	 * The cached value of the '{@link #getReferencedTable() <em>Referenced
	 * Table</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferencedTable()
	 * @generated
	 * @ordered
	 */
	protected Table referencedTable;

	/**
	 * The default value of the '{@link #getPrimaryForeignKey() <em>Primary Foreign
	 * Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrimaryForeignKey()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PRIMARY_FOREIGN_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryForeignKey() <em>Primary Foreign
	 * Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrimaryForeignKey()
	 * @generated
	 * @ordered
	 */
	protected Boolean primaryForeignKey = PRIMARY_FOREIGN_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnUpdate() <em>On Update</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOnUpdate()
	 * @generated
	 * @ordered
	 */
	protected static final Referential_Action ON_UPDATE_EDEFAULT = Referential_Action.RESTRICT;

	/**
	 * The cached value of the '{@link #getOnUpdate() <em>On Update</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOnUpdate()
	 * @generated
	 * @ordered
	 */
	protected Referential_Action onUpdate = ON_UPDATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnDelete() <em>On Delete</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOnDelete()
	 * @generated
	 * @ordered
	 */
	protected static final Referential_Action ON_DELETE_EDEFAULT = Referential_Action.RESTRICT;

	/**
	 * The cached value of the '{@link #getOnDelete() <em>On Delete</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOnDelete()
	 * @generated
	 * @ordered
	 */
	protected Referential_Action onDelete = ON_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraintName() <em>Constraint
	 * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraintName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraintName() <em>Constraint
	 * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraintName()
	 * @generated
	 * @ordered
	 */
	protected String constraintName = CONSTRAINT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedKeyColumn() <em>Referenced Key
	 * Column</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferencedKeyColumn()
	 * @generated
	 * @ordered
	 */
	protected PrimaryKey referencedKeyColumn;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MddePackage.Literals.FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Table getReferencedTable() {
		if (referencedTable != null && referencedTable.eIsProxy()) {
			InternalEObject oldReferencedTable = (InternalEObject) referencedTable;
			referencedTable = (Table) eResolveProxy(oldReferencedTable);
			if (referencedTable != oldReferencedTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MddePackage.FOREIGN_KEY__REFERENCED_TABLE,
							oldReferencedTable, referencedTable));
			}
		}
		return referencedTable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Table basicGetReferencedTable() {
		return referencedTable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setReferencedTable(Table newReferencedTable) {
		Table oldReferencedTable = referencedTable;
		referencedTable = newReferencedTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.FOREIGN_KEY__REFERENCED_TABLE,
					oldReferencedTable, referencedTable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Boolean getPrimaryForeignKey() {
		return primaryForeignKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPrimaryForeignKey(Boolean newPrimaryForeignKey) {
		Boolean oldPrimaryForeignKey = primaryForeignKey;
		primaryForeignKey = newPrimaryForeignKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.FOREIGN_KEY__PRIMARY_FOREIGN_KEY,
					oldPrimaryForeignKey, primaryForeignKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Referential_Action getOnUpdate() {
		return onUpdate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOnUpdate(Referential_Action newOnUpdate) {
		Referential_Action oldOnUpdate = onUpdate;
		onUpdate = newOnUpdate == null ? ON_UPDATE_EDEFAULT : newOnUpdate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.FOREIGN_KEY__ON_UPDATE, oldOnUpdate,
					onUpdate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Referential_Action getOnDelete() {
		return onDelete;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOnDelete(Referential_Action newOnDelete) {
		Referential_Action oldOnDelete = onDelete;
		onDelete = newOnDelete == null ? ON_DELETE_EDEFAULT : newOnDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.FOREIGN_KEY__ON_DELETE, oldOnDelete,
					onDelete));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getConstraintName() {
		return constraintName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setConstraintName(String newConstraintName) {
		String oldConstraintName = constraintName;
		constraintName = newConstraintName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.FOREIGN_KEY__CONSTRAINT_NAME,
					oldConstraintName, constraintName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public PrimaryKey getReferencedKeyColumn() {
		if (referencedKeyColumn != null && referencedKeyColumn.eIsProxy()) {
			InternalEObject oldReferencedKeyColumn = (InternalEObject) referencedKeyColumn;
			referencedKeyColumn = (PrimaryKey) eResolveProxy(oldReferencedKeyColumn);
			if (referencedKeyColumn != oldReferencedKeyColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN, oldReferencedKeyColumn,
							referencedKeyColumn));
			}
		}
		return referencedKeyColumn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryKey basicGetReferencedKeyColumn() {
		return referencedKeyColumn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public NotificationChain basicSetReferencedKeyColumn(PrimaryKey newReferencedKeyColumn, NotificationChain msgs) {
		PrimaryKey oldReferencedKeyColumn = referencedKeyColumn;
		if(newReferencedKeyColumn != null && newReferencedKeyColumn.getType() != getType()) {
			setType(newReferencedKeyColumn.getType());
		}
		referencedKeyColumn = newReferencedKeyColumn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN, oldReferencedKeyColumn, newReferencedKeyColumn);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setReferencedKeyColumn(PrimaryKey newReferencedKeyColumn) {
		if (newReferencedKeyColumn != referencedKeyColumn) {
			NotificationChain msgs = null;
			if (referencedKeyColumn != null)
				msgs = ((InternalEObject) referencedKeyColumn).eInverseRemove(this,
						MddePackage.PRIMARY_KEY__REFERENCED_BY, PrimaryKey.class, msgs);
			if (newReferencedKeyColumn != null)
				msgs = ((InternalEObject) newReferencedKeyColumn).eInverseAdd(this,
						MddePackage.PRIMARY_KEY__REFERENCED_BY, PrimaryKey.class, msgs);

			msgs = basicSetReferencedKeyColumn(newReferencedKeyColumn, msgs);

			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN,
					newReferencedKeyColumn, newReferencedKeyColumn));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean validateConstraintName(DiagnosticChain diagnostics, Map<Object, Object> context) {

		if (getConstraintName() != null) {

			EList<ForeignKey> foreignKeys = getTable().getForeignKeys();
			foreignKeys.remove(this);
			List<String> constraintNames = foreignKeys.stream().map(e -> e.getConstraintName())
					.collect(Collectors.toList());
			if (constraintNames.contains(getConstraintName())) {

				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
						MddeValidator.FOREIGN_KEY__VALIDATE_CONSTRAINT_NAME,
						"Invalid constraint name. The constraint name has to be unique!", new Object[] { this }));
			}
		}

		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN:
			if (referencedKeyColumn != null)
				msgs = ((InternalEObject) referencedKeyColumn).eInverseRemove(this,
						MddePackage.PRIMARY_KEY__REFERENCED_BY, PrimaryKey.class, msgs);
			return basicSetReferencedKeyColumn((PrimaryKey) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN:
			return basicSetReferencedKeyColumn(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MddePackage.FOREIGN_KEY__REFERENCED_TABLE:
			if (resolve)
				return getReferencedTable();
			return basicGetReferencedTable();
		case MddePackage.FOREIGN_KEY__PRIMARY_FOREIGN_KEY:
			return getPrimaryForeignKey();
		case MddePackage.FOREIGN_KEY__ON_UPDATE:
			return getOnUpdate();
		case MddePackage.FOREIGN_KEY__ON_DELETE:
			return getOnDelete();
		case MddePackage.FOREIGN_KEY__CONSTRAINT_NAME:
			return getConstraintName();
		case MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN:
			if (resolve)
				return getReferencedKeyColumn();
			return basicGetReferencedKeyColumn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MddePackage.FOREIGN_KEY__REFERENCED_TABLE:
			setReferencedTable((Table) newValue);
			return;
		case MddePackage.FOREIGN_KEY__PRIMARY_FOREIGN_KEY:
			setPrimaryForeignKey((Boolean) newValue);
			return;
		case MddePackage.FOREIGN_KEY__ON_UPDATE:
			setOnUpdate((Referential_Action) newValue);
			return;
		case MddePackage.FOREIGN_KEY__ON_DELETE:
			setOnDelete((Referential_Action) newValue);
			return;
		case MddePackage.FOREIGN_KEY__CONSTRAINT_NAME:
			setConstraintName((String) newValue);
			return;
		case MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN:
			setReferencedKeyColumn((PrimaryKey) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MddePackage.FOREIGN_KEY__REFERENCED_TABLE:
			setReferencedTable((Table) null);
			return;
		case MddePackage.FOREIGN_KEY__PRIMARY_FOREIGN_KEY:
			setPrimaryForeignKey(PRIMARY_FOREIGN_KEY_EDEFAULT);
			return;
		case MddePackage.FOREIGN_KEY__ON_UPDATE:
			setOnUpdate(ON_UPDATE_EDEFAULT);
			return;
		case MddePackage.FOREIGN_KEY__ON_DELETE:
			setOnDelete(ON_DELETE_EDEFAULT);
			return;
		case MddePackage.FOREIGN_KEY__CONSTRAINT_NAME:
			setConstraintName(CONSTRAINT_NAME_EDEFAULT);
			return;
		case MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN:
			setReferencedKeyColumn((PrimaryKey) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MddePackage.FOREIGN_KEY__REFERENCED_TABLE:
			return referencedTable != null;
		case MddePackage.FOREIGN_KEY__PRIMARY_FOREIGN_KEY:
			return PRIMARY_FOREIGN_KEY_EDEFAULT == null ? primaryForeignKey != null
					: !PRIMARY_FOREIGN_KEY_EDEFAULT.equals(primaryForeignKey);
		case MddePackage.FOREIGN_KEY__ON_UPDATE:
			return onUpdate != ON_UPDATE_EDEFAULT;
		case MddePackage.FOREIGN_KEY__ON_DELETE:
			return onDelete != ON_DELETE_EDEFAULT;
		case MddePackage.FOREIGN_KEY__CONSTRAINT_NAME:
			return CONSTRAINT_NAME_EDEFAULT == null ? constraintName != null
					: !CONSTRAINT_NAME_EDEFAULT.equals(constraintName);
		case MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN:
			return referencedKeyColumn != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case MddePackage.FOREIGN_KEY___VALIDATE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP:
			return validateConstraintName((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (primaryForeignKey: ");
		result.append(primaryForeignKey);
		result.append(", OnUpdate: ");
		result.append(onUpdate);
		result.append(", OnDelete: ");
		result.append(onDelete);
		result.append(", constraintName: ");
		result.append(constraintName);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean ForeignKeyHasToReferenceAKeyColumn(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return false;
	}

} // ForeignKeyImpl

/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.util.MddeValidator;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.impl.TableImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.TableImpl#getColumns <em>Columns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableImpl extends NamedElementImpl implements Table {
	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> columns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MddePackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Database_Schema getSchema() {
		if (eContainerFeatureID() != MddePackage.TABLE__SCHEMA) return null;
		return (Database_Schema)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchema(Database_Schema newSchema, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchema, MddePackage.TABLE__SCHEMA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchema(Database_Schema newSchema) {
		if (newSchema != eInternalContainer() || (eContainerFeatureID() != MddePackage.TABLE__SCHEMA && newSchema != null)) {
			if (EcoreUtil.isAncestor(this, newSchema))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchema != null)
				msgs = ((InternalEObject)newSchema).eInverseAdd(this, MddePackage.DATABASE_SCHEMA__ENTITES, Database_Schema.class, msgs);
			msgs = basicSetSchema(newSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.TABLE__SCHEMA, newSchema, newSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Column> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentWithInverseEList<Column>(Column.class, this, MddePackage.TABLE__COLUMNS, MddePackage.COLUMN__TABLE);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<PrimaryKey> getPrimaryKeys() {
		EList<Column> columns = getColumns();
		EList<PrimaryKey> primaryKeys = new BasicEList<PrimaryKey>();
		for (Column c : columns) {
			if (c instanceof PrimaryKey)
				primaryKeys.add((PrimaryKey) c);
		}
		return primaryKeys;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public PrimaryKey getPrimaryKeyByName(String primaryKeyName) {
		for (PrimaryKey c : getPrimaryKeys()) {
			if (c.getName().equalsIgnoreCase(primaryKeyName))
				return c;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<ForeignKey> getForeignKeys() {
		EList<Column> columns = getColumns();
		EList<ForeignKey> foreignKeys = new BasicEList<ForeignKey>();
		for (Column c : columns) {
			if (c instanceof ForeignKey)
				foreignKeys.add((ForeignKey) c);
		}
		return foreignKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public PrimaryKey getMainPrimaryKey() {
		EList<PrimaryKey> primaryKeys = getPrimaryKeys();

		if (primaryKeys.size() == 0)
			return null;
		else if (primaryKeys.size() == 1)
			return primaryKeys.get(0);
		else {
			for (PrimaryKey key : primaryKeys) {
				if (key.getAutoIncrement())
					return key;
			}
		}
		return primaryKeys.get(0);
	}

	/**
	 * The cached validation expression for the '{@link #OnlyOneAutoIncrementColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Only One Auto Increment Column</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OnlyOneAutoIncrementColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ONLY_ONE_AUTO_INCREMENT_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'Incorrect table definition; The table ' + Table.name + '  can only have one auto column and it must be defined as a key!',\n" +
		"\tstatus : Boolean = self.columns-> notEmpty() and\n" +
		"\t\t((columns->one(c1 | c1.autoIncrement)) or (columns-> select(c1 | c1.autoIncrement) -> isEmpty()) or ((columns-> select(c1 | c1.oclIsTypeOf(PrimaryKey)) -> isEmpty()) and columns->exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n" +
		"}.status";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean OnlyOneAutoIncrementColumn(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			MddeValidator.validate
				(MddePackage.Literals.TABLE,
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 MddePackage.Literals.TABLE___ONLY_ONE_AUTO_INCREMENT_COLUMN__DIAGNOSTICCHAIN_MAP,
				 ONLY_ONE_AUTO_INCREMENT_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 MddeValidator.DIAGNOSTIC_SOURCE,
				 MddeValidator.TABLE__ONLY_ONE_AUTO_INCREMENT_COLUMN);
	}

	/**
	 * The cached validation expression for the '{@link #NonKeyAutoIncrementColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Non Key Auto Increment Column</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NonKeyAutoIncrementColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NON_KEY_AUTO_INCREMENT_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'Incorrect table definition; The table ' + Table.name + '  can only have one auto column and it must be defined as a key!',\n" +
		"\tstatus : Boolean = self.columns-> notEmpty() and\n" +
		"\t\t((columns->one(c1 | c1.oclIsTypeOf(PrimaryKey) and c1.autoIncrement)) or ((columns-> select(c1 | c1.oclIsTypeOf(PrimaryKey)) -> isEmpty()) and columns->exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)) or (columns-> select(c1 | c1.autoIncrement) -> isEmpty()))\n" +
		"}.status";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NonKeyAutoIncrementColumn(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			MddeValidator.validate
				(MddePackage.Literals.TABLE,
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 MddePackage.Literals.TABLE___NON_KEY_AUTO_INCREMENT_COLUMN__DIAGNOSTICCHAIN_MAP,
				 NON_KEY_AUTO_INCREMENT_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 MddeValidator.DIAGNOSTIC_SOURCE,
				 MddeValidator.TABLE__NON_KEY_AUTO_INCREMENT_COLUMN);
	}

	/**
	 * The cached validation expression for the '{@link #TableRequiresAKeyColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Table Requires AKey Column</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TableRequiresAKeyColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_REQUIRES_AKEY_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'The Table ' + Table.name + ' requires a primary key or a set of primary foreign keys!',\n" +
		"\tstatus : Boolean = self.columns-> notEmpty() and\n" +
		"\t\t(columns->exists(oclIsTypeOf(PrimaryKey)) or columns -> exists(c1 | (c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n" +
		"}.status";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean TableRequiresAKeyColumn(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			MddeValidator.validate
				(MddePackage.Literals.TABLE,
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 MddePackage.Literals.TABLE___TABLE_REQUIRES_AKEY_COLUMN__DIAGNOSTICCHAIN_MAP,
				 TABLE_REQUIRES_AKEY_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 MddeValidator.DIAGNOSTIC_SOURCE,
				 MddeValidator.TABLE__TABLE_REQUIRES_AKEY_COLUMN);
	}

	/**
	 * The cached validation expression for the '{@link #TableRequiresAtLeastOneColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Table Requires At Least One Column</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TableRequiresAtLeastOneColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_REQUIRES_AT_LEAST_ONE_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'The Table ' + Table.name + ' requires at least one column!',\n" +
		"\tstatus : Boolean = self.columns->notEmpty()\n" +
		"}.status";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean TableRequiresAtLeastOneColumn(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			MddeValidator.validate
				(MddePackage.Literals.TABLE,
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 MddePackage.Literals.TABLE___TABLE_REQUIRES_AT_LEAST_ONE_COLUMN__DIAGNOSTICCHAIN_MAP,
				 TABLE_REQUIRES_AT_LEAST_ONE_COLUMN_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 MddeValidator.DIAGNOSTIC_SOURCE,
				 MddeValidator.TABLE__TABLE_REQUIRES_AT_LEAST_ONE_COLUMN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MddePackage.TABLE__SCHEMA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchema((Database_Schema)otherEnd, msgs);
			case MddePackage.TABLE__COLUMNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getColumns()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MddePackage.TABLE__SCHEMA:
				return basicSetSchema(null, msgs);
			case MddePackage.TABLE__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MddePackage.TABLE__SCHEMA:
				return eInternalContainer().eInverseRemove(this, MddePackage.DATABASE_SCHEMA__ENTITES, Database_Schema.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MddePackage.TABLE__SCHEMA:
				return getSchema();
			case MddePackage.TABLE__COLUMNS:
				return getColumns();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MddePackage.TABLE__SCHEMA:
				setSchema((Database_Schema)newValue);
				return;
			case MddePackage.TABLE__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends Column>)newValue);
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
			case MddePackage.TABLE__SCHEMA:
				setSchema((Database_Schema)null);
				return;
			case MddePackage.TABLE__COLUMNS:
				getColumns().clear();
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
			case MddePackage.TABLE__SCHEMA:
				return getSchema() != null;
			case MddePackage.TABLE__COLUMNS:
				return columns != null && !columns.isEmpty();
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
			case MddePackage.TABLE___GET_PRIMARY_KEYS:
				return getPrimaryKeys();
			case MddePackage.TABLE___GET_PRIMARY_KEY_BY_NAME__STRING:
				return getPrimaryKeyByName((String)arguments.get(0));
			case MddePackage.TABLE___GET_FOREIGN_KEYS:
				return getForeignKeys();
			case MddePackage.TABLE___GET_MAIN_PRIMARY_KEY:
				return getMainPrimaryKey();
			case MddePackage.TABLE___ONLY_ONE_AUTO_INCREMENT_COLUMN__DIAGNOSTICCHAIN_MAP:
				return OnlyOneAutoIncrementColumn((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MddePackage.TABLE___NON_KEY_AUTO_INCREMENT_COLUMN__DIAGNOSTICCHAIN_MAP:
				return NonKeyAutoIncrementColumn((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MddePackage.TABLE___TABLE_REQUIRES_AKEY_COLUMN__DIAGNOSTICCHAIN_MAP:
				return TableRequiresAKeyColumn((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MddePackage.TABLE___TABLE_REQUIRES_AT_LEAST_ONE_COLUMN__DIAGNOSTICCHAIN_MAP:
				return TableRequiresAtLeastOneColumn((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TableImpl

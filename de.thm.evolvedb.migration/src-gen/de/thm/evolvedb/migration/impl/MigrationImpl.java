/**
 */
package de.thm.evolvedb.migration.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.SchemaModificationOperator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Migration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.impl.MigrationImpl#getSymmetricDifference <em>Symmetric Difference</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.MigrationImpl#getSchemaModificationOperators <em>Schema Modification Operators</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.MigrationImpl#getSymetricDifferenceModel <em>Symetric Difference Model</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.impl.MigrationImpl#getUriSymetricDifferenceModel <em>Uri Symetric Difference Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MigrationImpl extends MinimalEObjectImpl.Container implements Migration {
	/**
	 * The cached value of the '{@link #getSymmetricDifference() <em>Symmetric Difference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymmetricDifference()
	 * @generated
	 * @ordered
	 */
	protected SymmetricDifference symmetricDifference;

	/**
	 * The cached value of the '{@link #getSchemaModificationOperators() <em>Schema Modification Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaModificationOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<SchemaModificationOperator> schemaModificationOperators;

	/**
	 * The default value of the '{@link #getSymetricDifferenceModel() <em>Symetric Difference Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymetricDifferenceModel()
	 * @generated
	 * @ordered
	 */
	protected static final Resource SYMETRIC_DIFFERENCE_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymetricDifferenceModel() <em>Symetric Difference Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymetricDifferenceModel()
	 * @generated
	 * @ordered
	 */
	protected Resource symetricDifferenceModel = SYMETRIC_DIFFERENCE_MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUriSymetricDifferenceModel() <em>Uri Symetric Difference Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriSymetricDifferenceModel()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_SYMETRIC_DIFFERENCE_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUriSymetricDifferenceModel() <em>Uri Symetric Difference Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriSymetricDifferenceModel()
	 * @generated
	 * @ordered
	 */
	protected String uriSymetricDifferenceModel = URI_SYMETRIC_DIFFERENCE_MODEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.MIGRATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SymmetricDifference getSymmetricDifference() {
		if (symmetricDifference != null && symmetricDifference.eIsProxy()) {
			InternalEObject oldSymmetricDifference = (InternalEObject)symmetricDifference;
			symmetricDifference = (SymmetricDifference)eResolveProxy(oldSymmetricDifference);
			if (symmetricDifference != oldSymmetricDifference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MigrationPackage.MIGRATION__SYMMETRIC_DIFFERENCE, oldSymmetricDifference, symmetricDifference));
			}
		}
		return symmetricDifference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricDifference basicGetSymmetricDifference() {
		return symmetricDifference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymmetricDifference(SymmetricDifference newSymmetricDifference) {
		SymmetricDifference oldSymmetricDifference = symmetricDifference;
		symmetricDifference = newSymmetricDifference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__SYMMETRIC_DIFFERENCE, oldSymmetricDifference, symmetricDifference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SchemaModificationOperator> getSchemaModificationOperators() {
		if (schemaModificationOperators == null) {
			schemaModificationOperators = new EObjectContainmentWithInverseEList<SchemaModificationOperator>(SchemaModificationOperator.class, this, MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS, MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__MIGRATION);
		}
		return schemaModificationOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource getSymetricDifferenceModel() {
		return symetricDifferenceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymetricDifferenceModel(Resource newSymetricDifferenceModel) {
		Resource oldSymetricDifferenceModel = symetricDifferenceModel;
		symetricDifferenceModel = newSymetricDifferenceModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__SYMETRIC_DIFFERENCE_MODEL, oldSymetricDifferenceModel, symetricDifferenceModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUriSymetricDifferenceModel() {
		return uriSymetricDifferenceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUriSymetricDifferenceModel(String newUriSymetricDifferenceModel) {
		String oldUriSymetricDifferenceModel = uriSymetricDifferenceModel;
		uriSymetricDifferenceModel = newUriSymetricDifferenceModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL, oldUriSymetricDifferenceModel, uriSymetricDifferenceModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<ResolvableOperator> getResolvableSMO() {
		EList<SchemaModificationOperator> operators = getSchemaModificationOperators();
		EList<ResolvableOperator> resolvableOperators = new BasicEList<ResolvableOperator>();
		for (SchemaModificationOperator operator : operators) {
			if(operator instanceof ResolvableOperator)
				resolvableOperators.add((ResolvableOperator) operator);
		}
		return resolvableOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<PartiallyResolvable> getPartiallyResovableSMO() {
		EList<SchemaModificationOperator> operators = getSchemaModificationOperators();
		EList<PartiallyResolvable> partiallyResolvables = new BasicEList<PartiallyResolvable>();
		for (SchemaModificationOperator operator : operators) {
			if(operator instanceof PartiallyResolvable)
				partiallyResolvables.add((PartiallyResolvable) operator);
		}
		return partiallyResolvables;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */ 
	@Override
	public EList<NotAutomaticallyResolvable> getNotAutimaticallyResolvable() {
		EList<SchemaModificationOperator> operators = getSchemaModificationOperators();
		EList<NotAutomaticallyResolvable> notAutomaticallyResolvable = new BasicEList<NotAutomaticallyResolvable>();
		for (SchemaModificationOperator operator : operators) {
			if(operator instanceof NotAutomaticallyResolvable)
				notAutomaticallyResolvable.add((NotAutomaticallyResolvable) operator);
		}
		return notAutomaticallyResolvable;
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
			case MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSchemaModificationOperators()).basicAdd(otherEnd, msgs);
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
			case MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS:
				return ((InternalEList<?>)getSchemaModificationOperators()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MigrationPackage.MIGRATION__SYMMETRIC_DIFFERENCE:
				if (resolve) return getSymmetricDifference();
				return basicGetSymmetricDifference();
			case MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS:
				return getSchemaModificationOperators();
			case MigrationPackage.MIGRATION__SYMETRIC_DIFFERENCE_MODEL:
				return getSymetricDifferenceModel();
			case MigrationPackage.MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL:
				return getUriSymetricDifferenceModel();
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
			case MigrationPackage.MIGRATION__SYMMETRIC_DIFFERENCE:
				setSymmetricDifference((SymmetricDifference)newValue);
				return;
			case MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS:
				getSchemaModificationOperators().clear();
				getSchemaModificationOperators().addAll((Collection<? extends SchemaModificationOperator>)newValue);
				return;
			case MigrationPackage.MIGRATION__SYMETRIC_DIFFERENCE_MODEL:
				setSymetricDifferenceModel((Resource)newValue);
				return;
			case MigrationPackage.MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL:
				setUriSymetricDifferenceModel((String)newValue);
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
			case MigrationPackage.MIGRATION__SYMMETRIC_DIFFERENCE:
				setSymmetricDifference((SymmetricDifference)null);
				return;
			case MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS:
				getSchemaModificationOperators().clear();
				return;
			case MigrationPackage.MIGRATION__SYMETRIC_DIFFERENCE_MODEL:
				setSymetricDifferenceModel(SYMETRIC_DIFFERENCE_MODEL_EDEFAULT);
				return;
			case MigrationPackage.MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL:
				setUriSymetricDifferenceModel(URI_SYMETRIC_DIFFERENCE_MODEL_EDEFAULT);
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
			case MigrationPackage.MIGRATION__SYMMETRIC_DIFFERENCE:
				return symmetricDifference != null;
			case MigrationPackage.MIGRATION__SCHEMA_MODIFICATION_OPERATORS:
				return schemaModificationOperators != null && !schemaModificationOperators.isEmpty();
			case MigrationPackage.MIGRATION__SYMETRIC_DIFFERENCE_MODEL:
				return SYMETRIC_DIFFERENCE_MODEL_EDEFAULT == null ? symetricDifferenceModel != null : !SYMETRIC_DIFFERENCE_MODEL_EDEFAULT.equals(symetricDifferenceModel);
			case MigrationPackage.MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL:
				return URI_SYMETRIC_DIFFERENCE_MODEL_EDEFAULT == null ? uriSymetricDifferenceModel != null : !URI_SYMETRIC_DIFFERENCE_MODEL_EDEFAULT.equals(uriSymetricDifferenceModel);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MigrationPackage.MIGRATION___GET_RESOLVABLE_SMO:
				return getResolvableSMO();
			case MigrationPackage.MIGRATION___GET_PARTIALLY_RESOVABLE_SMO:
				return getPartiallyResovableSMO();
			case MigrationPackage.MIGRATION___GET_NOT_AUTIMATICALLY_RESOLVABLE:
				return getNotAutimaticallyResolvable();
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
		result.append(" (symetricDifferenceModel: ");
		result.append(symetricDifferenceModel);
		result.append(", uriSymetricDifferenceModel: ");
		result.append(uriSymetricDifferenceModel);
		result.append(')');
		return result.toString();
	}

} //MigrationImpl

/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyValueType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyImpl#getMinCount <em>Min Count</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyImpl#getMaxCount <em>Max Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyImpl extends MinimalEObjectImpl.Container implements Property {
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
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected PropertyValueType value;

	/**
	 * The default value of the '{@link #getMinCount() <em>Min Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinCount() <em>Min Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCount()
	 * @generated
	 * @ordered
	 */
	protected int minCount = MIN_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxCount() <em>Max Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxCount() <em>Max Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCount()
	 * @generated
	 * @ordered
	 */
	protected int maxCount = MAX_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.PROPERTY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueType getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(PropertyValueType newValue, NotificationChain msgs) {
		PropertyValueType oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY__VALUE,
					oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(PropertyValueType newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - GraphPackage.PROPERTY__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphPackage.PROPERTY__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinCount() {
		return minCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCount(int newMinCount) {
		int oldMinCount = minCount;
		minCount = newMinCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY__MIN_COUNT, oldMinCount,
					minCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxCount() {
		return maxCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCount(int newMaxCount) {
		int oldMaxCount = maxCount;
		maxCount = newMaxCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY__MAX_COUNT, oldMaxCount,
					maxCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GraphPackage.PROPERTY__VALUE:
			return basicSetValue(null, msgs);
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
		case GraphPackage.PROPERTY__NAME:
			return getName();
		case GraphPackage.PROPERTY__VALUE:
			return getValue();
		case GraphPackage.PROPERTY__MIN_COUNT:
			return getMinCount();
		case GraphPackage.PROPERTY__MAX_COUNT:
			return getMaxCount();
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
		case GraphPackage.PROPERTY__NAME:
			setName((String) newValue);
			return;
		case GraphPackage.PROPERTY__VALUE:
			setValue((PropertyValueType) newValue);
			return;
		case GraphPackage.PROPERTY__MIN_COUNT:
			setMinCount((Integer) newValue);
			return;
		case GraphPackage.PROPERTY__MAX_COUNT:
			setMaxCount((Integer) newValue);
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
		case GraphPackage.PROPERTY__NAME:
			setName(NAME_EDEFAULT);
			return;
		case GraphPackage.PROPERTY__VALUE:
			setValue((PropertyValueType) null);
			return;
		case GraphPackage.PROPERTY__MIN_COUNT:
			setMinCount(MIN_COUNT_EDEFAULT);
			return;
		case GraphPackage.PROPERTY__MAX_COUNT:
			setMaxCount(MAX_COUNT_EDEFAULT);
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
		case GraphPackage.PROPERTY__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case GraphPackage.PROPERTY__VALUE:
			return value != null;
		case GraphPackage.PROPERTY__MIN_COUNT:
			return minCount != MIN_COUNT_EDEFAULT;
		case GraphPackage.PROPERTY__MAX_COUNT:
			return maxCount != MAX_COUNT_EDEFAULT;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", minCount: ");
		result.append(minCount);
		result.append(", maxCount: ");
		result.append(maxCount);
		result.append(')');
		return result.toString();
	}

} //PropertyImpl

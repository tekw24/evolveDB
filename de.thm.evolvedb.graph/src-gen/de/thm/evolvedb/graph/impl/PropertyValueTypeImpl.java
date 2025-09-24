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
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyValueTypeImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyValueTypeImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyValueTypeImpl extends MinimalEObjectImpl.Container implements PropertyValueType {
	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyValueTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.PROPERTY_VALUE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY_VALUE_TYPE__NULLABLE,
					oldNullable, nullable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (eContainerFeatureID() != GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY)
			return null;
		return (Property) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newProperty, GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		if (newProperty != eInternalContainer()
				|| (eContainerFeatureID() != GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY && newProperty != null)) {
			if (EcoreUtil.isAncestor(this, newProperty))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProperty != null)
				msgs = ((InternalEObject) newProperty).eInverseAdd(this, GraphPackage.PROPERTY__VALUE, Property.class,
						msgs);
			msgs = basicSetProperty(newProperty, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY,
					newProperty, newProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetProperty((Property) otherEnd, msgs);
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
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			return basicSetProperty(null, msgs);
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
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			return eInternalContainer().eInverseRemove(this, GraphPackage.PROPERTY__VALUE, Property.class, msgs);
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
		case GraphPackage.PROPERTY_VALUE_TYPE__NULLABLE:
			return isNullable();
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			return getProperty();
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
		case GraphPackage.PROPERTY_VALUE_TYPE__NULLABLE:
			setNullable((Boolean) newValue);
			return;
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			setProperty((Property) newValue);
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
		case GraphPackage.PROPERTY_VALUE_TYPE__NULLABLE:
			setNullable(NULLABLE_EDEFAULT);
			return;
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			setProperty((Property) null);
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
		case GraphPackage.PROPERTY_VALUE_TYPE__NULLABLE:
			return nullable != NULLABLE_EDEFAULT;
		case GraphPackage.PROPERTY_VALUE_TYPE__PROPERTY:
			return getProperty() != null;
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
		result.append(" (nullable: ");
		result.append(nullable);
		result.append(')');
		return result.toString();
	}

} //PropertyValueTypeImpl

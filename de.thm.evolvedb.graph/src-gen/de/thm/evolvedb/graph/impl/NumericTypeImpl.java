/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.NumericDataTypes;
import de.thm.evolvedb.graph.NumericType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.impl.NumericTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.NumericTypeImpl#getIntegralPart <em>Integral Part</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.NumericTypeImpl#getFractionalPart <em>Fractional Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericTypeImpl extends PropertyValueTypeImpl implements NumericType {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final NumericDataTypes TYPE_EDEFAULT = NumericDataTypes.DECIMAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected NumericDataTypes type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntegralPart() <em>Integral Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegralPart()
	 * @generated
	 * @ordered
	 */
	protected static final int INTEGRAL_PART_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntegralPart() <em>Integral Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegralPart()
	 * @generated
	 * @ordered
	 */
	protected int integralPart = INTEGRAL_PART_EDEFAULT;

	/**
	 * The default value of the '{@link #getFractionalPart() <em>Fractional Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionalPart()
	 * @generated
	 * @ordered
	 */
	protected static final int FRACTIONAL_PART_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFractionalPart() <em>Fractional Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionalPart()
	 * @generated
	 * @ordered
	 */
	protected int fractionalPart = FRACTIONAL_PART_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.NUMERIC_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericDataTypes getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(NumericDataTypes newType) {
		NumericDataTypes oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.NUMERIC_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntegralPart() {
		return integralPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegralPart(int newIntegralPart) {
		int oldIntegralPart = integralPart;
		integralPart = newIntegralPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.NUMERIC_TYPE__INTEGRAL_PART,
					oldIntegralPart, integralPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFractionalPart() {
		return fractionalPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFractionalPart(int newFractionalPart) {
		int oldFractionalPart = fractionalPart;
		fractionalPart = newFractionalPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.NUMERIC_TYPE__FRACTIONAL_PART,
					oldFractionalPart, fractionalPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GraphPackage.NUMERIC_TYPE__TYPE:
			return getType();
		case GraphPackage.NUMERIC_TYPE__INTEGRAL_PART:
			return getIntegralPart();
		case GraphPackage.NUMERIC_TYPE__FRACTIONAL_PART:
			return getFractionalPart();
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
		case GraphPackage.NUMERIC_TYPE__TYPE:
			setType((NumericDataTypes) newValue);
			return;
		case GraphPackage.NUMERIC_TYPE__INTEGRAL_PART:
			setIntegralPart((Integer) newValue);
			return;
		case GraphPackage.NUMERIC_TYPE__FRACTIONAL_PART:
			setFractionalPart((Integer) newValue);
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
		case GraphPackage.NUMERIC_TYPE__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case GraphPackage.NUMERIC_TYPE__INTEGRAL_PART:
			setIntegralPart(INTEGRAL_PART_EDEFAULT);
			return;
		case GraphPackage.NUMERIC_TYPE__FRACTIONAL_PART:
			setFractionalPart(FRACTIONAL_PART_EDEFAULT);
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
		case GraphPackage.NUMERIC_TYPE__TYPE:
			return type != TYPE_EDEFAULT;
		case GraphPackage.NUMERIC_TYPE__INTEGRAL_PART:
			return integralPart != INTEGRAL_PART_EDEFAULT;
		case GraphPackage.NUMERIC_TYPE__FRACTIONAL_PART:
			return fractionalPart != FRACTIONAL_PART_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", integralPart: ");
		result.append(integralPart);
		result.append(", fractionalPart: ");
		result.append(fractionalPart);
		result.append(')');
		return result.toString();
	}

} //NumericTypeImpl

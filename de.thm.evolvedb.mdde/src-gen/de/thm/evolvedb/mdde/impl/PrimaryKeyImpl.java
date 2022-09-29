/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.PrimaryKey;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.impl.PrimaryKeyImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.PrimaryKeyImpl#getReferencedBy <em>Referenced By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimaryKeyImpl extends ColumnImpl implements PrimaryKey {
	/**
	 * The default value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PRIMARY_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected Boolean primaryKey = PRIMARY_KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedBy() <em>Referenced By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ForeignKey> referencedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimaryKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MddePackage.Literals.PRIMARY_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryKey(Boolean newPrimaryKey) {
		Boolean oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.PRIMARY_KEY__PRIMARY_KEY, oldPrimaryKey, primaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ForeignKey> getReferencedBy() {
		if (referencedBy == null) {
			referencedBy = new EObjectWithInverseResolvingEList<ForeignKey>(ForeignKey.class, this, MddePackage.PRIMARY_KEY__REFERENCED_BY, MddePackage.FOREIGN_KEY__REFERENCED_KEY_COLUMN);
		}
		return referencedBy;
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
			case MddePackage.PRIMARY_KEY__REFERENCED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferencedBy()).basicAdd(otherEnd, msgs);
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
			case MddePackage.PRIMARY_KEY__REFERENCED_BY:
				return ((InternalEList<?>)getReferencedBy()).basicRemove(otherEnd, msgs);
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
			case MddePackage.PRIMARY_KEY__PRIMARY_KEY:
				return getPrimaryKey();
			case MddePackage.PRIMARY_KEY__REFERENCED_BY:
				return getReferencedBy();
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
			case MddePackage.PRIMARY_KEY__PRIMARY_KEY:
				setPrimaryKey((Boolean)newValue);
				return;
			case MddePackage.PRIMARY_KEY__REFERENCED_BY:
				getReferencedBy().clear();
				getReferencedBy().addAll((Collection<? extends ForeignKey>)newValue);
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
			case MddePackage.PRIMARY_KEY__PRIMARY_KEY:
				setPrimaryKey(PRIMARY_KEY_EDEFAULT);
				return;
			case MddePackage.PRIMARY_KEY__REFERENCED_BY:
				getReferencedBy().clear();
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
			case MddePackage.PRIMARY_KEY__PRIMARY_KEY:
				return PRIMARY_KEY_EDEFAULT == null ? primaryKey != null : !PRIMARY_KEY_EDEFAULT.equals(primaryKey);
			case MddePackage.PRIMARY_KEY__REFERENCED_BY:
				return referencedBy != null && !referencedBy.isEmpty();
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
		result.append(" (primaryKey: ");
		result.append(primaryKey);
		result.append(')');
		return result.toString();
	}

} //PrimaryKeyImpl

/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.Table;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.impl.Database_SchemaImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.Database_SchemaImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.Database_SchemaImpl#getEntites <em>Entites</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Database_SchemaImpl extends NamedElementImpl implements Database_Schema {
	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntites() <em>Entites</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntites()
	 * @generated
	 * @ordered
	 */
	protected EList<Table> entites;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Database_SchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MddePackage.Literals.DATABASE_SCHEMA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.DATABASE_SCHEMA__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.DATABASE_SCHEMA__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Table> getEntites() {
		if (entites == null) {
			entites = new EObjectContainmentWithInverseEList<Table>(Table.class, this, MddePackage.DATABASE_SCHEMA__ENTITES, MddePackage.TABLE__SCHEMA);
		}
		return entites;
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
			case MddePackage.DATABASE_SCHEMA__ENTITES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntites()).basicAdd(otherEnd, msgs);
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
			case MddePackage.DATABASE_SCHEMA__ENTITES:
				return ((InternalEList<?>)getEntites()).basicRemove(otherEnd, msgs);
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
			case MddePackage.DATABASE_SCHEMA__LOCATION:
				return getLocation();
			case MddePackage.DATABASE_SCHEMA__VERSION:
				return getVersion();
			case MddePackage.DATABASE_SCHEMA__ENTITES:
				return getEntites();
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
			case MddePackage.DATABASE_SCHEMA__LOCATION:
				setLocation((String)newValue);
				return;
			case MddePackage.DATABASE_SCHEMA__VERSION:
				setVersion((String)newValue);
				return;
			case MddePackage.DATABASE_SCHEMA__ENTITES:
				getEntites().clear();
				getEntites().addAll((Collection<? extends Table>)newValue);
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
			case MddePackage.DATABASE_SCHEMA__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case MddePackage.DATABASE_SCHEMA__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case MddePackage.DATABASE_SCHEMA__ENTITES:
				getEntites().clear();
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
			case MddePackage.DATABASE_SCHEMA__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case MddePackage.DATABASE_SCHEMA__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case MddePackage.DATABASE_SCHEMA__ENTITES:
				return entites != null && !entites.isEmpty();
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
		result.append(" (location: ");
		result.append(location);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //Database_SchemaImpl

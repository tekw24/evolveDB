/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.GraphItem;
import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.GraphType;
import de.thm.evolvedb.graph.PropertyGraph;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl#isClosed <em>Closed</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl#getGraphtype <em>Graphtype</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl#getItems <em>Items</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyGraphImpl extends MinimalEObjectImpl.Container implements PropertyGraph {
	/**
	 * The default value of the '{@link #isClosed() <em>Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClosed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLOSED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isClosed() <em>Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClosed()
	 * @generated
	 * @ordered
	 */
	protected boolean closed = CLOSED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGraphtype() <em>Graphtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphtype()
	 * @generated
	 * @ordered
	 */
	protected static final GraphType GRAPHTYPE_EDEFAULT = GraphType.MULTIGRAPH;

	/**
	 * The cached value of the '{@link #getGraphtype() <em>Graphtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphtype()
	 * @generated
	 * @ordered
	 */
	protected GraphType graphtype = GRAPHTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphItem> items;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.PROPERTY_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClosed(boolean newClosed) {
		boolean oldClosed = closed;
		closed = newClosed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY_GRAPH__CLOSED, oldClosed,
					closed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphType getGraphtype() {
		return graphtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphtype(GraphType newGraphtype) {
		GraphType oldGraphtype = graphtype;
		graphtype = newGraphtype == null ? GRAPHTYPE_EDEFAULT : newGraphtype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY_GRAPH__GRAPHTYPE, oldGraphtype,
					graphtype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentWithInverseEList<GraphItem>(GraphItem.class, this,
					GraphPackage.PROPERTY_GRAPH__ITEMS, GraphPackage.GRAPH_ITEM__GRAPH);
		}
		return items;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY_GRAPH__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.PROPERTY_GRAPH__LOCATION, oldLocation,
					location));
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
		case GraphPackage.PROPERTY_GRAPH__ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getItems()).basicAdd(otherEnd, msgs);
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
		case GraphPackage.PROPERTY_GRAPH__ITEMS:
			return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
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
		case GraphPackage.PROPERTY_GRAPH__CLOSED:
			return isClosed();
		case GraphPackage.PROPERTY_GRAPH__GRAPHTYPE:
			return getGraphtype();
		case GraphPackage.PROPERTY_GRAPH__ITEMS:
			return getItems();
		case GraphPackage.PROPERTY_GRAPH__NAME:
			return getName();
		case GraphPackage.PROPERTY_GRAPH__LOCATION:
			return getLocation();
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
		case GraphPackage.PROPERTY_GRAPH__CLOSED:
			setClosed((Boolean) newValue);
			return;
		case GraphPackage.PROPERTY_GRAPH__GRAPHTYPE:
			setGraphtype((GraphType) newValue);
			return;
		case GraphPackage.PROPERTY_GRAPH__ITEMS:
			getItems().clear();
			getItems().addAll((Collection<? extends GraphItem>) newValue);
			return;
		case GraphPackage.PROPERTY_GRAPH__NAME:
			setName((String) newValue);
			return;
		case GraphPackage.PROPERTY_GRAPH__LOCATION:
			setLocation((String) newValue);
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
		case GraphPackage.PROPERTY_GRAPH__CLOSED:
			setClosed(CLOSED_EDEFAULT);
			return;
		case GraphPackage.PROPERTY_GRAPH__GRAPHTYPE:
			setGraphtype(GRAPHTYPE_EDEFAULT);
			return;
		case GraphPackage.PROPERTY_GRAPH__ITEMS:
			getItems().clear();
			return;
		case GraphPackage.PROPERTY_GRAPH__NAME:
			setName(NAME_EDEFAULT);
			return;
		case GraphPackage.PROPERTY_GRAPH__LOCATION:
			setLocation(LOCATION_EDEFAULT);
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
		case GraphPackage.PROPERTY_GRAPH__CLOSED:
			return closed != CLOSED_EDEFAULT;
		case GraphPackage.PROPERTY_GRAPH__GRAPHTYPE:
			return graphtype != GRAPHTYPE_EDEFAULT;
		case GraphPackage.PROPERTY_GRAPH__ITEMS:
			return items != null && !items.isEmpty();
		case GraphPackage.PROPERTY_GRAPH__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case GraphPackage.PROPERTY_GRAPH__LOCATION:
			return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
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
		result.append(" (closed: ");
		result.append(closed);
		result.append(", graphtype: ");
		result.append(graphtype);
		result.append(", name: ");
		result.append(name);
		result.append(", location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //PropertyGraphImpl

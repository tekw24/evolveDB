/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.impl.NodeTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.NodeTypeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.NodeTypeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.NodeTypeImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeTypeImpl extends GraphItemImpl implements NodeType {
	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeLabel> label;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeType> outgoing;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeType> incoming;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.NODE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeLabel> getLabel() {
		if (label == null) {
			label = new EObjectWithInverseResolvingEList.ManyInverse<NodeLabel>(NodeLabel.class, this,
					GraphPackage.NODE_TYPE__LABEL, GraphPackage.NODE_LABEL__NODES);
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgeType> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<EdgeType>(EdgeType.class, this,
					GraphPackage.NODE_TYPE__OUTGOING, GraphPackage.EDGE_TYPE__SRC);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgeType> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<EdgeType>(EdgeType.class, this,
					GraphPackage.NODE_TYPE__INCOMING, GraphPackage.EDGE_TYPE__TGT);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this,
					GraphPackage.NODE_TYPE__PROPERTIES);
		}
		return properties;
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
		case GraphPackage.NODE_TYPE__LABEL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getLabel()).basicAdd(otherEnd, msgs);
		case GraphPackage.NODE_TYPE__OUTGOING:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutgoing()).basicAdd(otherEnd, msgs);
		case GraphPackage.NODE_TYPE__INCOMING:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncoming()).basicAdd(otherEnd, msgs);
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
		case GraphPackage.NODE_TYPE__LABEL:
			return ((InternalEList<?>) getLabel()).basicRemove(otherEnd, msgs);
		case GraphPackage.NODE_TYPE__OUTGOING:
			return ((InternalEList<?>) getOutgoing()).basicRemove(otherEnd, msgs);
		case GraphPackage.NODE_TYPE__INCOMING:
			return ((InternalEList<?>) getIncoming()).basicRemove(otherEnd, msgs);
		case GraphPackage.NODE_TYPE__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
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
		case GraphPackage.NODE_TYPE__LABEL:
			return getLabel();
		case GraphPackage.NODE_TYPE__OUTGOING:
			return getOutgoing();
		case GraphPackage.NODE_TYPE__INCOMING:
			return getIncoming();
		case GraphPackage.NODE_TYPE__PROPERTIES:
			return getProperties();
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
		case GraphPackage.NODE_TYPE__LABEL:
			getLabel().clear();
			getLabel().addAll((Collection<? extends NodeLabel>) newValue);
			return;
		case GraphPackage.NODE_TYPE__OUTGOING:
			getOutgoing().clear();
			getOutgoing().addAll((Collection<? extends EdgeType>) newValue);
			return;
		case GraphPackage.NODE_TYPE__INCOMING:
			getIncoming().clear();
			getIncoming().addAll((Collection<? extends EdgeType>) newValue);
			return;
		case GraphPackage.NODE_TYPE__PROPERTIES:
			getProperties().clear();
			getProperties().addAll((Collection<? extends Property>) newValue);
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
		case GraphPackage.NODE_TYPE__LABEL:
			getLabel().clear();
			return;
		case GraphPackage.NODE_TYPE__OUTGOING:
			getOutgoing().clear();
			return;
		case GraphPackage.NODE_TYPE__INCOMING:
			getIncoming().clear();
			return;
		case GraphPackage.NODE_TYPE__PROPERTIES:
			getProperties().clear();
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
		case GraphPackage.NODE_TYPE__LABEL:
			return label != null && !label.isEmpty();
		case GraphPackage.NODE_TYPE__OUTGOING:
			return outgoing != null && !outgoing.isEmpty();
		case GraphPackage.NODE_TYPE__INCOMING:
			return incoming != null && !incoming.isEmpty();
		case GraphPackage.NODE_TYPE__PROPERTIES:
			return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeTypeImpl

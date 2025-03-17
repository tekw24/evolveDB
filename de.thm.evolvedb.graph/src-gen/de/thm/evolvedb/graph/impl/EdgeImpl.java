/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.Edge;
import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.impl.EdgeImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.EdgeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.EdgeImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.impl.EdgeImpl#getTgt <em>Tgt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeImpl extends GraphItemImpl implements Edge {
	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeLabel> labels;

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
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected NodeType src;

	/**
	 * The cached value of the '{@link #getTgt() <em>Tgt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTgt()
	 * @generated
	 * @ordered
	 */
	protected NodeType tgt;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgeLabel> getLabels() {
		if (labels == null) {
			labels = new EObjectWithInverseResolvingEList.ManyInverse<EdgeLabel>(EdgeLabel.class, this,
					GraphPackage.EDGE__LABELS, GraphPackage.EDGE_LABEL__EDGES);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, GraphPackage.EDGE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject) src;
			src = (NodeType) eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__SRC, oldSrc, src));
			}
		}
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSrc(NodeType newSrc, NotificationChain msgs) {
		NodeType oldSrc = src;
		src = newSrc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__SRC,
					oldSrc, newSrc);
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
	public void setSrc(NodeType newSrc) {
		if (newSrc != src) {
			NotificationChain msgs = null;
			if (src != null)
				msgs = ((InternalEObject) src).eInverseRemove(this, GraphPackage.NODE_TYPE__OUTGOING, NodeType.class,
						msgs);
			if (newSrc != null)
				msgs = ((InternalEObject) newSrc).eInverseAdd(this, GraphPackage.NODE_TYPE__OUTGOING, NodeType.class,
						msgs);
			msgs = basicSetSrc(newSrc, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__SRC, newSrc, newSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getTgt() {
		if (tgt != null && tgt.eIsProxy()) {
			InternalEObject oldTgt = (InternalEObject) tgt;
			tgt = (NodeType) eResolveProxy(oldTgt);
			if (tgt != oldTgt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__TGT, oldTgt, tgt));
			}
		}
		return tgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType basicGetTgt() {
		return tgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTgt(NodeType newTgt, NotificationChain msgs) {
		NodeType oldTgt = tgt;
		tgt = newTgt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TGT,
					oldTgt, newTgt);
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
	public void setTgt(NodeType newTgt) {
		if (newTgt != tgt) {
			NotificationChain msgs = null;
			if (tgt != null)
				msgs = ((InternalEObject) tgt).eInverseRemove(this, GraphPackage.NODE_TYPE__INCOMING, NodeType.class,
						msgs);
			if (newTgt != null)
				msgs = ((InternalEObject) newTgt).eInverseAdd(this, GraphPackage.NODE_TYPE__INCOMING, NodeType.class,
						msgs);
			msgs = basicSetTgt(newTgt, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TGT, newTgt, newTgt));
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
		case GraphPackage.EDGE__LABELS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getLabels()).basicAdd(otherEnd, msgs);
		case GraphPackage.EDGE__SRC:
			if (src != null)
				msgs = ((InternalEObject) src).eInverseRemove(this, GraphPackage.NODE_TYPE__OUTGOING, NodeType.class,
						msgs);
			return basicSetSrc((NodeType) otherEnd, msgs);
		case GraphPackage.EDGE__TGT:
			if (tgt != null)
				msgs = ((InternalEObject) tgt).eInverseRemove(this, GraphPackage.NODE_TYPE__INCOMING, NodeType.class,
						msgs);
			return basicSetTgt((NodeType) otherEnd, msgs);
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
		case GraphPackage.EDGE__LABELS:
			return ((InternalEList<?>) getLabels()).basicRemove(otherEnd, msgs);
		case GraphPackage.EDGE__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
		case GraphPackage.EDGE__SRC:
			return basicSetSrc(null, msgs);
		case GraphPackage.EDGE__TGT:
			return basicSetTgt(null, msgs);
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
		case GraphPackage.EDGE__LABELS:
			return getLabels();
		case GraphPackage.EDGE__PROPERTIES:
			return getProperties();
		case GraphPackage.EDGE__SRC:
			if (resolve)
				return getSrc();
			return basicGetSrc();
		case GraphPackage.EDGE__TGT:
			if (resolve)
				return getTgt();
			return basicGetTgt();
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
		case GraphPackage.EDGE__LABELS:
			getLabels().clear();
			getLabels().addAll((Collection<? extends EdgeLabel>) newValue);
			return;
		case GraphPackage.EDGE__PROPERTIES:
			getProperties().clear();
			getProperties().addAll((Collection<? extends Property>) newValue);
			return;
		case GraphPackage.EDGE__SRC:
			setSrc((NodeType) newValue);
			return;
		case GraphPackage.EDGE__TGT:
			setTgt((NodeType) newValue);
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
		case GraphPackage.EDGE__LABELS:
			getLabels().clear();
			return;
		case GraphPackage.EDGE__PROPERTIES:
			getProperties().clear();
			return;
		case GraphPackage.EDGE__SRC:
			setSrc((NodeType) null);
			return;
		case GraphPackage.EDGE__TGT:
			setTgt((NodeType) null);
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
		case GraphPackage.EDGE__LABELS:
			return labels != null && !labels.isEmpty();
		case GraphPackage.EDGE__PROPERTIES:
			return properties != null && !properties.isEmpty();
		case GraphPackage.EDGE__SRC:
			return src != null;
		case GraphPackage.EDGE__TGT:
			return tgt != null;
		}
		return super.eIsSet(featureID);
	}

} //EdgeImpl

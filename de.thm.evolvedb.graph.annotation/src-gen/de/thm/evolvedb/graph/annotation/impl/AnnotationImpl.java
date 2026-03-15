/**
 */
package de.thm.evolvedb.graph.annotation.impl;

import de.thm.evolvedb.graph.annotation.Annotation;
import de.thm.evolvedb.graph.annotation.AnnotationPackage;
import de.thm.evolvedb.graph.annotation.AnnotationTarget;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.annotation.impl.AnnotationImpl#getAnnotationTarget <em>Annotation Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationImpl extends MinimalEObjectImpl.Container implements Annotation {
	/**
	 * The cached value of the '{@link #getAnnotationTarget() <em>Annotation Target</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationTarget> annotationTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotationPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnnotationTarget> getAnnotationTarget() {
		if (annotationTarget == null) {
			annotationTarget = new EObjectContainmentEList<AnnotationTarget>(AnnotationTarget.class, this,
					AnnotationPackage.ANNOTATION__ANNOTATION_TARGET);
		}
		return annotationTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AnnotationPackage.ANNOTATION__ANNOTATION_TARGET:
			return ((InternalEList<?>) getAnnotationTarget()).basicRemove(otherEnd, msgs);
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
		case AnnotationPackage.ANNOTATION__ANNOTATION_TARGET:
			return getAnnotationTarget();
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
		case AnnotationPackage.ANNOTATION__ANNOTATION_TARGET:
			getAnnotationTarget().clear();
			getAnnotationTarget().addAll((Collection<? extends AnnotationTarget>) newValue);
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
		case AnnotationPackage.ANNOTATION__ANNOTATION_TARGET:
			getAnnotationTarget().clear();
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
		case AnnotationPackage.ANNOTATION__ANNOTATION_TARGET:
			return annotationTarget != null && !annotationTarget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationImpl

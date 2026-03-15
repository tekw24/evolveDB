/**
 */
package de.thm.evolvedb.graph.annotation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.annotation.AnnotationTarget#getTargetURI <em>Target URI</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.annotation.AnnotationTarget#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationTarget()
 * @model
 * @generated
 */
public interface AnnotationTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target URI</em>' attribute.
	 * @see #setTargetURI(String)
	 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationTarget_TargetURI()
	 * @model
	 * @generated
	 */
	String getTargetURI();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.annotation.AnnotationTarget#getTargetURI <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target URI</em>' attribute.
	 * @see #getTargetURI()
	 * @generated
	 */
	void setTargetURI(String value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.annotation.AnnotationEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationTarget_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationEntry> getAnnotations();

} // AnnotationTarget

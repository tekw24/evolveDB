/**
 */
package de.thm.evolvedb.graph.annotation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.annotation.Annotation#getAnnotationTarget <em>Annotation Target</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotation Target</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.annotation.AnnotationTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Target</em>' containment reference list.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotation_AnnotationTarget()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationTarget> getAnnotationTarget();

} // Annotation

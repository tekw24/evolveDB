/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.Constraint#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Constraint#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getConstraint()
 * @model abstract="true"
 * @generated
 */
public interface Constraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.thm.evolvedb.graph.GraphPackage#getConstraint_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Constraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.Label#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' container reference.
	 * @see #setLabel(Label)
	 * @see de.thm.evolvedb.graph.GraphPackage#getConstraint_Label()
	 * @see de.thm.evolvedb.graph.Label#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	Label getLabel();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Constraint#getLabel <em>Label</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' container reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(Label value);

} // Constraint

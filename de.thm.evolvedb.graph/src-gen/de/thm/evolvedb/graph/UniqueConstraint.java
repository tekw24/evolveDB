/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unique Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.UniqueConstraint#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getUniqueConstraint()
 * @model
 * @generated
 */
public interface UniqueConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getUniqueConstraint_Properties()
	 * @model
	 * @generated
	 */
	EList<Property> getProperties();

} // UniqueConstraint

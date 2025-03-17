/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.PropertyValueType#isNullable <em>Nullable</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyValueType()
 * @model abstract="true"
 * @generated
 */
public interface PropertyValueType extends EObject {
	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #setNullable(boolean)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyValueType_Nullable()
	 * @model default="false"
	 * @generated
	 */
	boolean isNullable();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyValueType#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isNullable()
	 * @generated
	 */
	void setNullable(boolean value);

} // PropertyValueType

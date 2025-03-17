/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.Property#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Property#getValue <em>Value</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Property#getMinCount <em>Min Count</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Property#getMaxCount <em>Max Count</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.thm.evolvedb.graph.GraphPackage#getProperty_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Property#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(PropertyValueType)
	 * @see de.thm.evolvedb.graph.GraphPackage#getProperty_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PropertyValueType getValue();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Property#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(PropertyValueType value);

	/**
	 * Returns the value of the '<em><b>Min Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Count</em>' attribute.
	 * @see #setMinCount(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getProperty_MinCount()
	 * @model
	 * @generated
	 */
	int getMinCount();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Property#getMinCount <em>Min Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Count</em>' attribute.
	 * @see #getMinCount()
	 * @generated
	 */
	void setMinCount(int value);

	/**
	 * Returns the value of the '<em><b>Max Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Count</em>' attribute.
	 * @see #setMaxCount(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getProperty_MaxCount()
	 * @model
	 * @generated
	 */
	int getMaxCount();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Property#getMaxCount <em>Max Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Count</em>' attribute.
	 * @see #getMaxCount()
	 * @generated
	 */
	void setMaxCount(int value);

} // Property

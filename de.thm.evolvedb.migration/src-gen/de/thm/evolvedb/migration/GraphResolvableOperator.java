/**
 */
package de.thm.evolvedb.migration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.GraphResolvableOperator#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphResolvableOperator()
 * @model
 * @generated
 */
public interface GraphResolvableOperator extends SchemaModificationOperator {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.GraphResolvableOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.GraphResolvableOperatorType
	 * @see #setDisplayName(GraphResolvableOperatorType)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphResolvableOperator_DisplayName()
	 * @model
	 * @generated
	 */
	GraphResolvableOperatorType getDisplayName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.GraphResolvableOperator#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.GraphResolvableOperatorType
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(GraphResolvableOperatorType value);

} // GraphResolvableOperator

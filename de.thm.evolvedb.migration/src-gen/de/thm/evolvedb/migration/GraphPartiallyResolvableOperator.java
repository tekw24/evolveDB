/**
 */
package de.thm.evolvedb.migration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Partially Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.GraphPartiallyResolvableOperator#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphPartiallyResolvableOperator()
 * @model
 * @generated
 */
public interface GraphPartiallyResolvableOperator extends SchemaModificationOperator {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.GraphPartiallyResolvableOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.GraphPartiallyResolvableOperatorType
	 * @see #setDisplayName(GraphPartiallyResolvableOperatorType)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphPartiallyResolvableOperator_DisplayName()
	 * @model
	 * @generated
	 */
	GraphPartiallyResolvableOperatorType getDisplayName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.GraphPartiallyResolvableOperator#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.GraphPartiallyResolvableOperatorType
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(GraphPartiallyResolvableOperatorType value);

} // GraphPartiallyResolvableOperator

/**
 */
package de.thm.evolvedb.migration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Not Automatically Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperator#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphNotAutomaticallyResolvableOperator()
 * @model
 * @generated
 */
public interface GraphNotAutomaticallyResolvableOperator extends SchemaModificationOperator {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperatorType
	 * @see #setDisplayName(GraphNotAutomaticallyResolvableOperatorType)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphNotAutomaticallyResolvableOperator_DisplayName()
	 * @model
	 * @generated
	 */
	GraphNotAutomaticallyResolvableOperatorType getDisplayName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperator#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperatorType
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(GraphNotAutomaticallyResolvableOperatorType value);

} // GraphNotAutomaticallyResolvableOperator

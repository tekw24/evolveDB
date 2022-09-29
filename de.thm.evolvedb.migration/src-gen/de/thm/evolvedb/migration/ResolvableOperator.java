/**
 */
package de.thm.evolvedb.migration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.ResolvableOperator#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getResolvableOperator()
 * @model
 * @generated
 */
public interface ResolvableOperator extends SchemaModificationOperator {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.ResolvableOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.ResolvableOperatorType
	 * @see #setDisplayName(ResolvableOperatorType)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getResolvableOperator_DisplayName()
	 * @model
	 * @generated
	 */
	ResolvableOperatorType getDisplayName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.ResolvableOperator#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.ResolvableOperatorType
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(ResolvableOperatorType value);

} // ResolvableOperator

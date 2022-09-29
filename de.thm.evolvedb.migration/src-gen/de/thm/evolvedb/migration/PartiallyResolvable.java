/**
 */
package de.thm.evolvedb.migration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partially Resolvable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.PartiallyResolvable#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.PartiallyResolvable#getResolveOptions <em>Resolve Options</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getPartiallyResolvable()
 * @model
 * @generated
 */
public interface PartiallyResolvable extends SchemaModificationOperator {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.PartiallyResolvableOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.PartiallyResolvableOperatorType
	 * @see #setDisplayName(PartiallyResolvableOperatorType)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getPartiallyResolvable_DisplayName()
	 * @model
	 * @generated
	 */
	PartiallyResolvableOperatorType getDisplayName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.PartiallyResolvable#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.PartiallyResolvableOperatorType
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(PartiallyResolvableOperatorType value);

	/**
	 * Returns the value of the '<em><b>Resolve Options</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.ColumnOptions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolve Options</em>' attribute.
	 * @see de.thm.evolvedb.migration.ColumnOptions
	 * @see #setResolveOptions(ColumnOptions)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getPartiallyResolvable_ResolveOptions()
	 * @model
	 * @generated
	 */
	ColumnOptions getResolveOptions();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.PartiallyResolvable#getResolveOptions <em>Resolve Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolve Options</em>' attribute.
	 * @see de.thm.evolvedb.migration.ColumnOptions
	 * @see #getResolveOptions()
	 * @generated
	 */
	void setResolveOptions(ColumnOptions value);

} // PartiallyResolvable

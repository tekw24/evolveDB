/**
 */
package de.thm.evolvedb.migration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Automatically Resolvable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable#getResolveOptions <em>Resolve Options</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getNotAutomaticallyResolvable()
 * @model
 * @generated
 */
public interface NotAutomaticallyResolvable extends SchemaModificationOperator {
	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType
	 * @see #setDisplayName(NotAutomaticallyResolvableOperatorType)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getNotAutomaticallyResolvable_DisplayName()
	 * @model
	 * @generated
	 */
	NotAutomaticallyResolvableOperatorType getDisplayName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(NotAutomaticallyResolvableOperatorType value);

	/**
	 * Returns the value of the '<em><b>Resolve Options</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.ComplexResolveOptions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolve Options</em>' attribute.
	 * @see de.thm.evolvedb.migration.ComplexResolveOptions
	 * @see #setResolveOptions(ComplexResolveOptions)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getNotAutomaticallyResolvable_ResolveOptions()
	 * @model
	 * @generated
	 */
	ComplexResolveOptions getResolveOptions();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable#getResolveOptions <em>Resolve Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolve Options</em>' attribute.
	 * @see de.thm.evolvedb.migration.ComplexResolveOptions
	 * @see #getResolveOptions()
	 * @generated
	 */
	void setResolveOptions(ComplexResolveOptions value);

} // NotAutomaticallyResolvable

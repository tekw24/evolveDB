/**
 */
package de.thm.evolvedb.mdde;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.Database_Schema#getLocation <em>Location</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Database_Schema#getVersion <em>Version</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Database_Schema#getEntites <em>Entites</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getDatabase_Schema()
 * @model
 * @generated
 */
public interface Database_Schema extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getDatabase_Schema_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Database_Schema#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getDatabase_Schema_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Database_Schema#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Entites</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.mdde.Table}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Table#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entites</em>' containment reference list.
	 * @see de.thm.evolvedb.mdde.MddePackage#getDatabase_Schema_Entites()
	 * @see de.thm.evolvedb.mdde.Table#getSchema
	 * @model opposite="schema" containment="true"
	 * @generated
	 */
	EList<Table> getEntites();

} // Database_Schema

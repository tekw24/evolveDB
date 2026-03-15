/**
 */
package de.thm.evolvedb.graph.annotation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getKey <em>Key</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getValue <em>Value</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationEntry()
 * @model
 * @generated
 */
public interface AnnotationEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationEntry_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationEntry_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see de.thm.evolvedb.graph.annotation.AnnotationPackage#getAnnotationEntry_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // AnnotationEntry

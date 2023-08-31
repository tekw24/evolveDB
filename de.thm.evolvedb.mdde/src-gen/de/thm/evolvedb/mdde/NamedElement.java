/**
 */
package de.thm.evolvedb.mdde;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.NamedElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getNamedElement()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NameNotNull'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot NameNotNull='Tuple {\n\tmessage : String = \'Name should not be empty!\',\n\tstatus : Boolean = self.name-&gt;size() &gt; 0\n}.status'"
 * @generated
 */
public interface NamedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getNamedElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // NamedElement

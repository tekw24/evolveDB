/**
 */
package de.thm.evolvedb.mdde;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Referential Action</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.mdde.MddePackage#getReferential_Action()
 * @model
 * @generated
 */
public enum Referential_Action implements Enumerator {
	/**
	 * The '<em><b>RESTRICT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESTRICT_VALUE
	 * @generated
	 * @ordered
	 */
	RESTRICT(1, "RESTRICT", "RESTRICT"),

	/**
	 * The '<em><b>CASCADE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CASCADE_VALUE
	 * @generated
	 * @ordered
	 */
	CASCADE(0, "CASCADE", "CASCADE"),

	/**
	 * The '<em><b>SET NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	SET_NULL(2, "SET_NULL", "SET NULL"),

	/**
	 * The '<em><b>NO ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	NO_ACTION(3, "NO_ACTION", "NO ACTION");

	/**
	 * The '<em><b>RESTRICT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESTRICT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESTRICT_VALUE = 1;

	/**
	 * The '<em><b>CASCADE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CASCADE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CASCADE_VALUE = 0;

	/**
	 * The '<em><b>SET NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_NULL
	 * @model literal="SET NULL"
	 * @generated
	 * @ordered
	 */
	public static final int SET_NULL_VALUE = 2;

	/**
	 * The '<em><b>NO ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_ACTION
	 * @model literal="NO ACTION"
	 * @generated
	 * @ordered
	 */
	public static final int NO_ACTION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Referential Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Referential_Action[] VALUES_ARRAY =
		new Referential_Action[] {
			RESTRICT,
			CASCADE,
			SET_NULL,
			NO_ACTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Referential Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Referential_Action> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Referential Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Referential_Action get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Referential_Action result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Referential Action</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Referential_Action getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Referential_Action result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Referential Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Referential_Action get(int value) {
		switch (value) {
			case RESTRICT_VALUE: return RESTRICT;
			case CASCADE_VALUE: return CASCADE;
			case SET_NULL_VALUE: return SET_NULL;
			case NO_ACTION_VALUE: return NO_ACTION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Referential_Action(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Referential_Action

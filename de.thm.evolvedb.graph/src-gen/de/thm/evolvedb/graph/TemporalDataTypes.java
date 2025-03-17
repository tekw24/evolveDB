/**
 */
package de.thm.evolvedb.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Temporal Data Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.graph.GraphPackage#getTemporalDataTypes()
 * @model
 * @generated
 */
public enum TemporalDataTypes implements Enumerator {
	/**
	 * The '<em><b>ZONED DATETIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZONED_DATETIME_VALUE
	 * @generated
	 * @ordered
	 */
	ZONED_DATETIME(0, "ZONED_DATETIME", "ZONED_DATETIME"),

	/**
	 * The '<em><b>LOCAL DATETIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_DATETIME_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_DATETIME(1, "LOCAL_DATETIME", "LOCAL_DATETIME"),

	/**
	 * The '<em><b>DATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
	DATE(2, "DATE", "DATE"),

	/**
	 * The '<em><b>ZONED TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZONED_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	ZONED_TIME(3, "ZONED_TIME", "ZONED_TIME"),

	/**
	 * The '<em><b>LOCAL TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_TIME(4, "LOCAL_TIME", "LOCAL_TIME"),

	/**
	 * The '<em><b>YEAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEAR_VALUE
	 * @generated
	 * @ordered
	 */
	YEAR(5, "YEAR", "YEAR"),

	/**
	 * The '<em><b>MONTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MONTH_VALUE
	 * @generated
	 * @ordered
	 */
	MONTH(6, "MONTH", "MONTH"),

	/**
	 * The '<em><b>DAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DAY_VALUE
	 * @generated
	 * @ordered
	 */
	DAY(7, "DAY", "DAY"),

	/**
	 * The '<em><b>MINUTES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUTES_VALUE
	 * @generated
	 * @ordered
	 */
	MINUTES(8, "MINUTES", "MINUTES"),

	/**
	 * The '<em><b>SUBSECONDS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSECONDS_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSECONDS(9, "SUBSECONDS", "SUBSECONDS");

	/**
	 * The '<em><b>ZONED DATETIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZONED_DATETIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZONED_DATETIME_VALUE = 0;

	/**
	 * The '<em><b>LOCAL DATETIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_DATETIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_DATETIME_VALUE = 1;

	/**
	 * The '<em><b>DATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATE_VALUE = 2;

	/**
	 * The '<em><b>ZONED TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZONED_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZONED_TIME_VALUE = 3;

	/**
	 * The '<em><b>LOCAL TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_TIME_VALUE = 4;

	/**
	 * The '<em><b>YEAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int YEAR_VALUE = 5;

	/**
	 * The '<em><b>MONTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MONTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MONTH_VALUE = 6;

	/**
	 * The '<em><b>DAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DAY_VALUE = 7;

	/**
	 * The '<em><b>MINUTES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUTES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MINUTES_VALUE = 8;

	/**
	 * The '<em><b>SUBSECONDS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSECONDS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSECONDS_VALUE = 9;

	/**
	 * An array of all the '<em><b>Temporal Data Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TemporalDataTypes[] VALUES_ARRAY = new TemporalDataTypes[] { ZONED_DATETIME, LOCAL_DATETIME,
			DATE, ZONED_TIME, LOCAL_TIME, YEAR, MONTH, DAY, MINUTES, SUBSECONDS, };

	/**
	 * A public read-only list of all the '<em><b>Temporal Data Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TemporalDataTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Temporal Data Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TemporalDataTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TemporalDataTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temporal Data Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TemporalDataTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TemporalDataTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temporal Data Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TemporalDataTypes get(int value) {
		switch (value) {
		case ZONED_DATETIME_VALUE:
			return ZONED_DATETIME;
		case LOCAL_DATETIME_VALUE:
			return LOCAL_DATETIME;
		case DATE_VALUE:
			return DATE;
		case ZONED_TIME_VALUE:
			return ZONED_TIME;
		case LOCAL_TIME_VALUE:
			return LOCAL_TIME;
		case YEAR_VALUE:
			return YEAR;
		case MONTH_VALUE:
			return MONTH;
		case DAY_VALUE:
			return DAY;
		case MINUTES_VALUE:
			return MINUTES;
		case SUBSECONDS_VALUE:
			return SUBSECONDS;
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
	private TemporalDataTypes(int value, String name, String literal) {
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

} //TemporalDataTypes

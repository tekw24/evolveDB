/**
 */
package de.thm.evolvedb.migration.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Migration</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class MigrationAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new MigrationAllTests("Migration Tests");
		suite.addTest(MigrationTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationAllTests(String name) {
		super(name);
	}

} //MigrationAllTests

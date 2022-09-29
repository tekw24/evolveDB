/**
 */
package de.thm.evolvedb.migration.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>migration</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MigrationTests extends TestSuite {

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
		TestSuite suite = new MigrationTests("migration Tests");
		suite.addTestSuite(MigrationTest.class);
		suite.addTestSuite(ResolvableOperatorTest.class);
		suite.addTestSuite(PartiallyResolvableTest.class);
		suite.addTestSuite(NotAutomaticallyResolvableTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationTests(String name) {
		super(name);
	}

} //MigrationTests

/**
 */
package de.thm.evolvedb.mdde.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>mdde</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MddeTests extends TestSuite {

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
		TestSuite suite = new MddeTests("mdde Tests");
		suite.addTestSuite(TableTest.class);
		suite.addTestSuite(PrimaryKeyTest.class);
		suite.addTestSuite(ForeignKeyTest.class);
		suite.addTestSuite(ColumnTest.class);
		suite.addTestSuite(UniqueConstraintTest.class);
		suite.addTestSuite(IndexTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MddeTests(String name) {
		super(name);
	}

} //MddeTests

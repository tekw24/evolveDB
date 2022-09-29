/**
 */
package de.thm.evolvedb.mdde.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Mdde</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class MddeAllTests extends TestSuite {

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
		TestSuite suite = new MddeAllTests("Mdde Tests");
		suite.addTest(MddeTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MddeAllTests(String name) {
		super(name);
	}

} //MddeAllTests

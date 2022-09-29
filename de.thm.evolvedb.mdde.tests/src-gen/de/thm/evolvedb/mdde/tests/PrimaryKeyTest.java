/**
 */
package de.thm.evolvedb.mdde.tests;

import de.thm.evolvedb.mdde.MddeFactory;
import de.thm.evolvedb.mdde.PrimaryKey;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimaryKeyTest extends ColumnTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PrimaryKeyTest.class);
	}

	/**
	 * Constructs a new Primary Key test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKeyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Primary Key test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PrimaryKey getFixture() {
		return (PrimaryKey)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MddeFactory.eINSTANCE.createPrimaryKey());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PrimaryKeyTest

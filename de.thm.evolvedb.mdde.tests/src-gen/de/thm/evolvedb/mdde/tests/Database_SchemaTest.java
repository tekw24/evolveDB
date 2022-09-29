/**
 */
package de.thm.evolvedb.mdde.tests;

import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.MddeFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Database Schema</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Database_SchemaTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Database_SchemaTest.class);
	}

	/**
	 * Constructs a new Database Schema test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Database_SchemaTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Database Schema test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Database_Schema getFixture() {
		return (Database_Schema)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MddeFactory.eINSTANCE.createDatabase_Schema());
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

} //Database_SchemaTest

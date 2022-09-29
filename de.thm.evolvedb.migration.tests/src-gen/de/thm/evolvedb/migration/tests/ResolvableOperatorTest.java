/**
 */
package de.thm.evolvedb.migration.tests;

import de.thm.evolvedb.migration.MigrationFactory;
import de.thm.evolvedb.migration.ResolvableOperator;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResolvableOperatorTest extends SchemaModificationOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResolvableOperatorTest.class);
	}

	/**
	 * Constructs a new Resolvable Operator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvableOperatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Resolvable Operator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ResolvableOperator getFixture() {
		return (ResolvableOperator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MigrationFactory.eINSTANCE.createResolvableOperator());
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

} //ResolvableOperatorTest

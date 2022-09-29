/**
 */
package de.thm.evolvedb.migration.tests;

import de.thm.evolvedb.migration.MigrationFactory;
import de.thm.evolvedb.migration.PartiallyResolvable;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Partially Resolvable</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartiallyResolvableTest extends SchemaModificationOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PartiallyResolvableTest.class);
	}

	/**
	 * Constructs a new Partially Resolvable test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartiallyResolvableTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Partially Resolvable test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PartiallyResolvable getFixture() {
		return (PartiallyResolvable)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MigrationFactory.eINSTANCE.createPartiallyResolvable());
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

} //PartiallyResolvableTest

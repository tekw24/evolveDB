/**
 */
package de.thm.evolvedb.migration.tests;

import de.thm.evolvedb.migration.MigrationFactory;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Not Automatically Resolvable</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NotAutomaticallyResolvableTest extends SchemaModificationOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NotAutomaticallyResolvableTest.class);
	}

	/**
	 * Constructs a new Not Automatically Resolvable test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotAutomaticallyResolvableTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Not Automatically Resolvable test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NotAutomaticallyResolvable getFixture() {
		return (NotAutomaticallyResolvable)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MigrationFactory.eINSTANCE.createNotAutomaticallyResolvable());
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

} //NotAutomaticallyResolvableTest

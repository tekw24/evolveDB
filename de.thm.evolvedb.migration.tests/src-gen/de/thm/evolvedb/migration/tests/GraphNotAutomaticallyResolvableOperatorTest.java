/**
 */
package de.thm.evolvedb.migration.tests;

import de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperator;
import de.thm.evolvedb.migration.MigrationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph Not Automatically Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphNotAutomaticallyResolvableOperatorTest extends SchemaModificationOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphNotAutomaticallyResolvableOperatorTest.class);
	}

	/**
	 * Constructs a new Graph Not Automatically Resolvable Operator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphNotAutomaticallyResolvableOperatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph Not Automatically Resolvable Operator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GraphNotAutomaticallyResolvableOperator getFixture() {
		return (GraphNotAutomaticallyResolvableOperator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MigrationFactory.eINSTANCE.createGraphNotAutomaticallyResolvableOperator());
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

} //GraphNotAutomaticallyResolvableOperatorTest

/**
 */
package de.thm.evolvedb.migration.tests;

import de.thm.evolvedb.migration.GraphResolvableOperator;
import de.thm.evolvedb.migration.MigrationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphResolvableOperatorTest extends SchemaModificationOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphResolvableOperatorTest.class);
	}

	/**
	 * Constructs a new Graph Resolvable Operator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphResolvableOperatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph Resolvable Operator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GraphResolvableOperator getFixture() {
		return (GraphResolvableOperator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MigrationFactory.eINSTANCE.createGraphResolvableOperator());
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

} //GraphResolvableOperatorTest

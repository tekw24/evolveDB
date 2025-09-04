/**
 */
package de.thm.evolvedb.migration.tests;

import de.thm.evolvedb.migration.GraphPartiallyResolvableOperator;
import de.thm.evolvedb.migration.MigrationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph Partially Resolvable Operator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphPartiallyResolvableOperatorTest extends SchemaModificationOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphPartiallyResolvableOperatorTest.class);
	}

	/**
	 * Constructs a new Graph Partially Resolvable Operator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPartiallyResolvableOperatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph Partially Resolvable Operator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GraphPartiallyResolvableOperator getFixture() {
		return (GraphPartiallyResolvableOperator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MigrationFactory.eINSTANCE.createGraphPartiallyResolvableOperator());
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

} //GraphPartiallyResolvableOperatorTest

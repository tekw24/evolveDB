/**
 */
package de.thm.evolvedb.mdde.tests;

import de.thm.evolvedb.mdde.MddeFactory;
import de.thm.evolvedb.mdde.NamedElement;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NamedElementTest extends TestCase {

	/**
	 * The fixture for this Named Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NamedElementTest.class);
	}

	/**
	 * Constructs a new Named Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Named Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(NamedElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Named Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElement getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MddeFactory.eINSTANCE.createNamedElement());
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

} //NamedElementTest

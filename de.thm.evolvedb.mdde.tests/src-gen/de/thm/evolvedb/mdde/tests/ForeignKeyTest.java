/**
 */
package de.thm.evolvedb.mdde.tests;

import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddeFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#validateConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Constraint Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#ForeignKeyHasToReferenceAKeyColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Foreign Key Has To Reference AKey Column</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ForeignKeyTest extends ColumnTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ForeignKeyTest.class);
	}

	/**
	 * Constructs a new Foreign Key test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKeyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Foreign Key test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ForeignKey getFixture() {
		return (ForeignKey)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MddeFactory.eINSTANCE.createForeignKey());
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

	/**
	 * Tests the '{@link de.thm.evolvedb.mdde.ForeignKey#validateConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Constraint Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.ForeignKey#validateConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateConstraintName__DiagnosticChain_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.thm.evolvedb.mdde.ForeignKey#ForeignKeyHasToReferenceAKeyColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Foreign Key Has To Reference AKey Column</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.ForeignKey#ForeignKeyHasToReferenceAKeyColumn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testForeignKeyHasToReferenceAKeyColumn__DiagnosticChain_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ForeignKeyTest

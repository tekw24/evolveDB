/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.BinaryDataTypes;
import de.thm.evolvedb.graph.BinaryTypes;
import de.thm.evolvedb.graph.BooleanDataTypes;
import de.thm.evolvedb.graph.BooleanType;
import de.thm.evolvedb.graph.Constraint;
import de.thm.evolvedb.graph.DynamicUnionTypes;
import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.GraphFactory;
import de.thm.evolvedb.graph.GraphItem;
import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.GraphType;
import de.thm.evolvedb.graph.KeyConstraint;
import de.thm.evolvedb.graph.Label;
import de.thm.evolvedb.graph.ListType;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.NumericDataTypes;
import de.thm.evolvedb.graph.NumericType;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyExistenceConstraint;
import de.thm.evolvedb.graph.PropertyGraph;
import de.thm.evolvedb.graph.PropertyTypeConstraint;
import de.thm.evolvedb.graph.PropertyValueType;
import de.thm.evolvedb.graph.StringDataTypes;
import de.thm.evolvedb.graph.StringType;
import de.thm.evolvedb.graph.TemporalDataTypes;
import de.thm.evolvedb.graph.TemporalTypes;
import de.thm.evolvedb.graph.UnionType;

import de.thm.evolvedb.graph.UniqueConstraint;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphPackageImpl extends EPackageImpl implements GraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyValueTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temporalTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTypeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyExistenceConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum graphTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dynamicUnionTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum booleanDataTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum temporalDataTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numericDataTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stringDataTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryDataTypesEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.thm.evolvedb.graph.GraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphPackageImpl() {
		super(eNS_URI, GraphFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link GraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphPackage init() {
		if (isInited)
			return (GraphPackage) EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphPackageImpl theGraphPackage = registeredGraphPackage instanceof GraphPackageImpl
				? (GraphPackageImpl) registeredGraphPackage
				: new GraphPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theGraphPackage.createPackageContents();

		// Initialize created meta-data
		theGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphPackage.eNS_URI, theGraphPackage);
		return theGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyGraph() {
		return propertyGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyGraph_Closed() {
		return (EAttribute) propertyGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyGraph_Graphtype() {
		return (EAttribute) propertyGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyGraph_Items() {
		return (EReference) propertyGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyGraph_Name() {
		return (EAttribute) propertyGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyGraph_Location() {
		return (EAttribute) propertyGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphItem() {
		return graphItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphItem_Graph() {
		return (EReference) graphItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeType() {
		return nodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_Label() {
		return (EReference) nodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_Outgoing() {
		return (EReference) nodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_Incoming() {
		return (EReference) nodeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeType() {
		return edgeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeType_Labels() {
		return (EReference) edgeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeType_Properties() {
		return (EReference) edgeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeType_Src() {
		return (EReference) edgeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeType_Tgt() {
		return (EReference) edgeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabel() {
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabel_Name() {
		return (EAttribute) labelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabel_Properties() {
		return (EReference) labelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabel_SuperType() {
		return (EReference) labelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLabel_Constraints() {
		return (EReference) labelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeLabel() {
		return edgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLabel_Edges() {
		return (EReference) edgeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeLabel() {
		return nodeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeLabel_Nodes() {
		return (EReference) nodeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_Value() {
		return (EReference) propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Mandatory() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyValueType() {
		return propertyValueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyValueType_Nullable() {
		return (EAttribute) propertyValueTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnionType() {
		return unionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnionType_Type() {
		return (EAttribute) unionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericType() {
		return numericTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericType_Type() {
		return (EAttribute) numericTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericType_IntegralPart() {
		return (EAttribute) numericTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericType_FractionalPart() {
		return (EAttribute) numericTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringType_MinLength() {
		return (EAttribute) stringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringType_MaxLength() {
		return (EAttribute) stringTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringType_Type() {
		return (EAttribute) stringTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanType_Type() {
		return (EAttribute) booleanTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryTypes() {
		return binaryTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryTypes_Type() {
		return (EAttribute) binaryTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryTypes_MinLength() {
		return (EAttribute) binaryTypesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryTypes_MaxLength() {
		return (EAttribute) binaryTypesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListType() {
		return listTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListType_LowerBound() {
		return (EAttribute) listTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListType_UpperBound() {
		return (EAttribute) listTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListType_Type() {
		return (EReference) listTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemporalTypes() {
		return temporalTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemporalTypes_Type() {
		return (EAttribute) temporalTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Name() {
		return (EAttribute) constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Label() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueConstraint() {
		return uniqueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUniqueConstraint_Properties() {
		return (EReference) uniqueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyTypeConstraint() {
		return propertyTypeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTypeConstraint_Properties() {
		return (EReference) propertyTypeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTypeConstraint_Type() {
		return (EReference) propertyTypeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyExistenceConstraint() {
		return propertyExistenceConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyExistenceConstraint_Properties() {
		return (EReference) propertyExistenceConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyConstraint() {
		return keyConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyConstraint_Properties() {
		return (EReference) keyConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGraphType() {
		return graphTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDynamicUnionTypes() {
		return dynamicUnionTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBooleanDataTypes() {
		return booleanDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTemporalDataTypes() {
		return temporalDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumericDataTypes() {
		return numericDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStringDataTypes() {
		return stringDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryDataTypes() {
		return binaryDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphFactory getGraphFactory() {
		return (GraphFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		propertyGraphEClass = createEClass(PROPERTY_GRAPH);
		createEAttribute(propertyGraphEClass, PROPERTY_GRAPH__CLOSED);
		createEAttribute(propertyGraphEClass, PROPERTY_GRAPH__GRAPHTYPE);
		createEReference(propertyGraphEClass, PROPERTY_GRAPH__ITEMS);
		createEAttribute(propertyGraphEClass, PROPERTY_GRAPH__NAME);
		createEAttribute(propertyGraphEClass, PROPERTY_GRAPH__LOCATION);

		graphItemEClass = createEClass(GRAPH_ITEM);
		createEReference(graphItemEClass, GRAPH_ITEM__GRAPH);

		nodeTypeEClass = createEClass(NODE_TYPE);
		createEReference(nodeTypeEClass, NODE_TYPE__LABEL);
		createEReference(nodeTypeEClass, NODE_TYPE__OUTGOING);
		createEReference(nodeTypeEClass, NODE_TYPE__INCOMING);

		edgeTypeEClass = createEClass(EDGE_TYPE);
		createEReference(edgeTypeEClass, EDGE_TYPE__LABELS);
		createEReference(edgeTypeEClass, EDGE_TYPE__PROPERTIES);
		createEReference(edgeTypeEClass, EDGE_TYPE__SRC);
		createEReference(edgeTypeEClass, EDGE_TYPE__TGT);

		labelEClass = createEClass(LABEL);
		createEAttribute(labelEClass, LABEL__NAME);
		createEReference(labelEClass, LABEL__PROPERTIES);
		createEReference(labelEClass, LABEL__SUPER_TYPE);
		createEReference(labelEClass, LABEL__CONSTRAINTS);

		edgeLabelEClass = createEClass(EDGE_LABEL);
		createEReference(edgeLabelEClass, EDGE_LABEL__EDGES);

		nodeLabelEClass = createEClass(NODE_LABEL);
		createEReference(nodeLabelEClass, NODE_LABEL__NODES);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEReference(propertyEClass, PROPERTY__VALUE);
		createEAttribute(propertyEClass, PROPERTY__MANDATORY);

		propertyValueTypeEClass = createEClass(PROPERTY_VALUE_TYPE);
		createEAttribute(propertyValueTypeEClass, PROPERTY_VALUE_TYPE__NULLABLE);

		unionTypeEClass = createEClass(UNION_TYPE);
		createEAttribute(unionTypeEClass, UNION_TYPE__TYPE);

		numericTypeEClass = createEClass(NUMERIC_TYPE);
		createEAttribute(numericTypeEClass, NUMERIC_TYPE__TYPE);
		createEAttribute(numericTypeEClass, NUMERIC_TYPE__INTEGRAL_PART);
		createEAttribute(numericTypeEClass, NUMERIC_TYPE__FRACTIONAL_PART);

		stringTypeEClass = createEClass(STRING_TYPE);
		createEAttribute(stringTypeEClass, STRING_TYPE__MIN_LENGTH);
		createEAttribute(stringTypeEClass, STRING_TYPE__MAX_LENGTH);
		createEAttribute(stringTypeEClass, STRING_TYPE__TYPE);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);
		createEAttribute(booleanTypeEClass, BOOLEAN_TYPE__TYPE);

		binaryTypesEClass = createEClass(BINARY_TYPES);
		createEAttribute(binaryTypesEClass, BINARY_TYPES__TYPE);
		createEAttribute(binaryTypesEClass, BINARY_TYPES__MIN_LENGTH);
		createEAttribute(binaryTypesEClass, BINARY_TYPES__MAX_LENGTH);

		listTypeEClass = createEClass(LIST_TYPE);
		createEAttribute(listTypeEClass, LIST_TYPE__LOWER_BOUND);
		createEAttribute(listTypeEClass, LIST_TYPE__UPPER_BOUND);
		createEReference(listTypeEClass, LIST_TYPE__TYPE);

		temporalTypesEClass = createEClass(TEMPORAL_TYPES);
		createEAttribute(temporalTypesEClass, TEMPORAL_TYPES__TYPE);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__NAME);
		createEReference(constraintEClass, CONSTRAINT__LABEL);

		uniqueConstraintEClass = createEClass(UNIQUE_CONSTRAINT);
		createEReference(uniqueConstraintEClass, UNIQUE_CONSTRAINT__PROPERTIES);

		propertyTypeConstraintEClass = createEClass(PROPERTY_TYPE_CONSTRAINT);
		createEReference(propertyTypeConstraintEClass, PROPERTY_TYPE_CONSTRAINT__PROPERTIES);
		createEReference(propertyTypeConstraintEClass, PROPERTY_TYPE_CONSTRAINT__TYPE);

		propertyExistenceConstraintEClass = createEClass(PROPERTY_EXISTENCE_CONSTRAINT);
		createEReference(propertyExistenceConstraintEClass, PROPERTY_EXISTENCE_CONSTRAINT__PROPERTIES);

		keyConstraintEClass = createEClass(KEY_CONSTRAINT);
		createEReference(keyConstraintEClass, KEY_CONSTRAINT__PROPERTIES);

		// Create enums
		graphTypeEEnum = createEEnum(GRAPH_TYPE);
		dynamicUnionTypesEEnum = createEEnum(DYNAMIC_UNION_TYPES);
		booleanDataTypesEEnum = createEEnum(BOOLEAN_DATA_TYPES);
		temporalDataTypesEEnum = createEEnum(TEMPORAL_DATA_TYPES);
		numericDataTypesEEnum = createEEnum(NUMERIC_DATA_TYPES);
		stringDataTypesEEnum = createEEnum(STRING_DATA_TYPES);
		binaryDataTypesEEnum = createEEnum(BINARY_DATA_TYPES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nodeTypeEClass.getESuperTypes().add(this.getGraphItem());
		edgeTypeEClass.getESuperTypes().add(this.getGraphItem());
		labelEClass.getESuperTypes().add(this.getGraphItem());
		edgeLabelEClass.getESuperTypes().add(this.getLabel());
		nodeLabelEClass.getESuperTypes().add(this.getLabel());
		unionTypeEClass.getESuperTypes().add(this.getPropertyValueType());
		numericTypeEClass.getESuperTypes().add(this.getPropertyValueType());
		stringTypeEClass.getESuperTypes().add(this.getPropertyValueType());
		booleanTypeEClass.getESuperTypes().add(this.getPropertyValueType());
		binaryTypesEClass.getESuperTypes().add(this.getPropertyValueType());
		listTypeEClass.getESuperTypes().add(this.getPropertyValueType());
		temporalTypesEClass.getESuperTypes().add(this.getPropertyValueType());
		uniqueConstraintEClass.getESuperTypes().add(this.getConstraint());
		propertyTypeConstraintEClass.getESuperTypes().add(this.getConstraint());
		propertyExistenceConstraintEClass.getESuperTypes().add(this.getConstraint());
		keyConstraintEClass.getESuperTypes().add(this.getConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(propertyGraphEClass, PropertyGraph.class, "PropertyGraph", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyGraph_Closed(), ecorePackage.getEBoolean(), "closed", "true", 0, 1,
				PropertyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyGraph_Graphtype(), this.getGraphType(), "graphtype", null, 0, 1, PropertyGraph.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyGraph_Items(), this.getGraphItem(), this.getGraphItem_Graph(), "items", null, 0, -1,
				PropertyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyGraph_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropertyGraph.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyGraph_Location(), ecorePackage.getEString(), "location", null, 0, 1,
				PropertyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(graphItemEClass, GraphItem.class, "GraphItem", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphItem_Graph(), this.getPropertyGraph(), this.getPropertyGraph_Items(), "graph", null, 0,
				1, GraphItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeTypeEClass, NodeType.class, "NodeType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeType_Label(), this.getNodeLabel(), this.getNodeLabel_Nodes(), "label", null, 0, -1,
				NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_Outgoing(), this.getEdgeType(), this.getEdgeType_Src(), "outgoing", null, 0, -1,
				NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_Incoming(), this.getEdgeType(), this.getEdgeType_Tgt(), "incoming", null, 0, -1,
				NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeTypeEClass, EdgeType.class, "EdgeType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeType_Labels(), this.getEdgeLabel(), this.getEdgeLabel_Edges(), "labels", null, 0, -1,
				EdgeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgeType_Properties(), this.getProperty(), null, "properties", null, 0, -1, EdgeType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgeType_Src(), this.getNodeType(), this.getNodeType_Outgoing(), "src", null, 0, 1,
				EdgeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgeType_Tgt(), this.getNodeType(), this.getNodeType_Incoming(), "tgt", null, 0, 1,
				EdgeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelEClass, Label.class, "Label", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabel_Name(), ecorePackage.getEString(), "name", null, 1, 1, Label.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabel_Properties(), this.getProperty(), null, "properties", null, 0, -1, Label.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabel_SuperType(), this.getLabel(), null, "SuperType", null, 0, -1, Label.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabel_Constraints(), this.getConstraint(), this.getConstraint_Label(), "constraints", null, 0,
				-1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeLabelEClass, EdgeLabel.class, "EdgeLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeLabel_Edges(), this.getEdgeType(), this.getEdgeType_Labels(), "edges", null, 0, -1,
				EdgeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeLabelEClass, NodeLabel.class, "NodeLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeLabel_Nodes(), this.getNodeType(), this.getNodeType_Label(), "nodes", null, 0, -1,
				NodeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProperty_Value(), this.getPropertyValueType(), null, "value", null, 1, 1, Property.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "false", 0, 1, Property.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyValueTypeEClass, PropertyValueType.class, "PropertyValueType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyValueType_Nullable(), ecorePackage.getEBoolean(), "nullable", "false", 0, 1,
				PropertyValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(unionTypeEClass, UnionType.class, "UnionType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnionType_Type(), this.getDynamicUnionTypes(), "type", null, 1, 1, UnionType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericTypeEClass, NumericType.class, "NumericType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericType_Type(), this.getNumericDataTypes(), "type", null, 1, 1, NumericType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericType_IntegralPart(), ecorePackage.getEInt(), "integralPart", null, 0, 1,
				NumericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericType_FractionalPart(), ecorePackage.getEInt(), "fractionalPart", null, 0, 1,
				NumericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringType_MinLength(), ecorePackage.getEInt(), "minLength", null, 0, 1, StringType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringType_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1, StringType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringType_Type(), this.getStringDataTypes(), "type", null, 1, 1, StringType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanType_Type(), this.getBooleanDataTypes(), "type", null, 1, 1, BooleanType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryTypesEClass, BinaryTypes.class, "BinaryTypes", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryTypes_Type(), this.getBinaryDataTypes(), "type", null, 1, 1, BinaryTypes.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryTypes_MinLength(), ecorePackage.getEInt(), "minLength", null, 0, 1, BinaryTypes.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryTypes_MaxLength(), ecorePackage.getEInt(), "maxLength", null, 0, 1, BinaryTypes.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getListType_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, ListType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getListType_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, ListType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getListType_Type(), this.getPropertyValueType(), null, "type", null, 1, 1, ListType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temporalTypesEClass, TemporalTypes.class, "TemporalTypes", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemporalTypes_Type(), this.getTemporalDataTypes(), "type", null, 1, 1, TemporalTypes.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Name(), ecorePackage.getEString(), "name", null, 1, 1, Constraint.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Label(), this.getLabel(), this.getLabel_Constraints(), "Label", null, 0, 1,
				Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uniqueConstraintEClass, UniqueConstraint.class, "UniqueConstraint", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUniqueConstraint_Properties(), this.getProperty(), null, "properties", null, 0, -1,
				UniqueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyTypeConstraintEClass, PropertyTypeConstraint.class, "PropertyTypeConstraint", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTypeConstraint_Properties(), this.getProperty(), null, "properties", null, 0, 1,
				PropertyTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTypeConstraint_Type(), this.getPropertyValueType(), null, "type", null, 0, 1,
				PropertyTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyExistenceConstraintEClass, PropertyExistenceConstraint.class, "PropertyExistenceConstraint",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyExistenceConstraint_Properties(), this.getProperty(), null, "properties", null, 0, 1,
				PropertyExistenceConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyConstraintEClass, KeyConstraint.class, "KeyConstraint", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyConstraint_Properties(), this.getProperty(), null, "properties", null, 0, -1,
				KeyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(graphTypeEEnum, GraphType.class, "GraphType");
		addEEnumLiteral(graphTypeEEnum, GraphType.MULTIGRAPH);
		addEEnumLiteral(graphTypeEEnum, GraphType.DIRECTED_GRAPH);
		addEEnumLiteral(graphTypeEEnum, GraphType.UNDIRECTED_GRAPH);
		addEEnumLiteral(graphTypeEEnum, GraphType.MIXED_GRAPH);
		addEEnumLiteral(graphTypeEEnum, GraphType.EMPTY_GRAPH);

		initEEnum(dynamicUnionTypesEEnum, DynamicUnionTypes.class, "DynamicUnionTypes");
		addEEnumLiteral(dynamicUnionTypesEEnum, DynamicUnionTypes.ANY_TYPE);

		initEEnum(booleanDataTypesEEnum, BooleanDataTypes.class, "BooleanDataTypes");
		addEEnumLiteral(booleanDataTypesEEnum, BooleanDataTypes.BOOLEAN);

		initEEnum(temporalDataTypesEEnum, TemporalDataTypes.class, "TemporalDataTypes");
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.ZONED_DATETIME);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.LOCAL_DATETIME);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.DATE);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.ZONED_TIME);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.LOCAL_TIME);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.YEAR);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.MONTH);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.DAY);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.MINUTES);
		addEEnumLiteral(temporalDataTypesEEnum, TemporalDataTypes.SUBSECONDS);

		initEEnum(numericDataTypesEEnum, NumericDataTypes.class, "NumericDataTypes");
		addEEnumLiteral(numericDataTypesEEnum, NumericDataTypes.DECIMAL);
		addEEnumLiteral(numericDataTypesEEnum, NumericDataTypes.INT);
		addEEnumLiteral(numericDataTypesEEnum, NumericDataTypes.UINT);
		addEEnumLiteral(numericDataTypesEEnum, NumericDataTypes.FLOAT);
		addEEnumLiteral(numericDataTypesEEnum, NumericDataTypes.FLOAT128);
		addEEnumLiteral(numericDataTypesEEnum, NumericDataTypes.DOUBLE);

		initEEnum(stringDataTypesEEnum, StringDataTypes.class, "StringDataTypes");
		addEEnumLiteral(stringDataTypesEEnum, StringDataTypes.VARCHAR);
		addEEnumLiteral(stringDataTypesEEnum, StringDataTypes.STRING);

		initEEnum(binaryDataTypesEEnum, BinaryDataTypes.class, "BinaryDataTypes");
		addEEnumLiteral(binaryDataTypesEEnum, BinaryDataTypes.VARBINARY);
		addEEnumLiteral(binaryDataTypesEEnum, BinaryDataTypes.BYTES);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphPackageImpl

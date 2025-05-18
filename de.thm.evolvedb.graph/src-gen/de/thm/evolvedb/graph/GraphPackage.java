/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.graph.GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.thm.de/graph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphPackage eINSTANCE = de.thm.evolvedb.graph.impl.GraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl <em>Property Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.PropertyGraphImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyGraph()
	 * @generated
	 */
	int PROPERTY_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Closed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH__CLOSED = 0;

	/**
	 * The feature id for the '<em><b>Graphtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH__GRAPHTYPE = 1;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH__ITEMS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH__NAME = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH__LOCATION = 4;

	/**
	 * The number of structural features of the '<em>Property Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Property Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.GraphItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.GraphItemImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getGraphItem()
	 * @generated
	 */
	int GRAPH_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ITEM__GRAPH = 0;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ITEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.NodeTypeImpl <em>Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.NodeTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__GRAPH = GRAPH_ITEM__GRAPH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__NAME = GRAPH_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__LABEL = GRAPH_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__OUTGOING = GRAPH_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__INCOMING = GRAPH_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__PROPERTIES = GRAPH_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_FEATURE_COUNT = GRAPH_ITEM_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_OPERATION_COUNT = GRAPH_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.EdgeTypeImpl <em>Edge Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.EdgeTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getEdgeType()
	 * @generated
	 */
	int EDGE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__GRAPH = GRAPH_ITEM__GRAPH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__NAME = GRAPH_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__LABELS = GRAPH_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__PROPERTIES = GRAPH_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__SRC = GRAPH_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__TGT = GRAPH_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Edge Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE_FEATURE_COUNT = GRAPH_ITEM_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Edge Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE_OPERATION_COUNT = GRAPH_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.LabelImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 4;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__GRAPH = GRAPH_ITEM__GRAPH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__NAME = GRAPH_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__PROPERTIES = GRAPH_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__SUPER_TYPE = GRAPH_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CONSTRAINTS = GRAPH_ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = GRAPH_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_OPERATION_COUNT = GRAPH_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.EdgeLabelImpl <em>Edge Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.EdgeLabelImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getEdgeLabel()
	 * @generated
	 */
	int EDGE_LABEL = 5;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__GRAPH = LABEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__NAME = LABEL__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__PROPERTIES = LABEL__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__SUPER_TYPE = LABEL__SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__CONSTRAINTS = LABEL__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL__EDGES = LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL_FEATURE_COUNT = LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Edge Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LABEL_OPERATION_COUNT = LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.NodeLabelImpl <em>Node Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.NodeLabelImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNodeLabel()
	 * @generated
	 */
	int NODE_LABEL = 6;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__GRAPH = LABEL__GRAPH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__NAME = LABEL__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__PROPERTIES = LABEL__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__SUPER_TYPE = LABEL__SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__CONSTRAINTS = LABEL__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL__NODES = LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL_FEATURE_COUNT = LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Node Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LABEL_OPERATION_COUNT = LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.PropertyImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__MANDATORY = 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.PropertyValueTypeImpl <em>Property Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.PropertyValueTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyValueType()
	 * @generated
	 */
	int PROPERTY_VALUE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_TYPE__NULLABLE = 0;

	/**
	 * The number of structural features of the '<em>Property Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Property Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VALUE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.UnionTypeImpl <em>Union Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.UnionTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getUnionType()
	 * @generated
	 */
	int UNION_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Union Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Union Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_TYPE_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.NumericTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNumericType()
	 * @generated
	 */
	int NUMERIC_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Integral Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__INTEGRAL_PART = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fractional Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__FRACTIONAL_PART = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Numeric Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Numeric Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.StringTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__MIN_LENGTH = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__MAX_LENGTH = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.BooleanTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.BinaryTypesImpl <em>Binary Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.BinaryTypesImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBinaryTypes()
	 * @generated
	 */
	int BINARY_TYPES = 13;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TYPES__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TYPES__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TYPES__MIN_LENGTH = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TYPES__MAX_LENGTH = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TYPES_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Binary Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TYPES_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.ListTypeImpl <em>List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.ListTypeImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getListType()
	 * @generated
	 */
	int LIST_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__LOWER_BOUND = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__UPPER_BOUND = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.TemporalTypesImpl <em>Temporal Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.TemporalTypesImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getTemporalTypes()
	 * @generated
	 */
	int TEMPORAL_TYPES = 15;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_TYPES__NULLABLE = PROPERTY_VALUE_TYPE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_TYPES__TYPE = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Temporal Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_TYPES_FEATURE_COUNT = PROPERTY_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Temporal Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_TYPES_OPERATION_COUNT = PROPERTY_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.ConstraintImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__LABEL = 1;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.UniqueConstraintImpl <em>Unique Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.UniqueConstraintImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getUniqueConstraint()
	 * @generated
	 */
	int UNIQUE_CONSTRAINT = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__LABEL = CONSTRAINT__LABEL;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__PROPERTIES = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unique Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unique Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.PropertyTypeConstraintImpl <em>Property Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.PropertyTypeConstraintImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyTypeConstraint()
	 * @generated
	 */
	int PROPERTY_TYPE_CONSTRAINT = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_CONSTRAINT__LABEL = CONSTRAINT__LABEL;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_CONSTRAINT__PROPERTIES = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_CONSTRAINT__TYPE = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Property Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.PropertyExistenceConstraintImpl <em>Property Existence Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.PropertyExistenceConstraintImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyExistenceConstraint()
	 * @generated
	 */
	int PROPERTY_EXISTENCE_CONSTRAINT = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EXISTENCE_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EXISTENCE_CONSTRAINT__LABEL = CONSTRAINT__LABEL;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EXISTENCE_CONSTRAINT__PROPERTIES = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Existence Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EXISTENCE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Existence Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EXISTENCE_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.impl.KeyConstraintImpl <em>Key Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.impl.KeyConstraintImpl
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getKeyConstraint()
	 * @generated
	 */
	int KEY_CONSTRAINT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_CONSTRAINT__LABEL = CONSTRAINT__LABEL;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_CONSTRAINT__PROPERTIES = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Key Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Key Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.GraphType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.GraphType
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getGraphType()
	 * @generated
	 */
	int GRAPH_TYPE = 21;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.DynamicUnionTypes <em>Dynamic Union Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.DynamicUnionTypes
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getDynamicUnionTypes()
	 * @generated
	 */
	int DYNAMIC_UNION_TYPES = 22;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.BooleanDataTypes <em>Boolean Data Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.BooleanDataTypes
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBooleanDataTypes()
	 * @generated
	 */
	int BOOLEAN_DATA_TYPES = 23;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.TemporalDataTypes <em>Temporal Data Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.TemporalDataTypes
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getTemporalDataTypes()
	 * @generated
	 */
	int TEMPORAL_DATA_TYPES = 24;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.NumericDataTypes <em>Numeric Data Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.NumericDataTypes
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNumericDataTypes()
	 * @generated
	 */
	int NUMERIC_DATA_TYPES = 25;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.StringDataTypes <em>String Data Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.StringDataTypes
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getStringDataTypes()
	 * @generated
	 */
	int STRING_DATA_TYPES = 26;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.BinaryDataTypes <em>Binary Data Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.BinaryDataTypes
	 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBinaryDataTypes()
	 * @generated
	 */
	int BINARY_DATA_TYPES = 27;

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.PropertyGraph <em>Property Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Graph</em>'.
	 * @see de.thm.evolvedb.graph.PropertyGraph
	 * @generated
	 */
	EClass getPropertyGraph();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.PropertyGraph#isClosed <em>Closed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Closed</em>'.
	 * @see de.thm.evolvedb.graph.PropertyGraph#isClosed()
	 * @see #getPropertyGraph()
	 * @generated
	 */
	EAttribute getPropertyGraph_Closed();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.PropertyGraph#getGraphtype <em>Graphtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graphtype</em>'.
	 * @see de.thm.evolvedb.graph.PropertyGraph#getGraphtype()
	 * @see #getPropertyGraph()
	 * @generated
	 */
	EAttribute getPropertyGraph_Graphtype();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.PropertyGraph#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see de.thm.evolvedb.graph.PropertyGraph#getItems()
	 * @see #getPropertyGraph()
	 * @generated
	 */
	EReference getPropertyGraph_Items();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.PropertyGraph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.graph.PropertyGraph#getName()
	 * @see #getPropertyGraph()
	 * @generated
	 */
	EAttribute getPropertyGraph_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.PropertyGraph#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see de.thm.evolvedb.graph.PropertyGraph#getLocation()
	 * @see #getPropertyGraph()
	 * @generated
	 */
	EAttribute getPropertyGraph_Location();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.GraphItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see de.thm.evolvedb.graph.GraphItem
	 * @generated
	 */
	EClass getGraphItem();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.graph.GraphItem#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see de.thm.evolvedb.graph.GraphItem#getGraph()
	 * @see #getGraphItem()
	 * @generated
	 */
	EReference getGraphItem_Graph();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Type</em>'.
	 * @see de.thm.evolvedb.graph.NodeType
	 * @generated
	 */
	EClass getNodeType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.NodeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.graph.NodeType#getName()
	 * @see #getNodeType()
	 * @generated
	 */
	EAttribute getNodeType_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.NodeType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Label</em>'.
	 * @see de.thm.evolvedb.graph.NodeType#getLabel()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Label();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.NodeType#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see de.thm.evolvedb.graph.NodeType#getOutgoing()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.NodeType#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see de.thm.evolvedb.graph.NodeType#getIncoming()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Incoming();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.NodeType#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.NodeType#getProperties()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Properties();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.EdgeType <em>Edge Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Type</em>'.
	 * @see de.thm.evolvedb.graph.EdgeType
	 * @generated
	 */
	EClass getEdgeType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.EdgeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.graph.EdgeType#getName()
	 * @see #getEdgeType()
	 * @generated
	 */
	EAttribute getEdgeType_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.EdgeType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Labels</em>'.
	 * @see de.thm.evolvedb.graph.EdgeType#getLabels()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_Labels();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.EdgeType#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.EdgeType#getProperties()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_Properties();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.graph.EdgeType#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see de.thm.evolvedb.graph.EdgeType#getSrc()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_Src();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.graph.EdgeType#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see de.thm.evolvedb.graph.EdgeType#getTgt()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_Tgt();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see de.thm.evolvedb.graph.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.Label#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.graph.Label#getName()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.Label#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.Label#getProperties()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_Properties();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.Label#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Type</em>'.
	 * @see de.thm.evolvedb.graph.Label#getSuperType()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_SuperType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.Label#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.thm.evolvedb.graph.Label#getConstraints()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_Constraints();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.EdgeLabel <em>Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Label</em>'.
	 * @see de.thm.evolvedb.graph.EdgeLabel
	 * @generated
	 */
	EClass getEdgeLabel();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.EdgeLabel#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see de.thm.evolvedb.graph.EdgeLabel#getEdges()
	 * @see #getEdgeLabel()
	 * @generated
	 */
	EReference getEdgeLabel_Edges();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.NodeLabel <em>Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Label</em>'.
	 * @see de.thm.evolvedb.graph.NodeLabel
	 * @generated
	 */
	EClass getNodeLabel();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.NodeLabel#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see de.thm.evolvedb.graph.NodeLabel#getNodes()
	 * @see #getNodeLabel()
	 * @generated
	 */
	EReference getNodeLabel_Nodes();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see de.thm.evolvedb.graph.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.graph.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.thm.evolvedb.graph.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.thm.evolvedb.graph.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.Property#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see de.thm.evolvedb.graph.Property#isMandatory()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Mandatory();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.PropertyValueType <em>Property Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value Type</em>'.
	 * @see de.thm.evolvedb.graph.PropertyValueType
	 * @generated
	 */
	EClass getPropertyValueType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.PropertyValueType#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see de.thm.evolvedb.graph.PropertyValueType#isNullable()
	 * @see #getPropertyValueType()
	 * @generated
	 */
	EAttribute getPropertyValueType_Nullable();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.UnionType <em>Union Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union Type</em>'.
	 * @see de.thm.evolvedb.graph.UnionType
	 * @generated
	 */
	EClass getUnionType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.UnionType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.UnionType#getType()
	 * @see #getUnionType()
	 * @generated
	 */
	EAttribute getUnionType_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Type</em>'.
	 * @see de.thm.evolvedb.graph.NumericType
	 * @generated
	 */
	EClass getNumericType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.NumericType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.NumericType#getType()
	 * @see #getNumericType()
	 * @generated
	 */
	EAttribute getNumericType_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.NumericType#getIntegralPart <em>Integral Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integral Part</em>'.
	 * @see de.thm.evolvedb.graph.NumericType#getIntegralPart()
	 * @see #getNumericType()
	 * @generated
	 */
	EAttribute getNumericType_IntegralPart();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.NumericType#getFractionalPart <em>Fractional Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fractional Part</em>'.
	 * @see de.thm.evolvedb.graph.NumericType#getFractionalPart()
	 * @see #getNumericType()
	 * @generated
	 */
	EAttribute getNumericType_FractionalPart();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see de.thm.evolvedb.graph.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.StringType#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see de.thm.evolvedb.graph.StringType#getMinLength()
	 * @see #getStringType()
	 * @generated
	 */
	EAttribute getStringType_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.StringType#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see de.thm.evolvedb.graph.StringType#getMaxLength()
	 * @see #getStringType()
	 * @generated
	 */
	EAttribute getStringType_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.StringType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.StringType#getType()
	 * @see #getStringType()
	 * @generated
	 */
	EAttribute getStringType_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see de.thm.evolvedb.graph.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.BooleanType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.BooleanType#getType()
	 * @see #getBooleanType()
	 * @generated
	 */
	EAttribute getBooleanType_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.BinaryTypes <em>Binary Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Types</em>'.
	 * @see de.thm.evolvedb.graph.BinaryTypes
	 * @generated
	 */
	EClass getBinaryTypes();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.BinaryTypes#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.BinaryTypes#getType()
	 * @see #getBinaryTypes()
	 * @generated
	 */
	EAttribute getBinaryTypes_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.BinaryTypes#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see de.thm.evolvedb.graph.BinaryTypes#getMinLength()
	 * @see #getBinaryTypes()
	 * @generated
	 */
	EAttribute getBinaryTypes_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.BinaryTypes#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see de.thm.evolvedb.graph.BinaryTypes#getMaxLength()
	 * @see #getBinaryTypes()
	 * @generated
	 */
	EAttribute getBinaryTypes_MaxLength();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type</em>'.
	 * @see de.thm.evolvedb.graph.ListType
	 * @generated
	 */
	EClass getListType();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.ListType#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see de.thm.evolvedb.graph.ListType#getLowerBound()
	 * @see #getListType()
	 * @generated
	 */
	EAttribute getListType_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.ListType#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see de.thm.evolvedb.graph.ListType#getUpperBound()
	 * @see #getListType()
	 * @generated
	 */
	EAttribute getListType_UpperBound();

	/**
	 * Returns the meta object for the containment reference '{@link de.thm.evolvedb.graph.ListType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.ListType#getType()
	 * @see #getListType()
	 * @generated
	 */
	EReference getListType_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.TemporalTypes <em>Temporal Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Types</em>'.
	 * @see de.thm.evolvedb.graph.TemporalTypes
	 * @generated
	 */
	EClass getTemporalTypes();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.TemporalTypes#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.TemporalTypes#getType()
	 * @see #getTemporalTypes()
	 * @generated
	 */
	EAttribute getTemporalTypes_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.thm.evolvedb.graph.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.graph.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.graph.Constraint#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Label</em>'.
	 * @see de.thm.evolvedb.graph.Constraint#getLabel()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Label();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.UniqueConstraint <em>Unique Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Constraint</em>'.
	 * @see de.thm.evolvedb.graph.UniqueConstraint
	 * @generated
	 */
	EClass getUniqueConstraint();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.UniqueConstraint#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.UniqueConstraint#getProperties()
	 * @see #getUniqueConstraint()
	 * @generated
	 */
	EReference getUniqueConstraint_Properties();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.PropertyTypeConstraint <em>Property Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Type Constraint</em>'.
	 * @see de.thm.evolvedb.graph.PropertyTypeConstraint
	 * @generated
	 */
	EClass getPropertyTypeConstraint();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.graph.PropertyTypeConstraint#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.PropertyTypeConstraint#getProperties()
	 * @see #getPropertyTypeConstraint()
	 * @generated
	 */
	EReference getPropertyTypeConstraint_Properties();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.graph.PropertyTypeConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.PropertyTypeConstraint#getType()
	 * @see #getPropertyTypeConstraint()
	 * @generated
	 */
	EReference getPropertyTypeConstraint_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.PropertyExistenceConstraint <em>Property Existence Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Existence Constraint</em>'.
	 * @see de.thm.evolvedb.graph.PropertyExistenceConstraint
	 * @generated
	 */
	EClass getPropertyExistenceConstraint();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.graph.PropertyExistenceConstraint#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.PropertyExistenceConstraint#getProperties()
	 * @see #getPropertyExistenceConstraint()
	 * @generated
	 */
	EReference getPropertyExistenceConstraint_Properties();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.KeyConstraint <em>Key Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Constraint</em>'.
	 * @see de.thm.evolvedb.graph.KeyConstraint
	 * @generated
	 */
	EClass getKeyConstraint();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.graph.KeyConstraint#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see de.thm.evolvedb.graph.KeyConstraint#getProperties()
	 * @see #getKeyConstraint()
	 * @generated
	 */
	EReference getKeyConstraint_Properties();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.GraphType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see de.thm.evolvedb.graph.GraphType
	 * @generated
	 */
	EEnum getGraphType();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.DynamicUnionTypes <em>Dynamic Union Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dynamic Union Types</em>'.
	 * @see de.thm.evolvedb.graph.DynamicUnionTypes
	 * @generated
	 */
	EEnum getDynamicUnionTypes();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.BooleanDataTypes <em>Boolean Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Boolean Data Types</em>'.
	 * @see de.thm.evolvedb.graph.BooleanDataTypes
	 * @generated
	 */
	EEnum getBooleanDataTypes();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.TemporalDataTypes <em>Temporal Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Temporal Data Types</em>'.
	 * @see de.thm.evolvedb.graph.TemporalDataTypes
	 * @generated
	 */
	EEnum getTemporalDataTypes();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.NumericDataTypes <em>Numeric Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Numeric Data Types</em>'.
	 * @see de.thm.evolvedb.graph.NumericDataTypes
	 * @generated
	 */
	EEnum getNumericDataTypes();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.StringDataTypes <em>String Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>String Data Types</em>'.
	 * @see de.thm.evolvedb.graph.StringDataTypes
	 * @generated
	 */
	EEnum getStringDataTypes();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.graph.BinaryDataTypes <em>Binary Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Data Types</em>'.
	 * @see de.thm.evolvedb.graph.BinaryDataTypes
	 * @generated
	 */
	EEnum getBinaryDataTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphFactory getGraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.PropertyGraphImpl <em>Property Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.PropertyGraphImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyGraph()
		 * @generated
		 */
		EClass PROPERTY_GRAPH = eINSTANCE.getPropertyGraph();

		/**
		 * The meta object literal for the '<em><b>Closed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_GRAPH__CLOSED = eINSTANCE.getPropertyGraph_Closed();

		/**
		 * The meta object literal for the '<em><b>Graphtype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_GRAPH__GRAPHTYPE = eINSTANCE.getPropertyGraph_Graphtype();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_GRAPH__ITEMS = eINSTANCE.getPropertyGraph_Items();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_GRAPH__NAME = eINSTANCE.getPropertyGraph_Name();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_GRAPH__LOCATION = eINSTANCE.getPropertyGraph_Location();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.GraphItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.GraphItemImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getGraphItem()
		 * @generated
		 */
		EClass GRAPH_ITEM = eINSTANCE.getGraphItem();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_ITEM__GRAPH = eINSTANCE.getGraphItem_Graph();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.NodeTypeImpl <em>Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.NodeTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNodeType()
		 * @generated
		 */
		EClass NODE_TYPE = eINSTANCE.getNodeType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_TYPE__NAME = eINSTANCE.getNodeType_Name();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__LABEL = eINSTANCE.getNodeType_Label();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__OUTGOING = eINSTANCE.getNodeType_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__INCOMING = eINSTANCE.getNodeType_Incoming();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__PROPERTIES = eINSTANCE.getNodeType_Properties();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.EdgeTypeImpl <em>Edge Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.EdgeTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getEdgeType()
		 * @generated
		 */
		EClass EDGE_TYPE = eINSTANCE.getEdgeType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_TYPE__NAME = eINSTANCE.getEdgeType_Name();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__LABELS = eINSTANCE.getEdgeType_Labels();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__PROPERTIES = eINSTANCE.getEdgeType_Properties();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__SRC = eINSTANCE.getEdgeType_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__TGT = eINSTANCE.getEdgeType_Tgt();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.LabelImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__PROPERTIES = eINSTANCE.getLabel_Properties();

		/**
		 * The meta object literal for the '<em><b>Super Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__SUPER_TYPE = eINSTANCE.getLabel_SuperType();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__CONSTRAINTS = eINSTANCE.getLabel_Constraints();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.EdgeLabelImpl <em>Edge Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.EdgeLabelImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getEdgeLabel()
		 * @generated
		 */
		EClass EDGE_LABEL = eINSTANCE.getEdgeLabel();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LABEL__EDGES = eINSTANCE.getEdgeLabel_Edges();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.NodeLabelImpl <em>Node Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.NodeLabelImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNodeLabel()
		 * @generated
		 */
		EClass NODE_LABEL = eINSTANCE.getNodeLabel();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LABEL__NODES = eINSTANCE.getNodeLabel_Nodes();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.PropertyImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__MANDATORY = eINSTANCE.getProperty_Mandatory();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.PropertyValueTypeImpl <em>Property Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.PropertyValueTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyValueType()
		 * @generated
		 */
		EClass PROPERTY_VALUE_TYPE = eINSTANCE.getPropertyValueType();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_VALUE_TYPE__NULLABLE = eINSTANCE.getPropertyValueType_Nullable();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.UnionTypeImpl <em>Union Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.UnionTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getUnionType()
		 * @generated
		 */
		EClass UNION_TYPE = eINSTANCE.getUnionType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNION_TYPE__TYPE = eINSTANCE.getUnionType_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.NumericTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNumericType()
		 * @generated
		 */
		EClass NUMERIC_TYPE = eINSTANCE.getNumericType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_TYPE__TYPE = eINSTANCE.getNumericType_Type();

		/**
		 * The meta object literal for the '<em><b>Integral Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_TYPE__INTEGRAL_PART = eINSTANCE.getNumericType_IntegralPart();

		/**
		 * The meta object literal for the '<em><b>Fractional Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_TYPE__FRACTIONAL_PART = eINSTANCE.getNumericType_FractionalPart();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.StringTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE__MIN_LENGTH = eINSTANCE.getStringType_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE__MAX_LENGTH = eINSTANCE.getStringType_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE__TYPE = eINSTANCE.getStringType_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.BooleanTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TYPE__TYPE = eINSTANCE.getBooleanType_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.BinaryTypesImpl <em>Binary Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.BinaryTypesImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBinaryTypes()
		 * @generated
		 */
		EClass BINARY_TYPES = eINSTANCE.getBinaryTypes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_TYPES__TYPE = eINSTANCE.getBinaryTypes_Type();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_TYPES__MIN_LENGTH = eINSTANCE.getBinaryTypes_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_TYPES__MAX_LENGTH = eINSTANCE.getBinaryTypes_MaxLength();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.ListTypeImpl <em>List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.ListTypeImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getListType()
		 * @generated
		 */
		EClass LIST_TYPE = eINSTANCE.getListType();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST_TYPE__LOWER_BOUND = eINSTANCE.getListType_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST_TYPE__UPPER_BOUND = eINSTANCE.getListType_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_TYPE__TYPE = eINSTANCE.getListType_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.TemporalTypesImpl <em>Temporal Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.TemporalTypesImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getTemporalTypes()
		 * @generated
		 */
		EClass TEMPORAL_TYPES = eINSTANCE.getTemporalTypes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORAL_TYPES__TYPE = eINSTANCE.getTemporalTypes_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.ConstraintImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__LABEL = eINSTANCE.getConstraint_Label();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.UniqueConstraintImpl <em>Unique Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.UniqueConstraintImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getUniqueConstraint()
		 * @generated
		 */
		EClass UNIQUE_CONSTRAINT = eINSTANCE.getUniqueConstraint();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIQUE_CONSTRAINT__PROPERTIES = eINSTANCE.getUniqueConstraint_Properties();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.PropertyTypeConstraintImpl <em>Property Type Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.PropertyTypeConstraintImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyTypeConstraint()
		 * @generated
		 */
		EClass PROPERTY_TYPE_CONSTRAINT = eINSTANCE.getPropertyTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TYPE_CONSTRAINT__PROPERTIES = eINSTANCE.getPropertyTypeConstraint_Properties();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TYPE_CONSTRAINT__TYPE = eINSTANCE.getPropertyTypeConstraint_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.PropertyExistenceConstraintImpl <em>Property Existence Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.PropertyExistenceConstraintImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getPropertyExistenceConstraint()
		 * @generated
		 */
		EClass PROPERTY_EXISTENCE_CONSTRAINT = eINSTANCE.getPropertyExistenceConstraint();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_EXISTENCE_CONSTRAINT__PROPERTIES = eINSTANCE.getPropertyExistenceConstraint_Properties();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.impl.KeyConstraintImpl <em>Key Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.impl.KeyConstraintImpl
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getKeyConstraint()
		 * @generated
		 */
		EClass KEY_CONSTRAINT = eINSTANCE.getKeyConstraint();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_CONSTRAINT__PROPERTIES = eINSTANCE.getKeyConstraint_Properties();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.GraphType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.GraphType
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getGraphType()
		 * @generated
		 */
		EEnum GRAPH_TYPE = eINSTANCE.getGraphType();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.DynamicUnionTypes <em>Dynamic Union Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.DynamicUnionTypes
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getDynamicUnionTypes()
		 * @generated
		 */
		EEnum DYNAMIC_UNION_TYPES = eINSTANCE.getDynamicUnionTypes();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.BooleanDataTypes <em>Boolean Data Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.BooleanDataTypes
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBooleanDataTypes()
		 * @generated
		 */
		EEnum BOOLEAN_DATA_TYPES = eINSTANCE.getBooleanDataTypes();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.TemporalDataTypes <em>Temporal Data Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.TemporalDataTypes
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getTemporalDataTypes()
		 * @generated
		 */
		EEnum TEMPORAL_DATA_TYPES = eINSTANCE.getTemporalDataTypes();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.NumericDataTypes <em>Numeric Data Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.NumericDataTypes
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getNumericDataTypes()
		 * @generated
		 */
		EEnum NUMERIC_DATA_TYPES = eINSTANCE.getNumericDataTypes();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.StringDataTypes <em>String Data Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.StringDataTypes
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getStringDataTypes()
		 * @generated
		 */
		EEnum STRING_DATA_TYPES = eINSTANCE.getStringDataTypes();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.BinaryDataTypes <em>Binary Data Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.BinaryDataTypes
		 * @see de.thm.evolvedb.graph.impl.GraphPackageImpl#getBinaryDataTypes()
		 * @generated
		 */
		EEnum BINARY_DATA_TYPES = eINSTANCE.getBinaryDataTypes();

	}

} //GraphPackage

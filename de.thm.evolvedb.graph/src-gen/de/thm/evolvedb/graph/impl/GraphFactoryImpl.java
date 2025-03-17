/**
 */
package de.thm.evolvedb.graph.impl;

import de.thm.evolvedb.graph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphFactoryImpl extends EFactoryImpl implements GraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphFactory init() {
		try {
			GraphFactory theGraphFactory = (GraphFactory) EPackage.Registry.INSTANCE.getEFactory(GraphPackage.eNS_URI);
			if (theGraphFactory != null) {
				return theGraphFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case GraphPackage.PROPERTY_GRAPH:
			return createPropertyGraph();
		case GraphPackage.NODE_TYPE:
			return createNodeType();
		case GraphPackage.EDGE:
			return createEdge();
		case GraphPackage.EDGE_LABEL:
			return createEdgeLabel();
		case GraphPackage.NODE_LABEL:
			return createNodeLabel();
		case GraphPackage.PROPERTY:
			return createProperty();
		case GraphPackage.UNION_TYPE:
			return createUnionType();
		case GraphPackage.NUMERIC_TYPE:
			return createNumericType();
		case GraphPackage.STRING_TYPE:
			return createStringType();
		case GraphPackage.BOOLEAN_TYPE:
			return createBooleanType();
		case GraphPackage.BINARY_TYPES:
			return createBinaryTypes();
		case GraphPackage.LIST_TYPE:
			return createListType();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case GraphPackage.GRAPH_TYPE:
			return createGraphTypeFromString(eDataType, initialValue);
		case GraphPackage.DYNAMIC_UNION_TYPES:
			return createDynamicUnionTypesFromString(eDataType, initialValue);
		case GraphPackage.BOOLEAN_DATA_TYPES:
			return createBooleanDataTypesFromString(eDataType, initialValue);
		case GraphPackage.TEMPORAL_DATA_TYPES:
			return createTemporalDataTypesFromString(eDataType, initialValue);
		case GraphPackage.NUMERIC_DATA_TYPES:
			return createNumericDataTypesFromString(eDataType, initialValue);
		case GraphPackage.STRING_DATA_TYPES:
			return createStringDataTypesFromString(eDataType, initialValue);
		case GraphPackage.BINARY_DATA_TYPES:
			return createBinaryDataTypesFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case GraphPackage.GRAPH_TYPE:
			return convertGraphTypeToString(eDataType, instanceValue);
		case GraphPackage.DYNAMIC_UNION_TYPES:
			return convertDynamicUnionTypesToString(eDataType, instanceValue);
		case GraphPackage.BOOLEAN_DATA_TYPES:
			return convertBooleanDataTypesToString(eDataType, instanceValue);
		case GraphPackage.TEMPORAL_DATA_TYPES:
			return convertTemporalDataTypesToString(eDataType, instanceValue);
		case GraphPackage.NUMERIC_DATA_TYPES:
			return convertNumericDataTypesToString(eDataType, instanceValue);
		case GraphPackage.STRING_DATA_TYPES:
			return convertStringDataTypesToString(eDataType, instanceValue);
		case GraphPackage.BINARY_DATA_TYPES:
			return convertBinaryDataTypesToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyGraph createPropertyGraph() {
		PropertyGraphImpl propertyGraph = new PropertyGraphImpl();
		return propertyGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType createNodeType() {
		NodeTypeImpl nodeType = new NodeTypeImpl();
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeLabel createEdgeLabel() {
		EdgeLabelImpl edgeLabel = new EdgeLabelImpl();
		return edgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeLabel createNodeLabel() {
		NodeLabelImpl nodeLabel = new NodeLabelImpl();
		return nodeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnionType createUnionType() {
		UnionTypeImpl unionType = new UnionTypeImpl();
		return unionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericType createNumericType() {
		NumericTypeImpl numericType = new NumericTypeImpl();
		return numericType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryTypes createBinaryTypes() {
		BinaryTypesImpl binaryTypes = new BinaryTypesImpl();
		return binaryTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListType createListType() {
		ListTypeImpl listType = new ListTypeImpl();
		return listType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphType createGraphTypeFromString(EDataType eDataType, String initialValue) {
		GraphType result = GraphType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGraphTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicUnionTypes createDynamicUnionTypesFromString(EDataType eDataType, String initialValue) {
		DynamicUnionTypes result = DynamicUnionTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDynamicUnionTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanDataTypes createBooleanDataTypesFromString(EDataType eDataType, String initialValue) {
		BooleanDataTypes result = BooleanDataTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporalDataTypes createTemporalDataTypesFromString(EDataType eDataType, String initialValue) {
		TemporalDataTypes result = TemporalDataTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemporalDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericDataTypes createNumericDataTypesFromString(EDataType eDataType, String initialValue) {
		NumericDataTypes result = NumericDataTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNumericDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringDataTypes createStringDataTypesFromString(EDataType eDataType, String initialValue) {
		StringDataTypes result = StringDataTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryDataTypes createBinaryDataTypesFromString(EDataType eDataType, String initialValue) {
		BinaryDataTypes result = BinaryDataTypes.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphPackage getGraphPackage() {
		return (GraphPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphPackage getPackage() {
		return GraphPackage.eINSTANCE;
	}

} //GraphFactoryImpl

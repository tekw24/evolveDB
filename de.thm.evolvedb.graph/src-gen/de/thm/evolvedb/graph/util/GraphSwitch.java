/**
 */
package de.thm.evolvedb.graph.util;

import de.thm.evolvedb.graph.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.graph.GraphPackage
 * @generated
 */
public class GraphSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphSwitch() {
		if (modelPackage == null) {
			modelPackage = GraphPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case GraphPackage.PROPERTY_GRAPH: {
			PropertyGraph propertyGraph = (PropertyGraph) theEObject;
			T result = casePropertyGraph(propertyGraph);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.GRAPH_ITEM: {
			GraphItem graphItem = (GraphItem) theEObject;
			T result = caseGraphItem(graphItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.NODE_TYPE: {
			NodeType nodeType = (NodeType) theEObject;
			T result = caseNodeType(nodeType);
			if (result == null)
				result = caseGraphItem(nodeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.EDGE: {
			Edge edge = (Edge) theEObject;
			T result = caseEdge(edge);
			if (result == null)
				result = caseGraphItem(edge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.LABEL: {
			Label label = (Label) theEObject;
			T result = caseLabel(label);
			if (result == null)
				result = caseGraphItem(label);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.EDGE_LABEL: {
			EdgeLabel edgeLabel = (EdgeLabel) theEObject;
			T result = caseEdgeLabel(edgeLabel);
			if (result == null)
				result = caseLabel(edgeLabel);
			if (result == null)
				result = caseGraphItem(edgeLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.NODE_LABEL: {
			NodeLabel nodeLabel = (NodeLabel) theEObject;
			T result = caseNodeLabel(nodeLabel);
			if (result == null)
				result = caseLabel(nodeLabel);
			if (result == null)
				result = caseGraphItem(nodeLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.PROPERTY: {
			Property property = (Property) theEObject;
			T result = caseProperty(property);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.PROPERTY_VALUE_TYPE: {
			PropertyValueType propertyValueType = (PropertyValueType) theEObject;
			T result = casePropertyValueType(propertyValueType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.UNION_TYPE: {
			UnionType unionType = (UnionType) theEObject;
			T result = caseUnionType(unionType);
			if (result == null)
				result = casePropertyValueType(unionType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.NUMERIC_TYPE: {
			NumericType numericType = (NumericType) theEObject;
			T result = caseNumericType(numericType);
			if (result == null)
				result = casePropertyValueType(numericType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.STRING_TYPE: {
			StringType stringType = (StringType) theEObject;
			T result = caseStringType(stringType);
			if (result == null)
				result = casePropertyValueType(stringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.BOOLEAN_TYPE: {
			BooleanType booleanType = (BooleanType) theEObject;
			T result = caseBooleanType(booleanType);
			if (result == null)
				result = casePropertyValueType(booleanType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.BINARY_TYPES: {
			BinaryTypes binaryTypes = (BinaryTypes) theEObject;
			T result = caseBinaryTypes(binaryTypes);
			if (result == null)
				result = casePropertyValueType(binaryTypes);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case GraphPackage.LIST_TYPE: {
			ListType listType = (ListType) theEObject;
			T result = caseListType(listType);
			if (result == null)
				result = casePropertyValueType(listType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyGraph(PropertyGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphItem(GraphItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeType(NodeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeLabel(EdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeLabel(NodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyValueType(PropertyValueType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnionType(UnionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericType(NumericType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Types</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Types</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryTypes(BinaryTypes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GraphSwitch

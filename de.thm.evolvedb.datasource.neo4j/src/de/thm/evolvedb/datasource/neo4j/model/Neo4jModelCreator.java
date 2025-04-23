package de.thm.evolvedb.datasource.neo4j.model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.thm.evolvedb.graph.Constraint;
import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.GraphFactory;
import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.KeyConstraint;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.PropertyGraph;
import de.thm.evolvedb.graph.PropertyValueType;
import de.thm.evolvedb.graph.StringDataTypes;
import de.thm.evolvedb.graph.StringType;
import de.thm.evolvedb.graph.UniqueConstraint;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyExistenceConstraint;

public class Neo4jModelCreator {

	protected GraphPackage graphPackage = GraphPackage.eINSTANCE;
	protected GraphFactory graphFactory = graphPackage.getGraphFactory();

	public EObject create(Connection con) {

		PropertyGraph graph = (PropertyGraph) createInitialModel();
		graph.setName("MyGraph");

		Map<String, NodeLabel> nodeLabels = new TreeMap<String, NodeLabel>();

		Statement stmt;
		try {
			stmt = con.createStatement();

			System.out.println("== Knoten-Labels ==");
			ResultSet rs = stmt.executeQuery("CALL db.labels()");
			ArrayList<String> labels = new ArrayList<String>();
			while (rs.next()) {
				System.out.println(rs.getString("label"));
				labels.add(rs.getString("label"));
			}

			for (String label : labels) {
				NodeLabel nodeLabel = createLabelWithProperties(label, stmt);
				nodeLabels.put(label, nodeLabel);
				graph.getItems().add(nodeLabel);
			}

			System.out.println("\n== Beziehungstypen ==");
			ResultSet rs2 = stmt.executeQuery("CALL apoc.meta.relTypeProperties() "
					+ "YIELD relType, propertyName, propertyTypes RETURN REPLACE(REPLACE(relType, \":`\", \"\"), \"`\", \"\") "
					+ "AS relTypeClean, propertyName, propertyTypes " + "ORDER BY relType, propertyName;");

			Map<String, Map<String, List>> relTypesAndProperties = new TreeMap<String, Map<String, List>>();
			while (rs2.next()) {
				System.out.println(rs2.getString("relTypeClean"));
				String relType = rs2.getString("relTypeClean");
				if (!relTypesAndProperties.containsKey(relType)) {
					String propertyName = rs2.getString("propertyName");

					Map<String, List> properties = new TreeMap<String, List>();
					if (propertyName != null) {
						List propertyTypes = rs2.getObject("propertyTypes", List.class);
						properties.put(propertyName, propertyTypes);
					}

					relTypesAndProperties.put(relType, properties);

				} else {
					String propertyName = rs2.getString("propertyName");
					if (propertyName != null) {
						List propertyTypes = rs2.getObject("propertyTypes", List.class);
						relTypesAndProperties.get(relType).put(propertyName, propertyTypes);
					}
				}

			}
			Map<String, EdgeLabel> edgeLabels = createRelationshipLabels(relTypesAndProperties, graph);

			// ---- Create NodeTypes

			System.out.println("\n== NodeTypes ==");
			ResultSet rs5 = stmt.executeQuery("	MATCH (n) WHERE size(labels(n)) >= 1 RETURN labels(n) "
					+ "AS labelCombo, count(*) AS count ORDER BY count DESC;");
			List<LabelCombo> labelCombos = new ArrayList<>();
			while (rs5.next()) {
				List<String> propertyTypes = rs5.getObject("labelCombo", List.class);
				int count = rs5.getInt("count");
				labelCombos.add(new LabelCombo(propertyTypes, count));
			}

			// TODO checken von Attributen
			List<NodeType> nodeTypes = createNodeTypes(labelCombos, graph, nodeLabels);

			// Create Edge Types
			System.out.println("\n== EdgeTypes ==");

			ResultSet rs6 = stmt.executeQuery(
					"	MATCH (a)-[r]->(b) RETURN DISTINCT labels(a) AS fromLabels, type(r) AS relationshipType, labels(b) AS toLabels;");

			List<EdgeTypeCombo> edgeTypeCombos = new ArrayList<Neo4jModelCreator.EdgeTypeCombo>();
			while (rs6.next()) {
				List<String> fromLabels = rs6.getObject("fromLabels", List.class);
				List<String> toLabels = rs6.getObject("toLabels", List.class);
				String relationshipType = rs6.getString("relationshipType");
				edgeTypeCombos.add(new EdgeTypeCombo(fromLabels, toLabels, relationshipType));

			}

			List<EdgeType> edgeTypes = createEdgeTypes(edgeTypeCombos, graph, nodeTypes, edgeLabels);

			// Create Constraints

			System.out.println("\n== Constraints ==");

			List<ConstraintModel> models = new ArrayList<Neo4jModelCreator.ConstraintModel>();

			ResultSet rs7 = stmt.executeQuery("SHOW CONSTRAINTS");
			while (rs7.next()) {

				String name = rs7.getString("name");
				String type = rs7.getString("type");
				String entityType = rs7.getString("entityType");
				List<String> labelsOrTypes = rs7.getObject("labelsOrTypes", List.class);
				List<String> properties = rs7.getObject("properties", List.class);
				String ownedIndex = rs7.getString("ownedIndex");
				String propertyType = rs7.getString("propertyType");

				ConstraintModel model = new ConstraintModel(name, type, entityType, labelsOrTypes, properties,
						ownedIndex, propertyType);
				models.add(model);

			}

			List<Constraint> cosntraints = createConstraints(models, edgeLabels, nodeLabels);

			System.out.println("\n== Property Keys ==");
			ResultSet rs3 = stmt.executeQuery("CALL db.propertyKeys()");
			while (rs3.next()) {
				System.out.println(rs3.getString("propertyKey"));
			}

			ResultSet rs4 = stmt.executeQuery(
					"MATCH (n) UNWIND labels(n) AS label " + "WITH label, keys(n) AS props UNWIND props AS key "
							+ "RETURN label, collect(DISTINCT key) AS properties ORDER BY label");
			while (rs4.next()) {
				System.out.println("- " + rs4.getString("label") + ": " + rs4.getObject("properties").toString());

			}
			stmt.close();
			con.close();
			return graph;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return graph;

	}

	private List<Constraint> createConstraints(List<ConstraintModel> models, Map<String, EdgeLabel> edgeLabels,
			Map<String, NodeLabel> nodeLabels) {

		List<Constraint> constraints = new ArrayList<Constraint>();

		for (ConstraintModel constraintModel : models) {


			switch (constraintModel.type) {
			case "UNIQUENESS": {

				UniqueConstraint uniqueConstraint = graphFactory.createUniqueConstraint();
				uniqueConstraint.setName("constraint_1");

				if (constraintModel.getEntityType().equals("NODE")) {
					if (constraintModel.getLabelsOrTypes().size() == 1) {
						NodeLabel nodeLabel = nodeLabels.get(constraintModel.getLabelsOrTypes().get(0));
						if (nodeLabel != null) {
							uniqueConstraint.setLabel(nodeLabel);
							for (Property property : nodeLabel.getProperties()) {
								if (constraintModel.getProperties().contains(property.getName()))
									uniqueConstraint.getProperties().add(property);
							}
						}

					} else if (constraintModel.getLabelsOrTypes().size() > 1) {
						// TODO gibt es diesen Fall überhaupt?
					}
				} else if (constraintModel.getEntityType().equals("RELATIONSHIP")) {
					if (constraintModel.getLabelsOrTypes().size() == 1) {
						EdgeLabel edgeLabel = edgeLabels.get(constraintModel.getLabelsOrTypes().get(0));
						if (edgeLabel != null) {
							uniqueConstraint.setLabel(edgeLabel);
							for (Property property : edgeLabel.getProperties()) {
								if (constraintModel.getProperties().contains(property.getName()))
									uniqueConstraint.getProperties().add(property);
							}
						}

					} else if (constraintModel.getLabelsOrTypes().size() > 1) {
						// TODO gibt es diesen Fall überhaupt?
					}

				}
				constraints.add(uniqueConstraint);
				break;
			}
			case "NODE_KEY": {

				KeyConstraint keyConstraint = graphFactory.createKeyConstraint();
				keyConstraint.setName("constraint_1");

				if (constraintModel.getEntityType().equals("NODE")) {
					if (constraintModel.getLabelsOrTypes().size() == 1) {
						NodeLabel nodeLabel = nodeLabels.get(constraintModel.getLabelsOrTypes().get(0));
						if (nodeLabel != null) {
							keyConstraint.setLabel(nodeLabel);
							for (Property property : nodeLabel.getProperties()) {
								if (constraintModel.getProperties().contains(property.getName()))
									keyConstraint.getProperties().add(property);
							}
						}

					} else if (constraintModel.getLabelsOrTypes().size() > 1) {
						// TODO gibt es diesen Fall überhaupt?
					}
				} else if (constraintModel.getEntityType().equals("RELATIONSHIP")) {
					if (constraintModel.getLabelsOrTypes().size() == 1) {
						EdgeLabel edgeLabel = edgeLabels.get(constraintModel.getLabelsOrTypes().get(0));
						if (edgeLabel != null) {
							keyConstraint.setLabel(edgeLabel);
							for (Property property : edgeLabel.getProperties()) {
								if (constraintModel.getProperties().contains(property.getName()))
									keyConstraint.getProperties().add(property);
							}
						}

					} else if (constraintModel.getLabelsOrTypes().size() > 1) {
						// TODO gibt es diesen Fall überhaupt?
					}

				}
				constraints.add(keyConstraint);
				break;
			}
			case "NODE_PROPERTY_EXISTENCE": {

				PropertyExistenceConstraint propertyExistenceConstraint = graphFactory
						.createPropertyExistenceConstraint();

				if (constraintModel.getLabelsOrTypes().size() == 1) {
					NodeLabel nodeLabel = nodeLabels.get(constraintModel.getLabelsOrTypes().get(0));
					if (nodeLabel != null) {
						propertyExistenceConstraint.setLabel(nodeLabel);
						for (Property property : nodeLabel.getProperties()) {
							if (constraintModel.getProperties().contains(property.getName())) {
								propertyExistenceConstraint.setProperties(property);
								break;
							}
						}
					}

				} else if (constraintModel.getLabelsOrTypes().size() > 1) {
					// TODO gibt es diesen Fall überhaupt?
				}
				constraints.add(propertyExistenceConstraint);
				break;
			}

			case "RELATIONSHIP_PROPERTY_EXISTENCE": {
				PropertyExistenceConstraint propertyExistenceConstraint = graphFactory
						.createPropertyExistenceConstraint();

				if (constraintModel.getLabelsOrTypes().size() == 1) {
					EdgeLabel edgeLabel = edgeLabels.get(constraintModel.getLabelsOrTypes().get(0));
					if (edgeLabel != null) {
						propertyExistenceConstraint.setLabel(edgeLabel);
						for (Property property : edgeLabel.getProperties()) {
							if (constraintModel.getProperties().contains(property.getName())) {
								propertyExistenceConstraint.setProperties(property);
								break;
							}
						}
					}

				} else if (constraintModel.getLabelsOrTypes().size() > 1) {
					// TODO gibt es diesen Fall überhaupt?
				}
				constraints.add(propertyExistenceConstraint);
				break;
			}
			default:
				break;
			}

		}

		return constraints;
	}

	private List<EdgeType> createEdgeTypes(List<EdgeTypeCombo> edgeTypeCombos, PropertyGraph graph,
			List<NodeType> nodeTypes, Map<String, EdgeLabel> edgeLabels) {

		List<EdgeType> edgeTypes = new ArrayList<EdgeType>();

		for (EdgeTypeCombo edgeTypeCombo : edgeTypeCombos) {
			NodeType nodeTypeFrom = getNodeTypeForLabelCombo(nodeTypes, edgeTypeCombo.getFromLabels());
			NodeType nodeTypeTo = getNodeTypeForLabelCombo(nodeTypes, edgeTypeCombo.getToLabels());
			EdgeLabel label = edgeLabels.get(edgeTypeCombo.getRelationshipType());

			EdgeType edgeType = graphFactory.createEdgeType();
			edgeType.setSrc(nodeTypeFrom);
			edgeType.setTgt(nodeTypeTo);
			edgeType.getLabels().add(label);

			graph.getItems().add(edgeType);
			edgeTypes.add(edgeType);
		}

		return edgeTypes;
	}

	private NodeType getNodeTypeForLabelCombo(List<NodeType> nodeTypes, List<String> labels) {

		for (NodeType nodeType : nodeTypes) {

			String labelConcat = "";

			for (NodeLabel nodeLabel : nodeType.getLabel()) {
				labelConcat += nodeLabel.getName();
			}

			boolean contains = true;
			for (String label : labels) {
				if (!labelConcat.contains(label)) {
					contains = false;
					break;
				}
			}

			if (contains) {
				return nodeType;
			}

		}

		return null;

	}

	private List<NodeType> createNodeTypes(List<LabelCombo> labelCombos, PropertyGraph graph,
			Map<String, NodeLabel> nodeLabels) {

		List<NodeType> nodeTypes = new ArrayList<NodeType>();

		for (LabelCombo labelCombo : labelCombos) {

			NodeType nodeType = graphFactory.createNodeType();

			for (String label : labelCombo.getLabelCombo()) {
				NodeLabel nodeLabel = nodeLabels.get(label);
				nodeType.getLabel().add(nodeLabel);
			}

			graph.getItems().add(nodeType);
			nodeTypes.add(nodeType);
			// Check Attributes

		}
		return nodeTypes;

	}

	/**
	 * Creates and Returns a new Label with its properties
	 * 
	 * @param name
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	protected NodeLabel createLabelWithProperties(String name, Statement stmt) throws SQLException {
		NodeLabel label = (NodeLabel) graphFactory.create(graphPackage.getNodeLabel());
		label.setName(name);

		String query = "MATCH (n:" + name
				+ ") UNWIND labels(n) AS label WITH label, keys(n) AS props UNWIND props AS key RETURN collect(DISTINCT key) AS properties";

		ResultSet rs = stmt.executeQuery(query);

		List list = null;

		while (rs.next()) {
			list = rs.getObject("properties", List.class);

		}

		rs.close();

		if (list != null) {
			for (Object propertyName : list) {
				System.out.println(propertyName.toString());
				String query2 = "MATCH (p:" + name + ") RETURN apoc.meta.cypher.type(p." + propertyName.toString()
						+ ") AS typeInfo, count(*) AS occurrences ORDER BY occurrences DESC;";
				ResultSet rs1 = stmt.executeQuery(query2);

				Map<String, Integer> types = new TreeMap<String, Integer>();

				while (rs1.next()) {
					types.put(rs1.getString("typeInfo"), rs1.getInt("occurrences"));
				}

				Property property = (Property) graphFactory.create(graphPackage.getProperty());
				property.setName(propertyName.toString());

				// TODO
				StringType propertyValueType = (StringType) graphFactory.create(graphPackage.getStringType());
				propertyValueType.setType(StringDataTypes.STRING);

				property.setValue(propertyValueType);
				label.getProperties().add(property);

			}
		}

		return label;
	}

	protected Map<String, EdgeLabel> createRelationshipLabels(Map<String, Map<String, List>> relTypesAndProperties,
			PropertyGraph graph) {

		Map<String, EdgeLabel> edgeLabels = new TreeMap<String, EdgeLabel>();
		for (Entry<String, Map<String, List>> entry : relTypesAndProperties.entrySet()) {
			EdgeLabel edgeLabel = graphFactory.createEdgeLabel();
			edgeLabel.setName(entry.getKey());

			for (Entry<String, List> entry2 : entry.getValue().entrySet()) {
				Property property = graphFactory.createProperty();
				property.setName(entry2.getKey());

				List datatype = entry2.getValue();

				if (datatype.size() == 1) {
					StringType propertyValueType = graphFactory.createStringType();
					propertyValueType.setType(StringDataTypes.STRING);
					property.setValue(propertyValueType);
				} else {
					// TODO
				}

				edgeLabel.getProperties().add(property);

			}

			graph.getItems().add(edgeLabel);
			edgeLabels.put(entry.getKey(), edgeLabel);

		}
		return edgeLabels;

	}

	/**
	 * Create a new model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EObject createInitialModel() {
		EClass eClass = graphPackage.getPropertyGraph();
		EObject rootObject = graphFactory.create(eClass);
		return rootObject;
	}

	private class LabelCombo {

		private List<String> labelCombo;
		private int count;

		public LabelCombo(List<String> labelCombo, int count) {
			this.count = count;
			this.labelCombo = labelCombo;
		}

		public List<String> getLabelCombo() {
			return labelCombo;
		}

		public void setLabelCombo(List<String> labelCombo) {
			this.labelCombo = labelCombo;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

	private class ConstraintModel {

		private String name;
		private String type;
		private String entityType;
		private List<String> labelsOrTypes;
		private List<String> properties;
		private String ownedIndex;
		private String propertyType;

		public ConstraintModel(String name, String type, String entityType, List<String> labelsOrTypes,
				List<String> properties, String ownedIndex, String propertyType) {
			this.name = name;
			this.type = type;
			this.entityType = entityType;
			this.labelsOrTypes = labelsOrTypes;
			this.properties = properties;
			this.ownedIndex = ownedIndex;
			this.propertyType = propertyType;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getEntityType() {
			return entityType;
		}

		public void setEntityType(String entityType) {
			this.entityType = entityType;
		}

		public List<String> getLabelsOrTypes() {
			return labelsOrTypes;
		}

		public void setLabelsOrTypes(List<String> labelsOrTypes) {
			this.labelsOrTypes = labelsOrTypes;
		}

		public List<String> getProperties() {
			return properties;
		}

		public void setProperties(List<String> properties) {
			this.properties = properties;
		}

		public String getOwnedIndex() {
			return ownedIndex;
		}

		public void setOwnedIndex(String ownedIndex) {
			this.ownedIndex = ownedIndex;
		}

		public String getPropertyType() {
			return propertyType;
		}

		public void setPropertyType(String propertyType) {
			this.propertyType = propertyType;
		}

	}

	private class EdgeTypeCombo {
		private List<String> fromLabels;
		private List<String> toLabels;
		private String relationshipType;

		public EdgeTypeCombo(List<String> fromLabels, List<String> toLabels, String relationshipType) {
			this.fromLabels = fromLabels;
			this.toLabels = toLabels;
			this.relationshipType = relationshipType;
		}

		public List<String> getFromLabels() {
			return fromLabels;
		}

		public void setFromLabels(List<String> fromLabels) {
			this.fromLabels = fromLabels;
		}

		public List<String> getToLabels() {
			return toLabels;
		}

		public void setToLabels(List<String> toLabels) {
			this.toLabels = toLabels;
		}

		public String getRelationshipType() {
			return relationshipType;
		}

		public void setRelationshipType(String relationshipType) {
			this.relationshipType = relationshipType;
		}

	}

}

package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.Label;
import de.thm.evolvedb.graph.Property;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * GeoTemplates
 * - Static Xtend template helpers that return textual GEO specifications (as CharSequence)
 * - Each method corresponds to one GEO operator flavor
 * - Parameters supply all needed data; no global state required
 * 
 * Notes
 * - These are *text* templates (Xtend template expressions) for the GEO-DSL.
 */
@SuppressWarnings("all")
public class GEOTemplates {
  /**
   * Utility: quote a string for inclusion into the GEO text
   */
  public static String q(final String s) {
    String _xblockexpression = null;
    {
      if ((s == null)) {
        return "null";
      }
      String _replace = s.replace("\"", "\\\"");
      String _plus = ("" + _replace);
      _xblockexpression = (_plus + "");
    }
    return _xblockexpression;
  }

  /**
   * Utility: join a list with a separator
   */
  public static String join(final Iterable<String> parts, final String sep) {
    return GEOTemplates.join(parts, sep);
  }

  /**
   * GEO: Add node with label <label_name>
   */
  public static CharSequence addNodeLabel(final String label) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add nodelabel ");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Add label <label_name_to_add> to node with label <node_label>
   */
  public static CharSequence addLabelToNode(final String labelToAdd, final String nodeLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add label ");
    String _q = GEOTemplates.q(labelToAdd);
    _builder.append(_q);
    _builder.append(" to node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Delete label <label_name_to_delete> of node with label <node_label>
   */
  public static CharSequence deleteLabelFromNode(final String labelToDelete, final String nodeLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete label ");
    String _q = GEOTemplates.q(labelToDelete);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Rename label <old_label> of node with label <node_label>
   *     to label <new_label>
   */
  public static CharSequence renameLabelOfNode(final String oldLabel, final String nodeLabel, final String newLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename label ");
    String _q = GEOTemplates.q(oldLabel);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" to label ");
    String _q_2 = GEOTemplates.q(newLabel);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Add property <property_name> to node with label <node_label>
   */
  public static CharSequence addSimpleNodeProperty(final String nodeLabel, final String propertyName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add property ");
    String _q = GEOTemplates.q(propertyName);
    _builder.append(_q);
    _builder.append(" to node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Delete property <property_name> of node with label <node_label>
   */
  public static CharSequence deleteNodeProperty(final String nodeLabel, final String propertyName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete property ");
    String _q = GEOTemplates.q(propertyName);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Rename property <fromProp> of node with label <node_label>
   *     to property <toProp>
   */
  public static CharSequence renameSimpleNodeProperty(final String nodeLabel, final String fromProp, final String toProp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename property ");
    String _q = GEOTemplates.q(fromProp);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" to property ");
    String _q_2 = GEOTemplates.q(toProp);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Change property type <fromProp> of property with label <node_label>
   *     to property <toProp>
   */
  public static CharSequence changeType(final String property, final String oldType, final String newType, final String labelName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Change datatype of property ");
    _builder.append(property);
    _builder.append(" with ");
    _builder.append(labelName);
    _builder.append(" from ");
    _builder.append(oldType);
    _builder.append(" to ");
    _builder.append(newType);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Pfad-Variante aus deiner Definition:
   * (Add | Delete | Rename) (label | property) ... starting at relationship with type ..., ending at relationship with type ...
   * 
   * Add label:
   * Add label <labelToAdd> to node with label <nodeLabel>
   *     starting at relationship with type <startRelType>, ending at relationship with type <endRelType>
   */
  public static CharSequence addLabelToNodeOnPath(final String labelToAdd, final String nodeLabel, final String startRelType, final String endRelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add label ");
    String _q = GEOTemplates.q(labelToAdd);
    _builder.append(_q);
    _builder.append(" to node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("starting at relationship with type ");
    String _q_2 = GEOTemplates.q(startRelType);
    _builder.append(_q_2, "    ");
    _builder.append(", ending at relationship with type ");
    String _q_3 = GEOTemplates.q(endRelType);
    _builder.append(_q_3, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Delete label ... on path
   */
  public static CharSequence deleteLabelFromNodeOnPath(final String labelToDelete, final String nodeLabel, final String startRelType, final String endRelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete label ");
    String _q = GEOTemplates.q(labelToDelete);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("starting at relationship with type ");
    String _q_2 = GEOTemplates.q(startRelType);
    _builder.append(_q_2, "    ");
    _builder.append(", ending at relationship with type ");
    String _q_3 = GEOTemplates.q(endRelType);
    _builder.append(_q_3, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Add label to nodetype
   */
  public static CharSequence addNodeLabelToNodeType(final List<String> nodeTypeLabels, final String newLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add nodelabel ");
    String _q = GEOTemplates.q(newLabel);
    _builder.append(_q);
    _builder.append(" to nodetype ");
    {
      boolean _hasElements = false;
      for(final String s : nodeTypeLabels) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append(s);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Rename label ... on path
   */
  public static CharSequence renameLabelOfNodeOnPath(final String oldLabel, final String newLabel, final String nodeLabel, final String startRelType, final String endRelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename label ");
    String _q = GEOTemplates.q(oldLabel);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" to label ");
    String _q_2 = GEOTemplates.q(newLabel);
    _builder.append(_q_2);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("starting at relationship with type ");
    String _q_3 = GEOTemplates.q(startRelType);
    _builder.append(_q_3, "    ");
    _builder.append(", ending at relationship with type ");
    String _q_4 = GEOTemplates.q(endRelType);
    _builder.append(_q_4, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Add property ... on path
   */
  public static CharSequence addPropertyToNodeOnPath(final String propertyName, final String nodeLabel, final String startRelType, final String endRelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add property ");
    String _q = GEOTemplates.q(propertyName);
    _builder.append(_q);
    _builder.append(" to node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("starting at relationship with type ");
    String _q_2 = GEOTemplates.q(startRelType);
    _builder.append(_q_2, "    ");
    _builder.append(", ending at relationship with type ");
    String _q_3 = GEOTemplates.q(endRelType);
    _builder.append(_q_3, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Add property ... on path
   */
  public static CharSequence addPropertyToNode(final String propertyName, final String nodeLabel, final String datatype) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add property ");
    String _q = GEOTemplates.q(propertyName);
    _builder.append(_q);
    _builder.append(" with datatype ");
    _builder.append(datatype);
    _builder.append(" to nodelabel with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Delete property ... on path
   */
  public static CharSequence deletePropertyFromNodeOnPath(final String propertyName, final String nodeLabel, final String startRelType, final String endRelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete property ");
    String _q = GEOTemplates.q(propertyName);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("starting at relationship with type ");
    String _q_2 = GEOTemplates.q(startRelType);
    _builder.append(_q_2, "    ");
    _builder.append(", ending at relationship with type ");
    String _q_3 = GEOTemplates.q(endRelType);
    _builder.append(_q_3, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Rename property ... on path
   */
  public static CharSequence renamePropertyOfNodeOnPath(final String fromProp, final String toProp, final String nodeLabel, final String startRelType, final String endRelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename property ");
    String _q = GEOTemplates.q(fromProp);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.append(" to property ");
    String _q_2 = GEOTemplates.q(toProp);
    _builder.append(_q_2);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("starting at relationship with type ");
    String _q_3 = GEOTemplates.q(startRelType);
    _builder.append(_q_3, "    ");
    _builder.append(", ending at relationship with type ");
    String _q_4 = GEOTemplates.q(endRelType);
    _builder.append(_q_4, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Rename label <old_label> of node with label <old_label> to label <new_label>
   */
  public static CharSequence renameNodeLabel(final String oldLabel, final String newLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename label ");
    String _q = GEOTemplates.q(oldLabel);
    _builder.append(_q);
    _builder.append(" of node with label ");
    String _q_1 = GEOTemplates.q(oldLabel);
    _builder.append(_q_1);
    _builder.append(" to label ");
    String _q_2 = GEOTemplates.q(newLabel);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Rename type <old_type> of relationship with type <old_type> to type <new_type>
   */
  public static CharSequence renameRelationshipType(final String oldType, final String newType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename type ");
    String _q = GEOTemplates.q(oldType);
    _builder.append(_q);
    _builder.append(" of relationship with type ");
    String _q_1 = GEOTemplates.q(oldType);
    _builder.append(_q_1);
    _builder.append(" to type ");
    String _q_2 = GEOTemplates.q(newType);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Delete node with label <label_name> with/without connecting relationships
   */
  public static CharSequence deleteNode(final String label, final boolean withConnectingRelationships) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete node with label ");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.append(" ");
    {
      if (withConnectingRelationships) {
        _builder.append("with");
      } else {
        _builder.append("without");
      }
    }
    _builder.append(" connecting relationships");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Einfache Variante:
   * Add relationship with type <type_name>
   */
  public static CharSequence addRelationshipType(final String relType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add relationship with type ");
    String _q = GEOTemplates.q(relType);
    _builder.append(_q);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence addEdgeType(final String edgeType, final List<String> labelNames, final String srcName, final String tgtName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add relationship_type ");
    String _q = GEOTemplates.q(edgeType);
    _builder.append(_q);
    _builder.append(" with label ");
    {
      boolean _hasElements = false;
      for(final String s : labelNames) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append(s);
      }
    }
    _builder.append(" starting from ");
    _builder.append(srcName);
    _builder.append(" ending at ");
    _builder.append(tgtName);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Vollständiger laut Definition:
   * Add relationship with type <type_name> starting at node with label <startLabel>, ending at node with label <endLabel>
   */
  public static CharSequence addRelationship(final String relType, final String startNodeLabel, final String endNodeLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add relationship with type ");
    String _q = GEOTemplates.q(relType);
    _builder.append(_q);
    _builder.append(" starting at node with label ");
    String _q_1 = GEOTemplates.q(startNodeLabel);
    _builder.append(_q_1);
    _builder.append(", ending at node with label ");
    String _q_2 = GEOTemplates.q(endNodeLabel);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Delete relationship with type <type_name> starting at node with label <startLabel>, ending at node with label <endLabel>
   */
  public static CharSequence deleteRelationship(final String relType, final String startNodeLabel, final String endNodeLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete relationship with type ");
    String _q = GEOTemplates.q(relType);
    _builder.append(_q);
    _builder.append(" starting at node with label ");
    String _q_1 = GEOTemplates.q(startNodeLabel);
    _builder.append(_q_1);
    _builder.append(", ending at node with label ");
    String _q_2 = GEOTemplates.q(endNodeLabel);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Rename relationship with type <old_type> starting at node with label <startLabel>, ending at node with label <endLabel>
   *     to relationship with type <new_type>
   */
  public static CharSequence renameRelationshipBetween(final String oldType, final String newType, final String startNodeLabel, final String endNodeLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename relationship with type ");
    String _q = GEOTemplates.q(oldType);
    _builder.append(_q);
    _builder.append(" starting at node with label ");
    String _q_1 = GEOTemplates.q(startNodeLabel);
    _builder.append(_q_1);
    _builder.append(", ending at node with label ");
    String _q_2 = GEOTemplates.q(endNodeLabel);
    _builder.append(_q_2);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("to relationship with type ");
    String _q_3 = GEOTemplates.q(newType);
    _builder.append(_q_3, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Add property <property> of type <type> with default <default> to relationship with type <relType>
   */
  public static CharSequence addRelationshipProperty(final String relType, final String property, final String type, final String defaultValue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Add property ");
    String _q = GEOTemplates.q(property);
    _builder.append(_q);
    _builder.append(" of type ");
    String _q_1 = GEOTemplates.q(type);
    _builder.append(_q_1);
    _builder.append(" with default ");
    String _q_2 = GEOTemplates.q(defaultValue);
    _builder.append(_q_2);
    _builder.append(" to relationship with type ");
    String _q_3 = GEOTemplates.q(relType);
    _builder.append(_q_3);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Delete property <property> of relationship with type <relType>
   */
  public static CharSequence deleteRelationshipProperty(final String relType, final String property) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Delete property ");
    String _q = GEOTemplates.q(property);
    _builder.append(_q);
    _builder.append(" of relationship with type ");
    String _q_1 = GEOTemplates.q(relType);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Rename property <fromProp> of relationship with type <relType> to property <toProp>
   */
  public static CharSequence renameRelationshipProperty(final String relType, final String fromProp, final String toProp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename property ");
    String _q = GEOTemplates.q(fromProp);
    _builder.append(_q);
    _builder.append(" of relationship with type ");
    String _q_1 = GEOTemplates.q(relType);
    _builder.append(_q_1);
    _builder.append(" to property ");
    String _q_2 = GEOTemplates.q(toProp);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Copy label <featureName> of node with label <fromId> to node with label <toId>
   * Copy property <featureName> of relationship with type <fromId> to node with label <toId>
   * 
   * Parameter:
   *  featureKind : "label" or "property"
   *  fromKind    : "node" or "relationship"
   *  toKind      : "node" or "relationship"
   *  fromId      : Labelname (bei node) oder Typname (bei relationship)
   *  toId        : Labelname (bei node) oder Typname (bei relationship)
   */
  public static CharSequence copyFeature(final String featureKind, final String featureName, final String fromKind, final String fromId, final String toKind, final String toId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Copy ");
    _builder.append(featureKind);
    _builder.append(" ");
    String _q = GEOTemplates.q(featureName);
    _builder.append(_q);
    _builder.append(" of ");
    _builder.append(fromKind);
    _builder.append(" with ");
    {
      boolean _equals = Objects.equals(fromKind, "node");
      if (_equals) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q_1 = GEOTemplates.q(fromId);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("to ");
    _builder.append(toKind, "    ");
    _builder.append(" with ");
    {
      boolean _equals_1 = Objects.equals(toKind, "node");
      if (_equals_1) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q_2 = GEOTemplates.q(toId);
    _builder.append(_q_2, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Move <featureKind> <featureName> of <fromKind> with label/type <fromId>
   *     to <toKind> with label/type <toId>
   */
  public static CharSequence moveFeature(final String featureKind, final String featureName, final String fromKind, final String fromId, final String toKind, final String toId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Move ");
    _builder.append(featureKind);
    _builder.append(" ");
    String _q = GEOTemplates.q(featureName);
    _builder.append(_q);
    _builder.append(" of ");
    _builder.append(fromKind);
    _builder.append(" with ");
    {
      boolean _equals = Objects.equals(fromKind, "node");
      if (_equals) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q_1 = GEOTemplates.q(fromId);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("to ");
    _builder.append(toKind, "    ");
    _builder.append(" with ");
    {
      boolean _equals_1 = Objects.equals(toKind, "node");
      if (_equals_1) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q_2 = GEOTemplates.q(toId);
    _builder.append(_q_2, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * relationHandling:
   *  - "keep"
   *  - "delete"
   *  - "keepOfPartA"
   *  - "keepOfPartB"
   * 
   * GEO (Beispiele):
   * Split node with label "Person" at property "status" keep relations
   * Split relationship with type "KNOWS" at property "since" delete relations
   * Split node with label "Person" at property "status" keep relations "of" partA
   */
  public static CharSequence splitElement(final String kind, final String id, final String propertyName, final String relationHandling, final String partALabel, final String partBLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Split ");
    _builder.append(kind);
    _builder.append(" with ");
    {
      boolean _equals = Objects.equals(kind, "node");
      if (_equals) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q = GEOTemplates.q(id);
    _builder.append(_q);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("at property ");
    String _q_1 = GEOTemplates.q(propertyName);
    _builder.append(_q_1, "    ");
    _builder.append(" ");
    {
      boolean _equals_1 = Objects.equals(relationHandling, "keep");
      if (_equals_1) {
        _builder.append("keep relations");
      } else {
        boolean _equals_2 = Objects.equals(relationHandling, "delete");
        if (_equals_2) {
          _builder.append("delete relations");
        } else {
          boolean _equals_3 = Objects.equals(relationHandling, "keepOfPartA");
          if (_equals_3) {
            _builder.append("keep relations \"of\" ");
            String _q_2 = GEOTemplates.q(partALabel);
            _builder.append(_q_2, "    ");
          } else {
            boolean _equals_4 = Objects.equals(relationHandling, "keepOfPartB");
            if (_equals_4) {
              _builder.append("keep relations \"of\" ");
              String _q_3 = GEOTemplates.q(partBLabel);
              _builder.append(_q_3, "    ");
            }
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("into ");
    _builder.append(kind, "    ");
    _builder.append(" with label/type ");
    String _q_4 = GEOTemplates.q(partALabel);
    _builder.append(_q_4, "    ");
    _builder.append(" and ");
    String _q_5 = GEOTemplates.q(partBLabel);
    _builder.append(_q_5, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Transform node with label <label> to relationship with type <relType>
   */
  public static CharSequence transformNodeToRelationship(final String nodeLabel, final String relType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Transform node with label ");
    String _q = GEOTemplates.q(nodeLabel);
    _builder.append(_q);
    _builder.append(" to relationship with type ");
    String _q_1 = GEOTemplates.q(relType);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * GEO:
   * Transform relationship with type <relType> to node with label <label>
   */
  public static CharSequence transformRelationshipToNode(final String relType, final String nodeLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Transform relationship with type ");
    String _q = GEOTemplates.q(relType);
    _builder.append(_q);
    _builder.append(" to node with label ");
    String _q_1 = GEOTemplates.q(nodeLabel);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * propertyKind : "duplicate" or "different"
   * elementKind  : "node" or "relationship"
   * deleteStrategy : "cascadeDelete" or "restrictedDelete"
   * joinType       : "inner" or "full outer exclusive"
   * 
   * GEO:
   * Merge <propertyKind> properties of <elementKind> with label/type <id>,
   *     (add label <extraLabels>)* and <deleteStrategy> originals -> <joinType> join
   */
  public static CharSequence mergeProperties(final String propertyKind, final String elementKind, final String id, final List<String> extraLabels, final String deleteStrategy, final String joinType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Merge ");
    _builder.append(propertyKind);
    _builder.append(" properties of ");
    _builder.append(elementKind);
    _builder.append(" with ");
    {
      boolean _equals = Objects.equals(elementKind, "node");
      if (_equals) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q = GEOTemplates.q(id);
    _builder.append(_q);
    {
      if (((extraLabels != null) && (!extraLabels.isEmpty()))) {
        _builder.newLineIfNotEmpty();
        _builder.append(", add label(s) [");
        {
          boolean _hasElements = false;
          for(final String l : extraLabels) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _q_1 = GEOTemplates.q(l);
            _builder.append(_q_1);
          }
        }
        _builder.append("]");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("and ");
    _builder.append(deleteStrategy, "\t");
    _builder.append(" originals -> ");
    _builder.append(joinType, "\t");
    _builder.append(" join");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * keepSide    : "left" or "right"
   * elementKind : "node" or "relationship"
   * 
   * GEO:
   * Keep all features of <keepSide> <elementKind> with label/type <leftId/rightId>
   *     add duplicates from <otherSide> <elementKind> with label/type <...> -> left/right join
   */
  public static CharSequence keepAllFeaturesJoin(final String keepSide, final String elementKind, final String leftId, final String rightId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Keep all features of ");
    _builder.append(keepSide);
    _builder.append(" ");
    _builder.append(elementKind);
    _builder.append(" with ");
    {
      boolean _equals = Objects.equals(elementKind, "node");
      if (_equals) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    {
      boolean _equals_1 = Objects.equals(keepSide, "left");
      if (_equals_1) {
        String _q = GEOTemplates.q(leftId);
        _builder.append(_q);
      } else {
        String _q_1 = GEOTemplates.q(rightId);
        _builder.append(_q_1);
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("add duplicates from ");
    {
      boolean _equals_2 = Objects.equals(keepSide, "left");
      if (_equals_2) {
        _builder.append("right");
      } else {
        _builder.append("left");
      }
    }
    _builder.append(" ");
    _builder.append(elementKind, "    ");
    _builder.append(" with ");
    {
      boolean _equals_3 = Objects.equals(elementKind, "node");
      if (_equals_3) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    {
      boolean _equals_4 = Objects.equals(keepSide, "left");
      if (_equals_4) {
        String _q_2 = GEOTemplates.q(rightId);
        _builder.append(_q_2, "    ");
      } else {
        String _q_3 = GEOTemplates.q(leftId);
        _builder.append(_q_3, "    ");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("-> ");
    {
      boolean _equals_5 = Objects.equals(keepSide, "left");
      if (_equals_5) {
        _builder.append("left");
      } else {
        _builder.append("right");
      }
    }
    _builder.append(" join");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * deleteStrategy : "cascadeDelete" or "restrictedDelete"
   * 
   * GEO:
   * copy properties of <fromKind> with label/type <fromId> to <toKind> with label/type <toId>
   *     and <deleteStrategy> originals -> full outer inclusive
   */
  public static CharSequence copyPropertiesAndDeleteOriginals(final String fromKind, final String fromId, final String toKind, final String toId, final String deleteStrategy) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("copy properties of ");
    _builder.append(fromKind);
    _builder.append(" with ");
    {
      boolean _equals = Objects.equals(fromKind, "node");
      if (_equals) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q = GEOTemplates.q(fromId);
    _builder.append(_q);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("to ");
    _builder.append(toKind, "    ");
    _builder.append(" with ");
    {
      boolean _equals_1 = Objects.equals(toKind, "node");
      if (_equals_1) {
        _builder.append("label");
      } else {
        _builder.append("type");
      }
    }
    _builder.append(" ");
    String _q_1 = GEOTemplates.q(toId);
    _builder.append(_q_1, "    ");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("and ");
    _builder.append(deleteStrategy, "    ");
    _builder.append(" originals -> full outer inclusive");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Spezielle Merge-Variante aus deiner ursprünglichen Klasse.
   * Passt nicht 1:1 in die neue Kurzsyntax, bleibt aber als Komfort-Template bestehen.
   */
  public static CharSequence mergeNodes(final String label, final List<String> keyProperties, final String conflictStrategy) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Merge duplicate properties of node with label ");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("using keys [");
    {
      boolean _hasElements = false;
      for(final String k : keyProperties) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "    ");
        }
        String _q_1 = GEOTemplates.q(k);
        _builder.append(_q_1, "    ");
      }
    }
    _builder.append("] ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("and conflict strategy ");
    String _q_2 = GEOTemplates.q(conflictStrategy);
    _builder.append(_q_2, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Eigenständige Copy-Subgraph-Operation (nicht explizit in der Liste, aber hilfreich).
   */
  public static CharSequence copySubgraph(final String rootLabel, final int depth, final Set<String> includeRelTypes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Copy subgraph of nodes with label ");
    String _q = GEOTemplates.q(rootLabel);
    _builder.append(_q);
    _builder.append(" up to depth ");
    _builder.append(depth);
    {
      if (((includeRelTypes != null) && (!includeRelTypes.isEmpty()))) {
        _builder.newLineIfNotEmpty();
        _builder.append("including relationships with types [");
        {
          boolean _hasElements = false;
          for(final String t : includeRelTypes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _q_1 = GEOTemplates.q(t);
            _builder.append(_q_1);
          }
        }
        _builder.append("]");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Split node – ursprüngliche Variante mit Prädikat und zwei Labels.
   */
  public static CharSequence splitNode(final String label, final String predicateExpr, final String newLabelTrue, final String newLabelFalse) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Split node with label ");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.append(" using predicate ");
    String _q_1 = GEOTemplates.q(predicateExpr);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("into node with label ");
    String _q_2 = GEOTemplates.q(newLabelTrue);
    _builder.append(_q_2, "    ");
    _builder.append(" and node with label ");
    String _q_3 = GEOTemplates.q(newLabelFalse);
    _builder.append(_q_3, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Move subgraph – ursprüngliche Variante mit Pfad.
   */
  public static CharSequence moveSubgraph(final String startLabel, final String pathPattern, final String newRootLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Move subgraph starting at node with label ");
    String _q = GEOTemplates.q(startLabel);
    _builder.append(_q);
    _builder.append(" along path ");
    String _q_1 = GEOTemplates.q(pathPattern);
    _builder.append(_q_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("to node with label ");
    String _q_2 = GEOTemplates.q(newRootLabel);
    _builder.append(_q_2, "    ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static String createKeyConstraint(final String string, final Label label, final EList<Property> list) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property x with dataype y and unique values (wäre dann quasi ein key constraint)");
    _builder.newLine();
    return _builder.toString();
  }

  public static String createUniqueConstraint(final String string, final Label label, final EList<Property> list) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property x with dataype y and unique values (wäre dann quasi ein key constraint)");
    _builder.newLine();
    return _builder.toString();
  }

  public static String createPropertyExistenceConstraint(final String string, final Label label, final Property property) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property ");
    String _name = property.getName();
    _builder.append(_name);
    _builder.append(" with dataype ");
    String _geoType = GeoTypeMapper.toGeoType(property.getValue());
    _builder.append(_geoType);
    _builder.append(" and unique values");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public static String createPropertyTypeConstraint(final String string, final Label label, final Property property) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property x with dataype y and unique values (wäre dann quasi ein key constraint)");
    _builder.newLine();
    return _builder.toString();
  }

  public static String deleteKeyConstraint(final String string, final Label label, final EList<Property> list) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property x with dataype y and unique values (wäre dann quasi ein key constraint)");
    _builder.newLine();
    return _builder.toString();
  }

  public static String deleteUniqueConstraint(final String string, final Label label, final EList<Property> list) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property x with dataype y and unique values (wäre dann quasi ein key constraint)");
    _builder.newLine();
    return _builder.toString();
  }

  public static String deletePropertyExistenceConstraint(final String string, final Label label, final Property property) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property ");
    String _name = property.getName();
    _builder.append(_name);
    _builder.append(" with dataype ");
    String _geoType = GeoTypeMapper.toGeoType(property.getValue());
    _builder.append(_geoType);
    _builder.append(" and unique values");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public static String deletePropertyTypeConstraint(final String string, final Label label, final Property property) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mandatory property x with dataype y and unique values (wäre dann quasi ein key constraint)");
    _builder.newLine();
    return _builder.toString();
  }
}

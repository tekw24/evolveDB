package de.thm.evolvedb.graph.xtend;

import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * GeoTemplates
 * - Static Xtend template helpers that return textual GEO specifications (as CharSequence)
 * - Each method corresponds to one GEO operator flavor
 * - Parameters supply all needed data; no global state required
 * 
 * Notes
 * - These are *text* templates (Xtend template expressions) that you can feed into your own GEO parser/executor.
 * - If you prefer emitting Cypher/APOC directly, see the CypherTemplates class below.
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
      String _plus = ("\"" + _replace);
      _xblockexpression = (_plus + "\"");
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
   * Add a node label (entity type)
   */
  public static CharSequence addNodeLabel(final String label) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO AddLabel {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("target: Node");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("label: ");
    String _q = GEOTemplates.q(label);
    _builder.append(_q, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Add a relationship type (edge type)
   */
  public static CharSequence addRelationshipType(final String relType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO AddRelationshipType {");
    _builder.newLine();
    _builder.append("type: ");
    String _q = GEOTemplates.q(relType);
    _builder.append(_q);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Add a property to all nodes of a label
   */
  public static CharSequence addNodeProperty(final String label, final String property, final String type, final String defaultValue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO AddProperty {");
    _builder.newLine();
    _builder.append("target: Node(label=");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("property { name: ");
    String _q_1 = GEOTemplates.q(property);
    _builder.append(_q_1);
    _builder.append(", dtype: ");
    String _q_2 = GEOTemplates.q(type);
    _builder.append(_q_2);
    _builder.append(", default: ");
    String _q_3 = GEOTemplates.q(defaultValue);
    _builder.append(_q_3);
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Add a property to all relationships of a type
   */
  public static CharSequence addRelationshipProperty(final String relType, final String property, final String type, final String defaultValue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO AddProperty {");
    _builder.newLine();
    _builder.append("target: Relationship(type=");
    String _q = GEOTemplates.q(relType);
    _builder.append(_q);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("property { name: ");
    String _q_1 = GEOTemplates.q(property);
    _builder.append(_q_1);
    _builder.append(", dtype: ");
    String _q_2 = GEOTemplates.q(type);
    _builder.append(_q_2);
    _builder.append(", default: ");
    String _q_3 = GEOTemplates.q(defaultValue);
    _builder.append(_q_3);
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Rename a node label
   */
  public static CharSequence renameNodeLabel(final String oldLabel, final String newLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO RenameLabel {");
    _builder.newLine();
    _builder.append("target: Node");
    _builder.newLine();
    _builder.append("from: ");
    String _q = GEOTemplates.q(oldLabel);
    _builder.append(_q);
    _builder.newLineIfNotEmpty();
    _builder.append("to: ");
    String _q_1 = GEOTemplates.q(newLabel);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Rename a relationship type
   */
  public static CharSequence renameRelationshipType(final String oldType, final String newType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO RenameRelationshipType {");
    _builder.newLine();
    _builder.append("from: ");
    String _q = GEOTemplates.q(oldType);
    _builder.append(_q);
    _builder.newLineIfNotEmpty();
    _builder.append("to: ");
    String _q_1 = GEOTemplates.q(newType);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Rename a property on nodes of a given label
   */
  public static CharSequence renameNodeProperty(final String label, final String fromProp, final String toProp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO RenameProperty {");
    _builder.newLine();
    _builder.append("target: Node(label=");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("from: ");
    String _q_1 = GEOTemplates.q(fromProp);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    _builder.append("to: ");
    String _q_2 = GEOTemplates.q(toProp);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Rename a property on relationships of a given type
   */
  public static CharSequence mergeNodes(final String label, final List<String> keyProperties, final String conflictStrategy) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO MergeNodes {");
    _builder.newLine();
    _builder.append("label: ");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.newLineIfNotEmpty();
    _builder.append("keys: [ ");
    {
      boolean _hasElements = false;
      for(final String k : keyProperties) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _q_1 = GEOTemplates.q(k);
        _builder.append(_q_1);
      }
    }
    _builder.append(" ]");
    _builder.newLineIfNotEmpty();
    _builder.append("conflict: ");
    String _q_2 = GEOTemplates.q(conflictStrategy);
    _builder.append(_q_2);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }

  /**
   * Copy a subgraph outward from nodes with a label up to a depth, optionally filter relationship types.
   */
  public static CharSequence copySubgraph(final String rootLabel, final int depth, final Set<String> includeRelTypes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO CopySubgraph {");
    _builder.newLine();
    _builder.append("roots: Node(label=");
    String _q = GEOTemplates.q(rootLabel);
    _builder.append(_q);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("depth: ");
    _builder.append(depth);
    _builder.newLineIfNotEmpty();
    {
      if (((includeRelTypes != null) && (!includeRelTypes.isEmpty()))) {
        _builder.append("includeRels: [ ");
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
        _builder.append(" ]");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Split a node set by a predicate into two labels; predicate is a DSL/Cypher-like expression you decide.
   */
  public static CharSequence splitNode(final String label, final String predicateExpr, final String newLabelTrue, final String newLabelFalse) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO SplitNode {");
    _builder.newLine();
    _builder.append("source: Node(label=");
    String _q = GEOTemplates.q(label);
    _builder.append(_q);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("when: ");
    String _q_1 = GEOTemplates.q(predicateExpr);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    _builder.append("then: Node(label=");
    String _q_2 = GEOTemplates.q(newLabelTrue);
    _builder.append(_q_2);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("else: Node(label=");
    String _q_3 = GEOTemplates.q(newLabelFalse);
    _builder.append(_q_3);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  /**
   * Move a subgraph selected by a path pattern under a new root/label (logical relocation)
   */
  public static CharSequence moveSubgraph(final String startLabel, final String pathPattern, final String newRootLabel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GEO MoveSubgraph {");
    _builder.newLine();
    _builder.append("start: Node(label=");
    String _q = GEOTemplates.q(startLabel);
    _builder.append(_q);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("path: ");
    String _q_1 = GEOTemplates.q(pathPattern);
    _builder.append(_q_1);
    _builder.newLineIfNotEmpty();
    _builder.append("targetRoot: Node(label=");
    String _q_2 = GEOTemplates.q(newRootLabel);
    _builder.append(_q_2);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}

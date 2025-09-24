package de.thm.evolvedb.graph.xtend;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Optional: direct Cypher/APOC emission for the same ops.
 * Useful if your toolchain executes the migration immediately on Neo4j.
 */
@SuppressWarnings("all")
public class CypherTemplates {
  public static String esc(final String s) {
    String _xblockexpression = null;
    {
      if ((s == null)) {
        return "";
      }
      _xblockexpression = s.replace("`", "``");
    }
    return _xblockexpression;
  }

  public static CharSequence addNodeProperty(final String label, final String property, final String defaultValue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Add property with default to existing nodes");
    _builder.newLine();
    _builder.append("MATCH (n:`");
    String _esc = CypherTemplates.esc(label);
    _builder.append(_esc);
    _builder.append("`)");
    _builder.newLineIfNotEmpty();
    _builder.append("WHERE n.`");
    String _esc_1 = CypherTemplates.esc(property);
    _builder.append(_esc_1);
    _builder.append("` IS NULL");
    _builder.newLineIfNotEmpty();
    _builder.append("SET n.`");
    String _esc_2 = CypherTemplates.esc(property);
    _builder.append(_esc_2);
    _builder.append("` = ");
    {
      if ((defaultValue != null)) {
        _builder.append("\'");
        _builder.append(defaultValue);
        _builder.append("\'");
      } else {
        _builder.append("null");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence renameNodeProperty(final String label, final String fromProp, final String toProp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// APOC-based rename");
    _builder.newLine();
    _builder.append("CALL apoc.refactor.rename.nodeProperty(\'");
    String _esc = CypherTemplates.esc(label);
    _builder.append(_esc);
    _builder.append("\',\'");
    String _esc_1 = CypherTemplates.esc(fromProp);
    _builder.append(_esc_1);
    _builder.append("\',\'");
    String _esc_2 = CypherTemplates.esc(toProp);
    _builder.append(_esc_2);
    _builder.append("\',{iterate:true,batchSize:5000});");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence deleteNodeProperty(final String label, final String property) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (n:`");
    String _esc = CypherTemplates.esc(label);
    _builder.append(_esc);
    _builder.append("`)");
    _builder.newLineIfNotEmpty();
    _builder.append("REMOVE n.`");
    String _esc_1 = CypherTemplates.esc(property);
    _builder.append(_esc_1);
    _builder.append("`;");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence addRelationshipProperty(final String relType, final String property, final String defaultValue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH ()-[r:`");
    String _esc = CypherTemplates.esc(relType);
    _builder.append(_esc);
    _builder.append("`]-()");
    _builder.newLineIfNotEmpty();
    _builder.append("WHERE r.`");
    String _esc_1 = CypherTemplates.esc(property);
    _builder.append(_esc_1);
    _builder.append("` IS NULL");
    _builder.newLineIfNotEmpty();
    _builder.append("SET r.`");
    String _esc_2 = CypherTemplates.esc(property);
    _builder.append(_esc_2);
    _builder.append("` = ");
    {
      if ((defaultValue != null)) {
        _builder.append("\'");
        _builder.append(defaultValue);
        _builder.append("\'");
      } else {
        _builder.append("null");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence renameRelationshipType(final String fromType, final String toType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// APOC refactor type");
    _builder.newLine();
    _builder.append("MATCH ()-[r:`");
    String _esc = CypherTemplates.esc(fromType);
    _builder.append(_esc);
    _builder.append("`]-()");
    _builder.newLineIfNotEmpty();
    _builder.append("CALL apoc.refactor.setType(r,\'");
    String _esc_1 = CypherTemplates.esc(toType);
    _builder.append(_esc_1);
    _builder.append("\') YIELD input, output RETURN count(output);");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence transformPropertyToNode(final String sourceLabel, final String property, final String newNodeLabel, final String relType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (n:`");
    String _esc = CypherTemplates.esc(sourceLabel);
    _builder.append(_esc);
    _builder.append("`) WHERE n.`");
    String _esc_1 = CypherTemplates.esc(property);
    _builder.append(_esc_1);
    _builder.append("` IS NOT NULL");
    _builder.newLineIfNotEmpty();
    _builder.append("MERGE (m:`");
    String _esc_2 = CypherTemplates.esc(newNodeLabel);
    _builder.append(_esc_2);
    _builder.append("` { name: n.`");
    String _esc_3 = CypherTemplates.esc(property);
    _builder.append(_esc_3);
    _builder.append("` })");
    _builder.newLineIfNotEmpty();
    _builder.append("MERGE (n)-[:`");
    String _esc_4 = CypherTemplates.esc(relType);
    _builder.append(_esc_4);
    _builder.append("`]->(m);");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public static CharSequence mergeNodesByKeys(final String label, final List<String> keys) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// APOC dedup by composite key");
    _builder.newLine();
    _builder.append("CALL apoc.periodic.iterate(");
    _builder.newLine();
    _builder.append("\'MATCH (n:`");
    String _esc = CypherTemplates.esc(label);
    _builder.append(_esc);
    _builder.append("`) RETURN n\',");
    _builder.newLineIfNotEmpty();
    _builder.append("\'WITH n, ");
    {
      boolean _hasElements = false;
      for(final String k : keys) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("n.`");
        String _esc_1 = CypherTemplates.esc(k);
        _builder.append(_esc_1);
        _builder.append("` AS ");
        String _esc_2 = CypherTemplates.esc(k);
        _builder.append(_esc_2);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("WITH collect(n) AS nodes");
    _builder.newLine();
    _builder.append("CALL apoc.refactor.mergeNodes(nodes,{properties:\"combine\", mergeRels:true}) YIELD node RETURN node\',");
    _builder.newLine();
    _builder.append("{batchSize:1000, parallel:true}");
    _builder.newLine();
    _builder.append(");");
    _builder.newLine();
    return _builder;
  }
}

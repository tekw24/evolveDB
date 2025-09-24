package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.migration.GraphResolvableOperator;
import de.thm.evolvedb.migration.ProcessStatus;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class GraphCreateOperator {
  public static String createLabel(final GraphResolvableOperator smo) {
    ProcessStatus _processStatus = smo.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_NodeLabel_IN_PropertyGraph_(items)"));
      };
      SemanticChangeSet addNodeLabel = IterableExtensions.<SemanticChangeSet>findFirst(smo.getSemanticChangeSets(), _function);
      final Function1<SemanticChangeSet, Boolean> _function_1 = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_Property_IN_LABEL_(properties)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(smo.getSemanticChangeSets(), _function_1));
      if ((addNodeLabel != null)) {
        return GraphCreateOperator.createNodeLabel(addNodeLabel, addProperties);
      } else {
        final Function1<SemanticChangeSet, Boolean> _function_2 = (SemanticChangeSet it) -> {
          return Boolean.valueOf(it.getEditRName().equals("CREATE_EdgeLabel_IN_PropertyGraph_(items)"));
        };
        addNodeLabel = IterableExtensions.<SemanticChangeSet>findFirst(smo.getSemanticChangeSets(), _function_2);
        if ((addNodeLabel != null)) {
          return GraphCreateOperator.createEdgeLabel(addNodeLabel, addProperties);
        }
      }
    }
    return "";
  }

  /**
   * Creates the GEO for a new Node Label with Properties
   */
  public static String createNodeLabel(final SemanticChangeSet addNodeLabel, final List<SemanticChangeSet> addProperties) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    final Function1<Change, AddObject> _function_1 = (Change it) -> {
      return ((AddObject) it);
    };
    List<AddObject> addObjects = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(addNodeLabel.getChanges(), _function), _function_1));
    List<AddObject> properties = CollectionLiterals.<AddObject>newArrayList();
    NodeLabel nodelabel = null;
    for (final AddObject a : addObjects) {
      EObject _obj = a.getObj();
      if ((_obj instanceof NodeLabel)) {
        EObject _obj_1 = a.getObj();
        nodelabel = ((NodeLabel) _obj_1);
      }
    }
    for (final SemanticChangeSet scs : addProperties) {
      final Function1<Change, Boolean> _function_2 = (Change it) -> {
        return Boolean.valueOf((it instanceof AddObject));
      };
      final Function1<Change, AddObject> _function_3 = (Change it) -> {
        return ((AddObject) it);
      };
      List<AddObject> _list = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_2), _function_3));
      for (final AddObject ad : _list) {
        EObject _obj_2 = ad.getObj();
        if ((_obj_2 instanceof Property)) {
          properties.add(ad);
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    if ((nodelabel != null)) {
      String _content = content;
      CharSequence _addNodeLabel = GEOTemplates.addNodeLabel(nodelabel.getName());
      content = (_content + _addNodeLabel);
      for (final AddObject a_1 : properties) {
        {
          EObject _obj_3 = a_1.getObj();
          Property property = ((Property) _obj_3);
          String _content_1 = content;
          CharSequence _addNodeProperty = GEOTemplates.addNodeProperty(nodelabel.getName(), property.getName(), GeoTypeMapper.toGeoType(property.getValue()), 
            "");
          content = (_content_1 + _addNodeProperty);
        }
      }
      return content;
    }
    return "";
  }

  /**
   * Creates the GEO for a new Edge Label with Properties
   */
  public static String createEdgeLabel(final SemanticChangeSet addEdgeLabel, final List<SemanticChangeSet> addProperties) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    final Function1<Change, AddObject> _function_1 = (Change it) -> {
      return ((AddObject) it);
    };
    List<AddObject> addObjects = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(addEdgeLabel.getChanges(), _function), _function_1));
    List<AddObject> properties = CollectionLiterals.<AddObject>newArrayList();
    EdgeLabel edgelabel = null;
    for (final AddObject a : addObjects) {
      EObject _obj = a.getObj();
      if ((_obj instanceof EdgeLabel)) {
        EObject _obj_1 = a.getObj();
        edgelabel = ((EdgeLabel) _obj_1);
      }
    }
    for (final SemanticChangeSet scs : addProperties) {
      final Function1<Change, Boolean> _function_2 = (Change it) -> {
        return Boolean.valueOf((it instanceof AddObject));
      };
      final Function1<Change, AddObject> _function_3 = (Change it) -> {
        return ((AddObject) it);
      };
      List<AddObject> _list = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_2), _function_3));
      for (final AddObject ad : _list) {
        EObject _obj_2 = ad.getObj();
        if ((_obj_2 instanceof Property)) {
          properties.add(ad);
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    if ((edgelabel != null)) {
      String _content = content;
      CharSequence _addRelationshipType = GEOTemplates.addRelationshipType(edgelabel.getName());
      content = (_content + _addRelationshipType);
      for (final AddObject a_1 : properties) {
        {
          EObject _obj_3 = a_1.getObj();
          Property property = ((Property) _obj_3);
          String _content_1 = content;
          CharSequence _addRelationshipProperty = GEOTemplates.addRelationshipProperty(edgelabel.getName(), property.getName(), 
            GeoTypeMapper.toGeoType(property.getValue()), "");
          content = (_content_1 + _addRelationshipProperty);
        }
      }
      return content;
    }
    return "";
  }
}

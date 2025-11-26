package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.Label;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.migration.GraphPartiallyResolvableOperator;
import de.thm.evolvedb.migration.ProcessStatus;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class GraphDeleteOperator {
  public static String deleteEdgeType(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("DELETE_EdgeType_IN_PropertyGraph_(items)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<RemoveObject> properties = CollectionLiterals.<RemoveObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        final Function1<Change, RemoveObject> _function_2 = (Change it) -> {
          return ((RemoveObject) it);
        };
        List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final RemoveObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final RemoveObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          EdgeType edgeType = ((EdgeType) _obj_1);
          String _content = content;
          CharSequence _deleteRelationship = GEOTemplates.deleteRelationship(edgeType.getName(), edgeType.getSrc().getName(), edgeType.getTgt().getName());
          content = (_content + _deleteRelationship);
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String deleteLabel(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf((it.getEditRName().equals("DELETE_EdgeLabel_IN_PropertyGraph_(items)") || it.getEditRName().equals("DELETE_NodeLabel_IN_PropertyGraph_(items)")));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<RemoveObject> properties = CollectionLiterals.<RemoveObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        final Function1<Change, RemoveObject> _function_2 = (Change it) -> {
          return ((RemoveObject) it);
        };
        List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final RemoveObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final RemoveObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          Label label = ((Label) _obj_1);
          boolean _matched = false;
          if (label instanceof EdgeLabel) {
            _matched=true;
            String _string = ((EdgeLabel)label).toString();
            return ("not implemented: " + _string);
          }
          if (!_matched) {
            if (label instanceof NodeLabel) {
              _matched=true;
              String _string = ((NodeLabel)label).toString();
              return ("not implemented: " + _string);
            }
          }
          String _string = label.toString();
          return ("not implemented: " + _string);
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String deleteNodeType(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("DELETE_NodeType_IN_PropertyGraph_(items)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<RemoveObject> properties = CollectionLiterals.<RemoveObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        final Function1<Change, RemoveObject> _function_2 = (Change it) -> {
          return ((RemoveObject) it);
        };
        List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final RemoveObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final RemoveObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          NodeType nodeType = ((NodeType) _obj_1);
          String _content = content;
          CharSequence _deleteNode = GEOTemplates.deleteNode(nodeType.getName(), false);
          content = (_content + _deleteNode);
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String deletePropertyLabel(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("DELETE_Property_IN_LABEL_(properties)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<RemoveObject> properties = CollectionLiterals.<RemoveObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        final Function1<Change, RemoveObject> _function_2 = (Change it) -> {
          return ((RemoveObject) it);
        };
        List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final RemoveObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final RemoveObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          Property property = ((Property) _obj_1);
          String _content = content;
          CharSequence _deleteNodeProperty = GEOTemplates.deleteNodeProperty(property.getName(), GEOHelper.getPropertyParent(property));
          content = (_content + _deleteNodeProperty);
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String deletePropertyEdgeType(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("DELETE_Property_IN_LABEL_(properties)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<RemoveObject> properties = CollectionLiterals.<RemoveObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        final Function1<Change, RemoveObject> _function_2 = (Change it) -> {
          return ((RemoveObject) it);
        };
        List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final RemoveObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final RemoveObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          Property property = ((Property) _obj_1);
          String _content = content;
          CharSequence _deletePropertyFromNodeOnPath = GEOTemplates.deletePropertyFromNodeOnPath(property.getName(), GEOHelper.getPropertyParent(property), 
            GeoTypeMapper.toGeoType(property.getValue()), "");
          content = (_content + _deletePropertyFromNodeOnPath);
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String deletePropertyNodeType(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("DELETE_Property_IN_LABEL_(properties)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<RemoveObject> properties = CollectionLiterals.<RemoveObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        final Function1<Change, RemoveObject> _function_2 = (Change it) -> {
          return ((RemoveObject) it);
        };
        List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final RemoveObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final RemoveObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          Property property = ((Property) _obj_1);
          String _content = content;
          CharSequence _deleteNodeProperty = GEOTemplates.deleteNodeProperty(property.getName(), GEOHelper.getPropertyParent(property));
          content = (_content + _deleteNodeProperty);
        }
      }
      return content;
    } else {
      return "";
    }
  }
}

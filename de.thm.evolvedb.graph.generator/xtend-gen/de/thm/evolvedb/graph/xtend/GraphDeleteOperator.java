package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.Constraint;
import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.KeyConstraint;
import de.thm.evolvedb.graph.Label;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyExistenceConstraint;
import de.thm.evolvedb.graph.PropertyTypeConstraint;
import de.thm.evolvedb.graph.UniqueConstraint;
import de.thm.evolvedb.migration.GraphPartiallyResolvableOperator;
import de.thm.evolvedb.migration.ProcessStatus;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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

  public static String deleteConstraintInLabel(final GraphPartiallyResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      EList<SemanticChangeSet> _semanticChangeSets = operator.getSemanticChangeSets();
      for (final SemanticChangeSet scs : _semanticChangeSets) {
        {
          List<RemoveObject> removeConstraints = CollectionLiterals.<RemoveObject>newArrayList();
          final Function1<Change, Boolean> _function = (Change it) -> {
            return Boolean.valueOf((it instanceof RemoveObject));
          };
          final Function1<Change, RemoveObject> _function_1 = (Change it) -> {
            return ((RemoveObject) it);
          };
          List<RemoveObject> _list = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function), _function_1));
          for (final RemoveObject ad : _list) {
            EObject _obj = ad.getObj();
            if ((_obj instanceof Constraint)) {
              removeConstraints.add(ad);
            }
          }
          for (final RemoveObject a : removeConstraints) {
            EObject _obj_1 = a.getObj();
            if ((_obj_1 instanceof KeyConstraint)) {
              EObject _obj_2 = a.getObj();
              KeyConstraint constraint = ((KeyConstraint) _obj_2);
              String _content = content;
              String _deleteKeyConstraint = GEOTemplates.deleteKeyConstraint(constraint.getName(), constraint.getLabel(), constraint.getProperties());
              content = (_content + _deleteKeyConstraint);
            } else {
              EObject _obj_3 = a.getObj();
              if ((_obj_3 instanceof UniqueConstraint)) {
                EObject _obj_4 = a.getObj();
                UniqueConstraint constraint_1 = ((UniqueConstraint) _obj_4);
                String _content_1 = content;
                String _deleteUniqueConstraint = GEOTemplates.deleteUniqueConstraint(constraint_1.getName(), constraint_1.getLabel(), constraint_1.getProperties());
                content = (_content_1 + _deleteUniqueConstraint);
              } else {
                EObject _obj_5 = a.getObj();
                if ((_obj_5 instanceof PropertyExistenceConstraint)) {
                  EObject _obj_6 = a.getObj();
                  PropertyExistenceConstraint constraint_2 = ((PropertyExistenceConstraint) _obj_6);
                  String _content_2 = content;
                  String _deletePropertyExistenceConstraint = GEOTemplates.deletePropertyExistenceConstraint(constraint_2.getName(), constraint_2.getLabel(), constraint_2.getProperties());
                  content = (_content_2 + _deletePropertyExistenceConstraint);
                } else {
                  EObject _obj_7 = a.getObj();
                  if ((_obj_7 instanceof PropertyTypeConstraint)) {
                    EObject _obj_8 = a.getObj();
                    PropertyTypeConstraint constraint_3 = ((PropertyTypeConstraint) _obj_8);
                    String _content_3 = content;
                    String _deletePropertyTypeConstraint = GEOTemplates.deletePropertyTypeConstraint(constraint_3.getName(), constraint_3.getLabel(), constraint_3.getProperties());
                    content = (_content_3 + _deletePropertyTypeConstraint);
                  }
                }
              }
            }
          }
        }
      }
      return content;
    }
    return null;
  }
}

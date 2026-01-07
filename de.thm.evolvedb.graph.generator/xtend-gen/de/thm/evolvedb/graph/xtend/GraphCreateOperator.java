package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.Constraint;
import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.KeyConstraint;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyExistenceConstraint;
import de.thm.evolvedb.graph.PropertyTypeConstraint;
import de.thm.evolvedb.graph.UniqueConstraint;
import de.thm.evolvedb.migration.GraphResolvableOperator;
import de.thm.evolvedb.migration.ProcessStatus;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
      EList<Property> _properties = nodelabel.getProperties();
      for (final Property property : _properties) {
        String _content_1 = content;
        CharSequence _addPropertyToNode = GEOTemplates.addPropertyToNode(property.getName(), nodelabel.getName(), 
          GeoTypeMapper.toGeoType(property.getValue()));
        content = (_content_1 + _addPropertyToNode);
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

  /**
   * Creates the GEO for a new Edge Label with Properties
   */
  public static String createEdgeType(final GraphResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
    } else {
      return "";
    }
    final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
      return Boolean.valueOf(it.getEditRName().equals("CREATE_EdgeType_IN_PropertyGraph_(items)"));
    };
    SemanticChangeSet addEdgeType = IterableExtensions.<SemanticChangeSet>findFirst(operator.getSemanticChangeSets(), _function);
    final Function1<Change, Boolean> _function_1 = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    final Function1<Change, AddObject> _function_2 = (Change it) -> {
      return ((AddObject) it);
    };
    List<AddObject> addObjects = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(addEdgeType.getChanges(), _function_1), _function_2));
    EdgeType edgetype = null;
    for (final AddObject a : addObjects) {
      EObject _obj = a.getObj();
      if ((_obj instanceof EdgeType)) {
        EObject _obj_1 = a.getObj();
        edgetype = ((EdgeType) _obj_1);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    List<String> labelNames = CollectionLiterals.<String>newArrayList();
    if ((edgetype != null)) {
      EList<EdgeLabel> _labels = edgetype.getLabels();
      for (final EdgeLabel edgeLabel : _labels) {
        labelNames.add(edgeLabel.getName());
      }
      String _content = content;
      CharSequence _addEdgeType = GEOTemplates.addEdgeType(edgetype.getName(), labelNames, edgetype.getSrc().getName(), edgetype.getTgt().getName());
      content = (_content + _addEdgeType);
      return content;
    }
    return "";
  }

  public static String createNodeType(final GraphResolvableOperator operator) {
    Object _xifexpression = null;
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      _xifexpression = null;
    } else {
      return "";
    }
    return ((String)_xifexpression);
  }

  public static String createProperty(final GraphResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_Property_IN_LABEL_(properties)"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<AddObject> properties = CollectionLiterals.<AddObject>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddObject));
        };
        final Function1<Change, AddObject> _function_2 = (Change it) -> {
          return ((AddObject) it);
        };
        List<AddObject> _list = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final AddObject ad : _list) {
          EObject _obj = ad.getObj();
          if ((_obj instanceof Property)) {
            properties.add(ad);
          }
        }
      }
      for (final AddObject a : properties) {
        {
          EObject _obj_1 = a.getObj();
          Property property = ((Property) _obj_1);
          String _content = content;
          CharSequence _addPropertyToNodeOnPath = GEOTemplates.addPropertyToNodeOnPath(property.getName(), GEOHelper.getPropertyParent(property), 
            GeoTypeMapper.toGeoType(property.getValue()), "");
          content = (_content + _addPropertyToNodeOnPath);
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String createConstraintInLabel(final GraphResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      EList<SemanticChangeSet> _semanticChangeSets = operator.getSemanticChangeSets();
      for (final SemanticChangeSet scs : _semanticChangeSets) {
        {
          List<AddObject> newConstraints = CollectionLiterals.<AddObject>newArrayList();
          final Function1<Change, Boolean> _function = (Change it) -> {
            return Boolean.valueOf((it instanceof AddObject));
          };
          final Function1<Change, AddObject> _function_1 = (Change it) -> {
            return ((AddObject) it);
          };
          List<AddObject> _list = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(scs.getChanges(), _function), _function_1));
          for (final AddObject ad : _list) {
            EObject _obj = ad.getObj();
            if ((_obj instanceof Constraint)) {
              newConstraints.add(ad);
            }
          }
          for (final AddObject a : newConstraints) {
            EObject _obj_1 = a.getObj();
            if ((_obj_1 instanceof KeyConstraint)) {
              EObject _obj_2 = a.getObj();
              KeyConstraint constraint = ((KeyConstraint) _obj_2);
              String _content = content;
              String _createKeyConstraint = GEOTemplates.createKeyConstraint(constraint.getName(), constraint.getLabel(), constraint.getProperties());
              content = (_content + _createKeyConstraint);
            } else {
              EObject _obj_3 = a.getObj();
              if ((_obj_3 instanceof UniqueConstraint)) {
                EObject _obj_4 = a.getObj();
                UniqueConstraint constraint_1 = ((UniqueConstraint) _obj_4);
                String _content_1 = content;
                String _createUniqueConstraint = GEOTemplates.createUniqueConstraint(constraint_1.getName(), constraint_1.getLabel(), constraint_1.getProperties());
                content = (_content_1 + _createUniqueConstraint);
              } else {
                EObject _obj_5 = a.getObj();
                if ((_obj_5 instanceof PropertyExistenceConstraint)) {
                  EObject _obj_6 = a.getObj();
                  PropertyExistenceConstraint constraint_2 = ((PropertyExistenceConstraint) _obj_6);
                  String _content_2 = content;
                  String _createPropertyExistenceConstraint = GEOTemplates.createPropertyExistenceConstraint(constraint_2.getName(), constraint_2.getLabel(), constraint_2.getProperties());
                  content = (_content_2 + _createPropertyExistenceConstraint);
                } else {
                  EObject _obj_7 = a.getObj();
                  if ((_obj_7 instanceof PropertyTypeConstraint)) {
                    EObject _obj_8 = a.getObj();
                    PropertyTypeConstraint constraint_3 = ((PropertyTypeConstraint) _obj_8);
                    String _content_3 = content;
                    String _createPropertyTypeConstraint = GEOTemplates.createPropertyTypeConstraint(constraint_3.getName(), constraint_3.getLabel(), constraint_3.getProperties());
                    content = (_content_3 + _createPropertyTypeConstraint);
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

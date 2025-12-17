package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.GraphItem;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyValueType;
import de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperator;
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
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class GraphChangeOperator {
  public static String changeName(final GraphResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf((it.getEditRName().equals("SET_ATTRIBUTE_Property_Name") || it.getEditRName().equals("SET_ATTRIBUTE_Label_Name")));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      List<AttributeValueChange> properties = CollectionLiterals.<AttributeValueChange>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      for (final SemanticChangeSet scs : addProperties) {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AttributeValueChange));
        };
        final Function1<Change, AttributeValueChange> _function_2 = (Change it) -> {
          return ((AttributeValueChange) it);
        };
        List<AttributeValueChange> _list = IterableExtensions.<AttributeValueChange>toList(IterableExtensions.<Change, AttributeValueChange>map(IterableExtensions.<Change>filter(scs.getChanges(), _function_1), _function_2));
        for (final AttributeValueChange ad : _list) {
          properties.add(ad);
        }
      }
      for (final AttributeValueChange a : properties) {
        EObject _objA = a.getObjA();
        boolean _matched = false;
        if (_objA instanceof EdgeLabel) {
          _matched=true;
          EObject _objA_1 = a.getObjA();
          EdgeLabel edgeLabelA = ((EdgeLabel) _objA_1);
          EObject _objB = a.getObjB();
          EdgeLabel edgeLabelB = ((EdgeLabel) _objB);
          String _content = content;
          CharSequence _renameRelationshipType = GEOTemplates.renameRelationshipType(edgeLabelA.getName(), edgeLabelB.getName());
          content = (_content + _renameRelationshipType);
        }
        if (!_matched) {
          if (_objA instanceof NodeLabel) {
            _matched=true;
            EObject _objA_1 = a.getObjA();
            NodeLabel nodeLabelA = ((NodeLabel) _objA_1);
            EObject _objB = a.getObjB();
            NodeLabel nodeLabelB = ((NodeLabel) _objB);
            String _content = content;
            CharSequence _renameNodeLabel = GEOTemplates.renameNodeLabel(nodeLabelA.getName(), nodeLabelB.getName());
            content = (_content + _renameNodeLabel);
          }
        }
        if (!_matched) {
          if (_objA instanceof Property) {
            _matched=true;
            EObject _objA_1 = a.getObjA();
            Property propertyA = ((Property) _objA_1);
            EObject _objB = a.getObjB();
            Property propertyB = ((Property) _objB);
            String _content = content;
            CharSequence _renameSimpleNodeProperty = GEOTemplates.renameSimpleNodeProperty(GEOHelper.getPropertyParent(propertyA), 
              propertyA.getName(), propertyB.getName());
            content = (_content + _renameSimpleNodeProperty);
          }
        }
        if (!_matched) {
          return "Error";
        }
      }
      return content;
    } else {
      return "";
    }
  }

  public static String addLabelToNodeType(final GraphResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("ADD_NodeLabel_(nodes)_TGT_NodeType"));
      };
      List<SemanticChangeSet> addProperties = IterableExtensions.<SemanticChangeSet>toList(IterableExtensions.<SemanticChangeSet>filter(operator.getSemanticChangeSets(), _function));
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      NodeType nodeType = null;
      NodeLabel nodeLabel = null;
      for (final SemanticChangeSet scs : addProperties) {
        {
          final Function1<Change, Boolean> _function_1 = (Change it) -> {
            return Boolean.valueOf((it instanceof AddReference));
          };
          Change _findFirst = IterableExtensions.<Change>findFirst(scs.getChanges(), _function_1);
          AddReference ad = ((AddReference) _findFirst);
          if (((ad.getSrc() instanceof NodeType) && (ad.getTgt() instanceof NodeLabel))) {
            EObject _src = ad.getSrc();
            nodeType = ((NodeType) _src);
            EObject _tgt = ad.getTgt();
            nodeLabel = ((NodeLabel) _tgt);
          } else {
            if (((ad.getSrc() instanceof NodeLabel) && (ad.getTgt() instanceof NodeType))) {
              EObject _tgt_1 = ad.getTgt();
              nodeType = ((NodeType) _tgt_1);
              EObject _src_1 = ad.getSrc();
              nodeLabel = ((NodeLabel) _src_1);
            }
          }
        }
      }
      List<String> labelNames = CollectionLiterals.<String>newArrayList();
      EList<NodeLabel> _label = nodeType.getLabel();
      for (final NodeLabel label : _label) {
        labelNames.add(label.getName());
      }
      String _content = content;
      CharSequence _addNodeLabelToNodeType = GEOTemplates.addNodeLabelToNodeType(labelNames, nodeLabel.getName());
      content = (_content + _addNodeLabelToNodeType);
      return content;
    } else {
      return "";
    }
  }

  public static String moveCombined(final GraphNotAutomaticallyResolvableOperator operator) {
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

  public static String moveEdgeType(final GraphNotAutomaticallyResolvableOperator operator) {
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

  public static String moveLabel(final GraphNotAutomaticallyResolvableOperator operator) {
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

  public static String moveNodeType(final GraphNotAutomaticallyResolvableOperator operator) {
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

  public static String moveProperty(final GraphNotAutomaticallyResolvableOperator operator) {
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

  public static String changeType(final GraphResolvableOperator operator) {
    ProcessStatus _processStatus = operator.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf((((((it.getEditRName().equals("CHANGE_NumericType") || it.getEditRName().equals("CHANGE_StringType")) || 
          it.getEditRName().equals("CHANGE_PropertyValueType")) || it.getEditRName().equals("CHANGE_TemporalType")) || 
          it.getEditRName().equals("CREATE_BinaryTypes")) || it.getEditRName().equals("CREATE_BooleanType")));
      };
      SemanticChangeSet changeType = IterableExtensions.<SemanticChangeSet>findFirst(operator.getSemanticChangeSets(), _function);
      final Function1<Change, Boolean> _function_1 = (Change it) -> {
        return Boolean.valueOf((it instanceof AddObject));
      };
      Change _findFirst = IterableExtensions.<Change>findFirst(changeType.getChanges(), _function_1);
      AddObject addObject = ((AddObject) _findFirst);
      final Function1<Change, Boolean> _function_2 = (Change it) -> {
        return Boolean.valueOf((it instanceof RemoveObject));
      };
      Change _findFirst_1 = IterableExtensions.<Change>findFirst(changeType.getChanges(), _function_2);
      RemoveObject removeObject = ((RemoveObject) _findFirst_1);
      EObject _obj = addObject.getObj();
      PropertyValueType newtype = ((PropertyValueType) _obj);
      EObject _obj_1 = removeObject.getObj();
      PropertyValueType oldtype = ((PropertyValueType) _obj_1);
      Property property = oldtype.getProperty();
      String labelName = "";
      GraphItem _containerElement = property.getContainerElement();
      boolean _matched = false;
      if (_containerElement instanceof EdgeLabel) {
        _matched=true;
        GraphItem _containerElement_1 = property.getContainerElement();
        EdgeLabel a = ((EdgeLabel) _containerElement_1);
        String _name = a.getName();
        String _plus = ("edgelabel " + _name);
        labelName = _plus;
      }
      if (!_matched) {
        if (_containerElement instanceof NodeLabel) {
          _matched=true;
          GraphItem _containerElement_1 = property.getContainerElement();
          NodeLabel a = ((NodeLabel) _containerElement_1);
          String _name = a.getName();
          String _plus = ("nodelabel " + _name);
          labelName = _plus;
        }
      }
      if (!_matched) {
        if (_containerElement instanceof EdgeType) {
          _matched=true;
          GraphItem _containerElement_1 = property.getContainerElement();
          Property a = ((Property) _containerElement_1);
          String _name = a.getName();
          String _plus = ("edgetype " + _name);
          labelName = _plus;
        }
      }
      if (!_matched) {
        if (_containerElement instanceof NodeType) {
          _matched=true;
          GraphItem _containerElement_1 = property.getContainerElement();
          NodeType a = ((NodeType) _containerElement_1);
          String _name = a.getName();
          String _plus = ("nodetype " + _name);
          labelName = _plus;
        }
      }
      if (!_matched) {
        labelName = "No Value";
      }
      StringConcatenation _builder = new StringConcatenation();
      String content = _builder.toString();
      String _content = content;
      CharSequence _changeType = GEOTemplates.changeType(property.getName(), GeoTypeMapper.toGeoType(oldtype), 
        GeoTypeMapper.toGeoType(newtype), labelName);
      content = (_content + _changeType);
      return content;
    } else {
      return "";
    }
  }
}

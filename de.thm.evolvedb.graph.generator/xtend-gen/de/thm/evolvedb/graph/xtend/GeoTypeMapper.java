package de.thm.evolvedb.graph.xtend;

import java.util.Objects;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

@SuppressWarnings("all")
public class GeoTypeMapper {
  /**
   * Public entry: map a PropertyValueType EObject -> GEO type string (e.g., "INT", "VARCHAR(255)?", "LIST<STRING>")
   */
  public static String toGeoType(final EObject vt) {
    if ((vt == null)) {
      return "ANY";
    }
    final Boolean nullable = GeoTypeMapper.b(vt, "nullable");
    String _switchResult = null;
    String _name = vt.eClass().getName();
    if (_name != null) {
      switch (_name) {
        case "NumericType":
          _switchResult = GeoTypeMapper.numericToGeo(vt);
          break;
        case "StringType":
          _switchResult = GeoTypeMapper.stringToGeo(vt);
          break;
        case "BooleanType":
          _switchResult = "BOOLEAN";
          break;
        case "TemporalTypes":
          _switchResult = GeoTypeMapper.temporalToGeo(vt);
          break;
        case "BinaryTypes":
          _switchResult = GeoTypeMapper.binaryToGeo(vt);
          break;
        case "ListType":
          _switchResult = GeoTypeMapper.listToGeo(vt);
          break;
        case "UnionType":
          _switchResult = GeoTypeMapper.unionToGeo(vt);
          break;
        default:
          _switchResult = vt.eClass().getName();
          break;
      }
    } else {
      _switchResult = vt.eClass().getName();
    }
    final String base = _switchResult;
    String _xifexpression = null;
    if ((nullable).booleanValue()) {
      _xifexpression = "?";
    } else {
      _xifexpression = "";
    }
    return (base + _xifexpression);
  }

  private static String numericToGeo(final EObject vt) {
    String _xblockexpression = null;
    {
      final String kind = GeoTypeMapper.s(vt, "type");
      final Integer ip = GeoTypeMapper.iOrNull(vt, "integralPart");
      final Integer fp = GeoTypeMapper.iOrNull(vt, "fractionalPart");
      String _switchResult = null;
      if (kind != null) {
        switch (kind) {
          case "DECIMAL":
            String _xifexpression = null;
            if ((((ip != null) && (fp != null)) && ((ip).intValue() > 0))) {
              _xifexpression = (((("DECIMAL(" + ip) + ",") + fp) + ")");
            } else {
              _xifexpression = "DECIMAL";
            }
            _switchResult = _xifexpression;
            break;
          case "FLOAT128":
            _switchResult = "FLOAT128";
            break;
          case "DOUBLE":
            _switchResult = "DOUBLE";
            break;
          case "FLOAT":
            _switchResult = "FLOAT";
            break;
          case "UINT":
            _switchResult = "UINT";
            break;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private static String stringToGeo(final EObject vt) {
    final String kind = GeoTypeMapper.s(vt, "type");
    final Integer maxL = GeoTypeMapper.iOrNull(vt, "maxLength");
    boolean _equals = Objects.equals("VARCHAR", kind);
    if (_equals) {
      if (((maxL != null) && ((maxL).intValue() > 0))) {
        return (("VARCHAR(" + maxL) + ")");
      } else {
        return "VARCHAR";
      }
    }
    return "STRING";
  }

  private static String binaryToGeo(final EObject vt) {
    String _xblockexpression = null;
    {
      final String kind = GeoTypeMapper.s(vt, "type");
      final Integer maxL = GeoTypeMapper.iOrNull(vt, "maxLength");
      String _switchResult = null;
      if (kind != null) {
        switch (kind) {
          case "VARBINARY":
            String _xifexpression = null;
            if (((maxL != null) && ((maxL).intValue() > 0))) {
              _xifexpression = (("VARBINARY(" + maxL) + ")");
            } else {
              _xifexpression = "VARBINARY";
            }
            _switchResult = _xifexpression;
            break;
          case "BYTES":
            String _xifexpression_1 = null;
            if (((maxL != null) && ((maxL).intValue() > 0))) {
              _xifexpression_1 = (("BYTES(" + maxL) + ")");
            } else {
              _xifexpression_1 = "BYTES";
            }
            _switchResult = _xifexpression_1;
            break;
          default:
            String _elvis = null;
            if (kind != null) {
              _elvis = kind;
            } else {
              _elvis = "BINARY";
            }
            _switchResult = _elvis;
            break;
        }
      } else {
        String _elvis = null;
        if (kind != null) {
          _elvis = kind;
        } else {
          _elvis = "BINARY";
        }
        _switchResult = _elvis;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private static String temporalToGeo(final EObject vt) {
    String _xblockexpression = null;
    {
      final String kind = GeoTypeMapper.s(vt, "type");
      String _switchResult = null;
      if (kind != null) {
        switch (kind) {
          case "ZONED_DATETIME":
            _switchResult = "DATETIME";
            break;
          case "LOCAL_DATETIME":
            _switchResult = "LOCAL_DATETIME";
            break;
          case "DATE":
            _switchResult = "DATE";
            break;
          case "ZONED_TIME":
            _switchResult = "TIME";
            break;
          case "LOCAL_TIME":
            _switchResult = "LOCAL_TIME";
            break;
          case "YEAR":
            _switchResult = "TEMPORAL<YEAR>";
            break;
          case "MONTH":
            _switchResult = "TEMPORAL<MONTH>";
            break;
          case "DAY":
            _switchResult = "TEMPORAL<DAY>";
            break;
          case "MINUTES":
            _switchResult = "TEMPORAL<MINUTES>";
            break;
          case "SUBSECONDS":
            _switchResult = "TEMPORAL<SUBSECONDS>";
            break;
          default:
            String _elvis = null;
            if (kind != null) {
              _elvis = kind;
            } else {
              _elvis = "TEMPORAL";
            }
            _switchResult = _elvis;
            break;
        }
      } else {
        String _elvis = null;
        if (kind != null) {
          _elvis = kind;
        } else {
          _elvis = "TEMPORAL";
        }
        _switchResult = _elvis;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private static String listToGeo(final EObject vt) {
    final EObject inner = GeoTypeMapper.ref(vt, "type");
    String _xifexpression = null;
    if ((inner != null)) {
      _xifexpression = GeoTypeMapper.toGeoType(inner);
    } else {
      _xifexpression = "ANY";
    }
    final String innerStr = _xifexpression;
    final Integer lb = GeoTypeMapper.iOrNull(vt, "lowerBound");
    final Integer ub = GeoTypeMapper.iOrNull(vt, "upperBound");
    String res = (("LIST<" + innerStr) + ">");
    if ((((lb != null) && (ub != null)) && (((lb).intValue() >= 0) || ((ub).intValue() >= 0)))) {
      Integer _xifexpression_1 = null;
      if ((lb != null)) {
        _xifexpression_1 = lb;
      } else {
        _xifexpression_1 = Integer.valueOf(0);
      }
      String _plus = ((res + "[") + _xifexpression_1);
      String _plus_1 = (_plus + "..");
      Integer _xifexpression_2 = null;
      if ((ub != null)) {
        _xifexpression_2 = ub;
      } else {
        _xifexpression_2 = Integer.valueOf((-1));
      }
      String _plus_2 = (_plus_1 + _xifexpression_2);
      String _plus_3 = (_plus_2 + "]");
      res = _plus_3;
    }
    return res;
  }

  private static String unionToGeo(final EObject vt) {
    final String kind = GeoTypeMapper.s(vt, "type");
    if ((Objects.equals("AnyType", kind) || (kind == null))) {
      return "ANY";
    } else {
      return (("UNION<" + kind) + ">");
    }
  }

  private static String s(final EObject o, final String feature) {
    String _xblockexpression = null;
    {
      final EStructuralFeature f = o.eClass().getEStructuralFeature(feature);
      Object _xifexpression = null;
      if ((f != null)) {
        _xifexpression = o.eGet(f);
      } else {
        _xifexpression = null;
      }
      final Object v = _xifexpression;
      String _switchResult = null;
      boolean _matched = false;
      if (v instanceof String) {
        _matched=true;
        _switchResult = ((String)v);
      }
      if (!_matched) {
        if (v instanceof Enumerator) {
          _matched=true;
          _switchResult = ((Enumerator)v).toString();
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private static Boolean b(final EObject o, final String feature) {
    Boolean _xblockexpression = null;
    {
      final EStructuralFeature f = o.eClass().getEStructuralFeature(feature);
      Object _xifexpression = null;
      if ((f != null)) {
        _xifexpression = o.eGet(f);
      } else {
        _xifexpression = null;
      }
      final Object v = _xifexpression;
      Boolean _xifexpression_1 = null;
      if ((v instanceof Boolean)) {
        _xifexpression_1 = ((Boolean) v);
      } else {
        _xifexpression_1 = Boolean.valueOf(false);
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }

  private static Integer iOrNull(final EObject o, final String feature) {
    Integer _xblockexpression = null;
    {
      final EStructuralFeature f = o.eClass().getEStructuralFeature(feature);
      Object _xifexpression = null;
      if ((f != null)) {
        _xifexpression = o.eGet(f);
      } else {
        _xifexpression = null;
      }
      final Object v = _xifexpression;
      Integer _xifexpression_1 = null;
      if ((v instanceof Integer)) {
        _xifexpression_1 = ((Integer) v);
      } else {
        _xifexpression_1 = null;
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }

  private static EObject ref(final EObject o, final String feature) {
    EObject _xblockexpression = null;
    {
      final EStructuralFeature f = o.eClass().getEStructuralFeature(feature);
      if ((f == null)) {
        return null;
      }
      final Object v = o.eGet(f);
      EObject _xifexpression = null;
      if ((v instanceof EObject)) {
        _xifexpression = ((EObject) v);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}

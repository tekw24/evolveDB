package de.thm.evolvedb.graph.xtend;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GEODefaultValueRenderer {
  /**
   * Render a default value literal for a given PropertyValueType.
   * 
   * @param raw  – the default value coming from your model (String, Number, Boolean, java.time.*, List, Map, etc.)
   * @param vt   – the PropertyValueType EObject (same hierarchy as in your ECORE)
   * @return     – String literal suitable for your GEO text (or "null" if none/invalid)
   */
  public static String toGeoDefault(final Object raw, final EObject vt) {
    String _xblockexpression = null;
    {
      if ((raw == null)) {
        return "null";
      }
      if ((vt == null)) {
        return GEODefaultValueRenderer.valueAuto(raw);
      }
      String _switchResult = null;
      String _name = vt.eClass().getName();
      if (_name != null) {
        switch (_name) {
          case "NumericType":
            _switchResult = GEODefaultValueRenderer.numericDefault(raw);
            break;
          case "BooleanType":
            _switchResult = GEODefaultValueRenderer.booleanDefault(raw);
            break;
          case "StringType":
            _switchResult = GEODefaultValueRenderer.stringDefault(raw);
            break;
          case "TemporalTypes":
            _switchResult = GEODefaultValueRenderer.temporalDefault(raw, GEODefaultValueRenderer.s(vt, "type"));
            break;
          case "BinaryTypes":
            _switchResult = GEODefaultValueRenderer.binaryDefault(raw);
            break;
          case "ListType":
            _switchResult = GEODefaultValueRenderer.listDefault(raw, GEODefaultValueRenderer.ref(vt, "type"));
            break;
          case "UnionType":
            _switchResult = GEODefaultValueRenderer.valueAuto(raw);
            break;
          default:
            _switchResult = GEODefaultValueRenderer.valueAuto(raw);
            break;
        }
      } else {
        _switchResult = GEODefaultValueRenderer.valueAuto(raw);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  private static String numericDefault(final Object raw) {
    String _switchResult = null;
    boolean _matched = false;
    if ((raw instanceof Number)) {
      _matched=true;
      _switchResult = raw.toString();
    }
    if (!_matched) {
      if (((raw instanceof String) && 
        ((String) raw).matches("[+-]?\\d+(?:[.][0-9]+)?(?:[eE][+-]?\\d+)?"))) {
        _matched=true;
        _switchResult = ((String) raw);
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }

  private static String booleanDefault(final Object raw) {
    String _switchResult = null;
    boolean _matched = false;
    if ((raw instanceof Boolean)) {
      _matched=true;
      _switchResult = ((Boolean) raw).toString();
    }
    if (!_matched) {
      if (((raw instanceof String) && ((String) raw).toLowerCase().matches("true|false"))) {
        _matched=true;
        _switchResult = ((String) raw).toLowerCase();
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }

  private static String stringDefault(final Object raw) {
    String _xifexpression = null;
    if ((raw instanceof String)) {
      _xifexpression = ((String) raw);
    } else {
      _xifexpression = String.valueOf(raw);
    }
    String _escape = GEODefaultValueRenderer.escape(_xifexpression);
    String _plus = ("\"" + _escape);
    return (_plus + "\"");
  }

  private static String temporalDefault(final Object raw, final String kind) {
    if ((raw instanceof TemporalAccessor)) {
      final String str = ((TemporalAccessor)raw).toString();
      String _escape = GEODefaultValueRenderer.escape(str);
      String _plus = ("\"" + _escape);
      return (_plus + "\"");
    }
    if ((raw instanceof String)) {
      final String s = ((String) raw);
      boolean _switchResult = false;
      if (kind != null) {
        switch (kind) {
          case "DATE":
            _switchResult = s.matches("\\d{4}-\\d{2}-\\d{2}");
            break;
          case "LOCAL_TIME":
            _switchResult = s.matches("\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?");
            break;
          case "ZONED_TIME":
            _switchResult = s.matches("\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?(?:Z|[+-]\\d{2}:\\d{2})");
            break;
          case "LOCAL_DATETIME":
            _switchResult = s.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?");
            break;
          case "ZONED_DATETIME":
            _switchResult = s.matches(
              "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?(?:Z|[+-]\\d{2}:\\d{2})");
            break;
          default:
            int _length = s.length();
            _switchResult = (_length > 0);
            break;
        }
      } else {
        int _length = s.length();
        _switchResult = (_length > 0);
      }
      final boolean ok = _switchResult;
      String _xifexpression = null;
      if (ok) {
        String _escape_1 = GEODefaultValueRenderer.escape(s);
        String _plus_1 = ("\"" + _escape_1);
        _xifexpression = (_plus_1 + "\"");
      } else {
        _xifexpression = "null";
      }
      return _xifexpression;
    }
    String _escape_2 = GEODefaultValueRenderer.escape(String.valueOf(raw));
    String _plus_2 = ("\"" + _escape_2);
    return (_plus_2 + "\"");
  }

  private static String binaryDefault(final Object raw) {
    String _switchResult = null;
    boolean _matched = false;
    if ((raw instanceof byte[])) {
      _matched=true;
      String _encodeToString = Base64.getEncoder().encodeToString(((byte[]) raw));
      String _plus = ("\"" + _encodeToString);
      _switchResult = (_plus + "\"");
    }
    if (!_matched) {
      if (((raw instanceof String) && ((String) raw).startsWith("0x"))) {
        _matched=true;
        _switchResult = ((String) raw);
      }
    }
    if (!_matched) {
      if ((raw instanceof String)) {
        _matched=true;
        String _escape = GEODefaultValueRenderer.escape(((String) raw));
        String _plus_1 = ("\"" + _escape);
        _switchResult = (_plus_1 + "\"");
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }

  private static String listDefault(final Object raw, final EObject innerVt) {
    final Iterable<?> iter = GEODefaultValueRenderer.asIterable(raw);
    if ((iter == null)) {
      return "[]";
    }
    final ArrayList<String> rendered = CollectionLiterals.<String>newArrayList();
    for (final Object elem : iter) {
      String _geoDefault = GEODefaultValueRenderer.toGeoDefault(elem, innerVt);
      rendered.add(_geoDefault);
    }
    String _join = IterableExtensions.join(rendered, ",");
    String _plus = ("[" + _join);
    return (_plus + "]");
  }

  /**
   * Auto-quote strings, keep numbers/bools as-is, lists recursively handled
   */
  private static String valueAuto(final Object raw) {
    String _switchResult = null;
    boolean _matched = false;
    if ((raw instanceof Number)) {
      _matched=true;
      _switchResult = raw.toString();
    }
    if (!_matched) {
      if ((raw instanceof Boolean)) {
        _matched=true;
        _switchResult = ((Boolean) raw).toString();
      }
    }
    if (!_matched) {
      if ((raw instanceof CharSequence)) {
        _matched=true;
        String _escape = GEODefaultValueRenderer.escape(raw.toString());
        String _plus = ("\"" + _escape);
        _switchResult = (_plus + "\"");
      }
    }
    if (!_matched) {
      if ((raw instanceof byte[])) {
        _matched=true;
        String _encodeToString = Base64.getEncoder().encodeToString(((byte[]) raw));
        String _plus_1 = ("\"" + _encodeToString);
        _switchResult = (_plus_1 + "\"");
      }
    }
    if (!_matched) {
      String _xblockexpression = null;
      {
        final Iterable<?> iter = GEODefaultValueRenderer.asIterable(raw);
        if ((iter != null)) {
          final Function1<Object, String> _function = (Object v) -> {
            return GEODefaultValueRenderer.valueAuto(v);
          };
          final List<String> rendered = IterableExtensions.<String>toList(IterableExtensions.map(iter, _function));
          String _join = IterableExtensions.join(rendered, ",");
          String _plus_2 = ("[" + _join);
          return (_plus_2 + "]");
        }
        String _escape_1 = GEODefaultValueRenderer.escape(String.valueOf(raw));
        String _plus_3 = ("\"" + _escape_1);
        _xblockexpression = (_plus_3 + "\"");
      }
      _switchResult = _xblockexpression;
    }
    return _switchResult;
  }

  private static String escape(final String s) {
    String _xblockexpression = null;
    {
      if ((s == null)) {
        return "";
      }
      _xblockexpression = s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
    return _xblockexpression;
  }

  private static Iterable<?> asIterable(final Object o) {
    Collection<?> _switchResult = null;
    boolean _matched = false;
    if ((o instanceof Collection<?>)) {
      _matched=true;
      _switchResult = ((Collection<?>) o);
    }
    if (!_matched) {
      boolean _isArray = o.getClass().isArray();
      if (_isArray) {
        _matched=true;
        _switchResult = Arrays.<Object>asList(o);
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
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

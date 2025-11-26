package de.thm.evolvedb.graph.xtend;

import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class GEOHelper {
  /**
   * Returns the parent name for the given property
   */
  public static String getPropertyParent(final Property property) {
    EObject parent = property.eContainer();
    boolean _matched = false;
    if (parent instanceof EdgeLabel) {
      _matched=true;
      return ((EdgeLabel) parent).getName();
    }
    if (!_matched) {
      if (parent instanceof NodeLabel) {
        _matched=true;
        return ((NodeLabel) parent).getName();
      }
    }
    if (!_matched) {
      if (parent instanceof NodeType) {
        _matched=true;
        return ((NodeType) parent).getName();
      }
    }
    if (!_matched) {
      if (parent instanceof EdgeType) {
        _matched=true;
        return ((EdgeType) parent).getName();
      }
    }
    return "Parent invalid";
  }
}

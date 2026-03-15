package de.thm.evolvedb.statistics;

import com.google.common.collect.Iterables;
import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ColumnConstraint;
import de.thm.evolvedb.mdde.Constraint;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.Table;
import java.util.List;
import java.util.Objects;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.sidiff.matching.model.Correspondence;

@SuppressWarnings("all")
public class CountCorrespondences {
  public String countCorrespondences(final Resource resourceDifference) {
    Iterable<Correspondence> _filter = Iterables.<Correspondence>filter(IteratorExtensions.<EObject>toIterable(resourceDifference.getAllContents()), Correspondence.class);
    for (final Correspondence e : _filter) {
    }
    Iterable<Correspondence> number = Iterables.<Correspondence>filter(IteratorExtensions.<EObject>toIterable(resourceDifference.getAllContents()), Correspondence.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The Resource contained ");
    int _size = IterableExtensions.size(number);
    _builder.append(_size);
    _builder.append(" correspondences");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    String result = _builder.toString();
    return result;
  }

  public String countStructuralElements(final Resource resourceDifference) {
    Iterable<Correspondence> _filter = Iterables.<Correspondence>filter(IteratorExtensions.<EObject>toIterable(resourceDifference.getAllContents()), Correspondence.class);
    for (final Correspondence e : _filter) {
    }
    Iterable<EObject> number = Iterables.<EObject>filter(IteratorExtensions.<EObject>toIterable(resourceDifference.getAllContents()), EObject.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The Resource contained ");
    int _size = IterableExtensions.size(number);
    _builder.append(_size);
    _builder.append(" structuralElements");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    String result = _builder.toString();
    return result;
  }

  /**
   * resourceA is the ground truth resourceB is the automatical matching without corrections
   */
  public String returnTruepositives(final Resource resourceA, final Resource resourceB) {
    List<Correspondence> corespondencesA = IterableExtensions.<Correspondence>toList(Iterables.<Correspondence>filter(IteratorExtensions.<EObject>toIterable(resourceA.getAllContents()), Correspondence.class));
    List<Correspondence> corespondencesB = IterableExtensions.<Correspondence>toList(Iterables.<Correspondence>filter(IteratorExtensions.<EObject>toIterable(resourceB.getAllContents()), Correspondence.class));
    List<Correspondence> intersection = this.intersection(corespondencesA, corespondencesB);
    final Function1<Correspondence, Boolean> _function = (Correspondence it) -> {
      EObject _matchedA = it.getMatchedA();
      return Boolean.valueOf((_matchedA instanceof Table));
    };
    List<Correspondence> tables = IterableExtensions.<Correspondence>toList(IterableExtensions.<Correspondence>filter(intersection, _function));
    final Function1<Correspondence, Boolean> _function_1 = (Correspondence it) -> {
      EObject _matchedA = it.getMatchedA();
      return Boolean.valueOf((_matchedA instanceof Column));
    };
    List<Correspondence> columns = IterableExtensions.<Correspondence>toList(IterableExtensions.<Correspondence>filter(intersection, _function_1));
    final Function1<Correspondence, Boolean> _function_2 = (Correspondence it) -> {
      EObject _matchedA = it.getMatchedA();
      return Boolean.valueOf((_matchedA instanceof Constraint));
    };
    List<Correspondence> constraints = IterableExtensions.<Correspondence>toList(IterableExtensions.<Correspondence>filter(intersection, _function_2));
    final Function1<Correspondence, Boolean> _function_3 = (Correspondence it) -> {
      EObject _matchedA = it.getMatchedA();
      return Boolean.valueOf((_matchedA instanceof ColumnConstraint));
    };
    List<Correspondence> columnConstraint = IterableExtensions.<Correspondence>toList(IterableExtensions.<Correspondence>filter(intersection, _function_3));
    final Function1<Correspondence, Boolean> _function_4 = (Correspondence it) -> {
      EObject _matchedA = it.getMatchedA();
      return Boolean.valueOf((_matchedA instanceof Database_Schema));
    };
    List<Correspondence> databaseSchema = IterableExtensions.<Correspondence>toList(IterableExtensions.<Correspondence>filter(intersection, _function_4));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Die Anzahl der True Positives beträgt insgesamt: ");
    int _size = intersection.size();
    _builder.append(_size);
    _builder.newLineIfNotEmpty();
    _builder.append("Table True Positives: ");
    int _size_1 = tables.size();
    _builder.append(_size_1);
    _builder.newLineIfNotEmpty();
    _builder.append("Column True Positives: ");
    int _size_2 = columns.size();
    _builder.append(_size_2);
    _builder.newLineIfNotEmpty();
    _builder.append("Constraint True Positives: ");
    int _size_3 = constraints.size();
    _builder.append(_size_3);
    _builder.newLineIfNotEmpty();
    _builder.append("Column Constraint True Positives: ");
    int _size_4 = columnConstraint.size();
    _builder.append(_size_4);
    _builder.newLineIfNotEmpty();
    _builder.append("Database Schema True Positives: ");
    int _size_5 = databaseSchema.size();
    _builder.append(_size_5);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String content = _builder.toString();
    return content;
  }

  public List<Correspondence> intersection(final List<Correspondence> list1, final List<Correspondence> list2) {
    final Function1<Correspondence, Boolean> _function = (Correspondence c1) -> {
      final Function1<Correspondence, Boolean> _function_1 = (Correspondence c2) -> {
        return Boolean.valueOf((Objects.equals(this.castEobjectGetName(c1.getMatchedA()), this.castEobjectGetName(c2.getMatchedA())) && 
          Objects.equals(this.castEobjectGetName(c1.getMatchedB()), this.castEobjectGetName(c2.getMatchedB()))));
      };
      return Boolean.valueOf(IterableExtensions.<Correspondence>exists(list2, _function_1));
    };
    return IterableExtensions.<Correspondence>toList(IterableExtensions.<Correspondence>filter(list1, _function));
  }

  public String castEobjectGetName(final EObject eObject) {
    String _xifexpression = null;
    if ((eObject instanceof Table)) {
      return ((Table) eObject).getName();
    } else {
      String _xifexpression_1 = null;
      if ((eObject instanceof Column)) {
        return ((Column) eObject).getName();
      } else {
        String _xifexpression_2 = null;
        if ((eObject instanceof Constraint)) {
          return ((Constraint) eObject).getName();
        } else {
          String _xifexpression_3 = null;
          if ((eObject instanceof ColumnConstraint)) {
            return ((ColumnConstraint) eObject).getName();
          } else {
            String _xifexpression_4 = null;
            if ((eObject instanceof Database_Schema)) {
              return ((Database_Schema) eObject).getName();
            } else {
              String _xblockexpression = null;
              {
                InputOutput.<String>println("None");
                EClass _eClass = eObject.eClass();
                String _plus = ("" + _eClass);
                _xblockexpression = InputOutput.<String>println(_plus);
              }
              _xifexpression_4 = _xblockexpression;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}

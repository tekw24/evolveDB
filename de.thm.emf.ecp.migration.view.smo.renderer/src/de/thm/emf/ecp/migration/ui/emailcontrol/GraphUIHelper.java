/*******************************************************************************
 * Copyright (c) 2011-2025 EclipseSource Muenchen GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Torben - initial API and implementation
 ******************************************************************************/
package de.thm.emf.ecp.migration.ui.emailcontrol;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.edit.spi.ReferenceService;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.thm.evolvedb.graph.BinaryTypes;
import de.thm.evolvedb.graph.BooleanType;
import de.thm.evolvedb.graph.Constraint;
import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.GraphItem;
import de.thm.evolvedb.graph.GraphPackage;
import de.thm.evolvedb.graph.KeyConstraint;
import de.thm.evolvedb.graph.ListType;
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.NumericType;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyExistenceConstraint;
import de.thm.evolvedb.graph.PropertyGraph;
import de.thm.evolvedb.graph.PropertyTypeConstraint;
import de.thm.evolvedb.graph.PropertyValueType;
import de.thm.evolvedb.graph.StringType;
import de.thm.evolvedb.graph.TemporalTypes;
import de.thm.evolvedb.graph.UnionType;
import de.thm.evolvedb.graph.UniqueConstraint;

/**
 * @author Torben
 *
 */
public class GraphUIHelper {

	public static final List<String> GRAPH_RULES = Arrays.asList(
		// resolvableRulesGraph (bereinigt)
		"ADD_EdgeType_(labels)_TGT_EdgeLabel",
		"ADD_EdgeLabel_(edges)_TGT_EdgeType",
		"ADD_KeyConstraint_(properties)_TGT_Property",
		"ADD_Label_(SuperType)_TGT_Label",
		"ADD_NodeType_(label)_TGT_NodeLabel",
		"ADD_NodeType_(incoming)_TGT_EdgeType",
		"ADD_NodeType_(outgoing)_TGT_EdgeType",
		"ADD_NodeLabel_(nodes)_TGT_NodeType",
		"ADD_UniqueConstraint_(properties)_TGT_Property",
		"CHANGE_LITERAL_NumericType_type_FROM_DOUBLE_TO_FLOAT128",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT_TO_FLOAT128",
		"CHANGE_LITERAL_NumericType_type_FROM_INT_TO_FLOAT",
		"CHANGE_LITERAL_NumericType_type_FROM_INT_TO_FLOAT128",
		"CHANGE_LITERAL_NumericType_type_FROM_UINT_TO_DOUBLE",
		"CHANGE_LITERAL_NumericType_type_FROM_UINT_TO_FLOAT",
		"CHANGE_LITERAL_NumericType_type_FROM_UINT_TO_FLOAT128",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_ZONED_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_ZONED_TIME",
		"CREATE_BinaryTypes",
		"CREATE_BooleanType",
		"CREATE_EdgeLabel_IN_PropertyGraph_(items)",
		"CREATE_EdgeType_IN_PropertyGraph_(items)",
		"CREATE_KeyConstraint_IN_Label_(constraints)",
		"CREATE_NodeType_IN_PropertyGraph_(items)",
		"CREATE_NodeLabel_IN_PropertyGraph_(items)",
		"CREATE_NumericType",
		"CREATE_PropertyExistenceConstraint_IN_Label_(constraints)",
		"CREATE_PropertyGraph",
		"CREATE_PropertyTypeConstraint_IN_Label_(constraints)",
		"CREATE_Property_IN_Label_(properties)",
		"CREATE_StringType",
		"CREATE_TemporalTypes",
		"CREATE_UnionType",
		"CREATE_UniqueConstraint_IN_Label_(constraints)",
		"SET_ATTRIBUTE_ListType_LowerBound",
		"SET_ATTRIBUTE_Property_Name",
		"SET_ATTRIBUTE_PropertyGraph_Closed",
		"SET_ATTRIBUTE_PropertyMandatory",
		"SET_ATTRIBUTE_PropertyValueType_Nullable",
		"SET_ATTRIBUTE_StringType_MinLength",
		"SET_ATTRIBUTE_StringType_MaxLength",
		"SET_ATTRIBUTE_StringType_Type",
		"SET_ATTRIBUTE_BinaryTypes_MaxLength",
		"SET_ATTRIBUTE_BinaryTypes_MinLength",
		"SET_ATTRIBUTE_BinaryTypes_Type",
		"SET_ATTRIBUTE_BooleanType_Type",
		"SET_ATTRIBUTE_Constraint_Name",
		"SET_ATTRIBUTE_Label_Name",
		"SET_ATTRIBUTE_ListType_UpperBound",
		"SET_ATTRIBUTE_NumericType_FractionalPart",
		"SET_ATTRIBUTE_NumericType_IntegralPart",
		"SET_ATTRIBUTE_NumericType_Type",
		"SET_ATTRIBUTE_PropertyGraph_GraphType",
		"SET_ATTRIBUTE_PropertyGraph_Location",
		"SET_ATTRIBUTE_PropertyGraph_Name",
		"SET_ATTRIBUTE_TemporalTypes_Type",
		"SET_ATTRIBUTE_UnionType_Type",
		"SET_REFERENCE_PropertyExistenceConstraint_(properties)_TGT_Property",
		"SET_REFERENCE_PropertyTypeConstraint_(properties)_TGT_Property",
		"SET_REFERENCE_PropertyTypeConstraint_(type)_TGT_PropertyValueType",
		"SET_REFERENCE_EdgeType_(src)_TGT_NodeType",
		"SET_REFERENCE_EdgeType_(tgt)_TGT_NodeType",
		"CHANGE_StringType",
		"CHANGE_PropertyValueType",
		"CHANGE_NumericType",
		"CHANGE_TemporalType",
		"CHANGE_BinaryType",

		// partiallyResolvableRulesGraph (bereinigt)
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_MINUTES",
		"CHANGE_LITERAL_StringType_type_FROM_STRING_TO_VARCHAR",
		"CHANGE_LITERAL_StringType_type_FROM_VARCHAR_TO_STRING",
		"CHANGE_LITERAL_BinaryTypes_type_FROM_BYTES_TO_VARBINARY",
		"CHANGE_LITERAL_BinaryTypes_type_FROM_VARBINARY_TO_BYTES",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT128_TO_UINT",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT_TO_DOUBLE",
		"CHANGE_LITERAL_NumericType_type_FROM_INT_TO_DOUBLE",
		"CHANGE_LITERAL_NumericType_type_FROM_DECIMAL_TO_FLOAT",
		"CHANGE_LITERAL_NumericType_type_FROM_DECIMAL_TO_FLOAT128",
		"CHANGE_LITERAL_NumericType_type_FROM_DECIMAL_TO_DOUBLE",
		"CHANGE_LITERAL_NumericType_type_FROM_DECIMAL_TO_INT",
		"CHANGE_LITERAL_NumericType_type_FROM_DECIMAL_TO_UINT",
		"CHANGE_LITERAL_NumericType_type_FROM_DOUBLE_TO_DECIMAL",
		"CHANGE_LITERAL_NumericType_type_FROM_DOUBLE_TO_FLOAT",
		"CHANGE_LITERAL_NumericType_type_FROM_DOUBLE_TO_INT",
		"CHANGE_LITERAL_NumericType_type_FROM_DOUBLE_TO_UINT",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT128_TO_DECIMAL",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT128_TO_DOUBLE",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT128_TO_FLOAT",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT128_TO_INT",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT_TO_DECIMAL",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT_TO_INT",
		"CHANGE_LITERAL_NumericType_type_FROM_FLOAT_TO_UINT",
		"CHANGE_LITERAL_NumericType_type_FROM_INT_TO_DECIMAL",
		"CHANGE_LITERAL_NumericType_type_FROM_INT_TO_UINT",
		"CHANGE_LITERAL_NumericType_type_FROM_UINT_TO_DECIMAL",
		"CHANGE_LITERAL_NumericType_type_FROM_UINT_TO_INT",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DATE_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_DAY_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_DATETIME_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_LOCAL_TIME_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MINUTES_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_MONTH_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_SUBSECONDS_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_ZONED_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_YEAR_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_DATETIME_TO_YEAR",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_DATE",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_DAY",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_LOCAL_DATETIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_LOCAL_TIME",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_MINUTES",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_MONTH",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_SUBSECONDS",
		"CHANGE_LITERAL_TemporalTypes_type_FROM_ZONED_TIME_TO_YEAR",
		"DELETE_KeyConstraint_IN_Label_(constraints)",
		"DELETE_ListType",
		"DELETE_NodeLabel_IN_PropertyGraph_(items)",
		"DELETE_NumericType",
		"DELETE_PropertyExistenceConstraint_IN_Label_(constraints)",
		"DELETE_PropertyGraph",
		"DELETE_PropertyTypeConstraint_IN_Label_(constraints)",
		"DELETE_Property_IN_EdgeType_(properties)",
		"DELETE_Property_IN_Label_(properties)",
		"DELETE_Property_IN_NodeType_(properties)",
		"DELETE_UnionType",
		"DELETE_StringType",
		"DELETE_BinaryTypes",
		"DELETE_BooleanType",
		"DELETE_EdgeLabel_IN_PropertyGraph_(items)",
		"DELETE_EdgeType_IN_PropertyGraph_(items)",
		"DELETE_NodeType_IN_PropertyGraph_(items)",
		"DELETE_TemporalTypes",
		"DELETE_UniqueConstraint_IN_Label_(constraints)",
		"REMOVE_KeyConstraint_(properties)_TGT_Property",
		"REMOVE_NodeLabel_(nodes)_TGT_NodeType",
		"REMOVE_EdgeLabel_(edges)_TGT_EdgeType",
		"REMOVE_EdgeType_(labels)_TGT_EdgeLabel",
		"REMOVE_Label_(SuperType)_TGT_Label",
		"REMOVE_NodeType_(incoming)_TGT_EdgeType",
		"REMOVE_NodeType_(label)_TGT_NodeLabel",
		"REMOVE_NodeType_(outgoing)_TGT_EdgeType",
		"REMOVE_UniqueConstraint_(properties)_TGT_Property",

		// notAutomaticallyResolvableRulesGraph (bereinigt)
		"MOVE_EdgeLabel_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_EdgeType_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_KeyConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_NodeLabel_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_NodeType_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_Property_FROM_EdgeType_(properties)_TO_EdgeType_(properties)",
		"MOVE_Property_FROM_NodeType_(properties)_TO_NodeType_(properties)",
		"MOVE_PropertyExistenceConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_PropertyTypeConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_REF_COMBI_EdgeLabel_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_REF_COMBI_EdgeType_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_REF_COMBI_KeyConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_REF_COMBI_NodeLabel_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_REF_COMBI_NodeType_FROM_PropertyGraph_(items)_TO_PropertyGraph_(items)",
		"MOVE_REF_COMBI_Property_FROM_EdgeType_(properties)_TO_EdgeType_(properties)",
		"MOVE_REF_COMBI_Property_FROM_Label_(properties)_TO_NodeType_(properties)",
		"MOVE_REF_COMBI_Property_FROM_NodeType_(properties)_TO_EdgeType_(properties)",
		"MOVE_REF_COMBI_Property_FROM_NodeType_(properties)_TO_Label_(properties)",
		"MOVE_REF_COMBI_Property_FROM_NodeType_(properties)_TO_NodeType_(properties)",
		"MOVE_REF_COMBI_PropertyExistenceConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_REF_COMBI_PropertyTypeConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_REF_COMBI_Property_FROM_EdgeType_(properties)_TO_Label_(properties)",
		"MOVE_REF_COMBI_Property_FROM_EdgeType_(properties)_TO_NodeType_(properties)",
		"MOVE_REF_COMBI_Property_FROM_Label_(properties)_TO_EdgeType_(properties)",
		"MOVE_REF_COMBI_Property_FROM_Label_(properties)_TO_Label_(properties)",
		"MOVE_REF_COMBI_UniqueConstraint_FROM_Label_(constraints)_TO_Label_(constraints)",
		"MOVE_UniqueConstraint_FROM_Label_(constraints)_TO_Label_(constraints)");

	// protected static void createCompositeForProperty(Composite composite, Property property, String label,
	// EStructuralFeature es,
	// String labeltext, AdapterFactoryItemDelegator adapterFactoryItemDelegator, ReferenceService referenceService,
	// String key) {
	//
	// final Composite area = new Composite(composite, SWT.NONE);
	// GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
	// GridDataFactory.fillDefaults().grab(true, false)
	// .align(SWT.FILL, SWT.BEGINNING).applyTo(area);
	//
	// UIHelper.createHyperlink(area, property, "Property " + property.getName(), labeltext,
	// adapterFactoryItemDelegator,
	// referenceService, key);
	//
	// if (es != null) {
	// final Label header = new Label(area, SWT.NONE);
	// header.setText(label);
	//
	// GridDataFactory.fillDefaults().grab(true, false)
	// .align(SWT.FILL, SWT.BEGINNING).applyTo(header);
	//
	// final Object value = property.eGet(es);
	// final Text text = new Text(area, SWT.NONE);
	// text.setEditable(false);
	// text.setText(value != null ? value.toString() : "null"); //$NON-NLS-1$
	//
	// GridDataFactory.fillDefaults().grab(true, false)
	// .align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(text);
	// }
	//
	// }

	/*
	 * =========================================================
	 * Low-level Helfer (Layout/Attribute/Referenzen)
	 * =========================================================
	 */

	private static Composite newArea(Composite parent) {
		final Composite area = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(area);
		return area;
	}

	private static void renderAttr(Composite area, String label, Object value) {
		final Label header = new Label(area, SWT.NONE);
		header.setText(label);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.BEGINNING, SWT.BEGINNING).applyTo(header);

		final Text text = new Text(area, SWT.READ_ONLY | SWT.SINGLE | SWT.BORDER);
		text.setEditable(false);
		text.setText(value != null ? String.valueOf(value) : "null"); //$NON-NLS-1$
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(text);
	}

	private static void renderHyperlink(Composite area, EObject target, String title, String labeltext,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {
		UIHelper.createHyperlink(area, target, title, labeltext, afd, refService, key);
	}

	private static void renderRefSingle(Composite parent, String caption, EObject target,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {
		final Composite area = newArea(parent);
		final Label header = new Label(area, SWT.NONE);
		header.setText(caption);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.BEGINNING, SWT.CENTER).applyTo(header);

		if (target != null) {
			renderHyperlink(area, target, getTitleFor(target), caption, afd, refService, key);
		} else {
			final Label empty = new Label(area, SWT.NONE);
			empty.setText("—");
			GridDataFactory.fillDefaults().span(2, 1).applyTo(empty);
		}
	}

	private static void renderRefList(Composite parent, String caption, List<? extends EObject> list,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(parent);
		final Label header = new Label(area, SWT.NONE);
		header.setText(caption);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.BEGINNING, SWT.BEGINNING).applyTo(header);

		if (list == null || list.isEmpty()) {
			final Label empty = new Label(area, SWT.NONE);
			empty.setText("—");
			GridDataFactory.fillDefaults().span(2, 1).applyTo(empty);
			return;
		}

		// erste Zelle schon belegt -> zwei Spalten für die Links
		final Composite links = new Composite(area, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(links);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(links);

		for (final EObject obj : list) {
			renderHyperlink(links, obj, getTitleFor(obj), caption, afd, refService, key);
		}
	}

	private static String getTitleFor(EObject obj) {
		if (obj instanceof PropertyGraph) {
			final PropertyGraph g = (PropertyGraph) obj;
			return "PropertyGraph " + safe(g.getName());
		}
		if (obj instanceof NodeType) {
			final NodeType n = (NodeType) obj;
			return "NodeType " + safe(n.getName());
		}
		if (obj instanceof EdgeType) {
			final EdgeType e = (EdgeType) obj;
			return "EdgeType " + safe(e.getName());
		}
		if (obj instanceof NodeLabel) {
			return "NodeLabel " + safe(((NodeLabel) obj).getName());
		}
		if (obj instanceof EdgeLabel) {
			return "EdgeLabel " + safe(((EdgeLabel) obj).getName());
		}
		if (obj instanceof Property) {
			return "Property " + safe(((Property) obj).getName());
		}
		if (obj instanceof Constraint) {
			return "Constraint " + safe(((Constraint) obj).getName());
		}
		return obj.eClass().getName();
	}

	private static String safe(String s) {
		return s == null ? "<unnamed>" : s;
	}

	/*
	 * =========================================================
	 * Bestehende Methode (Property)
	 * =========================================================
	 */

	protected static void createCompositeForProperty(Composite composite, Property property, String label,
		EStructuralFeature es, String labeltext, AdapterFactoryItemDelegator adapterFactoryItemDelegator,
		ReferenceService referenceService, String key) {

		final Composite area = newArea(composite);

		// Kopf-Link auf das Property selbst
		renderHyperlink(area, property, "Property " + safe(property.getName()), labeltext,
			adapterFactoryItemDelegator, referenceService, key);

		if (es != null) {
			renderAttr(area, label, property.eGet(es));
		}

		// Standardfelder (falls gewünscht direkt mit anzeigen)
		renderAttr(area, "name", property.getName());
		renderAttr(area, "mandatory", property.isMandatory());

		// Value-Typ (einzeln)
		renderRefSingle(composite, "value", property.getValue(),
			adapterFactoryItemDelegator, referenceService, key);
	}

	/*
	 * =========================================================
	 * PropertyGraph & Basistypen
	 * =========================================================
	 */

	public static void createCompositeForPropertyGraph(Composite composite, PropertyGraph graph,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(composite);
		renderHyperlink(area, graph, getTitleFor(graph), "graph", afd, refService, key);

		renderAttr(area, "name", graph.getName());
		renderAttr(area, "closed", graph.isClosed());
		renderAttr(area, "graphtype", graph.getGraphtype());
		renderAttr(area, "location", graph.getLocation());

		// Items (heterogen): wir zeigen alle mit Hyperlink
		renderRefList(composite, "items", graph.getItems(), afd, refService, key);
	}

	/** Gemeinsamer Teil für GraphItem (zeigt den übergeordneten Graph). */
	private static void renderGraphBackref(Composite composite, GraphItem item,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {
		renderRefSingle(composite, "graph", item.getGraph(), afd, refService, key);
	}

	/*
	 * =========================================================
	 * NodeType / EdgeType
	 * =========================================================
	 */

	public static void createCompositeForNodeType(Composite composite, NodeType nodeType,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(composite);
		renderHyperlink(area, nodeType, getTitleFor(nodeType), "nodeType", afd, refService, key);

		renderAttr(area, "name", nodeType.getName()); // derived
		renderGraphBackref(composite, nodeType, afd, refService, key);

		renderRefList(composite, "label", nodeType.getLabel(), afd, refService, key);
		renderRefList(composite, "outgoing", nodeType.getOutgoing(), afd, refService, key);
		renderRefList(composite, "incoming", nodeType.getIncoming(), afd, refService, key);
		renderRefList(composite, "properties", nodeType.getProperties(), afd, refService, key);
	}

	public static void createCompositeForEdgeType(Composite composite, EdgeType edgeType,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(composite);
		renderHyperlink(area, edgeType, getTitleFor(edgeType), "edgeType", afd, refService, key);

		renderAttr(area, "name", edgeType.getName()); // derived
		renderGraphBackref(composite, edgeType, afd, refService, key);

		renderRefList(composite, "labels", edgeType.getLabels(), afd, refService, key);
		renderRefList(composite, "properties", edgeType.getProperties(), afd, refService, key);
		renderRefSingle(composite, "src", edgeType.getSrc(), afd, refService, key);
		renderRefSingle(composite, "tgt", edgeType.getTgt(), afd, refService, key);
	}

	/*
	 * =========================================================
	 * Label / NodeLabel / EdgeLabel
	 * =========================================================
	 */

	public static void createCompositeForLabel(Composite composite, de.thm.evolvedb.graph.Label label,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(composite);
		renderHyperlink(area, label, getTitleFor(label), "label", afd, refService, key);

		renderAttr(area, "name", label.getName());
		renderGraphBackref(composite, label, afd, refService, key);

		renderRefList(composite, "properties", label.getProperties(), afd, refService, key);
		renderRefList(composite, "superTypes", label.getSuperType(), afd, refService, key);
		renderRefList(composite, "constraints", label.getConstraints(), afd, refService, key);
	}

	public static void createCompositeForNodeLabel(Composite composite, NodeLabel nodeLabel,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {
		createCompositeForLabel(composite, nodeLabel, afd, refService, key);
		renderRefList(composite, "nodes", nodeLabel.getNodes(), afd, refService, key);
	}

	public static void createCompositeForEdgeLabel(Composite composite, EdgeLabel edgeLabel,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {
		createCompositeForLabel(composite, edgeLabel, afd, refService, key);
		renderRefList(composite, "edges", edgeLabel.getEdges(), afd, refService, key);
	}

	/*
	 * =========================================================
	 * PropertyValueType (+ Subklassen)
	 * =========================================================
	 */

	public static void createCompositeForPropertyValueType(Composite composite, PropertyValueType pvt,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(composite);
		renderHyperlink(area, pvt, pvt.eClass().getName(), "valueType", afd, refService, key);

		renderAttr(area, "nullable", pvt.isNullable());
		renderRefSingle(composite, "property", pvt.getProperty(), afd, refService, key);

		if (pvt instanceof StringType) {
			final StringType s = (StringType) pvt;
			renderAttr(composite, "type", s.getType());
			renderAttr(composite, "minLength", s.getMinLength());
			renderAttr(composite, "maxLength", s.getMaxLength());
		} else if (pvt instanceof NumericType) {
			final NumericType n = (NumericType) pvt;
			renderAttr(composite, "type", n.getType());
			renderAttr(composite, "integralPart", n.getIntegralPart());
			renderAttr(composite, "fractionalPart", n.getFractionalPart());
		} else if (pvt instanceof TemporalTypes) {
			renderAttr(composite, "type", ((TemporalTypes) pvt).getType());
		} else if (pvt instanceof BooleanType) {
			renderAttr(composite, "type", ((BooleanType) pvt).getType());
		} else if (pvt instanceof BinaryTypes) {
			final BinaryTypes b = (BinaryTypes) pvt;
			renderAttr(composite, "type", b.getType());
			renderAttr(composite, "minLength", b.getMinLength());
			renderAttr(composite, "maxLength", b.getMaxLength());
		} else if (pvt instanceof UnionType) {
			renderAttr(composite, "type", ((UnionType) pvt).getType());
		} else if (pvt instanceof ListType) {
			final ListType l = (ListType) pvt;
			renderAttr(composite, "lowerBound", l.getLowerBound());
			renderAttr(composite, "upperBound", l.getUpperBound());
			renderRefSingle(composite, "type", l.getType(), afd, refService, key);
		}
	}

	/*
	 * =========================================================
	 * Constraints
	 * =========================================================
	 */

	public static void createCompositeForConstraint(Composite composite, Constraint c,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		final Composite area = newArea(composite);
		renderHyperlink(area, c, getTitleFor(c), "constraint", afd, refService, key);
		renderAttr(area, "name", c.getName());
		renderRefSingle(composite, "label", c.getLabel(), afd, refService, key);

		if (c instanceof UniqueConstraint) {
			renderRefList(composite, "properties", ((UniqueConstraint) c).getProperties(), afd, refService, key);
		} else if (c instanceof PropertyTypeConstraint) {
			final PropertyTypeConstraint ptc = (PropertyTypeConstraint) c;
			renderRefSingle(composite, "properties", ptc.getProperties(), afd, refService, key);
			renderRefSingle(composite, "type", ptc.getType(), afd, refService, key);
		} else if (c instanceof PropertyExistenceConstraint) {
			renderRefSingle(composite, "properties", ((PropertyExistenceConstraint) c).getProperties(), afd, refService,
				key);
		} else if (c instanceof KeyConstraint) {
			renderRefList(composite, "properties", ((KeyConstraint) c).getProperties(), afd, refService, key);
		}
	}

	/*
	 * =========================================================
	 * Convenience – EStructuralFeature-basierte Anzeige
	 * (falls du punktgenau ein einzelnes Feature zeigen willst)
	 * =========================================================
	 */

	public static void createFeatureRow(Composite composite, EObject obj, EStructuralFeature feature, String caption) {
		final Composite area = newArea(composite);
		renderAttr(area, caption != null ? caption : feature.getName(), obj.eGet(feature));
	}

	/*
	 * =========================================================
	 * Schnelle Dispatcher (optional)
	 * =========================================================
	 */

	public static void createCompositeForAny(Composite composite, EObject obj,
		AdapterFactoryItemDelegator afd, ReferenceService refService, String key) {

		if (obj instanceof PropertyGraph) {
			createCompositeForPropertyGraph(composite, (PropertyGraph) obj, afd, refService, key);
		} else if (obj instanceof NodeType) {
			createCompositeForNodeType(composite, (NodeType) obj, afd, refService, key);
		} else if (obj instanceof EdgeType) {
			createCompositeForEdgeType(composite, (EdgeType) obj, afd, refService, key);
		} else if (obj instanceof NodeLabel) {
			createCompositeForNodeLabel(composite, (NodeLabel) obj, afd, refService, key);
		} else if (obj instanceof EdgeLabel) {
			createCompositeForEdgeLabel(composite, (EdgeLabel) obj, afd, refService, key);
		} else if (obj instanceof Property) {
			createCompositeForProperty(composite, (Property) obj, "value", GraphPackage.Literals.PROPERTY__VALUE,
				"value", afd, refService, key);
		} else if (obj instanceof PropertyValueType) {
			createCompositeForPropertyValueType(composite, (PropertyValueType) obj, afd, refService, key);
		} else if (obj instanceof Constraint) {
			createCompositeForConstraint(composite, (Constraint) obj, afd, refService, key);
		} else {
			// Fallback: generisch ein paar Kerninfos
			final Composite area = newArea(composite);
			renderHyperlink(area, obj, obj.eClass().getName(), obj.eClass().getName(), afd, refService, key);
		}
	}

}

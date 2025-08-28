/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.emf.ecp.migration.ui.emailcontrol;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.edit.spi.ReferenceService;
import org.eclipse.emf.ecp.view.model.common.AbstractGridCell.Alignment;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.AbstractControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.core.services.label.NoLabelFoundException;
import org.eclipse.emfforms.spi.swt.core.layout.GridDescriptionFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ColumnConstraint;
import de.thm.evolvedb.mdde.Constraint;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.Index;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.impl.ColumnImpl;

/**
 * @author Torben
 *
 */
public class SemanticChangeSetRenderer extends AbstractControlSWTRenderer<VControl> {

	private final EMFFormsEditSupport emfFormsEditSupport;
	private SWTGridDescription rendererGridDescription;
	private ReferenceService referenceService;
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	private ComposedAdapterFactory composedAdapterFactory;

	/**
	 * @param vElement
	 * @param viewContext
	 * @param reportService
	 * @param emfFormsDatabinding
	 * @param emfFormsLabelProvider
	 * @param vtViewTemplateProvider
	 */
	@Inject
	public SemanticChangeSetRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService,
		EMFFormsDatabinding emfFormsDatabinding, EMFFormsLabelProvider emfFormsLabelProvider,
		VTViewTemplateProvider vtViewTemplateProvider, EMFFormsEditSupport emfFormsEditSupport) {
		super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider);
		this.emfFormsEditSupport = emfFormsEditSupport;
		super.applyEnable();
	}

	@Override
	protected void postInit() {
		super.postInit();
		composedAdapterFactory = new ComposedAdapterFactory(new AdapterFactory[] {
			new CustomReflectiveItemProviderAdapterFactory(),
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer#getGridDescription(org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription)
	 */
	@Override
	public SWTGridDescription getGridDescription(SWTGridDescription gridDescription) {
		if (rendererGridDescription == null) {
			rendererGridDescription = GridDescriptionFactory.INSTANCE.createSimpleGrid(1, 1, this);
		}
		return rendererGridDescription;
	}

	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlSWTControlSWTRenderer#createBindings(org.eclipse.swt.widgets.Control)
	// */
	// @Override
	// protected Binding[] createBindings(Control control) throws DatabindingFailedException {
	// System.out.println("Create Binding");
	// throw new IllegalAccessError();
	//
	// // final EStructuralFeature structuralFeature = (EStructuralFeature) getModelValue().getValueType();
	// // final UpdateValueStrategy targetToModelUpdateStrategy = withPreSetValidation(
	// // new TargetToModelUpdateStrategy(structuralFeature.isUnsettable()));
	// // final ModelToTargetUpdateStrategy modelToTargetUpdateStrategy = new ModelToTargetUpdateStrategy(false);
	// // final Binding binding = bindValue(control, getModelValue(), getDataBindingContext(),
	// // targetToModelUpdateStrategy,
	// // modelToTargetUpdateStrategy);
	// // final Binding tooltipBinding = createTooltipBinding(control, getModelValue(), getDataBindingContext(),
	// // targetToModelUpdateStrategy,
	// // new ModelToTargetUpdateStrategy(true));
	// // return new Binding[] { binding, tooltipBinding };
	//
	// //return null;
	// }

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlSWTControlSWTRenderer#createSWTControl(org.eclipse.swt.widgets.Composite)
	 */
	// @Override
	// protected Control createSWTControl(Composite parent) throws DatabindingFailedException {
	// final Composite composite = new Composite(parent, SWT.NONE);
	// GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(true).applyTo(composite);
	//
	// final Label label = new Label(composite, SWT.NONE);
	// label.setText("Semantic Change Sets2");
	//
	// final EList<SemanticChangeSet> object = (EList<SemanticChangeSet>) getModelValue().getValue();
	// System.out.println("This is the object: " + object.toString());
	// // final Text text = new Text(composite, getTextWidgetStyle());
	// // text.setData(CUSTOM_VARIANT, getTextVariantID());
	// SWTDataElementIdHelper.setElementIdDataForVControl(label, getVElement(), getViewModelContext());
	// // text.setMessage(getTextMessage());
	//
	// final GridDataFactory gdf = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
	// .grab(true, true).span(1, 1);
	// final EMFFormsEditSupport editSupport = getEmfFormsEditSupport();
	// if (editSupport.isMultiLine(getVElement().getDomainModelReference(), getViewModelContext().getDomainModel())) {
	// gdf.hint(50, 200);// set x hint to enable wrapping
	// }
	//
	// for (final SemanticChangeSet set : object) {
	// final Label label2 = new Label(composite, SWT.NONE);
	// label2.setText(set.getDescription());
	// gdf.applyTo(label2);
	// }
	//
	// gdf.applyTo(label);
	//
	// return composite;
	// }

	public EMFFormsEditSupport getEmfFormsEditSupport() {
		return emfFormsEditSupport;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer#renderControl(org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell,
	 *      org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control renderControl(SWTGridCell cell, Composite parent) {
		cell.setVerticalFill(false);
		cell.setVerticalAlignment(Alignment.BEGINNING);
		cell.setVerticalGrab(false);

		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(true).applyTo(composite);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(composite);

		// final Color textBgColor = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
		// composite.setBackground(textBgColor);

		// final Label label = new Label(composite, SWT.NONE);
		// label.setText("Semantic Change Sets");

		// GridDataFactory.fillDefaults().grab(true, false)
		// .align(SWT.FILL, SWT.BEGINNING).applyTo(label);

		try {
			final EList<SemanticChangeSet> object = (EList<SemanticChangeSet>) getModelValue().getValue();

			if (object.size() == 1) {

				for (final SemanticChangeSet set : object) {
					final Label label2 = new Label(composite, SWT.NONE);
					label2.setText(set.getDescription());
					GridDataFactory.fillDefaults().grab(true, false)
						.align(SWT.FILL, SWT.BEGINNING).applyTo(label2);

					if (set.getChanges().size() == 1) {
						for (final Change change : set.getChanges()) {
							if (change instanceof AttributeValueChange) {
								final AttributeValueChange avc = (AttributeValueChange) change;
								createForAttributeValueChange(avc, composite);

							}

						}
					} else {

						if (set.getEditRName().equals("CREATE_Column_IN_Table_(columns)")) { //$NON-NLS-1$
							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).findFirst();
							if (optional2.isPresent()) {

								final AddObject addObject = (AddObject) optional2.get();

								final Column columnA = (Column) addObject.getObj();

								createCompositeForColumn(composite, columnA, null, null, "New Column:"); //$NON-NLS-1$

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("CREATE_ColumnConstraint_IN_Constraint_(columns)")) { //$NON-NLS-1$
							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).findFirst();
							if (optional2.isPresent()) {

								final AddObject addObject = (AddObject) optional2.get();

								final ColumnConstraint columnConstraint = (ColumnConstraint) addObject.getObj();

								createCompositeForConstraint(composite, columnConstraint.getConstraint(),
									columnConstraint.getConstraint().getName(), null,
									"Existing Constraint:"); //$NON-NLS-1$

								final Label label = new Label(composite, SWT.NONE);
								label.setText("Adds the following column to the existing constraint:");

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								// createDescription(composite, eAttribute, columnA, columnB);

								final Column columnA = columnConstraint.getColumn();

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("SET_REFERENCE_ColumnConstraint_(column)_TGT_Column")) { //$NON-NLS-1$
							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof AddReference).findFirst();
							if (optional2.isPresent()) {

								final AddReference addObject = (AddReference) optional2.get();

								ColumnConstraint columnConstraint = null;
								Column columnA = null;
								if (addObject.getSrc() instanceof ColumnConstraint) {
									columnConstraint = (ColumnConstraint) addObject.getSrc();
									columnA = (Column) addObject.getTgt();
								} else {
									columnConstraint = (ColumnConstraint) addObject.getTgt();
									columnA = (Column) addObject.getSrc();
								}

								createCompositeForConstraint(composite, columnConstraint.getConstraint(),
									columnConstraint.getConstraint().getName(), null,
									"Existing Constraint:"); //$NON-NLS-1$

								final Label label = new Label(composite, SWT.NONE);
								label.setText("Adds the following column to the existing constraint:");

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								// createDescription(composite, eAttribute, columnA, columnB)

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("CREATE_PrimaryKey_IN_Table_(columns)")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).findFirst();
							if (optional2.isPresent()) {

								final AddObject addObject = (AddObject) optional2.get();

								final Column columnA = (Column) addObject.getObj();

								createCompositeForColumn(composite, columnA, null, null, "New Primary Key:"); //$NON-NLS-1$

								// createDescription(composite, eAttribute, columnA, columnB);

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("CREATE_ForeignKey_IN_Table_(columns)")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).findFirst();
							if (optional2.isPresent()) {

								final AddObject addObject = (AddObject) optional2.get();

								final ForeignKey columnA = (ForeignKey) addObject.getObj();

								createCompositeForColumn(composite, columnA, null, null, "New Column:"); //$NON-NLS-1$

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								createHyperlink(area, columnA.getReferencedTable(),
									Messages.SemanticChangeSetRenderer_Table + columnA.getReferencedTable().getName(),
									Messages.SemanticChangeSetRenderer_Ref_Table);
								createHyperlink(area, columnA.getReferencedKeyColumn(),
									Messages.SemanticChangeSetRenderer_Primary
										+ columnA.getReferencedKeyColumn().getName(),
									Messages.SemanticChangeSetRenderer_Ref_Key);

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("DELETE_ForeignKey_IN_Table_(columns)")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).findFirst();
							if (optional2.isPresent()) {

								final RemoveObject addObject = (RemoveObject) optional2.get();

								final ForeignKey columnA = (ForeignKey) addObject.getObj();

								createCompositeForColumn(composite, columnA, null, null, "Remove Foreign Key:"); //$NON-NLS-1$

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								createHyperlink(area, columnA.getReferencedTable(),
									Messages.SemanticChangeSetRenderer_Table + columnA.getReferencedTable().getName(),
									Messages.SemanticChangeSetRenderer_Ref_Table);
								createHyperlink(area, columnA.getReferencedKeyColumn(),
									Messages.SemanticChangeSetRenderer_Primary
										+ columnA.getReferencedKeyColumn().getName(),
									Messages.SemanticChangeSetRenderer_Ref_Key);

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("DELETE_Column_IN_Table_(columns)")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).findFirst();
							if (optional2.isPresent()) {

								final RemoveObject addObject = (RemoveObject) optional2.get();

								final Column columnA = (Column) addObject.getObj();

								createCompositeForColumn(composite, columnA, null, null, "Remove Column:"); //$NON-NLS-1$

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								createHyperlink(area, columnA.getTable(),
									Messages.SemanticChangeSetRenderer_Table + columnA.getTable().getName(),
									Messages.SemanticChangeSetRenderer_Table);

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("DELETE_PrimaryKey_IN_Table_(columns)")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).findFirst();
							if (optional2.isPresent()) {

								final RemoveObject addObject = (RemoveObject) optional2.get();

								final PrimaryKey columnA = (PrimaryKey) addObject.getObj();

								createCompositeForColumn(composite, columnA, null, null, "Remove Column:"); //$NON-NLS-1$

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								createHyperlink(area, columnA.getTable(),
									Messages.SemanticChangeSetRenderer_Table + columnA.getTable().getName(),
									Messages.SemanticChangeSetRenderer_Table);

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						}

						else if (set.getEditRName().equals("MOVE_Column_FROM_Table_(columns)_TO_Table_(columns)")) { //$NON-NLS-1$

							final List<RemoveReference> removeReference = set.getChanges().stream()
								.filter(n -> n instanceof RemoveReference).map(n -> (RemoveReference) n)
								.collect(Collectors.toList());
							final List<AddReference> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddReference).map(n -> (AddReference) n)
								.collect(Collectors.toList());

							if (removeReference.size() > 0 && addReference.size() > 0) {

								final Optional<AddReference> addReferenceOptional = addReference.stream()
									.filter(n -> n.getSrc() instanceof Column).findFirst();
								final Optional<RemoveReference> removeReferenceOptional = removeReference.stream()
									.filter(n -> n.getSrc() instanceof Column).findFirst();

								if (addReferenceOptional.isPresent() && removeReferenceOptional.isPresent()) {
									final Column columnAdd = (Column) addReferenceOptional.get().getSrc();
									final Column columnRemove = (Column) removeReferenceOptional.get().getSrc();

									createCompositeForColumn(composite, columnAdd, null, null,
										Messages.SemanticChangeSetRenderer_Column);

									// createCompositeForTable(composite, columnRemove.getTable(), "Old Table:", null,
									// //$NON-NLS-1$
									// "New Column:");

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									createHyperlink(area, columnAdd.getTable(),
										Messages.SemanticChangeSetRenderer_Table
											+ columnAdd.getTable().getName(),
										Messages.SemanticChangeSetRenderer_Old_Table);
									createHyperlink(area, columnRemove.getTable(),
										Messages.SemanticChangeSetRenderer_Table
											+ columnRemove.getTable().getName(),
										Messages.SemanticChangeSetRenderer_New_Table);

								}
							}

						}

						else if (set.getEditRName().equals("CHANGE_1N_INTO_NM")) { //$NON-NLS-1$

							final List<RemoveObject> removeReference = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).map(n -> (RemoveObject) n)
								.collect(Collectors.toList());
							final List<AddObject> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).map(n -> (AddObject) n)
								.collect(Collectors.toList());

							if (removeReference.size() > 0 && addReference.size() > 0) {

								final Optional<AddObject> addTable = addReference.stream()
									.filter(n -> n.getObj() instanceof Table).findFirst();
								final Optional<RemoveObject> removeForeignKey = removeReference.stream()
									.filter(n -> n.getObj() instanceof ForeignKey).findFirst();

								if (addTable.isPresent() && removeForeignKey.isPresent()) {

									final Table tableAdd = (Table) addTable.get().getObj();
									final ForeignKey columnRemove = (ForeignKey) removeForeignKey.get().getObj();

									createCompositeForColumn(composite, columnRemove, null, null,
										Messages.SemanticChangeSetRenderer_OLD_FOREIGNKEY);

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									final Label label = new Label(area, SWT.NONE);
									label.setText(Messages.SemanticChangeSetRenderer_CreateTable + tableAdd.getName());
									GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

									FontDescriptor descriptor = FontDescriptor.createFrom(label.getFont());
									// setStyle method returns a new font descriptor for the given style
									descriptor = descriptor.setStyle(SWT.BOLD);
									label.setFont(descriptor.createFont(label.getDisplay()));

									createHyperlink(area, tableAdd,
										Messages.SemanticChangeSetRenderer_Table + tableAdd.getName(),
										Messages.SemanticChangeSetRenderer_newOBJ);

									final Grid grid = createGrid(area, 3, 1);

									for (final Column column : tableAdd.getColumns()) {
										final GridItem item = new GridItem(grid, SWT.NONE);
										item.setText(column.getName());
										item.setText(1, column.eClass().getName());
										item.setText(2, column.getType().getName());
										item.setText(3, column.getSize() != null ? column.getSize()
											: Messages.SemanticChangeSetRenderer_null);
										item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
											: Messages.SemanticChangeSetRenderer_null);
										// item.setChecked(5, column.getUnique() != null ? column.getUnique()
										// : false);
										item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
											: false);

									}

								}
							}

						} else if (set.getEditRName().equals("CHANGE_1N_INTO_NM_MOVE")) { //$NON-NLS-1$

							final List<RemoveReference> removeReference = set.getChanges().stream()
								.filter(n -> n instanceof RemoveReference).map(n -> (RemoveReference) n)
								.collect(Collectors.toList());
							final List<AddObject> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).map(n -> (AddObject) n)
								.collect(Collectors.toList());

							if (removeReference.size() > 0 && addReference.size() > 0) {

								final Optional<AddObject> addTable = addReference.stream()
									.filter(n -> n.getObj() instanceof Table).findFirst();
								final Optional<RemoveReference> moveForeignKey = removeReference.stream()
									.filter(n -> n.getSrc() instanceof Column).findFirst();

								if (addTable.isPresent() && moveForeignKey.isPresent()) {

									final Table tableAdd = (Table) addTable.get().getObj();
									final ForeignKey columnRemove = (ForeignKey) moveForeignKey.get().getSrc();

									createCompositeForColumn(composite, columnRemove, null, null,
										Messages.SemanticChangeSetRenderer_OLD_FOREIGNKEY);

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									final Label label = new Label(area, SWT.NONE);
									label.setText(Messages.SemanticChangeSetRenderer_CreateTable + tableAdd.getName());
									GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

									FontDescriptor descriptor = FontDescriptor.createFrom(label.getFont());
									// setStyle method returns a new font descriptor for the given style
									descriptor = descriptor.setStyle(SWT.BOLD);
									label.setFont(descriptor.createFont(label.getDisplay()));

									createHyperlink(area, tableAdd,
										Messages.SemanticChangeSetRenderer_Table + tableAdd.getName(),
										Messages.SemanticChangeSetRenderer_newOBJ);

									final Grid grid = createGrid(area, 3, 1);

									for (final Column column : tableAdd.getColumns()) {
										final GridItem item = new GridItem(grid, SWT.NONE);
										item.setText(column.getName());
										item.setText(1, column.eClass().getName());
										item.setText(2, column.getType().getName());
										item.setText(3, column.getSize() != null ? column.getSize()
											: Messages.SemanticChangeSetRenderer_null);
										item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
											: Messages.SemanticChangeSetRenderer_null);
										// item.setChecked(5, column.getUnique() != null ? column.getUnique()
										// : false);
										item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
											: false);

									}

								}
							}

						} else if (set.getEditRName().equals("CHANGE_1N_INTO_NM_PRESERVE")) { //$NON-NLS-1$

							final List<AddObject> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).map(n -> (AddObject) n)
								.collect(Collectors.toList());

							if (addReference.size() > 0) {

								final Optional<AddObject> addTable = addReference.stream()
									.filter(n -> n.getObj() instanceof Table).findFirst();

								if (addTable.isPresent()) {

									final Table tableAdd = (Table) addTable.get().getObj();

									// The column isn't removed.
									// createCompositeForColumn(composite, columnRemove, null, null,
									// Messages.SemanticChangeSetRenderer_OLD_FOREIGNKEY);

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									final Label label = new Label(area, SWT.NONE);
									label.setText(Messages.SemanticChangeSetRenderer_CreateTable + tableAdd.getName());
									GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

									FontDescriptor descriptor = FontDescriptor.createFrom(label.getFont());
									// setStyle method returns a new font descriptor for the given style
									descriptor = descriptor.setStyle(SWT.BOLD);
									label.setFont(descriptor.createFont(label.getDisplay()));

									createHyperlink(area, tableAdd,
										Messages.SemanticChangeSetRenderer_Table + tableAdd.getName(),
										Messages.SemanticChangeSetRenderer_newOBJ);

									final Grid grid = createGrid(area, 3, 1);

									for (final Column column : tableAdd.getColumns()) {
										final GridItem item = new GridItem(grid, SWT.NONE);
										item.setText(column.getName());
										item.setText(1, column.eClass().getName());
										item.setText(2, column.getType().getName());
										item.setText(3, column.getSize() != null ? column.getSize()
											: Messages.SemanticChangeSetRenderer_null);
										item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
											: Messages.SemanticChangeSetRenderer_null);
										// item.setChecked(5, column.getUnique() != null ? column.getUnique()
										// : false);
										item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
											: false);

									}

								}
							}

						}

						else if (set.getEditRName().equals("CHANGE_NM_INTO_1N")) { //$NON-NLS-1$

							final List<RemoveObject> removeReference = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).map(n -> (RemoveObject) n)
								.collect(Collectors.toList());
							final List<AddObject> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).map(n -> (AddObject) n)
								.collect(Collectors.toList());

							if (removeReference.size() > 0 && addReference.size() > 0) {

								final Optional<AddObject> addForeign = addReference.stream()
									.filter(n -> n.getObj() instanceof ForeignKey).findFirst();
								final Optional<RemoveObject> removeTable = removeReference.stream()
									.filter(n -> n.getObj() instanceof Table).findFirst();

								if (addForeign.isPresent() && removeTable.isPresent()) {

									final Table tableRemove = (Table) removeTable.get().getObj();
									final ForeignKey columnAdd = (ForeignKey) addForeign.get().getObj();

									createCompositeForColumn(composite, columnAdd, null, null,
										Messages.SemanticChangeSetRenderer_newOBJ);

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									createHyperlink(area, columnAdd.getReferencedTable(),
										Messages.SemanticChangeSetRenderer_Table
											+ columnAdd.getReferencedTable().getName(),
										Messages.SemanticChangeSetRenderer_Ref_Table);
									createHyperlink(area, columnAdd.getReferencedKeyColumn(),
										Messages.SemanticChangeSetRenderer_Primary
											+ columnAdd.getReferencedKeyColumn().getName(),
										Messages.SemanticChangeSetRenderer_Ref_Key);

									final Label label = new Label(area, SWT.NONE);
									label.setText(Messages.SemanticChangeSetRenderer_Removed_Elements);
									GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

									FontDescriptor descriptor = FontDescriptor.createFrom(label.getFont());
									// setStyle method returns a new font descriptor for the given style
									descriptor = descriptor.setStyle(SWT.BOLD);
									label.setFont(descriptor.createFont(label.getDisplay()));

									createHyperlink(area, tableRemove,
										Messages.SemanticChangeSetRenderer_Table + tableRemove.getName(),
										Messages.SemanticChangeSetRenderer_Old_Table);

									final Grid grid = createGrid(area, 3, 1);

									for (final Column column : tableRemove.getColumns()) {
										final GridItem item = new GridItem(grid, SWT.NONE);
										item.setText(column.getName());
										item.setText(1, column.eClass().getName());
										item.setText(2, column.getType().getName());
										item.setText(3, column.getSize() != null ? column.getSize()
											: Messages.SemanticChangeSetRenderer_null);
										item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
											: Messages.SemanticChangeSetRenderer_null);
										// item.setChecked(5, column.getUnique() != null ? column.getUnique()
										// : false);
										item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
											: false);

									}

								}
							}

						}

						else if (set.getEditRName().equals("CHANGE_NM_INTO_1N_PRESERVE")) { //$NON-NLS-1$

							final List<AddObject> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).map(n -> (AddObject) n)
								.collect(Collectors.toList());

							if (addReference.size() > 0) {

								final Optional<AddObject> addForeign = addReference.stream()
									.filter(n -> n.getObj() instanceof ForeignKey).findFirst();

								if (addForeign.isPresent()) {

									final ForeignKey columnAdd = (ForeignKey) addForeign.get().getObj();

									createCompositeForColumn(composite, columnAdd, null, null,
										Messages.SemanticChangeSetRenderer_newOBJ);

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									createHyperlink(area, columnAdd.getReferencedTable(),
										Messages.SemanticChangeSetRenderer_Table
											+ columnAdd.getReferencedTable().getName(),
										Messages.SemanticChangeSetRenderer_Ref_Table);
									createHyperlink(area, columnAdd.getReferencedKeyColumn(),
										Messages.SemanticChangeSetRenderer_Primary
											+ columnAdd.getReferencedKeyColumn().getName(),
										Messages.SemanticChangeSetRenderer_Ref_Key);

								}
							}

						} else if (set.getEditRName().equals("SET_ATTRIBUTE_Column_Size_and_Type")) { //$NON-NLS-1$
							// Operator consists of two attribute value changes
							AttributeValueChange changeSize = null;
							AttributeValueChange changeType = null;

							for (final Change change : set.getChanges()) {

								if (change instanceof AttributeValueChange) {
									final AttributeValueChange avc = (AttributeValueChange) change;
									if (avc.getType().equals(MddePackage.eINSTANCE.getColumn_Size())) {
										changeSize = avc;
									}
									if (avc.getType().equals(MddePackage.eINSTANCE.getColumn_Type())) {
										changeType = avc;
									}

								}
							}

							final Object objA = changeType.getObjA();
							final Object objB = changeType.getObjB();

							if (objA instanceof Column) {
								final Column columnA = (Column) objA;
								final Column columnB = (Column) objB;

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								createHyperlink(area, columnA, "Column " + columnA.getName(), //$NON-NLS-1$
									Messages.SemanticChangeSetRenderer_COLUMN_MODELA);
								createHyperlink(area, columnB,
									Messages.SemanticChangeSetRenderer_ColumnDES + columnB.getName(),
									Messages.SemanticChangeSetRenderer_COLUMN_MODELB);

								// Type
								createBoldLabel(composite, Messages.SemanticChangeSetRenderer_DataType);

								createCompositeForValue(composite, columnA, Messages.SemanticChangeSetRenderer_OLD_TYPE,
									changeType.getType());
								createCompositeForValue(composite, columnB, Messages.SemanticChangeSetRenderer_NEW_TYPE,
									changeType.getType());

								// Size
								createBoldLabel(composite, Messages.SemanticChangeSetRenderer_Size);

								createCompositeForValue(composite, columnA, Messages.SemanticChangeSetRenderer_OLD_SIZE,
									changeSize.getType());
								createCompositeForValue(composite, columnB, Messages.SemanticChangeSetRenderer_NEW_SIZE,
									changeSize.getType());

								createDescription(composite, changeSize.getType(), columnA, columnB);

							}

						} else if (set.getEditRName().equals("JOIN_tables")) { //$NON-NLS-1$
							// Operator consists of two attribute value changes
							final List<RemoveObject> removeReference = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).map(n -> (RemoveObject) n)
								.collect(Collectors.toList());
							final List<AddObject> addReference = set.getChanges().stream()
								.filter(n -> n instanceof AddObject).map(n -> (AddObject) n)
								.collect(Collectors.toList());

							if (removeReference.size() > 0 && addReference.size() > 0) {

								// New Table
								final Optional<AddObject> addTable = addReference.stream()
									.filter(n -> n.getObj() instanceof Table).findFirst();

								// List old tables
								final List<RemoveObject> removeTables = removeReference.stream()
									.filter(n -> n.getObj() instanceof Table).collect(Collectors.toList());

								if (addTable.isPresent() && removeTables.size() == 2) {

									final Table newTable = (Table) addTable.get().getObj();

									final Composite area = new Composite(composite, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

									final Label label = new Label(area, SWT.NONE);
									label.setText(Messages.SemanticChangeSetRenderer_Removed_Elements);
									GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

									FontDescriptor descriptor = FontDescriptor.createFrom(label.getFont());
									// setStyle method returns a new font descriptor for the given style
									descriptor = descriptor.setStyle(SWT.BOLD);
									label.setFont(descriptor.createFont(label.getDisplay()));

									for (final RemoveObject removeObject : removeTables) {

										final Table removeTable = (Table) removeObject.getObj();

										createHyperlink(area, removeTable,
											Messages.SemanticChangeSetRenderer_Table
												+ removeTable.getName(),
											Messages.SemanticChangeSetRenderer_Old_Table);

										final Grid grid = createGrid(area, 3, 1);

										for (final Column column : removeTable.getColumns()) {
											final GridItem item = new GridItem(grid, SWT.NONE);
											item.setText(column.getName());
											item.setText(1, column.eClass().getName());
											item.setText(2, column.getType().getName());
											item.setText(3, column.getSize() != null ? column.getSize()
												: Messages.SemanticChangeSetRenderer_null);
											item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
												: Messages.SemanticChangeSetRenderer_null);
											// item.setChecked(5, column.getUnique() != null ? column.getUnique()
											// : false);
											item.setChecked(5,
												column.getAutoIncrement() != null ? column.getAutoIncrement()
													: false);

										}

									}

									final Label labelNew = new Label(area, SWT.NONE);
									labelNew.setText(Messages.SemanticChangeSetRenderer_New_Table);
									GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
										.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

									labelNew.setFont(descriptor.createFont(label.getDisplay()));

									final Composite linkparent = new Composite(area, SWT.NONE);
									GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false)
										.applyTo(linkparent);
									GridDataFactory.fillDefaults().grab(true, false)
										.align(SWT.FILL, SWT.BEGINNING).span(3, 1).applyTo(linkparent);

									createHyperlink(linkparent, newTable,
										Messages.SemanticChangeSetRenderer_Table + newTable.getName(),
										Messages.SemanticChangeSetRenderer_New_Table);

									final Grid grid = createGrid(area, 3, 1);

									for (final Column column : newTable.getColumns()) {
										final GridItem item = new GridItem(grid, SWT.NONE);
										item.setText(column.getName());
										item.setText(1, column.eClass().getName());
										item.setText(2, column.getType().getName());
										item.setText(3, column.getSize() != null ? column.getSize()
											: Messages.SemanticChangeSetRenderer_null);
										item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
											: Messages.SemanticChangeSetRenderer_null);
										// item.setChecked(5, column.getUnique() != null ? column.getUnique()
										// : false);
										item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
											: false);

									}

								}
							}

						} else if (set.getEditRName().equals("ADD_Constraint_(columns)_TGT_Column") //$NON-NLS-1$
							|| set.getEditRName().equals("ADD_Column_(constraints)_TGT_ColumnConstraint")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof AddReference).findFirst();
							if (optional2.isPresent()) {

								final AddReference addObject = (AddReference) optional2.get();

								final EObject eObject = addObject.getSrc();

								ColumnConstraint constraint;

								if (eObject instanceof Constraint) {
									constraint = (ColumnConstraint) eObject;
								} else {
									constraint = (ColumnConstraint) addObject.getTgt();
								}

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								if (constraint instanceof Index) {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
										Messages.SemanticChangeSetRenderer_newOBJ);
								} else {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_uniqueConstraint + constraint.getName(),
										Messages.SemanticChangeSetRenderer_newOBJ);
								}

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final Column columnA = constraint.getColumn();

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(columnA.getName());
								item.setText(1, columnA.eClass().getName());
								item.setText(2, columnA.getType().getName());
								item.setText(3, columnA.getSize() != null ? columnA.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, columnA.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("DELETE_UniqueConstraint_IN_Table_(constraints)") //$NON-NLS-1$
							|| set.getEditRName().equals("DELETE_Index_IN_Table_(constraints)")) { //$NON-NLS-1$

							final List<Change> removeObjects = set.getChanges().stream()
								.filter(n -> n instanceof RemoveObject).collect(Collectors.toList());

							if (removeObjects.size() > 0) {

								Constraint constraint = null;

								for (final Change rO : removeObjects) {
									final RemoveObject remove = (RemoveObject) rO;
									if (remove.getObj() instanceof Constraint) {
										constraint = (Constraint) remove.getObj();
									}
								}

								if (constraint == null) {

									return composite;
								}

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								if (constraint instanceof Index) {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
										Messages.SemanticChangeSetRenderer_Removed_Elements);
								} else {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_uniqueConstraint + constraint.getName(),
										Messages.SemanticChangeSetRenderer_Removed_Elements);
								}

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								for (final ColumnConstraint columnConstraint : constraint.getColumns()) {

									final Column columnA = columnConstraint.getColumn();

									final GridItem item = new GridItem(grid, SWT.NONE);
									item.setText(columnA.getName());
									item.setText(1, columnA.eClass().getName());
									item.setText(2, columnA.getType().getName());
									item.setText(3, columnA.getSize() != null ? columnA.getSize()
										: Messages.SemanticChangeSetRenderer_null);
									item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
										: Messages.SemanticChangeSetRenderer_null);
									// item.setChecked(5, columnA.getUnique());
									item.setChecked(5, columnA.getAutoIncrement());
								}

							}

						} else if (set.getEditRName().equals("REMOVE_Column_(constraints)_TGT_ColumnConstraint")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof RemoveReference).findFirst();
							if (optional2.isPresent()) {

								final RemoveReference removeObject = (RemoveReference) optional2.get();
								final EObject eObject = removeObject.getSrc();

								ColumnConstraint constraint;
								Column column;

								if (eObject instanceof Constraint) {
									constraint = (ColumnConstraint) eObject;
									column = (Column) removeObject.getTgt();
								} else {
									constraint = (ColumnConstraint) removeObject.getTgt();
									column = (Column) removeObject.getSrc();
								}

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								final Label label = new Label(area, SWT.NONE);
								label.setText(Messages.SemanticChangeSetRenderer_Column_Index_Remove);
								GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

								createHyperlink(area, column,
									Messages.SemanticChangeSetRenderer_Column + column.getName(),
									Messages.SemanticChangeSetRenderer_Removed_Elements);

								if (constraint.getConstraint() instanceof Index) {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
										Messages.SemanticChangeSetRenderer_0);
								} else {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_uniqueConstraint + constraint.getName(),
										Messages.SemanticChangeSetRenderer_Removed_Elements);
								}

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(column.getName());
								item.setText(1, column.eClass().getName());
								item.setText(2, column.getType().getName());
								item.setText(3, column.getSize() != null ? column.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, column.getAutoIncrement());

							}

						} else if (set.getEditRName().equals("DELETE_ColumnConstraint_IN_Constraint_(columns)")) { //$NON-NLS-1$

							final Optional<Change> optional2 = set.getChanges().stream()
								.filter(n -> n instanceof RemoveReference).findFirst();
							if (optional2.isPresent()) {

								final RemoveReference removeObject = (RemoveReference) optional2.get();
								final EObject eObject = removeObject.getSrc();

								Constraint constraint;
								final ColumnConstraint columnConstraint;

								if (eObject instanceof Constraint) {
									constraint = (Constraint) eObject;
									columnConstraint = (ColumnConstraint) removeObject.getTgt();
								} else {
									constraint = (Constraint) removeObject.getTgt();
									columnConstraint = (ColumnConstraint) removeObject.getSrc();
								}

								final Column column = columnConstraint.getColumn();

								final Composite area = new Composite(composite, SWT.NONE);
								GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
								GridDataFactory.fillDefaults().grab(true, false)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

								final Label label = new Label(area, SWT.NONE);
								label.setText(Messages.SemanticChangeSetRenderer_Column_Index_Remove);
								GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
									.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

								createHyperlink(area, column,
									Messages.SemanticChangeSetRenderer_Column + column.getName(),
									Messages.SemanticChangeSetRenderer_Removed_Elements);

								if (constraint instanceof Index) {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
										Messages.SemanticChangeSetRenderer_0);
								} else {
									createHyperlink(area, constraint,
										Messages.SemanticChangeSetRenderer_uniqueConstraint + constraint.getName(),
										Messages.SemanticChangeSetRenderer_Removed_Elements);
								}

								// createDescription(composite, eAttribute, columnA, columnB);

								final Grid grid = createGrid(area, 3, 1);

								final GridItem item = new GridItem(grid, SWT.NONE);
								item.setText(column.getName());
								item.setText(1, column.eClass().getName());
								item.setText(2, column.getType().getName());
								item.setText(3, column.getSize() != null ? column.getSize()
									: Messages.SemanticChangeSetRenderer_null);
								item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
									: Messages.SemanticChangeSetRenderer_null);
								// item.setChecked(5, columnA.getUnique());
								item.setChecked(5, column.getAutoIncrement());

							}

						}

					}

				}

			} else {

				// All Create and delete operations could have mor than one semantic change set
				final Optional<SemanticChangeSet> optional4 = object.stream()
					.filter(n -> n.getEditRName().equals("DELETE_Table_IN_Database_Schema_(entites)")).findFirst(); //$NON-NLS-1$
				if (optional4.isPresent()) {

					final SemanticChangeSet set = optional4.get();
					final List<Change> removeObjects = set.getChanges().stream()
						.filter(n -> n instanceof RemoveObject).collect(Collectors.toList());

					if (removeObjects.size() > 0) {

						Table table = null;

						for (final Change rO : removeObjects) {
							final RemoveObject remove = (RemoveObject) rO;
							if (remove.getObj() instanceof Table) {
								table = (Table) remove.getObj();
							}
						}

						if (table == null) {

							return composite;
						}

						final Composite area = new Composite(composite, SWT.NONE);
						GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
						GridDataFactory.fillDefaults().grab(true, false)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

						createHyperlink(area, table, Messages.SemanticChangeSetRenderer_Table + table.getName(),
							Messages.SemanticChangeSetRenderer_Removed_Elements);

						final Label label3 = new Label(area, SWT.NONE);
						label3.setText(Messages.SemanticChangeSetRenderer_1);
						GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(label3);

						final Grid grid = createGrid(area, 3, 1);

						for (final Column columnA : table.getColumns()) {

							final GridItem item = new GridItem(grid, SWT.NONE);
							item.setText(columnA.getName());
							item.setText(1, columnA.eClass().getName());
							item.setText(2, columnA.getType().getName());
							item.setText(3, columnA.getSize() != null ? columnA.getSize()
								: Messages.SemanticChangeSetRenderer_null);
							item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
								: Messages.SemanticChangeSetRenderer_null);
							// item.setChecked(5, columnA.getUnique());
							item.setChecked(5, columnA.getAutoIncrement());
						}

					}

					return composite;

				}

				final Optional<SemanticChangeSet> optional = object.stream()
					.filter(n -> n.getEditRName().equals("CREATE_Table_IN_Database_Schema_(entites)")).findFirst(); //$NON-NLS-1$
				if (optional.isPresent()) {

					final SemanticChangeSet set = optional.get();

					final Optional<Change> optional2 = set.getChanges().stream()
						.filter(n -> n instanceof AddObject).findFirst();
					if (optional2.isPresent()) {

						final Composite area = new Composite(composite, SWT.NONE);
						GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
						GridDataFactory.fillDefaults().grab(true, false)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

						final AddObject addObject = (AddObject) optional2.get();
						final Table newTable = (Table) addObject.getObj();

						final Label label2 = new Label(area, SWT.NONE);
						label2.setText(Messages.SemanticChangeSetRenderer_CreateTable + newTable.getName());
						GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(label2);

						createHyperlink(area, newTable, Messages.SemanticChangeSetRenderer_Table + newTable.getName(),
							Messages.SemanticChangeSetRenderer_newOBJ);

						final Label label3 = new Label(area, SWT.NONE);
						label3.setText(Messages.SemanticChangeSetRenderer_1);
						GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(label3);

						final Grid grid = createGrid(area, 3, 1);

						for (final Column column : newTable.getColumns()) {
							final GridItem item = new GridItem(grid, SWT.NONE);
							item.setText(column.getName());
							item.setText(1, column.eClass().getName());
							item.setText(2, column.getType().getName());
							item.setText(3, column.getSize() != null ? column.getSize()
								: Messages.SemanticChangeSetRenderer_null);
							item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
								: Messages.SemanticChangeSetRenderer_null);
							// item.setChecked(5, column.getUnique() != null ? column.getUnique()
							// : false);
							item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
								: false);

						}

					}
					return composite;

				}

				final Optional<SemanticChangeSet> optional2 = object.stream()
					.filter(n -> n.getEditRName().equals("CREATE_Index_IN_Table_(constraints)") //$NON-NLS-1$
						|| n.getEditRName().equals("CREATE_UniqueConstraint_IN_Table_(constraints)")) //$NON-NLS-1$
					.findFirst();
				if (optional2.isPresent()) {
					final SemanticChangeSet set = optional2.get();
					final Optional<Change> optional3 = set.getChanges().stream()
						.filter(n -> n instanceof AddObject).findFirst();
					if (optional3.isPresent()) {

						final Composite area = new Composite(composite, SWT.NONE);
						GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
						GridDataFactory.fillDefaults().grab(true, false)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

						final AddObject addObject = (AddObject) optional3.get();
						final Constraint constraint = (Constraint) addObject.getObj();

						if (constraint instanceof Index) {

							final Label label2 = new Label(area, SWT.NONE);
							label2.setText(Messages.SemanticChangeSetRenderer_2 + " " + constraint.getName());
							GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
								.align(SWT.FILL, SWT.BEGINNING).applyTo(label2);

						} else {
							final Label label2 = new Label(area, SWT.NONE);
							label2.setText(Messages.SemanticChangeSetRenderer_3 + constraint.getName());
							GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
								.align(SWT.FILL, SWT.BEGINNING).applyTo(label2);
						}

						createHyperlink(area, constraint,
							Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
							Messages.SemanticChangeSetRenderer_newOBJ);

						final Label label3 = new Label(area, SWT.NONE);
						label3.setText(Messages.SemanticChangeSetRenderer_1);
						GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(label3);

						final Grid grid = createGrid(area, 3, 1);

						for (final ColumnConstraint columnConstraint : constraint.getColumns()) {

							final Column column = columnConstraint.getColumn();
							final GridItem item = new GridItem(grid, SWT.NONE);
							item.setText(column.getName());
							item.setText(1, column.eClass().getName());
							item.setText(2, column.getType().getName());
							item.setText(3, column.getSize() != null ? column.getSize()
								: Messages.SemanticChangeSetRenderer_null);
							item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
								: Messages.SemanticChangeSetRenderer_null);
							// item.setChecked(5, column.getUnique() != null ? column.getUnique()
							// : false);
							item.setChecked(5, column.getAutoIncrement() != null ? column.getAutoIncrement()
								: false);

						}

					}

				}

				final Optional<SemanticChangeSet> optional3 = object.stream()
					.filter(n -> n.getEditRName().equals("DELETE_UniqueConstraint_IN_Table_(constraints)") //$NON-NLS-1$
						|| n.getEditRName().equals("DELETE_Index_IN_Table_(constraints)")) //$NON-NLS-1$
					.findFirst();

				if (optional3.isPresent()) {
					final SemanticChangeSet set = optional3.get();

					final List<Change> removeObjects = set.getChanges().stream()
						.filter(n -> n instanceof RemoveObject).collect(Collectors.toList());

					if (removeObjects.size() > 0) {

						Constraint constraint = null;

						for (final Change rO : removeObjects) {
							final RemoveObject remove = (RemoveObject) rO;
							if (remove.getObj() instanceof Constraint) {
								constraint = (Constraint) remove.getObj();
							}
						}

						if (constraint == null) {

							return composite;
						}

						final Composite area = new Composite(composite, SWT.NONE);
						GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
						GridDataFactory.fillDefaults().grab(true, false)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

						if (constraint instanceof Index) {
							createHyperlink(area, constraint,
								Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
								Messages.SemanticChangeSetRenderer_Removed_Elements);
						} else {
							createHyperlink(area, constraint,
								Messages.SemanticChangeSetRenderer_uniqueConstraint + constraint.getName(),
								Messages.SemanticChangeSetRenderer_Removed_Elements);
						}

						// createDescription(composite, eAttribute, columnA, columnB);

						final Grid grid = createGrid(area, 3, 1);

						for (final ColumnConstraint columnConstraint : constraint.getColumns()) {

							final Column columnA = columnConstraint.getColumn();

							final GridItem item = new GridItem(grid, SWT.NONE);
							item.setText(columnA.getName());
							item.setText(1, columnA.eClass().getName());
							item.setText(2, columnA.getType().getName());
							item.setText(3, columnA.getSize() != null ? columnA.getSize()
								: Messages.SemanticChangeSetRenderer_null);
							item.setText(4, columnA.getDefaultValue() != null ? columnA.getDefaultValue()
								: Messages.SemanticChangeSetRenderer_null);
							// item.setChecked(5, columnA.getUnique());
							item.setChecked(5, columnA.getAutoIncrement());
						}

					}

				}

				final Optional<SemanticChangeSet> optional7 = object.stream()
					.filter(n -> n.getEditRName().equals("DELETE_ColumnConstraint_IN_Constraint_(columns)")) //$NON-NLS-1$
					.findFirst();

				if (optional7.isPresent()) {

					final SemanticChangeSet set = optional7.get();

					final Optional<Change> optional8 = set.getChanges().stream()
						.filter(n -> n instanceof RemoveReference).findFirst();

					if (optional8.isPresent()) {

						final RemoveReference removeObject = (RemoveReference) optional8.get();
						final EObject eObject = removeObject.getSrc();

						Constraint constraint;
						final ColumnConstraint columnConstraint;

						if (eObject instanceof Constraint) {
							constraint = (Constraint) eObject;
							columnConstraint = (ColumnConstraint) removeObject.getTgt();
						} else {
							constraint = (Constraint) removeObject.getTgt();
							columnConstraint = (ColumnConstraint) removeObject.getSrc();
						}

						final Column column = columnConstraint.getColumn();

						final Composite area = new Composite(composite, SWT.NONE);
						GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
						GridDataFactory.fillDefaults().grab(true, false)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

						final Label label = new Label(area, SWT.NONE);
						label.setText(Messages.SemanticChangeSetRenderer_Column_Index_Remove);
						GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
							.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

						createHyperlink(area, column,
							Messages.SemanticChangeSetRenderer_Column + column.getName(),
							Messages.SemanticChangeSetRenderer_Removed_Elements);

						if (constraint instanceof Index) {
							createHyperlink(area, constraint,
								Messages.SemanticChangeSetRenderer_0 + constraint.getName(),
								Messages.SemanticChangeSetRenderer_0);
						} else {
							createHyperlink(area, constraint,
								Messages.SemanticChangeSetRenderer_uniqueConstraint + constraint.getName(),
								Messages.SemanticChangeSetRenderer_Removed_Elements);
						}

						// createDescription(composite, eAttribute, columnA, columnB);

						final Grid grid = createGrid(area, 3, 1);

						final GridItem item = new GridItem(grid, SWT.NONE);
						item.setText(column.getName());
						item.setText(1, column.eClass().getName());
						item.setText(2, column.getType().getName());
						item.setText(3, column.getSize() != null ? column.getSize()
							: Messages.SemanticChangeSetRenderer_null);
						item.setText(4, column.getDefaultValue() != null ? column.getDefaultValue()
							: Messages.SemanticChangeSetRenderer_null);
						// item.setChecked(5, columnA.getUnique());
						item.setChecked(5, column.getAutoIncrement());

					}

				}

			}

			createBoldLabel(composite, "Atomic Changes");
			// Table
			final TableViewer viewer = new TableViewer(composite,
				SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
			final org.eclipse.swt.widgets.Table table = viewer.getTable();
			table.setHeaderVisible(false);
			table.setLinesVisible(true);
			GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).hint(SWT.DEFAULT, 220)
				.applyTo(table);

			viewer.setContentProvider(ArrayContentProvider.getInstance());
			viewer.setLabelProvider(new AdapterFactoryLabelProvider(composedAdapterFactory));
			viewer.setUseHashlookup(true);

			final List<Change> changes = object.stream()
				.flatMap(scs -> scs.getChanges().stream())
				.toList();

			viewer.setInput(changes);

		} catch (

		final DatabindingFailedException ex) {
			ex.printStackTrace();
			// TODO Auto-generated catch block
			// Do NOT catch all Exceptions ("catch (Exception e)")
			// Log AND handle Exceptions if possible
			//
			// You can just uncomment one of the lines below to log an exception:
			// logException will show the logged excpetion to the user
			// ModelUtil.logException(ex);
			// ModelUtil.logException("YOUR MESSAGE HERE", ex);

			// logWarning will only add the message to the error log
			// ModelUtil.logWarning("YOUR MESSAGE HERE", ex);
			// ModelUtil.logWarning("YOUR MESSAGE HERE");
			//
			// If handling is not possible declare and rethrow Exception
		}

		return composite;
	}

	private void createBoldLabel(Composite paremt, String labelText) {

		final Label label = new Label(paremt, SWT.NONE);
		label.setText(labelText);
		GridDataFactory.fillDefaults().grab(true, false).span(3, 1)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(label);

		FontDescriptor descriptor = FontDescriptor.createFrom(label.getFont());
		// setStyle method returns a new font descriptor for the given style
		descriptor = descriptor.setStyle(SWT.BOLD);
		label.setFont(descriptor.createFont(label.getDisplay()));

	}

	private Grid createGrid(Composite parent, int hSpan, int vSpan) {

		final Grid grid = new Grid(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		grid.setHeaderVisible(true);
		GridDataFactory.fillDefaults().grab(true, true).span(hSpan, vSpan)
			.align(SWT.FILL, SWT.FILL).applyTo(grid);

		// GridColumns
		final GridColumn columnDescription = new GridColumn(grid, SWT.NONE);
		columnDescription.setText(Messages.SemanticChangeSetRenderer_ColumnName);
		final GridColumn columnType = new GridColumn(grid, SWT.NONE);
		columnType.setText(Messages.SemanticChangeSetRenderer_ColumnType);
		final GridColumn columnName = new GridColumn(grid, SWT.NONE);
		columnName.setText(Messages.SemanticChangeSetRenderer_DataType);

		final GridColumn columnSize = new GridColumn(grid, SWT.NONE);
		columnSize.setText(Messages.SemanticChangeSetRenderer_Size);

		final GridColumn columnDefault = new GridColumn(grid, SWT.NONE);
		columnDefault.setText(Messages.SemanticChangeSetRenderer_DefaultValue);

		// final GridColumn columnUniqe = new GridColumn(grid, SWT.CHECK);
		// columnUniqe.setText(Messages.SemanticChangeSetRenderer_Unique);
		// columnUniqe.setCellSelectionEnabled(false);

		final GridColumn columnAI = new GridColumn(grid, SWT.CHECK);
		columnAI.setText(Messages.SemanticChangeSetRenderer_AutoIncrement);
		columnAI.setCellSelectionEnabled(false);

		columnDescription.setWidth(250);
		columnType.setWidth(100);
		columnName.setWidth(100);
		columnSize.setWidth(75);
		columnDefault.setWidth(200);
		// columnUniqe.setWidth(75);
		columnAI.setWidth(125);

		return grid;
	}

	private Composite createForAttributeValueChange(AttributeValueChange avc, Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final Object objA = avc.getObjA();
		final Object objB = avc.getObjB();

		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(true).applyTo(composite);

		if (objA instanceof Column) {
			final Column columnA = (Column) objA;
			final Column columnB = (Column) objB;
			final EAttribute eAttribute = avc.getType();

			createCompositeForColumn(composite, columnA, "Old Value:", eAttribute, "Column in Model A:"); //$NON-NLS-1$ //$NON-NLS-2$
			createCompositeForColumn(composite, columnB, "New Value:", eAttribute, "Column in Model B:"); //$NON-NLS-1$ //$NON-NLS-2$

			createDescription(composite, eAttribute, columnA, columnB);

		}

		if (objA instanceof Table) {
			final Table tableA = (Table) objA;
			final Table tableB = (Table) objB;
			final EAttribute eAttribute = avc.getType();

			createCompositeForTable(composite, tableA, "Old Value:", eAttribute, "Table in Model A:"); //$NON-NLS-1$ //$NON-NLS-2$
			createCompositeForTable(composite, tableB, "New Value:", eAttribute, "Table in Model B:"); //$NON-NLS-1$ //$NON-NLS-2$

			// createDescription(composite, eAttribute, tableA, tableB);
			// TODO Create Description

		}

		if (objA instanceof Constraint) {
			final Constraint constraintA = (Constraint) objA;
			final Constraint constraintB = (Constraint) objB;
			final EAttribute eAttribute = avc.getType();

			final Composite area = new Composite(composite, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

			createHyperlink(area, constraintB.getTable(), "Table " + constraintB.getTable().getName(), "Table:");
			createCompositeForConstraint(composite, constraintA, "Old Value:", eAttribute, "Constraint in Model A:"); //$NON-NLS-1$ //$NON-NLS-2$
			createCompositeForConstraint(composite, constraintB, "New Value:", eAttribute, "Constraint in Model B:"); //$NON-NLS-1$ //$NON-NLS-2$

			// createDescription(composite, eAttribute, tableA, tableB);
			// TODO Create Description

		}

		return composite;
	}

	/**
	 * @param composite
	 * @param eAttribute
	 */
	private void createDescription(Composite composite, EAttribute eAttribute, Column columnA, Column columnB) {

		if (MddePackage.eINSTANCE.getColumn_DefaultValue().getName().equals(eAttribute.getName())) {
			final Text header = new Text(composite, SWT.WRAP);
			header.setText(Messages.SemanticChangeSetRenderer_descriptionSetColumDefaultValue);
			final GridData gridData = new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1);
			gridData.widthHint = 500;
			header.setLayoutData(gridData);
			return;
		}

		// if (MddePackage.eINSTANCE.getColumn_Unique().getName().equals(eAttribute.getName())) {
		// final Text header = new Text(composite, SWT.WRAP);
		// Boolean unique = false;
		// if (columnB != null) {
		// unique = columnB.getUnique() != null ? columnB.getUnique() : false;
		// }
		//
		// if (unique) {
		// header.setText(Messages.SemanticChangeSetRenderer_descriptionMakeColumnUnique);
		// } else {
		// header.setText(Messages.SemanticChangeSetRenderer_descriptionRemoveColumnUnique);
		// }
		// final GridData gridData = new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1);
		// gridData.widthHint = 500;
		// header.setLayoutData(gridData);
		// return;
		// }TODO UNIQUE

		if (MddePackage.eINSTANCE.getColumn_Size().getName().equals(eAttribute.getName())) {
			// final Label header = new Label(composite, SWT.WRAP);
			final Text header = new Text(composite, SWT.WRAP);
			if (ColumnImpl.dateTypesWithFraction.contains(columnA.getType())) {
				header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSizeDate);
			} else if (ColumnImpl.decimalTypes.contains(columnA.getType())) {
				header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSizeDecimal);
			} else if (ColumnImpl.textTypes.contains(columnA.getType())) {
				header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSizeText);
			} else {
				header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSize);
			}

			final GridData gridData = new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1);
			gridData.widthHint = 500;
			header.setLayoutData(gridData);
			return;
		}

	}

	private void createCompositeForColumn(Composite composite, Column column, String label, EStructuralFeature es,
		String labeltext) {

		final Composite area = new Composite(composite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

		createHyperlink(area, column, "Column " + column.getName(), labeltext); //$NON-NLS-1$

		if (es != null) {
			final Label header = new Label(area, SWT.NONE);
			header.setText(label);

			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(header);

			final Object value = column.eGet(es);
			final Text text = new Text(area, SWT.NONE);
			text.setEditable(false);
			text.setText(value != null ? value.toString() : "null"); //$NON-NLS-1$

			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(text);
		}

	}

	private void createCompositeForValue(Composite composite, Column column, String label, EStructuralFeature es) {

		final Composite area = new Composite(composite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

		if (es != null) {
			final Label header = new Label(area, SWT.NONE);
			header.setText(label);

			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(header);

			final Object value = column.eGet(es);
			final Text text = new Text(area, SWT.NONE);
			text.setEditable(false);
			text.setText(value != null ? value.toString() : "null"); //$NON-NLS-1$

			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(text);
		}

	}

	private void createCompositeForTable(Composite composite, Table column, String label, EStructuralFeature es,
		String labeltext) {

		final Composite area = new Composite(composite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

		createHyperlink(area, column, "Column " + column.getName(), labeltext); //$NON-NLS-1$

		final Label header = new Label(area, SWT.NONE);
		header.setText(label);

		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(header);

		final Object value = column.eGet(es);
		final Text text = new Text(area, getLabelStyleBits());
		text.setEditable(false);
		text.setText(value != null ? value.toString() : "null"); //$NON-NLS-1$

		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(text);

	}

	private void createCompositeForConstraint(Composite composite, Constraint objA, String label, EStructuralFeature es,
		String labeltext) {

		final Composite area = new Composite(composite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

		createHyperlink(area, objA, "Column " + objA.getName(), labeltext); //$NON-NLS-1$

		if (es != null) {
			final Label header = new Label(area, SWT.NONE);
			header.setText(label);

			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(header);

			final Object value = objA.eGet(es);
			final Text text = new Text(area, getLabelStyleBits());
			text.setEditable(false);
			text.setText(value != null ? value.toString() : "null"); //$NON-NLS-1$

			GridDataFactory.fillDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(text);
		}

	}

	/**
	 * Creates a link object targeting the EObject.
	 *
	 * @param linkComposite
	 * @param eObject
	 * @param text
	 * @param labelText
	 */
	private void createHyperlink(Composite linkComposite, EObject eObject, String text, String labelText) {

		final Label labelhyper = new Label(linkComposite, SWT.NONE);
		labelhyper.setBackground(linkComposite.getBackground());
		labelhyper.setText(labelText);

		final Label imageHyperlink = new Label(linkComposite, SWT.NONE);
		imageHyperlink.setBackground(linkComposite.getBackground());
		imageHyperlink.setImage(getImage(eObject));

		final Link hyperlink = new Link(linkComposite, SWT.NONE);
		hyperlink.setText("<a>" + getText(eObject) + "</a>"); //$NON-NLS-1$//$NON-NLS-2$
		hyperlink.setData(CUSTOM_VARIANT, "org_eclipse_emf_ecp_control_reference"); //$NON-NLS-1$
		hyperlink.setBackground(linkComposite.getBackground());
		hyperlink.setEnabled(true);
		hyperlink.setToolTipText(text);
		hyperlink.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unused")
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				super.widgetDefaultSelected(e);
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				linkClicked(eObject);
			}

		});
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.LEFT, SWT.BEGINNING).applyTo(hyperlink);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.LEFT, SWT.BEGINNING).applyTo(imageHyperlink);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.LEFT, SWT.BEGINNING).applyTo(labelhyper);
	}

	/**
	 * Method is called when a link has been clicked by the user.
	 * The value is openend in a new Context
	 *
	 * @param value
	 */
	protected void linkClicked(EObject value) {
		final ReferenceService referenceService = getReferenceService();
		referenceService.openInNewContext(value);

		// final ISelection selection = new StructuredSelection(value);
		// final IWorkbench wb = PlatformUI.getWorkbench();
		// final IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		// final IWorkbenchPage page = win.getActivePage();
		// final IWorkbenchPart part = page.getActivePart();
		// final IViewPart viewPart = page.findView("org.eclipse.ui.views.PropertySheet");
		//
		// final PropertySheet sheet = (PropertySheet) viewPart;
		// final IPage sheetPage = sheet.getCurrentPage();
		// final PropertySheetPage activePropertysheet = (PropertySheetPage) sheetPage;
		// activePropertysheet.selectionChanged(part, selection);
		// if (sheetPage instanceof PropertySheetPage && sheetPage != null) {
		// System.out.println(" works ");
		// final PropertySheetPage activePropertysheet = (PropertySheetPage) sheetPage;
		// activePropertysheet.selectionChanged(part, selection);
		//
		// }

	}

	protected ReferenceService getReferenceService() {
		if (referenceService == null) {
			referenceService = getViewModelContext().getService(ReferenceService.class);
		}
		return referenceService;
	}

	/**
	 * Returns the link text to be used for the given linked {@code value}.
	 *
	 * @param value the value
	 * @return The link text.
	 * @throws DatabindingFailedException
	 * @throws NoLabelFoundException
	 */
	protected String getText(Object value) {
		final String linkName = adapterFactoryItemDelegator.getText(value);
		return linkName == null ? "" : linkName; //$NON-NLS-1$
	}

	/**
	 * Returns the image to be used for the given linked {@code value}.
	 *
	 * @param value the object for which the image is retrieved
	 * @return the image
	 */
	protected Image getImage(Object value) {
		if (value == null) {
			return null;
		}
		final Object imageDescription = adapterFactoryItemDelegator.getImage(value);
		if (imageDescription == null) {
			return null;
		}
		final Image image = org.eclipse.emf.ecp.edit.internal.swt.SWTImageHelper.getImage(imageDescription);
		return image;
	}

}

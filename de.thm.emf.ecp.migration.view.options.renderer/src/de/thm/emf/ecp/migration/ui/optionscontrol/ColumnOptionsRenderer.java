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
package de.thm.emf.ecp.migration.ui.optionscontrol;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
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
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.impl.ColumnImpl;
import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.ComplexResolveOptions;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.mdde.migration.util.ColumnMigrationUtil;
import de.thm.mdde.migration.view.editor.MigrationCustomEditor;

/**
 * @author Torben
 *
 */
public class ColumnOptionsRenderer extends AbstractControlSWTRenderer<VControl> {

	private final EMFFormsEditSupport emfFormsEditSupport;
	private SWTGridDescription rendererGridDescription;
	private ReferenceService referenceService;
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	private ComposedAdapterFactory composedAdapterFactory;

	private PartiallyResolvable partiallyResolvable;
	private NotAutomaticallyResolvable notAutomaticallyResolvable;

	/**
	 * @param vElement
	 * @param viewContext
	 * @param reportService
	 * @param emfFormsDatabinding
	 * @param emfFormsLabelProvider
	 * @param vtViewTemplateProvider
	 */
	@Inject
	public ColumnOptionsRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService,
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
		// final Color textBgColor = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		// composite.setBackground(textBgColor);

		// try {

		final EObject eobject = getViewModelContext().getDomainModel();
		if (eobject instanceof PartiallyResolvable) {
			partiallyResolvable = (PartiallyResolvable) eobject;

			switch (partiallyResolvable.getDisplayName()) {
			case SET_COLUMN_TYPE:

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {
					final SemanticChangeSet set = partiallyResolvable.getSemanticChangeSets().get(0);

					for (final Change change : set.getChanges()) {
						if (change instanceof AttributeValueChange) {
							final AttributeValueChange avc = (AttributeValueChange) change;
							final Object objA = avc.getObjA();
							final Object objB = avc.getObjB();

							if (objA instanceof Column) {
								final Column columnA = (Column) objA;
								final Column columnB = (Column) objB;

								final List<ColumnOptions> compatibility = ColumnMigrationUtil
									.checkColumnTypeCompatibility(columnA,
										columnB);

								if (compatibility.size() == 0) {
									createComboBoxComponent(composite, compatibility,
										Messages.ColumnOptionsRenderer_TYPE_COMPATIBLE, false);
									return composite;
								}
								createComboBoxComponent(composite, compatibility,
									Messages.ColumnOptionsRenderer_0);

								return composite;

							}

						}

					}

					break;
				}
				break;
			case SET_COLUMN_SIZE: {
				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {
					final SemanticChangeSet set = partiallyResolvable.getSemanticChangeSets().get(0);

					for (final Change change : set.getChanges()) {
						if (change instanceof AttributeValueChange) {
							final AttributeValueChange avc = (AttributeValueChange) change;
							final Object objA = avc.getObjA();
							final Object objB = avc.getObjB();

							if (objA instanceof Column) {
								final Column columnA = (Column) objA;
								final Column columnB = (Column) objB;

								final List<ColumnOptions> compatibility = ColumnMigrationUtil
									.checkColumnSizeCompatibility(columnA,
										columnB);

								if (compatibility.size() == 0) {
									createComboBoxComponent(composite, compatibility,
										Messages.ColumnOptionsRenderer_SIZE_COMPATIBLE,
										false);
									return composite;
								}
								createComboBoxComponent(composite, compatibility,
									Messages.ColumnOptionsRenderer_1);
								return composite;

							}

						}

					}

					break;
				}

			}

				break;
			// case SET_COLUMN_UNIQUE: {TODO Column Unique
			// if (partiallyResolvable.getSemanticChangeSets().size() == 1) {
			// final SemanticChangeSet set = partiallyResolvable.getSemanticChangeSets().get(0);
			//
			// for (final Change change : set.getChanges()) {
			// if (change instanceof AttributeValueChange) {
			// final AttributeValueChange avc = (AttributeValueChange) change;
			// final Object objA = avc.getObjA();
			// final Object objB = avc.getObjB();
			//
			// if (objA instanceof Column) {
			// final Column columnA = (Column) objA;
			// final Column columnB = (Column) objB;
			//
			// final List<ColumnOptions> compatibility = ColumnMigrationUtil
			// .checkColumnUniqueCompatibility(columnA,
			// columnB);
			//
			// if (compatibility.size() == 0) {
			// return composite;
			// }
			// createComboBoxComponent(composite, compatibility,
			// Messages.ColumnOptionsRenderer_UNIQUE_CONSTRAINT);
			// return composite;
			//
			// }
			//
			// }
			//
			// }
			//
			// break;
			// }
			//
			// }
			// break;
			case SET_COLUMN_NOT_NULL: {

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {
					final SemanticChangeSet set = partiallyResolvable.getSemanticChangeSets().get(0);

					for (final Change change : set.getChanges()) {
						if (change instanceof AttributeValueChange) {
							final AttributeValueChange avc = (AttributeValueChange) change;
							final Object objA = avc.getObjA();
							final Object objB = avc.getObjB();

							if (objA instanceof Column) {
								final Column columnA = (Column) objA;
								final Column columnB = (Column) objB;

								final List<ColumnOptions> compatibility = ColumnMigrationUtil
									.checkColumnNotNullCompatibility(columnA,
										columnB);

								if (compatibility.size() == 0) {
									return composite;
								}
								createComboBoxComponent(composite, compatibility,
									Messages.ColumnOptionsRenderer_NOT_NULL);
								return composite;

							}

						}

					}

					break;
				}

			}

			//$FALL-THROUGH$
			case CHANGE_1N_INTO_NM:
			case CHANGE_1N_INTO_NM_PRESERVE:
			case CHANGE_1N_INTO_NM_MOVE: {

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {

					final List<ColumnOptions> compatibility = Arrays.asList(ColumnOptions.IGNORE,
						ColumnOptions.MIGRATE_DATA);

					createComboBoxComponent(composite, compatibility,
						Messages.ColumnOptionsRenderer_DATA_MIGRATE);
					return composite;

				}

				break;

			}

			case CHANGE_NM_INTO_1N: {

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {

					final List<ColumnOptions> compatibility = Arrays.asList(ColumnOptions.IGNORE,
						ColumnOptions.MIGRATE_DATA, ColumnOptions.DELETE_DUBLICATES,
						ColumnOptions.IGNORE_DUBLICATES);

					createComboBoxComponent(composite, compatibility,
						Messages.ColumnOptionsRenderer_DATA_MIGRATE);
					return composite;

				}

				break;

			}

			case CHANGE_NM_INTO_1N_PRESERVE: {

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {

					final List<ColumnOptions> compatibility = Arrays.asList(ColumnOptions.IGNORE,
						ColumnOptions.MIGRATE_DATA, ColumnOptions.IGNORE_DUBLICATES);

					createComboBoxComponent(composite, compatibility,
						Messages.ColumnOptionsRenderer_DATA_MIGRATE);
					return composite;

				}

				break;

			}

			case SET_COLUMN_TYPE_AND_SIZE: {

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {
					final SemanticChangeSet set = partiallyResolvable.getSemanticChangeSets().get(0);

					for (final Change change : set.getChanges()) {
						if (change instanceof AttributeValueChange) {
							final AttributeValueChange avc = (AttributeValueChange) change;
							final Object objA = avc.getObjA();
							final Object objB = avc.getObjB();

							if (objA instanceof Column) {
								final Column columnA = (Column) objA;
								final Column columnB = (Column) objB;

								final List<ColumnOptions> compatibility = ColumnMigrationUtil
									.checkColumnTypeCompatibility(columnA,
										columnB);

								if (compatibility.size() != 0) {
									createComboBoxComponent(composite, compatibility,
										Messages.ColumnOptionsRenderer_0);
									return composite;
								}
								final List<ColumnOptions> compatibility2 = ColumnMigrationUtil
									.checkColumnSizeCompatibility(columnA,
										columnB);
								if (compatibility2.size() != 0) {
									createComboBoxComponent(composite, compatibility2,
										Messages.ColumnOptionsRenderer_0);
									return composite;
								}

								createComboBoxComponent(composite, compatibility,
									Messages.ColumnOptionsRenderer_TYPE_AND_SIZE_COMPATIBLE,
									false);
								return composite;

							}

						}

					}

					break;
				}
				break;
			}
			case CREATE_PRIMARY_KEY: {

				if (partiallyResolvable.getSemanticChangeSets().size() == 1) {

					final List<ColumnOptions> compatibility = Arrays.asList(ColumnOptions.IGNORE,
						ColumnOptions.MIGRATE_DATA, ColumnOptions.SPECIFY_CONDITION_MANUALLY);

					createComboBoxComponent(composite, compatibility,
						Messages.ColumnOptionsRenderer_DATA_MIGRATE);
					return composite;

				}

				break;

			}

			default:
				break;
			}

		} else if (eobject instanceof NotAutomaticallyResolvable) {
			notAutomaticallyResolvable = (NotAutomaticallyResolvable) eobject;
			switch (notAutomaticallyResolvable.getDisplayName()) {
			case JOIN_TABLE: {
				createComboBoxComponent(composite,
					Messages.ColumnOptionsRenderer_DATA_MIGRATE, ComplexResolveOptions.VALUES);
				return composite;
			}
			}

		}

		return composite;

	}

	/**
	 * Creates the custom component with a description and the CCombo.
	 *
	 * @param parent
	 * @param columnOptions
	 * @return
	 */
	private Composite createComboBoxComponent(Composite parent, List<ColumnOptions> columnOptions, String labelString) {
		return createComboBoxComponent(parent, columnOptions, labelString, true);
	}

	/**
	 * Creates the custom component with a description and the CCombo.
	 *
	 * @param parent
	 * @param columnOptions
	 * @return
	 */
	private Composite createComboBoxComponent(Composite parent, String labelString,
		List<ComplexResolveOptions> columnOptions) {
		return createComboBoxComponent(parent, labelString, columnOptions, true);
	}

	/**
	 * Creates the custom component with a description and the CCombo.
	 *
	 * @param parent
	 * @param columnOptions
	 * @return
	 */
	private Composite createComboBoxComponent(Composite parent, List<ColumnOptions> columnOptions, String labelString,
		boolean enabled) {

		final Composite area = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).extendedMargins(0, 0, 0, 10).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

		final Label header = new Label(area, SWT.NONE);
		header.setText(
			labelString);

		GridDataFactory.fillDefaults().span(2, 1).grab(true, false)
			.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(header);

		final Label label = new Label(area, SWT.NONE);
		label.setText(Messages.ColumnOptionsRenderer_2);

		GridDataFactory.fillDefaults().span(1, 1).grab(false, false)
			.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(label);

		final CCombo combo = new CCombo(area, SWT.DROP_DOWN | SWT.BORDER);
		GridDataFactory.fillDefaults().span(1, 1).grab(false, false)
			.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(combo);

		if (enabled) {
			combo.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					final ColumnOptions columnOptions = (ColumnOptions) combo
						.getData(combo.getItem(combo.getSelectionIndex()));
					if (columnOptions != null) {
						partiallyResolvable.eResource().setTrackingModification(true);
						// partiallyResolvable.setResolveOptions(columnOptions);
						// partiallyResolvable.eResource().setModified(true);

						final EditingDomain editingDomain = AdapterFactoryEditingDomain
							.getEditingDomainFor(partiallyResolvable);
						final Command cmd = SetCommand.create(editingDomain, partiallyResolvable,
							MigrationPackage.eINSTANCE.getPartiallyResolvable_ResolveOptions(), columnOptions);
						editingDomain.getCommandStack().execute(cmd);

						final IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.getActiveEditor();

						if (part instanceof MigrationCustomEditor) {
							final MigrationCustomEditor editor = (MigrationCustomEditor) part;
							editor.firePropertyChange(IEditorPart.PROP_DIRTY, true);
						}

					}

				}

			});

			for (int i = 0; i < columnOptions.size(); i++) {

				final ColumnOptions co = columnOptions.get(i);
				combo.add(co.getLiteral(), i);
				combo.setData(co.getLiteral(), co);
				if (partiallyResolvable.getResolveOptions() != null
					&& partiallyResolvable.getResolveOptions().equals(co)) {
					combo.select(i);
				}

			}
		} else {
			label.setEnabled(enabled);
			combo.setEnabled(enabled);
		}
		return area;
	}

	/**
	 * Creates the custom component with a description and the CCombo.
	 *
	 * @param parent
	 * @param columnOptions
	 * @return
	 */
	private Composite createComboBoxComponent(Composite parent, String labelString,
		List<ComplexResolveOptions> columnOptions,
		boolean enabled) {

		final Composite area = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).extendedMargins(0, 0, 0, 10).applyTo(area);
		GridDataFactory.fillDefaults().grab(true, false)
			.align(SWT.FILL, SWT.BEGINNING).applyTo(area);

		final Label header = new Label(area, SWT.NONE);
		header.setText(
			labelString);

		GridDataFactory.fillDefaults().span(2, 1).grab(true, false)
			.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(header);

		final Label label = new Label(area, SWT.NONE);
		label.setText(Messages.ColumnOptionsRenderer_2);

		GridDataFactory.fillDefaults().span(1, 1).grab(false, false)
			.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(label);

		final CCombo combo = new CCombo(area, SWT.DROP_DOWN | SWT.BORDER);
		GridDataFactory.fillDefaults().span(1, 1).grab(false, false)
			.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(combo);

		if (enabled) {
			combo.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					final ComplexResolveOptions columnOptions = (ComplexResolveOptions) combo
						.getData(combo.getItem(combo.getSelectionIndex()));
					if (columnOptions != null) {
						notAutomaticallyResolvable.eResource().setTrackingModification(true);
						// partiallyResolvable.setResolveOptions(columnOptions);
						// partiallyResolvable.eResource().setModified(true);

						final EditingDomain editingDomain = AdapterFactoryEditingDomain
							.getEditingDomainFor(notAutomaticallyResolvable);
						final Command cmd = SetCommand.create(editingDomain, notAutomaticallyResolvable,
							MigrationPackage.eINSTANCE.getNotAutomaticallyResolvable_ResolveOptions(), columnOptions);
						editingDomain.getCommandStack().execute(cmd);

						final IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.getActiveEditor();

						if (part instanceof MigrationCustomEditor) {
							final MigrationCustomEditor editor = (MigrationCustomEditor) part;
							editor.firePropertyChange(IEditorPart.PROP_DIRTY, true);
						}

					}

				}

			});

			for (int i = 0; i < columnOptions.size(); i++) {

				final ComplexResolveOptions co = columnOptions.get(i);
				combo.add(co.getLiteral(), i);
				combo.setData(co.getLiteral(), co);
				if (notAutomaticallyResolvable.getResolveOptions() != null
					&& notAutomaticallyResolvable.getResolveOptions().equals(co)) {
					combo.select(i);
				}

			}
		} else {
			label.setEnabled(enabled);
			combo.setEnabled(enabled);
		}
		return area;
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

			createCompositeForTable(composite, tableA, "Old Value:", eAttribute, "Column in Model A:"); //$NON-NLS-1$ //$NON-NLS-2$
			createCompositeForTable(composite, tableB, "New Value:", eAttribute, "Column in Model B:"); //$NON-NLS-1$ //$NON-NLS-2$

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
			// header.setText(Messages.SemanticChangeSetRenderer_descriptionSetColumDefaultValue);
			final GridData gridData = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
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
		// // header.setText(Messages.SemanticChangeSetRenderer_descriptionMakeColumnUnique);
		// } else {
		// // header.setText(Messages.SemanticChangeSetRenderer_descriptionRemoveColumnUnique);
		// }
		// final GridData gridData = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		// gridData.widthHint = 500;
		// header.setLayoutData(gridData);
		// return;
		// }TODO UNIQUE

		if (MddePackage.eINSTANCE.getColumn_Size().getName().equals(eAttribute.getName())) {
			// final Label header = new Label(composite, SWT.WRAP);
			final Text header = new Text(composite, SWT.WRAP);
			if (ColumnImpl.dateTypesWithFraction.contains(columnA.getType())) {
				// header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSizeDate);
			} else if (ColumnImpl.decimalTypes.contains(columnA.getType())) {
				// header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSizeDecimal);
			} else if (ColumnImpl.textTypes.contains(columnA.getType())) {
				// header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSizeText);
			} else {
				// header.setText(Messages.SemanticChangeSetRenderer_descriptionColumnSize);
			}

			final GridData gridData = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
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

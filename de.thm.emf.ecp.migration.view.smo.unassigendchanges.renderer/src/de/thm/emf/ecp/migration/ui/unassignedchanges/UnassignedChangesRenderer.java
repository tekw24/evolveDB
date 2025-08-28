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
package de.thm.emf.ecp.migration.ui.unassignedchanges;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.inject.Inject;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.edit.spi.ReferenceService;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.AbstractControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;

import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.MigrationPackage;

/**
 * @author Torben
 *
 */
public class UnassignedChangesRenderer extends AbstractControlSWTRenderer<VControl> {

	private final EMFFormsEditSupport emfFormsEditSupport;
	private SWTGridDescription rendererGridDescription;
	private ReferenceService referenceService;
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	private ComposedAdapterFactory composedAdapterFactory;
	private TableViewer viewer;
	private ToolBar toolbar;

	/**
	 * @param vElement
	 * @param viewContext
	 * @param reportService
	 * @param emfFormsDatabinding
	 * @param emfFormsLabelProvider
	 * @param vtViewTemplateProvider
	 */
	@Inject
	public UnassignedChangesRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService,
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

	public EMFFormsEditSupport getEmfFormsEditSupport() {
		return emfFormsEditSupport;
	}

	@Override
	protected Control renderControl(SWTGridCell cell, Composite parent) {
		// Layout wie gehabt …
		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(composite);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(composite);

		// Toolbar
		toolbar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(toolbar);

		// Table
		viewer = new TableViewer(composite,
			SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		final Table table = viewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(true);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).hint(SWT.DEFAULT, 220)
			.applyTo(table);

		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(composedAdapterFactory));
		viewer.setUseHashlookup(true);
		viewer.setInput(getCurrentUnassigned());

		final ToolItem createSetBtn = new ToolItem(toolbar, SWT.PUSH);
		createSetBtn.setText("Neues Set aus Auswahl");
		createSetBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final List<Change> sel = getSelection(viewer);
				if (sel.isEmpty()) {
					return;
				}
				runInCommand(() -> {
					final SymmetricDifference diff = getDiff();
					if (diff == null) {
						return null;
					}

					// TODO[1]: Stelle sicher, dass du hier die korrekte Factory nutzt:
					final SemanticChangeSet scs = SymmetricFactory.eINSTANCE.createSemanticChangeSet();

					// TODO[2]: Füge das SCS in die richtige Containment-Liste des diff ein:
					// z.B.: diff.getChangeSets().add(scs);
					addSCS(diff, scs);

					scs.getChanges().addAll(sel);
					return null;
				});
				refreshViewer(viewer);
			}
		});

		final ToolItem addToExistingBtn = new ToolItem(toolbar, SWT.PUSH);
		addToExistingBtn.setText("Zu bestehendem Set…");
		addToExistingBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final List<Change> sel = getSelection(viewer);
				if (sel.isEmpty()) {
					return;
				}

				final SemanticChangeSet target = pickExistingSCS(toolbar.getShell());
				if (target == null) {
					return;
				}

				runInCommand(() -> {
					target.getChanges().addAll(sel);
					return null;
				});
				refreshViewer(viewer);
			}
		});

		// Live-Refresh bei Modelländerungen
		attachAutoRefreshAdapter(composite, viewer);

		// … Buttons & Listener wie zuvor …

		// WICHTIG: erst JETZT Enable-Status anwenden (wir überschreiben Read-only)
		applyEnable();

		// optional: Fokusierbares Control an EMF Forms melden
		// table.setData("org.eclipse.emfforms.renderer.multiControl.isFocusCandidate", Boolean.TRUE);

		return composite;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer#setControlEnabled(org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell,
	 *      org.eclipse.swt.widgets.Control, boolean)
	 */
	@Override
	protected void setControlEnabled(SWTGridCell gridCell, Control control, boolean enabled) {
		// TODO Auto-generated method stub
		control.setEnabled(true);
	}

	// /** EMF Forms hält das Feature für read-only; wir wollen aber interaktive UI. */
	// @Override
	// protected boolean isEffectivelyReadonly() {
	// return false; // immer interaktiv, unabhängig vom Feature
	// }
	//
	// /** Sage EMF Forms explizit, welche Widgets es (de-)aktivieren soll. */
	// @Override
	// protected java.util.Set<Control> getControlsToEnable() {
	// final java.util.Set<Control> controls = new java.util.HashSet<>();
	// if (toolbar != null && !toolbar.isDisposed()) {
	// controls.add(toolbar);
	// }
	// if (viewer != null && !viewer.getControl().isDisposed()) {
	// controls.add(viewer.getControl());
	// }
	// return controls;
	// }
	//
	// /** Optional: erstes fokusierbares Control liefern (bessere Tastaturnavigation). */
	// @Override
	// protected Control getFirstFocusable() {
	// return viewer != null ? viewer.getTable() : null;
	// }

	@SuppressWarnings("unchecked")
	private List<Change> getCurrentUnassigned() {
		try {
			final Object val = getModelValue().getValue();
			if (val instanceof List<?>) {
				return new ArrayList<>((List<Change>) val);
			}
		} catch (final DatabindingFailedException ex) {
			ex.printStackTrace();
			// reportService.report(ex);
		}
		return new ArrayList<>();
	}

	private List<Change> getSelection(TableViewer viewer) {
		final IStructuredSelection sel = viewer.getStructuredSelection();
		final List<Change> result = new ArrayList<>();
		for (final Object o : sel.toArray()) {
			if (o instanceof Change) {
				result.add((Change) o);
			}
		}
		return result;
	}

	private void refreshViewer(TableViewer viewer) {
		viewer.setInput(getCurrentUnassigned());
		viewer.refresh();
	}

	private EditingDomain getDomain(EObject any) {
		// Bevorzugt: TransactionalEditingDomain (falls verfügbar)
		final TransactionalEditingDomain tx = TransactionUtil.getEditingDomain(any);
		if (tx != null) {
			return tx;
		}

		// Fallback: klassische EditingDomain
		return AdapterFactoryEditingDomain.getEditingDomainFor(any);
	}

	private SymmetricDifference getDiff() {
		final EObject root = getViewModelContext().getDomainModel();
		// DomainModel kann Migration sein – passe ggf. an deinen Typ an:
		if (root instanceof Migration) {
			return ((Migration) root).getSymmetricDifference();
		}
		// Fallback: Suche im selben ResourceSet
		return null;
	}

	// Kapselt Ausführung auf dem CommandStack (undo/redo-fähig)
	private void runInCommand(Supplier<Void> work) {
		final EObject anchor = getViewModelContext().getDomainModel();
		final EditingDomain domain = getDomain(anchor);
		final CommandStack stack = domain.getCommandStack();
		stack.execute(new RecordingCommand(
			(org.eclipse.emf.transaction.TransactionalEditingDomain) domain) {
			@Override
			protected void doExecute() {
				work.get();
			}
		});
	}

	/* ---- Auswahl-Dialog für vorhandene Sets ---- */
	private SemanticChangeSet pickExistingSCS(org.eclipse.swt.widgets.Shell shell) {
		final SymmetricDifference diff = getDiff();
		if (diff == null) {
			return null;
		}

		final List<SemanticChangeSet> allSets = getAllSCS(diff);
		if (allSets.isEmpty()) {
			return null;
		}

		final ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell,
			new AdapterFactoryLabelProvider(composedAdapterFactory));
		dlg.setTitle("Semantic Change Set wählen");
		dlg.setMessage("Bitte ein Set auswählen:");
		dlg.setElements(allSets.toArray());
		if (dlg.open() == org.eclipse.jface.window.Window.OK) {
			final Object res = dlg.getFirstResult();
			if (res instanceof SemanticChangeSet) {
				return (SemanticChangeSet) res;
			}
		}
		return null;
	}

	/* ---- Modell-spezifische Stellen: bitte prüfen/anpassen ---- */

	// fügt SCS in die Containment-Liste des Diff ein
	private void addSCS(SymmetricDifference diff, SemanticChangeSet scs) {
		// TODO[2]: hier die _richtige_ Containment-Referenz verwenden:
		// Beispiel (häufiger Name): diff.getChangeSets().add(scs);
		diff.getChangeSets().add(scs);
	}

	private List<SemanticChangeSet> getAllSCS(SymmetricDifference diff) {
		// TODO[1]: hier ebenso die richtige Getter nutzen
		return new ArrayList<>(diff.getChangeSets());
	}

	// --- Ersetze deine attachAutoRefreshAdapter(...) durch:
	private void attachAutoRefreshAdapter(Composite control, TableViewer viewer) {
		final java.util.concurrent.atomic.AtomicBoolean refreshPending = new java.util.concurrent.atomic.AtomicBoolean(
			false);

		final org.eclipse.emf.common.notify.Adapter refresh = new org.eclipse.emf.common.notify.impl.AdapterImpl() {
			@Override
			public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
				// Nur reagieren, wenn wirklich relevant:
				final Object f = msg.getFeature();
				final boolean relevant = f == MigrationPackage.Literals.MIGRATION__SCHEMA_MODIFICATION_OPERATORS
					|| f == MigrationPackage.Literals.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS
				// Falls du ein Literal für "Changes in SCS" hast, ergänzen:
					|| f instanceof org.eclipse.emf.ecore.EStructuralFeature
						&& ((org.eclipse.emf.ecore.EStructuralFeature) f).getName().equals("changes")
				// oder wenn SymmetricDifference/ChangeSets geändert werden:
					|| msg.getNotifier() instanceof org.sidiff.difference.symmetric.SemanticChangeSet
					|| msg.getNotifier() instanceof org.sidiff.difference.symmetric.SymmetricDifference;

				if (!relevant) {
					return;
				}

				// Coalesced refresh: max. 1 Refresh im UI-Thread zur Zeit
				if (refreshPending.compareAndSet(false, true)) {
					control.getDisplay().asyncExec(() -> {
						try {
							if (control.isDisposed() || viewer.getControl().isDisposed()) {
								return;
							}
							refreshViewerPreserve(viewer);
						} finally {
							refreshPending.set(false);
						}
					});
				}
			}
		};

		// Am Domain-Objekt (z. B. Migration) registrieren
		final org.eclipse.emf.ecore.EObject domain = getViewModelContext().getDomainModel();
		domain.eAdapters().add(refresh);

		control.addListener(org.eclipse.swt.SWT.Dispose, e -> domain.eAdapters().remove(refresh));
	}

	// Erhalte Selektion und Scroll-Position:
	private void refreshViewerPreserve(TableViewer viewer) {
		final org.eclipse.jface.viewers.IStructuredSelection sel = viewer.getStructuredSelection();
		final int topIndex = viewer.getTable().getTopIndex();

		// Nur refresh, KEIN setInput erneut!
		viewer.refresh();

		// Auswahl & Position wiederherstellen
		if (sel != null && !sel.isEmpty()) {
			viewer.setSelection(sel, true);
		}
		if (topIndex >= 0 && topIndex < viewer.getTable().getItemCount()) {
			viewer.getTable().setTopIndex(topIndex);
		}
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

/*******************************************************************************
 * Copyright (c) 2011-2020 EclipseSource Muenchen GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Clemens Elflein - initial API and implementation
 * Johannes Faltermeier - initial API and implementation
 * Christian W. Damus - bugs 545460, 548592, 559116
 ******************************************************************************/

package org.eclipse.emfforms.spi.editor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecp.common.spi.ChildrenDescriptorCollector;
import org.eclipse.emf.ecp.common.spi.UniqueSetting;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.reporting.StatusReport;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emfforms.common.Optional;
import org.eclipse.emfforms.internal.editor.Activator;
import org.eclipse.emfforms.internal.editor.toolbaractions.LoadEcoreAction;
import org.eclipse.emfforms.internal.editor.ui.EditorToolBar;
import org.eclipse.emfforms.internal.swt.treemasterdetail.defaultprovider.DefaultDeleteActionBuilder;
import org.eclipse.emfforms.spi.editor.helpers.ResourceSetHelpers;
import org.eclipse.emfforms.spi.editor.messages.Messages;
import org.eclipse.emfforms.spi.swt.treemasterdetail.MenuProvider;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailComposite;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailMenuListener;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailSWTBuilder;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailSWTFactory;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeViewerBuilder;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.ActionCollector;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.MasterDetailAction;
import org.eclipse.emfforms.spi.swt.treemasterdetail.decorator.validation.ecp.ECPValidationLabelDecoratorProvider;
import org.eclipse.emfforms.spi.swt.treemasterdetail.diagnostic.DiagnosticCache;
import org.eclipse.emfforms.spi.swt.treemasterdetail.diagnostic.DiagnosticCache.ValidationListener;
import org.eclipse.emfforms.spi.swt.treemasterdetail.util.CreateElementCallback;
import org.eclipse.emfforms.spi.swt.treemasterdetail.util.DetailPanelRenderingFinishedCallback;
import org.eclipse.emfforms.spi.swt.treemasterdetail.util.RootObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.EditorPart;

/**
 * The Class GenericEditor it is the generic part for editing any EObject.
 */
public class GenericEditor extends EditorPart implements IEditingDomainProvider, IGotoMarker {

	private static final String GENERIC_EDITOR_CONTEXT = "org.eclipse.emfforms.editor.context"; //$NON-NLS-1$

	private static final String FRAGMENT_URI = "FRAGMENT_URI"; //$NON-NLS-1$

	private static final String RESOURCE_URI = "RESOURCE_URI"; //$NON-NLS-1$

	private static final String FEATURE_URI = "FEATURE_URI"; //$NON-NLS-1$

	private static final String ITOOLBAR_ACTIONS_ID = "org.eclipse.emfforms.editor.toolbarActions"; //$NON-NLS-1$

	/** The Resource loaded from the provided EditorInput. */
	private ResourceSet resourceSet;

	/** The command stack. It is used to mark the editor as dirty as well as undo/redo operations */
	private final BasicCommandStack commandStack = new BasicCommandStack();

	/** The root view. It is the main Editor panel. */
	private TreeMasterDetailComposite rootView;

	/**
	 * True, if there were changes in the filesystem while the editor was in the background and the changes could not be
	 * applied to current view.
	 */
	private boolean filesChangedWithConflict;

	private final IPartListener partListener = new GenericEditorActivationListener();

	private final IResourceChangeListener resourceChangeListener = new GenericEditorResourceChangeListener();

	private final MarkerHelper markerHelper = new GenericEditorMarkerHelper();

	private final AtomicReference<Job> markerJob = new AtomicReference<>();

	private DiagnosticCache cache;

	private boolean reloading;

	private boolean closing;

	/**
	 * @return the {@link DiagnosticCache}. may be <code>null</code>
	 * @since 1.10
	 */
	protected DiagnosticCache getDiagnosticCache() {
		return cache;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Remove the Listener, so that we won't get a changed notification for our own save operation
		preSave();
		if (ResourceSetHelpers.save(resourceSet, getResourceSaveOptions())) {
			// Tell the CommandStack, that we have saved the file successfully
			// and inform the Workspace, that the Dirty property has changed.
			getCommandStack().saveIsDone();
			firePropertyChange(PROP_DIRTY);
			filesChangedWithConflict = false;
		}
		// Add the listener again, so that we get notifications for future changes
		postSave();
	}

	/**
	 * Executes the code which needs to be executed before a save, e.g. removing listeners.
	 *
	 * @since 1.10
	 */
	protected void preSave() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
	}

	/**
	 * Executes the code which needs to be executed after a save, e.g. readding listeners.
	 *
	 * @since 1.10
	 */
	protected void postSave() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
	}

	/**
	 * Handles filesystem changes.
	 *
	 * @param changedResources A List of changed Resources
	 * @param removedResources A List of removed Resources
	 */
	protected void handleResourceChange(final Collection<Resource> changedResources,
		final Collection<Resource> removedResources) {
		if (!isDirty()) {
			getSite().getShell().getDisplay().asyncExec(() -> {
				if (resourceSet == null || rootView.isDisposed()) {
					return;
				}
				reloading = true;
				removeResources(removedResources);

				// We need to get every changed resource by its URI from the resource set because otherwise proxies will
				// not be able to resolve after the reload. This is the case because the given resources are not
				// part of this editor's resource set.
				final List<Resource> toReload = changedResources.stream()
					.map(changed -> resourceSet.getResource(changed.getURI(), false))
					.filter(Objects::nonNull)
					.collect(Collectors.toList());

				reloadResources(toReload);
				reloading = false;
				getCommandStack().flush();
				initMarkers();
			});
		} else {
			filesChangedWithConflict = true;
		}
	}

	/**
	 * Reloads the given resources and refreshes the tree accordingly.
	 *
	 * @param resources The {@link Resource Resources} to reload
	 * @since 1.22
	 */
	protected void reloadResources(Collection<Resource> resources) {
		for (final Resource r : resources) {
			r.unload();
			try {
				r.load(getResourceLoadOptions());
			} catch (final IOException e) {
			}
		}
		ResourceSetHelpers.resolveAllProxies(resourceSet);
		refreshTreeAfterResourceChange();
	}

	/**
	 * Called after a resource change to refresh the tree master detail of the editor. By default only the tree is
	 * refreshed. If the tree's input is not this editor's resource but only derived from it, this method should be
	 * overridden to reset the tree's input.
	 *
	 * @since 1.22
	 */
	protected void refreshTreeAfterResourceChange() {
		rootView.refresh();
	}

	private boolean discardChanges() {
		return MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
			Messages.GenericEditor_DiscardChangesTitle,
			Messages.GenericEditor_DiscardChangesDescription);
	}

	@Override
	public void doSaveAs() {
		final SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		final int result = saveAsDialog.open();
		if (result == Window.OK) {
			final IPath path = saveAsDialog.getResult();
			setPartName(path.lastSegment());
			resourceSet.getResources().get(0)
				.setURI(URI.createFileURI(path.toOSString()));
			doSave(null);
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
		throws PartInitException {
		setSite(site);
		setInput(input);

		// Set the Title for this Editor to the Name of the Input (= Filename)
		setPartName(input.getName());

		// As soon as the resource changed, we inform the Workspace, that it is
		// now dirty
		getCommandStack().addCommandStackListener(new CommandStackListener() {
			@Override
			public void commandStackChanged(EventObject event) {
				GenericEditor.this.firePropertyChange(PROP_DIRTY);
			}
		});

		site.getPage().addPartListener(partListener);

		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
		// Load the resource from the provided input and display the editor
		resourceSet = loadResource(getEditorInput());
	}

	/**
	 * Returns the context id set for this editor.
	 *
	 * @return the context id
	 */
	protected String getContextId() {
		return GENERIC_EDITOR_CONTEXT;
	}

	@Override
	public boolean isDirty() {
		return getCommandStack().isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
		parent.setBackgroundMode(SWT.INHERIT_FORCE);

		final Object editorInput = modifyEditorInput(resourceSet);
		if (enableValidation()) {
			setupDiagnosticCache(editorInput);
			getDiagnosticCache().registerValidationListener(new MarkerValidationListener());
		}
		rootView = createRootView(parent, getEditorTitle(), editorInput, getToolbarActions(),
			getCreateElementCallback());

		initMarkers();

		// We need to set the selectionProvider for the editor, so that the EditingDomainActionBarContributor
		// knows the currently selected object to copy/paste
		getEditorSite().setSelectionProvider(rootView.getMasterDetailSelectionProvider());
	}

	private synchronized void initMarkers() {
		if (getDiagnosticCache() == null || reloading) {
			return;
		}
		final Job oldJob = markerJob.get();
		if (oldJob != null) {
			oldJob.cancel();
			markerJob.compareAndSet(oldJob, null);
		}

		final Job job = Job.create(Messages.GenericEditor_ValidationMarkersJobName, monitor -> {
			try {
				adjustMarkers(monitor);
				return Status.OK_STATUS;
			} catch (final CoreException ex) {
				return ex.getStatus();
			} finally {
				markerJob.compareAndSet(Job.getJobManager().currentJob(), null);
			}
		});
		job.setPriority(Job.LONG);

		if (markerJob.compareAndSet(null, job)) {
			job.schedule(500);
		}
	}

	private synchronized void adjustMarkers(IProgressMonitor monitor) throws CoreException {
		if (monitor.isCanceled() || reloading) {
			return;
		}
		deleteMarkers();
		for (final Object o : getDiagnosticCache().getObjects()) {
			try {
				if (monitor.isCanceled() || reloading) {
					return;
				}
				final Diagnostic value = getDiagnosticCache().getOwnValue(o);
				if (value.getSeverity() < Diagnostic.WARNING) {
					continue;
				}
				markerHelper.createMarkers(value);
			} catch (final CoreException ex) {
				/* silent */
			}
		}
	}

	/**
	 * Deletes the problem markers created by this Editor. <b>Please take care that this method should be called from a
	 * {@link Job}</b> to avoid problems with a locked index.
	 *
	 * @throws CoreException if the method fails
	 * @since 1.10
	 */
	protected void deleteMarkers() throws CoreException {
		final Optional<IFile> file = getFile();
		if (!file.isPresent()) {
			return;
		}
		markerHelper.deleteMarkers(file.get());
	}

	/**
	 * Get the Notifier from the tree input.
	 *
	 * @param editorInput The editor input to transform
	 * @return {@link Notifier}
	 * @throws IllegalStateException if the editor input is not a Notifier
	 */
	protected Notifier getNotifierFromEditorInput(Object editorInput) {
		Object input = editorInput;
		if (input instanceof RootObject) {
			input = ((RootObject) input).getRoot();
		}
		if (!Notifier.class.isInstance(input)) {
			throw new IllegalStateException("The editor input is not a Notifier!"); //$NON-NLS-1$
		}
		return (Notifier) input;
	}

	private void setupDiagnosticCache(Object editorInput) {
		cache = createDiangosticCache(getNotifierFromEditorInput(editorInput));
	}

	/**
	 * Creates the diagnostic cache.
	 *
	 * @param input the input
	 * @return the cache
	 * @since 1.10
	 */
	protected DiagnosticCache createDiangosticCache(final Notifier input) {
		return new DiagnosticCache(input);
	}

	/**
	 * @return whether a diagnostic cache should be managed.
	 * @since 1.10
	 */
	protected boolean enableValidation() {
		return false;
	}

	/**
	 * Creates the top area of the editor.
	 *
	 * @param parent The parent {@link Composite}
	 * @param editorTitle The title of the editor
	 * @param editorInput the editor input
	 * @param toolbarActions The actions shown on the top area
	 * @param createElementCallback a call back if elements are created
	 * @return a {@link TreeMasterDetailComposite}
	 * @since 1.14
	 */
	protected TreeMasterDetailComposite createRootView(Composite parent, String editorTitle, Object editorInput,
		List<Action> toolbarActions, CreateElementCallback createElementCallback) {
		final Composite composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new FormLayout());

		final FormData toolbarLayoutData = new FormData();
		toolbarLayoutData.left = new FormAttachment(0);
		toolbarLayoutData.right = new FormAttachment(100);
		toolbarLayoutData.top = new FormAttachment(0);
		final EditorToolBar toolbar = new EditorToolBar(composite, SWT.NONE, editorTitle, toolbarActions);
		toolbar.setLayoutData(toolbarLayoutData);

		final FormData treeMasterDetailLayoutData = new FormData();
		treeMasterDetailLayoutData.top = new FormAttachment(toolbar, 5);
		treeMasterDetailLayoutData.left = new FormAttachment(0);
		treeMasterDetailLayoutData.right = new FormAttachment(100);
		treeMasterDetailLayoutData.bottom = new FormAttachment(100);
		final TreeMasterDetailComposite treeMasterDetail = createTreeMasterDetail(composite, editorInput,
			createElementCallback);
		treeMasterDetail.setLayoutData(treeMasterDetailLayoutData);

		for (final Action action : toolbarActions) {
			if (action instanceof IEditingDomainAware) {
				((IEditingDomainAware) action).setEditingDomain(getEditingDomain());
			}
		}
		return treeMasterDetail;
	}

	/**
	 * Returns the root composite containing the tree and the detail view. This is null before the editor control is
	 * created.
	 *
	 * @return The root {@link TreeMasterDetailComposite} of this editor
	 * @since 1.20
	 */
	protected TreeMasterDetailComposite getRootView() {
		return rootView;
	}

	/**
	 * This method creates a tree master detail. Override this method if you want to customize the tree.
	 *
	 * @param composite the parent composite
	 * @param editorInput the editor input
	 * @param createElementCallback the create element callback to add
	 *
	 * @return the {@link TreeMasterDetailComposite}
	 */
	protected TreeMasterDetailComposite createTreeMasterDetail(
		final Composite composite,
		Object editorInput,
		final CreateElementCallback createElementCallback) {
		final TreeMasterDetailSWTBuilder builder = TreeMasterDetailSWTFactory
			.fillDefaults(composite, SWT.NONE, editorInput)
			.customizeCildCreation(createElementCallback)
			.customizeMenu(new MenuProvider() {
				@Override
				public Menu getMenu(TreeViewer treeViewer, EditingDomain editingDomain) {
					final MenuManager menuMgr = new MenuManager();
					menuMgr.setRemoveAllWhenShown(true);
					final List<MasterDetailAction> masterDetailActions = ActionCollector.newList()
						.addCutAction(editingDomain).addCopyAction(editingDomain).addPasteAction(editingDomain)
						.getList();
					menuMgr.addMenuListener(new TreeMasterDetailMenuListener(new ChildrenDescriptorCollector(), menuMgr,
						treeViewer, editingDomain, masterDetailActions, createElementCallback,
						new DefaultDeleteActionBuilder()));
					final Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
					return menu;

				}
			})
			.customizeTree(createTreeViewerBuilder())
			.customizeReadOnly(!isEditable(getEditorInput()));

		if (enableValidation()) {
			builder.customizeLabelDecorator(
				new ECPValidationLabelDecoratorProvider(getNotifierFromEditorInput(editorInput), getDiagnosticCache()));
		}

		final TreeMasterDetailComposite treeMasterDetail = customizeTree(builder).create();
		treeMasterDetail.registerDetailPanelRenderingFinishedCallback(
			DetailPanelRenderingFinishedCallback.adapt((ctx, __) -> handleDetailActivated(ctx)));
		return treeMasterDetail;
	}

	/**
	 * Create the {@link TreeViewerBuilder} customization which creates the tree for the editor's tree master detail.
	 * <p>
	 * Clients can override this to customize the tree viewer.
	 *
	 * @return the {@link TreeViewerBuilder} which creates the tree viewer for the editor's tree master detail
	 * @since 1.20
	 */
	protected TreeViewerBuilder createTreeViewerBuilder() {
		return parent -> {
			final TreeViewer treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.BORDER);
			treeViewer.setAutoExpandLevel(3);
			treeViewer.getTree().addFocusListener(new FocusListener() {
				private IContextActivation activation;

				@Override
				public void focusLost(FocusEvent e) {
					getSite().getService(IContextService.class).deactivateContext(activation);
				}

				@Override
				public void focusGained(FocusEvent e) {
					activation = getSite().getService(IContextService.class).activateContext(getContextId());
				}
			});
			return treeViewer;
		};
	}

	/**
	 * Allows to modify the input object for the editor.
	 *
	 * @param resourceSet the resourceSet which is the default editor input
	 * @return the object to set as the input
	 */
	protected Object modifyEditorInput(ResourceSet resourceSet) {
		return resourceSet;
	}

	/**
	 * Creates a resource set and loads all required resources for the editor input.
	 *
	 * @param editorInput the editor input
	 * @return the resource set
	 * @throws PartInitException if the resource could not be loaded
	 */
	protected ResourceSet loadResource(IEditorInput editorInput) throws PartInitException {
		ResourceSet resourceSet = ResourceSetHelpers.createResourceSet(getCommandStack());
		final URI resourceURI = EditUIUtil.getURI(editorInput, resourceSet.getURIConverter());

		try {
			resourceSet = ResourceSetHelpers.loadResourceWithProxies(resourceURI, resourceSet,
				getResourceLoadOptions());
			verifyEditorResource(resourceURI, resourceSet);
			return resourceSet;
			// CHECKSTYLE.OFF: IllegalCatch
		} catch (final Exception e) {
			throw new PartInitException(e.getLocalizedMessage(), e);
		}
		// CHECKSTYLE.ON: IllegalCatch
	}

	/**
	 * Returns whether the editor input allows editing of its contents.
	 *
	 * @param editorInput the editor's {@link IEditorInput}
	 * @return <code>true</code> if the input source allows editing, <code>false</code> otherwise
	 * @since 1.22
	 */
	protected boolean isEditable(IEditorInput editorInput) {
		// Only allow editing data if it can be persisted
		return editorInput.getPersistable() != null;
	}

	/**
	 * Check that the resource was loaded correctly and show any warnings to the user.
	 *
	 * @param resourceSet the resource set
	 * @param resourceURI the URI of the resource
	 * @since 1.19
	 *
	 */
	protected void verifyEditorResource(URI resourceURI, ResourceSet resourceSet) {
		final Resource resource = resourceSet.getResource(resourceURI, true);
		if (XMLResource.class.isInstance(resource)
			&& !XMLResource.class.cast(resource).getEObjectToExtensionMap().isEmpty()) {
			// we are showing a view which wasn't fully loaded
			MessageDialog
				.openWarning(
					getSite().getShell(),
					Messages.GenericEditor_UnknownFeaturesDialogTitle,
					Messages.GenericEditor_UnknownFeaturesDialogDescription);
		}
	}

	/**
	 * The options to be used when loading the editor's resource.
	 *
	 * @return the load options
	 * @since 1.19
	 */
	protected Map<Object, Object> getResourceLoadOptions() {
		final HashMap<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
			Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		return options;
	}

	/**
	 * The options to be used when saving the editor's resource.
	 *
	 * @return the save options
	 * @since 1.19
	 */
	protected Map<Object, Object> getResourceSaveOptions() {
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		return saveOptions;
	}

	@Override
	public void setFocus() {
		// NOOP
	}

	/**
	 * Returns true, if the editor should have shortcuts.
	 *
	 * @return true, if the editor has shortcuts
	 */
	protected boolean hasShortcuts() {
		return false;
	}

	/**
	 * Returns the title for the currently displayed editor.
	 * Subclasses should override this function to change the Editor's title
	 *
	 * @return the title
	 */
	protected String getEditorTitle() {
		return Messages.GenericEditor_EditorTitle;
	}

	/**
	 * Returns the createElementCallback for this editor. By default, there is none.
	 *
	 * @return the callback
	 */
	protected CreateElementCallback getCreateElementCallback() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditingDomain getEditingDomain() {
		if (rootView == null) {
			return null;
		}
		return rootView.getEditingDomain();
	}

	/**
	 * Returns the toolbar actions for this editor.
	 *
	 * @return A list of actions to show in the Editor's Toolbar
	 * @since 1.10
	 */
	protected List<Action> getToolbarActions() {
		final List<Action> result = new LinkedList<Action>();
		if (!isEditable(getEditorInput())) {
			// If the input isn't editable, toolbar actions are disabled
			return result;
		}

		result.add(new LoadEcoreAction(resourceSet));

		result.addAll(readToolbarActions());
		return result;
	}

	/**
	 * Read toolbar actions from all extensions.
	 *
	 * @return the Actions registered via extension point
	 * @since 1.10
	 */
	protected List<Action> readToolbarActions() {
		final List<Action> result = new LinkedList<Action>();

		final ISelectionProvider selectionProvider = new GenericEditorSelectionProvider();

		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry == null) {
			return result;
		}

		final IConfigurationElement[] config = registry.getConfigurationElementsFor(ITOOLBAR_ACTIONS_ID);
		for (final IConfigurationElement e : config) {
			try {
				final Object o = e.createExecutableExtension("toolbarAction"); //$NON-NLS-1$
				if (o instanceof IToolbarAction) {
					final IToolbarAction action = (IToolbarAction) o;
					if (!action.canExecute(resourceSet)) {
						continue;
					}

					result.add(action.getAction(resourceSet, selectionProvider));
				}
			} catch (final CoreException ex) {
				Activator.getDefault().getReportService().report(
					new StatusReport(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex)));
			}
		}
		return result;
	}

	/**
	 * Returns the ResouceSet of this Editor.
	 *
	 * @return The resource set
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public void dispose() {
		if (getDiagnosticCache() != null) {
			getDiagnosticCache().dispose();
		}
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		getSite().getPage().removePartListener(partListener);
		super.dispose();
	}

	private Optional<IFile> getFile() {
		final IEditorInput input = GenericEditor.this.getEditorInput();
		if (isEditable(getEditorInput()) && IFileEditorInput.class.isInstance(input)) {
			return Optional.of(IFileEditorInput.class.cast(input).getFile());
		}
		return Optional.empty();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.ide.IGotoMarker#gotoMarker(org.eclipse.core.resources.IMarker)
	 * @since 1.10
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		try {
			EObject eObject = null;
			EStructuralFeature feature = null;

			final String resourceURI = (String) marker.getAttribute(RESOURCE_URI);
			final String fragmentURI = (String) marker.getAttribute(FRAGMENT_URI);
			if (resourceURI != null && fragmentURI != null) {
				final Resource resource = getEditingDomain().getResourceSet().getResource(URI.createURI(resourceURI),
					true);
				eObject = resource.getEObject(fragmentURI);

				final String featureURI = marker.getAttribute(FEATURE_URI, null);
				if (featureURI != null) {
					// Don't load on demand because this should be a delegated look-up in the package registry
					// or else find the Ecore resource already loaded to resolve our model's schema
					final EObject featureObject = getEditingDomain().getResourceSet().getEObject(
						URI.createURI(featureURI),
						false);
					if (featureObject instanceof EStructuralFeature) {
						feature = (EStructuralFeature) featureObject;
					}
				}
			} else {
				// Maybe it's an EMF-standard marker?
				final List<?> targets = markerHelper.getTargetObjects(getEditingDomain(), marker, false);
				for (final Object next : targets) {
					if (next instanceof EObject) {
						if (eObject == null) {
							eObject = (EObject) next;
						} else if (feature == null && next instanceof EStructuralFeature) {
							feature = (EStructuralFeature) next;
						}
					}
				}
			}

			if (eObject == null) {
				// Nothing to navigate to
				return;
			}

			if (feature == null) {
				reveal(eObject);
			} else {
				reveal(UniqueSetting.createSetting(eObject, feature));
			}
		} catch (final CoreException ex) {
			// silent
		}
	}

	/**
	 * The given element will be revealed in the tree of the editor.
	 *
	 * @param objectToReveal the object to reveal
	 * @since 1.10
	 */
	public void reveal(EObject objectToReveal) {
		rootView.refresh();
		rootView.selectAndReveal(objectToReveal);
	}

	/**
	 * Reveal the control that edits a {@code setting} of some object.
	 *
	 * @param setting the feature setting to reveal of object
	 * @since 1.22
	 */
	public void reveal(UniqueSetting setting) {
		rootView.refresh();
		rootView.selectAndReveal(setting);
	}

	/**
	 * @return the commandStack the {@link
	 *         import org.eclipse.emf.common.command.CommandStack;}
	 * @since 1.10
	 */
	protected BasicCommandStack getCommandStack() {
		return commandStack;
	}

	/**
	 * Override this method to set additional attributes on the given {@link IMarker}, e.g. location information.
	 *
	 * @param marker the {@link IMarker} to adjust
	 * @param diagnostic the {@link Diagnostic}
	 * @return <code>true</code> if the marker was changed, <code>false</code> otherwise
	 * @throws CoreException in case of an error
	 * @since 1.10
	 */
	protected boolean adjustErrorMarker(IMarker marker, Diagnostic diagnostic) throws CoreException {
		final List<?> data = diagnostic.getData();
		if (data.size() < 1) {
			return false;
		}
		if (!EObject.class.isInstance(data.get(0))) {
			return false;
		}
		final EObject eObject = EObject.class.cast(data.get(0));
		if (eObject.eResource() == null) {
			/* possible when job still running but getting closed */
			return false;
		}
		final EStructuralFeature feature = data.subList(1, data.size()).stream()
			.filter(EStructuralFeature.class::isInstance).map(EStructuralFeature.class::cast)
			.findFirst().orElse(null);
		final String uri = eObject.eResource().getURI().toString();
		final String uriFragment = eObject.eResource().getURIFragment(eObject);
		marker.setAttribute(RESOURCE_URI, uri);
		marker.setAttribute(FRAGMENT_URI, uriFragment);
		if (feature != null) {
			marker.setAttribute(FEATURE_URI, String.valueOf(EcoreUtil.getURI(feature)));
		}
		return true;
	}

	/**
	 * Returns whether this editor is currently in the process of shutting down.
	 *
	 * @return <code>true</code> if the editor is currently closing, <code>false</code> otherwise
	 * @since 1.18
	 */
	protected boolean isClosing() {
		return closing;
	}

	/**
	 * Set whether this editor is currently in the process of shutting down.
	 * Set this flag in case you will close the editor.
	 *
	 * @param closing Whether the editor is currently closing (shutting down)
	 * @since 1.18
	 */
	protected void setClosing(boolean closing) {
		this.closing = closing;
	}

	/**
	 * Removes the given {@linkplain Resource Resources} from this editor's {@linkplain ResourceSet}. Thereby the
	 * resources are matched by URI.
	 *
	 * @param resources The {@linkplain Resource Resources} to remove from this editor's {@linkplain ResourceSet}.
	 * @since 1.18
	 */
	protected void removeResources(final Collection<Resource> resources) {
		for (final Resource removed : resources) {
			final Resource toRemove = resourceSet.getResource(removed.getURI(), false);
			if (toRemove != null) {
				resourceSet.getResources().remove(toRemove);
			}
		}
	}

	/**
	 * Customize the tree {@code builder}. Subclasses are free to add
	 * customizations or override default customizations installed by this
	 * class, but the latter requires care not to break expected editor
	 * behaviour.
	 *
	 * @param builder the tree builder
	 * @return the {@code builder} for convenience of call chaining, or if
	 *         absolutely necessary an entirely new builder
	 *
	 * @since 1.24
	 */
	protected TreeMasterDetailSWTBuilder customizeTree(TreeMasterDetailSWTBuilder builder) {
		return builder;
	}

	/**
	 * React to the rendering or re-activation of a detail context. The default
	 * implementation does nothing; subclasses may just override it.
	 *
	 * @param detailContext the active detail context
	 *
	 * @since 1.24
	 */
	protected void handleDetailActivated(ViewModelContext detailContext) {
		// Nothing to do
	}

	/**
	 * Listens to part events.
	 *
	 */
	private final class GenericEditorActivationListener implements IPartListener {
		@Override
		public void partOpened(IWorkbenchPart part) {
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
		}

		@Override
		public void partClosed(IWorkbenchPart part) {
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
		}

		@Override
		public void partActivated(IWorkbenchPart part) {
			if (!isClosing() && part == GenericEditor.this && isDirty() && filesChangedWithConflict
				&& discardChanges()) {
				reloading = true;
				reloadResources(resourceSet.getResources());
				reloading = false;
				getCommandStack().flush();
				initMarkers();
				firePropertyChange(PROP_DIRTY);
				filesChangedWithConflict = false;
			}
		}
	}

	/**
	 * Reacts to revalidation changes and creates/removes marker accordingly.
	 *
	 * @author Johannes Faltermeier
	 *
	 */
	private final class MarkerValidationListener implements ValidationListener {
		@Override
		public void revalidationOccurred(final Collection<EObject> object, boolean potentialStructuralChange) {
			initMarkers();
		}
	}

	/**
	 * {@link MarkerHelper} for this editor.
	 *
	 * @author Johannes Faltermeier
	 *
	 */
	private final class GenericEditorMarkerHelper extends EditUIMarkerHelper {
		@Override
		public IFile getFile(Diagnostic diagnostic) {
			final Optional<IFile> file = GenericEditor.this.getFile();
			if (file.isPresent()) {
				return file.get();
			}
			return super.getFile(diagnostic);
		}

		@Override
		protected boolean adjustMarker(IMarker marker, Diagnostic diagnostic) throws CoreException {
			return adjustErrorMarker(marker, diagnostic);
		}
	}

	/**
	 * The GenericEditorResourceChangeListener listens for changes in currently opened Ecore files and reports
	 * them to the EcoreEditor.
	 */
	private final class GenericEditorResourceChangeListener implements IResourceChangeListener {

		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			final Collection<Resource> changedResources = new ArrayList<Resource>();
			final Collection<Resource> removedResources = new ArrayList<Resource>();
			final IResourceDelta delta = event.getDelta();

			if (delta == null) {
				return;
			}

			try {
				delta.accept(new GenericEditorResourceDeltaVisitor(removedResources, changedResources));
			} catch (final CoreException ex) {
				Activator.getDefault().getReportService().report(
					new StatusReport(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex)));
			}
			if (changedResources.isEmpty() && removedResources.isEmpty()) {
				return;
			}
			handleResourceChange(changedResources, removedResources);
		}
	}

	/**
	 * The delata visitor deciding if changes are relevant for reloading.
	 */
	private final class GenericEditorResourceDeltaVisitor implements IResourceDeltaVisitor {
		private final Collection<Resource> removedResources;
		private final Collection<Resource> changedResources;

		GenericEditorResourceDeltaVisitor(Collection<Resource> removedResources,
			Collection<Resource> changedResources) {
			this.removedResources = removedResources;
			this.changedResources = changedResources;
		}

		@Override
		public boolean visit(final IResourceDelta delta) {
			if ((delta.getFlags() & IResourceDelta.MARKERS) != 0) {
				return false;
			}
			if (delta.getResource().getType() == IResource.FILE
				&& (delta.getKind() == IResourceDelta.REMOVED ||
					delta.getKind() == IResourceDelta.CHANGED)) {
				final ResourceSet resourceSet = getResourceSet();
				if (resourceSet == null) {
					return false;
				}
				Resource resource = null;

				final URI uri = URI.createPlatformResourceURI(delta.getFullPath().toString(), true);
				resource = resourceSet.getResource(uri, false);
				if (resource == null) {
					try {
						final URL fileURL = FileLocator.resolve(new URL(uri.toString()));
						resource = resourceSet.getResource(URI.createFileURI(fileURL.getPath()), false);
					} catch (final IOException ex) {
						return false;
					}
				}

				if (resource != null) {
					if (delta.getKind() == IResourceDelta.REMOVED) {
						removedResources.add(resource);
					} else {
						changedResources.add(resource);
					}
				}
				return false;
			}
			return true;
		}
	}

	/** Selection Provider for the GenericEditor. */
	private class GenericEditorSelectionProvider implements ISelectionProvider {

		@Override
		public void setSelection(ISelection selection) {
			if (rootView == null) {
				return;
			}
			rootView.getMasterDetailSelectionProvider().setSelection(selection);
		}

		@Override
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			if (rootView == null) {
				return;
			}
			rootView.getMasterDetailSelectionProvider().removeSelectionChangedListener(listener);
		}

		@Override
		public ISelection getSelection() {
			if (rootView == null) {
				return StructuredSelection.EMPTY;
			}
			return rootView.getMasterDetailSelectionProvider().getSelection();
		}

		@Override
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			if (rootView == null) {
				return;
			}
			rootView.getMasterDetailSelectionProvider().addSelectionChangedListener(listener);
		}
	}
}

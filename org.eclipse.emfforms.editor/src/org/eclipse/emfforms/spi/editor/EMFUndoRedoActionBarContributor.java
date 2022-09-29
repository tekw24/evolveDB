/**
 * Copyright (c) 2002-2006 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * IBM - Initial API and implementation
 * Eugen Neufeld - Left only Undo and Redo actions
 */
package org.eclipse.emfforms.spi.editor;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;

/**
 * This is a contributor for an editor, multi-page or otherwise,
 * that implements {@link IEditingDomainProvider}.
 * It automatically hooks up the Undo, Redo actions on the Edit menu
 * to the corresponding commands supported by the {@link org.eclipse.emf.edit.domain.EditingDomain}.
 * The actions are also refreshed every time the editor fires to its {@link IPropertyListener}s.
 * <p>
 * Another very useful feature of this contributor is that it can be used as follows:
 *
 * <pre>
 * ((IMenuListener) ((IEditorSite) getSite()).getActionBarContributor()).menuAboutToShow(menuManager);
 * </pre>
 *
 * to contribute the Edit menu actions to a pop-up menu.
 *
 *
 */
// REUSED CLASS
public class EMFUndoRedoActionBarContributor
	extends
	MultiPageEditorActionBarContributor
	implements
	IMenuListener,
	IPropertyListener {
	/**
	 * This keeps track of the current editor part.
	 */
	protected IEditorPart activeEditor;

	/**
	 * This is the action used to implement undo.
	 */
	protected UndoAction undoAction;

	/**
	 * This is the action used to implement redo.
	 */
	protected RedoAction redoAction;

	/**
	 * This is the action used to perform validation.
	 */
	protected ValidateAction validateAction;

	/**
	 * This is the action used to perform validation.
	 *
	 * @since 2.9
	 */
	protected DiagnosticDecorator.LiveValidator.LiveValidationAction liveValidationAction;

	/**
	 * This style bit indicates that the "additions" separator should come after the "edit" separator.
	 */
	public static final int ADDITIONS_LAST_STYLE = 0x1;

	/**
	 * This is used to encode the style bits.
	 */
	protected int style;

	/**
	 * This creates an instance of the contributor.
	 */
	public EMFUndoRedoActionBarContributor() {
		super();
	}

	/**
	 * This creates an instance of the contributor.
	 */
	public EMFUndoRedoActionBarContributor(int style) {
		super();
		this.style = style;
	}

	@Override
	public void init(IActionBars actionBars) {
		super.init(actionBars);
		final ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

		undoAction = createUndoAction();
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);

		redoAction = createRedoAction();
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}

	/**
	 * Returns the action used to implement undo.
	 *
	 * @see #undoAction
	 * @since 2.6
	 */
	protected UndoAction createUndoAction() {
		return new UndoAction();
	}

	/**
	 * Returns the action used to implement redo.
	 *
	 * @see #redoAction
	 * @since 2.6
	 */
	protected RedoAction createRedoAction() {
		return new RedoAction();
	}

	/**
	 * This determines whether or not the delete action should clean up all references to the deleted objects.
	 * It is false by default, to provide the same beahviour, by default, as in EMF 2.1 and before.
	 * You should probably override this method to return true, in order to get the new, more useful beahviour.
	 *
	 * @since 2.2
	 */
	protected boolean removeAllReferencesOnDelete() {
		return false;
	}

	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);
	}

	@Override
	public void contributeToStatusLine(IStatusLineManager statusLineManager) {
		super.contributeToStatusLine(statusLineManager);
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
	}

	public void shareGlobalActions(IPage page, IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}

	/**
	 * @deprecated
	 */
	@Deprecated
	public void setActiveView(IViewPart part) {
		final IActionBars actionBars = part.getViewSite().getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);

		actionBars.updateActionBars();
	}

	public IEditorPart getActiveEditor() {
		return activeEditor;
	}

	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);

		if (part != activeEditor) {
			if (activeEditor != null) {
				deactivate();
			}

			if (part instanceof IEditingDomainProvider) {
				activeEditor = part;
				activate();

			}
		}
	}

	@Override
	public void setActivePage(IEditorPart part) {
		// Do nothing
	}

	public void deactivate() {
		activeEditor.removePropertyListener(this);

		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);

		if (validateAction != null) {
			validateAction.setActiveWorkbenchPart(null);
		}

		if (liveValidationAction != null) {
			liveValidationAction.setActiveWorkbenchPart(null);
		}

		final ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider
			? (ISelectionProvider) activeEditor
			: activeEditor.getEditorSite().getSelectionProvider();

		if (selectionProvider != null) {
			if (validateAction != null) {
				selectionProvider.removeSelectionChangedListener(validateAction);
			}
		}
	}

	public void activate() {
		activeEditor.addPropertyListener(this);

		undoAction.setActiveWorkbenchPart(activeEditor);
		redoAction.setActiveWorkbenchPart(activeEditor);

		if (validateAction != null) {
			validateAction.setActiveWorkbenchPart(activeEditor);
		}

		if (liveValidationAction != null) {
			liveValidationAction.setActiveWorkbenchPart(activeEditor);
		}

		final ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider
			? (ISelectionProvider) activeEditor
			: activeEditor.getEditorSite().getSelectionProvider();

		if (selectionProvider != null) {

			if (validateAction != null) {
				selectionProvider.addSelectionChangedListener(validateAction);
			}

		}

		update();
	}

	public void update() {
		final ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider
			? (ISelectionProvider) activeEditor
			: activeEditor.getEditorSite().getSelectionProvider();

		if (selectionProvider != null) {
			final ISelection selection = selectionProvider.getSelection();
			final IStructuredSelection structuredSelection = selection instanceof IStructuredSelection
				? (IStructuredSelection) selection
				: StructuredSelection.EMPTY;

			if (validateAction != null) {
				validateAction.updateSelection(structuredSelection);
			}

		}

		undoAction.update();
		redoAction.update();

		if (liveValidationAction != null) {
			liveValidationAction.update();
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions
	 * from the Edit menu.
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		// Add our standard marker.
		//
		if ((style & ADDITIONS_LAST_STYLE) == 0) {
			menuManager.add(new Separator("additions")); //$NON-NLS-1$
		}
		menuManager.add(new Separator("edit")); //$NON-NLS-1$

		// Add the edit menu actions.
		//
		menuManager.add(new ActionContributionItem(undoAction));
		menuManager.add(new ActionContributionItem(redoAction));
		menuManager.add(new Separator());

		if ((style & ADDITIONS_LAST_STYLE) != 0) {
			menuManager.add(new Separator("additions")); //$NON-NLS-1$
			menuManager.add(new Separator());
		}
		// Add our other standard marker.
		//
		menuManager.add(new Separator("additions-end")); //$NON-NLS-1$

		addGlobalActions(menuManager);
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 */
	protected void addGlobalActions(IMenuManager menuManager) {
		final String key = (style & ADDITIONS_LAST_STYLE) == 0 ? "additions-end" : "additions"; //$NON-NLS-1$ //$NON-NLS-2$
		if (validateAction != null) {
			menuManager.insertBefore(key, new ActionContributionItem(validateAction));
		}

		if (liveValidationAction != null) {
			menuManager.insertBefore(key, new ActionContributionItem(liveValidationAction));
		}

		if (validateAction != null) {
			menuManager.insertBefore(key, new Separator());
		}

	}

	@Override
	public void propertyChanged(Object source, int id) {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				update();
			}
		});

	}
}
// END REUSED CLASS

/*******************************************************************************
 * Copyright (c) 2011-2013 EclipseSource Muenchen GmbH and others.
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
 ******************************************************************************/

package org.eclipse.emfforms.internal.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfforms.common.Optional;
import org.eclipse.emfforms.internal.editor.ui.CreateNewChildDialog;
import org.eclipse.emfforms.spi.editor.handler.DeleteShortCutHandler;
import org.eclipse.emfforms.spi.editor.messages.Messages;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * The ShorcutHandler receives the shortcuts defined in plugin.xml and passes them to the editor.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ShortcutHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		final StructuredSelection sSelection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		if (sSelection == null) {
			return null;
		}

		final Object selection = sSelection.getFirstElement();

		// We only create or delete elements for EObjects
		if (!(selection instanceof EObject)) {
			return null;
		}

		final String commandName = event.getCommand().getId();
		final EObject currentSelection = (EObject) selection;

		final EditingDomain editingDomain = AdapterFactoryEditingDomain
			.getEditingDomainFor(currentSelection);

		if (getDeleteCmdName().equals(commandName)) {
			performDelete(sSelection, editingDomain);
		} else if (getNewChildCmdName().equals(commandName)) {
			createNewElementDialog(editingDomain, editor.getEditorSite().getSelectionProvider(), currentSelection,
				Messages.ShortcutHandler_NewElementDialogTitle).open();
		} else if (getNewSiblingCmdName().equals(commandName)) {
			// Get Parent of current Selection and show the dialog for it
			final EObject parent = currentSelection.eContainer();
			final EditingDomain parentEditingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(parent);
			createNewElementDialog(parentEditingDomain, editor.getEditorSite().getSelectionProvider(), parent,
				Messages.ShortcutHandler_NewElementDialogDescription).open();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private void performDelete(final StructuredSelection sSelection, final EditingDomain editingDomain) {
		final Bundle bundle = FrameworkUtil.getBundle(ShortcutHandler.class);
		final BundleContext bundleContext = bundle.getBundleContext();
		final ServiceReference<DeleteShortCutHandler> serviceReference = bundleContext
			.getServiceReference(DeleteShortCutHandler.class);
		if (serviceReference != null) {
			final DeleteShortCutHandler service = bundleContext.getService(serviceReference);
			final Optional<DeleteShortCutHandler> deleteHandler = Optional.ofNullable(service);

			if (deleteHandler.isPresent()) {
				deleteHandler.get().handleDeleteShortcut(sSelection.toList());
				bundleContext.ungetService(serviceReference);
				return;
			}
		}
		final Command command = DeleteCommand.create(editingDomain, sSelection.toList());
		if (!command.canExecute()) {
			return;
		}
		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * @return the cmd name for new siblings
	 */
	protected String getNewSiblingCmdName() {
		return "org.eclipse.emfforms.editor.new.sibling"; //$NON-NLS-1$
	}

	/**
	 * @return the cmd name for new children
	 */
	protected String getNewChildCmdName() {
		return "org.eclipse.emfforms.editor.new"; //$NON-NLS-1$
	}

	/**
	 * @return the cmd name for deletions
	 */
	protected String getDeleteCmdName() {
		return "org.eclipse.emfforms.editor.delete"; //$NON-NLS-1$
	}

	/**
	 * Creates the new element dialog.
	 *
	 * @param editingDomain the editing domain
	 * @param selectionProvider the selection
	 * @param selection the selection
	 * @param title the title
	 * @return the dialog
	 */
	protected Dialog createNewElementDialog(final EditingDomain editingDomain,
		final ISelectionProvider selectionProvider, final EObject selection, final String title) {

		return new CreateNewChildDialog(Display.getCurrent().getActiveShell(), title, selection,
			selectionProvider);
	}
}

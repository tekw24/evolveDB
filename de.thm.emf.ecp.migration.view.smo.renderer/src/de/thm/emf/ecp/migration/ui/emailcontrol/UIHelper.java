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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.edit.spi.ReferenceService;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.label.NoLabelFoundException;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

/**
 * @author Torben
 *
 */
public class UIHelper {

	/**
	 * Creates a link object targeting the EObject.
	 *
	 * @param linkComposite
	 * @param eObject
	 * @param text
	 * @param labelText
	 */
	protected static void createHyperlink(Composite linkComposite, EObject eObject, String text, String labelText,
		AdapterFactoryItemDelegator adapterFactoryItemDelegator, ReferenceService referenceService, String key) {

		final Label labelhyper = new Label(linkComposite, SWT.NONE);
		labelhyper.setBackground(linkComposite.getBackground());
		labelhyper.setText(labelText);

		final Label imageHyperlink = new Label(linkComposite, SWT.NONE);
		imageHyperlink.setBackground(linkComposite.getBackground());
		imageHyperlink.setImage(getImage(eObject, adapterFactoryItemDelegator));

		final Link hyperlink = new Link(linkComposite, SWT.NONE);
		hyperlink.setText("<a>" + getText(eObject, adapterFactoryItemDelegator) + "</a>"); //$NON-NLS-1$//$NON-NLS-2$
		hyperlink.setData(key, "org_eclipse_emf_ecp_control_reference"); //$NON-NLS-1$
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
				linkClicked(eObject, referenceService);
			}

		});
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.LEFT, SWT.BEGINNING).applyTo(hyperlink);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.LEFT, SWT.BEGINNING).applyTo(imageHyperlink);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.LEFT, SWT.BEGINNING).applyTo(labelhyper);
	}

	/**
	 * Returns the link text to be used for the given linked {@code value}.
	 *
	 * @param value the value
	 * @return The link text.
	 * @throws DatabindingFailedException
	 * @throws NoLabelFoundException
	 */
	protected static String getText(Object value, AdapterFactoryItemDelegator adapterFactoryItemDelegator) {
		final String linkName = adapterFactoryItemDelegator.getText(value);
		return linkName == null ? "" : linkName; //$NON-NLS-1$
	}

	/**
	 * Returns the image to be used for the given linked {@code value}.
	 *
	 * @param value the object for which the image is retrieved
	 * @return the image
	 */
	protected static Image getImage(Object value, AdapterFactoryItemDelegator adapterFactoryItemDelegator) {
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

	protected static void linkClicked(EObject value, ReferenceService referenceService) {

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

}

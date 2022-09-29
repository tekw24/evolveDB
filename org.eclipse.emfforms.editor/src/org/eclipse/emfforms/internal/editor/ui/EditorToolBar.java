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
 * Clemens Elflein - initial implementation
 ******************************************************************************/
package org.eclipse.emfforms.internal.editor.ui;

import java.util.List;

import org.eclipse.emfforms.internal.editor.Activator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;

/**
 * The Toolbar at the top of the editor.
 */
public class EditorToolBar extends Composite {

	private final ToolBarManager toolBarManager;

	private final Color background;

	/**
	 * Creates a new Toolbar.
	 *
	 * @param parent The parent
	 * @param style The Style (SWT.NONE)
	 * @param titleText The text in the toolbar
	 * @param toolbarActions a List of actions for the toolbar
	 */
	public EditorToolBar(Composite parent, int style, String titleText, List<Action> toolbarActions) {
		super(parent, style);

		background = new Color(parent.getDisplay(), 207, 222, 238);

		setBackground(background);

		final FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		setLayout(layout);

		// Create the Icon on the Left
		final Label titleImage = new Label(this, SWT.NONE);
		final ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(Activator.getDefault().getBundle()
			.getResource("icons/view.png")); //$NON-NLS-1$
		titleImage.setImage(new Image(parent.getDisplay(), imageDescriptor.getImageData(100)));

		final FormData titleImageData = new FormData();
		final int imageOffset = -titleImage.computeSize(SWT.DEFAULT, SWT.DEFAULT).y / 2;
		titleImageData.top = new FormAttachment(50, imageOffset);
		titleImageData.left = new FormAttachment(0, 10);
		titleImage.setLayoutData(titleImageData);

		// Create the label for the Title Text
		final Label title = new Label(this, SWT.WRAP);
		final FontDescriptor boldDescriptor = FontDescriptor.createFrom(title.getFont()).setHeight(13)
			.setStyle(SWT.BOLD);
		final Font boldFont = boldDescriptor.createFont(title.getDisplay());
		title.setForeground(new Color(parent.getDisplay(), 25, 76, 127));
		title.setFont(boldFont);
		title.setText(titleText);
		final FormData titleData = new FormData();
		titleData.left = new FormAttachment(titleImage, 5, SWT.DEFAULT);
		final int titleHeight = title.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		titleData.top = new FormAttachment(50, -titleHeight / 2);
		title.setLayoutData(titleData);

		// Create the toolbar and add it to the header
		final ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		final FormData formData = new FormData();
		formData.right = new FormAttachment(100, 0);
		toolBar.setLayoutData(formData);
		toolBar.layout();
		toolBarManager = new ToolBarManager(toolBar);

		// Add the provided actions
		if (toolbarActions != null) {
			for (final Action a : toolbarActions) {
				toolBarManager.add(a);
			}
		}

		toolBarManager.update(true);
		this.layout();
	}

	@Override
	public void dispose() {
		background.dispose();
		super.dispose();
	}

}

/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.mdde.migration.view.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emfforms.spi.editor.GenericEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.thm.mdde.migration.view.editor.toolbar.GenerateAction;
import de.thm.mdde.migration.view.editor.toolbar.ValidateModelAction;

public class MigrationCustomEditor extends GenericEditor {

	private boolean dirtyFlag;

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
	}

	/**
	 * Returns the title for the currently displayed editor. Subclasses should
	 * override this function to change the Editor's title
	 *
	 * @return the title
	 */
	@Override
	protected String getEditorTitle() {
		return "Migration Editor";
	}

	/**
	 * Returns the toolbar actions for this editor.
	 *
	 * @return A list of actions to show in the Editor's Toolbar
	 * @since 1.10
	 */
	@Override
	protected List<Action> getToolbarActions() {
		List<Action> result = new LinkedList<Action>();
		result.add(new GenerateAction(super.getResourceSet()));
		result.add(new ValidateModelAction(super.getResourceSet()));
		return result;

	}

	@Override
	public void firePropertyChange(int propertyId) {
		super.firePropertyChange(propertyId);
	}

	public void firePropertyChange(int propertyId, boolean dirty) {
		dirtyFlag = dirty;
		super.firePropertyChange(propertyId);
		dirtyFlag = false;
	}

	@Override
	public boolean isDirty() {
		if (dirtyFlag)
			return true;
		return super.isDirty();
	}

}

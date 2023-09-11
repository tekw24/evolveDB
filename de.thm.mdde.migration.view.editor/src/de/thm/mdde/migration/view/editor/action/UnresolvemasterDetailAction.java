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


/**
 * 
 */
package de.thm.mdde.migration.view.editor.action;

import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.delegating.DelegatingMasterDetailAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;

import de.thm.evolvedb.migration.SchemaModificationOperator;

/**
 * @author Torben
 *
 */
public class UnresolvemasterDetailAction extends DelegatingMasterDetailAction {

	private static final String ICON_PATH = "icons/full/obj16/warning16.png"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 * @param editingDomain
	 *            The {@link EditingDomain} for the {@link PasteAction}.
	 */
	public UnresolvemasterDetailAction(EditingDomain editingDomain) {
		super(editingDomain);
	}

	@Override
	protected String getEMFImagePath() {
		return ICON_PATH;
	}
	


	@Override
	protected CommandActionHandler createDelegatedAction(EditingDomain editingDomain) {
		return new UnresolveAction(editingDomain);
	}

	@Override
	protected boolean isExecuteOnKeyRelease(KeyEvent event) {
		return isActivated(event, SWT.CTRL, 'u');
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public boolean shouldShow(List<Object> objects) {
		for(Object object : objects) {
			if(!(object instanceof SchemaModificationOperator))
				return false;
		}
		return true;
	}
	
	


}

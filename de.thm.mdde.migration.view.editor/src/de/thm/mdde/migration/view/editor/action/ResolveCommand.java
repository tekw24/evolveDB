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

import java.util.Collection;

import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;

import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.SchemaModificationOperator;

/**
 * @author Torben
 *
 */
public class ResolveCommand extends AbstractOverrideableCommand{

	private Collection<?> selection;

	/**
	 * @param domain
	 */
	protected ResolveCommand(EditingDomain domain, Collection<?> selection) {
		super(domain, "Resolve");
		this.selection = selection;
		// TODO Auto-generated constructor stub
	}
	
	 public ResolveCommand()
	  {
	    super(null,"Resolve");
	  }

	@Override
	public void doExecute() {
		for (Object select : selection) {
			if(select instanceof SchemaModificationOperator) {
				SchemaModificationOperator smo = (SchemaModificationOperator) select;
				
				smo.setProcessStatus(ProcessStatus.RESOLVED);
			}
		}
		
	}

	@Override
	public void doUndo() {
		for (Object select : selection) {
			if(select instanceof SchemaModificationOperator) {
				SchemaModificationOperator smo = (SchemaModificationOperator) select;
				
				smo.setProcessStatus(ProcessStatus.UNRESOLVED);
			}
			
		}
		
	}

	@Override
	public void doRedo() {
		for (Object select : selection) {
			if(select instanceof SchemaModificationOperator) {
				SchemaModificationOperator smo = (SchemaModificationOperator) select;
				
				smo.setProcessStatus(ProcessStatus.RESOLVED);
			}
		}
		
	}
	
	@Override
	public boolean doCanExecute() {
		// TODO Auto-generated method stub
		return true;
	}

}

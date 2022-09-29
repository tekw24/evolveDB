package de.thm.mdde.view.editor;

import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emfforms.internal.editor.toolbaractions.LoadEcoreAction;
import org.eclipse.emfforms.spi.editor.GenericEditor;
import org.eclipse.emfforms.spi.editor.messages.Messages;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.thm.mdde.view.editor.toolbar.ValidateModelAction;

public class MddeCustomEditor extends GenericEditor{
	
	
	@Override
	public void init(IEditorSite site, IEditorInput input)
		throws PartInitException {
		super.init(site, input);
		
		
	}
	
	/**
	 * Returns the title for the currently displayed editor.
	 * Subclasses should override this function to change the Editor's title
	 *
	 * @return the title
	 */
	@Override
	protected String getEditorTitle() {
		return "Mdde Custom Editor";
	}
	
	
	/**
	 * Returns the toolbar actions for this editor.
	 *
	 * @return A list of actions to show in the Editor's Toolbar
	 * @since 1.10
	 */
	@Override
	protected List<Action> getToolbarActions() {
		//List<Action> result =  super.getToolbarActions();
		List<Action> result =  new LinkedList<Action>();
		
		result.add(new ValidateModelAction(super.getResourceSet()));
		return result;
	}
	
	
}

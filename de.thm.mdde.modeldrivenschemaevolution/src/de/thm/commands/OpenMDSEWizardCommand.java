package de.thm.commands;

import de.thm.mdde.wizard.MddeDatabaseConnectionController;
import de.thm.mdde.wizard.MddeDatabaseConnectionModelWizard;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenMDSEWizardCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell activeShell = HandlerUtil.getActiveShell(event);
		//IWizard wizard = new MddeDatabaseConnectionModelWizard();
		WizardDialog dialog = new WizardDialog(activeShell, new MddeDatabaseConnectionModelWizard(new MddeDatabaseConnectionController(null)));
		dialog.open();
		

		return null;
	}

}

package de.thm.mdde.migration.view.editor.action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfforms.spi.swt.treemasterdetail.DeleteActionBuilder;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.MasterDetailAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.thm.evolvedb.migration.SchemaModificationOperator;

public class ConfirmingDeleteActionBuilder implements DeleteActionBuilder {

	@Override
    public Action createDeleteAction(IStructuredSelection selection, EditingDomain editingDomain) {
        Action deleteAction = new Action("Delete") {

            @Override
            public void run() {
                if (selection == null || selection.isEmpty()) {
                    return;
                }

                List<Object> selectList = selection.toList();
                
                // Build a concise name list for the dialog
                String names = (String) selectList.stream()
                        .map(o -> {
                            // Replace with your own label provider if needed
                            return String.valueOf(o);
                        })
                        .collect(Collectors.joining(", "));

                boolean ok = MessageDialog.openQuestion(
                        Display.getCurrent().getActiveShell(),
                        "Delete item(s)",
                        "Do you really want to delete the selected item(s)?\n\n" + names);

                if (!ok) return;
                List<Object> deleteList= new ArrayList<>();
                for(Object sel : selectList) {
                	if(sel instanceof SchemaModificationOperator) {
                		SchemaModificationOperator smo = (SchemaModificationOperator) sel;
                		deleteList.addAll(smo.getSemanticChangeSets());
                	}
                }
                
                deleteList.addAll(selectList);
                
                Command cmd = DeleteCommand.create(editingDomain, deleteList);
                if (cmd.canExecute()) {
                	
      
                	
                    editingDomain.getCommandStack().execute(cmd);
                }
            }

            @Override
            public boolean isEnabled() {
                return selection != null && !selection.isEmpty();
            }
        };

        // Tooltip
        deleteAction.setToolTipText("Delete selected item(s)");

        // Icon(s): use Eclipse shared images (enabled + disabled)
        deleteAction.setImageDescriptor(
                PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
        deleteAction.setDisabledImageDescriptor(
                PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));

        // Optional: keyboard shortcut in label (platform-specific handling may vary)
        // deleteAction.setAccelerator(SWT.DEL);

        return deleteAction;
    }

}

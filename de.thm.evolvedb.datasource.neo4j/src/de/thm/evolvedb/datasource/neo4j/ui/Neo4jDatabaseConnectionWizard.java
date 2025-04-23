package de.thm.evolvedb.datasource.neo4j.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.thm.evolvedb.datasource.neo4j.connection.Neo4JDatabaseConnectionController;
import de.thm.evolvedb.graph.presentation.GraphEditorPlugin;



public class Neo4jDatabaseConnectionWizard extends Wizard implements INewWizard{
	
	
	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
			Arrays.asList(GraphEditorPlugin.INSTANCE.getString("_UI_GraphEditorFilenameExtensions").split("\\s*,\\s*")));

	private Neo4JDatabaseConnectionController controller;
	private IWorkbench workbench;
	private IStructuredSelection selection;
	private Neo4jDatabaseConnectionWizardPage_1 connectionWizardPage_1;
	
	
	public Neo4jDatabaseConnectionWizard(Neo4JDatabaseConnectionController controller) {
		super();
		this.controller = controller;
	}
	
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;	
		setWindowTitle(GraphEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(GraphEditorPlugin.INSTANCE.getImage("full/wizban/NewGraph")));
		
	}
	
	@Override
	public boolean canFinish() {
		//&& mddeDatabaseModelConnectionWizardPage_2.isPageComplete() TODO
		return connectionWizardPage_1.isPageComplete() ;
	}
	
	@Override
	public void addPages() {

		// Create a page, set the title, and the initial model file name.
		//
		connectionWizardPage_1 = new Neo4jDatabaseConnectionWizardPage_1("Whatever", selection, controller);
		connectionWizardPage_1.setTitle(GraphEditorPlugin.INSTANCE.getString("_UI_GraphModelWizard_label"));
		connectionWizardPage_1.setDescription(GraphEditorPlugin.INSTANCE.getString("_UI_GraphModelWizard_description"));
//		connectionWizardPage_1.setFileName(MddeEditorPlugin.INSTANCE.getString("_UI_MddeEditorFilenameDefaultBase") + "."
//				+ FILE_EXTENSIONS.get(0));
		addPage(connectionWizardPage_1);

		// Try and get the resource selection to determine a current directory for the
		// file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					// connectionWizardPage_1.setContainerFullPath(selectedResource.getFullPath());
					// //TODO

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = GraphEditorPlugin.INSTANCE
							.getString("_UI_GraphEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					// connectionWizardPage_1.setFileName(modelFilename); //TODO
				}
			}
		}
//		mddeDatabaseModelConnectionWizardPage_2 = new MddeDatabaseModelConnectionWizardPage_2("Whatever", selection,
//				controller);
//		addPage(mddeDatabaseModelConnectionWizardPage_2);
//		mddeDatabaseModelConnectionWizardPage_2
//				.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
//		mddeDatabaseModelConnectionWizardPage_2
//				.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_description"));
//
//
		controller.setConnectionWizardPage_1(connectionWizardPage_1);
//		controller.setMddeDatabaseModelConnectionWizardPage_2(mddeDatabaseModelConnectionWizardPage_2);


		connectionWizardPage_1.setPageComplete(false);
//		mddeDatabaseModelConnectionWizardPage_2.setPageComplete(false);
		//mddeDatabaseModelNewFileCreationPage_4.setPageComplete(false);

	}
	
	
	@Override
	public boolean performCancel() {
		controller.setCanceled(true);
		return super.performCancel();
	}
	

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}

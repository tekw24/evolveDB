package de.thm.mdde.connection.ui.wizard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;
import de.thm.mdde.connection.driver.ui.DriverDownloadDialog;

public class EDBConnectionWizard extends Wizard implements INewWizard {

	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
			Arrays.asList(MddeEditorPlugin.INSTANCE.getString("_UI_MddeEditorFilenameExtensions").split("\\s*,\\s*")));

	private IWorkbench workbench;
	private IStructuredSelection selection;

	private EDBConnectionController controller;

	private EDBDatabaseModelNewFileCreationPage edbDatabaseModelNewFileCreationPage;

	private EDBConnectionSelectDataSourcePage edbSelectDatasourcePage;

	public EDBConnectionWizard() {
		super();
		// this.resModelFile = resModelFile;
//		if(controller != null)
//			controller.setResModelFile(resModelFile);

		setWindowTitle("Select Datasource Dialog");
//		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
//				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;

		setWindowTitle("Select Driver Dialog");
//		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
//				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));

	}

	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			// final IFile modelFile = getFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {

						// controller.generateMigrations(getFile(),
						// mddeCodeGenerationWizardPage_2.getContainerFolder());

						// Add the initial model object to the contents.

//						// Save the contents of the resource to the file system.

//						Map<Object, Object> options = new HashMap<Object, Object>();
//						options.put(XMLResource.OPTION_ENCODING, mddeCodeGenerationWizardPage_2.getEncoding());
//						resource.save(options);

					} catch (Exception exception) {
						// MddeEditorPlugin.INSTANCE.log(exception);
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error",
								exception.getLocalizedMessage());
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// TODO Kann ich die neue Datei im Explorer �ffnen?
//			// Select the new file resource in the current view.
//			//
//			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
//			IWorkbenchPage page = workbenchWindow.getActivePage();
//			final IWorkbenchPart activePart = page.getActivePart();
//			if (activePart instanceof ISetSelectionTarget) {
//				final ISelection targetSelection = new StructuredSelection(modelFile);
//				getShell().getDisplay().asyncExec(new Runnable() {
//					@Override
//					public void run() {
//						((ISetSelectionTarget) activePart).selectReveal(targetSelection);
//					}
//				});
//			}
//
//			// Open an editor on the new file.
//			//
//			try {
//				page.openEditor(new FileEditorInput(modelFile),
//						workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
//			} catch (PartInitException exception) {
//				MessageDialog.openError(workbenchWindow.getShell(),
//						MddeEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
//				return false;
//			}
//
			return true;
		} catch (Exception exception) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", exception.getLocalizedMessage());
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean canFinish() {
		return edbSelectDatasourcePage.isPageComplete();
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page.equals(edbSelectDatasourcePage)) {
			
		}

		return super.getNextPage(page);
	}
	
	

	@Override
	public void addPages() {
		controller = new EDBConnectionController();
		edbSelectDatasourcePage = new EDBConnectionSelectDataSourcePage("Erste Seite", "Select Datasource", null,
				controller);

		addPage(edbSelectDatasourcePage);

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
					String defaultModelBaseFilename = MddeEditorPlugin.INSTANCE
							.getString("_UI_MddeEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					// connectionWizardPage_1.setFileName(modelFilename); //TODO
				}
			}

		} else
			selection = StructuredSelection.EMPTY;

		edbDatabaseModelNewFileCreationPage = new EDBDatabaseModelNewFileCreationPage("Test", selection, controller);
		addPage(edbDatabaseModelNewFileCreationPage);
		edbDatabaseModelNewFileCreationPage.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
		edbDatabaseModelNewFileCreationPage
				.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_description"));

		super.addPages();
	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
//	public IFile getFile() {
//		return mddeCodeGenerationWizardPage_2.getFile();
//	}

}

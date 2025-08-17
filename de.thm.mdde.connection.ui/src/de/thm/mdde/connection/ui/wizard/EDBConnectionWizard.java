package de.thm.mdde.connection.ui.wizard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.IOWrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

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
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));

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
			final IFile modelFile = getFile();
			
			if(modelFile == null) {
				MessageDialog.openError(getShell(), "File location not set", "Please select a location for the new model file.");
				return false;
			}
				

			// Do the work within an operation.

			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						//
						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the model file.
						//
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

						// Create a resource for this file.
						//
						Resource resource = resourceSet.createResource(fileURI);

						EObject rootObject = controller.geteObject();

						// Add the initial model object to the contents.

						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.

						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, edbDatabaseModelNewFileCreationPage.getEncoding());

						try {
							resource.save(options);
						} catch (IOWrappedException e) {
							// DO nothing
							System.out.println("Exception");
							e.printStackTrace();
						}

						// Save a copy to the generatedModel Folder
						IPath path = null;
						if (!edbDatabaseModelNewFileCreationPage.getContainerFullPath().toFile().isDirectory()) {

							path = edbDatabaseModelNewFileCreationPage.getContainerFullPath();
							path = path.append("/genModel");

							IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
							if (!folder.exists()) {
								createFolder(folder, false, true, null);
							}

						} else {

							path = edbDatabaseModelNewFileCreationPage.getContainerFolder().getFullPath();
							IFolder folder = edbDatabaseModelNewFileCreationPage.getContainerFolder();
							IFolder binFolder = folder.getFolder("genModel");
							if (!binFolder.exists()) {
								createFolder(binFolder, false, true, null);
							}
							path = path.append("genModel");
						}

						String filename = edbDatabaseModelNewFileCreationPage.getFileName();
						String extension = edbDatabaseModelNewFileCreationPage.getFormatted_file_extensions();
						if (filename != null) {
							filename = filename.substring(0, filename.length() - (extension.length() + 1));
							filename = filename + "V2." + extension;
						}

						ResourceSet resourceSet2 = new ResourceSetImpl();
						Resource resource2 = resourceSet2.createResource(URI.createPlatformResourceURI(
								path.append("/" + (filename != null ? filename : "test.mdde")).toString(), true));
						resource2.getContents().add(rootObject);

						try {
							resource2.save(options);
						} catch (IOWrappedException e) {
							// DO nothing
							System.out.println("Exception");
							e.printStackTrace();
						}

//						folder.create(false, true, progressMonitor);
//						
//						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//						IProject project = root.getProject(projectName);

//						Object firstElement = selection.getFirstElement();
//						if (firstElement instanceof IAdaptable) {
//							IProject project = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
//							IPath path = project.getFullPath();
//							System.out.println(path);
//						}

					} catch (Exception exception) {
						MddeEditorPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//

			if (workbench == null)
				workbench = PlatformUI.getWorkbench();

			if (workbench != null) {

				IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
				IWorkbenchPage page = workbenchWindow.getActivePage();
				final IWorkbenchPart activePart = page.getActivePart();
				if (activePart instanceof ISetSelectionTarget) {
					final ISelection targetSelection = new StructuredSelection(modelFile);
					getShell().getDisplay().asyncExec(new Runnable() {
						@Override
						public void run() {
							((ISetSelectionTarget) activePart).selectReveal(targetSelection);
						}
					});
				}

				// Open an editor on the new file.
				//
				try {
					page.openEditor(new FileEditorInput(modelFile),
							workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
				} catch (PartInitException exception) {
					MessageDialog.openError(workbenchWindow.getShell(),
							MddeEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
					return false;
				}

			}

			return true;
		} catch (Exception exception) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", exception.getLocalizedMessage());
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean canFinish() {
		return edbSelectDatasourcePage.isPageComplete() && edbDatabaseModelNewFileCreationPage.isPageComplete();
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page.equals(edbSelectDatasourcePage)) {

		}

		return super.getNextPage(page);
	}

	@Override
	public void addPages() {
		controller = new EDBConnectionController(this);
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
					//

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

	private void createFolder(IFolder folder, boolean force, boolean local, IProgressMonitor monitor)
			throws CoreException {
		if (!folder.exists()) {
			IContainer parent = folder.getParent();
			if (parent instanceof IFolder) {
				createFolder((IFolder) parent, force, local, null);
			}
			folder.create(force, local, monitor);
		}
	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getFile() {
		return edbDatabaseModelNewFileCreationPage.getModelFile();
	}

}

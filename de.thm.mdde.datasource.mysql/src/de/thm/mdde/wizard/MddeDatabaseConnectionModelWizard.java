package de.thm.mdde.wizard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.thm.evolvedb.mdde.MddeFactory;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

public class MddeDatabaseConnectionModelWizard extends Wizard implements INewWizard {

	protected MddePackage mddePackage = MddePackage.eINSTANCE;
	protected MddeFactory mddeFactory = mddePackage.getMddeFactory();

	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
			Arrays.asList(MddeEditorPlugin.INSTANCE.getString("_UI_MddeEditorFilenameExtensions").split("\\s*,\\s*")));

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private MddeDatabaseConnectionWizardPage_1 connectionWizardPage_1;
	private MddeDatabaseConnectionController controller;
	private MddeDatabaseModelConnectionWizardPage_2 mddeDatabaseModelConnectionWizardPage_2;

	//private MddeDatabaseModelNewFileCreationPage_4 mddeDatabaseModelNewFileCreationPage_4;
	private MddeDatabaseModelConnectionWizardPage_3 mddeDatabaseModelConnectionWizardPage_3;

	public MddeDatabaseConnectionModelWizard(MddeDatabaseConnectionController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;	
		setWindowTitle(MddeEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));

	}

	@Override
	public boolean canFinish() {
		return connectionWizardPage_1.isPageComplete() && mddeDatabaseModelConnectionWizardPage_2.isPageComplete();
	}

	@Override
	public boolean performFinish() {
		return false;

//		try {
			// Remember the file.
			//
			//final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
//			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
//				@Override
//				protected void execute(IProgressMonitor progressMonitor) {
//					try {
//						// Create a resource set
//						//
//						ResourceSet resourceSet = new ResourceSetImpl();
//
//						// Get the URI of the model file.
//						//
//						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
//
//						// Create a resource for this file.
//						//
//						Resource resource = resourceSet.createResource(fileURI);
//
//						EObject rootObject = controller.createModel();
//
//						// Add the initial model object to the contents.
//
//						if (rootObject != null) {
//							resource.getContents().add(rootObject);
//						}
//
////						// Save the contents of the resource to the file system.
//
//						Map<Object, Object> options = new HashMap<Object, Object>();
//						options.put(XMLResource.OPTION_ENCODING, mddeDatabaseModelNewFileCreationPage_4.getEncoding());
//
//						try {
//							resource.save(options);
//						} catch (IOWrappedException e) {
//							// DO nothing
//							System.out.println("Exception");
//							e.printStackTrace();
//						}
//
//						// Save a copy to the generatedModel Folder
//						IPath path = null;	
//						if (!mddeDatabaseModelNewFileCreationPage_4.getContainerFullPath().toFile().isDirectory()) {
//							
//							path = mddeDatabaseModelNewFileCreationPage_4.getContainerFullPath();
//							path = path.append("/genModel");
//							
//							IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
//							if (!folder.exists()) {
//								createFolder(folder, false, true, null);
//							}
//							
//						} else {
//
//							path = mddeDatabaseModelNewFileCreationPage_4.getContainerFolder().getFullPath();
//							IFolder folder = mddeDatabaseModelNewFileCreationPage_4.getContainerFolder();
//							IFolder binFolder = folder.getFolder("genModel");
//							if (!binFolder.exists()) {
//								createFolder(binFolder, false, true, null);
//							}
//							path = path.append("genModel");
//						}
//
//						String filename = mddeDatabaseModelNewFileCreationPage_4.getFileName();
//						if (filename != null) {
//							filename = filename.substring(0, filename.length() - 5);
//							filename = filename + "V2.mdde";
//						}
//
//						ResourceSet resourceSet2 = new ResourceSetImpl();
//						Resource resource2 = resourceSet2.createResource(URI.createPlatformResourceURI(
//								path.append("/" + (filename != null ? filename : "test.mdde")).toString(),
//								true));
//						resource2.getContents().add(rootObject);
//
//						try {
//							resource2.save(options);
//						} catch (IOWrappedException e) {
//							// DO nothing
//							System.out.println("Exception");
//							e.printStackTrace();
//						}
//
////						folder.create(false, true, progressMonitor);
////						
////						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
////						IProject project = root.getProject(projectName);
//
////						Object firstElement = selection.getFirstElement();
////						if (firstElement instanceof IAdaptable) {
////							IProject project = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
////							IPath path = project.getFullPath();
////							System.out.println(path);
////						}
//
//					} catch (Exception exception) {
//						MddeEditorPlugin.INSTANCE.log(exception);
//					} finally {
//						progressMonitor.done();
//					}
//				}
//			};

//			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
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
//			return true;
//		} catch (Exception exception) {
//			MddeEditorPlugin.INSTANCE.log(exception);
//			return false;
//		}
	}

	/**
	 * The framework calls this to create the contents of the wizard. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void addPages() {

		// Create a page, set the title, and the initial model file name.
		//
		connectionWizardPage_1 = new MddeDatabaseConnectionWizardPage_1("Whatever", selection, controller);
		connectionWizardPage_1.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
		connectionWizardPage_1.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_description"));
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
		}
		mddeDatabaseModelConnectionWizardPage_2 = new MddeDatabaseModelConnectionWizardPage_2("Whatever", selection,
				controller);
		addPage(mddeDatabaseModelConnectionWizardPage_2);
		mddeDatabaseModelConnectionWizardPage_2
				.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
		mddeDatabaseModelConnectionWizardPage_2
				.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_description"));
//		initialObjectCreationPage = new MddeModelWizardInitialObjectCreationPage("Whatever2");
//		initialObjectCreationPage.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
//		initialObjectCreationPage
//				.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
//		addPage(initialObjectCreationPage);

		// Wird aktuell nicht ben�tigt
//		mddeDatabaseModelConnectionWizardPage_3 = new MddeDatabaseModelConnectionWizardPage_3("Test", selection,
//				controller);
//		addPage(mddeDatabaseModelConnectionWizardPage_3);
//		mddeDatabaseModelConnectionWizardPage_3
//				.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
//		mddeDatabaseModelConnectionWizardPage_3
//				.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_description"));

//		mddeDatabaseModelNewFileCreationPage_4 = new MddeDatabaseModelNewFileCreationPage_4("Test", selection,
//				controller);
//		addPage(mddeDatabaseModelNewFileCreationPage_4);
//		mddeDatabaseModelNewFileCreationPage_4
//				.setTitle(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_label"));
//		mddeDatabaseModelNewFileCreationPage_4
//				.setDescription(MddeEditorPlugin.INSTANCE.getString("_UI_MddeModelWizard_description"));

		controller.setConnectionWizardPage_1(connectionWizardPage_1);
		controller.setMddeDatabaseModelConnectionWizardPage_2(mddeDatabaseModelConnectionWizardPage_2);
		// controller.setMddeDatabaseModelConnectionWizardPage_3(mddeDatabaseModelConnectionWizardPage_3);

		connectionWizardPage_1.setPageComplete(false);
		mddeDatabaseModelConnectionWizardPage_2.setPageComplete(false);
		//mddeDatabaseModelNewFileCreationPage_4.setPageComplete(false);

	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page.equals(connectionWizardPage_1)) {
			if (controller.isSchemaSelected()) {
				mddeDatabaseModelConnectionWizardPage_2.setPageComplete(true);
				//return mddeDatabaseModelNewFileCreationPage_4;
			} else {
				return super.getNextPage(page);
			}
		}
		return super.getNextPage(page);
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
//		if (page.equals(mddeDatabaseModelNewFileCreationPage_4)) {
//			if (controller.isSchemaSelected()) {
//				return connectionWizardPage_1;
//			} else {
//				return super.getPreviousPage(page);
//			}
//		}
		return super.getPreviousPage(page);
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
//	public IFile getModelFile() {
//		return mddeDatabaseModelNewFileCreationPage_4.getModelFile();
//	}

}

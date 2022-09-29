package de.thm.mdde.differenceBuilderWizard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.input.InputModels;
import org.sidiff.difference.symmetric.SymmetricDifference;

import de.thm.commonui.util.UIUtil;
import de.thm.mdde.language.Language;
import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

public class MddeDifferenceBuilderWizard extends Wizard implements INewWizard {

	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
			Arrays.asList(MddeEditorPlugin.INSTANCE.getString("_UI_MddeEditorFilenameExtensions").split("\\s*,\\s*")));

	private IStructuredSelection selection;

	private MddeDifferenceBuilderNewFilePage builderNewFilePage;
	private MddeDifferenceBuilderController controller;

	private MddeDifferenceBuilderInputModelPage inputModelPage;

	private DifferenceType differenceType;

	private MddeDifferenceBuilderMatchingPage matchingPage;

	private MddeDifferenceBuilderWizard() {
		super();
	}

	public MddeDifferenceBuilderWizard(InputModels inputModels, DifferenceType differenceType) {
		this();
		this.differenceType = differenceType;
		controller = new MddeDifferenceBuilderController(inputModels);
		setWindowTitle("New Symmetric Difference Wizard");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New Symmetric Difference Wizard");

		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));

	}

	@Override
	public boolean performFinish() {

		try {
			// Remember the file.
			//
			// final IFile modelFile = getModelFile();
			final IFile modelFile = builderNewFilePage.getModelContainer();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {

						// Get the URI of the model file.
						//
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

						SymmetricDifference symmetricDifference = null;

						if (differenceType.equals(DifferenceType.TECHNICALDIFFERENCE)) {
							symmetricDifference = controller.createTechnicalDifference();
						} else if (differenceType.equals(DifferenceType.LIFTEDDIFFERENCE)) {
							symmetricDifference = controller.createLiftedDifference();
						}

						// Add the initial model object to the contents.

						if (symmetricDifference != null) {
							controller.persistSymmetricDifference(symmetricDifference, fileURI,
									builderNewFilePage.getFileName());
						}

					} catch (InvalidModelException | NoCorrespondencesException exception) {
						MddeEditorPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = UIUtil.getActiveWindow();
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

			return true;
		} catch (Exception exception) {
			MddeEditorPlugin.INSTANCE.log(exception);
			return false;
		}

	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getModelFile() {
		return builderNewFilePage.getModelFile();
	}

	@Override
	public boolean canFinish() {
		return builderNewFilePage.isPageComplete();
	}

	@Override
	public void addPages() {
		// first page
		inputModelPage = new MddeDifferenceBuilderInputModelPage(Language.WIZARD_COMPARE_MODELS, controller);
		inputModelPage.setTitle(Language.WIZARD_MODEL_COMPARISON);
		inputModelPage.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(inputModelPage);

		// second page
		matchingPage = new MddeDifferenceBuilderMatchingPage(Language.WIZARD_COMPARE_MODELS, controller);
		matchingPage.setTitle(Language.WIZARD_MODEL_COMPARISON);
		matchingPage.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(matchingPage);

		// Third page
		builderNewFilePage = new MddeDifferenceBuilderNewFilePage("Test", selection);
		addPage(builderNewFilePage);
		builderNewFilePage.setTitle(Language.WIZARD_SYMMETRIC_DIFFERENCE);
		builderNewFilePage.setDescription(Language.WIZARD_CREATE_SYMMETRIC_DIFFERENCE);

		// builderNewFilePage.setPageComplete(false);
	}

}

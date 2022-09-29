package de.thm.commonui.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.commands.*;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.*;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.services.IServiceLocator;

public class UIUtil {

	/**
	 * Returns the active shell.
	 * @return active shell, <code>null</code> if none
	 */
	public static Shell getActiveShell() {
		IWorkbenchWindow win = getActiveWindow();
		return win != null ? win.getShell() : null;
	}

	/**
	 * Returns the active workbench window.
	 * @return active window, <code>null</code> if none
	 */
	public static IWorkbenchWindow getActiveWindow() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}

	/**
	 * Returns the active workbench page.
	 * @return the active page, <code>null</code> if none
	 */
	public static IWorkbenchPage getActivePage() {
		IWorkbenchWindow win = getActiveWindow();
		return win != null ? win.getActivePage() : null;
	}

	/**
	 * Returns the active workbench part.
	 * @return the active part, <code>null</code> if none
	 */
	public static IWorkbenchPart getActivePart() {
		IWorkbenchPage page = getActivePage();
		return page != null ? page.getActivePart() : null;
	}

	/**
	 * Shows the perspective with the given ID.
	 * @param perspectiveId the ID of the perspective
	 * @return the workbench page that the perspective was shown
	 * @throws WorkbenchException if the perspective could not be shown
	 * @throws IllegalThreadStateException if not called from UI thread, or no active window
	 */
	public static IWorkbenchPage showPerspective(String perspectiveId) throws WorkbenchException {
		IWorkbenchWindow window = getActiveWindow();
		if(window == null) {
			throw new IllegalThreadStateException("Not called from UI thread, or no active window");
		}
		return PlatformUI.getWorkbench().showPerspective(perspectiveId, window);
	}

	/**
	 * Shows the view with the given ID and type in the active workbench page.
	 * @param viewType the class of the view
	 * @param viewId the ID of the view
	 * @return the view (newly created or existing)
	 * @throws PartInitException if the view could not be initialized
	 * @throws IllegalThreadStateException if not called from UI thread, or no active page/window
	 * @throws IllegalArgumentException if the part with the ID is found but does not have the specified type
	 */
	public static <V extends IViewPart> V showView(Class<V> viewType, String viewId) throws PartInitException {
		IWorkbenchPage page = getActivePage();
		if(page == null) {
			throw new IllegalThreadStateException("Not called from UI thread, or no active page/window");
		}
		IViewPart part = page.showView(viewId);
		if(!viewType.isInstance(part)) {
			throw new IllegalArgumentException("Part with ID " + viewId + " is not of type " + viewType);
		}
		return viewType.cast(part);
	}

	/**
	 * Tries to select and reveal the given resource in the JDT Package Explorer view,
	 * else tries the same using the Project Explorer view.
	 * @param window the workbench window to open the view in
	 * @param resource the resource to select and reveal
	 * @throws ExecutionException if neither package explorer nor project explorer could be opened
	 */
	public static void selectRevealInExplorerView(IWorkbenchWindow window, IResource resource) throws ExecutionException {
		IWorkbenchPage page = window.getActivePage();
		if(page == null) {
			throw new IllegalThreadStateException("Not called from UI thread, or no active page/window");
		}
		IViewPart part;
		try {
			// First try to open PackageExplorer
			part = page.showView("org.eclipse.jdt.ui.PackageExplorer");
		} catch (PartInitException e1) {
			try {
				// Else, fall back to project explorer
				part = page.showView(IPageLayout.ID_PROJECT_EXPLORER);
			} catch (PartInitException e2) {
				e2.initCause(e1);
				throw new ExecutionException("Could not open Package Explorer and Project Explorer views", e2);
			}
		}
		((ISetSelectionTarget)part).selectReveal(new StructuredSelection(resource));
	}

	/**
	 * Execute Eclipse command programmatically.
	 *
	 * @param commandID The command ID.
	 */
	public static void callCommand(String commandID, Map<String, String> parameters) throws CommandException {
		IServiceLocator serviceLocator = PlatformUI.getWorkbench();
		ICommandService commandService = serviceLocator.getService(ICommandService.class);
		IEvaluationService evaluationService = serviceLocator.getService(IEvaluationService.class);
		Command theCommand = commandService.getCommand(commandID);
		ExecutionEvent event = new ExecutionEvent(
			theCommand,
			parameters,
			null,
			evaluationService.getCurrentState());
		theCommand.executeWithChecks(event);
	}

	/**
	 * Open a file with the associated editor.
	 *
	 * @param osFile file on the file system.
	 * @throws FileNotFoundException
	 * @throws PartInitException
	 */
	public static void openEditor(File osFile) throws FileNotFoundException, PartInitException {
		if(!osFile.exists() || !osFile.isFile()) {
			throw new FileNotFoundException("File could not be found: " + osFile);
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(osFile.getAbsolutePath());
		IFile file = workspace.getRoot().getFileForLocation(location);

		IWorkbenchPage page = getActivePage();
		if(page == null) {
			throw new IllegalStateException("The active workbench window has no active page");
		}

		if (file != null) {
			// Open from workspace:
			IDE.openEditor(page, file);
		} else {
			// Open from file system:
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(osFile.toURI());
			IDE.openEditorOnFileStore(page, fileStore);
		}
	}

	public static void showMessage(final String message) {
		Display.getDefault().asyncExec(() -> MessageDialog.openInformation(getActiveShell(),
				getActivePart().getTitle(),
				message));
	}

	public static void showError(final String message) {
		Display.getDefault().asyncExec(() -> MessageDialog.openError(getActiveShell(),
				getActivePart().getTitle(),
				message));
	}

	/**
	 * Runs the given runnable on the UI thread and waits until it is finished,
	 * returning the return value of the invocation of {@link RunnableWithResult#run()}
	 * @param <T> type of the result
	 * @param runnable a runnable which returns a result of type T
	 * @return the result of type T
	 */
	public static <T> T syncExecWithResult(RunnableWithResult<T> runnable) {
		AtomicReference<T> reference = new AtomicReference<>(null);
		Display.getDefault().syncExec(() -> {
			reference.set(runnable.run());
		});
		return reference.get();
	}

	@FunctionalInterface
	public interface RunnableWithResult<T> {
		T run();
	}

	/**
	 * This class validates a String.
	 */
	public static class NotEmptyValidator implements IInputValidator {

		@Override
		public String isValid(String newText) {
			int len = newText.length();

			// Determine if input is empty
			if (len < 1) {
				return "Empty inputs are not allowed!";
			}

			// Input must be OK
			return null;
		}
	}
}


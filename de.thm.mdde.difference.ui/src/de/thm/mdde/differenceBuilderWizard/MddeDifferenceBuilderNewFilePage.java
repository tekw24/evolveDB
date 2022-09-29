package de.thm.mdde.differenceBuilderWizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

public class MddeDifferenceBuilderNewFilePage extends WizardNewFileCreationPage {


	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList("symmetric"));

	/**
	 * A formatted list of supported file extensions, suitable for display. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	public static final String FORMATTED_FILE_EXTENSIONS = "symmetric";

	private ArrayList<String> encodings;

	public MddeDifferenceBuilderNewFilePage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
	}

	@Override
	protected void initialPopulateContainerNameField() {
		// Super method throws a null pointer exception. 
		// super.initialPopulateContainerNameField();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}

	public IFile getModelContainer() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath());
	}


	/**
	 * The framework calls this to see if the file is correct. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
				String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
				System.out.println(key);
				setErrorMessage(MddeEditorPlugin.INSTANCE.getString(key, new Object[] { FORMATTED_FILE_EXTENSIONS }));
				return false;
			}
			return true;
		}

		return false;

	}

	protected Collection<String> getEncodings() {
		if (encodings == null) {
			encodings = new ArrayList<String>();
			for (StringTokenizer stringTokenizer = new StringTokenizer(
					MddeEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens();) {
				encodings.add(stringTokenizer.nextToken());
			}
		}
		return encodings;
	}

}

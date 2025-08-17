package de.thm.mdde.connection.ui.wizard;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

public class EDBDatabaseModelNewFileCreationPage extends WizardNewFileCreationPage {

	public List<String> file_extensions;

	/**
	 * A formatted list of supported file extensions, suitable for display. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String formatted_file_extensions; 
			

	private Combo encodingField;

	private ArrayList<String> encodings;
	/**
	 * The controller for this wizard.
	 */
	private EDBConnectionController controller;

	
	public EDBDatabaseModelNewFileCreationPage(String pageName, IStructuredSelection selection, EDBConnectionController controller) {
		super(pageName, selection);
		this.controller = controller;
		

	}
	
	@Override
	public boolean isPageComplete() {
		return super.isPageComplete();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		Composite control = (Composite) getControl();

		Composite composite = new Composite(control, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		Label encodingLabel = new Label(composite, SWT.LEFT);
		{
			encodingLabel.setText(MddeEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			encodingLabel.setLayoutData(data);
		}
		encodingField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			encodingField.setLayoutData(data);
		}

		for (String encoding : getEncodings()) {
			encodingField.add(encoding);
		}

		encodingField.select(0);
		// encodingField.addModifyListener(validator);



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
			if (extension == null || !file_extensions.contains(extension)) {
				String key = file_extensions.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
				setErrorMessage(MddeEditorPlugin.INSTANCE.getString(key, new Object[] { formatted_file_extensions }));
				setPageComplete(false);
				return false;
			}
//			if(getContainerFullPath() == null || !getContainerFullPath().toFile().isDirectory()) {
//				setErrorMessage("Files should not be stored in the project root.");
//				return false;
//			}
			
			setPageComplete(true);
			return true;
		}
		setPageComplete(false);
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
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		file_extensions = controller.getFileExtensions();
		formatted_file_extensions= file_extensions.get(0).replaceAll("\\s*,\\s*", ", ");	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getEncoding() {
		return encodingField.getText();
	}
	
	

	public String getFormatted_file_extensions() {
		return formatted_file_extensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}
	
	public IFolder getContainerFolder() {
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(getContainerFullPath());
	}

}

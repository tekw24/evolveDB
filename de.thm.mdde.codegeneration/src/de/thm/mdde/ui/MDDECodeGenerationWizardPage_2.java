package de.thm.mdde.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

public class MDDECodeGenerationWizardPage_2 extends WizardNewFileCreationPage{
	
	
	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
			Arrays.asList("sql"));
	
	/**
	 * A formatted list of supported file extensions, suitable for display. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS = "sql".replaceAll("\\s*,\\s*", ", ");

	private Combo encodingField;

	private ArrayList<String> encodings;
	
	/**
	 * The controller for this wizard.
	 */
	private MDDECodeGenerationController controller;
	

	public MDDECodeGenerationWizardPage_2(String pageName, IStructuredSelection selection, MDDECodeGenerationController controller, String pageTitle) {
		super(pageName, selection);
		this.controller = controller;
		setTitle(pageTitle);
		setMessage("File name must be specified.");
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		setMessage("File name must be specified.");
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

		// Save Configuration file
//		Button btnSaveConfiguration = new Button(composite, SWT.PUSH);
//		btnSaveConfiguration.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
//		btnSaveConfiguration.setText(Language.WIZARD_SAVE_CONFIG);
//		btnSaveConfiguration.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				FileDialog fileDialog = new FileDialog(getShell(), SWT.SAVE);
//				String[] extensions = { "*.xml" };
//				fileDialog.setFilterExtensions(extensions);
//				fileDialog.setOverwrite(true);
//				fileDialog.setFilterPath(Platform.getLocation().toOSString());
//				String filename = fileDialog.open();
//				if (filename != null) {
//					
//					
//					controller.saveConfigFile(filename);
//					
//				}
//			}
//		});
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
		
		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public String getEncoding() {
			return encodingField.getText();
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public IFile getFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
		
		public IFolder getContainerFolder() {
			return ResourcesPlugin.getWorkspace().getRoot().getFolder(getContainerFullPath());
		}
		

	}



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
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

public class MddeDifferenceBuilderNewFilePage extends WizardNewFileCreationPage {

	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList("symmetric"));
	public static final List<String> MIGRATION_EXTENSIONS = Collections.unmodifiableList(Arrays.asList("migration"));

	/**
	 * A formatted list of supported file extensions, suitable for display. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	public static final String FORMATTED_FILE_EXTENSIONS = "symmetric";
	public static final String FORMATTED_MIGRATION_FILE_EXTENSIONS = "symmetric";

	private ArrayList<String> encodings;

	private Button createMigrationButton;

	private Text text;

	public MddeDifferenceBuilderNewFilePage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
	}

	@Override
	protected void initialPopulateContainerNameField() {
		// Super method throws a null pointer exception.
		// super.initialPopulateContainerNameField();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		Composite control = (Composite) getControl();

		
		Group group = new Group(control, SWT.NONE);
		group.setText("Migration model");
		group.setLayoutData(group);
		
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.verticalSpacing = 12;
			group.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			group.setLayoutData(data);
		}
		
		

		createMigrationButton = new Button(group, SWT.CHECK);
		createMigrationButton.setText("Create Migration Model");
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = 2;
			createMigrationButton.setLayoutData(data);
			createMigrationButton.setSelection(true);
			

		}
		
		Label fileName = new Label(group, SWT.NONE);
		fileName.setText("Migration Model file name:");
		fileName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

		text = new Text(group, SWT.SINGLE | SWT.BORDER);
		{
			GridData data2 = new GridData();
			data2.horizontalAlignment = GridData.FILL;
			data2.grabExcessHorizontalSpace = true;
			text.setLayoutData(data2);

		}
		
		text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				validatePage();
				
			}
		});

		createMigrationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(createMigrationButton.getSelection());
				validatePage();
			}
		});

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}
	
	public IFile getMigreationModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getMigrationFileName()));
	}
	

	public IFile getModelContainer() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath());
	}
	
	public boolean isCreateModelSelected() {
		return createMigrationButton.getSelection();
	}
	
	public String getMigrationFileName() {
		return text.getText();
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
			if(isCreateModelSelected()) {
				extension = new Path(getMigrationFileName()).getFileExtension();
				if (extension == null || !MIGRATION_EXTENSIONS.contains(extension)) {
					String key = MIGRATION_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
					setErrorMessage(MddeEditorPlugin.INSTANCE.getString(key, new Object[] { FORMATTED_MIGRATION_FILE_EXTENSIONS }));
					super.setPageComplete(false);
					return false;
					
				}
				
			}
			super.setPageComplete(true);
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

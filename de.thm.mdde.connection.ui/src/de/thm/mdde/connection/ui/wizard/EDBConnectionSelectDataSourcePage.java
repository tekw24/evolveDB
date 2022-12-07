package de.thm.mdde.connection.ui.wizard;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.widgets.LabelFactory;
import org.eclipse.jface.widgets.WidgetFactory;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;

public class EDBConnectionSelectDataSourcePage extends WizardPage {

	private EDBConnectionController controller;
	private String fFilter;

	private boolean fIsMultipleSelection = false;
	private boolean fMatchEmptyString = true;
	private boolean fAllowDuplicates = true;
	private boolean fIgnoreCase = true;
	private ILabelProvider fRenderer;
	private int fWidth = 60;
	private int fHeight = 18;

	/**
	 * Allows direct access to the filtered list.
	 */
	protected FilteredList fFilteredList;

	protected EDBConnectionSelectDataSourcePage(String pageName, String title, ImageDescriptor titleImage,
			EDBConnectionController controller) {
		super(pageName, title, titleImage);
		this.controller = controller;
		setMessage("This page shows the registered datasources.");

	}

	@Override
	public void createControl(Composite parent) {

		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		// layout.verticalSpacing =
		// convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.verticalSpacing = 15;
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		Composite composite = WidgetFactory.composite(SWT.NONE).layout(layout)
				.layoutData(new GridData(GridData.FILL_BOTH)).create(parent);

		createMessageArea(composite);
		createFilterText(composite);
		createFilteredList(composite);
		fFilteredList.setLabelProvider(new LabelProvider());

		fFilteredList.setElements(controller.loadGenerators());
		setPageComplete(false);
		setControl(composite);

	}

	/**
	 * Creates the message text widget and sets layout data.
	 *
	 * @param composite the parent composite of the message area.
	 */
	protected Label createMessageArea(Composite composite) {

		LabelFactory factory = WidgetFactory.label(SWT.NONE).font(composite.getFont());
		factory.text(
				"The list contains all registered datasources. New datasources can be added by contributing to the de.thm.mdde.datasource extension point.");
		Label label = factory.create(composite);

		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		label.setLayoutData(data);
		return label;
	}

	/**
	 * Creates the filter text. Subclasses are allowed to override if they want the
	 * text to be created differently and must not call super in this case.
	 *
	 * @param parent the parent to create the widget on
	 * @return the created filter text widget.
	 */
	protected Text createFilterText(Composite parent) {
		Text text = new Text(parent, SWT.BORDER);

		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		text.setLayoutData(data);
		text.setFont(parent.getFont());

		text.setText((fFilter == null ? "" : fFilter)); //$NON-NLS-1$

		Listener listener = e -> fFilteredList.setFilter(text.getText());
		text.addListener(SWT.Modify, listener);

		text.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					fFilteredList.setFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		return text;
	}

	/**
	 * Creates a filtered list.
	 *
	 * @param parent the parent composite.
	 * @return returns the filtered list widget.
	 */
	protected FilteredList createFilteredList(Composite parent) {
		int flags = SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | (fIsMultipleSelection ? SWT.MULTI : SWT.SINGLE);

		FilteredList list = new FilteredList(parent, flags, fRenderer, fIgnoreCase, fAllowDuplicates,
				fMatchEmptyString);

		GridData data = new GridData();
		data.widthHint = convertWidthInCharsToPixels(fWidth);
		data.heightHint = convertHeightInCharsToPixels(fHeight);
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		list.setLayoutData(data);
		list.setFont(parent.getFont());
		list.setFilter((fFilter == null ? "" : fFilter)); //$NON-NLS-1$

		list.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
//				handleDefaultSelected();
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleWidgetSelected();
			}
		});

		fFilteredList = list;

		return list;
	}

	private void handleWidgetSelected() {

		Object[] newSelection = fFilteredList.getSelection();
		if (newSelection.length == 1) {
			boolean result = controller.setDriver((String) newSelection[0]);
			setPageComplete(result);

		}
	}

	/**
	 * Sets the elements of the list (widget).
	 *
	 * @param elements the elements of the list.
	 */
	protected void setListElements(Object[] elements) {
		Assert.isNotNull(fFilteredList);
		fFilteredList.setElements(elements);
		handleElementsChanged();
	}

	/**
	 * This method is called when the elements of the backing list are changed to
	 * refresh the standard dialog widgets.
	 *
	 * @since 3.8
	 */
	protected void handleElementsChanged() {
		boolean enabled = !fFilteredList.isEmpty();
		fFilteredList.setEnabled(enabled);
	}

	@Override
	public void setVisible(boolean visible) {
		boolean disposed = true;
		if (!visible) {
			if (!controller.checkDriverExists()) {
				controller.openDownloadDriverPage();
				if (controller.checkDriverExists()) {
					disposed = controller.openConnectionUI();
				}else
					((WizardDialog) getContainer()).close();
			} else
				disposed = controller.openConnectionUI();

		}
		if (disposed)
			super.setVisible(visible);
	}

}

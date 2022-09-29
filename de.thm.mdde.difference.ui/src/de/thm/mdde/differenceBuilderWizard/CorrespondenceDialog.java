package de.thm.mdde.differenceBuilderWizard;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.Database_Schema;

public class CorrespondenceDialog extends TitleAreaDialog {

	private Table table;
	private List<EObject> matchingA;
	private List<EObject> matchingB;
	private Table tableA;
	private Table tableB;
	private Button okButton;

	private EObject eObjectA;
	private EObject eObjectB;

	protected CorrespondenceDialog(Shell parentShell, List<EObject> matchingA, List<EObject> matchingB) {
		super(parentShell);
		this.matchingA = matchingA;
		this.matchingB = matchingB;

	}

	@Override
	public void create() {
		super.create();
		setTitle("Add Matching");
		setMessage("In this dialog model elements can be matched.", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.None);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		tableA = createTabel(composite, matchingA, "Unmatched ResourceA");
		tableB = createTabel(composite, matchingB, "Unmatched ResourceB");

		return container;
	}

	private Table createTabel(Composite parent, List<EObject> matching, String label) {
		Table table = new org.eclipse.swt.widgets.Table(parent, SWT.BORDER | SWT.SINGLE);
		table.setToolTipText("Eine Tabelle");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				okButton.setEnabled(canFinish());
			}

		});

		TableColumn tc = new TableColumn(table, SWT.BORDER);
		tc.setText(label);
		tc.pack();
		tc.setMoveable(true);

		for (EObject e : matching) {
			String name = e.toString();
			if (e instanceof de.thm.evolvedb.mdde.Table) {
				name = ((de.thm.evolvedb.mdde.Table) e).getName();
			} else if (e instanceof Column) {
				Column column = (Column) e;
				name = column.getName() + " (" + column.getTable().getName() + ")";
			}

			TableItem item = new TableItem(table, SWT.BORDER);
			item.setText(new String[] { name });
			item.setData(item.getText(), e);

		}

		resizeColumns(table);

		return table;
	}

	private boolean canFinish() {
		return tableA.getSelectionCount() == 1 && tableB.getSelectionCount() == 1;
	}

	// override method to use "Login" as label for the OK button
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, "Create", true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void cancelPressed() {
		// TODO Auto-generated method stub
		super.cancelPressed();

	}

	@Override
	protected void okPressed() {
		TableItem a = tableA.getSelection()[0];
		TableItem b = tableB.getSelection()[0];
		this.eObjectA = (EObject) a.getData(a.getText());
		this.eObjectB = (EObject) b.getData(b.getText());
		super.okPressed();

	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add correspondence dialog");
	}

	private void resizeColumns(Table table) {
		Rectangle rect = table.getClientArea();
		if (rect.width > 0) {
			int extraSpace = rect.width / table.getColumns().length;
			// Resize the columns of the table
			for (TableColumn tc : table.getColumns())
				tc.setWidth(extraSpace);
		}
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(1000, 600);
	}

	public EObject geteObjectA() {
		return eObjectA;
	}

	public void seteObjectA(EObject eObjectA) {
		this.eObjectA = eObjectA;
	}

	public EObject geteObjectB() {
		return eObjectB;
	}

	public void seteObjectB(EObject eObjectB) {
		this.eObjectB = eObjectB;
	}

}

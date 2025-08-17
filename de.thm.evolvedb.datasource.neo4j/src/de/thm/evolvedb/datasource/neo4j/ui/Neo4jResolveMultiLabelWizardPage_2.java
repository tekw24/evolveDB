package de.thm.evolvedb.datasource.neo4j.ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableItem;

public class Neo4jResolveMultiLabelWizardPage_2 extends WizardPage {

	private final Map<String, ArrayList<String>> dataMap;
	private Combo keyCombo;
	private CheckboxTableViewer tableViewer;

	private Map<String, ArrayList<String>> selectedValues = new java.util.HashMap<>();

	protected Neo4jResolveMultiLabelWizardPage_2(String pageName, IStructuredSelection selection,
			Map<String, ArrayList<String>> dataMap) {
		super(pageName);
		this.dataMap = dataMap;
		setPageComplete(false);
		
		//adds all labels without selection
		for(Entry<String, ArrayList<String>> entry : dataMap.entrySet()) {
			selectedValues.put(entry.getKey(), new ArrayList<String>());
		}
		
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		// Combo for keys
		keyCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		keyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		keyCombo.setItems(dataMap.keySet().toArray(new String[0]));

		// TableViewer with checkboxes
		tableViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableViewer.setLabelProvider(new LabelProvider());

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		
		tableViewer.addCheckStateListener(event -> {
		    String currentKey = keyCombo.getText();
		    ArrayList<String> selected = getCurrentSelectedValues();
		    selectedValues.put(currentKey, selected);
		});
		
		

		// Combo selection logic
		keyCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selectedKey = keyCombo.getText();
				ArrayList<String> values = dataMap.get(selectedKey);
				if (values != null) {
					tableViewer.setInput(values);
					tableViewer.setAllChecked(false);
					
					
					
					
					
				}
			}
		});

		// Set default selection if available
		if (!dataMap.isEmpty()) {
			keyCombo.select(0);
			tableViewer.setInput(dataMap.get(keyCombo.getItem(0)));
		}

		setControl(container);
	}

	public String getSelectedKey() {
		return keyCombo.getText();
	}

	public ArrayList<String> getCurrentSelectedValues() {
		ArrayList<String> selected = new ArrayList<>();
		for (TableItem item : tableViewer.getTable().getItems()) {
			if (item.getChecked()) {
				selected.add(item.getText());
			}
		}
		return selected;
	}

	public Map<String, ArrayList<String>> getSelectedValues() {
		return selectedValues;
	}

	
	

}

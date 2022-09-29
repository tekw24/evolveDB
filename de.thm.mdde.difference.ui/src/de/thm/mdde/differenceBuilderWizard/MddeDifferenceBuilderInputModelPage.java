package de.thm.mdde.differenceBuilderWizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.thm.mdde.commonui.widgets.ModelDirectionWidget;

public class MddeDifferenceBuilderInputModelPage extends WizardPage{

	private MddeDifferenceBuilderController controller;

	protected MddeDifferenceBuilderInputModelPage(String pageName, MddeDifferenceBuilderController controller) {
		super(pageName);
		this.controller = controller;
	}

	@Override
	public void createControl(Composite parent) {
		
		Composite control = new Composite(parent, SWT.NULL);
		control.setLayout(new GridLayout(1, false));
		
		
		ModelDirectionWidget widget = new ModelDirectionWidget(controller.getInputModels());
		widget.createContents(control);
		
		setControl(control);
	}

}

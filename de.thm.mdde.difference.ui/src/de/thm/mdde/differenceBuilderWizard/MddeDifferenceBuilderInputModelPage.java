/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @Author Torben
 */
package de.thm.mdde.differenceBuilderWizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

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
		
		Label label = new Label(control, SWT.NONE);		
		label.setText("Choose the model comparison direction. The arrow should point at the edited model version.");
		
		Composite control2 = new Composite(control, SWT.NULL);
		control2.setLayout(new GridLayout(1, false));
		
		ModelDirectionWidget widget = new ModelDirectionWidget(controller.getInputModels());
		widget.createContents(control2);
		
		setControl(control);
	}

}

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
 */
package de.thm.mdde.commonui.widgets;

import java.util.Objects;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.sidiff.common.emf.input.InputModels;
import org.sidiff.common.emf.input.ui.internal.EmfInputUiPlugin;

public class ModelDirectionWidget {

	private String arrowLabel;
	private InputModels inputModels;
	private boolean inverseDirection = false;

	public ModelDirectionWidget(InputModels inputModels) {
		Assert.isLegal(inputModels.getFiles().size() == 2, "Exactly two input models must be specified");
		this.inputModels = inputModels;
		//setTitle("Select origin model");
		setArrowLabel("Direction");
	}

	
	public Composite createContents(Composite container) {

		Composite gridContainer = new Composite(container, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(gridContainer);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(gridContainer);

		// Model A:
		Button radioA = new Button(gridContainer, SWT.RADIO);
		radioA.setText("Model: " + inputModels.getLabels().get(0));
		radioA.setSelection(true);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, true).applyTo(radioA);

		// Arrow:
		final Image arrowUp = EmfInputUiPlugin.getImage(EmfInputUiPlugin.IMAGE_ARROW_UP);
		final Image arrowDown = EmfInputUiPlugin.getImage(EmfInputUiPlugin.IMAGE_ARROW_DOWN);

		final Label arrowImage = new Label(gridContainer, SWT.NONE);
		arrowImage.setImage(inverseDirection ? arrowUp : arrowDown);
		arrowImage.addDisposeListener(e -> {
			arrowUp.dispose();
			arrowDown.dispose();
		});
		GridDataFactory.fillDefaults().grab(false, true).applyTo(arrowImage);

		Label arrowText = new Label(gridContainer, SWT.NONE);
		arrowText.setSize(55, 15);
		arrowText.setText(arrowLabel);
		GridDataFactory.swtDefaults().grab(false, true).applyTo(arrowText);

		// Model B:
		Button radioB = new Button(gridContainer, SWT.RADIO);
		radioB.setText("Model: " + inputModels.getLabels().get(1));
		GridDataFactory.fillDefaults().span(2, 1).grab(true, true).applyTo(radioB);

		/*
		 * Swap action
		 */

		SelectionListener selectionListener = SelectionListener.widgetSelectedAdapter(e -> {
			if ((inverseDirection && radioA.getSelection()) || (!inverseDirection && radioB.getSelection())) {
				inverseDirection = !inverseDirection;
				arrowImage.setImage(inverseDirection ? arrowUp : arrowDown);
				inputModels.swap();
			}
		});

		radioA.addSelectionListener(selectionListener);
		radioB.addSelectionListener(selectionListener);

		return gridContainer;
	}

	public void setArrowLabel(String arrowLabel) {
		this.arrowLabel = Objects.requireNonNull(arrowLabel);
	}

	public String getArrowLabel() {
		return arrowLabel;
	}


}

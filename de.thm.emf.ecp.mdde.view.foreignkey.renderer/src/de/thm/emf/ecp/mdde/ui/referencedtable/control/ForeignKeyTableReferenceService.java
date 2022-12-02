/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.emf.ecp.mdde.ui.referencedtable.control;

import static java.util.Collections.singleton;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.edit.spi.ReferenceService;
import org.eclipse.emf.ecp.internal.edit.ECPControlHelper;
import org.eclipse.emf.ecp.spi.common.ui.SelectModelElementWizardFactory;
import org.eclipse.emf.ecp.spi.common.ui.composites.SelectionComposite;
import org.eclipse.emf.ecp.ui.view.swt.reference.AttachmentStrategy;
import org.eclipse.emf.ecp.ui.view.swt.reference.CreateNewModelElementStrategy;
import org.eclipse.emf.ecp.ui.view.swt.reference.EObjectSelectionStrategy;
import org.eclipse.emf.ecp.ui.view.swt.reference.OpenInNewContextStrategy;
import org.eclipse.emf.ecp.ui.view.swt.reference.ReferenceStrategy;
import org.eclipse.emf.ecp.ui.view.swt.reference.SelectionCompositeStrategy;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emfforms.common.Optional;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.Table;

/**
 * @author Torben
 *
 */
public class ForeignKeyTableReferenceService implements ReferenceService {

	private EObjectSelectionStrategy eobjectSelectionStrategy = EObjectSelectionStrategy.NULL;
	private CreateNewModelElementStrategy createNewModelElementStrategy = CreateNewModelElementStrategy.DEFAULT;
	private AttachmentStrategy attachmentStrategy = AttachmentStrategy.DEFAULT;
	private ReferenceStrategy referenceStrategy = ReferenceStrategy.DEFAULT;
	private OpenInNewContextStrategy openInNewContextStrategy = OpenInNewContextStrategy.DEFAULT;
	private SelectionCompositeStrategy selectionCompositeStrategy = SelectionCompositeStrategy.DEFAULT;

	@Override
	public void instantiate(ViewModelContext context) {
		// Nothing to do
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public int getPriority() {
		return 2;
	}

	@Deprecated
	@Override
	public void addNewModelElements(EObject eObject, EReference eReference) {
		addNewModelElements(eObject, eReference, true);
	}

	/**
	 * @since 1.17
	 */
	@Override
	public Optional<EObject> addNewModelElements(EObject eObject, EReference eReference, boolean openInNewContext) {
		if (eReference.isContainer()) {
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", //$NON-NLS-1$
				"Operation not permitted for container references!");//$NON-NLS-1$
			return Optional.empty();
		}

		final Optional<EObject> newMEInstanceOptional = createNewModelElementStrategy.createNewModelElement(eObject,
			eReference);

		if (!newMEInstanceOptional.isPresent()) {
			return Optional.empty();
		}
		final EObject newMEInstance = newMEInstanceOptional.get();

		if (!eReference.isContainment()) {
			attachmentStrategy.addElementToModel(eObject, eReference, newMEInstance);
		}

		referenceStrategy.addElementsToReference(eObject, eReference, singleton(newMEInstance));

		if (openInNewContext) {
			openInNewContext(newMEInstance);
		}

		return newMEInstanceOptional;
	}

	@Override
	public void openInNewContext(final EObject eObject) {
		final EObject owner = eObject.eContainer();
		final EReference reference = eObject.eContainmentFeature();
		openInNewContextStrategy.openInNewContext(owner, reference, eObject);
	}

	@Override
	public void addExistingModelElements(EObject eObject, EReference eReference) {

		final Iterator<EObject> allElements = ItemPropertyDescriptor
			.getReachableObjectsOfType(eObject, eReference.getEType())
			.iterator();

		Set<EObject> elements = new LinkedHashSet<EObject>();
		while (allElements.hasNext()) {
			elements.add(allElements.next());
		}

		elements = new LinkedHashSet<EObject>(
			eobjectSelectionStrategy.collectExistingObjects(eObject, eReference, elements));
		ECPControlHelper.removeExistingReferences(eObject, eReference, elements);

		final SelectionComposite<? extends StructuredViewer> selectionComposite = selectionCompositeStrategy
			.getSelectionViewer(eObject, eReference, elements);
		final Set<EObject> addedElements;
		if (selectionComposite == null) {
			addedElements = SelectModelElementWizardFactory
				.openModelElementSelectionDialog(elements, eReference.isMany());
		} else {
			addedElements = SelectModelElementWizardFactory.openModelElementSelectionDialog(selectionComposite);
		}

		// Don't invoke the Bazaar machinery to find a strategy just to add no elements
		if (!addedElements.isEmpty()) {
			referenceStrategy.addElementsToReference(eObject, eReference, addedElements);

			// Set the referenced key to null if a different is selected
			final ForeignKey foreignKey = (ForeignKey) eObject;
			if (foreignKey.getReferencedKeyColumn() != null) {

				for (final EObject eo : addedElements) {

					if (eo instanceof Table) {

						final Table table = (Table) eo;
						if (!table.getPrimaryKeys().contains(foreignKey.getReferencedKeyColumn())) {

							final EReference eReferencedKey = MddePackage.eINSTANCE.getForeignKey_ReferencedKeyColumn();
							delete(eObject, eReferencedKey);

						}
					}
				}
			}
		}
	}

	private void delete(EObject eObject, EReference reference) {
		final EditingDomain editingDomain = getEditingDomain(eObject);
		final Command removeCommand = SetCommand.create(editingDomain, eObject,
			reference, null);
		if (removeCommand.canExecute()) {
			editingDomain.getCommandStack().execute(removeCommand);
		}
	}

	/**
	 * Returns the {@link EditingDomain} for the provided {@link EObject domain model}.
	 *
	 * @param domainModel The provided {@link EObject domain model}
	 * @return The {@link EditingDomain} of this {@link EObject domain model}
	 * @since 1.6
	 */
	protected final EditingDomain getEditingDomain(EObject domainModel) {
		return AdapterFactoryEditingDomain.getEditingDomainFor(domainModel);
	}

	/**
	 * Add a strategy for selection of eligible existing {@link EObject}s to add
	 * to references.
	 *
	 * @param strategy a strategy to set
	 *
	 * @since 1.16
	 */
	void setEObjectSelectionStrategy(EObjectSelectionStrategy strategy) {
		if (strategy == null) {
			strategy = EObjectSelectionStrategy.NULL;
		}

		eobjectSelectionStrategy = strategy;
	}

	/**
	 * Add a strategy for the creation of a new model element.
	 *
	 * @param strategy The strategy to set
	 */
	void setCreateNewModelElementStrategy(CreateNewModelElementStrategy strategy) {
		if (strategy == null) {
			strategy = CreateNewModelElementStrategy.DEFAULT;
		}

		createNewModelElementStrategy = strategy;
	}

	/**
	 * Set a new attachment strategy ahead of previously added strategies.
	 *
	 * @param strategy an attachment strategy to set
	 *
	 * @since 1.16
	 */
	void setAttachmentStrategy(AttachmentStrategy strategy) {
		if (strategy == null) {
			strategy = AttachmentStrategy.DEFAULT;
		}

		attachmentStrategy = strategy;
	}

	/**
	 * Set a new reference strategy ahead of previously added strategies.
	 *
	 * @param strategy an reference strategy to set
	 *
	 * @since 1.16
	 */
	void setReferenceStrategy(ReferenceStrategy strategy) {
		if (strategy == null) {
			strategy = ReferenceStrategy.DEFAULT;
		}

		referenceStrategy = strategy;
	}

	/**
	 * Set a new open strategy ahead of previously added strategies.
	 *
	 * @param strategy an open strategy to set
	 *
	 * @since 1.16
	 */
	void setOpenStrategy(OpenInNewContextStrategy strategy) {
		if (strategy == null) {
			strategy = OpenInNewContextStrategy.DEFAULT;
		}

		openInNewContextStrategy = strategy;
	}

	/**
	 * Set the strategy for creation of the table composite to present in the selection dialog.
	 *
	 * @param strategy a table column strategy to set
	 *
	 * @since 1.22
	 */
	void setSelectionCompositeStrategyy(SelectionCompositeStrategy strategy) {
		if (strategy == null) {
			strategy = SelectionCompositeStrategy.DEFAULT;
		}

		selectionCompositeStrategy = strategy;
	}

}

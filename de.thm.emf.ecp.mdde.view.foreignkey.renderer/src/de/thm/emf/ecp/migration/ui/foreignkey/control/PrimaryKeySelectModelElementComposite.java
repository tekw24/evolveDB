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
package de.thm.emf.ecp.migration.ui.foreignkey.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.spi.common.ui.ECPViewerFilter;
import org.eclipse.emf.ecp.spi.common.ui.composites.AbstractFilteredSelectionComposite;
import org.eclipse.emf.ecp.spi.common.ui.composites.SelectionComposite;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import de.thm.evolvedb.mdde.PrimaryKey;

/**
 * @author Torben
 *
 */
public class PrimaryKeySelectModelElementComposite extends AbstractFilteredSelectionComposite<TableViewer> implements
	SelectionComposite<TableViewer> {

	private final ECPViewerFilter filter;

	private final Object input;

	private final ComposedAdapterFactory composedAdapterFactory;

	private final AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	private final boolean multiSelection;

	/**
	 * Default Constructor for the SelectModelElementCompositeImpl.
	 *
	 * @param input the input for the selection
	 * @param multiSelection whether multi selection is allowed
	 * @since 1.5
	 */
	public PrimaryKeySelectModelElementComposite(Object input, boolean multiSelection) {
		super();
		this.multiSelection = multiSelection;
		composedAdapterFactory = new ComposedAdapterFactory(new AdapterFactory[] {
			new ReflectiveItemProviderAdapterFactory(),
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
		filter = new ModelElementViewerFilter(adapterFactoryLabelProvider);
		this.input = input;
	}

	/**
	 * Returns the label provider.
	 *
	 * @return the label provider
	 */
	protected ILabelProvider getLabelProvider() {
		return adapterFactoryLabelProvider;
	}

	/**
	 * Returns the viewer input.
	 *
	 * @return the input
	 */
	protected Object getInput() {
		return input;
	}

	/** {@inheritDoc} **/
	@Override
	protected ECPViewerFilter getFilter() {
		return filter;
	}

	/** {@inheritDoc} **/
	@Override
	protected TableViewer createViewer(Composite composite) {
		TableViewer lv;
		if (multiSelection) {
			lv = new TableViewer(composite);
		} else {
			lv = new TableViewer(composite, SWT.SINGLE);
		}
		// lv.setLabelProvider(getLabelProvider());

		final TableViewerColumn colName = new TableViewerColumn(lv, SWT.NONE);
		colName.getColumn().setWidth(100);
		colName.getColumn().setText("Name");
		colName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				final PrimaryKey p = (PrimaryKey) element;
				return p.getName();
			}

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
			 */
			@Override
			public Image getImage(Object element) {
				return getLabelProvider().getImage(element);
			}

		});

		final TableViewerColumn colTable = new TableViewerColumn(lv, SWT.NONE);
		colTable.getColumn().setWidth(200);
		colTable.getColumn().setText("Table");
		colTable.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				final PrimaryKey p = (PrimaryKey) element;
				return p.getTable().getName() != null ? p.getTable().getName() : "Name not set!";
			}

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
			 */
			@Override
			public Image getImage(Object element) {
				final PrimaryKey p = (PrimaryKey) element;
				return getLabelProvider().getImage(p.getTable());
			}

		});

		lv.setContentProvider(ArrayContentProvider.getInstance());
		lv.setComparator(new ViewerComparator());
		lv.setInput(getInput());
		return lv;
	}

	/** {@inheritDoc} **/
	@Override
	public void dispose() {
		composedAdapterFactory.dispose();
		adapterFactoryLabelProvider.dispose();
	}

	/**
	 * Private Implementation of a {@link ECPViewerFilter} for ModelElements.
	 *
	 * @author Eugen Neufeld
	 *
	 */
	private final class ModelElementViewerFilter extends ECPViewerFilter {

		private static final String WILDCARD = "*"; //$NON-NLS-1$
		private final ILabelProvider labelProvider;

		ModelElementViewerFilter(ILabelProvider labelProvider) {
			this.labelProvider = labelProvider;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (getSearchTerm() == null || getSearchTerm().length() == 0) {
				return true;
			}
			if (!(element instanceof EObject)) {
				return false;
			}
			// TODO is this ok so?
			final EObject eObjectToFilter = (EObject) element;

			final String eObjectName = labelProvider.getText(eObjectToFilter);

			String searchString = getSearchTerm();
			if (!searchString.startsWith(WILDCARD)) {
				searchString = WILDCARD + searchString + WILDCARD;
			}
			final Pattern pattern = Pattern.compile(wildcardToRegex(searchString), Pattern.CASE_INSENSITIVE);
			final Matcher matcher = pattern.matcher(eObjectName);
			return matcher.matches();
		}
		// BEGIN COMPLEX CODE

		private String wildcardToRegex(String wildcard) {
			final StringBuffer s = new StringBuffer(wildcard.length());
			s.append('^');
			for (int i = 0, is = wildcard.length(); i < is; i++) {
				final char c = wildcard.charAt(i);
				switch (c) {
				case '*':
					s.append(".*"); //$NON-NLS-1$
					break;
				case '?':
					s.append("."); //$NON-NLS-1$
					break;
				case ' ':
					s.append("\\s"); //$NON-NLS-1$
					break;
				// escape special regexp-characters
				case '(':
				case ')':
				case '[':
				case ']':
				case '$':
				case '^':
				case '.':
				case '{':
				case '}':
				case '|':
				case '\\':
					s.append("\\"); //$NON-NLS-1$
					s.append(c);
					break;
				default:
					s.append(c);
					break;
				}
			}
			s.append('$');
			return s.toString();
			// END COMPLEX CODE
		}
	}

}

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
package de.thm.mdde.migration.view.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecp.common.spi.ChildrenDescriptorCollector;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfforms.internal.editor.ui.EditorToolBar;
import org.eclipse.emfforms.internal.swt.treemasterdetail.defaultprovider.DefaultDeleteActionBuilder;
import org.eclipse.emfforms.spi.editor.GenericEditor;
import org.eclipse.emfforms.spi.editor.IEditingDomainAware;
import org.eclipse.emfforms.spi.swt.treemasterdetail.MenuProvider;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailComposite;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailMenuListener;
import org.eclipse.emfforms.spi.swt.treemasterdetail.TreeMasterDetailSWTBuilder;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.ActionCollector;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.MasterDetailAction;
import org.eclipse.emfforms.spi.swt.treemasterdetail.actions.delegating.PasteMasterDetailAction;
import org.eclipse.emfforms.spi.swt.treemasterdetail.util.CreateElementCallback;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import de.thm.evolvedb.migration.SchemaModificationOperator;
import de.thm.mdde.migration.view.editor.action.ResolvemasterDetailAction;
import de.thm.mdde.migration.view.editor.action.UnresolvemasterDetailAction;
import de.thm.mdde.migration.view.editor.toolbar.GenerateAction;
import de.thm.mdde.migration.view.editor.toolbar.ValidateModelAction;

public class MigrationCustomEditor extends GenericEditor {

	private boolean dirtyFlag;
	private String filterText = "";
	private TreeMasterDetailSWTBuilder builder;

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
	}

	/**
	 * Returns the title for the currently displayed editor. Subclasses should
	 * override this function to change the Editor's title
	 *
	 * @return the title
	 */
	@Override
	protected String getEditorTitle() {
		return "Migration Editor";
	}

	/**
	 * Returns the toolbar actions for this editor.
	 *
	 * @return A list of actions to show in the Editor's Toolbar
	 * @since 1.10
	 */
	@Override
	protected List<Action> getToolbarActions() {
		List<Action> result = new LinkedList<Action>();
		result.add(new GenerateAction(super.getResourceSet()));
		result.add(new ValidateModelAction(super.getResourceSet()));
		return result;

	}

	@Override
	public void firePropertyChange(int propertyId) {
		super.firePropertyChange(propertyId);
	}

	public void firePropertyChange(int propertyId, boolean dirty) {
		dirtyFlag = dirty;
		super.firePropertyChange(propertyId);
		dirtyFlag = false;
	}

	@Override
	public boolean isDirty() {
		if (dirtyFlag)
			return true;
		return super.isDirty();
	}
	
	/**
	 * Creates the top area of the editor.
	 *
	 * @param parent The parent {@link Composite}
	 * @param editorTitle The title of the editor
	 * @param editorInput the editor input
	 * @param toolbarActions The actions shown on the top area
	 * @param createElementCallback a call back if elements are created
	 * @return a {@link TreeMasterDetailComposite}
	 * @since 1.14
	 */
	protected TreeMasterDetailComposite createRootView(Composite parent, String editorTitle, Object editorInput,
		List<Action> toolbarActions, CreateElementCallback createElementCallback) {
		final Composite composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new FormLayout());

		final FormData toolbarLayoutData = new FormData();
		toolbarLayoutData.left = new FormAttachment(0);
		toolbarLayoutData.right = new FormAttachment(100);
		toolbarLayoutData.top = new FormAttachment(0);
		final EditorToolBar toolbar = new EditorToolBar(composite, SWT.NONE, editorTitle, toolbarActions);
		toolbar.setLayoutData(toolbarLayoutData);
		
		
		final FormData filterLayoutData = new FormData();
		filterLayoutData.left = new FormAttachment(1);
		filterLayoutData.right = new FormAttachment(50);
		filterLayoutData.top = new FormAttachment(toolbar,5);
		final Text filter = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
		filter.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				refreshTreeFilter(filter.getText());
				
			}
		});
		filter.setLayoutData(filterLayoutData);
		
		

		final FormData treeMasterDetailLayoutData = new FormData();
		treeMasterDetailLayoutData.top = new FormAttachment(filter, 5);
		treeMasterDetailLayoutData.left = new FormAttachment(0);
		treeMasterDetailLayoutData.right = new FormAttachment(100);
		treeMasterDetailLayoutData.bottom = new FormAttachment(100);
		final TreeMasterDetailComposite treeMasterDetail = createTreeMasterDetail(composite, editorInput,
			createElementCallback);
		treeMasterDetail.setLayoutData(treeMasterDetailLayoutData);

		for (final Action action : toolbarActions) {
			if (action instanceof IEditingDomainAware) {
				((IEditingDomainAware) action).setEditingDomain(getEditingDomain());
			}
		}
		return treeMasterDetail;
	}
	
	@Override
	protected TreeMasterDetailSWTBuilder customizeTree(TreeMasterDetailSWTBuilder builder) {
		this.builder = builder;
		ViewerFilter viewerFilter = new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return true;
			}
			
			@Override
			public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
				List<Object> objects = new ArrayList<>();
				objects.addAll(Arrays.asList(elements));
				for(Object element : elements) {
					if(element instanceof SchemaModificationOperator) {
						SchemaModificationOperator t = (SchemaModificationOperator) element;
						if(!t.getDescription().contains(filterText))
							objects.remove(element);
							
					}
				}
						
				return super.filter(viewer, parent, objects.toArray());
			}
		};
		ViewerFilter[] array = {viewerFilter};
		builder.customizeViewerFilters(array);
		
		builder.customizeMenu(new MenuProvider() {
			@Override
			public Menu getMenu(TreeViewer treeViewer, EditingDomain editingDomain) {
				final MenuManager menuMgr = new MenuManager();
				menuMgr.setRemoveAllWhenShown(true);
				
				final List<MasterDetailAction> masterDetailActions = ActionCollector.newList().addCutAction(editingDomain).addCopyAction(editingDomain).addPasteAction(editingDomain)
						.add(new ResolvemasterDetailAction(editingDomain)).add(new UnresolvemasterDetailAction(editingDomain)).getList();

				menuMgr.addMenuListener(new TreeMasterDetailMenuListener(new ChildrenDescriptorCollector(), menuMgr,
					treeViewer, editingDomain, masterDetailActions, getCreateElementCallback(),
					new DefaultDeleteActionBuilder()));
				final Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
				return menu;

			}
		});
		
		
		
		return super.customizeTree(builder);
	}
	
	public void refreshTreeFilter(String filter) {
		this.filterText = filter;
		customizeTree(builder);
		super.refreshTreeAfterResourceChange();
		
	}
	
	public MasterDetailAction addResolveAction(EditingDomain editingDomain) {
		return new ResolvemasterDetailAction(editingDomain);
	}
	
	

}

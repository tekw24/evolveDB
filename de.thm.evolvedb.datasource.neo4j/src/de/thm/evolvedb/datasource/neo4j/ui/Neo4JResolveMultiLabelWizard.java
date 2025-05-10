package de.thm.evolvedb.datasource.neo4j.ui;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.thm.evolvedb.datasource.neo4j.model.Neo4jModelCreator;
import de.thm.evolvedb.graph.presentation.GraphEditorPlugin;

public class Neo4JResolveMultiLabelWizard extends Wizard implements INewWizard{

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private Neo4jResolveMultiLabelWizardPage_2 labelWizardPage_2;
	private Neo4jModelCreator neo4jModelCreator;
	private Map<String, ArrayList<String>> labelKombos;
	

	public Neo4JResolveMultiLabelWizard(Neo4jModelCreator neo4jModelCreator, Map<String, ArrayList<String>> labelKombos) {
		this.neo4jModelCreator = neo4jModelCreator;
		this.labelKombos = labelKombos;
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;	
		setWindowTitle(GraphEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(GraphEditorPlugin.INSTANCE.getImage("full/wizban/NewGraph")));
		
	}
	
	@Override
	public boolean canFinish() {
		//&& mddeDatabaseModelConnectionWizardPage_2.isPageComplete() TODO
		return labelWizardPage_2.isPageComplete() ;
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void addPages() {
		labelWizardPage_2 = new Neo4jResolveMultiLabelWizardPage_2("Whatever", selection, labelKombos);
		labelWizardPage_2.setTitle(GraphEditorPlugin.INSTANCE.getString("_UI_GraphModelWizard_label"));
		labelWizardPage_2.setDescription(GraphEditorPlugin.INSTANCE.getString("_UI_GraphModelWizard_description"));
//		connectionWizardPage_1.setFileName(MddeEditorPlugin.INSTANCE.getString("_UI_MddeEditorFilenameDefaultBase") + "."
//				+ FILE_EXTENSIONS.get(0));
		addPage(labelWizardPage_2);
		labelWizardPage_2.setPageComplete(true);
	}
	
	public Map<String, ArrayList<String>> getSelectedValues(){
		return labelWizardPage_2.getSelectedValues();
	}

}

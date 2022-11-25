package de.thm.mdde.drivermanager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.e4.core.di.annotations.Execute;


import de.thm.mdde.datasource.EDBDataSource;



public class EvalutaionContributionHandler {
	private static final String EXTENSION_POINT_ID = "de.thm.mdde.datasource";

	@Execute
	public List<EDBDataSource> execute(IExtensionRegistry registry) {
		IConfigurationElement[] config = registry.getConfigurationElementsFor(EXTENSION_POINT_ID);
		List<EDBDataSource> generators = new ArrayList<>();
		try {
			
			for (IConfigurationElement e : config) {				
				final Object o = e.createExecutableExtension("class");
				if (o instanceof EDBDataSource) {
					generators.add((EDBDataSource) o);
				}
			}
			
			return generators;
			

		} catch (CoreException ex) {
			ex.printStackTrace();
			if(generators.size() > 0)
				return generators;
		}
		
		return null;
	}

	/**
	 * This method opens a ElementListSelectionDialog where the user can choose between the registered ISQLgenerators.
	 * @param generators
	 * @return
	 */
//	private ISQLGenerator chooseGenerator(List<ISQLGenerator> generators) {
//		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(),
//				new LabelProvider());
//		
//		List<String> displayNames = generators.stream().map(e -> e.getDisplayName()).collect(Collectors.toList());
//		
//		//Convert the list into an array
//		String[] array = new String[displayNames.size()];
//		displayNames.toArray(array);
//		
//		dialog.setElements(array);
//		dialog.setTitle("Generator Selection");
//		dialog.setMessage("Which generator should be used?");
//		// user pressed cancel
//		if (dialog.open() != Window.OK) {
//			return null;
//		}	
//		Object[] result = dialog.getResult();
//		if(result.length == 1) {
//			Optional<ISQLGenerator> o = generators.stream().filter(p -> p.getDisplayName().equals((String)result[0])).findFirst();
//			return o.get();
//		}
//		return null;
//	}
//
//	private void executeExtension(final Object o) {
//		ISafeRunnable runnable = new ISafeRunnable() {
//			@Override
//			public void handleException(Throwable e) {
//				System.out.println("Exception in client");
//			}
//
//			@Override
//			public void run() throws Exception {
////				((ISQLGenerator) o).greet();
//			}
//		};
//		SafeRunner.run(runnable);
//	}
}

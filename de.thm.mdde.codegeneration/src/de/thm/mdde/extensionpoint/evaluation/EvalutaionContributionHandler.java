package de.thm.mdde.extensionpoint.evaluation;

import de.thm.extensionpoint.interfaces.ISQLGenerator;

import java.security.AlgorithmParameterGeneratorSpi;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;



public class EvalutaionContributionHandler {
	private static final String ISQL_GENERATOR_ID = "de.thm.mdde.extensionpoint.SQLGenerator";

	@Execute
	public List<ISQLGenerator> execute(IExtensionRegistry registry) {
		IConfigurationElement[] config = registry.getConfigurationElementsFor(ISQL_GENERATOR_ID);
		List<ISQLGenerator> generators = new ArrayList<>();
		try {
			
			for (IConfigurationElement e : config) {
				System.out.println("Evaluating extension");
				final Object o = e.createExecutableExtension("class");
				if (o instanceof ISQLGenerator) {
					generators.add((ISQLGenerator) o);
				}
			}
			
			return generators;
			
//			if(generators.size() > 0) {
//				ISQLGenerator sqGenerator = chooseGenerator(generators);
//				if (sqGenerator != null) {
//					return sqGenerator;
//					
//				}
//			}

		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
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
	private ISQLGenerator chooseGenerator(List<ISQLGenerator> generators) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(),
				new LabelProvider());
		
		List<String> displayNames = generators.stream().map(e -> e.getDisplayName()).collect(Collectors.toList());
		
		//Convert the list into an array
		String[] array = new String[displayNames.size()];
		displayNames.toArray(array);
		
		dialog.setElements(array);
		dialog.setTitle("Generator Selection");
		dialog.setMessage("Which generator should be used?");
		// user pressed cancel
		if (dialog.open() != Window.OK) {
			return null;
		}	
		Object[] result = dialog.getResult();
		if(result.length == 1) {
			Optional<ISQLGenerator> o = generators.stream().filter(p -> p.getDisplayName().equals((String)result[0])).findFirst();
			return o.get();
		}
		return null;
	}

	private void executeExtension(final Object o) {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				System.out.println("Exception in client");
			}

			@Override
			public void run() throws Exception {
//				((ISQLGenerator) o).greet();
			}
		};
		SafeRunner.run(runnable);
	}
}
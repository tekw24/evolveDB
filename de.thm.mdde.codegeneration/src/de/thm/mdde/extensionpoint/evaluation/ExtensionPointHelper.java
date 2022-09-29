package de.thm.mdde.extensionpoint.evaluation;

import java.util.List;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import de.thm.extensionpoint.interfaces.ISQLGenerator;


public class ExtensionPointHelper {

	public static List<ISQLGenerator> loadRegisteredSQLGenerators() {
		// Find registered generators
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		EvalutaionContributionHandler handler = new EvalutaionContributionHandler();
		List<ISQLGenerator>generator = handler.execute(registry);
		return generator;

	}

}

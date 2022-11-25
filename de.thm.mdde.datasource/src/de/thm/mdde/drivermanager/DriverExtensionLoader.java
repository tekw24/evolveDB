package de.thm.mdde.drivermanager;

import java.util.List;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import de.thm.mdde.datasource.EDBDataSource;



public class DriverExtensionLoader {

	public static List<EDBDataSource> loadRegisteredDrivers() {
		// Find registered generators
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		EvalutaionContributionHandler handler = new EvalutaionContributionHandler();
		List<EDBDataSource>generator = handler.execute(registry);
		return generator;

	}

}

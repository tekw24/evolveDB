package de.thm.commands;

import de.thm.connection.classloader.DriverClassLoader;
import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;
import de.thm.mdde.connection.driver.ui.DriverDownloadDialog;
import de.thm.mdde.connection.ui.wizard.EDBConnectionWizard;
import de.thm.mdde.datasource.EDBDataSource;
import de.thm.mdde.drivermanager.DriverExtensionLoader;
import de.thm.mdde.extensionpoint.evaluation.ExtensionPointHelper;
import de.thm.mdde.preferences.EDBPreferenceInitializer;
import de.thm.mdde.ui.MDDECodeGenerationWizard;
import de.thm.mdde.wizard.MddeDatabaseConnectionModelWizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.service.prefs.Preferences;

public class OpenDriverWizardCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell activeShell = HandlerUtil.getActiveShell(event);
		// IWizard wizard = new MddeDatabaseConnectionModelWizard();
		
		WizardDialog wizardDialog = new WizardDialog(activeShell, new EDBConnectionWizard());

		wizardDialog.open();

		List<EDBDataSource> drivers = DriverExtensionLoader.loadRegisteredDrivers();

		if (drivers.size() == 1) {

			EDBDataSource dataSource = drivers.get(0);

			String path = dataSource.getDriver().getDriverLibraries().get(0).getLocalFile();
			Path localFile = Paths.get(path);

			if (Files.exists(localFile)) {

				// Paths.get("C:\\Users\\Torben\\Documents\\Promotion2022\\mysql-connector-java-8.0.29.jar");

				// DriverClassLoader driverClassLoader = new
				// DriverClassLoader(dataSource.getDriver().getDriverLibraries(), null, null);

				URLClassLoader child;
				try {
					child = new URLClassLoader(new URL[] { localFile.toUri().toURL() },
							this.getClass().getClassLoader());

					Class classToLoad = Class.forName(dataSource.getDriver().getDriverClassName(), true, child);

					System.out.println();

//			Method method = classToLoad.getDeclaredMethod("myMethod");
//			Object instance = classToLoad.newInstance();
//			Object result = method.invoke(instance);

				} catch (MalformedURLException | ClassNotFoundException | SecurityException
						| IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				trackUserSettings();

				DriverDownloadDialog dialog = new DriverDownloadDialog(activeShell, dataSource.getDriver(),
						dataSource.getDriverDependencies(), false, false);
				dialog.setMinimumPageSize(100, 100);
				dialog.open();
			}
		}
		
		

	

		return null;
	}

	private void loadLocalFiles(Path localFile) {
		List<Path> result = new ArrayList<>();
		// Path localFile = library.getLocalFile();
		if (localFile != null) {

			if (Files.exists(localFile) && !Files.isDirectory(localFile)) {

			} else {
				if (Files.isDirectory(localFile)) {
					try {
						List<Path> folderFiles = Files.list(localFile).filter(p -> {
							String fileName = p.getFileName().toString();
							return fileName.endsWith(".jar") || fileName.endsWith(".zip");
						}).collect(Collectors.toList());

						if (!folderFiles.isEmpty()) {
							result.addAll(folderFiles);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (!result.contains(localFile)) {
					result.add(localFile);
				}
			}

		}
	}

	public void trackUserSettings() {

		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"de.thm.mdde.preferences");
		String string = scopedPreferenceStore.getString("de.thm.mdde.preferences");

		Preferences preferences = InstanceScope.INSTANCE.getNode("de.thm.mdde.preferences");
//		Preferences sub1 = preferences.node("node1");
//		Preferences sub2 = preferences.node("node2");
//		sub1.get("h1", "default");
//		sub1.get("h2", "default");
//		sub2.get("h1", "default");
		System.out.println();
	}

	public String loadLocationSetting() {
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"de.thm.mdde.preferences");
		String location = scopedPreferenceStore.getString(EDBPreferenceInitializer.DRIVER_DEFAULT_LOCATION);

		return location != null ? location : null;
	}

}
package de.thm.mdde.connection.ui.wizard;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.thm.mdde.connection.driver.ui.DriverDownloadDialog;
import de.thm.mdde.datasource.EDBDataSource;
import de.thm.mdde.drivermanager.DriverExtensionLoader;

public class EDBConnectionController {

	private List<EDBDataSource> dataSources;
	private EDBDataSource dataSource;
	private EObject eObject;
	private EDBConnectionWizard edbConnectionWizard;

	public EDBConnectionController(EDBConnectionWizard edbConnectionWizard) {
		this.edbConnectionWizard = edbConnectionWizard;

	}

	protected boolean checkDriverExists() {

		String path = dataSource.getDriver().getDriverLibraries().get(0).getLocalFile();
		Path localFile = Paths.get(path);

		if (Files.exists(localFile)) {

			URLClassLoader child;
			try {
				child = new URLClassLoader(new URL[] { localFile.toUri().toURL() }, this.getClass().getClassLoader());

				Class classToLoad = Class.forName(dataSource.getDriver().getDriverClassName(), true, child);
				return classToLoad != null;

			} catch (MalformedURLException | ClassNotFoundException | SecurityException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
		return false;
	}

	protected void openDownloadDriverPage() {
		Shell activeShell = Display.getCurrent().getActiveShell();
		DriverDownloadDialog dialog = new DriverDownloadDialog(activeShell, dataSource.getDriver(),
				dataSource.getDriverDependencies(), false, false);
		dialog.setMinimumPageSize(100, 100);
		dialog.open();

	}

	protected String[] loadGenerators() {

		dataSources = DriverExtensionLoader.loadRegisteredDrivers();

		List<String> displayNames = dataSources.stream().map(e -> e.getName()).collect(Collectors.toList());

		// Convert the list into an array
		String[] array = new String[displayNames.size()];
		displayNames.toArray(array);
		return array;
	}

	/**
	 * Method is called from the first Page, if the user choose a generator. If the
	 * value is present in the generators list, the method returns true and
	 * otherwise false.
	 * 
	 * @param name
	 * @return
	 */
	protected boolean setDriver(String name) {
		Optional<EDBDataSource> o = dataSources.stream().filter(p -> p.getName().equals(name)).findFirst();
		if (o.isPresent()) {
			dataSource = o.get();
			return true;
		}
		return false;
	}

	/**
	 * Opens the driver connection UI and waits until the UI is closed by the user.
	 */
	public boolean openConnectionUI() {
		if (dataSource != null) {
			dataSource.openConnectionUi();
			if (!dataSource.isCanceled()) {
				eObject = dataSource.getRootObject();
				return true;
			} else {
				((WizardDialog) edbConnectionWizard.getContainer()).close();
				
			}

		}
		return false;

	}

	public EObject geteObject() {
		return eObject;
	}

	private void seteObject(EObject eObject) {
		this.eObject = eObject;
	}

}

/*******************************************************************************
 * Copyright (c) 2010, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.symmetric2migration.files;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.ProgressMonitor;

import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.query.conditions.Not;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

/**
 * Entry point of the 'Symmetric2migration' transformation module.
 */
public class Symmetric2migration {

	/**
	 * The property file. Stores module list, the metamodel and library locations.
	 * @generated
	 */
	private Properties properties;
	
	/**
	 * The IN model.
	 * @generated
	 */
	protected IModel inModel;	
	
	/**
	 * The IN2 model.
	 * @generated
	 */
	protected IModel in2Model;

	/**
	 * The OUT model.
	 * @generated
	 */
	protected IModel outModel;	
	
	private IReferenceModel mddeMetamodel;
		
	/**
	 * The main method.
	 * 
	 * @param args
	 *            are the arguments
	 * @generated
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 3) {
				System.out.println("Arguments not valid : {IN_model_path, IN2_model_path, OUT_model_path}.");
			} else {
				Symmetric2migration runner = new Symmetric2migration();
				runner.loadModels(args[0], args[1]);
				runner.doSymmetric2migration(new NullProgressMonitor());
				runner.saveModels(args[2]);
			}
		} catch (ATLCoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ATLExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	public void runTransformation(String inPath, String outPath, String in2Path, IProgressMonitor progress) throws Exception {
		try {
			loadModels(inPath, in2Path);
			Object o = doSymmetric2migration(progress);
			System.out.println("In");
			saveModels(outPath);
		} catch (ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	/**
	 * Constructor.
	 *
	 * 
	 */
	public Symmetric2migration() throws IOException {
		properties = new Properties();
		properties.load(getFileURL("Symmetric2migration.properties").openStream());
		EPackage.Registry.INSTANCE.put(getMetamodelUri("Symmetric"), org.sidiff.difference.symmetric.SymmetricPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(getMetamodelUri("Mdde"), de.thm.evolvedb.mdde.MddePackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}
	

	/**
	 * Load the input and input/output models, initialize output models.
	 * 
	 * @param inModelPath
	 *            the IN model path
	 * @param in2ModelPath
	 *            the IN2 model path
	 * @throws ATLCoreException
	 *             if a problem occurs while loading models
	 *
	 * 
	 */
	public void loadModels(String inModelPath, String in2ModelPath) throws ATLCoreException {
		ModelFactory factory = new EMFModelFactory();
		IInjector injector = new EMFInjector();
	 	IReferenceModel migrationMetamodel = factory.newReferenceModel();
		injector.inject(migrationMetamodel, getMetamodelUri("Migration"));
	 	IReferenceModel symmetricMetamodel = factory.newReferenceModel();
		injector.inject(symmetricMetamodel, getMetamodelUri("Symmetric"));
	 	IReferenceModel mddeMetamodel = factory.newReferenceModel();
		injector.inject(mddeMetamodel, "http://www.thm.de/migration");
		this.inModel = factory.newModel(symmetricMetamodel);
		injector.inject(inModel, inModelPath);
		this.in2Model = factory.newModel(mddeMetamodel);
		injector.inject(in2Model, in2ModelPath);
		this.outModel = factory.newModel(migrationMetamodel);
	}


	/**
	 * Load the input and input/output models, initialize output models.
	 * 
	 * @param inModelPath
	 *            the IN model path
	 * @throws ATLCoreException
	 *             if a problem occurs while loading models
	 * 
	 *
	 */
	public void loadModels(String inModelPath) throws ATLCoreException {
		ModelFactory factory = new EMFModelFactory();
		EMFInjector injector = new EMFInjector();
	 	IReferenceModel migrationMetamodel = factory.newReferenceModel();
		injector.inject(migrationMetamodel, getMetamodelUri("Migration"));
	 	IReferenceModel symmetricMetamodel = factory.newReferenceModel();
		injector.inject(symmetricMetamodel, getMetamodelUri("Symmetric"));
		mddeMetamodel = factory.newReferenceModel();
		injector.inject(mddeMetamodel, "http://www.thm.de/migration");
		//injector.inject(mddeMetamodel, loadEMFResource(getMetamodelUri("Mdde")));
		
		this.inModel = factory.newModel(symmetricMetamodel);
		injector.inject(inModel, inModelPath);
		this.outModel = factory.newModel(migrationMetamodel);
	}
	
	private Resource loadEMFResource(String uri) {
		//URI fileURI = URI.createPlatformPluginURI(uri ,false);
		
		URI fileURI = URI.createPlatformPluginURI("/mdde/model/mdde.ecore", false);
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();
		// Demand load the resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);
		return resource;
	}
	
	/**
	 * Save the output and input/output models.
	 * 
	 * @param outModelPath
	 *            the OUT model path
	 * @throws ATLCoreException
	 *             if a problem occurs while saving models
	 *
	 * @generated
	 */
	public void saveModels(String outModelPath) throws ATLCoreException {
		IExtractor extractor = new EMFExtractor();
		extractor.extract(outModel, outModelPath);
	}

	/**
	 * Transform the models.
	 * 
	 * @param monitor
	 *            the progress monitor
	 * @throws ATLCoreException
	 *             if an error occurs during models handling
	 * @throws IOException
	 *             if a module cannot be read
	 * @throws ATLExecutionException
	 *             if an error occurs during the execution
	 *
	 * 
	 */
	public Object doSymmetric2migration(IProgressMonitor monitor) throws ATLCoreException, IOException, ATLExecutionException {
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = getOptions();
		launcherOptions.put("allowInterModelReferences", "true");
		launcher.initialize(launcherOptions);
		launcher.addInOutModel(in2Model, "IN2", "Mdde");
		launcher.addInModel(inModel, "IN", "Symmetric");
		launcher.addOutModel(outModel, "OUT", "Migration");
		
		return launcher.launch("run", monitor, launcherOptions, (Object[]) getModulesList());
	}
	 
	/**
	 * Returns an Array of the module input streams, parameterized by the
	 * property file.
	 * 
	 * @return an Array of the module input streams
	 * @throws IOException
	 *             if a module cannot be read
	 *
	 * @generated
	 */
	protected InputStream[] getModulesList() throws IOException {
		InputStream[] modules = null;
		String modulesList = properties.getProperty("Symmetric2migration.modules");
		if (modulesList != null) {
			String[] moduleNames = modulesList.split(",");
			modules = new InputStream[moduleNames.length];
			for (int i = 0; i < moduleNames.length; i++) {
				String asmModulePath = new Path(moduleNames[i].trim()).removeFileExtension().addFileExtension("asm").toString();
				modules[i] = getFileURL(asmModulePath).openStream();
			}
		}
		return modules;
	}
	
	/**
	 * Returns the URI of the given metamodel, parameterized from the property file.
	 * 
	 * @param metamodelName
	 *            the metamodel name
	 * @return the metamodel URI
	 *
	 * @generated
	 */
	protected String getMetamodelUri(String metamodelName) {
		return properties.getProperty("Symmetric2migration.metamodels." + metamodelName);
	}
	
	/**
	 * Returns the file name of the given library, parameterized from the property file.
	 * 
	 * @param libraryName
	 *            the library name
	 * @return the library file name
	 *
	 * @generated
	 */
	protected InputStream getLibraryAsStream(String libraryName) throws IOException {
		return getFileURL(properties.getProperty("Symmetric2migration.libraries." + libraryName)).openStream();
	}
	
	/**
	 * Returns the options map, parameterized from the property file.
	 * 
	 * @return the options map
	 *
	 * @generated
	 */
	protected Map<String, Object> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		for (Entry<Object, Object> entry : properties.entrySet()) {
			if (entry.getKey().toString().startsWith("Symmetric2migration.options.")) {
				options.put(entry.getKey().toString().replaceFirst("Symmetric2migration.options.", ""), 
				entry.getValue().toString());
			}
		}
		return options;
	}
	
	/**
	 * Finds the file in the plug-in. Returns the file URL.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the file URL
	 * @throws IOException
	 *             if the file doesn't exist
	 * 
	 * @generated
	 */
	protected static URL getFileURL(String fileName) throws IOException {
		final URL fileURL;
		if (isEclipseRunning()) {
			URL resourceURL = Symmetric2migration.class.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = Symmetric2migration.class.getResource(fileName);
		}
		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}

	/**
	 * Tests if eclipse is running.
	 * 
	 * @return <code>true</code> if eclipse is running
	 *
	 * @generated
	 */
	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable exception) {
			// Assume that we aren't running.
		}
		return false;
	}
}

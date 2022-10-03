package de.thm.mdde.migration.api;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.symmetric2migration.files.Symmetric2migration;

import de.thm.xtend.ResourceFilter.MigrationModelTransformation;
import de.thm.xtend.ResourceFilter.ResourceFilter;

public class MigrationApi {
	
	public static boolean createMigrationModel(String inPath, IFile outFile, String symmetricFileName, String fileName) {
		
		try {
			
			String path = outFile.getRawLocation().toString();

			//String outPath = "file:///"+project.getLocation().toOSString() +"\\generated\\test.migration";
			//String inPath =  "file:///"+fileEcore.getLocation().toOSString();
			URI inPlatformUri = URI.createFileURI(path+'/'+symmetricFileName);
			//URI outPathPlatformUri = URI.createFileURI(project.getLocation().toString() + "/generated/test.migration");
			URI outPathPlatformUri = URI.createFileURI(path+'/'+fileName);
			
			Symmetric2migration symmetric2migration = new Symmetric2migration();
			//symmetric2migration.runTransformation(inPath, outPath , uri, new NullProgressMonitor() );
			
			ResourceSet resourceSetXtend = new ResourceSetImpl();
			Resource resSymmetricModel = resourceSetXtend.createResource(inPlatformUri);
			resSymmetricModel.load(Collections.emptyMap());
			ResourceFilter a = new ResourceFilter();
			String uri = a.filterForSymmetricDifference(resSymmetricModel);
			
			
			symmetric2migration.runTransformation(inPlatformUri.toString(), outPathPlatformUri.toString() , uri, new NullProgressMonitor() );
		
		
			//Try to load new model for the xtend refinement
			//Load the Ressources and get the model URIS
			
			// load the ecore file
			Resource resXtendModelFile = resourceSetXtend.createResource(outPathPlatformUri);
			
			resXtendModelFile.load(Collections.emptyMap());
			
			
			MigrationModelTransformation migrationModelTransformation = new MigrationModelTransformation();
			migrationModelTransformation.runMigrtaionTransformation(resXtendModelFile, resSymmetricModel);
			resXtendModelFile.save(Collections.emptyMap());
			return false;
			
		} catch (IOException e) {

			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

}

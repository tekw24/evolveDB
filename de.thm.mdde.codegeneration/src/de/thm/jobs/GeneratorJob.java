package de.thm.jobs;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.extensionpoint.interfaces.ISQLGenerator;
import de.thm.mdde.exception.GenerationCanceledException;

public class GeneratorJob extends Job implements IJobChangeListener{
	
	private long jobBegin;
	private Resource resEcoreFile;
	private ISQLGenerator generator;
	private String content;
	private IFolder folder;
	private IFile iFile;
	

	public GeneratorJob(String name, Resource resEcoreFile,ISQLGenerator generator, IFile iFile, IFolder folder) {
		super(name);
		this.resEcoreFile = resEcoreFile;
		this.generator = generator;
		this.folder = folder;
		this.iFile = iFile;
		addJobChangeListener(this);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// start the generation
		jobBegin = System.currentTimeMillis();
		generator.generate(resEcoreFile, monitor);
		return Status.OK_STATUS;
	}

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void awake(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void done(IJobChangeEvent event) {
		long jobEnd = System.currentTimeMillis();
		if (event.getResult().isOK()) {
			System.out.println("Generating migration code has finished (took "
					+ (jobEnd - jobBegin) + " ms).");
			
			try {
				createFile(folder, iFile, true, generator.getContent());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		
		} else if (event.getResult().matches(Status.CANCEL)) {
			System.out
					.println("Generating migration code has been cancelled (took "
							+ (jobEnd - jobBegin) + " ms).");
		}

	}

	@Override
	public void running(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduled(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sleeping(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * Creates a file of the given content in the given folder. If the folder does not exist, it will be created.
	 * @throws CoreException 
	 */
	private void createFile(IFolder folder, IFile iFile, boolean overrideFile, CharSequence content) throws CoreException {

		if (!folder.exists()) {
			folder.create(true, true, null);
		}

		if (overrideFile == false && iFile.exists()) {
			return;
		}
		if (!iFile.exists()) {
			iFile.create(null, true, null);
		}

		// count character
		//int character += content.length

		// process the code
		String formattedCode = null;
//		if (fileName.endsWith(".java")) {
//			// organize imports
//			// count for stats
//			val char semicolon = ';'
//			val contentString = content.toString
//			val char[] charArray = contentString.toCharArray
//			for (char c : charArray) {
//				if (c == semicolon) {
//					statements++
//				}
//			}
//			lineSeparators += contentString.split(System.lineSeparator).length
		// TODO im not generating java code
		// var String sourceWithImports = importFinder.getWithImports(content.toString)
		// format the java code
		// formattedCode = JavaFormatter.format(sourceWithImports)
//		} else if (fileName.endsWith(".xml")) {
//			// format the xml code
//			formattedCode = XmlFormatter.format(content.toString)
//		}
		byte[] bytes;
		if (formattedCode != null) { // has the code been formatted?
			bytes = formattedCode.getBytes();
		} else { // code could not be formatted
			bytes = content.toString().getBytes();
			System.err.println("File " + iFile.getName() + " could not be formatted.");
		}
		// save the file
		InputStream source = new ByteArrayInputStream(bytes);
		iFile.setContents(source, IResource.FORCE, null);
	}
	
	

}

/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.jobs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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

public class GeneratorJob extends Job implements IJobChangeListener {

	private long jobBegin;
	private Resource resEcoreFile;
	private ISQLGenerator generator;
	private String content;
	private IFolder folder;
	private IFile iFile;

	public GeneratorJob(String name, Resource resEcoreFile, ISQLGenerator generator, IFile iFile, IFolder folder) {
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

	}

	@Override
	public void awake(IJobChangeEvent event) {

	}

	@Override
	public void done(IJobChangeEvent event) {
		long jobEnd = System.currentTimeMillis();
		if (event.getResult().isOK()) {
			System.out.println("Generating migration code has finished (took " + (jobEnd - jobBegin) + " ms).");

			try {
				createFile(folder, iFile, true, generator.getContent());
			} catch (CoreException e) {
				e.printStackTrace();
			}

		} else if (event.getResult().matches(Status.CANCEL)) {
			System.out.println("Generating migration code has been cancelled (took " + (jobEnd - jobBegin) + " ms).");
		}

	}

	@Override
	public void running(IJobChangeEvent event) {

	}

	@Override
	public void scheduled(IJobChangeEvent event) {

	}

	@Override
	public void sleeping(IJobChangeEvent event) {

	}

	/**
	 * Creates a file of the given content in the given folder. If the folder does
	 * not exist, it will be created.
	 * 
	 * @throws CoreException
	 */
	private void createFile(IFolder folder, IFile iFile, boolean overrideFile, CharSequence content)
			throws CoreException {

		if (!folder.exists()) {
			folder.create(true, true, null);
		}

		if (overrideFile == false && iFile.exists()) {
			return;
		}
		if (!iFile.exists()) {
			iFile.create(null, true, null);
		}

		byte[] bytes;

		bytes = content.toString().getBytes();

		// save the file
		InputStream source = new ByteArrayInputStream(bytes);
		iFile.setContents(source, IResource.FORCE, null);
	}

}

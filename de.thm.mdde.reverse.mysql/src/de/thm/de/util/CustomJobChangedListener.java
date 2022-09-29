package de.thm.de.util;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;

public abstract class CustomJobChangedListener implements IJobChangeListener {

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		
		
	}

	@Override
	public void awake(IJobChangeEvent event) {
	
		
	}

	
	public abstract void  done(IJobChangeEvent event);
	
		


	@Override
	public void running(IJobChangeEvent event) {
		
	}

	public abstract void scheduled(IJobChangeEvent event);
		


	@Override
	public void sleeping(IJobChangeEvent event) {
		
		
	}

}

/*******************************************************************************
 * Copyright (c) 2011-2022 EclipseSource Muenchen GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Torben - initial API and implementation
 ******************************************************************************/
package de.thm.emf.ecp.migration.ui.foreignkey.control;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedReport;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;

import de.thm.evolvedb.mdde.MddePackage;

/**
 * @author Torben
 *
 */
public class ForeignKeyRendererService implements EMFFormsDIRendererService<VControl> {

	private EMFFormsDatabinding databindingService;
	private ReportService reportService;

	/**
	 * Called by the initializer to set the EMFFormsDatabinding.
	 *
	 * @param databindingService The EMFFormsDatabinding
	 */
	protected void setEMFFormsDatabinding(EMFFormsDatabinding databindingService) {
		this.databindingService = databindingService;
	}

	/**
	 * Called by the initializer to set the ReportService.
	 *
	 * @param reportService The ReportService
	 */
	protected void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService#isApplicable(org.eclipse.emf.ecp.view.spi.model.VElement,
	 *      org.eclipse.emf.ecp.view.spi.context.ViewModelContext)
	 */
	@Override
	public double isApplicable(VElement vElement, ViewModelContext viewModelContext) {
		if (!VControl.class.isInstance(vElement)) {
			return NOT_APPLICABLE;
		}
		final VControl control = (VControl) vElement;
		if (control.getDomainModelReference() == null) {
			return NOT_APPLICABLE;
		}
		IValueProperty valueProperty;
		try {
			valueProperty = databindingService.getValueProperty(control.getDomainModelReference(),
				viewModelContext.getDomainModel());
		} catch (final DatabindingFailedException ex) {
			reportService.report(new DatabindingFailedReport(ex));
			return NOT_APPLICABLE;
		}
		final EStructuralFeature eStructuralFeature = EStructuralFeature.class.cast(valueProperty.getValueType());
		if (eStructuralFeature == null) {
			return NOT_APPLICABLE;
		}
		if (eStructuralFeature.isMany()) {
			return NOT_APPLICABLE;
		}
		if (MddePackage.eINSTANCE.getForeignKey_ReferencedKeyColumn().equals(eStructuralFeature)) {
			return 10;
		}
		return NOT_APPLICABLE;

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService#getRendererClass()
	 */
	@Override
	public Class<? extends AbstractSWTRenderer<VControl>> getRendererClass() {
		return ForeignKeyRenderer.class;
	}

}

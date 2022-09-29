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
package de.thm.emf.ecp.mdde.ui.referencedtable.control;

import javax.inject.Inject;

import org.eclipse.emf.ecp.edit.spi.ReferenceService;
import org.eclipse.emf.ecp.view.internal.core.swt.renderer.LinkControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.util.swt.ImageRegistryService;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.localization.EMFFormsLocalizationService;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;

import de.thm.evolvedb.migration.PartiallyResolvable;

/**
 * @author Torben
 *
 */
public class ForeignKeyTableRenderer extends LinkControlSWTRenderer {

	private SWTGridDescription rendererGridDescription;
	private ReferenceService referenceService;
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	private ComposedAdapterFactory composedAdapterFactory;

	private PartiallyResolvable partiallyResolvable;

	/**
	 * @param vElement the element to render
	 * @param viewContext the view model context
	 * @param reportService the report service
	 * @param emfFormsDatabinding the data binding service
	 * @param emfFormsLabelProvider the label provider
	 * @param vtViewTemplateProvider the view template provider
	 * @param localizationService the localization service
	 * @param imageRegistryService the image registry service
	 */
	@Inject
	// CHECKSTYLE.OFF: ParameterNumber
	public ForeignKeyTableRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService,
		EMFFormsDatabinding emfFormsDatabinding, EMFFormsLabelProvider emfFormsLabelProvider,
		VTViewTemplateProvider vtViewTemplateProvider, EMFFormsLocalizationService localizationService,
		ImageRegistryService imageRegistryService) {
		// CHECKSTYLE.ON: ParameterNumber
		super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider,
			localizationService, imageRegistryService);

		// MyReferenceService myReferenceService=new MyReferenceService();
		// ViewModelContext viewModelContext=ViewModelContextFactory.createViewModelContext(view, domainObject,
		// myServiceReference);
		// viewContext.
		// ECPSWTView ecpView=ECPSWTViewRenderer.INSTANCE.render(parent, viewModelContext);

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.ecp.view.internal.core.swt.renderer.LinkControlSWTRenderer#getReferenceService()
	 */
	@Override
	protected ReferenceService getReferenceService() {
		// TODO Auto-generated method stub
		return new ForeignKeyTableReferenceService();
	}

	// @Override
	// protected void postInit() {
	// super.postInit();
	// composedAdapterFactory = new ComposedAdapterFactory(new AdapterFactory[] {
	// new CustomReflectiveItemProviderAdapterFactory(),
	// new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
	// adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);
	//
	// }

}

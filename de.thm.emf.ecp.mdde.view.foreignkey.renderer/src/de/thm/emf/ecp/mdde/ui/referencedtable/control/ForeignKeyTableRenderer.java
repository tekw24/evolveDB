/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

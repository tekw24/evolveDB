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
package de.thm.evolvedb.graph.difference.wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.input.InputModels;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.api.settings.RecognitionEngineMode;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.difference.lifting.recognitionengine.RecognitionEngineSetup;
import org.sidiff.difference.lifting.recognitionengine.util.RecognitionEngineUtil;
import org.sidiff.difference.lifting.recognitionrulesorter.IRecognitionRuleSorter;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.ITechnicalDifferenceBuilder;
import org.sidiff.difference.technical.api.TechnicalDifferenceFacade;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.api.util.TechnicalDifferenceUtils;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.IncrementalMatcher;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.impl.CorrespondenceImpl;
import org.sidiff.matching.model.util.MatchingModelUtil;

public class MddeDifferenceBuilderController {

	private IFile[] files;
	private InputModels inputModels;
	private Matching matching;
	private ProgressMonitorDialog dialog;

	public MddeDifferenceBuilderController(IFile[] files) {
		this.files = files;
	}

	public MddeDifferenceBuilderController(InputModels inputModels) {
		this.inputModels = inputModels;
	}

	public SymmetricDifference createTechnicalDifference() throws InvalidModelException, NoCorrespondencesException {

		DifferenceSettings settings = DifferenceSettings.defaultSettings();

		ITechnicalDifferenceBuilder generichTechnicalDifferenceBuilder = TechnicalDifferenceUtils
				.getTechnicalDifferenceBuilder("GenericTechnicalDifferenceBuilder");
		settings.setTechBuilder(generichTechnicalDifferenceBuilder);

		return TechnicalDifferenceFacade.deriveTechnicalDifference(createMatching(), settings);

	}

	/**
	 * Creates a lifted difference between the two initially selected models.
	 * 
	 * @return
	 * @throws InvalidModelException
	 * @throws NoCorrespondencesException
	 */
	protected SymmetricDifference createLiftedDifference() throws InvalidModelException, NoCorrespondencesException {
		LiftingSettings settings = LiftingSettings.defaultSettings();

		// Get rulebase
		// ILiftingRuleBase ruleBase =
		// PipelineUtils.getRulebase("de.thm.mdde.difference.sqlrulebase5"); TODO
		ILiftingRuleBase ruleBase = PipelineUtils.getRulebase("de.thm.evolvedb.graphrulebase");
		settings.setRuleBases(Set.of(ruleBase));
		settings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING_AND_POST_PROCESSING);

		settings.setScope(Scope.RESOURCE);
		settings.setValidate(true);
//		settings.setCandidatesService(null);
//		settings.setCorrespondencesService(null);

		Optional<IRecognitionRuleSorter> sorter = IRecognitionRuleSorter.MANAGER.getDefaultExtension();
		settings.setRrSorter(sorter.get());

//		settings.setCalculateEditRuleMatch(false);
//		settings.setSerializeEditRuleMatch(false);
		
		RecognitionEngineSetup setup = PipelineUtils.createRecognitionEngineSetup(settings);
		//TODO Try to prevent Deadlock
		setup.setUseThreadPool(true);
		
		settings.setRecognitionEngine(RecognitionEngineUtil.getDefaultRecognitionEngine(
						setup));
		
		SymmetricDifference technicalDifference = createTechnicalDifference();

		return LiftingFacade.liftTechnicalDifference(technicalDifference, settings);

	}

	protected Matching createMatching() throws NoCorrespondencesException, InvalidModelException {

		if (matching == null) {

			// Get Resources
			Resource resourceA = inputModels.getResources().get(0);
			Resource resourceB = inputModels.getResources().get(1);

			// Loading Matcher
			IMatcher emfCompareMatcher = MatchingUtils.getMatcherByKey("EMFCompareMatcherAdapter");
			IMatcher uriFragmentMatcher = MatchingUtils.getMatcherByKey("URIFragmentMatcher");
			// IMatcher xmiIDMatcher =
			// MatchingUtils.getMatcherByKey("org.sidiff.matcher.id.xmiid.XMIIDMatcher");
			IMatcher namedElementMatcher = MatchingUtils
					.getMatcherByKey("org.sidiff.matcher.signature.name.NamedElementMatcher");

			// IMatcher annotatedSignatureMatcher =
			// MatchingUtils.getMatcherByKey("AnnotatedSignatureMatcher");

			namedElementMatcher.getConfiguration().setOption("useQualifiedNames", true);

			LiftingSettings settings = LiftingSettings.defaultSettings();

			List<IMatcher> matchers = new ArrayList<IMatcher>();
			matchers.addAll(Arrays.asList(emfCompareMatcher, namedElementMatcher, uriFragmentMatcher));

			IncrementalMatcher matcher = new IncrementalMatcher(matchers);
			settings.setMatcher(matcher);

			settings.setScope(Scope.RESOURCE);
			settings.setValidate(true);
			settings.setCandidatesService(null);
			settings.setCorrespondencesService(null);
			settings.setUnmergeImports(false);

			matching = MatchingFacade.match(Arrays.asList(resourceA, resourceB), settings);

		}
		return matching;
	}

	protected void persistSymmetricDifference(SymmetricDifference symmetricDifference, URI uri, String filename) {
		LiftingFacade.serializeLiftedDifference(symmetricDifference, uri, filename);
	}

	protected InputModels getInputModels() {
		return inputModels;
	}

	protected void removeCorrespondence(Correspondence correspondence) {
		matching.getCorrespondences().remove(correspondence);
		matching.getUnmatchedA().add(correspondence.getMatchedA());
		matching.getUnmatchedB().add(correspondence.getMatchedB());
	}

	protected void addCorrespondence(EObject a, EObject b) {
		Correspondence correspondence = MatchingModelUtil.createCorrespondence(a, b);
		matching.getCorrespondences().add(correspondence);
		matching.getUnmatchedA().remove(a);
		matching.getUnmatchedB().remove(b);
	}

}

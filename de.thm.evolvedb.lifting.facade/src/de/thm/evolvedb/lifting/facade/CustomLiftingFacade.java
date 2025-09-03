package de.thm.evolvedb.lifting.facade;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.api.settings.RecognitionEngineMode;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.difference.lifting.recognitionengine.RecognitionEngineSetup;
import org.sidiff.difference.lifting.recognitionengine.util.RecognitionEngineUtil;
import org.sidiff.difference.lifting.recognitionrulesorter.IRecognitionRuleSorter;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;

public class CustomLiftingFacade {
	
	
	/**
	 * Creates a lifted difference between the two initially selected models.
	 * @param diff 
	 * 
	 * @return
	 * @throws InvalidModelException
	 * @throws NoCorrespondencesException
	 */
	public static SymmetricDifference createLiftedDifference(List<Change>changes, SymmetricDifference diff) throws InvalidModelException, NoCorrespondencesException {
		LiftingSettings settings = LiftingSettings.defaultSettings();

		// Get rulebase
		// ILiftingRuleBase ruleBase =
		// PipelineUtils.getRulebase("de.thm.mdde.difference.sqlrulebase5"); TODO
		ILiftingRuleBase ruleBase = PipelineUtils.getRulebase("de.thm.mdde.difference.sqlrulebase2");
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
		// TODO Try to prevent Deadlock
		setup.setUseThreadPool(true);

		settings.setRecognitionEngine(RecognitionEngineUtil.getDefaultRecognitionEngine(setup));
		
		

		SymmetricDifference technicalDifference = SymmetricFactory.eINSTANCE.createSymmetricDifference(); 
		technicalDifference.getChanges().addAll(changes);
		technicalDifference.setUriModelA(diff.getUriModelA());
		technicalDifference.setUriModelB(diff.getUriModelB());
		technicalDifference.setMatching(diff.getMatching());

		return LiftingFacade.liftTechnicalDifference(technicalDifference, settings);

	}

	
	

}

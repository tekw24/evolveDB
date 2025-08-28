package de.thm.evolvedb.graphrulebase;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sidiff.editrule.rulebase.project.runtime.library.AbstractRuleBaseProject;

public class RuleBaseProject extends AbstractRuleBaseProject {

	@Override
	public String getKey() {
		return "de.thm.evolvedb.graphrulebase";
	}

	@Override
	public String getName() {
		return "Graphrulebase (2025-08-28 09:55:20)";
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Stream.of("http://www.thm.de/graph").collect(Collectors.toSet());
	}

	@Override
	public Set<String> getAttachmentTypes() {
		return Stream.of("org.sidiff.difference.rulebase.RecognitionRule").collect(Collectors.toSet());
	}
}
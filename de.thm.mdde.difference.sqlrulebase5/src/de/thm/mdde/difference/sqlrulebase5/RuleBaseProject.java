package de.thm.mdde.difference.sqlrulebase5;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sidiff.editrule.rulebase.project.runtime.library.AbstractRuleBaseProject;

public class RuleBaseProject extends AbstractRuleBaseProject {

	@Override
	public String getKey() {
		return "de.thm.mdde.difference.sqlrulebase5";
	}

	@Override
	public String getName() {
		return "Sqlrulebase5 (2024-11-29 10:51:53)";
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Stream.of("http://www.thm.de/mdde").collect(Collectors.toSet());
	}

	@Override
	public Set<String> getAttachmentTypes() {
		return Stream.of("org.sidiff.difference.rulebase.RecognitionRule").collect(Collectors.toSet());
	}
}
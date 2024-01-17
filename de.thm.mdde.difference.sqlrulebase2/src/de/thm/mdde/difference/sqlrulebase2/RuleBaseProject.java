package de.thm.mdde.difference.sqlrulebase2;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sidiff.editrule.rulebase.project.runtime.library.AbstractRuleBaseProject;

public class RuleBaseProject extends AbstractRuleBaseProject {

	@Override
	public String getKey() {
		return "de.thm.mdde.difference.sqlrulebase2";
	}

	@Override
	public String getName() {
		return "Sqlrulebase2 (2023-10-15 16:03:38)";
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
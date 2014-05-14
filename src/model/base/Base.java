package model.base;

import java.util.ArrayList;
import java.util.List;

import model.Predicate;
import model.Rule;

public enum Base {
	INSTANCE;
	private List<Rule> listOfRules = new ArrayList<>();

	public void addRule(Rule rule) {
		listOfRules.add(rule);
	}

	public List<Rule> getAllRulesByPredicate(Predicate predicate) {
		List<Rule> rules = new ArrayList<>();
		for (Rule rule : listOfRules) {
			if (predicate.equals(rule.getPredicate())) {
				rules.add(rule);
			}
		}
		return rules;
	}

	public void cleanBase() {
		listOfRules.clear();
	}

}

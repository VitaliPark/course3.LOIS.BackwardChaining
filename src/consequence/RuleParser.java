package consequence;

import java.util.List;

import model.Predicate;
import model.Rule;
import model.ValueTable;
import model.base.Base;

public class RuleParser {
	
	
	public ValueTable getFacts(Predicate predicate){
		ValueTable resultTable = new ValueTable();
		List<Rule> predicateRules = Base.INSTANCE.getAllRulesByPredicate(predicate);
		List<Predicate> rulePredicates = null;
		for (Rule rule : predicateRules) {
			rulePredicates = rule.getRuleTerms();
		}
		return resultTable;
	}
}

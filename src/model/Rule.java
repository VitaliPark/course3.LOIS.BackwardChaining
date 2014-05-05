package model;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	private Predicate predicate;
	private List<Predicate>  ruleTerms;
	
	public Rule(Predicate predicate) {
		super();
		this.predicate = predicate;
		ruleTerms = new ArrayList<Predicate>();
	}
	
	public void addRuleTerm(Predicate ruleTerm){
		ruleTerms.add(ruleTerm);
	}
	
	public List<Predicate> getRuleTerms() {
		return ruleTerms;
	}

	public Predicate getPredicate() {
		return predicate;
	}
	
}

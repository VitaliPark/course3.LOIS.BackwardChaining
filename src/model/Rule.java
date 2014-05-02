package model;

import java.util.ArrayList;

public class Rule {
	private Predicate predicate;
	private ArrayList<Predicate>  ruleTerms = new ArrayList<Predicate>();
	
	public Rule(Predicate predicate) {
		super();
		this.predicate = predicate;
	}
	
	public void addRuleTerm(Predicate ruleTerm){
		ruleTerms.add(ruleTerm);
	}

	public Predicate getPredicate() {
		return predicate;
	}
	
}

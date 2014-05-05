package consequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.ViewController;
import model.parameters.*;
import model.Cortege;
import model.Predicate;
import model.Rule;
import model.ValueTable;
import model.base.Base;

public class RuleParser {

	private ViewController controller;

	public RuleParser(ViewController controller) {
		super();
		this.controller = controller;
	}

	public ValueTable parsePredicate(Predicate predicate) {
		ValueTable resultTable = new ValueTable();
		resultTable.setHeaders(predicate.getHeadersAsVaribles());
		ValueTable temp;
		List<Rule> predicateRules = Base.INSTANCE
				.getAllRulesByPredicate(predicate);
		for (Rule rule : predicateRules) {
			temp = parseRule(rule);
			resultTable.union(temp);
			changeCortegeHeaders(resultTable);
		}
		if (!predicate.getHeadersAsVaribles().contains(new Variable("?"))) {
			updateTable(resultTable);
		}
		return resultTable;
	}

	private ValueTable parseRule(Rule rule) {
		ValueTable resultTable = new ValueTable();
		List<ValueTable> resultList;
		ValueTable temp;
		resultTable.setHeaders(rule.getPredicate().getHeadersAsVaribles());
		List<Predicate> ruleTerms = rule.getRuleTerms();
		if (!ruleTerms.isEmpty()) {
			resultList = new ArrayList<>();
			for (Predicate ruleTerm : ruleTerms) {
				temp = parsePredicate(ruleTerm);
				resultList.add(temp);
			}
			resultTable = mergeAll(resultList);
			resultTable = resultTable.projection(rule.getPredicate()
					.getHeadersAsVaribles());
		} else {
			resultTable = getFactTable(rule, resultTable.getHeaders());
		}
		return resultTable;
	}

	public ValueTable mergeAll(List<ValueTable> tableList) {
		ValueTable temp;
		if (tableList.size() > 1) {
			for (int i = 1; i < tableList.size(); ++i) {
				temp = tableList.get(0);
				tableList.add(0, temp.merge(tableList.get(i)));
				tableList.remove(i);
			}
		}
		return tableList.get(0);
	}

	private ValueTable getFactTable(Rule fact, List<Variable> header) {
		ValueTable result = new ValueTable();
		result.setHeaders(header);
		Cortege cortege = new Cortege(header);
		for (Parameter constant : fact.getPredicate().getParameters()) {
			cortege.add((Constant) constant);
		}
		if (!cortege.isEmpty()) {
			result.addCortege(cortege);
		}
		return result;
	}

	private void changeCortegeHeaders(ValueTable resultTable) {
		for (Cortege cortege : resultTable.getCortegeList()) {
			cortege.setHeader(resultTable.getHeaders());
		}
	}

	public void updateTable(ValueTable table) {
		for (int i = 0; i < table.getCortegeList().size();) {
			if (checkCortege(table, table.getCortegeList().get(i))) {
				i++;
			}
		}

	}

	private boolean checkCortege(ValueTable table, Cortege cortege) {
		for (int i = 0; i < table.getHeaders().size(); ++i) {
			for (int j = i; j < table.getHeaders().size(); ++j) {
				if (table.getHeaders().get(i).equals(table.getHeaders().get(j))) {
					if (!cortege.get(i).equals(cortege.get(j))) {
						table.deleteCortege(cortege);
						return false;
					}
				}
			}
		}
		return true;
	}

}

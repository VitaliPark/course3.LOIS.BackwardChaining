package consequence;

import java.util.ArrayList;
import java.util.List;

import GUI.GUIConstants;
import model.Cortege;
import model.Predicate;
import model.Rule;
import model.ValueTable;
import model.base.Base;
import model.parameters.Parameter;
import model.parameters.ParameterType;
import controller.ViewController;

public class RecursiveSolver implements Solver {

	@SuppressWarnings("unused")
	private ViewController controller;

	public RecursiveSolver(ViewController controller) {
		super();
		this.controller = controller;
	}

	public String solveTask(Predicate predicate) {
		if (null == predicate) {
			return GUIConstants.INCORRECT_INPUT.getValue();
		}
		ValueTable tempTable = new ValueTable();
		if (isVariable(predicate)) {
			tempTable = processPredicate(predicate);
			return tempTable.toString();
		} else {
			return factVerity(predicate);
		}

	}

	private boolean isVariable(Predicate predicate) {
		return predicate.getParameters().get(0).getType() == ParameterType.VARIABLE;
	}

	private ValueTable processPredicate(Predicate predicate) {
		ValueTable resultTable = new ValueTable();
		resultTable.setHeaders(predicate.getHeadersAsVaribles());
		ValueTable temp;
		List<Rule> predicateRules = Base.INSTANCE
				.getAllRulesByPredicate(predicate);
		for (Rule rule : predicateRules) {
			temp = processRule(rule);
			resultTable.union(temp);
			changeCortegeHeaders(resultTable);
		}

		if (!predicate.getHeadersAsVaribles().contains(
				new Parameter(ParameterType.VARIABLE, "?"))) {
			updateTable(resultTable);
		}
		return resultTable;
	}

	private ValueTable processRule(Rule rule) {
		ValueTable resultTable = new ValueTable();
		List<ValueTable> resultList;
		ValueTable temp;
		resultTable.setHeaders(rule.getPredicate().getHeadersAsVaribles());
		List<Predicate> ruleTerms = rule.getRuleTerms();
		if (!ruleTerms.isEmpty()) {
			resultList = new ArrayList<>();
			for (Predicate ruleTerm : ruleTerms) {
				temp = processPredicate(ruleTerm);
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

	private String factVerity(Predicate predicate) {
		ValueTable tempTable;
		tempTable = processPredicate(predicate);
		Cortege tempCortege = createCortegeFromPredicate(predicate);
		return checkCortege(tempTable, tempCortege);
	}

	private Cortege createCortegeFromPredicate(Predicate predicate) {
		Cortege tempCortege = new Cortege(null);
		for (Parameter param : predicate.getParameters()) {
			tempCortege.add(param);
		}
		return tempCortege;
	}

	private String checkCortege(ValueTable table, Cortege tempCortege) {
		for (Cortege cortege : table.getCortegeList()) {
			if (cortege.equals(tempCortege)) {
				return Boolean.TRUE.toString();
			}
		}
		return Boolean.FALSE.toString();
	}

	private ValueTable mergeAll(List<ValueTable> tableList) {
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

	private ValueTable getFactTable(Rule fact, List<Parameter> header) {
		ValueTable result = new ValueTable();
		result.setHeaders(header);
		Cortege cortege = new Cortege(header);
		for (Parameter constant : fact.getPredicate().getParameters()) {
			cortege.add(constant);
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

	private void updateTable(ValueTable table) {
		for (int i = 0; i < table.getCortegeList().size();) {
			if (checkEqualAttribute(table, table.getCortegeList().get(i))) {
				i++;
			}
		}
	}

	private boolean checkEqualAttribute(ValueTable table, Cortege cortege) {
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

package controller;

import input.LogicReader;
import model.Cortege;
import model.Predicate;
import model.ValueTable;
import model.parameters.Constant;
import model.parameters.Parameter;
import model.parameters.Variable;
import GUI.MainWnd;
import consequence.RuleParser;

public class ViewController {
	private MainWnd window;
	private LogicReader reader;
	private RuleParser parser;

	public void setWindow(MainWnd window) {
		this.window = window;
	}

	public void setReader(LogicReader reader) {
		this.reader = reader;
	}

	public void setParser(RuleParser parser) {
		this.parser = parser;
	}

	public Predicate checkQuery(String query) {
		return reader.checkQuery(query);
	}

	public String readDB() {
		return reader.read();
	}

	public void printAnswer() {

	}

	public void parsePredicate(Predicate predicate) {
		if (predicate.getParameters().get(0) instanceof Variable) {
			checkRule(predicate);
		} else {
			checkFact(predicate);
		}

	}

	private void checkRule(Predicate predicate) {
		String result = parser.parsePredicate(predicate).toString();
		window.setResult(result);
	}

	private void checkFact(Predicate predicate) {
		ValueTable table = parser.parsePredicate(predicate);
		Cortege tempCortege = new Cortege(null);
		for (Parameter param : predicate.getParameters()) {
			tempCortege.add((Constant) param);
		}
		window.setResult(checkCortege(table, tempCortege).toString());
	}

	private Boolean checkCortege(ValueTable table, Cortege tempCortege) {
		for (Cortege cortege : table.getCortegeList()) {
			if (cortege.equals(tempCortege)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public void printErrorMessage(String message) {

	}
}

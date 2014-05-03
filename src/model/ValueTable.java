package model;

import java.util.ArrayList;
import java.util.List;

import model.parameters.Variable;

public class ValueTable {

	private List<Variable> headers;
	private List<Cortege> cortegeList;

	public ValueTable() {
		super();
		this.headers = new ArrayList<>();
		this.cortegeList = new ArrayList<>();
	}

	public void addCortege(Cortege cortege) {
		cortegeList.add(cortege);
	}

	public void addVariable(Variable var) {
		headers.add(var);
	}

	public List<Variable> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Variable> headers) {
		this.headers = headers;
	}

	public List<Cortege> getCortegeList() {
		return cortegeList;
	}

	public void setCortegeList(List<Cortege> cortegeList) {
		this.cortegeList = cortegeList;
	}

	public ValueTable merge(ValueTable table) {
		ValueTable resultTable = new ValueTable();
		List<Variable> commonAttributes = new ArrayList<>();
		for (Variable variable : table.getHeaders()) {
			if (headers.contains(variable)) {
				commonAttributes.add(variable);
			}
		}
		formResultHeader(table, resultTable);
		Cortege temp = null;
		for (Cortege thisCortege : this.cortegeList) {
			for (Cortege cortege : table.getCortegeList()) {
				temp = mergeCortege(thisCortege, cortege, commonAttributes);
				if (temp != null) {
					resultTable.addCortege(temp);
				}
			}
		}
		return resultTable;
	}

	public ValueTable projection(List<Variable> attributes) {
		ValueTable resultTable = null;
		if (attributes != null && !attributes.isEmpty()
				&& this.headers.containsAll(attributes)) {
			resultTable = new ValueTable();
			resultTable.setHeaders(attributes);
			Cortege temp = new Cortege();
			for (Cortege cortege : this.cortegeList) {
				temp = cortege.project(attributes);
				if (!resultTable.cortegeList.contains(temp)) {
					resultTable.addCortege(temp);
				}
			}
		}
		return resultTable;
	}

	private Cortege mergeCortege(Cortege first, Cortege second,
			List<Variable> commonAttributes) {
		Cortege resultCortege = null;
		boolean isMergible = true;
		for (Variable variable : commonAttributes) {
			if (!first.get(variable).equals(second.get(variable))) {
				isMergible = false;
				break;
			}
		}
		if (isMergible) {
			resultCortege = new Cortege();
			resultCortege.putAll(first);
			resultCortege.putAll(second);
		}
		return resultCortege;
	}

	private void formResultHeader(ValueTable table, ValueTable resultTable) {
		for (Variable variable : this.headers) {
			resultTable.addVariable(variable);
		}
		for (Variable variable : table.getHeaders()) {
			if (!resultTable.getHeaders().contains(variable)) {
				resultTable.addVariable(variable);
			}
		}
	}

	@Override
	public String toString() {
		String result = new String();
		for (Variable attribute : headers) {
			result += attribute.getName() + " ";
		}
		result += '\n';
		for (Cortege cortege : cortegeList) {
			result += cortege.toString();
		}
		return result;
	}
}

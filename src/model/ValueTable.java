package model;

import java.util.ArrayList;
import java.util.List;

import model.parameters.Parameter;
import model.parameters.ParameterType;

public class ValueTable {

	private List<Parameter> headers;
	private List<Cortege> cortegeList;

	public ValueTable() {
		super();
		this.headers = new ArrayList<>();
		this.cortegeList = new ArrayList<>();
	}

	public void addCortege(Cortege cortege) {
		cortegeList.add(cortege);
	}

	public void deleteCortege(Cortege cortege) {
		cortegeList.remove(cortege);
	}

	public void addVariable(Parameter var) {
		headers.add(var);
	}

	public List<Parameter> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Parameter> headers) {
		this.headers = headers;
	}

	public void setHeaders(String... variables) {
		if (!headers.isEmpty()) {
			headers.clear();
		}
		for (String variable : variables) {
			headers.add(new Parameter(ParameterType.VARIABLE, variable));
		}
	}

	public List<Cortege> getCortegeList() {
		return cortegeList;
	}

	public void setCortegeList(List<Cortege> cortegeList) {
		this.cortegeList = cortegeList;
	}

	public ValueTable merge(ValueTable table) {
		ValueTable resultTable = new ValueTable();
		List<Parameter> commonAttributes = new ArrayList<>();
		for (Parameter variable : table.getHeaders()) {
			if (headers.contains(variable)) {
				commonAttributes.add(variable);
			}
		}
		formResultHeader(table, resultTable);
		Cortege temp = null;
		for (Cortege thisCortege : this.cortegeList) {
			for (Cortege cortege : table.getCortegeList()) {
				temp = mergeCortege(thisCortege, cortege, commonAttributes,
						resultTable.headers);
				if (temp != null) {
					resultTable.addCortege(temp);
				}
			}
		}
		return resultTable;
	}

	public int union(ValueTable tableToUnite) {
		if (this.getHeaders().size() != tableToUnite.getHeaders().size()) {
			return -1;
		} else {
			for (Cortege cortege : tableToUnite.getCortegeList()) {
				if (cortege.getValues().size() == this.getHeaders().size()) {
					this.cortegeList.add(cortege);
				}
			}
			return 1;
		}
	}

	public ValueTable projection(List<Parameter> attributes) {
		ValueTable resultTable = new ValueTable();
		if (attributes != null && !attributes.isEmpty()
				&& this.headers.containsAll(attributes)) {
			resultTable.setHeaders(attributes);
			Cortege temp = new Cortege(attributes);
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
			List<Parameter> commonAttributes, List<Parameter> resultHeader) {
		Cortege resultCortege = null;
		boolean isMergible = true;
		for (Parameter variable : commonAttributes) {
			if (!first.get(first.getHeader().indexOf(variable)).equals(
					second.get(second.getHeader().indexOf(variable)))) {
				isMergible = false;
				break;
			}
		}
		if (isMergible) {
			resultCortege = new Cortege(resultHeader);
			resultCortege.putAll(first);
			for (Parameter variable : second.getHeader()) {
				if (!commonAttributes.contains(variable)) {
					resultCortege.add(resultHeader.indexOf(variable),
							second.get(second.getHeader().indexOf(variable)));
				}
			}
		}
		return resultCortege;
	}

	private void formResultHeader(ValueTable table, ValueTable resultTable) {
		for (Parameter variable : this.headers) {
			resultTable.addVariable(variable);
		}
		for (Parameter variable : table.getHeaders()) {
			if (!resultTable.getHeaders().contains(variable)) {
				resultTable.addVariable(variable);
			}
		}
	}

	@Override
	public String toString() {
		String result = new String();
		for (Parameter attribute : headers) {
			result += attribute.getValue() + " ";
		}
		result += '\n';
		for (Cortege cortege : cortegeList) {
			result += cortege.toString();
		}
		return result;
	}
}

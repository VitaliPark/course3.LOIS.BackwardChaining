package model;

import java.util.ArrayList;
import java.util.List;

import model.parameters.Parameter;

public class Cortege {

	private List<Parameter> header;
	private List<Parameter> values;

	public Cortege(List<Parameter> header) {
		super();
		this.header = header;
		values = new ArrayList<>();
	}

	public List<Parameter> getValues() {
		return values;
	}

	public Parameter get(int index) {
		return values.get(index);
	}

	public void add(int index, Parameter constant) {
		values.add(index, constant);
	}

	public void add(Parameter constant) {
		values.add(constant);
	}

	public void addAll(List<Parameter> list) {
		values.addAll(list);
	}

	public boolean isEmpty() {
		return values.isEmpty();
	}

	public List<Parameter> getHeader() {
		return header;
	}

	public void setHeader(List<Parameter> header) {
		this.header = header;
	}

	public Cortege project(List<Parameter> attributes) {
		Cortege resultCortege = new Cortege(attributes);
		for (Parameter variable : attributes) {
			if (attributes.contains(variable)) {
				resultCortege.put(get(header.indexOf(variable)));
			}
		}
		return resultCortege;
	}

	@Override
	public String toString() {
		String result = new String();
		for (Parameter constant : this.values) {
			result += constant.getValue() + " ";
		}
		result += '\n';
		return result;
	}

	public void put(Parameter constant) {
		add(constant);
	}

	public void putAll(Cortege cortege) {
		addAll(cortege.getValues());
	}

	@Override
	public boolean equals(Object arg0) {
		Cortege cortegeToCheck = (Cortege) arg0;
		return isInstanceOf(arg0) && isSizeEquals(cortegeToCheck)
				&& isValuesEquals(cortegeToCheck);
	}

	private boolean isSizeEquals(Cortege cortegeToCheck) {
		return cortegeToCheck.getValues().size() == this.values.size();
	}

	private boolean isInstanceOf(Object arg) {
		return arg != null || (arg instanceof Cortege);
	}

	private boolean isValuesEquals(Cortege cortege) {
		for (int i = 0; i < this.values.size(); ++i) {
			if (!this.get(i).equals(cortege.get(i))) {
				return false;
			}
		}
		return true;
	}

}

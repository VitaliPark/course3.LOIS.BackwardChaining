package model;

import java.util.ArrayList;
import java.util.List;

import model.parameters.Parameter;
import model.parameters.ParameterType;

public class Predicate {

	private String name;
	private List<Parameter> parameters;

	public Predicate(String name) {
		super();
		this.name = name;
		parameters = new ArrayList<Parameter>();
	}

	public void addParameter(Parameter parameter) {
		parameters.add(parameter);
	}

	public String getName() {
		return name;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public List<Parameter> getHeadersAsVaribles() {
		List<Parameter> result = new ArrayList<>();
		for (Parameter param : parameters) {
			result.add(new Parameter(ParameterType.VARIABLE, param.getValue()));
		}

		return result;
	}

	@Override
	public boolean equals(Object arg0) {
		if (this == arg0) {
			return true;
		}
		if (!(arg0 instanceof Predicate)) {
			return false;
		}
		return name.equals(((Predicate) arg0).getName());
	}
}

package model;

import java.util.ArrayList;

import model.parameters.Parameter;

public class Predicate {

	private String name;
	private ArrayList<Parameter> parameters;
	
	public Predicate(String name) {
		super();
		this.name = name;
	}
	
	public void addParameter(Parameter parameter){
		parameters.add(parameter);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(this == arg0)
		{
			return true;
		}
		if(!(arg0 instanceof Predicate)){
			return false;
		}
		return name.equals(((Predicate)arg0).getName());
	}
}

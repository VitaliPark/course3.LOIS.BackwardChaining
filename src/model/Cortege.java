package model;

import java.util.ArrayList;
import java.util.List;
import model.parameters.Constant;
import model.parameters.Variable;

public class Cortege{

	private List<Variable> header;
	private ArrayList<Constant> values; 

	public Cortege(List<Variable> header) {
		super();
		this.header = header;
		values = new ArrayList<>();
	}
	
	public ArrayList<Constant> getValues() {
		return values;
	}

	public Constant get(int index){
		return values.get(index);
	}
	
	public void add(int index, Constant constant){
		values.add(index, constant);
	}
	
	public void add(Constant constant){
		values.add(constant);
	}
	
	public void addAll(List<Constant> list){
		values.addAll(list);
	}
	
	public boolean isEmpty(){
		return values.isEmpty();
	}
	
	public List<Variable> getHeader() {
		return header;
	}

	public void setHeader(List<Variable> header) {
		this.header = header;
	}

	public Cortege project(List<Variable> attributes) {
		Cortege resultCortege = new Cortege(attributes);
		for (Variable variable : attributes) {
			if (attributes.contains(variable)) {
				resultCortege.put(variable, get(header.indexOf(variable)));
			}
		}
		return resultCortege;
	}

	@Override
	public String toString() {
		String result = new String();
		for (Constant constant : this.values) {
			result += constant.getName() + " ";
		}
		result += '\n';
		return result;
	}

	public void put(Variable var, Constant constant) {
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

package model;

import java.util.ArrayList;
import java.util.List;
import model.parameters.Constant;
import model.parameters.Variable;

@SuppressWarnings("serial")
public class Cortege extends ArrayList<Constant>{
	
	private List<Variable> header;
	
	public Cortege(List<Variable> header) {
		super();
		this.header = header;
	}
	
	public List<Variable> getHeader() {
		return header;
	}

	public void setHeader(List<Variable> header) {
		this.header = header;
	}

	public Cortege project(List<Variable> attributes){
//		Cortege resultCortege = new Cortege();
//		Set<Variable> keySet = this.keySet();
//		for (Variable variable : keySet) {
//			if(attributes.contains(variable)){
//				resultCortege.put(variable, this.get(variable));
//			}
//		}
//		return resultCortege;
		
		Cortege resultCortege = new Cortege(attributes);
//		for (Variable variable : header) {
//			if(attributes.contains(variable)){
//				resultCortege.put(variable, get(header.indexOf(variable)));
//			}
//		}
		for (Variable variable : attributes) {
			if(attributes.contains(variable)){
				resultCortege.put(variable, get(header.indexOf(variable)));
			}
		}
		return resultCortege;
	}
	
	@Override
	public String toString(){
//		String result = new String();
//		for(Variable attribute : keySet()){
//			result += attribute.getName() + " : " + get(attribute).getName() + " ";
//		}
//		result += '\n';
//		return result;
		
		String result = new String();
		for(Constant constant : this){
			result += constant.getName() + " ";
		}
		result += '\n';
		return result;
	}
	
	public void put(Variable var, Constant constant){
		//add(header.indexOf(var), constant);
		add(constant);
	}
	
	public void putAll(Cortege cortege){
		addAll(cortege);
	}
	
	@Override
	public boolean equals(Object arg0) {
		Cortege cortegeToCheck = (Cortege) arg0;
		return isInstanceOf(arg0) && isSizeEquals(cortegeToCheck) && isValuesEquals(cortegeToCheck);
	}

	private boolean isSizeEquals(Cortege cortegeToCheck) {
		return cortegeToCheck.size() == this.size();
	}
	
	private boolean isInstanceOf(Object arg){
		return arg != null || (arg instanceof Cortege);
	}
	
	private boolean isValuesEquals(Cortege cortege){
//		for (Variable variable : keySet()) {
//			if(!this.get(variable).equals(cortege.get(variable))){
//				return false;
//			}
//		}
//		return true;
//	}
		
		for(int i = 0; i < this.size(); ++i){
			if(!this.get(i).equals(cortege.get(i))){
				return false;
			}
		}
		return true;
	}

}

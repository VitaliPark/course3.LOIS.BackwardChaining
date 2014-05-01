package model;

import java.util.HashMap;
import java.util.TreeMap;

import model.parameters.Constant;
import model.parameters.Variable;

@SuppressWarnings("serial")
public class Cortege extends HashMap<Variable, Constant>{
	@Override
	public String toString(){
		String result = new String();
		for(Variable attribute : keySet()){
			result += attribute.getName() + " : " + get(attribute).getName() + " ";
		}
		result += '\n';
		return result;
	}
}

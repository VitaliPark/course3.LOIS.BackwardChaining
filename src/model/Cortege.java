package model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.parameters.Constant;
import model.parameters.Variable;

@SuppressWarnings("serial")
public class Cortege extends HashMap<Variable, Constant> {

	public Cortege project(List<Variable> attributes) {
		Cortege resultCortege = new Cortege();
		Set<Variable> keySet = this.keySet();
		for (Variable variable : keySet) {
			if (attributes.contains(variable)) {
				resultCortege.put(variable, this.get(variable));
			}
		}
		return resultCortege;
	}

	@Override
	public String toString() {
		String result = new String();
		for (Variable attribute : keySet()) {
			result += attribute.getName() + " : " + get(attribute).getName()
					+ " ";
		}
		result += '\n';
		return result;
	}

	@Override
	public boolean equals(Object arg0) {
		Cortege cortegeToCheck = (Cortege) arg0;
		return isInstanceOf(arg0) && isSizeEquals(cortegeToCheck)
				&& isValuesEquals(cortegeToCheck);
	}

	private boolean isSizeEquals(Cortege cortegeToCheck) {
		return cortegeToCheck.size() == this.size();
	}

	private boolean isInstanceOf(Object arg) {
		return arg == null || !(arg instanceof Cortege);
	}

	private boolean isValuesEquals(Cortege cortege) {
		for (Variable variable : keySet()) {
			if (!this.get(variable).equals(cortege.get(variable))) {
				return false;
			}
		}
		return true;
	}

}



import java.util.ArrayList;
import java.util.List;

import model.Cortege;
import model.ValueTable;
import model.parameters.Constant;
import model.parameters.Variable;


public class EntryPoint {

	public static void main(String[] args) {
		ValueTable table1 = new ValueTable();
		ValueTable table2 = new ValueTable();
		ValueTable resT = new ValueTable();
		List<Variable> list1 = new ArrayList<>();
		List<Variable> list2 = new ArrayList<>();
		list1.add(new Variable("X"));
		list1.add(new Variable("Y"));
		list1.add(new Variable("Z"));
		list2.add(new Variable("A"));
		list2.add(new Variable("Y"));
		list2.add(new Variable("Z"));
		table1.setHeaders(list1);
		table2.setHeaders(list2);
		
		Cortege cort1 = new Cortege();
		Cortege cort2 = new Cortege();
		Cortege cort3 = new Cortege();
		cort1.put(new Variable("X"), new Constant("1"));
		cort1.put(new Variable("Y"), new Constant("2"));
		cort1.put(new Variable("Z"), new Constant("3"));
		cort2.put(new Variable("X"), new Constant("x"));
		cort2.put(new Variable("Y"), new Constant("y"));
		cort2.put(new Variable("Z"), new Constant("z"));
		cort3.put(new Variable("X"), new Constant("4"));
		cort3.put(new Variable("Y"), new Constant("5"));
		cort3.put(new Variable("Z"), new Constant("6"));
		
		Cortege cort4 = new Cortege();
		Cortege cort5 = new Cortege();
		Cortege cort6 = new Cortege();
		Cortege cort7 = new Cortege();
		cort4.put(new Variable("A"), new Constant("1"));
		cort4.put(new Variable("Y"), new Constant("2"));
		cort4.put(new Variable("Z"), new Constant("3"));
		cort5.put(new Variable("A"), new Constant("x"));
		cort5.put(new Variable("Y"), new Constant("y"));
		cort5.put(new Variable("Z"), new Constant("z"));
		cort6.put(new Variable("A"), new Constant("4"));
		cort6.put(new Variable("Y"), new Constant("7"));
		cort6.put(new Variable("Z"), new Constant("8"));
		
		cort7.put(new Variable("A"), new Constant("s"));
		cort7.put(new Variable("Y"), new Constant("2"));
		cort7.put(new Variable("Z"), new Constant("3"));
		
		table1.addCortege(cort1);
		table1.addCortege(cort2);
		table1.addCortege(cort3);
		
		table2.addCortege(cort4);
		table2.addCortege(cort5);
		table2.addCortege(cort6);
		table2.addCortege(cort7);
		List<Variable> attributes = new ArrayList<>();
		attributes.add(new Variable("X"));
		attributes.add(new Variable("Y"));
		resT = table1.merge(table2);
		resT = resT.projection(attributes);
		System.out.println(resT);
	}
}

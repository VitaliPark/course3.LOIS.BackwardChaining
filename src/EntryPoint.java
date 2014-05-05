
import input.LogicReader;

import java.util.ArrayList;
import java.util.List;

import GUI.MainWnd;
import consequence.RuleParser;
import controller.ViewController;
import model.Cortege;
import model.Predicate;
import model.Rule;
import model.ValueTable;
import model.base.Base;
import model.parameters.Constant;
import model.parameters.Variable;

public class EntryPoint {

	public static void main(String[] args) {
		ViewController controller = new ViewController();
		MainWnd window = new MainWnd(controller);
		LogicReader reader = new LogicReader();
		RuleParser parser = new RuleParser(controller);
		controller.setParser(parser);
		controller.setWindow(window);
		controller.setReader(reader);
		window.display();
		// mergeTest3();
		// unionTest1();
		// ruleParserTest();
		// mergeTest1();
		// cortegeTest1();
	}

	private static void mergeTest1() {
		ValueTable table1 = new ValueTable();
		ValueTable table2 = new ValueTable();
		ValueTable resT = new ValueTable();
		List<Variable> list1 = new ArrayList<>();
		List<Variable> list2 = new ArrayList<>();
		list1.add(new Variable("X"));
		list1.add(new Variable("Y"));
		list1.add(new Variable("Z"));
		list2.add(new Variable("A"));
		list2.add(new Variable("B"));
		list2.add(new Variable("C"));
		table1.setHeaders(list1);
		table2.setHeaders(list2);

		Cortege cort1 = new Cortege(list1);
		Cortege cort2 = new Cortege(list1);
		Cortege cort3 = new Cortege(list1);
		cort1.put(new Variable("X"), new Constant("1"));
		cort1.put(new Variable("Y"), new Constant("2"));
		cort1.put(new Variable("Z"), new Constant("3"));
		cort2.put(new Variable("X"), new Constant("x"));
		cort2.put(new Variable("Y"), new Constant("y"));
		cort2.put(new Variable("Z"), new Constant("z"));
		cort3.put(new Variable("X"), new Constant("4"));
		cort3.put(new Variable("Y"), new Constant("5"));
		cort3.put(new Variable("Z"), new Constant("6"));

		Cortege cort4 = new Cortege(list2);
		Cortege cort5 = new Cortege(list2);
		Cortege cort6 = new Cortege(list2);
		Cortege cort7 = new Cortege(list2);
		Cortege cort8 = new Cortege(list2);

		cort4.put(new Variable("A"), new Constant("1"));
		cort4.put(new Variable("B"), new Constant("1"));
		cort4.put(new Variable("C"), new Constant("3"));
		cort5.put(new Variable("A"), new Constant("x"));
		cort5.put(new Variable("B"), new Constant("y"));
		cort5.put(new Variable("C"), new Constant("z"));
		cort6.put(new Variable("A"), new Constant("4"));
		cort6.put(new Variable("B"), new Constant("7"));
		cort6.put(new Variable("C"), new Constant("8"));

		cort7.put(new Variable("A"), new Constant("s"));
		cort7.put(new Variable("B"), new Constant("2"));
		cort7.put(new Variable("C"), new Constant("3"));
		cort8.put(new Variable("A"), new Constant("9"));
		cort8.put(new Variable("B"), new Constant("5"));
		cort8.put(new Variable("C"), new Constant("6"));

		table1.addCortege(cort1);
		table1.addCortege(cort2);
		table1.addCortege(cort3);

		table2.addCortege(cort4);
		table2.addCortege(cort5);
		table2.addCortege(cort6);
		table2.addCortege(cort7);
		table2.addCortege(cort8);
		List<Variable> attributes = new ArrayList<>();
		attributes.add(new Variable("X"));
		// attributes.add(new Variable("A"));
		resT = table1.merge(table2);
		resT = resT.projection(attributes);
		System.out.println(resT);
	}

	private static void mergeTest2() {
		ValueTable table1 = new ValueTable();
		ValueTable table2 = new ValueTable();
		ValueTable resT = new ValueTable();
		List<Variable> list1 = new ArrayList<>();
		List<Variable> list2 = new ArrayList<>();
		list1.add(new Variable("X"));
		list1.add(new Variable("X"));
		list2.add(new Variable("X"));
		table1.setHeaders(list1);
		table2.setHeaders(list2);

		Cortege cort1 = new Cortege(list2);

		cort1.put(new Variable("X"), new Constant("1"));

		table1.addCortege(cort1);

		List<Variable> attributes = new ArrayList<>();
		attributes.add(new Variable("X"));
		attributes.add(new Variable("X"));
		// resT = table1.merge(table2);
		resT = table1.projection(attributes);
		System.out.println(resT);
	}

	private static void mergeTest3() {
		RuleParser parser = new RuleParser(new ViewController());
		ValueTable table1 = new ValueTable();
		ValueTable table2 = new ValueTable();
		ValueTable table3 = new ValueTable();
		ValueTable resT = new ValueTable();
		List<Variable> list1 = new ArrayList<>();
		List<Variable> list2 = new ArrayList<>();
		List<Variable> list3 = new ArrayList<>();
		list1.add(new Variable("X"));
		list1.add(new Variable("C"));
		list2.add(new Variable("C"));
		list2.add(new Variable("Y"));
		list3.add(new Variable("Y"));
		list3.add(new Variable("Z"));
		table1.setHeaders(list1);
		table2.setHeaders(list2);
		table3.setHeaders(list3);

		Cortege cort1 = new Cortege(list1);
		Cortege cort2 = new Cortege(list1);
		Cortege cort3 = new Cortege(list1);
		cort1.put(new Variable("X"), new Constant("a"));
		cort1.put(new Variable("C"), new Constant("b"));
		cort2.put(new Variable("X"), new Constant("b"));
		cort2.put(new Variable("C"), new Constant("c"));
		cort3.put(new Variable("X"), new Constant("m"));
		cort3.put(new Variable("C"), new Constant("k"));

		Cortege cort4 = new Cortege(list2);
		Cortege cort5 = new Cortege(list2);
		Cortege cort6 = new Cortege(list2);
		Cortege cort7 = new Cortege(list3);
		Cortege cort8 = new Cortege(list3);

		cort4.put(new Variable("C"), new Constant("b"));
		cort4.put(new Variable("Y"), new Constant("o"));
		cort5.put(new Variable("C"), new Constant("b"));
		cort5.put(new Variable("Y"), new Constant("a"));
		cort6.put(new Variable("C"), new Constant("k"));
		cort6.put(new Variable("Y"), new Constant("c"));

		cort7.put(new Variable("Y"), new Constant("a"));
		cort7.put(new Variable("Z"), new Constant("k"));
		cort8.put(new Variable("Y"), new Constant("c"));
		cort8.put(new Variable("Z"), new Constant("p"));

		table1.addCortege(cort1);
		table1.addCortege(cort2);
		table1.addCortege(cort3);

		table2.addCortege(cort4);
		table2.addCortege(cort5);
		table2.addCortege(cort6);
		table3.addCortege(cort7);
		table3.addCortege(cort8);
		List<ValueTable> t = new ArrayList<>();
		t.add(table1);
		t.add(table2);
		t.add(table3);

		List<Variable> attributes = new ArrayList<>();
		attributes.add(new Variable("Z"));
		attributes.add(new Variable("A"));
		resT = parser.mergeAll(t);
		// resT = table1.merge(table2);
		// resT = resT.merge(table3);
		System.out.println(resT);
	}

	private static void unionTest1() {
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

		Cortege cort1 = new Cortege(list1);
		Cortege cort2 = new Cortege(list1);
		Cortege cort3 = new Cortege(list1);
		cort1.put(new Variable("X"), new Constant("1"));
		cort1.put(new Variable("Y"), new Constant("2"));
		cort1.put(new Variable("Z"), new Constant("3"));
		cort2.put(new Variable("X"), new Constant("x"));
		cort2.put(new Variable("Y"), new Constant("y"));
		cort2.put(new Variable("Z"), new Constant("z"));
		cort3.put(new Variable("X"), new Constant("4"));
		cort3.put(new Variable("Y"), new Constant("5"));
		cort3.put(new Variable("Z"), new Constant("6"));

		Cortege cort4 = new Cortege(list2);
		Cortege cort5 = new Cortege(list2);
		Cortege cort6 = new Cortege(list2);
		Cortege cort7 = new Cortege(list2);
		Cortege cort8 = new Cortege(list2);

		cort4.put(new Variable("A"), new Constant("1"));
		cort4.put(new Variable("Y"), new Constant("1"));
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
		cort8.put(new Variable("A"), new Constant("9"));
		cort8.put(new Variable("Y"), new Constant("5"));
		cort8.put(new Variable("Z"), new Constant("6"));

		table1.addCortege(cort1);
		table1.addCortege(cort2);
		table1.addCortege(cort3);

		table2.addCortege(cort4);
		table2.addCortege(cort5);
		table2.addCortege(cort6);
		table2.addCortege(cort7);
		table2.addCortege(cort8);
		List<Variable> attributes = new ArrayList<>();
		attributes.add(new Variable("Z"));
		attributes.add(new Variable("A"));
		table1.union(table2);
		// resT = resT.projection(attributes);
		System.out.println(table1);
	}

	public static void ruleParserTest() {
		Predicate A = new Predicate("A");
		Predicate B = new Predicate("B");
		Predicate C = new Predicate("C");
		A.addParameter(new Variable("X"));
		A.addParameter(new Variable("Y"));
		B.addParameter(new Variable("X"));
		B.addParameter(new Variable("Z"));
		C.addParameter(new Variable("Z"));
		C.addParameter(new Variable("Y"));

		Rule rule = new Rule(A);
		rule.addRuleTerm(B);
		rule.addRuleTerm(C);

		Predicate B1 = new Predicate("B");
		B1.addParameter(new Variable("X"));
		B1.addParameter(new Variable("Y"));
		Predicate K = new Predicate("K");
		K.addParameter(new Variable("X"));
		K.addParameter(new Variable("X"));

		Rule rule2 = new Rule(B1);
		rule2.addRuleTerm(K);

		Predicate aFact1 = new Predicate("A");
		aFact1.addParameter(new Constant("a"));
		aFact1.addParameter(new Constant("a"));
		Rule ruleFact1 = new Rule(aFact1);

		Predicate aFact2 = new Predicate("A");
		aFact2.addParameter(new Constant("k"));
		aFact2.addParameter(new Constant("k"));
		Rule ruleFact2 = new Rule(aFact2);

		Predicate bFact1 = new Predicate("B");
		bFact1.addParameter(new Constant("p"));
		bFact1.addParameter(new Constant("m"));
		Rule ruleFact3 = new Rule(bFact1);

		Predicate bFact2 = new Predicate("B");
		bFact2.addParameter(new Constant("l"));
		bFact2.addParameter(new Constant("k"));
		Rule ruleFact4 = new Rule(bFact2);

		Predicate cFact1 = new Predicate("C");
		cFact1.addParameter(new Constant("m"));
		cFact1.addParameter(new Constant("o"));
		Rule ruleFact5 = new Rule(cFact1);

		Predicate cFact2 = new Predicate("C");
		cFact2.addParameter(new Constant("k"));
		cFact2.addParameter(new Constant("j"));
		Rule ruleFact6 = new Rule(cFact2);

		Predicate cFact3 = new Predicate("C");
		cFact3.addParameter(new Constant("p"));
		cFact3.addParameter(new Constant("v"));
		Rule ruleFact7 = new Rule(cFact3);

		Predicate cFact4 = new Predicate("C");
		cFact4.addParameter(new Constant("n"));
		cFact4.addParameter(new Constant("u"));
		Rule ruleFact10 = new Rule(cFact4);

		Predicate kFact1 = new Predicate("K");
		kFact1.addParameter(new Constant("a"));
		kFact1.addParameter(new Constant("p"));
		Rule ruleFact8 = new Rule(kFact1);

		Predicate kFact2 = new Predicate("K");
		kFact2.addParameter(new Constant("d"));
		kFact2.addParameter(new Constant("n"));
		Rule ruleFact9 = new Rule(kFact2);

		Base.INSTANCE.addRule(rule);
		Base.INSTANCE.addRule(rule2);
		Base.INSTANCE.addRule(ruleFact1);
		Base.INSTANCE.addRule(ruleFact2);
		Base.INSTANCE.addRule(ruleFact3);
		Base.INSTANCE.addRule(ruleFact4);
		Base.INSTANCE.addRule(ruleFact5);
		Base.INSTANCE.addRule(ruleFact6);
		Base.INSTANCE.addRule(ruleFact7);
		Base.INSTANCE.addRule(ruleFact8);
		Base.INSTANCE.addRule(ruleFact9);
		Base.INSTANCE.addRule(ruleFact10);

		Predicate query = new Predicate("A");
		query.addParameter(new Variable("X"));
		query.addParameter(new Variable("Z"));

		RuleParser parser = new RuleParser(new ViewController());
		ValueTable result = new ValueTable();
		result = parser.parsePredicate(query);
		System.out.println(result);

	}

	private static void cortegeTest1() {
		ValueTable table1 = new ValueTable();
		ValueTable resT = new ValueTable();
		List<Variable> list1 = new ArrayList<>();
		list1.add(new Variable("X"));
		list1.add(new Variable("X"));
		list1.add(new Variable("Z"));

		Cortege cort1 = new Cortege(list1);
		Cortege cort2 = new Cortege(list1);
		Cortege cort3 = new Cortege(list1);
		cort1.put(new Variable("X"), new Constant("1"));
		cort1.put(new Variable("X"), new Constant("1"));
		cort1.put(new Variable("Z"), new Constant("3"));
		cort2.put(new Variable("X"), new Constant("x"));
		cort2.put(new Variable("X"), new Constant("x"));
		cort2.put(new Variable("Z"), new Constant("z"));
		cort3.put(new Variable("X"), new Constant("4"));
		cort3.put(new Variable("X"), new Constant("4"));
		cort3.put(new Variable("Z"), new Constant("6"));
		table1.setHeaders(list1);
		table1.addCortege(cort1);
		table1.addCortege(cort2);
		table1.addCortege(cort3);
		RuleParser parser = new RuleParser(new ViewController());
		ValueTable result = new ValueTable();
		result.setHeaders(list1);
		parser.updateTable(table1);
		System.out.println(table1);
	}
}

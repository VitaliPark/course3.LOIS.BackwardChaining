package controller;

import input.LogicReader;
import model.Predicate;
import GUI.MainWnd;
import consequence.Solver;

public class ViewController {
	private MainWnd window;
	private LogicReader reader;
	private Solver solver;

	public void setWindow(MainWnd window) {
		this.window = window;
	}

	public void setReader(LogicReader reader) {
		this.reader = reader;
	}

	public void setSolver(Solver solver) {
		this.solver = solver;
	}

	public Predicate checkQuery(String query) {
		return reader.checkQuery(query);
	}

	public String readDB() {
		return reader.read();
	}

	public void printAnswer(String answer) {
		window.setResult(answer);
	}

	public void solveTask(Predicate predicate) {
		String result = solver.solveTask(predicate);
		printAnswer(result);
	}
	public void printErrorMessage(String message) {
		window.setResult(message);
	}
}

package controller;

import input.LogicReader;
import GUI.MainWnd;
import consequence.Solver;

public class ViewController implements Controller {
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

	public void readDB() {
		window.printDB(reader.read());
	}

	public void solveTask(String query) {
		String result = solver.solveTask(reader.checkQuery(query));
		window.printResult(result);
	}

}

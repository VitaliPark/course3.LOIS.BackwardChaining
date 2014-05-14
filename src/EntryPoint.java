import input.LogicReader;

import GUI.MainWnd;
import consequence.RecursiveSolver;
import consequence.Solver;
import controller.ViewController;

public class EntryPoint {

	public static void main(String[] args) {
		ViewController controller = new ViewController();
		MainWnd window = new MainWnd(controller);
		LogicReader reader = new LogicReader();
		Solver solver = new RecursiveSolver(controller);
		controller.setSolver(solver);
		controller.setWindow(window);
		controller.setReader(reader);
		window.display();
	}
}

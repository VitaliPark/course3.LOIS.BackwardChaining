
import input.LogicReader;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import GUI.MainWnd;
import consequence.RecursiveSolver;
import consequence.Solver;
import controller.ViewController;

public class EntryPoint {

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
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

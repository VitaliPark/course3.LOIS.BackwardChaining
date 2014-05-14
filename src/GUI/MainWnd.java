package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import controller.ViewController;

public class MainWnd {

	private JFrame frame;
	private JTextField txtQueryfield;
	private ViewController controller;
	private JTextArea DBTextArea;
	private JTextArea resulTextArea;

	public MainWnd(ViewController controller) {
		this.controller = controller;
		initialize();
	}

	public void display() {
		frame.setVisible(true);
	}

	public void printResult(String result) {
		resulTextArea.setText(result);
	}

	public void printDB(String DB) {
		DBTextArea.setText(DB);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		initDBPart();
		initQueryPart();
		initResultPart();
		initToolBar();
	}

	private void initDBPart() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 36, 229, 370);
		frame.getContentPane().add(scrollPane);

		DBTextArea = new JTextArea();
		scrollPane.setViewportView(DBTextArea);
		DBTextArea.setEditable(false);

		JLabel DBLabel = new JLabel(GUIConstants.DB_LABEL_NAME.getValue());
		DBLabel.setBounds(71, 11, 46, 14);
		frame.getContentPane().add(DBLabel);

		txtQueryfield = new JTextField();
		txtQueryfield.setBounds(327, 34, 86, 20);
		frame.getContentPane().add(txtQueryfield);
		txtQueryfield.setColumns(10);
	}

	private void initQueryPart() {
		JLabel queryLabel = new JLabel(GUIConstants.QUERY_LABEL_NAME.getValue());
		queryLabel.setBounds(327, 11, 46, 14);
		frame.getContentPane().add(queryLabel);

		JButton btnSearch = new JButton(
				GUIConstants.SEARCH_BUTTON_NAME.getValue());
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.solveTask(txtQueryfield.getText());
			}
		});
		btnSearch.setBounds(327, 66, 89, 23);
		frame.getContentPane().add(btnSearch);
	}

	private void initResultPart() {
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(437, 36, 237, 370);
		frame.getContentPane().add(scrollPane_1);

		resulTextArea = new JTextArea();
		resulTextArea.setEditable(false);
		scrollPane_1.setViewportView(resulTextArea);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(453, 11, 46, 14);
		frame.getContentPane().add(lblResult);
	}

	private void initToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setBounds(0, 0, 65, 262);
		frame.getContentPane().add(toolBar);
		initToolBarButtons(toolBar);
	}

	private void initToolBarButtons(JToolBar toolBar) {
		JButton openButton = new JButton();
		openButton.setForeground(UIManager.getColor(GUIConstants.BUTTONS_COLOR
				.getValue()));
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.readDB();
			}
		});
		openButton
				.setIcon(new ImageIcon(GUIConstants.OPEN_IMG_PATH.getValue()));
		toolBar.add(openButton);

		JButton searchButton = new JButton();
		searchButton.setBackground(UIManager
				.getColor(GUIConstants.BUTTONS_COLOR.getValue()));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.solveTask(txtQueryfield.getText());
			}
		});
		searchButton.setIcon(new ImageIcon(GUIConstants.SEARCH_INMG_PATH
				.getValue()));
		toolBar.add(searchButton);

		JButton aboutButton = new JButton();
		aboutButton.setForeground(UIManager.getColor(GUIConstants.BUTTONS_COLOR
				.getValue()));
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
						GUIConstants.ABOUT_MESSAGE.getValue());
			}
		});
		aboutButton.setIcon(new ImageIcon(GUIConstants.ABOUT_IMG_PATH
				.getValue()));
		toolBar.add(aboutButton);
	}
}

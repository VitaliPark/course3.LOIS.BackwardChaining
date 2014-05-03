package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.awt.Canvas;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWnd {

	private JFrame frame;
	private JTextField txtQueryfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWnd window = new MainWnd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWnd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 174, 129);
		frame.getContentPane().add(scrollPane);

		JTextArea DBTextArea = new JTextArea();
		DBTextArea.setEditable(false);
		scrollPane.setViewportView(DBTextArea);

		JLabel DBLabel = new JLabel("DB");
		DBLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(DBLabel);

		txtQueryfield = new JTextField();
		txtQueryfield.setBounds(208, 34, 86, 20);
		frame.getContentPane().add(txtQueryfield);
		txtQueryfield.setColumns(10);

		JLabel queryLabel = new JLabel("Query");
		queryLabel.setBounds(208, 11, 46, 14);
		frame.getContentPane().add(queryLabel);

		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// calculate
			}
		});
		btnSearch.setBounds(208, 65, 89, 23);
		frame.getContentPane().add(btnSearch);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(359, 36, 174, 129);
		frame.getContentPane().add(scrollPane_1);

		JTextArea resulTextArea = new JTextArea();
		resulTextArea.setEditable(false);
		scrollPane_1.setViewportView(resulTextArea);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(359, 11, 46, 14);
		frame.getContentPane().add(lblResult);
	}
}

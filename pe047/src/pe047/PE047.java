package pe047;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PE047 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE047 window = new PE047();
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
	public PE047() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				textField.setText(Long.toString(Work047.doIt()));
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.setBounds(100, 100, 586, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnTheFirstTwo = new JTextPane();
		txtpnTheFirstTwo.setEditable(false);
		txtpnTheFirstTwo.setBackground(SystemColor.window);
		txtpnTheFirstTwo.setText("The first two consecutive numbers to have two distinct prime factors are:\n\n14 = 2 × 7\n15 = 3 × 5\n\nThe first three consecutive numbers to have three distinct prime factors are:\n\n644 = 2² × 7 × 23\n645 = 3 × 5 × 43\n646 = 2 × 17 × 19.\n\nFind the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?\n");
		txtpnTheFirstTwo.setBounds(20, 30, 545, 237);
		frame.getContentPane().add(txtpnTheFirstTwo);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(225, 279, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}

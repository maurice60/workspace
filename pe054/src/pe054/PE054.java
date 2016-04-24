package pe054;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PE054 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE054 window = new PE054();
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
	public PE054() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setText(Long.toString(Work54.doIt()));
			}
		});
		frame.setBounds(100, 100, 512, 286);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnTheFilePokertxt = new JTextPane();
		txtpnTheFilePokertxt.setBounds(19, 10, 474, 206);
		txtpnTheFilePokertxt.setBackground(SystemColor.window);
		txtpnTheFilePokertxt.setEditable(false);
		txtpnTheFilePokertxt.setText("The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.\n\nHow many hands does Player 1 win?");
		frame.getContentPane().add(txtpnTheFilePokertxt);
		
		textField = new JTextField();
		textField.setBounds(189, 226, 134, 28);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

}

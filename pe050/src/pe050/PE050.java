package pe050;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class PE050 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE050 window = new PE050();
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
	public PE050() {
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
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				textField.setText(Long.toString(Work050.doIt()));
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnThePrime = new JTextPane();
		txtpnThePrime.setBackground(SystemColor.window);
		txtpnThePrime.setText("The prime 41, can be written as the sum of six consecutive primes:\n41 = 2 + 3 + 5 + 7 + 11 + 13\n\nThis is the longest sum of consecutive primes that adds to a prime below one-hundred.\n\nThe longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.\n\nWhich prime, below one-million, can be written as the sum of the most consecutive primes?\n");
		txtpnThePrime.setEditable(false);
		txtpnThePrime.setBounds(16, 6, 416, 203);
		frame.getContentPane().add(txtpnThePrime);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(155, 221, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}

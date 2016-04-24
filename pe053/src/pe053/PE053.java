package pe053;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PE053 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE053 window = new PE053();
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
	public PE053() {
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
				textField.setText(Long.toString(Work53.doIt()));
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 517, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnThereAreExactly = new JTextPane();
		txtpnThereAreExactly.setBackground(SystemColor.window);
		txtpnThereAreExactly.setContentType("text/html");
		txtpnThereAreExactly.setText("<p>There are exactly ten ways of selecting three from five, 12345:</p><p><center>123, 124, 125, 134, 135, 145, 234, 235, 245, and 345</center></p><p>In combinatorics, we use the notation, <sup>5</sup>C<sub>3</sub> = 10.</p><p>In general,<sup>n</sup>C<sub>r</sub> = n! / r!(n−r)!,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.</p><p>It is not until n = 23, that a value exceeds one-million: <sup>23</sup>C<sub>10</sub> = 1144066.</p><p>How many, not necessarily distinct, values of  <sup>n</sup>C<sub>r</sub>, for 1 ≤ n ≤ 100, are greater than one-million?</p>");
		txtpnThereAreExactly.setEditable(false);
		txtpnThereAreExactly.setBounds(18, 6, 481, 253);
		frame.getContentPane().add(txtpnThereAreExactly);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(190, 271, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}

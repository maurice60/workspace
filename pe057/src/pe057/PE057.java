package pe057;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class PE057 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE057 window = new PE057();
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
	public PE057() {
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
				textField.setText(Long.toString(Work57.doIt()));
			}
		});
		frame.setBounds(100, 100, 606, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow,center][grow]", "[grow][::10px][center]"));
		
		JTextPane txtpnItIsPossible = new JTextPane();
		txtpnItIsPossible.setBackground(SystemColor.window);
		txtpnItIsPossible.setText("It is possible to show that the square root of two can be expressed as an infinite continued fraction.\n\n√ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...\n\nBy expanding this for the first four iterations, we get:\n\n1 + 1/2 = 3/2 = 1.5\n1 + 1/(2 + 1/2) = 7/5 = 1.4\n1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...\n1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...\n\nThe next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.\n\nIn the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?");
		txtpnItIsPossible.setEditable(false);
		frame.getContentPane().add(txtpnItIsPossible, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 1 2,alignx center");
		textField.setColumns(10);
	}

}

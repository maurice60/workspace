package pe064;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class PE064 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE064 window = new PE064();
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
	public PE064() {
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
				textField.setText(Long.toString(Work64.doIt()));
		        frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.setBounds(100, 100, 678, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow,center][grow]", "[grow]10[]"));
		
		JTextPane txtpnForConcisenessWe = new JTextPane();
		txtpnForConcisenessWe.setBackground(SystemColor.window);
		txtpnForConcisenessWe.setText("For conciseness, we use the notation √23 = [4;(1,3,1,8)], to indicate that the block (1,3,1,8) repeats indefinitely.\n\nThe first ten continued fraction representations of (irrational) square roots are:\n\n√2=[1;(2)], period=1\n√3=[1;(1,2)], period=2\n√5=[2;(4)], period=1\n√6=[2;(2,4)], period=2\n√7=[2;(1,1,1,4)], period=4\n√8=[2;(1,4)], period=2\n√10=[3;(6)], period=1\n√11=[3;(3,6)], period=2\n√12= [3;(2,6)], period=2\n√13=[3;(1,1,1,1,6)], period=5\n\nExactly four continued fractions, for N ≤ 13, have an odd period.\n\nHow many continued fractions for N ≤ 10000 have an odd period?");
		txtpnForConcisenessWe.setEditable(false);
		frame.getContentPane().add(txtpnForConcisenessWe, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 1 1,alignx center");
		textField.setColumns(10);
	}

}

package pe065;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Cursor;

public class PE065 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE065 window = new PE065();
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
	public PE065() {
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
				textField.setText(Long.toString(Work65.doIt()));
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.setBounds(100, 100, 529, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow]10[]"));
		
		JTextPane textExplain = new JTextPane();
		textExplain.setBackground(SystemColor.window);
		textExplain.setContentType("text/html");
		textExplain.setText("<p>Hence the sequence of the first ten convergents for √2 are:<br>\n1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...</p>\n<p>What is most surprising is that the important mathematical constant,<br>\ne = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].</p>\n<p>The first ten terms in the sequence of convergents for e are:<br>\n2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...</p>\n\n<p>The sum of digits in the numerator of the 10<sup>th</sup> convergent is 1+4+5+7=17.</p>\n\n<p>Find the sum of digits in the numerator of the 100<sup>th</sup> convergent of the continued fraction for e.</p>");
		textExplain.setEditable(false);
		frame.getContentPane().add(textExplain, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField, "cell 1 1,alignx center");
		textField.setColumns(10);
	}

}

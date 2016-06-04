package pe066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PE066 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE066 window = new PE066();
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
	public PE066() {
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
				textField.setText(Long.toString(Work66.doIt()));
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 633, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][]"));
		
		JTextPane textBlurb = new JTextPane();
		textBlurb.setBackground(SystemColor.window);
		textBlurb.setContentType("text/html");
		textBlurb.setText("<p>Consider quadratic Diophantine equations of the form:</p>\n\n<p>x<sup>2</sup> – Dy<sup>2</sup> = 1\n\n<p>For example, when D=13, the minimal solution in x is 6492 – 13×1802 = 1.</p>\n\n<p>It can be assumed that there are no solutions in positive integers when D is square.</p>\n\n<p>By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:</p>\n<table>\n<tr>3<sup>2 </sup>– 2×2<sup>2 </sup> = 1</tr>\n<tr>2<sup>2 </sup> – 3×1<sup>2 </sup> = 1</tr>\n<tr><font color=\"red\">9</font><sup>2 </sup> – 5×4<sup>2 </sup> = 1</tr>\n<tr>5<sup>2 </sup> – 6×2<sup>2 </sup> = 1</tr>\n<tr>8<sup>2 </sup> – 7×3<sup>2 </sup> = 1</tr>\n</table>\n<p>Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.</p>\n\n<p>Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.</p>\n");
		textBlurb.setEditable(false);
		frame.getContentPane().add(textBlurb, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 1 1,alignx center");
		textField.setColumns(15);
	}

}

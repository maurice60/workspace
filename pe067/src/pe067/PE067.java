package pe067;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PE067 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE067 window = new PE067();
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
	public PE067() {
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
				textField.setText(Long.toString(Work67.doIt()));
			}
		});
		frame.setBounds(100, 100, 503, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][]"));
		
		JTextPane txtpnBlurb = new JTextPane();
		txtpnBlurb.setBackground(SystemColor.window);
		txtpnBlurb.setContentType("text/html");
		txtpnBlurb.setText("<p>By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.</p>\n<p style=\"text-align:center;font-family:'courier new';font-size:12pt;\"><span style=\"color:#ff0000;\"><b>3</b></span><br /><span style=\"color:#ff0000;\"><b>7</b></span> 4<br />\n2 <span style=\"color:#ff0000;\"><b>4</b></span> 6<br />\n8 5 <span style=\"color:#ff0000;\"><b>9</b></span> 3</p>\n<p>That is, 3 + 7 + 4 + 9 = 23.</p>\n<p>Find the maximum total from top to bottom in <a href=\"project/resources/p067_triangle.txt\">triangle.txt</a> (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.</p>\n");
		txtpnBlurb.setEditable(false);
		frame.getContentPane().add(txtpnBlurb, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 1 1,alignx center");
		textField.setColumns(15);
	}

}

package pe045;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PE045 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE045 frame = new PE045();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PE045() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setText(Long.toString(PE045w.doIt()));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpntrianglePentagonalAnd = new JTextPane();
		txtpntrianglePentagonalAnd.setEditable(false);
		txtpntrianglePentagonalAnd.setBackground(SystemColor.window);
		txtpntrianglePentagonalAnd.setContentType("text/html");
		txtpntrianglePentagonalAnd.setText("<p>Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:</p>\n<table>\n<tr><td>Triangle</td><td>T<sub>n</sub>=n(n+1)/2</td><td>1, 3, 6, 10, 15,... </td></tr><tr><td>Pentagonal</td><td>P<sub>n</sub>=n(3n−1)/2</td><td>1, 5, 12, 22, 35, ...</td></tr><tr><td>Hexagonal</td><td>H<sub>n</sub>=n(2n−1)</td><td>1, 6, 15, 28, 45, ... </td></tr></table><p>It can be verified that T<sub>285</sub> = P<sub>165</sub> = H<sub>143</sub> = 40755.</p><p>Find the next triangle number that is also pentagonal and hexagonal.</p>");
		txtpntrianglePentagonalAnd.setBounds(17, 6, 467, 209);
		contentPane.add(txtpntrianglePentagonalAnd);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(167, 227, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

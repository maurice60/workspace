package pe043;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import lists.Permutations;
import java.awt.Cursor;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Pe043 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pe043 frame = new Pe043();
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
	public Pe043() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				textField.setText(Long.toString(doIt()));
				contentPane.setCursor(Cursor.getDefaultCursor());
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnTheNumber = new JTextPane();
		txtpnTheNumber.setContentType("text/html");
		txtpnTheNumber.setFocusTraversalPolicyProvider(true);
		txtpnTheNumber.setBackground(SystemColor.window);
		txtpnTheNumber.setBounds(30, 5, 486, 300);
		txtpnTheNumber.setEditable(false);
		txtpnTheNumber.setText("<p>The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.</p><p>Let d<sub>1</sub> be the 1<sup>st</sup> digit, d<sub>2</sub> be the 2<sup>nd</sup> digit, and so on. In this way, we note the following:</p><ul>\n<li> d<sub>2</sub>d<sub>3</sub>d<sub>4</sub>=406 is divisible by 2</li>\n<li>  d<sub>3</sub>d<sub>4</sub>d<sub>5</sub>=063 is divisible by 3</li>\n<li>  d<sub>4</sub>d<sub>5</sub>d<sub>6</sub>=635 is divisible by 5</li>\n<li>  d<sub>5</sub>d<sub>6</sub>d<sub>7</sub>=357 is divisible by 7</li>\n<li>  d<sub>6</sub>d<sub>7</sub>d<sub>8</sub>=572 is divisible by 11</li>\n<li> d<sub>7</sub>d<sub>8</sub>d<sub>9</sub>=728 is divisible by 13</li>\n<li>  d<sub>8</sub>d<sub>9</sub>d<sub>10</sub>=289 is divisible by 17</li></ul>\n<p>Find the sum of all 0 to 9 pandigital numbers with this property.</p>");
		contentPane.add(txtpnTheNumber);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(175, 317, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	private long doIt() {
		ArrayList<String> pan = Permutations.permutation("1234567890");
		long ans = 0;

		for (String p : pan) {
			if (Integer.parseInt(p.substring(7)) % 17 != 0) continue;
			if (Integer.parseInt(p.substring(6, 9)) % 13 != 0) continue;
			if (Integer.parseInt(p.substring(5, 8)) % 11 != 0) continue;
			if (Integer.parseInt(p.substring(4, 7)) % 7 != 0) continue;
			if (Integer.parseInt(p.substring(3, 6)) % 5 != 0) continue;
			if (Integer.parseInt(p.substring(2, 5)) % 3 != 0) continue;
			if (Integer.parseInt(p.substring(1, 4)) % 2 == 0) ans += Long.parseLong(p);
		}
		return ans;
	}
}

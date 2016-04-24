package pe046;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class pe046 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pe046 frame = new pe046();
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
	public pe046() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setText(Long.toString(Work.doIt()));
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnItWasProposed = new JTextPane();
		txtpnItWasProposed.setEditable(false);
		txtpnItWasProposed.setBackground(SystemColor.window);
		txtpnItWasProposed.setContentType("text/html");
		txtpnItWasProposed.setText("<div>\n<p>It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.</p>\n<table>\n<tr>9 = 7 + 2×1<sup>2</sup></tr>\n<tr>15 = 7 + 2×2<sup>2</sup></tr>\n<tr>21 = 3 + 2×3<sup>2</sup></tr>\n<tr>25 = 7 + 2×3<sup>2</sup></tr>\n<tr>27 = 19 + 2×2<sup>2</sup></tr>\n<tr>33 = 31 + 2×1<sup>2</sup></tr>\n</table>\n<p>It turns out that the conjecture was false.</p>\n<p>What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?</p>\n</div>");
		txtpnItWasProposed.setBounds(16, 6, 554, 303);
		contentPane.add(txtpnItWasProposed);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(216, 321, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

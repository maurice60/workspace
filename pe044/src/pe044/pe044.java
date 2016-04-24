package pe044;

import java.awt.EventQueue;
import numbers.Numbers;
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
public class pe044 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pe044 frame = new pe044();
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
	public pe044() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setText(Long.toString(doIt()));
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnpentagonalNumbersAre = new JTextPane();
		txtpnpentagonalNumbersAre.setBackground(SystemColor.window);
		txtpnpentagonalNumbersAre.setContentType("text/html");
		txtpnpentagonalNumbersAre.setEditable(false);
		txtpnpentagonalNumbersAre.setText("<p>Pentagonal numbers are generated by the formula, P<sub>n</sub>=n(3n−1)/2. The first ten pentagonal numbers are:</p><p><center>1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...</center></p><p>It can be seen that P<sub>4</sub> + P<sub>7</sub> = 22 + 70 = 92 = P<sub>8</sub>. However, their difference, 70 − 22 = 48, is not pentagonal.</p><p>Find the pair of pentagonal numbers, P<sub>j</sub> and P<sub>k</sub>, for which their sum and difference are pentagonal and D = |P<sub>k</sub> − P<sub>j</sub>| is minimised; what is the value of D?</p>");
		txtpnpentagonalNumbersAre.setBounds(17, 6, 487, 217);
		contentPane.add(txtpnpentagonalNumbersAre);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(191, 235, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	private final long RANGE = 10000000;
	private long doIt() {
		long ans = RANGE;
		Numbers num = new Numbers();
		for (int i = 1; i < RANGE; i++) {
			long m = num.pentagonalNumber(i);
			for (int j = i + 1; j < RANGE; j++) {
				long n = num.pentagonalNumber(j);
				if (n-m > ans) break; 
				if (num.isPentagonalNumber(n-m)) {
					if (num.isPentagonalNumber(n+m)) {
						ans = n - m;
					}
				}
			}
		}
		return ans;
	}
}

package pe048;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PE048 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE048 window = new PE048();
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
	public PE048() {
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
				textField.setText(Work048.doIt());
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnTheSeries = new JTextPane();
		txtpnTheSeries.setBackground(SystemColor.window);
		txtpnTheSeries.setContentType("text/html");
		txtpnTheSeries.setText("<p>\nThe series, 1<sup>1</sup> + 2<sup>2</sup> + 3<sup>3</sup> + ... + 10<sup>10</sup> = 10405071317.<br/><br/>Find the last ten digits of the series, 1<sup>1</sup> + 2<sup>2 </sup>+ 3<sup>3</sup> + ... + 1000<sup>1000</sup>.\n</p>");
		txtpnTheSeries.setEditable(false);
		txtpnTheSeries.setBounds(22, 18, 409, 186);
		frame.getContentPane().add(txtpnTheSeries);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(158, 216, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

}

package pe052;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class PE052 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE052 window = new PE052();
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
	public PE052() {
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
				textField.setText(Long.toString(Work52.doIt()));
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.setBounds(100, 100, 436, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[408px]", "[170px][28px]"));
		
		JTextPane txtpnItCanBe = new JTextPane();
		txtpnItCanBe.setBackground(SystemColor.window);
		txtpnItCanBe.setText("It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.\n\nFind the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.\n");
		txtpnItCanBe.setEditable(false);
		frame.getContentPane().add(txtpnItCanBe, "cell 0 0,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 0 1,alignx center,aligny top");
		textField.setColumns(10);
	}

}

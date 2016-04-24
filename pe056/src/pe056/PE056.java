package pe056;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class PE056 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE056 window = new PE056();
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
	public PE056() {
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
				textField.setText(Long.toString(Work56.doIt()));
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 513, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][::10.00px][center]"));
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setBackground(SystemColor.window);
		txtpnInfo.setEditable(false);
		txtpnInfo.setDropMode(DropMode.INSERT);
		txtpnInfo.setContentType("text/html");
		txtpnInfo.setText("<p>A googol (10<sup>100</sup>) is a massive number: one followed by one-hundred zeros; 100<sup>100</sup> is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.</p>\n\n<p>Considering natural numbers of the form, a<sup>b</sup>, where a, b &lt; 100, what is the maximum digital sum?</p>\n");
		frame.getContentPane().add(txtpnInfo, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 1 2,alignx center");
		textField.setColumns(10);
	}

}

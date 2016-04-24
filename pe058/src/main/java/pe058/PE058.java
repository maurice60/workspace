package pe058;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class PE058 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PE058 window = new PE058();
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
	public PE058() {
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
				textField.setText(Long.toString(Work58.doIt()));
			}
		});
		frame.setBounds(100, 100, 610, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow]10[]"));
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setFont(new Font("Courier New", Font.ITALIC, 13));
		txtpnInfo.setContentType("text/html");
		txtpnInfo.setEditable(false);
		txtpnInfo.setBackground(SystemColor.window);
		txtpnInfo.setText("<div>\n<p>Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.</p><br/>\n<table style=\"font-family:'Courier'\">\n<tr><td style=\"color:red\">37</td> <td>36</td> <td>35</td> <td>34</td> <td>33</td> <td>32</td> <td style=\"color:red\">31</td></tr>\n<tr><td>38</td> <td style=\"color:red\">17</td> <td>16</td> <td>15</td> <td>14</td> <td style=\"color:red\">13</td> <td>30</td></tr>\n<tr><td>39</td> <td>18</td> <td style=\"color:red\">&#32;5</td> <td>&#32;4</td> <td style=\"color:red\">&#32;3</td> <td>12</td> <td>29</td></tr>\n<tr><td>40</td> <td>19</td> <td>&#32;6</td> <td>&#32;1</td> <td>&#32;2</td> <td>11</td> <td>28</td></tr>\n<tr><td>41</td> <td>20</td> <td style=\"color:red\">&#32;7</td> <td>&#32;8</td> <td>&#32;9</td> <td>10</td> <td>27</td></tr>\n<tr><td>42</td> <td>21</td> <td>22</td> <td>23</td> <td>24</td> <td>25</td> <td>26</td></tr>\n<tr><td style=\"color:red\">43</td> <td>44</td> <td>45</td> <td>46</td> <td>47</td> <td>48</td> <td>49</td></tr>\n</table>\n<p>It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.</p>\n<p>If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?</p>\n</div>");
		frame.getContentPane().add(txtpnInfo, "cell 0 0 3 1,grow");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		frame.getContentPane().add(textField, "cell 1 1,alignx center");
		textField.setColumns(10);
	}

}

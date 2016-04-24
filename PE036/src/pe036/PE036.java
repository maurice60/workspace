package pe036;

import processing.core.PApplet;


public class PE036 extends PApplet {

	public void settings() {
		size(300, 200);
	}

	public void setup() {
		fill(0);
		text(Long.toString(pe036()), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe036.PE036.class.getName() });
	}

	/**
	 * <p>The decimal number, 585 = 1001001001<sub>2</sub> (binary), is palindromic in both bases.<br>
	 *<br>
	 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.<br>
	 *<br>
	 * (Please note that the palindromic number, in either base, may not include leading zeros.)<br></p>
	 *
	 * @return The required total
	 */
	private long pe036() {
		long ans = 0;
		for (Long i = 1L; i < 1000000; i += 2) {
			if (isPalindome(i.toString())) if (isPalindome(Long.toBinaryString(i))) ans += i;
		}
		return ans;
	}
	
	/**
	 * <p>Check if a string is a palindrome.</p>
	 * 
	 * @param x The string to check
	 * @return True if a palindrome, false otherwise
	 */
	private boolean isPalindome(String x) {
		int i = x.length();
		if (i <= 1) return true;
		if (x.charAt(0) == x.charAt(i - 1)) return isPalindome(x.substring(1, i - 1));
		return false;
	}
}

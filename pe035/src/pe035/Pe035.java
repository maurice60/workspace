package pe035;

import processing.core.PApplet;
import numbers.Numbers;
import java.util.HashMap;


public class Pe035 extends PApplet {

	public void settings() {
		size(300, 200);
	}

	public void setup() {
		fill(0);
		text(Long.toString(pe035()), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe035.Pe035.class.getName() });
	}
	
	/** 
	 *
	 * <p>The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.<br><br>
	 * 
	 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.<br><br>
	 * 
	 * How many circular primes are there below one million?<br><br></p>
	 * 
	 * @return Number
	 */
	private long pe035() {
		long ans = 0;
		boolean fnd;
		HashMap<Long, Long> pl = primes();
		for (long p : pl.keySet()) {
			long nex = p, nChar = (long) Math.log10(p);
			fnd = true;
			do {
				nex = (nex % 10) * (long) Math.pow(10.0, (double) nChar) + (nex / 10);
				fnd = pl.containsKey(nex);					
			} while (fnd == true && nex != p);
			if (fnd) ans++;
		}
		return ans;
	}
	
	private HashMap<Long, Long> primes() {
		Numbers num = new Numbers();
		HashMap<Long, Long> out = new HashMap<>();
		num.findPrimesLessThan(1000000);
		for (long p : num.primesList()) out.put(p, 0L);
		return out;
	}
}

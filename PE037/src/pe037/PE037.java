package pe037;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

import numbers.Numbers;

public class PE037 extends PApplet {

	public void settings() {
		size(300, 200);
	}

	public void setup() {
		fill(0);
		text(Long.toString(pe037()), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe037.PE037.class.getName() });
	}
	
	/**
	 * 
	 * <p>The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,<br>
	 * and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.<br>
	 *<br>
	 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.<br>
	 *<br>
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.</p>
	 *
	 * @return The required sum
	 */
	private long pe037() {
		HashMap<Long, Long> primes = primes();
		boolean chk = true;
		ArrayList<Long> ans = new ArrayList<>();
		for (long p : primes.keySet()) {
			if (p < 10) continue;
			chk = true;
			long nex = p;
			while (chk && nex > 10) {
				nex /= 10;
				chk = primes.containsKey(nex);
			}
			nex = p;
			while (chk && nex > 10) {
				long nChar = (long) Math.log10(nex);
				nex %= Math.pow(10, (double) nChar);
				chk = primes.containsKey(nex);
			}
			if (chk) {
				ans.add(p);
				if (ans.size() == 11) break;
			}
		}
		System.out.println(ans);
		return addUp(ans);
	}
	
	private long addUp(ArrayList<Long> toAdd) {
		long x = 0;
		for (long a : toAdd) x += a;
		return x;
	}
	
	private HashMap<Long, Long> primes() {
		Numbers num = new Numbers();
		return num.primesHash(1000000);
	}
}

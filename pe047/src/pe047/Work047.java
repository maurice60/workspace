package pe047;
import java.util.HashMap;

import numbers.Numbers;

public class Work047 {
	
	public static long doIt() {
		Numbers num = new Numbers(false);
		long ans = 0;
		int lim = num.findPrimesLessThan(5000000);
		for (long i = 1; i <= lim; i++) {
			HashMap<Long, Long> pf = num.findPrimeFactors(i, true);
			if (pf.size() != 4) {
				ans = 0;
				continue;
			}
			if (ans == 0) ans = i;
			else if (i - ans == 3) return ans;
		}
		return ans != lim ? ans : 0;
	}
}

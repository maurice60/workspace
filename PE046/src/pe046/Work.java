package pe046;

import java.util.HashMap;

import numbers.Numbers;

public class Work {
	
	public static long doIt() {
		Numbers num = new Numbers();
		HashMap<Long, Long> primeH = num.primesHash(10000);
		for (long i = 9; i < 10000; i += 2) {
			if (primeH.containsKey(i)) continue;
			for (long j : num.primesList()) {
				if (j > i) return i;
		    	Double sqr = Math.sqrt((i-j)/2);
		    	if (Math.floor(sqr) == sqr) break;
			}
		}
		return 0;
	}
}

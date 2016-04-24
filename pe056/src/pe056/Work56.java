package pe056;

import java.math.BigInteger;

class Work56 {
	public static long doIt() {
		long ans = 0;
		for (BigInteger a = BigInteger.ONE; a.compareTo(BigInteger.valueOf(100L)) < 0; a = a.add(BigInteger.ONE)) {
			for (int b = 1; b < 100; b++) {
				long tl = a.pow(b).toString().chars().map(c -> Character.getNumericValue(c)).sum();
				if (tl > ans) ans = tl;
			}			
		}
		return ans;
	}
}

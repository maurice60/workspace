package pe055;

import java.math.BigInteger;

class Work55 {

	public static long doIt() {
		long ans = 0;
		for (long i = 10; i <= 10000; i++) {
			BigInteger  x = BigInteger.valueOf(i);
			int l = 0;
			do {
				x = x.add(reverse(x));
				if (x.compareTo(reverse(x)) == 0) break;
			} while (++l < 50);
			if (l == 50) ans += 1;
		}
		return ans;
	}
	
	private static BigInteger reverse(BigInteger f) {
		BigInteger r = BigInteger.ZERO;
		BigInteger ten = BigInteger.TEN;
		for (BigInteger i = f; i.compareTo(BigInteger.ZERO) > 0; i = i.divide(ten)) {
			r = ten.multiply(r).add(i.mod(ten));
		}
		return r;
	}
}

package pe057;

import java.math.BigInteger;

class Work57 {

	private static BigInteger num = BigInteger.ONE;
	private static BigInteger den = BigInteger.ONE;
	private static final BigInteger TWO = BigInteger.valueOf(2);
	
	public static long doIt() {
		long ans = 0;
		for (int i = 0; i < 1000; i++) {
			if (num.toString().length() > den.toString().length()) ans += 1;
			nextIter();			
		}
		return ans;
	}
	
	private static void nextIter() {
		BigInteger numT = num;
		num = num.add(den.multiply(TWO));
		den = numT.add(den);
//		System.out.println(num+" "+den);
	}
}

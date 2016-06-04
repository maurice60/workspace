package pe065;

import numbers.stat.Numbers;
import numbers.BigRational;

class Work65 {
	
	public static long doIt() {
		long ans = 0;
		BigRational rat = BigRational.toRational(Numbers.continuedFraction(Numbers.bigE(100), 100));
		System.out.println(rat);
		for (char c : rat.getNum().toString().toCharArray()) ans += c - '0';
		return ans;
	}
}

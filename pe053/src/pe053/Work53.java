package pe053;

import java.math.BigInteger;
import java.util.ArrayList;

import numbers.Pascal;

public class Work53 {

	public static long doIt() {
		ArrayList<BigInteger> itm = new ArrayList<>();
		long ans = 0;
		itm.add(BigInteger.ONE);
		for (int ix = 1; ix <= 100; ix++) {
			itm = Pascal.nextBigRow(itm);
			for (BigInteger i : itm) ans += (i.compareTo(BigInteger.valueOf(1000000)) > -1) ? 1:0; 
		}
//		System.out.println(itm);
		return ans;
	}
}

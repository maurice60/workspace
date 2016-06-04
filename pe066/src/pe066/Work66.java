package pe066;
import numbers.stat.*;
import numbers.BigRational;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

class Work66 {
	
	public static long doIt() {
		long ans = 0;
		ArrayList<Long> cf;
		BigRational rat;
		BigInteger lg = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			if (Numbers.isSquareNumber(i)) continue;
			cf = Numbers.continuedFraction(Numbers.sqrt(BigDecimal.valueOf(i), 225));
			if (cf.size() % 2 ==  1) {
				cf.remove(cf.size()-1);
			}
			else {
				cf.addAll(cf.subList(1, cf.size()-1));
			}
			rat = BigRational.toRational(cf);
			if (rat.getNum().compareTo(lg) == 1) {
				lg = rat.getNum();
				ans = i;
			}
		}
		System.out.println(ans+" "+lg);
		return ans;
	}
}

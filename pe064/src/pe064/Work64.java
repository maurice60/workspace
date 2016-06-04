package pe064;

import numbers.stat.Numbers;
import java.math.BigDecimal;

public class Work64 {
	
	public static long doIt() {
		long ans = 0;
		for (int i = 1; i <= 10000; i++) {
			if (Numbers.continuedFraction(Numbers.sqrt(BigDecimal.valueOf(i), 225)).size() % 2 == 0) ans += 1;
		}
		return ans;
	}

}

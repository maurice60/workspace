package pe045;

import numbers.Numbers;

public class PE045w {
	
	public static long doIt() {
		Numbers num = new Numbers();
		for (long i = 286; i <= Long.MAX_VALUE; i++) {
			long t = num.triangleNumber(i);
			if (num.isPentagonalNumber(t) && num.isHexagonalNumber(t)) return t;
		}
		return 0L;
	}
}

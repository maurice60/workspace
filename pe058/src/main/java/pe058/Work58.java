package pe058;

import numbers.Numbers;

class Work58 {
	
	public static long doIt() {
		long atI = 1, diag = 1, pri = 0, bas = 1, jmp = 2;
		Numbers num = new Numbers(false);
		num.findPrimesLessThan(100000);
		do  {
			for (int i = 0; i < 4; i++) {
				if (num.isPrime(atI += jmp)) pri += 1;
			}
			bas += 2;
			jmp += 2;
			diag += 4;
		} while (pri * 100.0 / diag > 10);
		return bas;
	}
}

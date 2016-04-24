package pe051;

import numbers.Numbers;

class Work051 {
	
	private static Numbers num = new Numbers();
	
	public static long doIt() {
		long ans = 0;
		for (Long p : num.primesList(1000000)) {
//			if (p < 100000) continue;
			String ps = p.toString();
			for (int i = 0; i < ps.length(); i++) {
				char c = ps.charAt(i);
				if (ps.lastIndexOf(c) != i)
					if (doSub(ps, c) == 8) return p;
			}
		}
		return ans;
	}
	
	private static int doSub(String s, char c) {
		int ret = 0;
		char [] r = "0123456789".toCharArray();
		for (char x : r) {
			String sr = s.replace(c, x);
			if (!sr.startsWith("0") && num.isPrime(Long.parseLong(sr))) ret += 1;
		}
		return ret;
	}
}

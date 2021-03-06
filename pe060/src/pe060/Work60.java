package pe060;

import java.util.ArrayList;

import numbers.Numbers;

class Work60 {

	private static Numbers num = new Numbers(false);
	private static final ArrayList<Long> PRIMES = findPrimes(10000);
	
	private static ArrayList<Long> findPrimes(int t) {
		ArrayList<Long> l = new ArrayList<>();
		num.findPrimesLessThan(t);
		for (long i : num.primesList()) {
			if (i == 2) continue;
			l.add(i);
		}
		return l;
	}
	
	private static boolean check(ArrayList<Long> xs, long y) {
		for (long x : xs) {
			long t1 = num.concatenate(x, y);
			long t2 = num.concatenate(y, x);
			if (!(num.isPrime(t1) && num.isPrime(t2))) return false;
		}
		return true;
	}

	private static ArrayList<Long> find(ArrayList<Long> fnd, int pos) {
		do {
			if (pos >= PRIMES.size()) {
				long o = fnd.remove(fnd.size() - 1);
				pos = PRIMES.indexOf(o) + 1;
				continue;
			}
			if (check(fnd, PRIMES.get(pos))) {
				fnd.add(PRIMES.get(pos++));
				continue;
			}
			pos += 1;
		} while (fnd.size() < 5);
		return fnd;
	}
	
	public static Long doIt() {
		long ans = 0;
		ArrayList<Long> f = find(new ArrayList<>(), 0);
		System.out.println(f);
		for (long i : f) ans += i;
		return ans;
	}
}

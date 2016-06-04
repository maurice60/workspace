package numbers.stat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;

public class Numbers {

    private static ArrayList<Long> primes;
    private static HashMap<Long, Long> hashPrimes;
    private static long primeSeed;
    private static boolean hasMap = true;

	public static boolean abundant(long x) {
        if (x < 1) return false;
        return x < sumDivisors(x);        
    }

	public static ArrayList<Long> allDivisors(long x) {return allDivisors(x, true);}

    public static ArrayList<Long> allDivisors(long x, boolean sorted) {
        ArrayList<Long> fact = findPrimeFactors(x);
        ArrayList<Long> ans = new ArrayList<>();
        ArrayList<Long> tmp = new ArrayList<>();
        long t;
        ans.add(1L);
        for (long f:fact) {
            tmp.clear();
            for (long a:ans) {
                t = f * a;
                if (!ans.contains(t) && t != x) tmp.add(t);
            }
            ans.addAll(tmp);
        }
        if (sorted) Collections.sort(ans);
        return ans;
    }
    
    public static boolean amicable(long x) {
        if (x < 1) return false;
        long t = sumDivisors(x);
        if (x == t) return false;
        return x == sumDivisors(t);
    }

    public static BigDecimal bigE(int p) {
		BigDecimal e = BigDecimal.ONE;
		BigDecimal fact = BigDecimal.ONE;

		for(int i=1;i<p;i++) {
			fact = fact.multiply(new BigDecimal(i));
			e = e.add(BigDecimal.ONE.divide(fact, new MathContext(10000, RoundingMode.HALF_UP)));
		}
		return e;
	}

    private static boolean checkPrime(long x) {
    /**
     * 
     * @param x
     * @return true if x is prime
     */
        double t;
        t = Math.sqrt(x);
        for (long j:primes) {
            if (x % j == 0) return false;
            if (j > t) return true;
        }
        return true;
    }

    public static long concatenate(long x, long y) {
    	return x * ((int) (Math.pow(10, (int) Math.log10(y) + 1))) + y;
    }

    public static ArrayList<Long> continuedFraction(BigDecimal d) {
    	return continuedFraction(d, d.scale(), 1000, true);
    }

    public static ArrayList<Long> continuedFraction(BigDecimal d, int size) {
    	return continuedFraction(d, d.scale(), size, false);
    }
    
    public static ArrayList<Long> continuedFraction(BigDecimal d, int s, int size, boolean at2X) {
		ArrayList<Long> out = new ArrayList<>();
		long i, i0 = d.longValue();
		while (out.size() < size) {
			i = d.longValue();
			out.add(i);
			if (at2X && i == 2*i0) break;
			if (d.subtract(BigDecimal.valueOf(i)).compareTo(BigDecimal.ZERO) == 0) break;
			d = BigDecimal.ONE.divide(d.subtract(BigDecimal.valueOf(i)), s, BigDecimal.ROUND_DOWN);		
		}
		return out;
	}
    
    public static boolean deficent(long x) {
        if (x < 1) return false;
        return x > sumDivisors(x);        
    }

    public static long factorial(long x) {
    	if (x <= 1) return 1;
    	else return x * factorial(x-1);
    }

    public static ArrayList<Long> findPrimeFactors(BigInteger x) {
        ArrayList<Long> ans = new ArrayList<>();
        BigInteger bigI;
        findPrimesLessThan(sqrt(x).longValue());
        for (long i:primes) {
            bigI =  new BigInteger(((Long) i).toString());
            while (x.remainder(bigI) == BigInteger.ZERO) {
                ans.add(i);
                x = x.divide(bigI);
            }
            if (x == BigInteger.ONE) break;
        }
        return ans;
    }
    
	public static ArrayList<Long> findPrimeFactors(long x) {
        ArrayList<Long> ans = new ArrayList<>();
        if (primeSeed < x / 2) findPrimesLessThan(x / 2);
        for (long i:primes) {
            while (x % i == 0) {
                ans.add(i);
                x /= i;
            }
            if (x == 1) break;
        }
        return ans;
    }

    public static HashMap<Long, Long> findPrimeFactors(long x, boolean map) {
        HashMap<Long, Long> ans = new HashMap<>(10);
        long n;
        if (!map) return ans;
        if (primeSeed < x / 2) findPrimesLessThan(x / 2);
        for (long i:primes) {
            n = 0;
            while (x % i == 0) {
                n += 1;
                x /= i;
            }
            if (n > 0) ans.put(i, n);
            if (x == 1) break;
        }
        return ans;
    }

    public static long findPrimes(int targ) {
        long x = primeSeed % 2 == 0 ? 1 : primeSeed;
        while (primes.size() < targ) {
            x += 2;
            if (checkPrime(x)) {
            	primes.add(x);
            	if (hasMap) hashPrimes.put(x, 0L);
            }
        }
        primeSeed = primes.get(primes.size() - 1);
        return x;
    }

    public static int findPrimesLessThan(long targ) {
        long x = primeSeed % 2 == 0 ? 1 : primeSeed;
        while (x < targ) {
            x += 2;
            if (checkPrime(x)) {
                primeSeed = x;
                primes.add(x);
                if (hasMap) hashPrimes.put(x, 0L);
            }
        }
        return primes.size();
    }

    public static ArrayList<Long> fullReptendPrimesList(long targ) {
        ArrayList <Long> ans = new ArrayList<>();
        long b = 10, r, t;
        findPrimesLessThan(targ);
        for (Long p : primes) {
            if (10 % p == 0) continue;
            if (p > targ) break;
            r = 1;
            t = 0;
            do {                
                t++;
                r = (r * b) % p;
            } while (r != 1);
            if (t == p - 1) ans.add(p);
        }
        return ans;
    }

    public static long hcf(long x, long y) {
    	long ans = 1;
//    	long targ = x > y ? x : y;
//    	findPrimesLessThan(targ);
		HashMap<Long, Long> fx = findPrimeFactors(x, true);
		HashMap<Long, Long> fy = findPrimeFactors(y, true);
		for (Iterator<Long> f = fx.keySet().iterator(); f.hasNext();) {
			long ft = f.next();
			if (fy.containsKey(ft)) {
				ans *= fx.get(ft) < fy.get(ft) ? Math.pow(ft, fx.get(ft)) : Math.pow(ft, fy.get(ft));
			}
		}
		return ans;
    }
    
    public static long heptagonalNumber(long n) {return n*(5*n-3)/2;}
    
    public static long hexagonalNumber(long n) {return n*(2*n-1);}

    public static boolean isHeptagonalNumber(long t) {
    	Double sqr = Math.sqrt(9 + 40*t);
    	if (Math.floor(sqr) == sqr && ((long) (3 + sqr) % 10 == 0)) return true;
    	else return false;
    }    

    public static boolean isHexagonalNumber(long t) {
    	Double sqr = Math.sqrt(1 + 8*t);
    	if (Math.floor(sqr) == sqr && ((long) (1 + sqr) % 4 == 0)) return true;
    	else return false;
    }

    public static boolean isOctagonalNumber(long t) {
    	Double sqr = Math.sqrt(4 + 12*t);
    	if (Math.floor(sqr) == sqr && ((long) (2 + sqr) % 6 == 0)) return true;
    	else return false;
    }
    
    public static boolean isPentagonalNumber(long t) {
    	Double sqr = Math.sqrt(1 + 24*t);
    	if (Math.floor(sqr) == sqr && ((long) (1 + sqr) % 6 == 0)) return true;
    	else return false;
    }
    public static boolean isPrime(long x) {
    	if (!hasMap) return checkPrime(x);
    	if (primeSeed < x + 1) findPrimesLessThan(x + 1);
    	return hashPrimes.containsKey(x);
    }
    
    
    public static boolean isSquareNumber(long t) {
    	Double sqr = Math.sqrt(t);
    	if (Math.floor(sqr) == sqr) return true;
    	else return false;
    }

    public static boolean isTriangleNumber(long t) {
    	Double sqr = Math.sqrt(1 + 8*t);
    	if (Math.floor(sqr) == sqr && ((long) (1 + sqr) % 2 == 0)) return true;
    	else return false;
    }

    public static ArrayList<Long> mersenne(long max) {
    	ArrayList<Long> ans = new ArrayList<>();
    	if (primeSeed < max + 1) findPrimesLessThan(max + 1);
    	for (long i = 1; i < max; i *= 2) {
    		if (isPrime(i-1)) ans.add(i - 1);
    	}
    	return ans;
    }

    public static long octagonalNumber(long n) {return n*(3*n-2);}

    public static long pentagonalNumber(long n) {return n*(3*n-1)/2;}
    
    public static ArrayList<Long> pentagonalNumberList(int n) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) ans.add(pentagonalNumber(i));
        return ans;
    }

    public static boolean perfect(long x) {
    	if (x < 1) return false;
    	return x == sumDivisors(x);        
    }
    
    public static int primeCount() {return primes.size();}

    public static long primeSeed() {return primeSeed;}

    public static HashMap<Long, Long> primesHash(int toFind) {
    	if (hasMap) return hashPrimes;
		HashMap<Long, Long> out = new HashMap<>();
		findPrimesLessThan(toFind);
		for (long p : primesList()) out.put(p, 0L);
		return out;
    }
    
    public static ArrayList<Long> primesList() {return primes;}

    public static ArrayList<Long> primesList(long targ) {
    	findPrimesLessThan(targ);
    	return primes;
    }
    
    public static BigDecimal sqrt(BigDecimal n, int s) {
		BigDecimal TWO = BigDecimal.valueOf(2);

//		BigDecimal x = BigDecimal.valueOf(Math.sqrt(n.doubleValue()));
		BigDecimal x = n.divide(BigDecimal.valueOf(2));
		BigDecimal lastX = x;

		for (int i = 0; i < 50; i++) {
			x = n.add(x.multiply(x)).divide(x.multiply(TWO), s, BigDecimal.ROUND_DOWN);
			if (x.compareTo(lastX) == 0)
				break;
			lastX = x;
		}
		return x;
	}
    
    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }
    
    public static long squareNumber(long n) {return n*n;}

    public static long sumDivisors(long x) {
        long t = 0;
        for (long i:allDivisors(x, false)) t += i;
        return t;
    }
    
    public static long triangleNumber(long n) {return n * (n+1) / 2;}
    
    public static ArrayList<Long> triangleNumberList(int n) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) ans.add(triangleNumber(i));
        return ans;
    }
  
	public Numbers() {
        primes = new ArrayList<>();
        hashPrimes = new HashMap<>();
        primes.add(2L);
        hashPrimes.put(2L, 0L);
        primeSeed = 2;
    }

	public Numbers(boolean map) {
        primes = new ArrayList<>();
        primes.add(2L);
        if (map) {
	        hashPrimes = new HashMap<>();
	        hashPrimes.put(2L, 0L);
        }
        primeSeed = 2; 
        hasMap = map;
    }
	
}

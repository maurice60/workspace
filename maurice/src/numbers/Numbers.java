package numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;

public class Numbers {

    private ArrayList<Long> primes;
    private HashMap<Long, Long> hashPrimes;
    private long primeSeed;
    private boolean hasMap = true;

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
    
    public boolean abundant(long x) {
        if (x < 1) return false;
        return x < sumDivisors(x);        
    }

    public ArrayList<Long> allDivisors(long x) {return allDivisors(x, true);}

    public ArrayList<Long> allDivisors(long x, boolean sorted) {
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

    public boolean amicable(long x) {
        if (x < 1) return false;
        long t = sumDivisors(x);
        if (x == t) return false;
        return x == sumDivisors(t);
    }

    private boolean checkPrime(long x) {
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
    
    public boolean isPrime(long x) {
    	if (!hasMap) return checkPrime(x);
    	if (primeSeed < x + 1) findPrimesLessThan(x + 1);
    	return hashPrimes.containsKey(x);
    }

    public boolean deficent(long x) {
        if (x < 1) return false;
        return x > sumDivisors(x);        
    }

    public long Factorial(long x) {
    	if (x <= 1) return 1;
    	else return x * Factorial(x-1);
    }
    
	public ArrayList<Long> findPrimeFactors(BigInteger x) {
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

    public ArrayList<Long> findPrimeFactors(long x) {
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

    public HashMap<Long, Long> findPrimeFactors(long x, boolean map) {
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

    public long findPrimes(int targ) {
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

    public int findPrimesLessThan(long targ) {
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

    public ArrayList<Long> fullReptendPrimesList(long targ) {
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
    
    public long hcf(long x, long y) {
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
    
    public boolean perfect(long x) {
        if (x < 1) return false;
        return x == sumDivisors(x);        
    }

    public int primeCount() {return primes.size();}    

    public long primeSeed() {return primeSeed;}

    public HashMap<Long, Long> primesHash(int toFind) {
    	if (hasMap) return hashPrimes;
		HashMap<Long, Long> out = new HashMap<>();
		findPrimesLessThan(toFind);
		for (long p : primesList()) out.put(p, 0L);
		return out;
    }
    
    public ArrayList<Long> primesList() {return primes;}
    public ArrayList<Long> primesList(long targ) {
    	findPrimesLessThan(targ);
    	return primes;
    }
    
    
    private BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }

    public long sumDivisors(long x) {
        long t = 0;
        for (long i:allDivisors(x, false)) t += i;
        return t;
    }

    public long triangleNumber(long n) {return n * (n+1) / 2;}

    public ArrayList<Long> triangleNumberList(int n) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) ans.add(triangleNumber(i));
        return ans;
    }

    public boolean isTriangleNumber(long t) {
    	Double sqr = Math.sqrt(1 + 8*t);
    	if (Math.floor(sqr) == sqr && ((long) (1 + sqr) % 2 == 0)) return true;
    	else return false;
    }
    
    public long squareNumber(long n) {return n*n;}

    public boolean isSquareNumber(long t) {
    	Double sqr = Math.sqrt(t);
    	if (Math.floor(sqr) == sqr) return true;
    	else return false;
    }
    
   public long pentagonalNumber(long n) {return n*(3*n-1)/2;}

    public ArrayList<Long> pentagonalNumberList(int n) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) ans.add(pentagonalNumber(i));
        return ans;
    }

    public boolean isPentagonalNumber(long t) {
    	Double sqr = Math.sqrt(1 + 24*t);
    	if (Math.floor(sqr) == sqr && ((long) (1 + sqr) % 6 == 0)) return true;
    	else return false;
    }
    
    public long hexagonalNumber(long n) {return n*(2*n-1);}

    public boolean isHexagonalNumber(long t) {
    	Double sqr = Math.sqrt(1 + 8*t);
    	if (Math.floor(sqr) == sqr && ((long) (1 + sqr) % 4 == 0)) return true;
    	else return false;
    }
    
    public long heptagonalNumber(long n) {return n*(5*n-3)/2;}
    
    public boolean isHeptagonalNumber(long t) {
    	Double sqr = Math.sqrt(9 + 40*t);
    	if (Math.floor(sqr) == sqr && ((long) (3 + sqr) % 10 == 0)) return true;
    	else return false;
    }
    
    public long octagonalNumber(long n) {return n*(3*n-2);}

    public boolean isOctagonalNumber(long t) {
    	Double sqr = Math.sqrt(4 + 12*t);
    	if (Math.floor(sqr) == sqr && ((long) (2 + sqr) % 6 == 0)) return true;
    	else return false;
    }
    
    public ArrayList<Long> mersenne(long max) {
    	ArrayList<Long> ans = new ArrayList<>();
    	if (primeSeed < max + 1) findPrimesLessThan(max + 1);
    	for (long i = 1; i < max; i *= 2) {
    		if (isPrime(i-1)) ans.add(i - 1);
    	}
    	return ans;
    }
    
    public long concatenate(long x, long y) {
    	return x * ((int) (Math.pow(10, (int) Math.log10(y) + 1))) + y;
    }
  
}

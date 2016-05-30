package numbers;

public class Rational implements Comparable<Rational> {
	private long num;
	private long den;
	private static final long MAXDEN = Long.MAX_VALUE;

	public Rational(long l, long m){
		this.num = l;
		this.den = m;
	}

	public Rational(double x) {
		long a = 0, b = 1, c = 1, d = 1;
		if (x < 1e-9) {
			this.num = a;
			this.den = b;
			return;
		}
		while (b <= MAXDEN && d <= MAXDEN) {
			double med = (double) (a+c)/(b+d);
			if (x == med) {
				if (b+d <= MAXDEN) 	{
					this.num = a+c;
					this.den = b+d;
					return;
				} else if (d > b){
					this.num = c;
					this.den = d;
					return;
				} else {
					this.num = a;
					this.den = b;
					return;
				}
			} else if (x > med) {
				a += c;
				b += d;
			} else {
				c += a;
				d += b;
			}
		}
		if (b > MAXDEN) {
			this.num = c;
			this.den = d;
			return;
		} else {
			this.num = a;
			this.den = b;
			return;
		}
	}
	
	public long getNum() {
		return num;
	}

	public long getDen() {
		return den;
	}

	@Override
	public String toString(){
		return num + " / " + den;
	}

	@Override
	public int compareTo(Rational o){
		return Double.compare((double)num / den, (double)this.num / this.den);
	}

}

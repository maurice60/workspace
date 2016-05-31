package numbers;

import java.util.ArrayList;

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

	public void setNum(long x) {
		this.num = x;
	}
	
	public long getDen() {
		return den;
	}

	public void setDen(long x) {
		this.den = x;
	}
	
	public void invert() {
		long temp = this.num;
		this.num = this.den;
		this.den = temp;
	}
	
	public static Rational toRational(ArrayList<Long> x) {
		Rational ans = new Rational(x.get(x.size() - 1), 1);
		for (int i = x.size() - 2; i >= 0; i--) {
			ans.invert();
			ans.setNum(ans.getDen() * x.get(i) + ans.getNum());
		}
		return ans;
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

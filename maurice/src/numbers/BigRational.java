package numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BigRational implements Comparable<BigRational> {
	private BigInteger num;
	private BigInteger den;

	public BigRational(long l, long m){
		this.num = BigInteger.valueOf(l);
		this.den = BigInteger.valueOf(m);
	}

	public BigInteger getNum() {
		return num;
	}

	public void setNum(long x) {
		this.num = BigInteger.valueOf(x);
	}
	
	public void setNum(BigInteger x) {
		this.num = x;
	}
	
	public BigInteger getDen() {
		return den;
	}

	public void setDen(long x) {
		this.den = BigInteger.valueOf(x);
	}
	
	public void setDen(BigInteger x) {
		this.den = x;
	}
	
	public void invert() {
		BigInteger temp = this.num;
		this.num = this.den;
		this.den = temp;
	}
	
	public static BigRational toRational(ArrayList<Long> x) {
		BigRational ans = new BigRational(x.get(x.size() - 1), 1);
		for (int i = x.size() - 2; i >= 0; i--) {
			ans.invert();
			ans.setNum(ans.getDen().multiply(BigInteger.valueOf(x.get(i))).add(ans.getNum()));
		}
		return ans;
	}

	@Override
	public String toString(){
		return num + " / " + den;
	}

	@Override
	public int compareTo(BigRational o) {
		BigDecimal on = new BigDecimal(o.num);
		BigDecimal od = new BigDecimal(o.den);
		BigDecimal tn = new BigDecimal(this.num);
		BigDecimal td = new BigDecimal(this.den);
		return on.divide(od, 100, RoundingMode.HALF_DOWN).compareTo(tn.divide(td, 100, RoundingMode.HALF_DOWN));
	}
	
}

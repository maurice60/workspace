/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author maurice
 */
public class pythagoreanTriple implements Comparable<pythagoreanTriple> {

	private int a, b, h, m, n;

    public pythagoreanTriple() {
        this(0, 0, 0);
    }

    public pythagoreanTriple(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
        this.m = (int) Math.sqrt((h+a)/2.0);
        this.n = (int) Math.sqrt((h-a)/2.0);
    }

    public pythagoreanTriple(int m, int n) {
        this.a = m*m-n*n;
        this.b = 2*m*n;
        this.h = m*m+n*n;
        this.m = m;
        this.n = n;
    }
    
    public void scale(int k) {
        this.a = a*k;
        this.b = b*k;
        this.h = h*k;	
        this.m = m*k;
        this.n = n*k;
	}
    
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public int getH() {
        return h;
    }
    public int getM() {
        return m;
    }
    public int getN() {
        return n;
    }

	public int sum() { return a+b+h; }
    public int product() { return a*b*h; }
    public boolean isValidTriple() { return h*h == a*a+b*b; }
    @Override
    public String toString() {return String.format("[%d, %d, %d]", a, b, h);}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + h;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pythagoreanTriple other = (pythagoreanTriple) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (h != other.h)
			return false;
		return true;
	}

	@Override
	public int compareTo(pythagoreanTriple o) {
		Integer t = this.getH();
		return t.compareTo(o.getH());
		
	}
}

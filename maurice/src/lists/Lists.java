/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author maurice
 */
public class Lists {
   
    public static ArrayList<Integer> permuteList(ArrayList<Integer> p) {

        int i = p.size() - 2;
        int j = 1;
        ArrayList<Integer> s, r;

        while (i >= 0) {
            if (p.get(i) < p.get(i+1)) break;
            i--;
        }
        if (i < 0) return p;
        r = new ArrayList<>(p.subList(0, i));
        s = new ArrayList<>(p.subList(i, p.size()));
        for (int k = 1; k < s.size(); k++) {
            if (s.get(k) < s.get(j) & p.get(i) < s.get(k)) {
                j = k;
            }
        }
        r.add(s.get(j));
        s.remove(j);
        Collections.sort(s);
        r.addAll(s);
        return r;
    }
    
    public static ArrayList<Long> permuteList(ArrayList<Long> p, boolean isLong) {

        int i = p.size() - 2;
        int j = 1;
        ArrayList<Long> s, r;

        while (i >= 0) {
            if (p.get(i) < p.get(i+1)) break;
            i--;
        }
        if (i < 0) return p;
        r = new ArrayList<>(p.subList(0, i));
        s = new ArrayList<>(p.subList(i, p.size()));
        for (int k = 1; k < s.size(); k++) {
            if (s.get(k) < s.get(j) & p.get(i) < s.get(k)) {
                j = k;
            }
        }
        r.add(s.get(j));
        s.remove(j);
        Collections.sort(s);
        r.addAll(s);
        return r;
    }
    
    public static int [] arrayMultiply(int [] x, int y) throws IllegalArgumentException {
        if (y > 9 | y < 0) throw new IllegalArgumentException("y not in range");
        int carry = 0, ans = 0;
        int [] mult = new int[x.length];        
        for (int j = 0; j < x.length; j++) {
            ans = x[j] * y + carry;
            mult[j] = ans % 10;
            carry = ans / 10;
        }
        return mult;
    }

    public static int [] arrayMultiply(int [] x, int y, int p) throws IllegalArgumentException {
        if (y > 9 | y < 0) throw new IllegalArgumentException("y not in range");
        if (p < 0) throw new IllegalArgumentException("p not in range");
        int carry = 0, ans = 0;
        int [] mult = new int[x.length];        
        for (int j = 0; j < x.length; j++) {
            ans = x[j] * y + carry;
            mult[j] = ans % 10;
            carry = ans / 10;
        }
        for (int i = 0; i < p; i++) {
        	for (int j = x.length - 1; j > 0; j--) mult[j] = mult[j-1];
        	mult[0] = 0;
        }
        return mult;
    }

    public static int [] arrayAdd(int [] x, int [] y) {
        int carry = 0, ans = 0;
        int wid = x.length > y.length ? x.length : y.length;
        int [] adder = new int[wid];
        for (int j = 0; j < x.length; j++) {
        	int a = j < x.length ? x[j] : 0;
        	int b = j < y.length ? y[j] : 0; 
            ans = a + b + carry;
            adder[j] = ans % 10;
            carry = ans / 10;
        }
        return adder;
    }
    
	public static int[] multiply(int m, int n) {
		int l = m < n ? m : n, h = m < n ? n : m;
		int siz = (int) Math.log10(h) + (int) Math.log10(l) + 1;
		int [] mul1 = new int[siz];
		int [] mul2 = new int[siz];
		int [] acc = new int[siz];	
		int idx = 0; 
		while (h > 0) {
			mul1[idx++] = h % 10;
			h /= 10;
		}
		idx = 0; 
		while (l > 0) {
			mul2[idx++] = l % 10;
			l /= 10;
		}
		for (int i = 0; i < mul2.length; i++) {
			if (mul2[i] > 0) acc = arrayAdd(acc, arrayMultiply(mul1, mul2[i], i));
		}
		return acc;
	}
	
	public static int[] power(int m, int n) {
		int siz = (int) (Math.log10(m) + 1) * n;
		int [] mul1 = new int[siz];
		int idx = 0; 
		while (m > 0) {
			mul1[idx++] = m % 10;
			m /= 10;
		}
		int [] mul2 = mul1.clone();
		for (int j = 1; j < n; j++) {
			int [] acc = new int[siz];
			for (int i = 0; i < mul2.length; i++) {
				if (mul2[i] > 0) acc = arrayAdd(acc, arrayMultiply(mul1, mul2[i], i));
			}
			mul1 = acc.clone();
		}
		return mul1;
	}

}

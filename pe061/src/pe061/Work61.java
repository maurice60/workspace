package pe061;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import numbers.Numbers;
import java.util.HashSet;
class Work61 {

	private static HashMap<Long, ArrayList<Long>> nums = new HashMap<>();
	private static HashSet<Long> circ = new HashSet<>();
	private static Numbers num = new Numbers();
	private static ArrayList<Long> ck = new ArrayList<>();
	
	private interface isType {
		boolean operation(long x);
	}
	private static isType triangular = (x) -> num.isTriangleNumber(x);
	private static isType square = (x) -> num.isSquareNumber(x);
	private static isType pentagonal = (x) -> num.isPentagonalNumber(x);
	private static isType hexagonal = (x) -> num.isHexagonalNumber(x);
	private static isType heptagonal = (x) -> num.isHeptagonalNumber(x);
	private static isType octagonal = (x) -> num.isOctagonalNumber(x);
	
	private static void addToNums(long x) {
		long h = x / 100, l = x % 100;
		if (!nums.containsKey(h)) nums.put(h, new ArrayList<>());
		if (!nums.get(h).contains(l)) nums.get(h).add(l);
		circ.add(l);
	}
	
	private static void getNumbers() {
		long i = 1, x;
		do {
			x = num.squareNumber(i);
			if (x > 1000 && x < 10000) addToNums(x);
			x = num.pentagonalNumber(i);
			if (x > 1000 && x < 10000) addToNums(x);
			x = num.hexagonalNumber(i);
			if (x > 1000 && x < 10000) addToNums(x);
			x = num.heptagonalNumber(i);
			if (x > 1000 && x < 10000) addToNums(x);
			x = num.octagonalNumber(i);
			if (x > 1000 && x < 10000) addToNums(x);
			x = num.triangleNumber(i++);
			if (x > 1000 && x < 10000) addToNums(x);
		} while (x < 10000);
	}
	
	private static boolean checkFn(long x, isType type) {
		return type.operation(x);
	}
	
	private static boolean checkEm() {
		boolean[] tr = new boolean[6];
		Arrays.fill(tr, false);
		for (long x : ck) {
			if (!tr[5]) if (tr[5] = checkFn(x, octagonal)) continue;
			if (!tr[4]) if (tr[4] = checkFn(x, heptagonal)) continue;
			if (!tr[3]) if (tr[3] = checkFn(x, hexagonal)) continue;
			if (!tr[2]) if (tr[2] = checkFn(x, pentagonal)) continue;
			if (!tr[1]) if (tr[1] = checkFn(x, square)) continue;
			if (!tr[0]) if (tr[0] = checkFn(x, triangular)) continue;
			return false;
		}
		return true;
	}
	
	public static long doIt() {
		long ans = 0;
		
		getNumbers();
		for (long h1 : nums.keySet()) {
			if (!circ.contains(h1)) continue;
			for (long l1 : nums.get(h1)) {
				ck.add(h1*100+l1);
				if (!nums.containsKey(l1)) break;
				for (long l2 : nums.get(l1)) {
					ck.add(l1*100+l2);
					if (!nums.containsKey(l2)) break;
					for (long l3 : nums.get(l2)) {
						ck.add(l2*100+l3);
						if (!nums.containsKey(l3)) break;
						for (long l4 : nums.get(l3)) {
							ck.add(l3*100+l4);
							if (!nums.containsKey(l4)) break;
							for (long l5 : nums.get(l4)) {
								ck.add(l4*100+l5);
								if (!nums.containsKey(l5)) break;
								for (long l6 : nums.get(l5)) {
									ck.add(l5*100+l6);
									if (l6 == h1 && checkEm()) {
										for (long x : ck) {
											ans += x;
										}
										System.out.println(getList());
										return ans;
									}
									if (ck.size() == 6) ck.remove(5);
								}
								if (ck.size() == 6) ck.remove(5);
								ck.remove(4);
							}
							if (ck.size() == 5) ck.remove(4);
							ck.remove(3);
						}
						if (ck.size() == 4) ck.remove(3);
						ck.remove(2);
					}
					if (ck.size() == 3) ck.remove(2);
					ck.remove(1);
				}
				if (ck.size() == 2) ck.remove(1);
				ck.remove(0);
			}
			if (ck.size() == 1) ck.remove(0);
		}
		return ans;
	}
	
	public static String getList() {
		return ck.toString();
	}
}

package pe039;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

import euler.pythagoreanTriple;;

public class PE039 extends PApplet {

	public void settings() {
		size(300, 200);
	}

	public void setup() {
		fill(0);
		text(Long.toString(pe039()), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe039.PE039.class.getName() });
	}
	
	/**
	 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
	 *
	 * {20,48,52}, {24,45,51}, {30,40,50}
	 *
	 * For which value of p ≤ 1000, is the number of solutions maximised?
	 *
	 * @return The answer
	 */
	private int pe039() {
		HashMap<Integer, ArrayList<Integer>> arr = new HashMap<>();
		int ans = 0, siz = 0;
		for (int m = 2; m <= 16; m++) {
			for (int n = 1; n < m; n++) {
				pythagoreanTriple pTriple = new pythagoreanTriple(m, n);
				for (int k = 1; k < 1000; k++) {
					int key = k*pTriple.sum();
					int hyp = k*pTriple.getH();
					if (key > 1000) break;
					if (!arr.containsKey(key)) arr.put(key, new ArrayList<>());
					if (!arr.get(key).contains(hyp)) arr.get(key).add(hyp);
				}
			}
		}
		for (int x : arr.keySet()) {
			if (arr.get(x).size() > siz) {
				ans = x;
				siz = arr.get(x).size();
			}
		}
		return ans;
	}
}

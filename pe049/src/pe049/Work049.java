package pe049;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import lists.Permutations;
import numbers.Numbers;

public class Work049 {
	
	private static HashMap<Long, Boolean> pHash = new HashMap<>();
	
	public static String doIt() {
		ArrayList<Long> pri = getPrimes();
		ArrayList<String> ans = new ArrayList<>();
		for (Long p : pri) {
			if (pHash.get(p)) continue;
			ArrayList<String> perm = Permutations.permutation(p.toString());
			ArrayList<Long> pExt = new ArrayList<>();
			Collections.sort(perm);
			long last = 0;
			for (String s : perm) {
				long e = Long.parseLong(s);
				if (e == last) continue;
				last = e;
				if (e < 1000) continue;
				if (pHash.containsKey(e)) {
					pHash.put(e, true);
					pExt.add(e);
				}
			}
			int siz = pExt.size();
			if (siz < 3) continue;
			for (int i = 0; i < siz - 2; i++) {
				Long a = pExt.get(i);
				for (int j = i + 1; j < siz - 1; j++) {
					Long b = pExt.get(j);
					Long k = 2*b - a;
					if (pExt.contains(k)) {
						ans.add(a.toString()+b.toString()+k.toString());
					}
				}
			}
		}
		return ans.size() > 1 ? ans.get(1) : "Not Found";
	}

	private static ArrayList<Long> getPrimes() {
		Numbers num = new Numbers(false);
		num.findPrimesLessThan(10000);
		ArrayList<Long> ret = new ArrayList<>();
		for (long p : num.primesList()) {
			if (p < 1000) continue;
			ret.add(p);
			pHash.put(p, false);
		}
		return ret;
	}
}

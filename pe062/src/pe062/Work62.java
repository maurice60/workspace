package pe062;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Work62 {
	
	private static ArrayList<Integer> findList(int x) {
		BigInteger i = BigInteger.valueOf(x).pow(3);
		ArrayList<Integer> outp = new ArrayList<>();
		while (i.compareTo(BigInteger.ZERO) > 0) {
			outp.add(i.mod(BigInteger.TEN).intValue());
			i = i.divide(BigInteger.TEN);
		}
		Collections.sort(outp);
		return(outp);
	}

	public static String doIt() {
		HashMap<ArrayList<Integer>, ArrayList<Integer>> sol = new HashMap<>();
		ArrayList<Integer> cubLis;
		for (int i = 2; i < 10000; i++) {
			cubLis = findList(i);
			if (!sol.containsKey(cubLis)) sol.put(cubLis, new ArrayList<>());
			sol.get(cubLis).add(i);
			if (sol.get(cubLis).size() == 5) {
				System.out.println(sol.get(cubLis));
				return BigInteger.valueOf(sol.get(cubLis).get(0)).pow(3).toString();
			}
		}
		return "None";
	}
}

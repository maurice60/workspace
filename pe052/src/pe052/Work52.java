package pe052;

import java.util.ArrayList;

import lists.Permutations;

class Work52 {

	public static long doIt() {
		long [] muls = {2,3,4,5,6}; 
		boolean found = false;
		for (Long i = 125875L; i < Long.MAX_VALUE; i++) {
			ArrayList<String> perm = Permutations.permutation(i.toString());
			found = true;
			for (long mul : muls) {
				Long tim = i * mul;
				if (!perm.contains(tim.toString())) {
					found = false;
					break;
				}
			}
			if (found) {
				System.out.println(i+" "+2*i+" "+3*i+" "+4*i+" "+5*i+" "+6*i);
				return i;
			}
		}
		return 0;
	}
}

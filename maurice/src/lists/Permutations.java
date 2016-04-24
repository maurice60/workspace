package lists;

import java.util.ArrayList;

public class Permutations {
	
	private static ArrayList<String> ans = new ArrayList<>();
	
	public static ArrayList<String> permutation(String str) { 
		ans.clear();
		permutation("", str); 
		return ans;
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) ans.add(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		}
	}
}

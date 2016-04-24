package pe059;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import files.Files;

class Work59 {
	private static HashMap<String, Integer> words = new HashMap<>();
	
	public static long doIt() {

		final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char [] srt = getEnc();
		char [] keys = new char[3], fkey = new char[3];
		int z = 0, zm = 0;

		getWords();
		for (char a : alphabet) {
			keys[0] = a;
			for (char b : alphabet) {
				keys[1] = b;
				for (char c : alphabet) {
					keys[2] = c;
					z = score(getDec(keys, srt));
					if (z > zm) {
						zm = z;
						fkey = keys.clone();
					}
				}				
			}			
		}
		System.out.println(getDec(fkey, srt));
		System.out.println(zm);
		return addUp(fkey, srt);
	}
	
	private static char[] getEnc() {
		char [] c;
		Files f = new Files();
		try {
			c = f.loadCharArray("p059_cipher.txt");
		} catch (FileNotFoundException e) {
			c = new char[0];
			e.printStackTrace();
		} catch (IOException e) {
			c = new char[0];
			e.printStackTrace();
		}
		return c;
	}
	
	private static String getDec(char [] k, char [] cs) {
		StringBuilder out = new StringBuilder();		
		int key = 0;
		for (char c : cs) {
			out.append((char) (c ^ k[key]));
			key = key == 2 ? 0 : key + 1;
		}
		return out.toString();
	}

	private static void getWords() {
		Files f = new Files();
		try {
			words = f.loadHash("20k.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int score(String para) {
		String [] wrds = para.toLowerCase().split("[ ,.;:\\(\\)]");
		int ans = 0;
		for (String wrd : wrds) {
			if (words.containsKey(wrd)) ans += 1;
		}
		return ans;
	}

	private static long addUp(char [] k, char [] cs) {
		int key = 0;
		long ans = 0;
		for (char c : cs) {
			ans += (c ^ k[key]);
			key = key == 2 ? 0 : key + 1;
		}
		return ans;
	}

}

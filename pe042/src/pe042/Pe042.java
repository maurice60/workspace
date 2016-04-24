package pe042;

import processing.core.PApplet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import files.Files;
import numbers.Numbers;

public class Pe042 extends PApplet {

	private static boolean runIt = true;
	private static long theAnswer = 0L;
	
	public void settings() {
		size(705, 200);
	}

	public void setup() {
		fill(0);
		text("The nᵗʰ term of the sequence of triangle numbers is given by, t(n) = ½n(n+1); so the first ten triangle numbers are:", 25, 30);
		text("1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...", 25, 45);
		text("By converting each letter in a word to a number corresponding to its alphabetical position and", 25, 60);
		text("adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.", 25, 75);
		text(" If the word value is a triangle number then we shall call the word a triangle word.", 25, 90);
		text("Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand", 25, 105);
		text("common English words, how many are triangle words?", 25, 120);
	}

	public void draw() {
		if (runIt) {
			theAnswer = doIt();
			runIt = false;
		}
		text(Long.toString(theAnswer), 300, 140);		
	}

	public static void main(String _args[]) {
		PApplet.main(new String[] { pe042.Pe042.class.getName() });
	}
	
	private long doIt() {
		ArrayList<String> wrds = loadFile();
		Numbers num = new Numbers();
		long ans = 0;
		for (String wrd : wrds) {
			if (num.isTriangleNumber(decode(wrd))) ans++;
		}
		return ans;
	}
	
	private long decode(String x) {
		long ret = 0;
		for (char c : x.toCharArray()) {
			ret += c - 'A' + 1;
		}
		return ret;
	}
	
	private ArrayList<String> loadFile() {
		Files fil = new Files();
		try {
			return fil.loadArray("p042_words.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}
	
}

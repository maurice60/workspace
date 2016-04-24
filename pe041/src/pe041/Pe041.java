package pe041;

import processing.core.PApplet;
import numbers.Numbers;
import lists.Permutations;
import java.util.ArrayList;
import java.util.Collections;

public class Pe041 extends PApplet {

	private static boolean runIt = true;
	private static long theAnswer = 0L;
	
	public void settings() {
		size(700, 200);
	}

	public void setup() {
		fill(0);
		text("We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.", 25, 30);
		text("For example, 2143 is a 4-digit pandigital and is also prime.", 25, 45);
		text("What is the largest n-digit pandigital prime that exists?", 25, 65);
	}

	public void draw() {
		if (runIt) {
			theAnswer = doIt();
			runIt = false;
		}
		text(Long.toString(theAnswer), 300, 100);		
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe041.Pe041.class.getName() });
	}
	
	
	private long doIt() {
		Numbers num = new Numbers(false);
		num.findPrimesLessThan((int) Math.sqrt(99999999) + 1);
		Long pan = 123456789L;
		while (pan > 0) {
			System.out.println(pan.toString().length());
			ArrayList<String> perm = Permutations.permutation(pan.toString());
			Collections.sort(perm);
			Collections.reverse(perm);
			for (String s : perm) {
				long ths = Long.parseLong(s);
				if (num.isPrime(ths))
					return ths;
			}
			pan /= 10;
		}
		return 0L;
	}

}

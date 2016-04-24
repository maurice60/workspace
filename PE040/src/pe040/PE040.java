package pe040;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;


public class PE040 extends PApplet {

	public void settings() {
		size(300, 200);
	}

	public void setup() {
		fill(0);
		text(Long.toString(pe040()), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe040.PE040.class.getName() });
	}
	
	/**
	 * 
	 * <p>An irrational decimal fraction is created by concatenating the positive integers:<br>
	 * <br>
	 * 0.12345678910<span style="color:red">1</span>112131415161718192021...<br>
	 * <br>
	 * It can be seen that the 12<sup>th</sup> digit of the fractional part is 1.<br>
	 * <br>
	 * If d<sub>n</sub> represents the n<sup>th</sup> digit of the fractional part, find the value of the following expression.<br>
	 * <br>
	 * d<sub>1</sub> * d<sub>10</sub> * d<sub>100</sub> * d<sub>1000</sub> * d<sub>10000</sub> * d<sub>100000</sub> * d<sub>1000000</sub><br></p>
	 * 
	 * @return The answer
	 */
	private long pe040() {
		
		ArrayList<Long> toFind = new ArrayList<>(Arrays.asList(1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L));
		long ans = 1, x = 0, f = toFind.remove(0);
		
		for (long i = 1; ; i++) {
			x += (long) Math.log10(i) + 1;
			if (x >= f) {
				ans *= ((long) ((double) i / Math.pow(10, x-f))) % 10;
				if (toFind.size() > 0) f = toFind.remove(0);
				else break;
			}
		}
		return ans;
	}
}

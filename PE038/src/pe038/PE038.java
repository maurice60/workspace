package pe038;

import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;
import lists.Permutations;;

public class PE038 extends PApplet {

	public void settings() {
		size(300, 200);
	}

	public void setup() {
		fill(0);
		text(pe038(), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe038.PE038.class.getName() });
	}
	
	/**
	 * <p>Take the number 192 and multiply it by each of 1, 2, and 3:<br>
	 * <br>
	 *    192 × 1 = 192<br>
	 *    192 × 2 = 384<br>
	 *    192 × 3 = 576<br>
	 * <br>
	 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)<br>
	 * <br>
	 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).<br>
	 * <br>
	 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?<br></p>
	 * 
	 * @return
	 */
	private String pe038() {
		ArrayList<String> toDo = Permutations.permutation("123456789");
		Collections.sort(toDo);
		Collections.reverse(toDo);
		for (String s : toDo) {
			for (int i = 1; i < s.length() / 2 + 1; i++) {
				int v = Integer.parseInt(s.substring(0, i));
				StringBuilder b = new StringBuilder();
				int mul = 1; 
				do {
					b.append(Integer.toString(v * mul++));
					if (!s.startsWith(b.toString())) break;
				} while (b.length() < 9);
				if (s.equals(b.toString())) {
					System.out.println(v);
					return s;
				}
			}
		}
		return "Not found";
	}
}

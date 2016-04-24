package pe033;

import numbers.Numbers;

public class PE033 {



/**
 * <p>
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * </p><p>
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * </p><p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
 * </p><p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 * </p>
 * @param args The command line arguments
 * 
 */
	public static void main(String[] args) {
		long div, num, den, tnum = 1, tden = 1, factr;
		Numbers nums = new Numbers();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (j == k) continue;
					div = j * 1000000 / k;
		            num = 10*i+j;
		            den = 10*k+i;
		            if (num < den) {
						if (num * 1000000 / den == div) { //System.out.println(i+" "+j+" "+k);
							tnum *= num;
							tden *= den;
							factr = nums.hcf(tnum, tden);
							tnum /= factr;
							tden /= factr;
						}
		            }
		            num = 10*j+i;
		            den = 10*i+k;
		            if (num < den) {
						if (num * 1000000 / den == div) { //System.out.println(i+" "+j+" "+k);
							tnum *= num;
							tden *= den;
							factr = nums.hcf(tnum, tden);
							tnum /= factr;
							tden /= factr;
						}
		            }
				}
			}
		}
		System.out.println(tden);
	}
}

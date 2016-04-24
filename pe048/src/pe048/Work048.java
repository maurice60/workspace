package pe048;

//import lists.Lists;
import java.math.BigInteger;
public class Work048 {
	
//	public static String doIt() {
//		StringBuilder sb = new StringBuilder();
//		int [] acc = Lists.power(1000,1000);	
//		for (int i = 999; i > 0; i--) {
//			acc = Lists.arrayAdd(acc, Lists.power(i, i));
//		}
//		int ix = 0;
//		for (Integer i : acc) {
//			sb.insert(0, i);
//			if (++ix > 9) break;
//		}
//		return sb.toString();
//	}	
	
	public static String doIt() {
		BigInteger big = BigInteger.ZERO;
		for (Integer i = 1; i <= 1000; i++) big = big.add(new BigInteger(i.toString()).pow(i));
		return big.mod(new BigInteger("10000000000")).toString();
	}	
}

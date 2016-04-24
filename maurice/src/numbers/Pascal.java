package numbers;

import java.util.ArrayList;
import java.math.BigInteger;

public class Pascal {
	
	public static ArrayList<Long> nextRow(ArrayList<Long> row) {
		ArrayList<Long> ret = new ArrayList<>();
		ret.add(1L);
		for (int r = 0; r < row.size() - 1; r++) {
			ret.add(row.get(r) + row.get(r+1));
		}
		ret.add(1L);
		return ret;
	}
	
	public static ArrayList<BigInteger> nextBigRow(ArrayList<BigInteger> row) {
		ArrayList<BigInteger> ret = new ArrayList<>();
		ret.add(BigInteger.ONE);
		for (int r = 0; r < row.size() - 1; r++) {
			ret.add(row.get(r).add(row.get(r+1)));
		}
		ret.add(BigInteger.ONE);
		return ret;
	}

}

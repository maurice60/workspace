package pe067;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Work67 {
	
    private static HashMap<Address, Node> tri = new HashMap<>();
    private static int nRows;
    
    private static void loadData() throws FileNotFoundException, IOException {
        String file = "p067_triangle.txt";
        String[] dat;
        int i = 0, j;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	for (String line; (line = br.readLine()) != null; i++) {
        		dat = line.split(" ");
        		j = 0;
        		for (String s : dat) {
        			tri.put(new Address(i, j++), new Node(Long.parseLong(s)));
        		}
        	}
        	nRows = i - 1;
        }
	}

	public static long doIt() {
		try {
			loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= nRows; i++) {
			Address a = new Address(nRows, i);
			Node n = tri.get(a);
			n.setMaxSum(n.getValue());
		}
		for (int i = nRows - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j ++) {
				Node tn = tri.get(new Address(i, j));
				long ln = tri.get(new Address(i + 1, j)).getMaxSum();
				long hn = tri.get(new Address(i + 1, j + 1)).getMaxSum();
				tn.setMaxSum(tn.getValue() + ((hn > ln) ? hn : ln));
			}
		}
		return tri.get(new Address(0, 0)).getMaxSum();
	}
}

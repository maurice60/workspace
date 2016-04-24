package files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Files {

    public int[][] loadGrid(String file, int n, int m) throws IOException {
        int[][] grid = new int[n][m];

        String[] dat;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            dat = br.readLine().split(", ");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(dat[i * n + j]);
            }
        }
        return grid;
    }
    
    public ArrayList<String> loadArray(String file) throws FileNotFoundException, IOException {
        ArrayList<String> outp = new ArrayList<>();
        
        String[] dat;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            dat = br.readLine().split(",");
        }
        for (String s : dat) {
            outp.add(s.replace("\"", ""));
        }
        return outp;
    }
    
    public char[] loadCharArray(String file) throws FileNotFoundException, IOException {
    	ArrayList<String> a = loadArray(file);
		char[] outp = new char[a.size()];
		int i = 0;
		for (String s : a) {
			outp[i++] = (char) Integer.parseInt(s);
		}
		return outp;
	}
    
    public HashMap<String, Integer> loadHash(String file) throws FileNotFoundException, IOException {
        HashMap<String, Integer> outp = new HashMap<>();
        
//      String[] dat;
        String dat;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//          dat = br.readLine().split("\n");
        	dat = br.readLine();
        	while (dat != null) {
        		outp.put(dat, 0);
            	dat = br.readLine();
        	}
        }
        return outp;
    }
}

package pe054;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Work54 {
	
	public static long doIt() {
		long ans = 0;
		ArrayList<String> data = getData();
		for (String d : data) {
			String[] ds = d.split(" ");
			Hand hand1 = formHand(ds, 0, 5);
			Hand hand2 = formHand(ds, 5, 10);
			if (hand1.compareTo(hand2) > 0) ans += 1;
		}
		return ans;
	}
	
	private static Hand formHand(String [] pack, int low, int hi) {
		ArrayList<Card> cards = new ArrayList<>();;
		for (int i = low; i < hi; i++) {
			char[] x = pack[i].toCharArray();
			cards.add(new Card(x[0], x[1]));
		}
		return new Hand(cards);
	}
	
	private static ArrayList<String> getData() {
        ArrayList<String> outp = new ArrayList<>(); 
        String dat;
        try { 
        	BufferedReader br = new BufferedReader(new FileReader("p054_poker.txt"));
        	dat = br.readLine();
        	while (dat != null) {
        		outp.add(dat);
            	dat = br.readLine();
        	}
        	br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return outp;
	}
}


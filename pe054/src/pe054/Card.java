package pe054;

public class Card implements Comparable<Card>{

	private char rank;
	private char suit;
	private static final char [] RANKS = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
	private int value;
	
	public Card(char rank, char suit) {
		this.rank = Character.toUpperCase(rank);
		this.suit = Character.toUpperCase(suit);
		value = cardValue(this.rank);
	}
	
	public static int cardValue(Character  rank) {
		for (int r = 0; r < RANKS.length; r++) {
			if (rank.equals(RANKS[r])) {
				return r;
			}
		}	
		return 0;
	}
	
	public int getValue() {
		return value;
	}

	public char getRank() {
		return rank;
	}

	public char getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card o) {
		Character tr = this.getRank();
		Character or = o.getRank();
		if (tr.equals(o.rank)) return 0;
		for (char r : RANKS) {
			if (tr.equals(r)) return -1;
			if (or.equals(r)) return 1;
		}
		return 0;
	}
}

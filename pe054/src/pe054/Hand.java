package pe054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hand implements Comparable<Hand> {

	private ArrayList<Card> cards;
	private HashMap<Character, Integer> ranks;
	private boolean flush;
	private boolean straight;
	private int max = 0;
	private ArrayList<Integer> maxVal;
	
	public Hand(ArrayList<Card> cards) {
		flush = true;
		this.cards = cards;
		Collections.sort(this.cards);
		ranks = new HashMap<>();
		char suit = this.cards.get(0).getSuit();
		int last = this.cards.get(0).getValue() + 1;
		for (Card card : this.cards) {
			if (ranks.containsKey(card.getRank())) 
				ranks.put(card.getRank(), ranks.get(card.getRank()) + 1);
			else
				ranks.put(card.getRank(), 1);
			if (card.getSuit() != suit) flush = false;
			if (--last != card.getValue()) straight = false;
		}
		for (char s : ranks.keySet()) {
			if (ranks.get(s) > max) max = ranks.get(s);
		}
		maxVal = new ArrayList<>();
		for (char s : ranks.keySet()) {
			if (ranks.get(s) == max) maxVal.add(Card.cardValue(s));
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public int getnCards() {
		return cards.size();
	}
	
	public int getMax() {
		return max;
	}

	public ArrayList<Integer> getMaxVal() {
		return maxVal;
	}

	public int score() {
		int score = 1;
		if (flush && straight) return cards.get(5).getRank() == 'T' ? 10 : 9;
		if (max == 4) return 8;
		if (max == 3) return ranks.size() == 2 ? 7 : 4;
		if (flush) return 6;
		if (straight) return 5;
		if (max == 2) return maxVal.size() == 2 ? 3 : 2;
		return score;
	}

	@Override
	public int compareTo(Hand o) {
		int a = this.score();
		int b = o.score();
		if (a != b) return a > b ? 1 : -1;
		for (int t = 0; t < maxVal.size(); t++) {
			if (maxVal.get(t) != (o.getMaxVal()).get(t)) return maxVal.get(t) > (o.getMaxVal()).get(t) ? 1 : -1;
		}
		return 0;
	}

}

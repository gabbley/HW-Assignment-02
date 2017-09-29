/*	<p>
 * Card class description
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Card implements Comparable<Card> {

	// push

	private String suit;
	private int rank;

	public Card() {
		suit = "Spades";
		rank = 0;
	}

	public Card(int suit, int rank) {
		this.suit = getSuitStr(suit);
		this.rank = rank;
	}

	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = getRankInt(rank);
	}

	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Card(int suit, String rank) {
		this.suit = getSuitStr(suit);
		this.rank = getRankInt(rank);
	}

	public String getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public String toString(Card c) {
		return c.getRankStr(c.getRank()) + c.getSuit();
	}

	public String getRankStr(int rank) {
		switch (rank) {
		case 1:
			return "ACE";
		case 2:
			return "TWO";
		case 3:
			return "THREE";
		case 4:
			return "FOUR";
		case 5:
			return "FIVE";
		case 6:
			return "SIX";
		case 7:
			return "SEVEN";
		case 8:
			return "EIGHT";
		case 9:
			return "NINE";
		case 10:
			return "TEN";
		case 11:
			return "JACK";
		case 12:
			return "QUEEN";
		case 13:
			return "KING";
		default:
			return "NULL";
		}
	}

	public int getRankInt(String rank) {
		switch (rank) {
		case "ACE":
			return 1;
		case "TWO":
			return 2;
		case "THREE":
			return 3;
		case "FOUR":
			return 4;
		case "FIVE":
			return 5;
		case "SIX":
			return 6;
		case "SEVEN":
			return 7;
		case "EIGHT":
			return 8;
		case "NINE":
			return 9;
		case "TEN":
			return 10;
		case "JACK":
			return 11;
		case "QUEEN":
			return 12;
		case "KING":
			return 13;
		default:
			return -1;
		}
	}

	public int getSuitInt(String suit) {
		switch (suit) {
		case "CLUBS":
			return 0;
		case "DIAMONDS":
			return 1;
		case "HEARTS":
			return 2;
		case "SPADES":
			return 3;
		default:
			return -1;
		}
	}

	public String getSuitStr(int suit) {
		switch (suit) {
		case 0:
			return "CLUBS";
		case 1:
			return "DIAMONDS";
		case 2:
			return "HEARTS";
		case 3:
			return "SPADES";
		default:
			return "NULL";
		}
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

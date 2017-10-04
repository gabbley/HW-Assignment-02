/*	<p>
 * The Card class creates cards with suits and ranks.
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Card implements Comparable<Card> {

	private String suit;
	private int rank;

	public Card() {
		suit = "SPADES";
		rank = 1;
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

	/**
	 * Prints out readable card (rank and suit)
	 * 
	 * @return Card as a String
	 */
	public String toString() {
		return getRankStr(this.rank) + " of " + this.suit;
	}

	/**
	 * Converts the int form of rank to a String
	 * 
	 * @param rank
	 *            as an int
	 * @return rank as a String
	 */
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

	/**
	 * Converts the String form of rank to an int
	 * 
	 * @param rank
	 *            as a String
	 * @return rank as an int
	 */
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

	/**
	 * Converts the String form of rank to an int
	 * 
	 * @param suit
	 *            as a String
	 * @return suit as an int
	 */
	public int getSuitInt() {
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

	/**
	 * Converts the int form of suit to a String
	 * 
	 * @param suit
	 *            as an int
	 * @return suit as a String
	 */
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
	public int compareTo(Card other) { //TODO check this, connect to other methods?
		if (suit.equals(other.getSuit())){
			if(rank == other.getRank()){
				return 0;
			}
			else{
				return (rank - other.getRank());
			}
		}
		else{
			return suit.compareTo(other.getSuit()) * 13;
		}
		
	}

	public boolean equals(Card other) {
		return (suit.equals(other.getSuit()) && rank == other.getRank());
	}

}

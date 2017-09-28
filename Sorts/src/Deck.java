/*	<p>
 * Deck class description
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Deck {
	
	private Card[] deck;
	private int topCard;
	
	public Deck() {
		this.deck = deck;
		this.topCard = topCard;
	}
	
	public Deck(boolean isSorted) {
		this.deck = deck;
		this.topCard = topCard;
	}
	
	public static void shuffle() {
		//TODO replaces existing deck field with new unsorted deck (same length)
	}
	
	public static String toString(Card[] c) {
		/*TODO disp cards in four columns, separated by a tab
		 * if sorted, each suit shoudl print in its own column
		 * ranks should be printed as words (Ace of Spades), use switch*/
		return "";
	}
	
	public static Deck[] deal(int hands, int cardsPerHand) {
		//TODO if statement, returns null if not enough cards in deck to fill all hands
	
		Deck[] d = new Deck[hands];
		return d;
	}
	
}

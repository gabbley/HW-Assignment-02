/*	<p>
 * Deck class description
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Deck {

	private final static int FULLDECK = 52;
	private static Card[] deck;
	private static int topCard; //cardsInDeck or topIndex or cardLength
	private static boolean isSorted;
	private static int deckSize;

	public Deck() {
		deck = new Card[FULLDECK];
		fillDeck();
		topCard = 1;
		isSorted = true;
		deckSize = deck.length;
	}

	public Deck(boolean isSorted) {
		deck = new Card[FULLDECK];
		fillDeck();
		this.isSorted = isSorted;
		deckSize = deck.length;
	}

	public static void shuffle() { // based on old Deck.java class from 2015-6
		
		Card[] shuffDeck = deck;

		for (int k = shuffDeck.length - 1; k > 0; k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = shuffDeck[k];
			shuffDeck[k] = shuffDeck[randPos];
			shuffDeck[randPos] = temp;
		}
		
		deck = shuffDeck;

	}

	public String toString() {
		/*
		 * TODO disp cards in four columns if complete deck (52), separated by a
		 * tab if sorted, each suit shoudl print in its own column ranks should
		 * be printed as words (Ace of Spades), use switch
		 */
		String deckStr = "";
		for (int i = 0; i < deck.length; i++) {
			deckStr += deck[i] + "\n";

		}

		return deckStr;

	}

	public static boolean equals(Deck other) {
		boolean result = false;
		
		for (int i = 0; i<other.deck.length; i++) {
			result = (deck[i].equals(other.deck[i]));
		}
		
		return result;
	}
	
	public static Card[] getDeck() {
		return deck;
	}

	public static Deck[] deal(int hands, int cardsPerHand) {
		// TODO if statement, returns null if not enough cards in deck to fill
		// all hands

		Deck[] d = new Deck[hands];
		return d;
	}

	public static Card pick() {
		int randPos = (int) (Math.random() * FULLDECK);
		 (int i = randPos; i<deckSize; i++){
			int tempIndex = 0; //TODO shift manually lol
		}
		return deck[randPos];
	}

	public static void selectionSort() {
		// TODO add selectionSort algorithm
	}

	public static void mergeSort() {
		// TODO add mergeSort algorithm
	}

	public static void fillDeck() {

			for (int i = 0; i < FULLDECK;) {
				for (int suit = 0; suit < 4; suit++) {
					for (int rank = 1; rank <= 13; rank++) {
						deck[i] = new Card(suit, rank);
						i++;
					}
			}
		}
	}
}

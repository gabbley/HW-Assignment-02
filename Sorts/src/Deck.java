/*	<p>
 * The Deck class consists mainly of a Card array.<br>
 * This Card array is a deck that can be sorted or shuffled and 
 * does not have to be complete (meaning, containing 52 cards).
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Deck {

	private final static int FULLDECK = 52; // number of a full deck
	private final static int EACHRANK = 13; // number of ranks (in compl. deck)
	private static Card[] deck; // deck as a Card array
	private static int topCard; // keeps track of last index of deck
	private static boolean sorted; // if deck is sorted or shuffled
	private static int deckSize; //gets current deckSize

	public Deck() {
		deck = new Card[FULLDECK];
		fillDeck();
		topCard = 1;
		sorted = true;
		deckSize = deck.length;
	}

	public Deck(boolean isSorted) {
		deck = new Card[FULLDECK];
		fillDeck();
		this.sorted = sorted;
		deckSize = deck.length;
	}

	public static Card[] getDeck() {
		return deck;
	}

	public static boolean isSorted() {
		return sorted;
	}

	public static int getTopCard() {
		return topCard;
	}

	/**
	 * Replaces current deck with newly unshuffled deck.
	 */
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
	
	/**
	 * Overrides toString method to print deck.
	 *
	 * @return String of entire deck
	 * 		If deck is complete, will print out in 4 columns by suit, ordered by rank
	 */
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


	public static Deck[] deal(int hands, int cardsPerHand) {
		// TODO if statement, returns null if not enough cards in deck to fill
		// all hands

		Deck[] d = new Deck[hands];
		return d;
	}

	/**
	 * Randomly picks Card out of array, collapses
	 *
	 * @return random Card from deck
	 */
	public static Card pick() {
		 	int randPos = (int) (Math.random() * FULLDECK);
		 		 for (int i = randPos; i<deckSize; i++){
		 			int tempIndex = 0; //TODO shift manually lol
		 		}
		 		return deck[randPos];
	}

	/**
	 * Sorts deck by suit and rank using Selection Sort Algorithm
	 */
	public static void selectionSort(Card[] c) {
		// TODO add selectionSort algorithm
		// int n = c.length;
		// while (n>1){
		// int maxPos = 0;
		// for (int i = 1; i<n; i++){
		// int suitInt = c[i].getSuitInt(c[i].getSuit());
		// for (int suit = 0; suit < 4; suit++){
		// if (suitInt > c[maxPos].getSuitInt(c[maxPos].getSuit())){
		// maxPos = i;
		// }
		// Card temp = c[maxPos];
		// }
		// }
		// }
	}

	/**
	 * Sorts deck by suit and rank using Selection Sort Algorithm
	 */
	public static void mergeSort() {
		// TODO add mergeSort algorithm
	}

	/**
	 * Fills a perfect deck, sorted by suit and rank
	 */
	public static void fillDeck() {

		for (int i = 0; i < FULLDECK;) {
			for (int suit = 0; suit < 4; suit++) {
				for (int rank = 1; rank <= EACHRANK; rank++) {
					deck[i] = new Card(suit, rank);
					i++;
				}

			}
		}
	}
}

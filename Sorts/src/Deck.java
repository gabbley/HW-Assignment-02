import java.util.ArrayList;

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
	private static int deckSize; // gets current deckSize

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
		this.sorted = isSorted;
		deckSize = deck.length;
	}

	public Card[] getDeck() {
		return deck;
	}

	public static boolean isSorted() {
		return sorted;
	}

	public static int getTopCard() {
		return topCard;
	}
	
	public void setDeck(Card[] c){
		deck = c;
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
	 * @return String of entire deck If deck is complete, will print out in 4
	 *         columns by suit, ordered by rank
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

	/**
	 * Utilizes equals method of Card class to compare each element.
	 *
	 * @return true if Decks are identical, false otherwise.
	 */
	public static boolean equals(Deck other) {
		boolean result = false;

		for (int i = 0; i < other.deck.length; i++) {
			result = (deck[i].equals(other.deck[i]));
		}

		return result;
	}

	public static Deck[] deal(int hands, int cardsPerHand) {
		// TODO ask about this
		
		Card[] startingDeck = deck;
		Card[] currHand = null;
		if (startingDeck.length < cardsPerHand)
			return null;

		Deck[] d = new Deck[hands];
		for (int i = 0; i < hands; i++) {
			for (int j = 0; j < cardsPerHand; j++) {
				currHand = new Card[cardsPerHand];
				currHand[i] = startingDeck[i];
			}
			d[i].setDeck(currHand);
		}

		return d;
	}

	/**
	 * Randomly picks Card out of array, collapses
	 *
	 * @return random Card from deck
	 */
	public static Card pick() {
		int randPos = (int) (Math.random() * deckSize);
		Card randCard = deck[randPos];
		for (int i = randPos; i <= deckSize - 2; i++) {
			deck[i] = deck[i + 1];
		}
		deck[deck.length - 1] = null; // TODO need to fix
		return randCard;
	}

	/**
	 * Sorts deck by suit and rank using Selection Sort Algorithm
	 */
	public static void selectionSort() {
		//TODO find a way to pile based on suit, merge sort within that
		int n = deck.length;

		int rankMax = 0;
		int currentSuit = deck[0].getSuitInt();

		for (int rank = 1; rank < n; rank++) {

			if (deck[rank].getRank() > deck[rankMax].getRank()) {
				rankMax = rank;
			}
			Card rankTemp = deck[rankMax];
			deck[rankMax] = deck[n - 1];
			deck[n - 1] = rankTemp;
			n--;
		}
	}

	public static Card[] pileOfSuits() {
		return deck;
	}

	/**
	 * Sorts deck by suit and rank using Merge Sort Algorithm
	 */
	public static void mergeSort(int from, int to) {
		// TODO add mergeSort algorithm
		if (to - from < 2) {
			if (to > from && deck[to].getSuitInt() < deck[from].getSuitInt()) {
				Card temp = deck[to];
				deck[to] = deck[from];
				deck[from] = temp;
			}
		} else {
			int middle = (from + to) / 2;
			mergeSort(from, middle);
			mergeSort(middle + 1, to);
			merge(deck, from, middle, to);
		}
	}

	public static void merge(Card[] deck, int from, int middle, int to) {
		// TODO i feel like this is wrong....?????
		{
			Card[] temp = new Card[1];
			int i = from, j = middle + 1, k = from;

			// While both arrays have elements left unprocessed:
			while (i <= middle && j <= to) {
				if (deck[i].getSuitInt() < deck[j].getSuitInt()) {
					temp[k] = deck[i]; // Or simply temp[k] = a[i++];
					i++;
				} else {
					temp[k] = deck[j];
					j++;
				}
				k++;
			}

			// Copy the tail of the first half, if any, into temp:
			while (i <= middle) {
				temp[k] = deck[i]; // Or simply temp[k++] = a[i++]
				i++;
				k++;
			}

			// Copy the tail of the second half, if any, into temp:
			while (j <= to) {
				temp[k] = deck[j]; // Or simply temp[k++] = a[j++]
				j++;
				k++;
			}

			// Copy temp back into a
			for (k = from; k <= to; k++)
				deck[k] = temp[k];
		}
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

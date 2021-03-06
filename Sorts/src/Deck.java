import java.util.ArrayList;

/*	<p>
 * The Deck class consists mainly of a Card array, representative of a hand/deck.<br>
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Deck {

	private final static int NUMRANKS = 13; // number of ranks (in compl. deck)
	private final static int NUMSUITS = 4; // number of suits (in compl. deck)
	private final static int DECKSIZE = NUMRANKS * NUMSUITS; // number of a full
																// deck

	private Card[] deck; // deck as a Card array
	private int topCard; // keeps track of last index of deck
	private boolean sorted; // if deck is sorted or shuffled

	public Deck() {
		deck = new Card[DECKSIZE];
		fillDeck(sorted);
		topCard = deck.length - 1;
		sorted = true;
	}

	public Deck(boolean sorted) {
		deck = new Card[DECKSIZE];
		fillDeck(sorted);
		this.sorted = sorted;
		topCard = deck.length - 1;
	}

	public Deck(int numCards) {
		deck = new Card[numCards];
		topCard = deck.length - 1;
	}

	public Deck(Deck o) { // copy constructor
		Card[] newDeck = new Card[topCard];
		for (int i = 0; i < topCard; i++) {
			newDeck[i] = deck[i];
		}
		this.deck = newDeck;
		this.topCard = o.topCard;
		this.sorted = o.sorted;
	}

	public Card[] getDeck() {
		return deck;
	}

	public int getTopCard() {
		return topCard;
	}

	public void setDeck(Card[] c) {
		deck = c;
	}

	/**
	 * Replaces current deck with newly unshuffled deck.
	 */
	public void shuffle() { // based on old Deck.java class from 2015-6

		Card[] shuffDeck = deck;

		for (int k = topCard; k > 0; k--) {
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
	 *         columns by suit, ordered by rank, otherwise in one column
	 */
	public String toString() {

		String deckStr = "";

		if (topCard == DECKSIZE-1) {

			for (int rank = 0; rank < NUMRANKS; rank++) {
				for (int suit = 0; suit < NUMSUITS; suit++) {
					deckStr += deck[suit * NUMRANKS + rank] + "\t";
				}
				deckStr += "\n";
			}
		}

		else {
			for (Card c : deck) {
				if (c != null)
					deckStr += c.toString() + "\n";
			}
		}
		return deckStr;

	}

	public String toString(Deck[] d) {
		String result = "";
		for (int i = 0; i < topCard; i++) {
			result += d[i].getDeck().toString();
		}
		return result;
	}

	/**
	 * Utilizes equals method of Card class to compare each element.
	 * 
	 * @param Deck
	 *            to compare
	 * @return true if Decks are identical, false otherwise.
	 */
	public boolean equals(Deck other) {

		Deck mainDeck = new Deck(this);
		Deck otherDeck = new Deck(other);

		if (mainDeck.getDeck().length != otherDeck.getDeck().length)
			return false;
		else {

			for (int i = 0; i < otherDeck.getDeck().length; i++) {
				if (!(mainDeck.getDeck()[i].equals(other.getDeck()[i]))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Deals out specified number of cards to specified number of hands.
	 *
	 * @param number
	 *            of hands
	 * @param cards
	 *            in each hand
	 * 
	 * @return final Deck[] of hands
	 */
	public Deck[] deal(int hands, int cardsPerHand) {

		if (topCard < (hands * cardsPerHand) || topCard <= 0)
			return null;

		Deck[] allHands = new Deck[hands];
		for (int c = 0; c < allHands.length; c++) {
			allHands[c] = new Deck();
			allHands[c].deck = new Card[cardsPerHand];
		}

		for (int ca = 0; ca < cardsPerHand; ca++) {
			for (int h = 0; h < hands; h++) {
				Card replaceCard = new Card(deck[topCard]);
				allHands[h].deck[ca] = replaceCard;
			}

		}

		return allHands;
	}

	/**
	 * Randomly picks Card out of array, collapses
	 *
	 * @return random Card from deck
	 */
	public Card pick() {
		int randPos = (int) (Math.random() * topCard);
		Card randCard = deck[randPos];
		for (int i = randPos + 1; i <= topCard; i++) {
			deck[i - 1] = deck[i];
		}
		deck[topCard] = null;
		topCard--;
		return randCard;
	}

	/**
	 * Sorts deck by suit and rank using Selection Sort Algorithm
	 */
	public void selectionSort() {
		// Note: throws NullPointerException

		if (topCard > 0) {
			for (int n = topCard + 1; n > 1; n--) {
				int maxPos = 0;
				for (int i = 1; i < n; i++) {
					if (deck[i].compareTo(deck[maxPos]) > 0) {

						maxPos = i;
					}
				}

				// swap maxPos with rightmost index
				Card temp = deck[maxPos];
				deck[maxPos] = deck[n - 1];
				deck[n - 1] = temp;

			}
		}

	}

	/**
	 * Sorts deck by suit and rank using Selection Sort Algorithm
	 * 
	 * @param deck
	 *            of cards to be sorted
	 */
	public void mergeSort() {
		Card[] temp = new Card[topCard];
		recursiveSort(deck, 0, topCard - 1, temp);
	}

	/**
	 * Merges unsorted elements into one array in sorted order
	 * 
	 * @param d
	 *            deck of cards
	 * @param from
	 *            index starting from
	 * @param middle
	 *            middle index
	 * @param to
	 *            index going towards
	 * @param temp
	 *            to copy over cards, store temporarily
	 */
	private void merge(int from, int middle, int to, Card[] temp) {
		int i = from;
		int j = middle + 1;
		int k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to) {
			if (deck[i].compareTo(deck[j]) <= -1) {
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

	/**
	 * Recursively merges elements together until sorted
	 * 
	 * @param d
	 *            deck of cards
	 * @param from
	 *            index starting from
	 * @param to
	 *            index going towards
	 * @param temp
	 *            to copy over cards, store temporarily
	 */
	private void recursiveSort(Card[] d, int from, int to, Card[] temp) {
		// to = topCard;
		if (to - from < 2) {
			if (to > from && d[to].compareTo(d[from]) <= -1) {
				// swap a[to] and a[from]
				Card aTemp = d[to];
				d[to] = d[from];
				d[from] = aTemp;
			}
		} else {
			int middle = (from + to) / 2;
			recursiveSort(d, from, middle, temp);
			recursiveSort(d, middle + 1, to, temp);
			merge(from, middle, to, temp);
		}
	}

	/**
	 * Fills a deck, sorted by suit and rank
	 * 
	 * @param determines
	 *            if deck should be shuffled or not
	 * 
	 */
	public void fillDeck(boolean sorted) {

		for (int i = 0; i < DECKSIZE;) {
			for (int suit = 0; suit < NUMSUITS; suit++) {
				for (int rank = 1; rank <= NUMRANKS; rank++) {
					deck[i] = new Card(suit, rank);
					i++;
				}
			} 
		}
		if (sorted != true)
			shuffle();
	}
}

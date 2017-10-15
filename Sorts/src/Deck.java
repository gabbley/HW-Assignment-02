import java.util.ArrayList;

/*	<p>
 * The Deck class consists mainly of a Card array, representative of a hand/deck.<br>
 * </p>
 * 
 * @author Gabby Baniqued
 * */

public class Deck {

	private final static int FULLDECK = 52; // number of a full deck
	private final static int NUMRANKS = 13; // number of ranks (in compl. deck)
	private final static int NUMSUITS = 4; // number of suits (in compl. deck)

	private Card[] deck; // deck as a Card array
	private int topCard; // keeps track of last index of deck
	private boolean sorted; // if deck is sorted or shuffled

	public Deck() {
		deck = new Card[FULLDECK];
		fillDeck();
		topCard = deck.length - 1;
		sorted = true;
	}

	public Deck(boolean isSorted) {
		deck = new Card[FULLDECK];
		fillDeck();
		this.sorted = isSorted;
		topCard = deck.length - 1;
	}
	
	public Deck(int numCards){
		deck = new Card[numCards];
		topCard = deck.length-1;
	}

	public Card[] getDeck() {
		return deck;
	}

	public boolean isSorted() {
		return sorted;
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
	 *         columns by suit, ordered by rank, otherwise in one column
	 */
	public String toString() {

		String deckStr = "";

		if (topCard == FULLDECK) {
			for (int rank = 0; rank < NUMRANKS; rank++) {
				for (int suit = 0; suit < NUMSUITS; suit++) {
					deckStr += deck[suit * NUMRANKS + rank] + "\t";
				}
				deckStr += "\n";
			}
		} 
		
		else {
			for (Card c : deck){
				if (c != null)
					deckStr += c.toString() + "\n";
			}
		}
		return deckStr;

	}
	
	public String toString(Deck[] d){
		String result = "";
		for (int i = 0; i<d.length; i++){
			result += d[i].getDeck().toString();
		}
		
		return result;
	}

	/**
	 * Utilizes equals method of Card class to compare each element.
	 * 
	 * @param Deck to compare
	 * @return true if Decks are identical, false otherwise.
	 */
	public boolean equals(Deck other) {

		for (int i = 0; i < other.deck.length; i++) {
			if (!(deck[i].equals(other.deck[i]))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Deals out specified number of cards to specified number of hands.
	 *
	 * @param number of hands
	 * @param cards in each hand
	 * 
	 * @return final Deck[] of hands
	 */
	public Deck[] deal(int hands, int cardsPerHand) {

		if (topCard < (hands * cardsPerHand))
			return null;

		Deck[] allHands = new Deck[hands];
		for (int c = 0; c < hands; c++) {
			allHands[c] = new Deck(cardsPerHand);
			// with numb of cards in parameter (cardsPerHand) //top card zero
		}

		for (int ca = 0; ca < cardsPerHand; ca++) {
			for (int h = 0; h < hands; h++) {
				//Card replaceCard = new Card(deck[topCard]);
				allHands[h].deck[ca] = deck[topCard]; //poss copy constructor
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
		//Note: throws NullPointerException
		
		for (int n = deck.length; n > 1; n--){
			int maxPos = 0;
			for (int i = 1; i < n; i++){
				if (deck[i].compareTo(deck[maxPos]) > 0){ //error with compareTo?
					maxPos = i;
				}
			}
			
			//swap maxPos with rightmost index
			Card temp = deck[maxPos];
			deck[maxPos] = deck[n-1];
			deck[n-1] = temp;
			
		}
		
	}

	/**
	 * Sorts deck by suit and rank using Merge Sort Algorithm
	 * 
	 * @param starting index
	 * @param ending index
	 */
	public void mergeSort(int from, int to) {
	//method is very much wrong i think
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


	/**
	 * Assists in Merge Sort algorithm (used provided code)
	 * 
	 * @param from, starting index
	 * @param middle, middle index
	 * @param ending index
	 */
	public void merge(Card[] deck, int from, int middle, int to) {
		// TODO fix merge
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
	public void fillDeck() {

		for (int i = 0; i < FULLDECK;) {
			for (int suit = 0; suit < NUMSUITS; suit++) {
				for (int rank = 1; rank <= NUMRANKS; rank++) {
					deck[i] = new Card(suit, rank);
					i++;
				}
			}
		}
	}
}

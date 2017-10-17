
/*	<p>
 * Tests both Deck and Card classes.
 * </p>
 * 
 * @author Gabby Baniqued
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class CardTester {

	public static void main(String[] args) {

		PrintWriter out = null;

		try {
			out = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No Print");
			e.printStackTrace();
		}

		out.println("Name: Gabby Baniqued!\n" + "Mood: Upset?\n");

		out.println("Testing the Card Class\n");
		ArrayList<Card> testCards = new ArrayList<Card>();
		Card testCard = new Card();

		out.println("Testing the Card Class Constructors\n");
		testCards.add(new Card());
		testCards.add(new Card(0, 1));
		testCards.add(new Card("Spades", "Ace"));
		testCards.add(new Card(0, "Five"));
		testCards.add(new Card(testCard));

		for (int i = 0; i < testCards.size(); i++) {
			out.println(testCards.get(i));
		}

		out.println("test getters\n");
		out.println(testCard.getRank() + " of " + testCard.getSuit());
		out.println(testCard.getRankStr(1));
		out.println(testCard.getRankInt("ACE"));
		out.println(testCard.getSuitInt());
		out.println(testCard.getSuitStr(0));

		// TODO TEST COMPARETO
		out.println("test compareTo and equals\n");

		out.println("Perfect Deck:");
		Deck testDeck = new Deck();
		out.println(testDeck + "\n");
		// System.out.println(testDeck);

		out.println("Deck, rand card picked, collapsed:");
		out.println(testDeck.pick() + "\n");
		out.println(testDeck + "\n");

		out.println("Deck, shuffled:");
		testDeck.shuffle();
		out.println(testDeck + "\n");

		out.println("Deck, sorted with selection sort:");
		testDeck.selectionSort();
		out.println(testDeck + "\n");

		testDeck.shuffle();
		out.println("Deck, sorted with merge sort:");
		testDeck.mergeSort();
		out.println(testDeck + "\n");

		out.println("Deck, dealt too many cards");
		Deck[] deckArrBig = testDeck.deal(4, 200); 
		out.println("Should be null -> " + deckArrBig + "\n");
		
		testDeck.shuffle();
		Deck[] deckArr = testDeck.deal(2, 10); //2 hands, 10 cards per
		for (int i = 0; i < deckArr.length; i++) {
			out.println(testDeck.toString());
		}
		
		out.println("Deck - equals method");
		Deck shuff = testDeck;
		shuff.shuffle();
		out.println("Should be true -> " + testDeck.equals(shuff) + "\n");

		out.close();

	}

}

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
		
		out.println("Name: Gabby Baniqued\n"
		+ "Mood: Upset\n");
		
		out.println("Testing the following:  \n"
				+ "sorted deck, shuffled deck, pick(), deal"+ "\n");
		
		

		// Card testCard = new Card();
		// System.out.println(testCard);
		out.println("Perfect Deck:");
		Deck testDeck = new Deck();
		out.println(testDeck + "\n");
		//System.out.println(testDeck);
		
		out.println("Deck, rand card picked, collapsed:");
		out.println(testDeck.pick() + "\n");
		out.println(testDeck+ "\n");

		out.println("Deck, shuffled:");
		testDeck.shuffle();
		out.println(testDeck+ "\n");
		
		//testDeck.selectionSort();
		//out.println(testDeck+ "\n");
		
//		testDeck.mergeSort(1, 51);
//		out.println(testDeck + "\n");

		out.println("Deck, attempted deal");
		Deck[] deckArr = testDeck.deal(2, 3); //could not figure out how to actually print deck
		for (int i = 0; i<deckArr.length; i++){
			out.println(testDeck.toString(deckArr));
		}
		
		out.close();

	}

}

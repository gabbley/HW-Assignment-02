import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class CardTester {

	public static void main(String[] args) {
		PrintWriter out = null;
		
		try {
			out = new PrintWriter("output.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		

		// Card testCard = new Card();
		// System.out.println(testCard);

		Deck testDeck = new Deck();
		// testDeck.shuffle();
		// System.out.println(testDeck);

		// testDeck.selectionSort();
		out.println(testDeck);

		out.println(Deck.pick() + "\n");
		out.println(testDeck);
		//out.println(testDeck.deal(2, 3)[0].getDeck());
		
		out.close();

	}

}


public class CardTester {

	public static void main(String[] args) {

		// Card testCard = new Card();
		// System.out.println(testCard);

		Deck testDeck = new Deck();
//		testDeck.shuffle();
		// System.out.println(testDeck);

//		testDeck.selectionSort();
		System.out.println(testDeck);

		System.out.println(Deck.pick() + "\n");
		System.out.println(testDeck);
		System.out.println(testDeck.deal(2, 3)[0]);

	}

}

/*	<p>
 * Able to compare two cards.
 * </p>
 * 
 * @author Gabby Baniqued
 * */

import java.util.Comparator;

public class CardSuitComparator implements Comparator<Card>{

	public int compare(Card card1, Card card2) {
		return card1.compareTo(card2);
	}
	
}

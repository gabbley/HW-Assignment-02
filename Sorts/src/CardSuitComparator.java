/*	<p>
 * CardSuitComparator class description
 * </p>
 * 
 * @author Gabby Baniqued
 * */

import java.util.Comparator;

public class CardSuitComparator implements Comparator<Card>{

	public int compare(Card card1, Card card2) {
		return card1.getSuit().compareTo(card2.getSuit());
	}
	
}

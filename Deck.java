package freecell_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import freecell_game.myCard.Suit;

public class Deck {
	private final ArrayList<myCard> cards = new ArrayList<>();
	  public Deck() {
	    for (Suit s: Suit.values())
	      for (int r=1; r<=13; r++)
	        cards.add(new myCard(s, r));
	  }
	  
	  
	  public void shuffle() { 
		  Collections.shuffle(cards); 
	  }
	  
	  
	  public ArrayList<myCard> drawAll() { 
		  return cards; 
	  }

}

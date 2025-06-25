package freecell_game;

public class myCard {
	public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}
	  private final Suit suit;
	  private final int rank; 
	  
	  public myCard(Suit newSuit, int newRank) {
		  rank = newRank;
		  suit = newSuit;
	  }
	  public Suit getSuit() {
		  return suit;
	  }
	  public int getRank() {
		  return rank;
	  }
	  
}

package freecell_game;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Pile {
		protected final Deque<myCard> cards = new ArrayDeque<>();
	  public boolean isEmpty() { return cards.isEmpty(); }
	  public myCard peek() { return cards.peek(); }
	  public abstract boolean canAccept(myCard c);
	  public void push(myCard c) { cards.push(c); }
	  public myCard pop() { return cards.pop(); }

}

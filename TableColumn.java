package freecell_game;

import java.util.ArrayList;
import freecell_game.myCard.Suit;

public class TableColumn extends Pile{
	private ArrayList<myCard> currentCards = new ArrayList<>(); 
	@Override
	public boolean canAccept(myCard c) {
		// TODO Auto-generated method stub
		if(currentCards.size() == 0) {
			currentCards.add(c);
			return true;
		}
		myCard temp = currentCards.get(currentCards.size()-1);
		if(temp.getSuit() == myCard.Suit.HEARTS || temp.getSuit() == myCard.Suit.DIAMONDS) {
			if(c.getSuit() == myCard.Suit.CLUBS || c.getSuit() == myCard.Suit.SPADES) {
				if(c.getRank() == (temp.getRank()-1)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public TableColumn(ArrayList<myCard> startingCards) {
		currentCards = startingCards;
	}
	
	public void add(myCard c) {
		currentCards.add(c);
	}
	
	public ArrayList<myCard> giveCards(int numCards){
		if(numCards>currentCards.size()) {
			return null;
		}
		ArrayList<myCard> returnStack = new ArrayList<>();
		
		
		returnStack = (ArrayList<myCard>) currentCards.subList(currentCards.size()-numCards, currentCards.size()-1);
		currentCards.removeAll(returnStack);
		return returnStack;
	}
	
	public myCard popBottom() {
		myCard temp = currentCards.get(currentCards.size()-1);
		currentCards.remove(currentCards.size()-1);
		return temp;
	}
	
	public String printCards() {
		String returnString = "";
		for(myCard s : currentCards) {
			returnString = returnString + " " + s.getRank() + " " + s.getSuit() + "\n";
		}
		return returnString;
	}

}

package freecell_game;

import java.util.ArrayList;

public class Foundation extends Pile{
	private ArrayList<myCard> currentCards = new ArrayList<>(); 
	private myCard lastCard = null;
	@Override
	public boolean canAccept(myCard c) {
		if(c == null)
			return false;
		if(currentCards.size() == 0) {
			if(c.getRank()==1) {
				return true;
			}else
				return false;
		}
		
		if(lastCard.getSuit()==c.getSuit()) {
			if((lastCard.getRank()+1)==c.getRank()) {
				return true;
			}
		}
		return false;
	}
	
	public void add(myCard c) {
		currentCards.add(c);
		lastCard = c;
	}
	
	public String printCard() {
		String returnString = "";
		for(myCard card : currentCards) {
			returnString = returnString + card.getRank() + " " + card.getSuit() + "\n";
		}
		
		return returnString;
	}

}

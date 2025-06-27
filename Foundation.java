package freecell_game;

import java.util.ArrayList;

public class Foundation extends Pile{
	private ArrayList<myCard> currentCards = new ArrayList<>(); 
	@Override
	public boolean canAccept(myCard c) {
		
		// TODO Auto-generated method stub
		return true;
	}
	
	public void add(myCard c) {
		currentCards.add(c);
	}
	
	public String printCard() {
		String returnString = "";
		for(myCard card : currentCards) {
			returnString = returnString + card.getRank() + " " + card.getSuit() + "\n";
		}
		
		return returnString;
	}

}

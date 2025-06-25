package freecell_game;

public class Freecell extends Pile{
	private myCard currentCard = null;
	@Override
	public boolean canAccept(myCard c) {
		// TODO Auto-generated method stub
		if(c == null)
			return false;
		if(currentCard != null) {
			return false;
		}
		return true;
	}
	
	public boolean canAccept() {
		if (currentCard == null)
				return true;
		return false;
	}
	
	public boolean addCard(myCard c) {
		if(currentCard == null) {
			currentCard = c;
			return true;
		}else {
			return false;
		}
	}
	
	public myCard getCurrent() {
		return currentCard;
	}
	
	public myCard popCurrent() {
		myCard temp = currentCard;
		currentCard = null;
		return temp;
	}
	
	public String printCard() {
		if(currentCard == null) {
			return "none";
		}else
			return currentCard.getRank() + " " + currentCard.getSuit();
	}

}

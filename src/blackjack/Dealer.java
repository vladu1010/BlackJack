package blackjack;

import java.util.ArrayList;

public class Dealer {
	private ArrayList<Cards> dealerHand;
	private int currentHand;
	private boolean isFinished;
	private boolean isAceEleven;
	
	public Dealer () {
		dealerHand = new ArrayList<Cards>();
		currentHand = 0;
		isFinished = false;
		isAceEleven = true;
	}
	
	public boolean getIsFinish () {
		return isFinished;
	}
	
	public int getCurrentHand () {
		return currentHand;
	}
	
	public void recalculateHand () {
		currentHand = 0;
		
		for (Cards cardDealer : dealerHand) {
			currentHand += cardDealer.getRank();	
		}
	}
	
	public void addCard (Cards card, Player player) {
		String comment = new String();
		
		dealerHand.add(card);
		currentHand += card.getRank();
		
		if (currentHand < 17) {
			comment = ", dealer draws another hand.";
		}
		else 
		{
			if (isAceEleven) {
				
				for (Cards cardDealer : dealerHand) {
					if ((cardDealer.getRank()) == 11 && currentHand > player.getPlayerResult()
							&& currentHand > 21) {
						isAceEleven = false;
						cardDealer.setRank(1);
					}		
				}
				
				recalculateHand();
			}
			if (currentHand >= 17 ) {
				isFinished = true;
				comment = ", dealer stops.";
			}
			else {
				comment = ", dealer draws another hand.";
			}
		}
		
		System.out.println("Dealer Draw: " + display(card.getValue()) + " "
				+ card.getSuit() + ". Dealer hand is " + currentHand + comment);
	}
	
	public void firstHand (Cards card[]) {
		dealerHand.add(card[0]);
		dealerHand.add(card[1]);
		
		currentHand += card[0].getRank();
		currentHand += card[1].getRank();

		System.out.println("Dealer Draw: " + display(card[0].getValue()) + " "
				+ card[0].getSuit() + ", " + "Hidden");
	}
	
	public void showCard () {
		String comment = new String();
		
		if (currentHand < 17)
			comment = ", dealer draws another hand.";
		else 
		{
			isFinished = true;
			comment = ", dealer stops.";
		}
		
		System.out.println("Dealer Hidden Card was: " + display(dealerHand.get(1).getValue()) + " "
				+ dealerHand.get(1).getSuit() + ". Dealer hand is " + currentHand + comment);
		
	}
	
	public String display (Integer thisHand) {
		String isRank;
		
		switch (thisHand) {
			case 11 : isRank = "ACE";
			break;
			case 12 : isRank = "J";
			break;
			case 13 : isRank = "Q";
			break;
			case 14 : isRank = "K";
			break;
			default : isRank = thisHand.toString();
		}
		
		return isRank;
	}
}

package blackjack;

import java.util.ArrayList;

public class Player {

	private ArrayList<Cards> playerHand;
	private int currentHand;
	private boolean isFinished;
	
	public Player () {
		playerHand = new ArrayList<Cards>();
		currentHand = 0;
		isFinished = false;
	}
	
	public boolean getIsFinish () {
		return isFinished;
	}
	
	public int getCurrentHand () {
		return currentHand;
	}
	
	public void recalculatePlayer () {
		currentHand = 0;
		
		for (Cards card : playerHand)
			currentHand += card.getRank();
		
	}
	
	public void recalculateHand () {
		if (currentHand != 21) {
			
			if (currentHand > 21) {
				for (Cards card : playerHand) {
					if (card.getRank() == 11 && (currentHand != 21 && currentHand > 21)) {
						card.setRank(1);
						recalculatePlayer();
					}
				}
			}
			
		}
	}
	
	public int getPlayerResult () {
		return currentHand;
	}
	
	public void addCard (Cards card) {
		playerHand.add(card);
		currentHand += card.getRank();
		
		System.out.println("Player Draw(1): " + display(card.getValue()) + " "
				+ card.getSuit() + ". Do you want to continue? (Y/N)");
	}
	
	public void firstHand (Cards card[]) {
		playerHand.add(card[0]);
		playerHand.add(card[1]);
		
		currentHand += card[0].getRank();
		currentHand += card[1].getRank();

		System.out.println("Player Draw(1): " + display(card[0].getValue()) + " "
				+ card[0].getSuit() + ", " + display(card[1].getValue()) + " "
				+ card[1].getSuit() + ". Do you want to continue? (Y/N)");
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

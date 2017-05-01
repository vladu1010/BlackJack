package blackjack;

public class Cards {
	
	private String Suit;
	private int Rank;
	
	public Cards(String Suit, int Rank) {
		this.Suit = Suit;
		this.Rank = Rank;
	}

	public int getRank () {
		if (Rank > 11)
			return 10;
		else 
			return Rank;
	}
	
	public int getValue () {
		return Rank;
	}
	
	public String getSuit () {
		return Suit;
	}
	
	public void setRank (int Rank) {
		this.Rank = Rank;
	}
	
	public String toString () {
		Integer trueRank = Rank;
		String isRank;
		
		switch (trueRank) {
			case 11 : isRank = "ACE";
			break;
			case 12 : isRank = "J";
			break;
			case 13 : isRank = "Q";
			break;
			case 14 : isRank = "K";
			break;
			default : isRank = trueRank.toString();
		}
		
		return "Player has " + isRank + " " + Suit;
	}
}

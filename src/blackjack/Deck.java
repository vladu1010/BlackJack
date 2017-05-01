package blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

	public ArrayList<Cards> deck; 
	private static int numberCards = 52;
	private Player player;
	private Dealer dealer;
	private boolean naturalBlackjack;
	
	public Deck () {
		deck = new ArrayList<Cards>();
		player = new Player();
		dealer = new Dealer();
		naturalBlackjack = false;
		
		String suits[] = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
		
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < 13; j++) {
				deck.add(new Cards(suits[i], (j + 2)));
			}
		}
	}
	
	public Cards draw () {
		int randomNum = ThreadLocalRandom.current().nextInt(0, numberCards);
		numberCards--;
		
		return deck.remove(randomNum);
	}
	
	public void firsHand () {
		System.out.println("Initial Draw");
		
		Cards cardDealer[] = new Cards[2];
		cardDealer[0] = draw();
		cardDealer[1] = draw();
		
		Cards cardPlayer[] = new Cards[2];
		cardPlayer[0] = draw();
		cardPlayer[1] = draw();
		
		dealer.firstHand(cardDealer);
		player.firstHand(cardPlayer);
		
		if (player.getCurrentHand() == 21)
			naturalBlackjack = true;
		
		playing();
	}
	
	public void playing () {
		Scanner sc=new Scanner(System.in);  
		boolean playerHasLost = false;
		
		while (true) {
			 
			if (player.getCurrentHand() == 21)
				break;
			
			if (player.getCurrentHand() > 21) {
				player.recalculateHand();
				if (player.getCurrentHand() > 21) {
					playerHasLost = true;
					break;
				}
			}
			
			String answer = sc.next();
			
			if (answer.equals("N"))
				break;
			else if(answer.equals("Y"))
				player.addCard(draw());

		}
		
		player.recalculateHand();
		
		if (!playerHasLost) {
			dealer.showCard();
			
			if (naturalBlackjack && dealer.getCurrentHand() != 21) 
				System.out.println("Player WINS!!!"); 
			else if (naturalBlackjack && dealer.getCurrentHand() == 21)
				System.out.println("It has finished equal!!!");
			else {
				while (!dealer.getIsFinish()) 
					dealer.addCard(draw(), player);
			
				System.out.println("Player Hand values " + player.getCurrentHand() + 
							", " + "Dealer Hand values " + dealer.getCurrentHand() + ".");
				
				if (player.getCurrentHand() > dealer.getCurrentHand() || dealer.getCurrentHand() > 21)
					System.out.println("Player WINS!!!");
				else if (player.getCurrentHand() == dealer.getCurrentHand())
					System.out.println("It has finished equal!!!");
				else
					System.out.println("Dealer WINS!!!");
			}
		}
		else {
			System.out.println("Dealer WINS!!!");
		}
		
		sc.close();
	}
}

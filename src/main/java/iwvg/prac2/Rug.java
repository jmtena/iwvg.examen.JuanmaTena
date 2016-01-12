package iwvg.prac2;

public class Rug implements RugForView{
	private static int CARDS_PER_SUIT = 13;
	
	private SetOfCards deck;
	
	private SetOfCards discard;
	
	private SetOfCards[] suitPile;
	
	private SetOfCards[] straight;
	
	public Rug(){
		deck = new SetOfCards();
		discard = new SetOfCards();
		
		for(int i=0; i<Klondike.NUM_SUITS; i++)
			suitPile[i] = new SetOfCards();
		
		for(int i=0; i<Klondike.NUM_STRAIGHTS; i++)
			straight[i] = new SetOfCards();
		initialize();
	}
	
	public Card getCard(Position position){
		Pile pile = position.getPile();
		int pos = position.getPos();
		
		switch(pile){
			case DECK_OF_CARDS:
				return deck.getCard(pos);
			case DISCARD:
				return discard.getCard(pos);
			case SUITPILE_OF_SPADES:
				return suitPile[0].getCard(pos);
			case SUITPILE_OF_HEARTS:
				return suitPile[1].getCard(pos);
			case SUITPILE_OF_DIAMONDS:
				return suitPile[2].getCard(pos);
			case SUITPILE_OF_CLUBS:
				return suitPile[3].getCard(pos);
			case STRAIGHT_ONE:
				return straight[0].getCard(pos);
			case STRAIGHT_TWO:
				return straight[1].getCard(pos);
			case STRAIGHT_THREE:
				return straight[2].getCard(pos);
			case STRAIGHT_FOUR:
				return straight[3].getCard(pos);
			case STRAIGHT_FIVE:
				return straight[4].getCard(pos);
			case STRAIGHT_SIX:
				return straight[5].getCard(pos);
			case STRAIGHT_SEVEN:
				return straight[6].getCard(pos);
			default:
					return null;
		}
	}
	
	private void initialize(){
		//We put all the cards into the set "deck"
		for(Suit s: Suit.values()){
			for(CardNumber number : CardNumber.values()){
				Card card = new Card(s,number,Orientation.FACE_DOWN);
				deck.addCard(card);
			}
		}
		deck.shuffle();
		
		for(int i=0; i<Klondike.NUM_STRAIGHTS; i++){
			//Repartir las cartas entre las escaleras
		}
		
	}
	
	public boolean complete(){
		boolean complete=true;
		
		boolean empty_deck = deck.isEmpty();
		boolean empty_discard = discard.isEmpty();
		boolean full_suitPiles = true;
		boolean empty_straights = true;

		for(int i=0; i<this.suitPile.length; i++){
			if (suitPile[i].getLength() != CARDS_PER_SUIT){
				full_suitPiles = false;
				break;
			}
		}
		
		for(int i=0; i<this.straight.length; i++){
			if (!straight[i].isEmpty()){
				empty_straights = false;
				break;
			}
		}
		
		complete = empty_deck && empty_discard && full_suitPiles && empty_straights;
		return complete;
	}
}

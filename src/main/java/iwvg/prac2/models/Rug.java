package iwvg.prac2.models;

import iwvg.prac2.utils.Position;

public class Rug{
	private static int CARDS_PER_SUIT = 13;
	
	private SetOfCards deck;
	
	private SetOfCards discard;
	
	//Suits
	private SetOfCards spadesSuit;
	
	private SetOfCards heartsSuit;
	
	private SetOfCards diamondsSuit;
	
	private SetOfCards clubsSuit;
	
	//Straights	
	private SetOfCards[] straights;
	
	public Rug(){
		deck = new SetOfCards();
		discard = new SetOfCards();
		
		spadesSuit = new SetOfCards();
		heartsSuit = new SetOfCards();
		diamondsSuit = new SetOfCards();
		clubsSuit = new SetOfCards();
		
		for(int i=0; i<Game.getNumStraights(); i++)
			straights[i] = new SetOfCards();
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
				return suits[0].getCard(pos);
			case SUITPILE_OF_HEARTS:
				return suits[1].getCard(pos);
			case SUITPILE_OF_DIAMONDS:
				return suits[2].getCard(pos);
			case SUITPILE_OF_CLUBS:
				return suits[3].getCard(pos);
			case STRAIGHT_ONE:
				return straights[0].getCard(pos);
			case STRAIGHT_TWO:
				return straights[1].getCard(pos);
			case STRAIGHT_THREE:
				return straights[2].getCard(pos);
			case STRAIGHT_FOUR:
				return straights[3].getCard(pos);
			case STRAIGHT_FIVE:
				return straights[4].getCard(pos);
			case STRAIGHT_SIX:
				return straights[5].getCard(pos);
			case STRAIGHT_SEVEN:
				return straights[6].getCard(pos);
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
		
		for(int i=0; i<this.straights.length; i++){
			if (!straights[i].isEmpty()){
				empty_straights = false;
				break;
			}
		}
		
		complete = empty_deck && empty_discard && full_suitPiles && empty_straights;
		return complete;
	}
	
	public SetOfCards getDeck(){
		return this.deck;
	}
	
	public SetOfCards getDiscard(){
		return this.discard;
	}
	
	public SetOfCards getSpadesPile(){
		return this.spadesSuit;
	}

	public SetOfCards getHeartsPile(){
		return this.heartsSuit;
	}
	
	public SetOfCards getDiamondsPile(){
		return this.diamondsSuit;
	}

	public SetOfCards getClubsPile(){
		return this.clubsSuit;
	}

	public SetOfCards getStraight(int pos){
		return this.straights[pos];
	}
}

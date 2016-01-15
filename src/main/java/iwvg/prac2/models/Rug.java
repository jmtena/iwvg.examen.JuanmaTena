package iwvg.prac2.models;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.utils.Orientation;
import iwvg.prac2.utils.Position;

public class Rug{
	
	//Baraja y descarte
	private SetOfCards deck;
	
	private SetOfCards discard;
	
	//Palos
	private SetOfCards spadesSuit;
	
	private SetOfCards heartsSuit;
	
	private SetOfCards diamondsSuit;
	
	private SetOfCards clubsSuit;
	
	//Escaleras
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
	
	public void shuffle(){
		deck.shuffle();
	}
	
	public void distribute_cards(){
		int n = Game.getNumStraights();
		
		for (int i = 0; i < n; i++){
			int num_cards = n - i;
			for(int j = 0; j < num_cards; j++){
				Card card = deck.takeCard();
				if (j==num_cards-1){
					//Ultima carta de la escalera
					card.turnOver();
				}
				straights[i].addCard(card);
				deck.removeCard();
			}
		}
	}
	
	public Error moveCard(Position origin, Position destiny){
		Error error;
		
		SetOfCards originPile = getPile(origin);
		SetOfCards destinyPile = getPile(destiny);
		
		if (originPile.getLength()==0){
			error = Error.NO_CARDS;
		}
		else{
			Card card = originPile.takeCard();
			if (card.getOrientation()==Orientation.FACE_DOWN){
				error = Error.CARD_FACE_DOWN;
			}
			else{
				destinyPile.addCard(card);
				originPile.removeCard();
				error = null;
			}
		}
		return error;
		
	}
	
	private SetOfCards getPile(Position position){
		switch(position){
			case DECK:
				return deck;
			case DISCARD:
				return discard;
			case SPADES:
				return spadesSuit;
			case HEARTS:
				return heartsSuit;
			case DIAMONDS:
				return diamondsSuit;
			case CLUBS:
				return clubsSuit;
			case STRAIGHT_ONE:
				return straights[0];
			case STRAIGHT_TWO:
				return straights[1];
			case STRAIGHT_THREE:
				return straights[2];
			case STRAIGHT_FOUR:
				return straights[3];
			case STRAIGHT_FIVE:
				return straights[4];
			case STRAIGHT_SIX:
				return straights[5];
			case STRAIGHT_SEVEN:
				return straights[6];
			default:
					return null;
		}
	}
	
	private void initialize(){
		//Ponemos todas las cartas en la baraja
		for(Suit s: Suit.values()){
			for(CardNumber number : CardNumber.values()){
				Card card = new Card(s,number,Orientation.FACE_DOWN);
				deck.addCard(card);
			}
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

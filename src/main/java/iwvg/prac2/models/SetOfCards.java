package iwvg.prac2.models;

public class SetOfCards {
	private Card[] cards;
	
	public SetOfCards(){
		cards = new Card[0];
	}
	
	public void addCard(Card new_card){
		assert new_card!= null;
		
		int new_length = cards.length + 1;
		Card[] new_cards = new Card[new_length];
		
		for(int i=0; i<new_length-1; i++)
			new_cards[i] = cards[i];
		
		new_cards[new_length-1] = new_card;
		cards = new_cards;
	}
	
	public void removeCard(){
		assert cards!= null;
		assert cards.length > 0;
		
		int new_length = cards.length - 1;
		Card[] new_cards = new Card[new_length];
		
		//Se elimina la ultima carta
		for(int i=0; i<new_length; i++)
			new_cards[i] = cards[i];
		
		cards = new_cards;
	}
	
	public void removeCard(Card card){
		assert card!= null;
		int new_length = cards.length - 1;
		Card[] new_cards = new Card[new_length];
		
		int j=0;
		for(int i=0; i<cards.length; i++)
			if (!cards[i].isEqual(card)){
				new_cards[j] = cards[i];
				j++;
			}
		
		cards = new_cards;
	}
	
	public void shuffle(){
		SetOfCards new_cards = new SetOfCards();
		
		//Se barajan las cartas aleatoriamente
		while(!this.isEmpty()){
			Card card = this.getRandomCard();
			new_cards.addCard(card);
			removeCard(card);
		}
		
		this.cards = new_cards.getSetOfCards();
	}
	
	public Card getCard(int pos){
		return cards[pos];
	}
	
	public Card getRandomCard(){
		int N=0;
		int M=this.getLength();
		
		int randomIntNumber = (int)Math.floor(Math.random()*(N-M+1)+M);
		
		return this.getCard(randomIntNumber);		
	}
	
	public Card takeCard(){
		int pos = cards.length - 1;
		return this.getCard(pos);
	}
	
	public int getLength(){
		return cards.length;
	}
	
	public boolean isEmpty(){
		return this.getLength()==0;
	}
	
	public Card[] getSetOfCards(){
		return this.cards;
	}
	
	public void clear(){
		cards = new Card[0];
	}
	
	@Override
	public String toString(){
		String set = "";
		
		for(int i=0; i<cards.length-1; i++){
			set += "[";
		}
		
		Card card = this.getCard(cards.length-1);
		set += "[" + card.getNumber() + "," + card.getSuit() +"]";
		
		return set;
	}

}

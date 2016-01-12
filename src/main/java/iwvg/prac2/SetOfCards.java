package iwvg.prac2;

public class SetOfCards {
	private Card[] cards;
	
	public SetOfCards(){
		cards = new Card[0];
	}
	
	public void addCard(Card new_card){
		assert cards!= null;
		
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
		
		for(int i=0; i<new_length; i++)
			new_cards[i] = cards[i];
		
		cards = new_cards;
	}
	
	private void removeCard(Card card){
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
		
		//We choose randomly the cards
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
	
	public int getLength(){
		return cards.length;
	}
	
	public boolean isEmpty(){
		return this.getLength()==0;
	}
	
	public Card[] getSetOfCards(){
		return this.cards;
	}
}

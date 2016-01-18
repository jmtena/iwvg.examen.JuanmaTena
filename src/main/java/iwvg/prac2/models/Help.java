package iwvg.prac2.models;

import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Orientation;

public class Help {
	
	private Game game;
	private Rug rug;
	
	public Help(Game game){
		this.game = game;
		this.rug = game.getRug();
	}

	public void showPossibleMoves(){
		showPossibleMovesFromDeck();
		showPossibleMovesFromDiscard();
		showPossibleMovesFromStraight();
		showPossibleMovesFromSuit();
		showPossibleTurnOverMoves();
	}
	
	private void showPossibleTurnOverMoves(){
		for(int i=0; i<Game.getNumStraights(); i++){
			SetOfCards straight = game.getStraight(i); 
			if (straight.takeCard().getOrientation()==Orientation.FACE_DOWN){
				new IO().write("Voltear la ultima carta en la escalera " + (i+1));
			}
		}
	}
	
	private void showPossibleMovesFromSuit(){
		showPossibleMovesFromSpadesToStraight();
		showPossibleMovesFromHeartsToStraight();
		showPossibleMovesFromDiamondsToStraight();
		showPossibleMovesFromClubsToStraight();
	}
	
	private void showPossibleMovesFromClubsToStraight(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(Position.CLUBS, straight)){
				new IO().write("Mover " + game.getClubsPile().takeCard().toString() + " de Palo Treboles a Escalera " + (i+1) + " sobre " + game.getStraight(i).takeCard().toString());
			}
		}
	}
	
	
	private void showPossibleMovesFromDiamondsToStraight(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(Position.DIAMONDS, straight)){
				new IO().write("Mover " + game.getDiamondsPile().takeCard().toString() + " de Palo Rombos a Escalera " + (i+1) + " sobre " + game.getStraight(i).takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromHeartsToStraight(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(Position.HEARTS, straight)){
				new IO().write("Mover " + game.getHeartsPile().takeCard().toString() + " de Palo Corazones a Escalera " + (i+1) + " sobre " + game.getStraight(i).takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromSpadesToStraight(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(Position.SPADES, straight)){
				new IO().write("Mover " + game.getSpadesPile().takeCard().toString() + " de Palo Picas a Escalera " + (i+1) + " sobre " + game.getStraight(i).takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraight(){
		showPossibleMovesFromStraightToSuit();
		showPossibleMovesFromStraightToStraight();
	}
	
	private void showPossibleMovesFromStraightToStraight(){
		for(int i=0; i<Game.getNumStraights(); i++){
			for(int j=0; j<Game.getNumStraights(); j++){
				SetOfCards originStraight = game.getStraight(i);
				SetOfCards destinyStraight = game.getStraight(j);
				int numCardsInStraight = originStraight.getLength();
				//Para cada escalera, se comprueba cuantas cartas se pueden mover
				for(int k=0; k<numCardsInStraight; k++){
					//Comprobamos la primera carta de la columna de cartas a mover (para cada caso)
					Card card = originStraight.getCard(originStraight.getLength()-1-numCardsInStraight-k);					
					if (rug.isPosibleMoveToStraight(destinyStraight, card)){
						new IO().write("Mover " + (k+1) + " cartas: " + card.toString() + " de Escalera " + (i+1) + " a Escalera " + (j+1) + " sobre " + game.getStraight(j).takeCard().toString());
					}
				}				
			}
		}
	}
	
	private void showPossibleMovesFromStraightToSuit(){
		showPossibleMovesFromStraightToSpades();
		showPossibleMovesFromStraightToHearts();
		showPossibleMovesFromStraightToDiamonds();
		showPossibleMovesFromStraightToClubs();
	}
	
	private void showPossibleMovesFromStraightToClubs(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.CLUBS)){
				new IO().write("Mover " + game.getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Treboles sobre " + game.getClubsPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraightToDiamonds(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.DIAMONDS)){
				new IO().write("Mover " + game.getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Rombos sobre " + game.getDiamondsPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraightToHearts(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.HEARTS)){
				new IO().write("Mover " + game.getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Corazones sobre " + game.getHeartsPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraightToSpades(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.SPADES)){
				new IO().write("Mover " + game.getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Picas sobre " + game.getSpadesPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromDeck(){
		showPossibleMovesFromDeckToDiscard();
	}
	
	private void showPossibleMovesFromDeckToDiscard(){
		if (rug.isPossibleMove(Position.DECK, Position.DISCARD)){
			int numcards = rug.getDeck().getLength();
			IO io = new IO();
			io.writeln("Mover " + numcards + " como maximo de baraja a descarte");
		}
	}
	
	private void showPossibleMovesFromDiscard(){
		showPossibleMovesFromDiscardToDeck();
		showPossibleMovesFromDiscardToSuit();
		showPossibleMovesFromDiscardToStraight();
	}
	
	private void showPossibleMovesFromDiscardToStraight(){
		for(int i=0; i<Game.getNumStraights(); i++){
			Position straight = this.game.getPile(i+1);
			if (rug.isPossibleMove(Position.DISCARD, straight)){
				new IO().write("Mover " + game.getDiscard().takeCard().toString() + " de Descarte a Escalera " + (i+1) + " sobre " + game.getStraight(i).takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromDiscardToDeck(){
		if (rug.isPossibleMove(Position.DISCARD, Position.DECK)){
			int numcards = rug.getDiscard().getLength();
			IO io = new IO();
			io.writeln("Mover " + numcards + " como maximo de descarte a baraja");
		}
	}
	
	private void showPossibleMovesFromDiscardToSuit(){
		showPossibleMovesFromDiscardToSpades();
		showPossibleMovesFromDiscardToHearts();
		showPossibleMovesFromDiscardToDiamonds();
		showPossibleMovesFromDiscardToClubs();
	}
	
	private void showPossibleMovesFromDiscardToSpades(){
		if (rug.isPossibleMove(Position.DISCARD, Position.SPADES)){
			new IO().write("Mover " + game.getDiscard().takeCard().toString() + " de Descarte a Palo Picas sobre " + game.getSpadesPile().takeCard().toString());
		}
	}
	
	private void showPossibleMovesFromDiscardToHearts(){
		if (rug.isPossibleMove(Position.DISCARD, Position.HEARTS)){
			new IO().write("Mover " + game.getDiscard().takeCard().toString() + " de Descarte a Palo Corazones sobre " + game.getHeartsPile().takeCard().toString());
		}
	}
	
	private void showPossibleMovesFromDiscardToDiamonds(){
		if (rug.isPossibleMove(Position.DISCARD, Position.DIAMONDS)){
			new IO().write("Mover " + game.getDiscard().takeCard().toString() + " de Descarte a Palo Rombos sobre " + game.getDiamondsPile().takeCard().toString());
		}
	}
	
	private void showPossibleMovesFromDiscardToClubs(){
		if (rug.isPossibleMove(Position.DISCARD, Position.CLUBS)){
			new IO().write("Mover " + game.getDiscard().takeCard().toString() + " de Descarte a Palo Treboles sobre " + game.getClubsPile().takeCard().toString());
		}
	}
	
}

package iwvg.prac2.models;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.utils.IO;

public class Game {

	private State state;

	private Rug rug;

	private static final int NUM_STRAIGHTS = 7;
	private static final int NUM_OPTIONS = 10;

	public Game() {
		state = State.IN_GAME;
		rug = new Rug();
	}

	private void changeState() {
		state = State.FINISHED;
	}

	public boolean isFinished() {
		return state == State.FINISHED;
	}

	public void initialize() {
		rug.initialize();
	}

	public void shuffle() {
		rug.shuffle();
	}

	public void distribute() {
		rug.distribute_cards();
	}

	public Error moveCard(Position origin, Position destiny) {
		assert origin != null;
		assert destiny != null;

		Error error = rug.moveCard(origin, destiny);
		if (rug.isComplete())
			this.changeState();
		return error;
	}

	public Error moveCards(Position origin, Position destiny, int numCards) {
		assert origin != null;
		assert destiny != null;

		Error error = rug.moveCards(origin, destiny, numCards);
		if (rug.isComplete())
			this.changeState();
		return error;
	}

	public Error turnOverCard(Position pos) {
		assert pos != null;
		return rug.turnOverCard(pos);
	}
	
	public void showPossibleMoves(){
		showPossibleMovesFromDeck();
		showPossibleMovesFromDiscard();
		showPossibleMovesFromStraight();
		showPossibleMovesFromSuit();
		showPossibleTurnOverMoves();
	}
	
	private void showPossibleMovesFromStraight(){
		showPossibleMovesFromStraightToSuit();
		showPossibleMovesFromStraightToStraight();
	}
	
	private void showPossibleMovesFromStraightToStraight(){
		for(int i=0; i<getNumStraights(); i++){
			for(int j=0; j<getNumStraights(); j++){
				SetOfCards originStraight = getStraight(i);
				SetOfCards destinyStraight = getStraight(j);
				//showPossibleMovesFromStraightToStraight(originStraight,destinyStraight);

				
				int numCardsInStraight = originStraight.getLength();
				for(int k=0; k<numCardsInStraight; k++){
					//Para cada escalera, se comprueba cuantas cartas se pueden mover
					//Comprobamos la primera carta de la columna de cartas a mover
					Card card = originStraight.getCard(originStraight.getLength()-1-numCardsInStraight-k);					
					if (rug.isPosibleMoveToStraight(destinyStraight, card)){
						new IO().write("Mover " + (k+1) + " cartas: " + getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Escalera " + (j+1) + " sobre " + getStraight(j).takeCard().toString());
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
		for(int i=0; i<getNumStraights(); i++){
			Position straight = this.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.CLUBS)){
				new IO().write("Mover " + getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Treboles sobre " + getClubsPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraightToDiamonds(){
		for(int i=0; i<getNumStraights(); i++){
			Position straight = this.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.DIAMONDS)){
				new IO().write("Mover " + getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Rombos sobre " + getDiamondsPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraightToHearts(){
		for(int i=0; i<getNumStraights(); i++){
			Position straight = this.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.HEARTS)){
				new IO().write("Mover " + getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Corazones sobre " + getHeartsPile().takeCard().toString());
			}
		}
	}
	
	private void showPossibleMovesFromStraightToSpades(){
		for(int i=0; i<getNumStraights(); i++){
			Position straight = this.getPile(i+1);
			if (rug.isPossibleMove(straight, Position.SPADES)){
				new IO().write("Mover " + getStraight(i).takeCard().toString() + " de Escalera " + (i+1) + " a Palo Picas sobre " + getSpadesPile().takeCard().toString());
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
		for(int i=0; i<getNumStraights(); i++){
			Position straight = this.getPile(i+1);
			if (rug.isPossibleMove(Position.DISCARD, straight)){
				new IO().write("Mover " + getDiscard().takeCard().toString() + " de Descarte a Escalera " + (i+1) + " sobre " + getStraight(i).takeCard().toString());
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
			new IO().write("Mover " + getDiscard().takeCard().toString() + " de Descarte a Palo Picas sobre " + getSpadesPile().takeCard().toString());
		}
	}
	
	private void showPossibleMovesFromDiscardToHearts(){
		if (rug.isPossibleMove(Position.DISCARD, Position.HEARTS)){
			new IO().write("Mover " + getDiscard().takeCard().toString() + " de Descarte a Palo Corazones sobre " + getHeartsPile().takeCard().toString());
		}
	}
	
	private void showPossibleMovesFromDiscardToDiamonds(){
		if (rug.isPossibleMove(Position.DISCARD, Position.DIAMONDS)){
			new IO().write("Mover " + getDiscard().takeCard().toString() + " de Descarte a Palo Rombos sobre " + getDiamondsPile().takeCard().toString());
		}
	}
	
	private void showPossibleMovesFromDiscardToClubs(){
		if (rug.isPossibleMove(Position.DISCARD, Position.CLUBS)){
			new IO().write("Mover " + getDiscard().takeCard().toString() + " de Descarte a Palo Treboles sobre " + getClubsPile().takeCard().toString());
		}
	}

	public SetOfCards getDeck() {
		return rug.getDeck();
	}

	public SetOfCards getDiscard() {
		return rug.getDiscard();
	}

	public SetOfCards getSpadesPile() {
		return rug.getSpadesPile();
	}

	public SetOfCards getHeartsPile() {
		return rug.getHeartsPile();
	}

	public SetOfCards getDiamondsPile() {
		return rug.getDiamondsPile();
	}

	public SetOfCards getClubsPile() {
		return rug.getClubsPile();
	}

	public SetOfCards getStraight(int pos) {
		return rug.getStraight(pos);
	}

	public Position getPile(int option) {
		switch (option) {
		case 1:
			return Position.STRAIGHT_ONE;
		case 2:
			return Position.STRAIGHT_TWO;
		case 3:
			return Position.STRAIGHT_THREE;
		case 4:
			return Position.STRAIGHT_FOUR;
		case 5:
			return Position.STRAIGHT_FIVE;
		case 6:
			return Position.STRAIGHT_SIX;
		case 7:
			return Position.STRAIGHT_SEVEN;
		default:
			return null;
		}
	}

	public Position getSuit(int option) {
		switch (option) {
		case 1:
			return Position.SPADES;
		case 2:
			return Position.HEARTS;
		case 3:
			return Position.DIAMONDS;
		case 4:
			return Position.CLUBS;
		default:
			return null;
		}
	}

	public static int getNumStraights() {
		return NUM_STRAIGHTS;
	}

	public static int getNumOptions() {
		return NUM_OPTIONS;
	}

}

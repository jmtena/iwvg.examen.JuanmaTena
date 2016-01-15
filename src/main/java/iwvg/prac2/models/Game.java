package iwvg.prac2.models;

import iwvg.prac2.controllers.Error;

public class Game {
	
	private State state;
	
	private Rug rug;
	
	private static final int NUM_STRAIGHTS = 7;
	private static final int NUM_OPTIONS = 9;
	
	public Game(){
		state = State.IN_GAME;
		rug = new Rug();
	}
	
	public void shuffle(){
		rug.shuffle();
	}
	
	public void distribute(){
		rug.distribute_cards();
	}
	
	public Error moveCard(Position origin, Position destiny){
		return rug.moveCard(origin,destiny);
	}
	
	public Error moveCards(Position origin, Position destiny, int numCards){
		return rug.moveCards(origin,destiny,numCards);
	}
	
	public Error turnOverCard(Position pos){
		return rug.turnOverCard(pos);
	}
	
	public SetOfCards getDeck(){
		return rug.getDeck();
	}
	
	public SetOfCards getDiscard(){
		return rug.getDiscard();
	}
	
	public SetOfCards getSpadesPile(){
		return rug.getSpadesPile();
	}

	public SetOfCards getHeartsPile(){
		return rug.getHeartsPile();
	}
	
	public SetOfCards getDiamondsPile(){
		return rug.getDiamondsPile();
	}

	public SetOfCards getClubsPile(){
		return rug.getClubsPile();
	}

	public SetOfCards getStraight(int pos){
		return rug.getStraight(pos);
	}

	public static int getNumStraights() {
		return NUM_STRAIGHTS;
	}

	public static int getNumOptions() {
		return NUM_OPTIONS;
	}
	
	
}

package iwvg.prac2.models;

public class Game {
	
	private State state;
	
	private Rug rug;
	
	private static final int NUM_SUITS = 4;
	private static final int NUM_STRAIGHTS = 7;
	private static final int NUM_OPTIONS = 9;
	
	public Game(){
		state = State.IN_GAME;
		rug = new Rug();
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
	
	public Rug getRug() {
		return rug;
	}

	public static int getNumSuits() {
		return NUM_SUITS;
	}

	public static int getNumStraights() {
		return NUM_STRAIGHTS;
	}

	public static int getNumOptions() {
		return NUM_OPTIONS;
	}
	
	
}

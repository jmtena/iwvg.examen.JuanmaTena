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

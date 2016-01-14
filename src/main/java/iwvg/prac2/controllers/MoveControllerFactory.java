package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;

public class MoveControllerFactory {
	private Game game;
	
	private DeckToDiscardController deckToDiscardController;
	
	private DiscardToDeckController discardToDeckController;
	
	private DiscardToSuitController discardToSuitController;
	
	private DiscardToStraightController discardToStraightController;
	
	private StraightToSuitController straightToSuitController;
	
	private StraightToStraightController straightToStraightController;
	
	private SuitToStraightController suitToStraightController;
	
	private TurnOverController turnOverController;
	
	
	public MoveControllerFactory(Game game){
		assert game != null;
		this.game = game;	
	}

	public DeckToDiscardController getDeckToDiscardController() {
		if (deckToDiscardController==null){
			deckToDiscardController = new DeckToDiscardController(game);
		}
		
		return deckToDiscardController;
	}

	public DiscardToDeckController getDiscardToDeckController() {
		return discardToDeckController;
	}

	public DiscardToSuitController getDiscardToSuitController() {
		return discardToSuitController;
	}

	public DiscardToStraightController getDiscardToStraightController() {
		return discardToStraightController;
	}

	public StraightToSuitController getStraightToSuitController() {
		return straightToSuitController;
	}

	public StraightToStraightController getStraightToStraightController() {
		return straightToStraightController;
	}

	public SuitToStraightController getSuitToStraightController() {
		return suitToStraightController;
	}

	public TurnOverController getTurnOverController() {
		return turnOverController;
	}
	
}

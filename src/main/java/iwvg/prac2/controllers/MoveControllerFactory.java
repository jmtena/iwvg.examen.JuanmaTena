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

	public MoveControllerFactory(Game game) {
		assert game != null;
		this.game = game;
	}

	public DeckToDiscardController getDeckToDiscardController() {
		if (deckToDiscardController == null) {
			deckToDiscardController = new DeckToDiscardController(game);
		}

		return deckToDiscardController;
	}

	public DiscardToDeckController getDiscardToDeckController() {
		if (discardToDeckController == null) {
			discardToDeckController = new DiscardToDeckController(game);
		}

		return discardToDeckController;
	}

	public DiscardToSuitController getDiscardToSuitController() {
		if (discardToSuitController == null) {
			discardToSuitController = new DiscardToSuitController(game);
		}

		return discardToSuitController;
	}

	public DiscardToStraightController getDiscardToStraightController() {
		if (discardToStraightController == null) {
			discardToStraightController = new DiscardToStraightController(game);
		}

		return discardToStraightController;
	}

	public StraightToSuitController getStraightToSuitController() {
		if (straightToSuitController == null) {
			straightToSuitController = new StraightToSuitController(game);
		}

		return straightToSuitController;
	}

	public StraightToStraightController getStraightToStraightController() {
		if (straightToStraightController == null) {
			straightToStraightController = new StraightToStraightController(game);
		}

		return straightToStraightController;
	}

	public SuitToStraightController getSuitToStraightController() {
		if (suitToStraightController == null) {
			suitToStraightController = new SuitToStraightController(game);
		}

		return suitToStraightController;
	}

	public TurnOverController getTurnOverController() {
		if (turnOverController == null) {
			turnOverController = new TurnOverController(game);
		}

		return turnOverController;
	}

}

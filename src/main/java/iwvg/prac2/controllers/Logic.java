package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.Option;

public class Logic {
	private Game game;
	
	private StartController startController;
	
	private MoveControllerFactory moveControllerFactory;

	private ExitController exitController;
	
	private ContinueController continueController;
	
	public Logic() {
		game = new Game();
		startController = new StartController(game);
		moveControllerFactory = new moveControllerFactory(game);
		exitController = new ExitController(game);
		continueController = new ContinueController(game);
	}
	
	public Controller getController(Option option){
		//Tenemos tantos controladores como funcionalidades
		//Un controlador por cada caso de uso (accion)
		
		switch(option){
			case START:
				return startController;
			case MOVE_DECK_TO_DISCARD: 
				return moveControllerFactory.getDeckToDiscardController();
			case MOVE_DISCARD_TO_DECK: 
				return moveControllerFactory.getDiscardToDeckController();
			case MOVE_DISCARD_TO_SUIT:
				return moveControllerFactory.getDiscardToSuitController();
			case MOVE_DISCARD_TO_STRAIGHT:
				return moveControllerFactory.getDiscardToStraightController();
			case MOVE_STRAIGHT_TO_SUIT:
				return moveControllerFactory.getStraightToSuitController();
			case MOVE_STRAIGHT_TO_STRAIGHT:
				return moveControllerFactory.getStraightToStraightController();
			case MOVE_SUIT_TO_STRAIGHT:
				return moveControllerFactory.getSuitToStraightController();
			case TURN_OVER:
				return moveControllerFactory.getTurnOverController();
			case EXIT:
				return exitController;
			case CONTINUE:
				return continueController;
			case EXIT_ALL:
			default:
				return null;
		}
	}
}

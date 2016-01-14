package iwvg.prac2.controllers;

import iwvg.prac2.utils.Option;

public interface OperationControllerVisitor {

	Option visit(StartController startController);
	
	Option visit(DeckToDiscardController deckToDiscardController);
	
	Option visit(DiscardToDeckController discardToDeckController);
	
	Option visit(DiscardToSuitController discardToSuitController);
	
	Option visit(DiscardToStraightController discardToStraightController);
	
	Option visit(StraightToSuitController straightToSuitController);
	
	Option visit(StraightToStraightController straightToStraightController);
	
	Option visit(SuitToStraightController suitToStraightController);
	
	Option visit(TurnOverController turnOverController);
	
	Option visit(ContinueController continueController);
	
	Option visit(ExitController exitController);

}

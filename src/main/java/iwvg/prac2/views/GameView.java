package iwvg.prac2.views;

import iwvg.prac2.controllers.DeckToDiscardController;
import iwvg.prac2.controllers.DiscardToDeckController;
import iwvg.prac2.controllers.DiscardToStraightController;
import iwvg.prac2.controllers.DiscardToSuitController;
import iwvg.prac2.controllers.MoveController;
import iwvg.prac2.controllers.MoveControllerVisitor;
import iwvg.prac2.controllers.StraightToStraightController;
import iwvg.prac2.controllers.StraightToSuitController;
import iwvg.prac2.controllers.SuitToStraightController;
import iwvg.prac2.controllers.TurnOverController;
import iwvg.prac2.utils.Option;

public class GameView implements MoveControllerVisitor {

	private DeckToDiscardView deckToDiscardView;

	private DiscardToDeckView discardToDeckView;

	private DiscardToSuitView discardToSuitView;

	private DiscardToStraightView discardToStraightView;

	private StraightToSuitView straightToSuitView;

	private StraightToStraightView straightToStraightView;

	private SuitToStraightView suitToStraightView;

	private TurnOverView turnOverView;

	public Option interact(MoveController moveController) {
		assert moveController != null;
		return moveController.accept(this);
	}

	@Override
	public Option visit(DeckToDiscardController deckToDiscardController) {
		return deckToDiscardView.interact(deckToDiscardController);
	}

	@Override
	public Option visit(DiscardToDeckController discardToDeckController) {
		return discardToDeckView.interact(discardToDeckController);
	}

	@Override
	public Option visit(DiscardToSuitController discardToSuitController) {
		return discardToSuitView.interact(discardToSuitController);
	}

	@Override
	public Option visit(DiscardToStraightController discardToStraightController) {
		return discardToStraightView.interact(discardToStraightController);
	}

	@Override
	public Option visit(StraightToSuitController straightToSuitController) {
		return straightToSuitView.interact(straightToSuitController);
	}

	@Override
	public Option visit(StraightToStraightController straightToStraightController) {
		return straightToStraightView.interact(straightToStraightController);
	}

	@Override
	public Option visit(SuitToStraightController suitToStraightController) {
		return suitToStraightView.interact(suitToStraightController);
	}

	@Override
	public Option visit(TurnOverController turnOverController) {
		return turnOverView.interact(turnOverController);
	}

}

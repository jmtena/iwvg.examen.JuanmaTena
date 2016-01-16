package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.Option;

public class DiscardToDeckController extends MoveController {

	public DiscardToDeckController(Game game) {
		super(game);
	}

	public Error move() {
		Position origin = Position.DISCARD;
		Position destiny = Position.DECK;
		return this.game.moveCard(origin, destiny);
	}

	@Override
	public Option accept(OperationControllerVisitor controllerVisitor) {
		return controllerVisitor.visit(this);
	}

	@Override
	public Option accept(MoveControllerVisitor moveControllerVisitor) {
		return moveControllerVisitor.visit(this);
	}

}

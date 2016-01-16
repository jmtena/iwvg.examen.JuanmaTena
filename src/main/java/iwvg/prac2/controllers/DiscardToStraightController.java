package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.LimitedIntDialog;
import iwvg.prac2.utils.Option;

public class DiscardToStraightController extends MoveController {

	public DiscardToStraightController(Game game) {
		super(game);
	}

	public Error move() {
		Position origin = Position.DISCARD;
		Position destiny;

		int option = new LimitedIntDialog("A que escalera desea mover?", 1, 7).read();
		destiny = this.game.getPile(option);

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

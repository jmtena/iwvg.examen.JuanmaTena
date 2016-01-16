package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.LimitedIntDialog;
import iwvg.prac2.utils.Option;

public class StraightToSuitController extends MoveController {

	public StraightToSuitController(Game game) {
		super(game);
	}

	public Error move() {
		Position origin;
		Position destiny;

		int option_origin = new LimitedIntDialog("De que escalera desea mover?", 1, 7).read();
		int option_destiny = new LimitedIntDialog("A que palo desea mover [1.Picas 2.Corazones 3.Rombos 4.Treboles]?",
				1, 4).read();

		origin = this.game.getPile(option_origin);
		destiny = this.game.getSuit(option_destiny);

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

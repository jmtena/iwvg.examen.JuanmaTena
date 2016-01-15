package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.Option;

public class DeckToDiscardController extends MoveController{

	public DeckToDiscardController(Game game) {
		super(game);
	}
	
	public Error move(){
		Position origin = Position.DECK;
		Position destiny = Position.DISCARD;
		return this.game.moveCard(origin,destiny);
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

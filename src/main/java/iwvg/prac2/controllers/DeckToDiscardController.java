package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.Option;

public class DeckToDiscardController extends MoveController{

	public DeckToDiscardController(Game game) {
		super(game);
		
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

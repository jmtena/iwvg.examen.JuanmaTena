package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.LimitedIntDialog;
import iwvg.prac2.utils.Option;

public class TurnOverController extends MoveController{

	public TurnOverController(Game game) {
		super(game);
	}
	
	public Error move(){
		Position pos;
		
		int option = new LimitedIntDialog("En que escalera desea voltear la carta?", 1, 7).read();
		pos = this.game.getPile(option);
		
		return this.game.turnOverCard(pos);
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

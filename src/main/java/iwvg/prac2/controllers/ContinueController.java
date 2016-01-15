package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.Option;

public class ContinueController extends Controller{

	public ContinueController(Game game){
		super(game);
	}
	
	@Override
	public Option accept(OperationControllerVisitor controllerVisitor) {
		return controllerVisitor.visit(this);
	}
}

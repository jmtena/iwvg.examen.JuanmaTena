package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.Option;

public abstract class MoveController extends Controller implements MoveOperationController{
	
	public MoveController(Game game){
		super(game);
	}
	
}

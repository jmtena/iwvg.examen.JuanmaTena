package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.Option;

public class StartController extends Controller{
	
	public StartController(Game game){
		super(game);
	}
	
	public void start(){
		//Barajar
		this.game.shuffle();
		
		//Repartir cartas
		this.game.distribute();
	}

	@Override
	public Option accept(ControllerVisitor controllerVisitor) {
		return controllerVisitor.visit(this);
	}

}

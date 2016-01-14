package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;

public abstract class Controller implements OperationController{
		
	private Game game;
	
	public Controller (Game game){
		this.game = game;
	}
	
	
}

package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.SetOfCards;

public abstract class Controller implements OperationController{
	
	protected Game game;
	
	public Controller (Game game){
		assert game != null;
		this.game = game;
	}
	
	public SetOfCards getDeck(){
		return game.getDeck();
	}
	
	public SetOfCards getDiscard(){
		return game.getDiscard();
	}
	
	public SetOfCards getSpadesPile(){
		return game.getSpadesPile();
	}

	public SetOfCards getHeartsPile(){
		return game.getHeartsPile();
	}
	
	public SetOfCards getDiamondsPile(){
		return game.getDiamondsPile();
	}

	public SetOfCards getClubsPile(){
		return game.getClubsPile();
	}

	public SetOfCards getStraight(int pos){
		return game.getStraight(pos);
	}
	
}

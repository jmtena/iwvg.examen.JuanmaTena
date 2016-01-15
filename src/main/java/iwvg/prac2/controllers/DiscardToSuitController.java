package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.models.Position;
import iwvg.prac2.utils.LimitedIntDialog;
import iwvg.prac2.utils.Option;

public class DiscardToSuitController extends MoveController{

	public DiscardToSuitController(Game game) {
		super(game);
	}
	
	public Error move(){
		Position origin = Position.DISCARD;
		Position destiny;
		
		int option = new LimitedIntDialog("A que palo desea mover [1.Picas 2.Corazones 3.Rombos 4.Treboles]?", 1, 4).read();
		destiny = getSuit(option);
		
		return this.game.moveCard(origin,destiny);
	}
	
	private Position getSuit(int option){
		switch(option){
			case 1:
				return Position.SPADES;
			case 2:
				return Position.HEARTS;
			case 3:
				return Position.DIAMONDS;
			case 4:
				return Position.CLUBS;
			default:
				return null;
		}
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

package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class HelpController extends Controller{

	public HelpController(Game game) {
		super(game);
	}
	
	public void showHelp(){
		game.showPossibleMoves();
		
		IO io = new IO();
		io.readString("[continuar]");
	}

	@Override
	public Option accept(OperationControllerVisitor controllerVisitor) {
		return controllerVisitor.visit(this);
	}
	
}

package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.Option;
import iwvg.prac2.utils.YesNoDialog;

public class ExitController extends Controller{

	public ExitController(Game game){
		super(game);
	}
	
	public boolean confirmExit(){
		YesNoDialog dialog = new YesNoDialog("Desea salir del juego");
		return dialog.read();
	}

	@Override
	public Option accept(OperationControllerVisitor controllerVisitor) {
		return controllerVisitor.visit(this);
	}
}

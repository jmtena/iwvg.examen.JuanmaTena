package iwvg.prac2.views;

import iwvg.prac2.controllers.DiscardToSuitController;
import iwvg.prac2.controllers.Error;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;
import iwvg.prac2.utils.YesNoDialog;

public class DiscardToSuitView {
	
	public Option interact(DiscardToSuitController discardToSuitController) {
		assert discardToSuitController != null;
		Error error = discardToSuitController.move();
		boolean finished = discardToSuitController.isGameFinished();
		
		IO io = new IO();
		
		if (finished){
			//Comprobamos si se termina el juego al pasar una carta a palo
			io.writeln("Enhorabuena!!! Ha completado el solitario");
			YesNoDialog dialog = new YesNoDialog("Desea empezar un juego nuevo");
			boolean startNewGame = dialog.read();
			if (startNewGame){
				return Option.START;
			}
			else{
				return Option.EXIT_ALL;
			}
		}
		else if (error == null){
			RugView rugView = new RugView(discardToSuitController);
			rugView.write();
			return rugView.read();
		}
		else{
			io.write("ERROR!!! " + error.toString());
			
			MenuView optionMenu = new MenuView();
			return optionMenu.read();
		}

	}
	
}

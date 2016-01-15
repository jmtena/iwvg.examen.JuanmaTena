package iwvg.prac2.views;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.controllers.TurnOverController;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class TurnOverView {

public Option interact(TurnOverController turnOverController) {
		
		Error error = turnOverController.move();
		
		if (error == null){
			RugView rugView = new RugView(turnOverController);
			rugView.write();
			return rugView.read();
		}
		else{
			IO io = new IO();
			io.write("ERROR!!! " + error.toString());
			
			MenuView optionMenu = new MenuView();
			return optionMenu.read();
		}

	}
	
}

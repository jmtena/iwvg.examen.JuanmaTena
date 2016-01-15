package iwvg.prac2.views;

import iwvg.prac2.controllers.DiscardToSuitController;
import iwvg.prac2.controllers.Error;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class DiscardToSuitView {
	
	public Option interact(DiscardToSuitController discardToSuitController) {
		
		Error error = discardToSuitController.move();
		
		if (error == null){
			RugView rugView = new RugView(discardToSuitController);
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

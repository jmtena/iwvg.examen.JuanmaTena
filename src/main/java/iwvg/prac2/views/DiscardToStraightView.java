package iwvg.prac2.views;

import iwvg.prac2.controllers.DiscardToStraightController;
import iwvg.prac2.controllers.Error;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class DiscardToStraightView {
	
	public Option interact(DiscardToStraightController discardToStraightController) {
		
		Error error = discardToStraightController.move();
		
		if (error == null){
			RugView rugView = new RugView(discardToStraightController);
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

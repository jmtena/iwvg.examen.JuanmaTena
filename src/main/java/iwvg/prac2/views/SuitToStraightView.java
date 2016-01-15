package iwvg.prac2.views;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.controllers.SuitToStraightController;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class SuitToStraightView {
	
	public Option interact(SuitToStraightController suitToStraightController) {
		
		Error error = suitToStraightController.move();
		
		if (error == null){
			RugView rugView = new RugView(suitToStraightController);
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

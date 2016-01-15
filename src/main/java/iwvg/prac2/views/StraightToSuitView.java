package iwvg.prac2.views;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.controllers.StraightToSuitController;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class StraightToSuitView {

	public Option interact(StraightToSuitController straightToSuitController) {
		assert straightToSuitController != null;
		Error error = straightToSuitController.move();
		
		if (error == null){
			RugView rugView = new RugView(straightToSuitController);
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

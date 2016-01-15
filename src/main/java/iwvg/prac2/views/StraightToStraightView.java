package iwvg.prac2.views;

import iwvg.prac2.controllers.Error;
import iwvg.prac2.controllers.StraightToStraightController;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class StraightToStraightView {
	
	public Option interact(StraightToStraightController straightToStraightController) {
		assert straightToStraightController != null;
		Error error = straightToStraightController.move();
		
		if (error == null){
			RugView rugView = new RugView(straightToStraightController);
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

package iwvg.prac2.views;

import iwvg.prac2.controllers.ExitController;
import iwvg.prac2.utils.Option;

public class ExitView {

	public Option interact(ExitController exitController){
		assert exitController != null;
		boolean exit = exitController.confirmExit();
		
		if (exit){
			return Option.EXIT_ALL;
		}
		else{
			return Option.CONTINUE;
		}
	}
	
}

package iwvg.prac2.views;

import iwvg.prac2.controllers.ContinueController;
import iwvg.prac2.utils.Option;

public class ContinueView {

	public Option interact(ContinueController continueController){		
		RugView rugView = new RugView(continueController);
		rugView.write();
		return rugView.read();
	}
	
}

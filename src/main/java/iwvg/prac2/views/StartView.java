package iwvg.prac2.views;

import iwvg.prac2.controllers.StartController;
import iwvg.prac2.utils.Option;

public class StartView{
	
	public Option interact(StartController startController){		
		startController.start();
		
		RugView rugView = new RugView(startController);
		rugView.write();
		return rugView.read();
	}
}

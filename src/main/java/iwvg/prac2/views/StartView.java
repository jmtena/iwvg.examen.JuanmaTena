package iwvg.prac2.views;

import iwvg.prac2.controllers.StartController;

public class StartView {
	
	void interact(StartController startController){
		new RugView(startController).write;
	}
}

package iwvg.prac2.views;

import iwvg.prac2.controllers.StartController;
import iwvg.prac2.utils.IO;

public class StartView {
	
	void interact(StartController startController){
		IO io = new IO();
		
		io.writeln("JUEGO NUEVO");
		new RugView(startController).write();
	}
}

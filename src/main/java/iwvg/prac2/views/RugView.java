package iwvg.prac2.views;

import iwvg.prac2.controllers.Controller;
import iwvg.prac2.models.Game;
import iwvg.prac2.utils.IO;

public class RugView {
	
	private Controller controller;
	
	public RugView(Controller controller) {
		assert controller != null;
		this.controller = controller;
	}
	
	public void write(){
		IO io = new IO();
		
		io.writeln("===========================");
		io.write("Baraja: ");
		
		io.write("Descarte: ");
		
		io.write("Picas: ");
		
		io.write("Corazones: ");
		
		io.write("Rombos: ");
		
		io.write("Treboles");
		
		for (int i=0; i<Game.getNumStraights(); i++){
			io.write("Escalera " + i + ": ");
		}			
	}

}

package iwvg.prac2.views;

import iwvg.prac2.controllers.Controller;
import iwvg.prac2.models.Game;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

class RugView {
	
	private Controller controller;
	
	private MenuView optionMenu;
	
	public RugView(Controller controller) {
		assert controller != null;
		this.controller = controller;
	}
	
	public void write(){
		IO io = new IO();
		
		io.writeln("===========================");
		io.write("Baraja: " + (controller.getDeck().getLength()==0 ? "<vacio>":"[X,X]"));
		io.write("Descarte: " + controller.getDiscard().toString());
		io.write("Picas: " + controller.getSpadesPile().toString());
		io.write("Corazones: " + controller.getHeartsPile().toString());
		io.write("Rombos: " + controller.getDiamondsPile().toString());
		io.write("Treboles" + controller.getClubsPile().toString());
		
		for (int i=0; i<Game.getNumStraights(); i++){
			io.write("Escalera " + (i+1) + ": " + controller.getStraight(i).toString());
		}
		
		optionMenu = new MenuView();
		optionMenu.write();
	}
	
	public Option read(){
		return optionMenu.read();
	}

}

package iwvg.prac2.views;

import iwvg.prac2.controllers.DeckToDiscardController;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;
import iwvg.prac2.controllers.Error;

public class DeckToDiscardView {
	
	public Option interact(DeckToDiscardController deckToDiscardController) {
		assert deckToDiscardController != null;
		Error error = deckToDiscardController.move();
		
		if (error == null){
			RugView rugView = new RugView(deckToDiscardController);
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

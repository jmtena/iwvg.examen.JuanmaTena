package iwvg.prac2.views;

import iwvg.prac2.controllers.DiscardToDeckController;
import iwvg.prac2.controllers.Error;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.Option;

public class DiscardToDeckView {

	public Option interact(DiscardToDeckController discardToDeckController) {
		assert discardToDeckController != null;
		Error error = discardToDeckController.move();

		if (error == null) {
			RugView rugView = new RugView(discardToDeckController);
			rugView.write();
			return rugView.read();
		} else {
			IO io = new IO();
			io.write("ERROR!!! " + error.toString());
			return new MenuView().read();
		}
	}

}

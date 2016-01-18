package iwvg.prac2.views;

import iwvg.prac2.controllers.HelpController;
import iwvg.prac2.utils.Option;

public class HelpView {

	public Option interact(HelpController helpController) {
		assert helpController != null;

		helpController.showHelp();
		
		RugView rugView = new RugView(helpController);
		rugView.write();
		return rugView.read();
	}
	
}

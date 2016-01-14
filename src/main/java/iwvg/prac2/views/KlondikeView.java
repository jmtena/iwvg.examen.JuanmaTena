package iwvg.prac2.views;

import iwvg.prac2.controllers.ContinueController;
import iwvg.prac2.controllers.Controller;
import iwvg.prac2.controllers.ControllerVisitor;
import iwvg.prac2.controllers.ExitController;
import iwvg.prac2.controllers.MoveController;
import iwvg.prac2.controllers.StartController;
import iwvg.prac2.utils.Option;

public class KlondikeView implements ControllerVisitor, View{
	
	private StartView startView;
	
	private GameView gameView;
	
	private ContinueView continueView;
	
	private ExitView exitView;
	
	
	public KlondikeView(){
		startView = new StartView();
		gameView = new GameView();
		continueView = new ContinueView();
		exitView = new ExitView();
	}
	
	@Override
	public Option interact(Controller controller){
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}

	@Override
	public void visit(MoveController moveController) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ContinueController continueController) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExitController exitController) {
		// TODO Auto-generated method stub
		
	}	
	
}

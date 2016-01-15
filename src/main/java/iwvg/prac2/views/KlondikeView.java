package iwvg.prac2.views;

import iwvg.prac2.controllers.ContinueController;
import iwvg.prac2.controllers.Controller;
import iwvg.prac2.controllers.OperationControllerVisitor;
import iwvg.prac2.controllers.ExitController;
import iwvg.prac2.controllers.MoveController;
import iwvg.prac2.controllers.StartController;
import iwvg.prac2.utils.Option;

public class KlondikeView implements OperationControllerVisitor, View{
	
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
		return controller.accept(this);
	}

	@Override
	public Option visit(StartController startController) {
		return startView.interact(startController);
	}

	@Override
	public Option visit(MoveController moveController) {
		return gameView.interact(moveController);
	}

	@Override
	public Option visit(ContinueController continueController) {
		return continueView.interact(continueController);
	}

	@Override
	public Option visit(ExitController exitController) {
		return exitView.interact(exitController);
	}
	
	
	
}

package iwvg.prac2.controllers;

public interface ControllerVisitor {

	void visit(StartController startController);
	
	void visit(MoveController moveController);
	
	void visit(ContinueController continueController);
	
	void visit(ExitController exitController);

}

package iwvg.prac2.controllers;

import iwvg.prac2.utils.Option;

public interface OperationControllerVisitor {

	Option visit(StartController startController);

	Option visit(MoveController moveController);

	Option visit(ContinueController continueController);

	Option visit(ExitController exitController);

}

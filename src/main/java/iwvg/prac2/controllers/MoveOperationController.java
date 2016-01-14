package iwvg.prac2.controllers;

import iwvg.prac2.utils.Option;

public interface MoveOperationController {

	Option accept(MoveControllerVisitor moveControllerVisitor);
	
}

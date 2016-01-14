package iwvg.prac2.controllers;

public class StartController extends Controller{

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}

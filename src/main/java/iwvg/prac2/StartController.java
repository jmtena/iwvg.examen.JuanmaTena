package iwvg.prac2;

public class StartController extends Controller {
	MoveControllerFactory colocateControllerFactory;
	
	protected StartController(Rug rug, MoveControllerFactory colocateControllerFactory) {
		super(rug);
		this.colocateControllerFactory = colocateControllerFactory;
	}

}

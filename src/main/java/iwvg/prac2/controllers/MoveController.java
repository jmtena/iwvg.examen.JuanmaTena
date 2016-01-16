package iwvg.prac2.controllers;

import iwvg.prac2.models.Game;

public abstract class MoveController extends Controller implements MoveOperationController {

	protected MoveController(Game game) {
		super(game);
	}

}

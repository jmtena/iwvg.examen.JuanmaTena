package iwvg.prac2.views;

public class GameView {
	private MoveControllerFactory moveControllerFactory;

	public GameView(MoveControllerFactory moveControllerFactory) {
		this.moveControllerFactory = moveControllerFactory;
	}
	
	public void render(){
		MoveController controller;
		do {
			controller = moveControllerFactory.getController();
			if (controller != null) {
				controller.recibir(this);
			}
		} while (controller != null);
	}
	
	public void atender(MoveControllerFactory moveControllerFactory){
		new MoveView(moveController).render();
	}
}

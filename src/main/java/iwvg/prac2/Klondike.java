package iwvg.prac2;

public class Klondike {
	
	private Logic logic;
	
	private KlondikeView view;
	
	public Klondike(){
		logic = new Logic();
		view = new KlondikeView();
	}
	
	public void play() {
		Controller controller;
		do {
			controller = logic.getController();
			if (controller != null){
				view.interact(controller);
			}
		} while (controller != null);
	}
	
	public static void main(String[] args) {
		new Klondike().play();
	}
	
}

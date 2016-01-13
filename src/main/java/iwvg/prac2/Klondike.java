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
		Option option = Option.START;
		do {
			controller = logic.getController(option);
			if (controller != null){
				option = view.interact(controller);
			}
		} while (controller != null);
	}
	
	public static void main(String[] args) {
		new Klondike().play();
	}
	
}

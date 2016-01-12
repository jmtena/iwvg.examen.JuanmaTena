package iwvg.prac2;

public class Klondike {
	public static int NUM_SUITS = 4;
	public static int NUM_STRAIGHTS = 7;
	
	private Rug rug;
	
	private StartController startController;
	
	private MoveControllerFactory colocateControllerFactory;
	
	private StartView startView;
	
	private GameView gameView;
	
	public Klondike(){
		Rug rug = new Rug();
		colocateControllerFactory = new MoveControllerFactory(rug);
		gameView = new GameView(colocateControllerFactory);
		startController = new StartController(rug, colocateControllerFactory);
		startView = new StartView(startController);
	}
	
	public void play() {
		startView.render();
		gameView.render();
	}
	
	public static void main(String[] args) {
		new Klondike().play();
	}
	
}

package iwvg.prac2;

public class MoveView {
	private static int MIN_OPTION;
	private static int MAX_OPTION;
	
	public MoveView(Rug rug, MoveControllerFactory moveControllerFactory){
		IO io = new IO(rug);
		io.prinScreen();
		int option;
		int origin;
		int destination;
		do{
			option = io.readOption();
			switch(option){
				case 3:
					destination = io.readSuit();
				case 4:
					destination = io.readStraight();
				case 5:
					origin = io.readStraight();
					destination = io.readSuit();
				case 6:
					origin = io.readStraight();
					destination = io.readStraight();
				case 7:
					origin = io.readSuit();
					destination = io.readStraight();
			}
		}while(dentroDeRango(option));
		
		moveControllerFactory.setSelectedMoveController(option, origin, destination);
	}
	
	private boolean dentroDeRango(int option){
		return option>=MIN_OPTION && option <= MAX_OPTION;
	}
}

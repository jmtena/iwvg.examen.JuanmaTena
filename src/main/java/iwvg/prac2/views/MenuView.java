package iwvg.prac2.views;

import iwvg.prac2.models.Game;
import iwvg.prac2.utils.IO;
import iwvg.prac2.utils.LimitedIntDialog;
import iwvg.prac2.utils.Option;

public class MenuView {
	
	private int numOptions;
	
	public MenuView(){
		numOptions = Game.getNumOptions();
	}
	
	public void write(){
		IO io = new IO();
		
		io.writeln("---------------------------");
		io.writeln("1. Mover de baraja a descarte");
		io.writeln("2. Mover de descarte a baraja");
		io.writeln("3. Mover de descarte a palo");
		io.writeln("4. Mover de descarte a escalera");
		io.writeln("5. Mover de escalera a palo");
		io.writeln("6. Mover de escalera a escalera");
		io.writeln("7. Mover de palo a escalera");
		io.writeln("8. Voltear en escalera");
		io.writeln("9. Salir");		
	}
	
	public Option read(){
		int option = new LimitedIntDialog("Opción?", 1, numOptions).read();	
		switch(option){
			case 1:
				return Option.MOVE_DECK_TO_DISCARD;
			case 2:
				return Option.MOVE_DISCARD_TO_DECK;
			case 3:
				return Option.MOVE_DISCARD_TO_SUIT;
			case 4:
				return Option.MOVE_DISCARD_TO_STRAIGHT;
			case 5:
				return Option.MOVE_STRAIGHT_TO_SUIT;
			case 6:
				return Option.MOVE_STRAIGHT_TO_STRAIGHT;
			case 7:
				return Option.MOVE_SUIT_TO_STRAIGHT;
			case 8:
				return Option.TURN_OVER;
			case 9:
				return Option.EXIT;
			default:
				return null;
		}
	}
	
}

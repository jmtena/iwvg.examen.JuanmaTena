package iwvg.prac2;

public class Position {
	private Pile pile;
	private int pos;
	
	public Position(Pile pile, int pos){
		this.pile = pile;
		this.pos = pos;
	}

	public Pile getPile() {
		return pile;
	}

	public int getPos() {
		return pos;
	}
}

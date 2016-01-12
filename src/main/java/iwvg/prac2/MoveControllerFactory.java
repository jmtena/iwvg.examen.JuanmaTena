package iwvg.prac2;

public class MoveControllerFactory {
	private Rug rug;
	
	private MoveController moveFromDeckController;
	
	private MoveController moveFromDiscardController;
	
	private MoveController[] moveFromPileController;
	
	private MoveController[] moveFromStraightController;
	
	private MoveController moveInStraight;
	
	private MoveController selectedMoveController;
	
	public MoveControllerFactory(Rug rug){
		assert rug != null;
		
		this.rug = rug;
		moveFromPileController = new MoveController[Klondike.NUM_SUITS];
		moveFromStraightController = new MoveController[Klondike.NUM_STRAIGHTS];
	}
	
	public MoveController getController() {
		if (rug.complete())
			return null;
		
		new MoveView(rug,this);
		return selectedMoveController;
	}

	public MoveController getSelectedMoveController() {
		return selectedMoveController;
	}

	public void setSelectedMoveController(int option, int origin, int destination) {
		switch(option){
		case 1:
			this.selectedMoveController = this.moveFromDeckController;
		case 2:
			this.selectedMoveController = this.moveFromDiscardController;
		case 3:
			this.selectedMoveController = this.moveFromDiscardController;
		case 4:
			this.selectedMoveController = this.moveFromDiscardController;
		case 5:
			this.selectedMoveController = this.moveFromStraightController[origin];
		case 6:
			this.selectedMoveController = this.moveFromStraightController[origin];
		case 7:
			this.selectedMoveController = this.moveFromPileController[origin];
		case 8:
			this.selectedMoveController = this.moveInStraight;
		default:
			//Case 9
			break;
		}
	}
	
}

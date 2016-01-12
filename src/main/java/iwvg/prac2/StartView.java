package iwvg.prac2;

public class StartView {
	private StartController startController;
	
	public StartView(StartController startController){
		this.startController = startController;
	}
	
	public void render(){
		new RugView(startController.getRug()).render();
	}
}

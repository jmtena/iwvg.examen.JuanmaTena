package iwvg.prac2.views;

public class StartView {
	private StartController startController;
	
	public StartView(StartController startController){
		this.startController = startController;
	}
	
	public void render(){
		new RugView(startController.getRug()).render();
	}
}

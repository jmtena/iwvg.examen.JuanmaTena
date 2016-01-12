package iwvg.prac2;

public abstract class Controller {
	
	protected Rug rug;
	
	protected Controller(Rug rug){
		assert rug != null;
		this.rug = rug;
	}

	public RugForView getRug() {
		return rug;
	}
	
}


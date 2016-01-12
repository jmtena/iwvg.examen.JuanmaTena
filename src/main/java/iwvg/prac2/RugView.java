package iwvg.prac2;

public class RugView {
	private RugForView rug;

	public RugView(RugForView rug) {
		this.rug = rug;
	}

	public void render() {
		IO io = new IO();
		
		//Aqui se debe mostrar el tapete por pantalla
		io.write(rug);
	}
}

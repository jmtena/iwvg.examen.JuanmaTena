package iwvg.prac2.utils;

public class LimitedIntDialog {

	private String title;

	private ClosedInterval limits;

	public LimitedIntDialog(String title, int min, int max) {
		assert title != null;
		this.limits = new ClosedInterval(min, max);
		this.title = title + " " + limits + ": ";
	}

	public int read() {
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(title);
			ok = limits.includes(value);
			if (!ok) {
				io.writeln("ERROR!!! La opción debe ser entre " + limits + " inclusives");
			}
		} while (!ok);
		return value;
	}
}

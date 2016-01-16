package iwvg.prac2.models;

public enum Suit {
	SPADES("p"), // Picas
	HEARTS("c"), // Corazones
	DIAMONDS("r"), // Rombos
	CLUBS("t"); // Treboles

	private String message;

	private Suit(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}

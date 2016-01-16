package iwvg.prac2.models;

public enum CardNumber {
	ONE("1"), 
	TWO("2"), 
	THREE("3"), 
	FOUR("4"), 
	FIVE("5"), 
	SIX("6"), 
	SEVEN("7"), 
	EIGHT("8"), 
	NINE("9"), 
	TEN("10"), 
	JACK("J"), 
	QUEEN("Q"), 
	KING("K");

	private String message;

	private CardNumber(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}

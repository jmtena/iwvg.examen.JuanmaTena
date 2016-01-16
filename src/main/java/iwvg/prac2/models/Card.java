package iwvg.prac2.models;

import iwvg.prac2.utils.Color;
import iwvg.prac2.utils.Orientation;

public class Card {
	private Suit suit;
	private CardNumber number;
	private Color color;
	private Orientation orientation;

	public Card(Suit suit, CardNumber number, Orientation orientation) {
		assert suit != null;
		assert number != null;
		assert orientation != null;

		this.suit = suit;
		this.number = number;
		this.orientation = orientation;
	}

	public boolean isEqual(Card card) {
		assert card != null;
		return this.suit == card.getSuit() && this.number == card.getNumber();
	}

	public void turnOver() {
		orientation = (orientation == Orientation.FACE_DOWN) ? Orientation.FACE_UP : Orientation.FACE_DOWN;
	}

	public Suit getSuit() {
		return suit;
	}

	public CardNumber getNumber() {
		return number;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "[" + number.toString() + "," + suit.toString() + "]";
	}

}

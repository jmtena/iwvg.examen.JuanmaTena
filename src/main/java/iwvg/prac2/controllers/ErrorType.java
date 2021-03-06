package iwvg.prac2.controllers;

public enum ErrorType {

	NO_CARDS("No hay cartas para mover"), 
	NOT_ENOUGH_CARDS("No hay suficientes cartas para mover"), 
	CARD_FACE_DOWN("No se puede mover una carta boca abajo"), 
	CARD_FACE_UP("La carta ya esta boca arriba");

	private String message;

	private ErrorType(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}

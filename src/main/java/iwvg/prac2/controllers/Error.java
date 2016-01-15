package iwvg.prac2.controllers;

public enum Error {
	
	NO_CARDS("No hay cartas para mover"),
	CARD_FACE_DOWN("No se puede mover una carta boca abajo");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}

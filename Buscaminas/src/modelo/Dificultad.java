package modelo;

public enum Dificultad {
	FACIL (10),
	NORMAL(20),
	DIFICIL(30);
	
	private final int TAMANO;
	
	Dificultad (int TAMANO) {
		this.TAMANO = TAMANO;
	}
	
	public int getTamaño() {
		return TAMANO;
	}
}



package modelo;

public enum Dificultad {
	FACIL (8,8,10),
	NORMAL(16,16,40),
	DIFICIL(16,30,99);
	
	private final int FILAS;
	private final int COLUMNAS;
	private final int MINAS;
	
	
	Dificultad (int FILAS, int COLUMNAS, int MINAS) {
		this.FILAS = FILAS;
		this.COLUMNAS=COLUMNAS;
		this.MINAS=MINAS;
	}
	
	public int getFilas() {
        return FILAS;
    }

    public int getColumnas() {
        return COLUMNAS;
    }

    public int getMinas() {
        return MINAS;
    }
}



package modelo;

public enum Dificultad {
	FACIL (8,8,10,1),
	NORMAL(16,16,40,2),
	DIFICIL(16,30,99,3);
	
	private final int FILAS;
	private final int COLUMNAS;
	private final int MINAS;
	private final int COEFICIENTE;
	
	
	Dificultad (int FILAS, int COLUMNAS, int MINAS, int COEFICIENTE) {
		this.FILAS = FILAS;
		this.COLUMNAS=COLUMNAS;
		this.MINAS=MINAS;
		this.COEFICIENTE= COEFICIENTE;
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

	public int getCOEFICIENTE() {
		return COEFICIENTE;
	}
}



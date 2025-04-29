package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tablero {

	private Dificultad dificultad;
	private List<Celda>celdas;
	
	public Tablero(Dificultad dificultad) {
		this.dificultad=dificultad;
		this.celdas=new ArrayList<>();
		iniciarTablero();
	}
	
	public void iniciarTablero() {
		for(int i=0;i<dificultad.getFilas()*dificultad.getColumnas();i++) {
		celdas.add(new Celda());
		}
		colocarMinas();
		calcularMinasCercanas();
		
	}

	private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < dificultad.getMinas()) {
            int indice = random.nextInt(celdas.size());
            Celda celda = celdas.get(indice);
            if (!celda.esMina()) {
                celda.setMina(true);
                minasColocadas++;
            }
        }
    }
	
	private void calcularMinasCercanas() {
        for (int i = 0; i < celdas.size(); i++) {
            Celda celda = celdas.get(i);
            if (celda.esMina()) {
                continue;
            }
            int minasCerca = contarMinasCercanas(i);
            celda.setMinasCerca(minasCerca);
        }
    }
	
	private int contarMinasCercanas(int indice) {
        int minasCerca = 0;
        int filas = dificultad.getFilas();
        int columnas = dificultad.getColumnas();
        int[] direcciones = {-1, 0, 1};

        for (int i : direcciones) {
            for (int j : direcciones) {
                if (i == 0 && j == 0) {
                	continue;
                }

                int vecinoX = (indice / columnas) + i;
                int vecinoY = (indice % columnas) + j;

                if (vecinoX >= 0 && vecinoX < filas && vecinoY >= 0 && vecinoY < columnas) {
                    int vecinoIndice = vecinoX * columnas + vecinoY;
                    if (celdas.get(vecinoIndice).esMina()) {
                        minasCerca++;
                    }
                }
            }
        }
        return minasCerca;
    }
	
	public Celda obtenerCelda(int fila, int columna) {
        int indice = fila * dificultad.getColumnas() + columna;
        return celdas.get(indice);
    }
	
	public double calcularPuntos(int segundos) {
		int totalCeldas = dificultad.getFilas() * dificultad.getColumnas();
		int totalMinas = dificultad.getMinas();
		int coeficiente = dificultad.getCOEFICIENTE();
		int celdasSinMinas = totalCeldas - totalMinas;
		
		if(segundos==0) {
			return celdasSinMinas + coeficiente;
		}
		return (double)((celdasSinMinas*coeficiente))/segundos;
	}

    public List<Celda> getCeldas() {
        return celdas;
    }
	
	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	

}

package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario implements Comparable<Usuario> {
	private String nombre;
	private int puntos;

	public Usuario(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.puntos, this.puntos);
	}

	
	
}

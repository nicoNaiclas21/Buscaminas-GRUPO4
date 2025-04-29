package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario implements Comparable<Usuario> {
	private String nombre;
	private double puntos;

	public Usuario(String nombre, double puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return Double.compare(o.puntos, this.puntos);
	}

	
	
}

package modelo;

public class Celda {

	private boolean esMina;
	private boolean descubierta;
	private boolean marcada;
	private int minasCerca;
	
	public Celda() {
		this.esMina= false;
		this.descubierta= false;
		this.marcada=false;
		this.minasCerca=0;
	}
	
	public boolean esMina() {
		return esMina;
	}
	
	public void setMina(boolean esMina) {
		this.esMina=esMina;
	}
	
	public boolean estaDescubierta() {
		return descubierta;
	}
	
	public void decubrir() {
		this.descubierta=true;
	}
	
	public boolean esMarcada() {
		return marcada;
	}
	
	public void marcar() {
		this.marcada=true;
	}
	
	public int getMinasCerca() {
		return minasCerca;
	}
	
	public void setMinasCerca(int minasCerca) {
		this.minasCerca=minasCerca;
	}
	public void desmarcar() {
		this.marcada=false;
	}
}

package controlador;

import vista.VentanaJuego;
import vista.VentanaMenu;

public class Main {

	private static VentanaMenu ventanaMenu;
	private static VentanaJuego ventanaJuego;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ventanaMenu = new VentanaMenu();
		ventanaMenu.setVisible(true);
	}

	public static void abrirJuegoYCerrarMenu() {
		ventanaMenu.setVisible(false);
		ventanaJuego = new VentanaJuego();
		ventanaJuego.setVisible(true);
	}
}

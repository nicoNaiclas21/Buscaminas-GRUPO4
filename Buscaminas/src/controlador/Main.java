package controlador;

import modelo.Dificultad;
import modelo.SoundPlayer;
import vista.VentanaJuego;
import vista.VentanaMenu;

public class Main {

	private static VentanaMenu ventanaMenu;
	private static VentanaJuego ventanaJuego;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ventanaMenu = new VentanaMenu();
		ventanaMenu.setVisible(true);
		SoundPlayer soundPlayer = new SoundPlayer();
		soundPlayer.playLoop("src/images/main-theme-68815.wav", -6f);
	}

	public static void abrirJuegoYCerrarMenu(Dificultad dificultad) {
		ventanaMenu.setVisible(false);
		ventanaJuego = new VentanaJuego(dificultad);
		ventanaJuego.setVisible(true);
	}
}

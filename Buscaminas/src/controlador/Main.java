package controlador;

import java.util.List;

import modelo.Dificultad;
import modelo.Ranking;
import modelo.SoundPlayer;
import modelo.Usuario;
import vista.VentanaJuego;
import vista.VentanaMenu;
import vista.VentanaRanking;

public class Main {

	private static VentanaMenu ventanaMenu;
	private static VentanaJuego ventanaJuego;
	private static VentanaRanking ventanaRanking;
	private static Ranking ranking = new Ranking();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ventanaMenu = new VentanaMenu();
		ventanaMenu.setVisible(true);
		SoundPlayer soundPlayer = new SoundPlayer();
		soundPlayer.playLoop("src/images/main-theme-68815.wav", -6f);
	}

	public static void abrirJuegoYCerrarMenu(String nombre,Dificultad dificultad) {
		ventanaMenu.setVisible(false);
		ventanaJuego = new VentanaJuego(nombre,dificultad);
		ventanaJuego.setVisible(true);
	}
	
	public static void abrirRanking() {
		List<Usuario> top10 = ranking.getTop10();
		ventanaJuego.setVisible(false);
		ventanaRanking = new VentanaRanking(top10);
		ventanaRanking.setVisible(true);
	}
	
	public static Ranking getRanking() {
	    return ranking;
	}
}

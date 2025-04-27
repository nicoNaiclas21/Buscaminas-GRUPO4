package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ranking {
	
	private List<Usuario> usuarios;
	private final String RUTA= "src/ranking.txt";
	
	public Ranking() {
		usuarios = new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	private void cargarDesdeArchivo() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(RUTA));
			String linea;
			while((linea=in.readLine())!=null) {
				String[] partes = linea.split("\t");
				if(partes.length==2) {
					String nombre = partes[0];
					int puntos = Integer.parseInt(partes[1]);
					usuarios.add(new Usuario(nombre,puntos));	
				}
			}
		}catch(IOException e) {
			System.out.println("Error al leer el fichero");
		}finally {
			try {
				if(in!=null) {
					in.close();
				}
			}catch(IOException e) {
				System.out.println("Error al cerrar el reader");
			}
		}
		Collections.sort(usuarios);
	}
	
	private void guardarEnArchivo() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(RUTA));
			Iterator<Usuario> it = usuarios.iterator();
			while(it.hasNext()) {
				Usuario u = it.next();
				out.write(u.getNombre() + "\t" + u.getPuntos());
				out.newLine();
			}
		}catch(IOException e) {
			System.out.println("Error al escribir en el fichero");
		}finally {
			try {
				if(out!=null) {
					out.close();
				}
			}catch(IOException e) {
				System.out.println("Error al cerrar el writer");
			}
		}
	}
	
	public boolean agregarOActualizarUsuario(Usuario usuario) {
		for (Usuario u : usuarios) {
			if(u.getNombre().equalsIgnoreCase(usuario.getNombre())) {
				if(usuario.getPuntos()> u.getPuntos()) {
					u.setPuntos(usuario.getPuntos());
					Collections.sort(usuarios);
					guardarEnArchivo();
				}
				return false;
			}
		}
		
		usuarios.add(usuario);
		Collections.sort(usuarios);
		guardarEnArchivo();
		return true;
	}
	
	public boolean nombreExiste(String nombre) {
		return usuarios.stream().anyMatch(u -> u.getNombre().equalsIgnoreCase(nombre));
	}
	
	public List<Usuario> getTop10(){
		List<Usuario> top = new ArrayList<>();
		for(int i = 0; i<10;i++) {
			if(i <usuarios.size()) {
				top.add(usuarios.get(i));
			}
			else {
				top.add(new Usuario("no hay Jugador", -1));
			}
		}
		return top;
	}
	

}

package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controlador.Main;
import modelo.Celda;
import modelo.Dificultad;
import modelo.Ranking;
import modelo.SoundPlayer;
import modelo.Tablero;
import modelo.Usuario;

public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Dificultad dificultad;
    private Timer timer;
    private int segundos;
    private JLabel labelTiempoUno, labelTiempoDos, labelTiempoTres;
    private List<Celda> celdas;
    private Tablero tablero;
    private JPanel panelJuego;
    private JPanel panelTimer;
    private int banderasDisponibles;
    private JLabel labelBanderasUno, labelBanderasDos, labelBanderasTres;
    private JButton botonCarita;
    private String nombre;

	public VentanaJuego(String nombre,Dificultad dificultad) {
		setTitle("Buscaminas - " + dificultad);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(35*dificultad.getColumnas(), 35*dificultad.getFilas());
        setLocationRelativeTo(null);
        this.banderasDisponibles = dificultad.getMinas();
        
        this.dificultad = dificultad;
        this.tablero = new Tablero(dificultad);
        this.celdas = tablero.getCeldas();
        this.nombre=nombre;

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        panelTimer = new JPanel();
        panelTimer.setLayout(new BorderLayout());
        panelTimer.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        inicializarContadorBanderas();
        
        labelTiempoUno = new JLabel(new ImageIcon("src/images/time0.gif"));
        labelTiempoDos = new JLabel(new ImageIcon("src/images/time0.gif"));
        labelTiempoTres = new JLabel(new ImageIcon("src/images/time0.gif"));

        JPanel panelTiempo = new JPanel();
        panelTiempo.add(labelTiempoUno);
        panelTiempo.add(labelTiempoDos);
        panelTiempo.add(labelTiempoTres);
        
        panelTimer.add(panelTiempo, BorderLayout.EAST);
        
        ImageIcon iconCarita = new ImageIcon("src/images/caritaGuay.png");

	    Image img = iconCarita.getImage();
	    Image imgNuevo = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	    ImageIcon iconoNuevo = new ImageIcon(imgNuevo);
	
	    botonCarita = new JButton(iconoNuevo);
	
	    botonCarita.setPreferredSize(new Dimension(50, 50));
	
	    botonCarita.setBorderPainted(false);
	    botonCarita.setFocusPainted(false);
	    botonCarita.setContentAreaFilled(false);
        botonCarita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });
        JPanel panelCarita = new JPanel();
        panelCarita.setLayout(new BorderLayout());
        panelCarita.add(botonCarita, BorderLayout.CENTER);
        
        panelTimer.add(botonCarita, BorderLayout.CENTER);
        
        contentPane.add(panelTimer, BorderLayout.NORTH);
        
        panelJuego = new JPanel();
        panelJuego.setLayout(new GridLayout(dificultad.getFilas(), dificultad.getColumnas()));
        contentPane.add(panelJuego, BorderLayout.CENTER);
        
        for (int i = 0; i < celdas.size(); i++) {
            Celda celdaModelo = celdas.get(i);
            JButton boton = new JButton(new ImageIcon("src/images/blank.gif"));
            boton.setPreferredSize(new Dimension(35, 35));

            final int fila = i / dificultad.getColumnas();
            final int columna = i % dificultad.getColumnas();

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    revelarCelda(boton, fila, columna);
                    SoundPlayer.playOnce("src/images/kick.wav", -5f);

                }
            });
            boton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        marcarBandera(boton, fila, columna);
                        SoundPlayer.playOnce("src/images/kick.wav", -5f);

                    }
                }
            });

            panelJuego.add(boton);
        }
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                int centenas = segundos / 100;
                int decenas = (segundos % 100) / 10;
                int unidades = segundos % 10;
                labelTiempoUno.setIcon(new ImageIcon("src/images/time" + centenas + ".gif"));
                labelTiempoDos.setIcon(new ImageIcon("src/images/time" + decenas + ".gif"));
                labelTiempoTres.setIcon(new ImageIcon("src/images/time" + unidades + ".gif"));
            }
        });
        timer.start();
	}
	
	private void reiniciarJuego() {
		celdasCorrectamenteDestapadas=0;
        segundos = 0;
        labelTiempoUno.setIcon(new ImageIcon("src/images/time0.gif"));
        labelTiempoDos.setIcon(new ImageIcon("src/images/time0.gif"));
        labelTiempoTres.setIcon(new ImageIcon("src/images/time0.gif"));

        this.tablero = new Tablero(dificultad);
        this.celdas = tablero.getCeldas();
        panelJuego.removeAll();
        for (int i = 0; i < celdas.size(); i++) {
            JButton boton = new JButton(new ImageIcon("src/images/blank.gif"));
            boton.setPreferredSize(new Dimension(35, 35));

            final int fila = i / dificultad.getColumnas();
            final int columna = i % dificultad.getColumnas();

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    revelarCelda(boton, fila, columna);
                }
            });
            boton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        marcarBandera(boton, fila, columna);
                    }
                }
            });

            panelJuego.add(boton);
        }

        panelJuego.revalidate();
        panelJuego.repaint();
        banderasDisponibles = dificultad.getMinas();
        actualizarContadorBanderas();
        juegoTerminado = false;
        timer.start();
    }
	
	private boolean juegoTerminado = false;
	private int celdasCorrectamenteDestapadas=0;
	private int minasActivadas= 0;
	
	private void revelarCelda(JButton boton, int fila, int columna) {
		
		if (juegoTerminado) {
			return;
		}
	    Celda celda = tablero.obtenerCelda(fila, columna);

	    if (celda.estaDescubierta() || celda.esMarcada()) return;

	    celda.decubrir();

	    if (celda.esMina()) {
	        boton.setIcon(new ImageIcon("src/images/bombdeath.gif"));
	        boton.setDisabledIcon(boton.getIcon());
	        boton.setEnabled(false);
            SoundPlayer.playOnce("src/images/explosion.wav", -5f);

	        juegoTerminado=true;
	        timer.stop();
	        revelarTodoElTablero();
	        JOptionPane.showMessageDialog(this, "¡Has Perdido! Has activado una mina.", "Game Over", JOptionPane.ERROR_MESSAGE);
	        
	        minasActivadas++;
	        
	        Main.getRanking().agregarOActualizarUsuario(new Usuario(nombre,calcularPuntos()));
	        Main.abrirRanking();
	        return;
	    }

	    int minasCercanas = celda.getMinasCerca();
	    boton.setIcon(new ImageIcon("src/images/open" + minasCercanas + ".gif"));
	    boton.setDisabledIcon(boton.getIcon());
	    boton.setEnabled(false);

	    if (minasCercanas == 0) {
	        celda.esDescubiertaCorrectamente();
	        celdasCorrectamenteDestapadas++; 
	        revelarCeldasVacias(fila, columna);
	    }

	    if (minasCercanas > 0) {
	        celda.esDescubiertaCorrectamente();
	        celdasCorrectamenteDestapadas++; 
	    }
	}

	
	private void revelarTodoElTablero() {
	    for (int i = 0; i < celdas.size(); i++) {
	        Celda celda = celdas.get(i);
	        JButton boton = (JButton) panelJuego.getComponent(i);
	        
	        if (celda.esMina() && celda.esMarcada()) {
	            boton.setIcon(new ImageIcon("src/images/bombflagged.gif"));
	            boton.setDisabledIcon(boton.getIcon());

	        } else if (celda.esMina() && !celda.estaDescubierta()) {
	            boton.setIcon(new ImageIcon("src/images/bombrevealed.gif"));
	            boton.setDisabledIcon(boton.getIcon());

	        } else if (!celda.esMina() && celda.esMarcada() && !celda.estaDescubierta()) {
	            boton.setIcon(new ImageIcon("src/images/bombmisflagged.gif"));
	            boton.setDisabledIcon(boton.getIcon());
	            
	        }else if (celda.estaDescubierta()) {
	            boton.setDisabledIcon(boton.getIcon());
	        }


	        boton.setEnabled(false);
	    }
	}
	
	private void comprobarVictoria() {
	    boolean ganar = true;
	    for (Celda celda : celdas) {
	        if (!celda.esMina() && !celda.estaDescubierta()) {
	            ganar = false;
	            break;
	        }
	    }
	    if (ganar) {
	        juegoTerminado = true;
	        timer.stop();
	        JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado.", "You Win!", JOptionPane.INFORMATION_MESSAGE);
	        Ranking ranking = new Ranking();
	        ranking.agregarOActualizarUsuario(new Usuario(nombre, calcularPuntos()));
	        Main.abrirRanking();
	    }
	}


	
	private void marcarBandera(JButton boton, int fila, int columna) {
		if(juegoTerminado) {
			return;
		}
	    Celda celda = tablero.obtenerCelda(fila, columna);
	    
	    if (celda.estaDescubierta()) {
	    	return;
	    }
	    if (celda.esMarcada()) {
	    	celda.desmarcar();
	        boton.setIcon(new ImageIcon("src/images/blank.gif"));
	        banderasDisponibles++;
	    } else if (banderasDisponibles > 0) {
	            celda.marcar();
	            boton.setIcon(new ImageIcon("src/images/bombflagged.gif"));
	            banderasDisponibles--;
	    }
	    actualizarContadorBanderas();
	    
	}
	
	private void revelarCeldasVacias(int fila,int columna) {
		int filas = dificultad.getFilas();
		int columnas = dificultad.getColumnas();
		
		for(int i = -1; i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				int nuevaFila = fila+i;
				int nuevaCol = columna+j;
				
				if(nuevaFila >=0 && nuevaFila <filas && nuevaCol >= 0 && nuevaCol < columnas) {
					int ind = nuevaFila * columnas + nuevaCol;
					Celda celdaDeAlLado = tablero.obtenerCelda(nuevaFila, nuevaCol);
					JButton botonDeAlLado = (JButton) panelJuego.getComponent(ind);
					
					if (!celdaDeAlLado.estaDescubierta() && !celdaDeAlLado.esMina()) {
					    if (celdaDeAlLado.esMarcada()) {
					        celdaDeAlLado.desmarcar();
					        banderasDisponibles++;
					        actualizarContadorBanderas();
					    }

					    celdaDeAlLado.decubrir();
					    int minasCercanas = celdaDeAlLado.getMinasCerca();

					    botonDeAlLado.setEnabled(false);
					    botonDeAlLado.setDisabledIcon(new ImageIcon("src/images/open" + minasCercanas + ".gif"));
					    botonDeAlLado.setIcon(new ImageIcon("src/images/open" + minasCercanas + ".gif"));

					    if (minasCercanas == 0) {
					        revelarCeldasVacias(nuevaFila, nuevaCol);
					    }
					}

				}
			}
		}
		comprobarVictoria();
	}
	
	private void inicializarContadorBanderas() {
	    JPanel panelBanderas = new JPanel();
	    
	    labelBanderasUno = new JLabel(new ImageIcon("src/images/time" + (banderasDisponibles / 100) + ".gif"));
	    labelBanderasDos = new JLabel(new ImageIcon("src/images/time" + ((banderasDisponibles % 100) / 10) + ".gif"));
	    labelBanderasTres = new JLabel(new ImageIcon("src/images/time" + (banderasDisponibles % 10) + ".gif"));
	    
	    ImageIcon originalIcon = new ImageIcon("src/images/bandera.png");
	    Image img = originalIcon.getImage();
	    Image imgNuevo = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    ImageIcon iconNuevo = new ImageIcon(imgNuevo);

	    panelBanderas.add(new JLabel(iconNuevo));

	    panelBanderas.add(labelBanderasUno);
	    panelBanderas.add(labelBanderasDos);
	    panelBanderas.add(labelBanderasTres);
	    
	    panelTimer.add(panelBanderas, BorderLayout.WEST);
	}

	private void actualizarContadorBanderas() {
	    int centenas = banderasDisponibles / 100;
	    int decenas = (banderasDisponibles % 100) / 10;
	    int unidades = banderasDisponibles % 10;
	    
	    labelBanderasUno.setIcon(new ImageIcon("src/images/time" + centenas + ".gif"));
	    labelBanderasDos.setIcon(new ImageIcon("src/images/time" + decenas + ".gif"));
	    labelBanderasTres.setIcon(new ImageIcon("src/images/time" + unidades + ".gif"));
	}

	private int calcularPuntos() {
		int c = celdasCorrectamenteDestapadas;
		int m = minasActivadas;
		int d= dificultad.getCOEFICIENTE();
		int t= segundos;
		
		return ((c-m)*d)/t;
	}

}

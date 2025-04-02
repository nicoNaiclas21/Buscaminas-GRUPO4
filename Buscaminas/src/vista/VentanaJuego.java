package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import modelo.Celda;
import modelo.Dificultad;
import modelo.Tablero;

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

	public VentanaJuego(Dificultad dificultad) {
		setTitle("Buscaminas - " + dificultad);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(35*dificultad.getColumnas(), 35*dificultad.getFilas());
        setLocationRelativeTo(null);
        this.banderasDisponibles = dificultad.getMinas();
        
        this.dificultad = dificultad;
        this.tablero = new Tablero(dificultad);
        this.celdas = tablero.getCeldas();

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
	
	private void revelarCelda(JButton boton, int fila, int columna) {
        Celda celda = tablero.obtenerCelda(fila, columna);

        if (celda.esMina()) {
            boton.setIcon(new ImageIcon("src/images/bombdeath.gif"));
            revelarTodoElTablero();
            timer.stop();
        } else {
            int minasCercanas = celda.getMinasCerca();
            if (minasCercanas == 0) {
                boton.setIcon(new ImageIcon("src/images/open0.gif"));
            } else if (minasCercanas == 1) {
                boton.setIcon(new ImageIcon("src/images/open1.gif"));
            } else if (minasCercanas == 2) {
                boton.setIcon(new ImageIcon("src/images/open2.gif"));
            } else if (minasCercanas == 3) {
                boton.setIcon(new ImageIcon("src/images/open3.gif"));
            } else if (minasCercanas == 4) {
                boton.setIcon(new ImageIcon("src/images/open4.gif"));
            } else if (minasCercanas == 5) {
                boton.setIcon(new ImageIcon("src/images/open5.gif"));
            } else if (minasCercanas == 6) {
                boton.setIcon(new ImageIcon("src/images/open6.gif"));
            } else if (minasCercanas == 7) {
                boton.setIcon(new ImageIcon("src/images/open7.gif"));
            } else if (minasCercanas == 8) {
                boton.setIcon(new ImageIcon("src/images/open8.gif"));
            }
        }
        boton.setDisabledIcon(boton.getIcon());
        boton.setEnabled(false); 
    }
	
	private void revelarTodoElTablero() {
	    for (int i = 0; i < celdas.size(); i++) {
	        Celda celda = celdas.get(i);
	        JButton boton = (JButton) panelJuego.getComponent(i);
	        
	        if (celda.esMina()) {
	            if (boton.getIcon().toString().contains("bombdeath.gif")) {
	                continue;
	            }
	            boton.setIcon(new ImageIcon("src/images/bombrevealed.gif"));
	        } 
	        else if (celda.esMarcada()) {
	            boton.setIcon(new ImageIcon("src/images/bombmisflagged.gif"));
	        } 
	        else if (celda.getMinasCerca() > 0) {
	            String imagen = "src/images/open" + celda.getMinasCerca() + ".gif";
	            boton.setIcon(new ImageIcon(imagen));
	        }
	        else {
	            boton.setIcon(new ImageIcon("src/images/open0.gif"));
	        }
	        boton.setDisabledIcon(boton.getIcon());
	        boton.setEnabled(false);
	    }
	}
	
	private void marcarBandera(JButton boton, int fila, int columna) {
	    Celda celda = tablero.obtenerCelda(fila, columna);
	    
	    if (!celda.estaDescubierta()) {
	        if (celda.esMarcada()) {
	            celda.desmarcar();
	            boton.setIcon(new ImageIcon("src/images/blank.gif"));
	            banderasDisponibles++;
	        } else if (banderasDisponibles > 0) {
	            celda.marcar();
	            boton.setIcon(new ImageIcon("src/images/bombflagged.gif"));
	            banderasDisponibles--;
	        } else {
	            return;
	        }
	        actualizarContadorBanderas();
	    }
	}
	
	private void inicializarContadorBanderas() {
	    JPanel panelBanderas = new JPanel();
	    
	    labelBanderasUno = new JLabel(new ImageIcon("src/images/time" + (banderasDisponibles / 100) + ".gif"));
	    labelBanderasDos = new JLabel(new ImageIcon("src/images/time" + ((banderasDisponibles % 100) / 10) + ".gif"));
	    labelBanderasTres = new JLabel(new ImageIcon("src/images/time" + (banderasDisponibles % 10) + ".gif"));
	    
	    panelBanderas.add(new JLabel("Banderas:"));
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


}

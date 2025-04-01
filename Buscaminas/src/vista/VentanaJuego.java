package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

	public VentanaJuego(Dificultad dificultad) {
		setTitle("Buscaminas - " + dificultad);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(35*dificultad.getColumnas(), 35*dificultad.getFilas());
        setLocationRelativeTo(null);
        
        this.dificultad = dificultad;
        this.tablero = new Tablero(dificultad);
        this.celdas = tablero.getCeldas();

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        JPanel panelTimer = new JPanel();
        panelTimer.setLayout(new BorderLayout());
        panelTimer.setBorder(new EmptyBorder(5, 5, 5, 5));
        
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
        boton.setEnabled(false);
    }

}

package vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dificultad;

public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dificultad dificultad;

	public VentanaJuego(Dificultad dificultad) {
		setTitle("Buscaminas - " + dificultad);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(35*dificultad.getColumnas(), 35*dificultad.getFilas());
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(dificultad.getFilas(), dificultad.getColumnas()));
        ImageIcon celda = new ImageIcon("src/images/blank.gif");
        
        
        for(int i = 0; i< dificultad.getFilas()*dificultad.getColumnas();i++) {
        	JButton boton = new JButton(celda);
        	boton.setPreferredSize(new Dimension(35,35));
        	contentPane.add(boton);
        }
        
        add(contentPane);
		
	}

}

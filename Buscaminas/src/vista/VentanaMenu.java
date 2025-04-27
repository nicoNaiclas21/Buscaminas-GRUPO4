package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Main;
import modelo.Dificultad;
import modelo.SoundPlayer;
import modelo.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel labelDificultad; 
	private Dificultad dificultad;
	public VentanaMenu() {
		dificultad = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{41, 31, 28, 65, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_2 = new JLabel("BUSCAMINAS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Introduce tu nombre:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Dificultad:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		labelDificultad = new JLabel("");
		GridBagConstraints gbc_labelDificultad = new GridBagConstraints();
		gbc_labelDificultad.anchor = GridBagConstraints.WEST;
		gbc_labelDificultad.gridx = 1;
		gbc_labelDificultad.gridy = 0;
		panel.add(labelDificultad, gbc_labelDificultad);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Elige la dificultad");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton botonFacil = new JButton("FACIL");
		botonFacil.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		botonFacil.setBackground(new Color(153, 255, 102));
		botonFacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelDificultad.setText("Facil");
				SoundPlayer.playOnce("src/images/button-124476.wav", -5f);
				dificultad = Dificultad.FACIL;
			}
		});
		botonFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_botonFacil = new GridBagConstraints();
		gbc_botonFacil.insets = new Insets(0, 0, 0, 5);
		gbc_botonFacil.gridx = 0;
		gbc_botonFacil.gridy = 1;
		panel_1.add(botonFacil, gbc_botonFacil);
		
		JButton botonNormal = new JButton("NORMAL");
		botonNormal.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		botonNormal.setBackground(new Color(255, 255, 51));
		botonNormal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelDificultad.setText("Normal");
				SoundPlayer.playOnce("src/images/button-124476.wav", -5f);
				dificultad = Dificultad.NORMAL;
			}
		});
		GridBagConstraints gbc_botonNormal = new GridBagConstraints();
		gbc_botonNormal.insets = new Insets(0, 0, 0, 5);
		gbc_botonNormal.gridx = 1;
		gbc_botonNormal.gridy = 1;
		panel_1.add(botonNormal, gbc_botonNormal);
		
		JButton botonDificil = new JButton("DIFICIL");
		botonDificil.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 13));
		botonDificil.setBackground(new Color(255, 51, 51));
		botonDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelDificultad.setText("Dificil");
				SoundPlayer.playOnce("src/images/button-124476.wav", -5f);
				dificultad = Dificultad.DIFICIL;
			}
		});
		botonDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_botonDificil = new GridBagConstraints();
		gbc_botonDificil.gridx = 2;
		gbc_botonDificil.gridy = 1;
		panel_1.add(botonDificil, gbc_botonDificil);
		
		JButton botonJugar = new JButton("JUGAR");
		botonJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = textField.getText();
				if(dificultad==null) {
					dificultad = Dificultad.FACIL;
				}else {
                    SoundPlayer.playOnce("src/images/jugar.wav", -5f);
					Main.abrirJuegoYCerrarMenu(nombre,dificultad);
				}
			}
		});
		botonJugar.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		GridBagConstraints gbc_botonJugar = new GridBagConstraints();
		gbc_botonJugar.insets = new Insets(0, 0, 0, 5);
		gbc_botonJugar.gridx = 1;
		gbc_botonJugar.gridy = 4;
		contentPane.add(botonJugar, gbc_botonJugar);
	}

}

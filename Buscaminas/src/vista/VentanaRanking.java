package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaRanking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Usuario> usuarios;
	private JLabel[] nombres;
	private JLabel[] puntos;

	public VentanaRanking(List<Usuario> usuarios) {
		this.usuarios=usuarios;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 330, 0, 0};
		gbl_contentPane.rowHeights = new int[]{43, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Ranking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		nombres = new JLabel[10];
        puntos = new JLabel[10];
        
        for (int i = 0; i < 10; i++) {
            int puesto = i + 1;
            JLabel puestoLabel = new JLabel(String.valueOf(puesto));
            GridBagConstraints gbc_puesto = new GridBagConstraints();
            gbc_puesto.insets = new Insets(0, 0, 5, 5);
            gbc_puesto.gridx = 0;
            gbc_puesto.gridy = i;
            panel.add(puestoLabel, gbc_puesto);

            // Nombre del jugador
            nombres[i] = new JLabel("no hay jugador");
            GridBagConstraints gbc_nombre = new GridBagConstraints();
            gbc_nombre.insets = new Insets(0, 0, 5, 5);
            gbc_nombre.gridx = 1;
            gbc_nombre.gridy = i;
            panel.add(nombres[i], gbc_nombre);

            // Puntos del jugador
            puntos[i] = new JLabel("-");
            GridBagConstraints gbc_puntos = new GridBagConstraints();
            gbc_puntos.insets = new Insets(0, 0, 5, 0);
            gbc_puntos.gridx = 2;
            gbc_puntos.gridy = i;
            panel.add(puntos[i], gbc_puntos);
        }

        
        for (int i = 0; i < usuarios.size() && i < 10; i++) {
            Usuario usuario = usuarios.get(i);
            nombres[i].setText(usuario.getNombre());
            if (usuario.getPuntos()==-1) {
            	puntos[i].setText("-");
            }
            else {
            	puntos[i].setText(Integer.toString(usuario.getPuntos()));
            }
        }
	}

}

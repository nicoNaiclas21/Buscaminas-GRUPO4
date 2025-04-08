package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaRanking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaRanking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Ranking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel nombreUser_label = new JLabel("Nombre usuario");
		nombreUser_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombreUser_label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nombreUser_label = new GridBagConstraints();
		gbc_nombreUser_label.insets = new Insets(0, 0, 5, 0);
		gbc_nombreUser_label.gridx = 0;
		gbc_nombreUser_label.gridy = 0;
		panel.add(nombreUser_label, gbc_nombreUser_label);
		
		JLabel nombreUserRanking = new JLabel("");
		nombreUserRanking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_nombreUserRanking = new GridBagConstraints();
		gbc_nombreUserRanking.gridx = 0;
		gbc_nombreUserRanking.gridy = 1;
		panel.add(nombreUserRanking, gbc_nombreUserRanking);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel Puntos_label = new JLabel("Puntos");
		Puntos_label.setHorizontalAlignment(SwingConstants.CENTER);
		Puntos_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_Puntos_label = new GridBagConstraints();
		gbc_Puntos_label.insets = new Insets(0, 0, 5, 0);
		gbc_Puntos_label.gridx = 0;
		gbc_Puntos_label.gridy = 0;
		panel_1.add(Puntos_label, gbc_Puntos_label);
		
		JLabel Puntos = new JLabel("");
		Puntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_Puntos = new GridBagConstraints();
		gbc_Puntos.gridx = 0;
		gbc_Puntos.gridy = 1;
		panel_1.add(Puntos, gbc_Puntos);
	}

}

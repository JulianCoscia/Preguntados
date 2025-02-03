package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class TeamMaker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamMaker frame = new TeamMaker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeamMaker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Cargador de equipos");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon originalImage;
		
		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				main.setVisible(true);
				setVisible(false);;
			}
		});
		backButton.setBounds(10, 11, 100, 31);
		contentPane.add(backButton);
		
		JLabel teamLoaderLabel = new JLabel("Cargador de Equipos");
		teamLoaderLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 45));
		teamLoaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLoaderLabel.setBounds(0, 0, 884, 82);
		contentPane.add(teamLoaderLabel);
		
		JButton btnDeleteAll = new JButton("Eliminar todos");
		btnDeleteAll.setBounds(10, 517, 140, 31);
		contentPane.add(btnDeleteAll);
		
		JButton btnEliminarEquipo = new JButton("Eliminar selecionado");
		btnEliminarEquipo.setBounds(181, 517, 140, 31);
		contentPane.add(btnEliminarEquipo);
		
		JButton btnModificarEquipo = new JButton("Modificar equipo");
		btnModificarEquipo.setBounds(354, 517, 140, 31);
		contentPane.add(btnModificarEquipo);
		
		JButton btnGuardarEquipo = new JButton("Guardar equipo");
		btnGuardarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarEquipo.setBounds(734, 517, 140, 31);
		contentPane.add(btnGuardarEquipo);
		
		nameTextField = new JTextField();
		nameTextField.setBorder(new LineBorder(new Color(171, 173, 179)));
		nameTextField.setText("EQUIPO DELTA AGUILAS");
		nameTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		nameTextField.setBounds(444, 153, 416, 30);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Blanco", "Celeste", "Violeta"}));
		comboBox.setBounds(444, 252, 416, 30);
		contentPane.add(comboBox);
		
		JLabel teamName = new JLabel("Nombre:");
		teamName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		teamName.setBounds(443, 129, 69, 18);
		contentPane.add(teamName);
		
		JLabel teamColor = new JLabel("Color:");
		teamColor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		teamColor.setBounds(442, 229, 69, 18);
		contentPane.add(teamColor);
		
		JLabel teamLoadedBackground = new JLabel("");
		teamLoadedBackground.setBounds(10, 123, 399, 365);
		originalImage = new ImageIcon(this.getClass().getResource("/images/background.jpg"));
		teamLoadedBackground.setIcon(originalImage);
		contentPane.add(teamLoadedBackground);
		
		JLabel teamNameLabel = new JLabel("");
		teamNameLabel.setBounds(433, 123, 440, 70);
		originalImage = new ImageIcon(this.getClass().getResource("/images/TeamMakerNameBackgroundSF.png"));
		teamNameLabel.setIcon(originalImage);
		contentPane.add(teamNameLabel);
		
		JLabel teamColorLabel = new JLabel("");
		teamColorLabel.setBounds(433, 223, 440, 70);
		originalImage = new ImageIcon(this.getClass().getResource("/images/TeamMakerNameBackgroundSF.png"));
		teamColorLabel.setIcon(originalImage);
		contentPane.add(teamColorLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(433, 389, 440, 70);
		originalImage = new ImageIcon(this.getClass().getResource("/images/RedPreview.png"));
		lblNewLabel_2.setIcon(originalImage);
		contentPane.add(lblNewLabel_2);
	}
}

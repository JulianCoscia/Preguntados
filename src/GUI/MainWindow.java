package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel topLabel;
	private JButton startGameButton;
	private JButton configButton;
	private JButton howToPlayButton;
	private JButton moreInfoButton;
	private JButton exitButton;
	private JButton loadQuestionButton;
	private JButton loadTeamButton;
	private JButton backButton;
	private JLabel timePerQuestionLabel;
	private JTextField timePerQuestion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Preguntados!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/question_mark.png")));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		topLabel = new JLabel();
		topLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topLabel.setBounds(0, 0, 484, 121);
		topLabel.setFont(new Font("Monotype Corsiva", Font.ITALIC, 70));
		contentPane.add(topLabel);
		
		startGameButton = new JButton("Iniciar Juego");
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow game = new GameWindow();
				game.setVisible(true);
				setVisible(false);
			}
		});
		startGameButton.setBounds(177, 160, 130, 45);
		contentPane.add(startGameButton);
		
		configButton = new JButton("Configuracion");
		configButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showConfigWindowProvision();
				
				//QuestionMaker Qwindow = new QuestionMaker();
				//Qwindow.setVisible(true);
				//setVisible(false);
			}
		});
		configButton.setBounds(177, 240, 130, 45);
		contentPane.add(configButton);
		
		howToPlayButton = new JButton("Como Jugar");
		howToPlayButton.setBounds(177, 320, 130, 45);
		contentPane.add(howToPlayButton);
		
		moreInfoButton = new JButton("Mas informacion");
		moreInfoButton.setBounds(177, 400, 130, 45);
		contentPane.add(moreInfoButton);
		
		exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(177, 525, 130, 25);
		contentPane.add(exitButton);
		
		//..........................................
		loadQuestionButton = new JButton("Cargar pregunta");
		loadQuestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionMaker Qwindow = new QuestionMaker();
				Qwindow.setVisible(true);
				setVisible(false);
			}
		});
		loadQuestionButton.setBounds(177, 240, 130, 45);
		contentPane.add(loadQuestionButton);
		
		loadTeamButton = new JButton("Cargar Equipos");
		loadTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamMaker Twindow = new TeamMaker();
				Twindow.setVisible(true);
				setVisible(false);								
			}
		});
		loadTeamButton.setBounds(177, 320, 130, 45);
		contentPane.add(loadTeamButton);
		
		timePerQuestionLabel = new JLabel("Segundos por pregunta:");
		timePerQuestionLabel.setBounds(162, 150, 160, 45);
		timePerQuestionLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		timePerQuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(timePerQuestionLabel);
		
		timePerQuestion = new JTextField();
		timePerQuestion.setBounds(230, 190, 30, 22);
		timePerQuestion.setFont(new Font("SansSerif", Font.PLAIN, 15));
		timePerQuestion.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(timePerQuestion);
		
		backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMainWindowProvision();
			}
		});
		backButton.setBounds(177, 525, 130, 25);
		contentPane.add(backButton);
		
		showMainWindowProvision();
	}
	
	private void showConfigWindowProvision() {
		topLabel.setText("Configuracion");
		startGameButton.setVisible(false);
		configButton.setVisible(false);
		howToPlayButton.setVisible(false);
		moreInfoButton.setVisible(false);
		exitButton.setVisible(false);
		
		loadQuestionButton.setVisible(true);
		loadTeamButton.setVisible(true);
		timePerQuestionLabel.setVisible(true);
		backButton.setVisible(true);
		timePerQuestion.setVisible(true);
	}
	
	private void showMainWindowProvision() {
		topLabel.setText("Bienvenidos!");
		startGameButton.setVisible(true);
		configButton.setVisible(true);
		howToPlayButton.setVisible(true);
		moreInfoButton.setVisible(true);
		exitButton.setVisible(true);
		
		loadQuestionButton.setVisible(false);
		loadTeamButton.setVisible(false);
		timePerQuestionLabel.setVisible(false);
		backButton.setVisible(false);
		timePerQuestion.setVisible(false);
	}
}

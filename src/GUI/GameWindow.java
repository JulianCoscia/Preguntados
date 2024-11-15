package GUI;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import Logic.Game;
import Team.Team;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int MAX_OPTIONS = 4;
	private Game myGame;
	private JPanel contentPane;
	private JLabel teamTurnLabel;
	private JLabel questionNumberLabel;
	private JLabel secondsPerQuestionLabel;
	private JLabel questionLabel;
	private JLabel timerBarLabel;
	private JButton nextQuestionButton;
	private ArrayList<JLabel> scoreLabels;
	private ArrayList<JLabel> optionLabels;
	private boolean optionClicked;
	private boolean timeEnded;
	private int valueTimeBar;
	private float decimalsValueTimeBar;
	private float decimalsValueTimeBarCounter;

	public GameWindow() {
		myGame  = new Game(45, this);
		createUI();
	}
	
	/**
	 * Notifies to the GUI that a second passed. 
	 * @param currentSecondsRemaining Current seconds.
	 */
	public void aSecondPassed(int currentSecondsRemaining) {
		decimalsValueTimeBarCounter = decimalsValueTimeBarCounter + decimalsValueTimeBar;
		if (!optionClicked) {
			if (decimalsValueTimeBarCounter < 1) {
				secondsPerQuestionLabel.setText(currentSecondsRemaining+"");
				timerBarLabel.setBounds(timerBarLabel.getX(), timerBarLabel.getY(),timerBarLabel.getWidth()-valueTimeBar, timerBarLabel.getHeight());
			}else {
				secondsPerQuestionLabel.setText(currentSecondsRemaining+"");
				timerBarLabel.setBounds(timerBarLabel.getX(), timerBarLabel.getY(),timerBarLabel.getWidth()-valueTimeBar-1, timerBarLabel.getHeight());
				decimalsValueTimeBarCounter--;
			}
		}
		
		if (currentSecondsRemaining == myGame.getTimePerQuestion()/2) {
			
			timerBarLabel.setBackground(new Color(232,220,0));
		}else{		
			if (currentSecondsRemaining == myGame.getTimePerQuestion()/3) {
				timerBarLabel.setBackground(new Color(233,18,29));
			}else{
				if (currentSecondsRemaining == 0) {
					timeEnded();
				}
			}
		}
		
	}
	
	/**
	 * Creates the frame.
	 */
	private void createUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		setTitle("Preguntados!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/question_mark.png")));
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon originalImage;
		scoreLabels = new ArrayList<JLabel>();
		optionLabels = new ArrayList<JLabel>();
		
		teamTurnLabel = new JLabel("");
		teamTurnLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		teamTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamTurnLabel.setBounds(115, 20, 436, 29);
		contentPane.add(teamTurnLabel);
		
		questionNumberLabel = new JLabel("");
		questionNumberLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		questionNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionNumberLabel.setBounds(58, 20, 40, 29);
		contentPane.add(questionNumberLabel);
		
		secondsPerQuestionLabel = new JLabel(myGame.getTimePerQuestion()+"");
		secondsPerQuestionLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		secondsPerQuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secondsPerQuestionLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		secondsPerQuestionLabel.setBounds(36, 290, 528, 23);
		contentPane.add(secondsPerQuestionLabel);
		
		timerBarLabel = new JLabel();
		timerBarLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		timerBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerBarLabel.setOpaque(true);
		timerBarLabel.setBackground(new Color(0, 255, 0));
		timerBarLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		timerBarLabel.setBounds(36, 290, 528, 23);
		valueTimeBar = (timerBarLabel.getWidth()/myGame.getTimePerQuestion());
		decimalsValueTimeBar = ((float)timerBarLabel.getWidth()/myGame.getTimePerQuestion()) - valueTimeBar;
		decimalsValueTimeBarCounter = 0;
		contentPane.add(timerBarLabel);
		
		JLabel EquiposLabel = new JLabel("Equipos");
		EquiposLabel.setFont(new Font("Monotype Corsiva", Font.ITALIC, 70));
		EquiposLabel.setVerticalAlignment(SwingConstants.TOP);
		EquiposLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EquiposLabel.setBounds(596, 11, 277, 83);
		contentPane.add(EquiposLabel);
		
		//__________ creating scoreLabels __________
		JLabel firstTeamScore = new JLabel();
		firstTeamScore.setBounds(595, 180, 70, 40);
		scoreLabels.add(firstTeamScore);
		
		JLabel secondTeamScore = new JLabel();
		secondTeamScore.setBounds(595, 230, 70, 40);
		scoreLabels.add(secondTeamScore);
		
		JLabel thirdTeamScore = new JLabel();
		thirdTeamScore.setBounds(595, 280, 70, 40);
		scoreLabels.add(thirdTeamScore);
		
		JLabel forthTeamScore = new JLabel();
		forthTeamScore.setBounds(595, 330, 70, 40);
		scoreLabels.add(forthTeamScore);
		
		JLabel fifthTeamScore = new JLabel();
		fifthTeamScore.setBounds(595, 380, 70, 40);
		scoreLabels.add(fifthTeamScore);
		
		JLabel sixthTeamScore = new JLabel();
		sixthTeamScore.setBounds(595, 430, 70, 40);
		scoreLabels.add(sixthTeamScore);
		
		JLabel seventhTeamScore = new JLabel();
		seventhTeamScore.setBounds(595, 480, 70, 40);
		scoreLabels.add(seventhTeamScore);
		
		JLabel eightTeamScore = new JLabel();
		eightTeamScore.setBounds(595, 530, 70, 40);
		scoreLabels.add(eightTeamScore);
		
		createTeamScoreLabels();
		
		//__________ creating TeamName labels __________
		ArrayList<JLabel> teamNames = new ArrayList<JLabel>();
		
		JLabel firstTeamName = new JLabel();
		firstTeamName.setBounds(720, 180, 207, 40);
		teamNames.add(firstTeamName);
		
		JLabel secondTeamName = new JLabel();
		secondTeamName.setBounds(720, 230, 207, 40);
		teamNames.add(secondTeamName);
		
		JLabel thirdTeamName = new JLabel();
		thirdTeamName.setBounds(720, 280, 207, 40);
		teamNames.add(thirdTeamName);
		
		JLabel forthTeamName = new JLabel();
		forthTeamName.setBounds(720, 330, 207, 40);
		teamNames.add(forthTeamName);
		
		JLabel fifthTeamName = new JLabel();
		fifthTeamName.setBounds(720, 380, 207, 40);
		teamNames.add(fifthTeamName);
		
		JLabel sixthTeamName = new JLabel();
		sixthTeamName.setBounds(720, 430, 207, 40);
		teamNames.add(sixthTeamName);
		
		JLabel seventhTeamName = new JLabel();
		seventhTeamName.setBounds(720, 480, 207, 40);
		teamNames.add(seventhTeamName);
		
		JLabel eightTeamName = new JLabel();
		eightTeamName.setBounds(720, 530, 207, 40);
		teamNames.add(eightTeamName);
		
		createTeamNameLabels(teamNames);
		
		//__________ creating team background labels __________
		createTeamBackgroundLabels();
		
		JButton startGameButton = new JButton("Iniciar Juego");
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionClicked = false;
				refreshFrame();
				nextQuestionButton.setEnabled(false);
				myGame.playTimer();
				startGameButton.setVisible(false);
			}
		});
		startGameButton.setFont(new Font("Segoe UI Historic", Font.PLAIN, 12));
		startGameButton.setFocusable(false);
		startGameButton.setBorder(null);
		startGameButton.setBackground(Color.WHITE);
		startGameButton.setBounds(595, 581, 140, 23);
		contentPane.add(startGameButton);
		
		JLabel characterLabel2 = new JLabel("");
		characterLabel2.setBounds(530, 427, 129, 184);
		originalImage = new ImageIcon(this.getClass().getResource("/images/art2.png"));
		characterLabel2.setIcon(scaleImage(originalImage, characterLabel2));
		contentPane.add(characterLabel2);
		
		JLabel characterLabel3 = new JLabel("");
		characterLabel3.setBounds(510, 159, 129, 142);
		originalImage = new ImageIcon(this.getClass().getResource("/images/cience.png"));
		characterLabel3.setIcon(scaleImage(originalImage, characterLabel3));
		contentPane.add(characterLabel3);
		
		JLabel characterLabel4 = new JLabel("");
		characterLabel4.setBounds(816, 40, 129, 133);
		originalImage = new ImageIcon(this.getClass().getResource("/images/history1.png"));
		characterLabel4.setIcon(scaleImage(originalImage, characterLabel4));
		contentPane.add(characterLabel4);
		
		JLabel characterLabel5 = new JLabel("");
		characterLabel5.setBounds(-61, 40, 129, 122);
		originalImage = new ImageIcon(this.getClass().getResource("/images/geo1.png"));
		characterLabel5.setIcon(scaleImage(originalImage, characterLabel5));
		contentPane.add(characterLabel5);
		
		optionClicked = true; //Para que al iniciar el juego no puedan hacer clic en las opciones
		
		//__________ creating option labels __________
		JLabel optionLabel = new JLabel("");
		optionLabel.setBounds(36, 324, 528, 60);
		optionLabel.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (!optionClicked) {
		    		if(!timeEnded) {
		    			checkAnswer(optionLabel, 0);
		    		}
		    	}
		    }
		});
		optionLabels.add(optionLabel);
		
		JLabel optionLabel2 = new JLabel("");
		optionLabel2.setBounds(36, 394, 528, 60);
		optionLabel2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (!optionClicked) {
		    		if(!timeEnded) {
		    			checkAnswer(optionLabel2, 1);
		    		}
		    	}
		    }
		});
		optionLabels.add(optionLabel2);
		
		JLabel optionLabel3 = new JLabel("");
		optionLabel3.setBounds(36, 464, 528, 60);
		optionLabel3.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (!optionClicked) {
		    		if(!timeEnded) {
		    			checkAnswer(optionLabel3, 2);
		    		}
		    	}
		    }
		});
		optionLabels.add(optionLabel3);
		
		JLabel optionLabel4 = new JLabel("");
		optionLabel4.setBounds(36, 534, 528, 60);
		optionLabel4.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (!optionClicked) {
		    		if(!timeEnded) {
		    			checkAnswer(optionLabel4, 3);
		    		}
		    	}
		    }
		});
		optionLabels.add(optionLabel4);
		
		createOptionLabels();
		
		JLabel characterLabel1 = new JLabel("");
		characterLabel1.setBounds(-35, 495, 129, 122);
		originalImage = new ImageIcon(this.getClass().getResource("/images/tv2.png"));
		characterLabel1.setIcon(scaleImage(originalImage, characterLabel1));
		contentPane.add(characterLabel1);
		
		questionLabel = new JLabel("");
		questionLabel.setBounds(36, 11, 528, 268);
		originalImage = new ImageIcon(this.getClass().getResource("/images/questionBackground.png"));
		questionLabel.setIcon(scaleImage(originalImage, questionLabel));
		questionLabel.setFont(new Font("SansSerif", Font.PLAIN, 26));
		questionLabel.setHorizontalTextPosition(JLabel.CENTER);
		questionLabel.setVerticalTextPosition(JLabel.CENTER);
		contentPane.add(questionLabel);
		
		nextQuestionButton = new JButton("Siguiente pregunta");
		nextQuestionButton.setBackground(new Color(255, 255, 255));
		nextQuestionButton.setBorder(null);
		nextQuestionButton.setFont(new Font("Segoe UI Historic", Font.PLAIN, 12));
		nextQuestionButton.setFocusable(false);
		nextQuestionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextQuestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionClicked = false;
				myGame.nextQuestion();
				
				if (myGame.getCurrentQuestion() != null) {
					myGame.nextTurn();
					resetOptionImage();
					
					// Makes unused optionLabels invisible
					for(int i = myGame.getCurrentQuestion().getNumberOfOptions(); i < MAX_OPTIONS; i++) {
						optionLabels.get(i).setVisible(false);
					}
					
					refreshFrame();
					myGame.playTimer();
					
					// Resets timerBar width
					timerBarLabel.setBounds(secondsPerQuestionLabel.getX(), secondsPerQuestionLabel.getY(), secondsPerQuestionLabel.getWidth(), secondsPerQuestionLabel.getHeight());
					timerBarLabel.setBackground(Color.GREEN);
				}
				secondsPerQuestionLabel.setText(myGame.getTimePerQuestion()+"");
				nextQuestionButton.setEnabled(false);
				timeEnded = false;
			}
		});
		nextQuestionButton.setBounds(750, 581, 140, 23);
		contentPane.add(nextQuestionButton);
		
		JLabel createdByLabel = new JLabel("Creado por Julian Coscia");
		createdByLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
		createdByLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		createdByLabel.setBounds(728, 0, 201, 23);
		contentPane.add(createdByLabel);
		
		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setOpaque(false);
		backgroundLabel.setBounds(0, 0, 934, 611);
		backgroundLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/background.jpg")));
		contentPane.add(backgroundLabel);
		
		nextQuestionButton.setEnabled(false);
	}
	
	private void createTeamBackgroundLabels() {
		ImageIcon originalImage;
		int x, y, width, height;
		x = 596;
		y = 181;
		width = 330;
		height = 40;
		int sum = 50;
		int value = 0;
		
		//podria mejorar el tema de las variables. crear teamConstants para esto, los puntajes, y etc. solo cambia el y o el x en algunas cosas
		
		for(Team gt:myGame.getTeams()) {
			JLabel label = new JLabel();
			label.setBounds(x, y+value, width, height);
			originalImage = new ImageIcon(this.getClass().getResource("/images/"+gt.getimageID()+"Team2.png"));
			label.setIcon(scaleImage(originalImage, label));
			contentPane.add(label);
			value = value + sum;
		}
	}

	private void refreshFrame() {
		if (myGame.getCurrentQuestion() != null) {
			questionNumberLabel.setText(myGame.getCurrentQuestion().getQuestionNumber()+"");
			teamTurnLabel.setText(myGame.getCurrentTeamTurn().getName());
			teamTurnLabel.setForeground(myGame.getCurrentTeamTurn().getColor());
			String text = "<html><div style='text-align: center;'>"+myGame.getCurrentQuestion().getQuestionText()+"</div></html>";
			questionLabel.setText(text);
			int index = 0;
			
			for(JLabel lb:optionLabels) {
				if(index < myGame.getCurrentQuestion().getNumberOfOptions()) {
					lb.setText("<html><div style='text-align: center;'>"+myGame.getCurrentQuestion().getOptions().get(index).getOption()+"</div></html>");
					lb.setVisible(true);
					index++;
				}
			}
			
			for(int i = myGame.getCurrentQuestion().getNumberOfOptions(); i < MAX_OPTIONS; i++) {
				optionLabels.get(i).setVisible(false);
			}
		}
	}
	
	/**
	 * Manages the end of time case.
	 */
	private void timeEnded() {
		ImageIcon originalImage;
		timeEnded = true;
		nextQuestionButton.setEnabled(true);
		
		for(int i = 0; i < myGame.getCurrentQuestion().getOptions().size(); i++) {
			if (myGame.getCurrentQuestion().getOptions().get(i).isCorrect()) {
				originalImage = new ImageIcon(this.getClass().getResource("/images/correctAnswerOptionBar.png"));
				optionLabels.get(i).setIcon(scaleImage(originalImage, optionLabels.get(i)));
			}else {
				originalImage = new ImageIcon(this.getClass().getResource("/images/incorrectAnswerOptionBar.png"));
				optionLabels.get(i).setIcon(scaleImage(originalImage, optionLabels.get(i)));
			}
		}
		
		// Checks if the game is over
		if (myGame.getCurrentQuestion().getQuestionNumber() == myGame.getNumberOfQuestions()) {
			nextQuestionButton.setEnabled(false);
			this.gameOver(myGame.gameOver());
		}
	}

	/**
	 * Checks if the chosen option is the correct one.
	 * @param optionLabel OptionLabel chosen.
	 * @param index Option chosen.
	 */
	private void checkAnswer(JLabel optionLabel, int index) {
		optionClicked = true;
		ImageIcon originalImage;
		int optionSize = myGame.getCurrentQuestion().getNumberOfOptions();
		nextQuestionButton.setEnabled(true);
		myGame.pauseTimer();
		
		if (myGame.getCurrentQuestion().getOptions().get(index).isCorrect()) {
			originalImage = new ImageIcon(this.getClass().getResource("/images/correctAnswerOptionBar.png"));
			optionLabel.setIcon(scaleImage(originalImage, optionLabel));
			myGame.addScore(myGame.getCurrentTeamTurn());
			scoreLabels.get(myGame.getCurrentTeamTurn().getNumber()).setText(myGame.getCurrentTeamTurn().getScore()+"");
			
			// Marks the other option as incorrect answers
			int value = (index+1)%optionSize;			
			for(int i = 0; i < (optionSize-1); i++) {
				originalImage = new ImageIcon(this.getClass().getResource("/images/incorrectAnswerOptionBar.png"));
				optionLabels.get(value).setIcon(scaleImage(originalImage, optionLabels.get(value)));
				value = (value+1)%optionSize;
			}
		}else {
			originalImage = new ImageIcon(this.getClass().getResource("/images/incorrectAnswerOptionBar.png"));
			optionLabel.setIcon(scaleImage(originalImage, optionLabel));
			
			// Marks only the correct option
			int value = (index+1)%optionSize;			
			for(int i = 0; i < (optionSize-1); i++) {
				if (myGame.getCurrentQuestion().getOptions().get(value).isCorrect()) {
					originalImage = new ImageIcon(this.getClass().getResource("/images/correctAnswerOptionBar.png"));
					optionLabels.get(value).setIcon(scaleImage(originalImage, optionLabels.get(value)));
				}
				value = (value+1)%optionSize;
			}
		}
		
		// Checks if the game is over
		if (myGame.getCurrentQuestion().getQuestionNumber() == myGame.getNumberOfQuestions()) {
			nextQuestionButton.setEnabled(false);
			this.gameOver(myGame.gameOver());
		}
	}

	/**
	 * Rescales an image to the correct label size.
	 * @param originalImageIcon the image.
	 * @param label Label.
	 * @return Rescaled imageIcon.
	 */
	private ImageIcon scaleImage(ImageIcon originalImageIcon, JLabel label) {
		Image image = originalImageIcon.getImage();
		Image scaledImage= image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
		return scaledImageIcon;
	}
	
	/**
	 * Resets all the option images to the default option images.
	 */
	private void resetOptionImage() {
		ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/images/optionBar.png"));
		
		for(JLabel e:optionLabels) {
			e.setIcon(scaleImage(originalImage, e));
		}
	}
	
	/**
	 * Manages the game's end.
	 * @param winners
	 */
	private void gameOver(ArrayList<Team> winners) {
		String ganadores = "El o Los ganadores son: ";
		
		for (Team e:winners) {
			ganadores = ganadores+e.getName()+" - ";
		}
		
		JOptionPane.showMessageDialog(contentPane, ganadores, "Ganadores", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Creates the option labels.
	 */
	private void createOptionLabels() {
		ImageIcon originalImage = new ImageIcon(this.getClass().getResource("/images/optionBar.png"));
		
		for(JLabel lb:optionLabels) {
			lb.setIcon(scaleImage(originalImage, lb));
			lb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lb.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lb.setHorizontalTextPosition(JLabel.CENTER);
			lb.setVerticalTextPosition(JLabel.CENTER);
			contentPane.add(lb);
		}
	}
	
	/**
	 * Creates the team labels.
	 */
	private void createTeamScoreLabels() {
		int i = 0;
		ArrayList<Team> teamNames = myGame.getTeams();		
		
		for(JLabel lb:scoreLabels) {
			lb.setHorizontalAlignment(SwingConstants.CENTER);
			lb.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lb.setText(teamNames.get(i).getScore()+"");
			contentPane.add(lb);
			i++;
		}
	}
	
	/**
	 * Creates the team name labels.
	 * @param nameLabels The list with the labels.
	 */
	private void createTeamNameLabels(ArrayList<JLabel> nameLabels) {
		int index = 0;
		ArrayList<Team> teamNames = myGame.getTeams();
		
		for(JLabel lb: nameLabels) {
			lb.setText(teamNames.get(index).getName()+"");
			lb.setHorizontalAlignment(SwingConstants.CENTER);
			lb.setFont(new Font("SansSerif", Font.PLAIN, 14));
			contentPane.add(lb);
			index++;
		}
	}
}

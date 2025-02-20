package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Question.Question;
import Question.Questions;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class QuestionMaker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea questionTextField;
	private JList<String> questionLoadedList;
	private ArrayList<JTextArea> optionList;
	private ArrayList<JRadioButton> radioButtonList;
	private ButtonGroup group;
	private int correctOption;

	/**
	 * Create the frame.
	 */
	public QuestionMaker(Questions questionsLoaded) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Cargador de preguntas");
		
		ImageIcon originalImage;
		optionList = new ArrayList<JTextArea>(4);
		radioButtonList = new ArrayList<JRadioButton>(4);
		group = new ButtonGroup();
		correctOption = -1;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel questionLoaderLabel = new JLabel("Cargador de Preguntas");
		questionLoaderLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 45));
		questionLoaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLoaderLabel.setBounds(0, 0, 984, 82);
		contentPane.add(questionLoaderLabel);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		questionLoadedList = new JList<>(listModel);
		questionLoadedList.setBorder(new LineBorder(new Color(0, 0, 0)));
		//questionLoadedList.setBounds(10, 158, 331, 393);
		JScrollPane scrollPane = new JScrollPane(questionLoadedList);
		scrollPane.setBounds(10, 158, 331, 393);
		questionLoadedList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { //Avoid duplicated events
                    int selectedIndex = questionLoadedList.getSelectedIndex();
                    Question questionSelected = questionsLoaded.getQuestion(selectedIndex+1);
                    questionTextField.setText(questionSelected.getQuestionText());
                    
                    for(int i = 0; i < questionSelected.getOptions().size(); i++) {
                    	optionList.get(i).setText(questionSelected.getOptions().get(i).getOption());
                    	
                    	if (questionSelected.getOptions().get(i).isCorrect()) {
                    		radioButtonList.get(i).setSelected(true);
                    		correctOption = i;
                    	}
                    }
                    
                    
                }
            }
        });
		contentPane.add(scrollPane);
		loadQuestions(questionsLoaded, listModel);
		
		questionTextField = new JTextArea();
		questionTextField.setFont(new Font("Monospaced", Font.PLAIN, 18));
		questionTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		questionTextField.setBounds(378, 178, 594, 133);
		contentPane.add(questionTextField);
		questionTextField.setColumns(10);
		questionTextField.setLineWrap(true);
		questionTextField.setWrapStyleWord(true);
		
		JLabel lblNewLabel = new JLabel("Pregunta:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(378, 154, 119, 21);
		contentPane.add(lblNewLabel);
		
		createOptionField();
		
		JLabel isCorrectLabel = new JLabel("¿Es correcta?");
		isCorrectLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		isCorrectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		isCorrectLabel.setBounds(900, 306, 84, 41);
		contentPane.add(isCorrectLabel);
		
		JButton btnNewButton = new JButton("Eliminar todas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(contentPane, "¿Realmente desea eliminar TODAS las preguntas cargadas?",
												"Eliminar todas las preguntas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
					questionsLoaded.clearList();
					DefaultListModel<String> newListModel = new DefaultListModel<>();
					questionLoadedList.setModel(newListModel);
					
					//Esto elimina del maker pero no de las cargadas. al iniciar el juego las preguntas siguen. sera que no actualice 
					//con que referencia comienza game?
				}
			}
		});
		btnNewButton.setBounds(10, 619, 140, 31);
		contentPane.add(btnNewButton);
		
		JButton btnEliminarPregunta = new JButton("Eliminar pregunta");
		btnEliminarPregunta.setBounds(220, 619, 140, 31);
		contentPane.add(btnEliminarPregunta);
		
		JButton btnModificarPregunta = new JButton("Modificar pregunta");
		btnModificarPregunta.setBounds(430, 619, 140, 31);
		contentPane.add(btnModificarPregunta);
		
		JButton btnGuardarPregunta = new JButton("Guardar pregunta");
		btnGuardarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (correctOption != -1) {
					//crear pregunta
				}else {
					System.out.println("No se selecciono una opcion correcta");
				}
			}
		});
		btnGuardarPregunta.setBounds(640, 619, 140, 31);
		contentPane.add(btnGuardarPregunta);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionTextField.setText("");
				
				for(JTextArea txt:optionList) {
					txt.setText("");
				}
			}
		});
		btnLimpiarCampos.setBounds(835, 619, 140, 31);
		contentPane.add(btnLimpiarCampos);
		
		JLabel lblNewLabel_1 = new JLabel("Preguntas cargadas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 127, 147, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel QuestionLoadedBackground = new JLabel("");
		QuestionLoadedBackground.setBounds(3, 123, 345, 436);
		originalImage = new ImageIcon(this.getClass().getResource("/images/Fondo lista de preguntasSF.png"));
		QuestionLoadedBackground.setIcon(originalImage);
		contentPane.add(QuestionLoadedBackground);
		
		JLabel QuestionBackground = new JLabel("");
		QuestionBackground.setBounds(371, 147, 608, 171);
		originalImage = new ImageIcon(this.getClass().getResource("/images/Fondo preguntaSF.png"));
		QuestionBackground.setIcon(originalImage);
		contentPane.add(QuestionBackground);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 984, 661);
		originalImage = new ImageIcon(this.getClass().getResource("/images/questionMakerBackground.jpg"));
		
		JLabel optionsLabel = new JLabel("Opciones:");
		optionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		optionsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		optionsLabel.setBounds(378, 306, 84, 41);
		contentPane.add(optionsLabel);
		background.setIcon(originalImage);
		contentPane.add(background);
	}
	
	/**
	 * Loads to the list model the questions readed.
	 * @param questionsLoaded
	 * @param listModel
	 */
	private void loadQuestions(Questions questionsLoaded, DefaultListModel<String> listModel) {
		Question question;
		for(int i = 1; i < questionsLoaded.getNumberOfQuestions()+1; i++) {
			question = questionsLoaded.getQuestion(i);
			listModel.addElement(question.getQuestionNumber()+") "+question.getQuestionText());
		}
		
	}

	private void createOptionField() {
		int textAreaY = 346;
		int radioButtonY = 355;
		int optionBackgroundY = 337;
		
		for (int i = 0; i < 4; i++) {
			//text field
			int id = i;
			JTextArea optionTextArea = new JTextArea();
			optionTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			optionTextArea.setBounds(387, textAreaY, 528, 42);
			optionTextArea.setColumns(10);
			optionTextArea.setLineWrap(true);
			optionTextArea.setWrapStyleWord(true);
			contentPane.add(optionTextArea);
			optionList.add(optionTextArea);
			
			//radio button
			JRadioButton isCorrectRadioButton = new JRadioButton("");
			isCorrectRadioButton.setOpaque(false);
			isCorrectRadioButton.setBounds(933, radioButtonY, 21, 21);
			isCorrectRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					correctOption = id;
				}
			});
			contentPane.add(isCorrectRadioButton);
			group.add(isCorrectRadioButton);
			radioButtonList.add(isCorrectRadioButton);
			
			//background
			JLabel optionBackground = new JLabel("");
			optionBackground.setBounds(370, optionBackgroundY, 610, 60);
			ImageIcon Image = new ImageIcon(this.getClass().getResource("/images/createOptionBackground.png"));
			optionBackground.setIcon(Image);
			contentPane.add(optionBackground);
			
			textAreaY = textAreaY + 65;
			radioButtonY = radioButtonY + 65;
			optionBackgroundY = optionBackgroundY + 65;
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
}

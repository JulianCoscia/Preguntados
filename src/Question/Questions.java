package Question;

import java.util.ArrayList;

public class Questions {
	private ArrayList<Question> questions;
	
	public Questions() {
		questions = new ArrayList<Question>();
	}
	
	//____________________ Methods ____________________
	/**
	 * Creates a new question and adds it to the question list.
	 * @param info Question's information (number, question text, options.) read from the file.
	 */
	public void createQuestion(String info) {
		String[] text = info.split(";");
		int number = Integer.valueOf(text[0]);
		String questionText = text[1];
		Question newQuestion = null;
		
		// Checks if the question has options
		if (text.length > 2) {
			String options = text[2];
			
			// Creates a string with all options of the question.
			for (int i = 3; i < text.length; i++) {
				options = options+";"+text[i];
			}
			
			newQuestion = new Question(number, questionText, options);
		}else {
			newQuestion = new Question(number, questionText, "This question does not have any options.");
		}
		
		questions.add(newQuestion);
	}
	
	/**
	 * @return First question of the game.
	 */
	public Question getFirstQuestion() {
		return questions.getFirst();
	}
	
	/**
	 * Returns the next question. 
	 * @param currentQuestion.
	 * @return Next question or Null if the question was not found.
	 */
	public Question nextQuestion(Question currentQuestion){
		Question response = null;
		
		if (currentQuestion != null && currentQuestion.getQuestionNumber() < questions.size()) {
			try {
				response = questions.get(currentQuestion.getQuestionNumber());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	/**
	 * Returns the previous question.
	 * @param currentQuestion
	 * @return Previous question or Null if the question was not found.
	 */
	public Question previousQuestion(Question currentQuestion) {
		Question response = null;
		
		if (currentQuestion.getQuestionNumber() > 0) {
			try {
				response = questions.get(currentQuestion.getQuestionNumber()-2);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	/**
	 * Returns the question specified by number.
	 * @param num Number of question to search.
	 * @return The specified question or Null if the question was not found.
	 */
	public Question getQuestion(int num) {
		Question response = null;
		
		if (num > 0 && num <= questions.size()) {
			try {
				response = questions.get(num-1);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	/**
	 * @return The number of questions loaded.
	 */
	public int getNumberOfQuestions() {
		return questions.size();
	}
}

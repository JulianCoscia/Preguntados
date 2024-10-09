package Question;

import java.util.ArrayList;

public class Question {
	private String questionText;
	private int number;
	private ArrayList<Option> options;
	
	public Question(int number, String questionText, String options) {
		this.options = new ArrayList<Option>();
		this.number = number;
		this.questionText = questionText;
		Option toAdd = null;
		
        String[] optionsRead = options.split(";");

        // Verifies which is the correct answer and adds every option to the option list.
        for (int i = 0; i < optionsRead.length; i++) {
            String optionText = optionsRead[i];
            boolean isCorrect = false;
            
            // Verifies if the option read is the correct answer.
            if (optionText.startsWith("#")) {
                isCorrect = true;
                optionText = optionText.substring(1);	// remove '#' from the text
            }
		
            // Adds the read option to the option list.
            toAdd = new Option(optionText, isCorrect);
            this.options.add(toAdd);
        }
	}
	
	//____________________ Methods ____________________
	/**
	 * Returns the question's text.
	 * @return Question's text.
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * Returns the question's options.
	 * @return Question's list of options.
	 */
	public ArrayList<Option> getOptions(){
		return options;
	}
	
	/**
	 * @param option The option selected.
	 * @return True if the option is correct. False otherwise.
	 */
	public boolean isCorrect(Option option) {
		return option.isCorrect();
	}
	
	/**
	 * @return The number of question.
	 */
	public int getQuestionNumber() {
		return number;
	}
	
	/**
	 * @return The number of options loaded.
	 */
	public int getNumberOfOptions() {
		return options.size();
	}
}

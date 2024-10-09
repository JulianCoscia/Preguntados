package Question;

public class Option {
	private String option;
	private boolean isCorrect;
	
	public Option(String option, boolean isCorrect) {
		this.option = option;
		this.isCorrect = isCorrect;
	}
	
	//____________________ Methods ____________________
	/**
	 * @return Option's text.
	 */
	public String getOption() {
		return option;
	}
	
	/**
	 * @return True if the option is correct. False otherwise.
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

}

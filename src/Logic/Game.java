package Logic;

import Question.*;
import Team.*;

public class Game {
	private Question currentQuestion;
	private Team currentTeam;
	private int timer;
	private int timePerQuestion;
	private Logic myLogic;
	
	public Game(int timePerQuestion) {
		myLogic = new Logic();
		this.timePerQuestion = timePerQuestion;
		currentQuestion = myLogic.getFirstQuestion();
		currentTeam = myLogic.getFirstTeam();
	}
	
	//____________________ Methods ____________________
	/**
	 * @return The current question.
	 */
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	
	/**
	 * @return The team that plays at this turn of the game.
	 */
	public Team getCurrentTeamTurn() {
		return currentTeam;
	}
	/**
	 * Updates the game to the following question.
	 */
	public void nextQuestion() {
		this.currentQuestion = myLogic.getNextQuestion(currentQuestion);
	}
	
	/**
	 * Pass the turn to the next team.
	 */
	public void nextTurn() {
		this.currentTeam = myLogic.nextTurn(currentTeam);
	}
	
	/**
	 * Add score to the current team.
	 * @param currentTeam Team that scored points.
	 */
	public void addScore(Team currentTeam) {
		myLogic.addScore(currentTeam);
	}
	
	/**
	 * @return The number of questions loaded.
	 */
	public int getNumberOfQuestions() {
		return myLogic.getNumberOfQuestions();
	}
	
	/**
	 * @return The number of teams loaded.
	 */
	public int getNumberOfTeams() {
		return myLogic.getNumberOfTeams();
	}
	
	/**
	 * Resets the question timer.
	 */
	public void resetTimer() {
		timer = 0;
		timePerQuestion = timer + 0;
		timer = timePerQuestion + 0;
	}
	
	/**
	 * Pauses the question timer.
	 */
	public void pauseTimer() {
		
	}
	
	/**
	 * Plays the question timer.
	 */
	public void playTimer(){
		
	}
	
	/**
	 * Finishes the game.
	 */
	public void endGame() {
		
	}
}

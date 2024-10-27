package Logic;

import java.util.ArrayList;

import GUI.GameWindow;
import Question.*;
import Team.*;

public class Game {
	private Question currentQuestion;
	private Team currentTeam;
	private Timer timer;
	private int timePerQuestion;
	private Logic myLogic;
	private GameWindow GUI;
	
	public Game(int secondsPerQuestion, GameWindow GUI) {
		myLogic = new Logic();
		this.timePerQuestion = secondsPerQuestion;
		currentQuestion = myLogic.getFirstQuestion();
		currentTeam = myLogic.getFirstTeam();
		this.GUI = GUI;
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
	 * @return List of teams loaded.
	 */
	public ArrayList<Team> getTeams(){
		return myLogic.getTeams();
	}
	
	/**
	 * @return Time per question.
	 */
	public int getTimePerQuestion() {
		return timePerQuestion;
	}
	
	/**
	 * Resets the question timer.
	 */
	public void resetTimer() {
		timer.resetTimer();
	}
	
	/**
	 * Pauses the question timer.
	 */
	public void pauseTimer() {
		timer.pauseTimer();
	}
	
	/**
	 * Plays the question timer.
	 */
	public void playTimer(){
		timer = new Timer(timePerQuestion, this);
		timer.resetTimer();
		timer.startTimer();
	}
	
	public void aSecondPassed(int currentSecondsRemaining) {
		GUI.aSecondPassed(currentSecondsRemaining);
	}
	
	/**
	 * The end of the game.
	 */
	public ArrayList<Team> gameOver() {
		Team winner = myLogic.getFirstTeam();
		
		for (Team t: myLogic.getTeams()){
			if(t.getScore() > winner.getScore()) {
				winner = t;
			}
		}
		
		ArrayList<Team> winners = new ArrayList<Team>();
		winners.add(winner);
		
		for (Team t:myLogic.getTeams()) {
			if(t != winner && t.getScore() == winner.getScore()) {
				winners.add(t);
			}
		}
		
		return winners;
	}
}

package Logic;

import java.util.ArrayList;
import Question.*;
import Team.*;

public class Logic {
	private Teams teams;
	private Questions questions;
	
	
	public Logic(Teams teamsLoaded, Questions questionsLoaded) {// Y si no hay archives???
		teams = teamsLoaded;
		questions = questionsLoaded;
	}
	//____________________ Methods ____________________
	/**
	 * @return The team that plays the first turn of the game.
	 */
	public Team getFirstTeam() {
		return teams.getFirst();
	}
	
	/**
	 * @return The first question of the game.
	 */
	public Question getFirstQuestion() {
		return questions.getFirstQuestion();
	}
	
	/**
	 * @return The number of questions loaded.
	 */
	public int getNumberOfQuestions() {
		return questions.getNumberOfQuestions();
	}
	
	/**
	 * @return The number of teams loaded.
	 */
	public int getNumberOfTeams() {
		return teams.getNumberOfTeams();
	}
	
	/**
	 * @return List of teams loaded. (agregar a UML)
	 */
	public ArrayList<Team> getTeams(){
		return teams.getTeams();
	}
	
	/**
	 * Gets the next question of the current question.
	 * @param currentQuestion
	 */
	public Question getNextQuestion(Question currentQuestion) {
		return questions.nextQuestion(currentQuestion);
	}
	
	/**
	 * Gets the team that plays on the next turn.
	 * @param currentTeam
	 */
	public Team nextTurn(Team currentTeam) {
		return teams.nextTurn(currentTeam);
	}
	
	/**
	 * Add score to the current team.
	 * @param currentTeam Team that scored points.
	 */
	public void addScore(Team currentTeam) {
		currentTeam.addScore(10);
	}
}

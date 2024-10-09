package Logic;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Question.*;
import Team.*;

public class Logic {
	private Teams teams;
	private Questions questions;
	
	
	public Logic() {// Y si no hay archives???
		teams = new Teams();
		questions = new Questions();
		
		// Get the user's "Documents" folder path
        String userHome = System.getProperty("user.home");
        Path documentsPath = Paths.get(userHome, "Documents");

        Path teamsPath = Paths.get(documentsPath.toString(), "EquiposDelPreguntados.txt");
        Path questionsPath = Paths.get(documentsPath.toString(), "PreguntasDelPreguntados.txt");

        // Checks if the files already exists
        File teamFile = teamsPath.toFile();
        File questionsFile = questionsPath.toFile();
        
        // Loads the teams and questions to the game
        if (teamFile.exists() && questionsFile.exists()){
            loadTeams(teamsPath);
            loadQuestions(questionsPath);
        }
	}
	
	//____________________ Methods ____________________
	/**
	 * This method searches in the path 'path' the file that contains the questions for the game and load all of them.
	 * @param path Path of the file 'PreguntasDelPreguntados'.
	 */
	public void loadQuestions(Path path) {
		try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                createQuestion(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
	}
	
	/**
	 * This method searches in the path 'path' the file that contains the teams for the game and load all of them.
	 * @param path Path of the file 'EquiposDelPreguntados'.
	 */
	public void loadTeams(Path path) {
		try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                createTeam(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
	}
	
	/**
	 * Creates a new team and adds it to the team list.
	 * @param info Team's information.
	 */
	public void createTeam(String info) {
		String[] parts = info.split(";");
		Color color = Color.LIGHT_GRAY;
		
		if (parts.length == 2) {
			switch (parts[1].toLowerCase()) {
				case "azul":
					color = Color.BLUE;
				case "gris":
					color = Color.GRAY;
				case "verde":
					color = Color.GREEN;
				case "violeta":
					color = Color.MAGENTA;
				case "rosa":
					color = Color.PINK;
				case "naranja":
					color = Color.ORANGE;
				case "amarillo":
					color = Color.YELLOW;
				case "rojo":
					color = Color.RED;
				case "negro":
					color = Color.BLACK;
				case "blanco":
					color = Color.WHITE;
			}
			
			teams.createTeam(parts[0], color);
		}
	}
	
	/**
	 * Creates a new question and adds it to the question list.
	 * @param info Question's information (number of question, question text, options).
	 */
	public void createQuestion(String info) {
		questions.createQuestion(info);
	}
	
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

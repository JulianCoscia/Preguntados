package Logic;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import Question.*;
import Team.*;

public class Logic {
	private Teams teams;
	private Questions questions;
	
	
	public Logic() {// Y si no hay archives???
		teams = new Teams();
		questions = new Questions();
		
		// Get the user's "Documents" folder path
        //String userHome = System.getProperty("user.home");
        //Path documentsPath = Paths.get(userHome, "Documents");

        //Path teamsPath = Paths.get(documentsPath.toString(), "EquiposDelPreguntados.txt");
        //Path questionsPath = Paths.get(documentsPath.toString(), "PreguntasDelPreguntados.txt");
		
		URL teamsURL = this.getClass().getResource("/archives/EquiposDelPreguntados.txt");
		URL questionsURL = this.getClass().getResource("/archives/PreguntasDelPreguntados.txt");
		
		//Path teamsPath = Paths.get(teamsURL.getPath());
        //Path questionsPath = Paths.get(questionsURL.getPath());

        // Checks if the files already exists
        //File teamFile = teamsPath.toFile();
       // File questionsFile = questionsPath.toFile();
        
        // Loads the teams and questions to the game
        //if (teamFile.exists() && questionsFile.exists()){
            loadTeams(teamsURL);
            loadQuestions(questionsURL);
       // }
	}
	//____________________ Methods ____________________
	
	public void loadQuestions(URL url) {
		try (InputStream inputStream = url.openStream();
		         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            
			String line;
            while ((line = reader.readLine()) != null) {
                createQuestion(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
	}
	
	public void loadTeams(URL url) {
	    try (InputStream inputStream = url.openStream();
	         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
	        
	        String line;
	        while ((line = reader.readLine()) != null) {
	            createTeam(line);
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading the file: " + e.getMessage());
	    }
	}
	
	
	
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
		String imageID = "gray";
		
		if (parts.length == 2) {
			switch (parts[1].toLowerCase()) {
				case "azul":{
					color = new Color(70, 81, 206);
					imageID = "blue";
					break;
				}
				case "gris":{
					color = new Color(134, 134, 134);
					imageID = "gray";
					break;
				}
				case "verde":{
					color = new Color(28, 166, 38);
					imageID = "green";
					break;
				}
				case "violeta":{
					color = new Color(163, 73, 164);
					imageID = "magenta";
					break;
				}
				case "rosa":{
					color = new Color(255, 119, 164);
					imageID = "pink";
					break;
				}
				case "naranja":{
					color = new Color(255, 102, 0);
					imageID = "orange";
					break;
				}
				case "amarillo":{
					color = new Color(240, 204, 2);
					imageID = "yellow";
					break;
				}
				case "rojo":{
					color = new Color(237, 28, 36);
					imageID = "red";
					break;
				}
				case "negro":{
					color = new Color(0, 0, 0);
					imageID = "black";
					break;
				}
				case "blanco":{
					color = Color.WHITE;
					imageID = "white";
					break;
				}
			}
			
			teams.createTeam(parts[0], color, imageID);
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

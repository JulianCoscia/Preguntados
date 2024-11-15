package Team;

import java.awt.Color;

public class Team {
	protected String name;
	protected int number;
	protected Color color;
	protected int score;
	protected String teamDesign;
	
	public Team(String name, Color color, int number) {
		this.name = name;
		this.color = color;
		this.score = 0;
		this.number = number;
	}
	
	public Team(String name, Color color, int number, String imageID) {
		this.name = name;
		this.color = color;
		this.score = 0;
		this.number = number;
		this.teamDesign = imageID;
	}
	
	public Team() {
		this.name = "Player";
		this.color = Color.WHITE;
		this.score = 0;
		this.number = 0;
	}

	//____________________ Methods ____________________.
	/**
	 * Returns the team's name.
	 * @return Team's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the Team's name.
	 * @param name of the team
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return Team's number. Remember that the team number starts from 0.
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Sets the team number. Remember that the team number starts from 0.
	 * @param val Team's number.
	 */
	public void setNumber(int val) {
		number = val;
	}
	
	/**
	 * Returns the team's color.
	 * @return Team's color.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the Team's color.
	 * @param color of the team
	 */	
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Returns the team's score.
	 * @return Score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Adds score to the team.
	 * @param value Number of points to add.
	 * @return Current score.
	 */
	public int addScore(int value) {
		score = score + value;
		
		return score;
	}

	/**
	 * Removes score from the team. If more points are removed than the team has scored, the score will become negative.
	 * @param value Number of points to remove.
	 * @return Current score.
	 */
	public int removeScore(int value) {
		score = score - value;
			
		return score;
	}
	
	/**
	 * @return Team design image ID.
	 */
	public String getimageID() {
		return teamDesign;
	}
}

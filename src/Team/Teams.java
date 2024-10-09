package Team;

import java.awt.Color;
import java.util.ArrayList;

public class Teams {
	private ArrayList<Team> teams;
	
	public Teams() {
		teams = new ArrayList<Team>();
	}
	
	//____________________ Methods ____________________
	/**
	 * @return The team that plays the first turn of the game.
	 */
	public Team getFirst() {
		return teams.getFirst();
	}
	
	/**
	 * @return The number of teams in the game.
	 */
	public int getNumberOfTeams() {
		return teams.size();
	}
	
	/**
	 * Returns the team that plays in the next turn.
	 * @param currentTeam
	 * @return Team that plays in the next turn. Returns null if the parameter is null.
	 */
	public Team nextTurn(Team currentTeam) {
		Team response = null;
		int teamNumber;
		int position;
		
		try {
			if (currentTeam != null) {
				teamNumber = currentTeam.getNumber();
				position = (teamNumber+1) % teams.size();
				response = teams.get(position);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	/**
	 * Creates and adds a new team to the Team list.
	 * @param name Team's name.
	 * @param color Team's color.
	 */
	public void createTeam(String name, Color color) {
		Team newTeam = new Team(name, color, teams.size());
		teams.add(newTeam);
	}
	
	/**
	 * Creates a new empty team (Without name, number or color).
	 * @return New empty team.
	 */
	public Team createTeam() {
		return new Team();
	}
	
	/**
	 * Adds a new team to the Team list.
	 * @param newTeam Team to add.
	 */
	public void addTeam(Team newTeam) {
		if (newTeam != null) {
			newTeam.setNumber(teams.size());
			teams.add(newTeam);
		}
	}
}

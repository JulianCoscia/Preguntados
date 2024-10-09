package Logic;

import Question.*;
import Team.Team;

public class Tester {

	public static void main(String[] args) {
		//______________________ APP TESTER ________________________
		Game game = new Game(30);
		Question quest= game.getCurrentQuestion();
		Team turn = game.getCurrentTeamTurn();
		
		for(int i = 0; i < game.getNumberOfQuestions(); i++) {
			System.out.println(quest.getQuestionNumber()+": "+quest.getQuestionText());
			
			for (Option e:quest.getOptions()) {
				System.out.println(e.getOption()+" is "+e.isCorrect());
			}
			
			System.out.println("Question for "+turn.getName()+" team");
			game.nextQuestion();
			game.nextTurn();
			quest= game.getCurrentQuestion();
			turn = game.getCurrentTeamTurn();
		}
		
		
		
		
		
		
		
		
		/*
		________________________ TEAM TESTER ________________________
		Teams lista = new Teams();
		lista.createTeam("Primero", Color.BLUE);
		lista.createTeam("Segundo", Color.WHITE);
		lista.createTeam("Tercero", Color.RED);
		lista.createTeam("Cuarto", Color.BLACK);
		lista.createTeam("Quinto", Color.GRAY);
		lista.createTeam("Sexto", Color.GREEN);
		lista.createTeam("Septimo", Color.CYAN);
		lista.createTeam("Octavo", Color.MAGENTA);
		Team falla1 = lista.createTeam();// sin nada
		Team falla2 = lista.createTeam();// con nombre solo
		Team falla3 = lista.createTeam();// con todo seteado a mano
		
		Team turnos = lista.getFirst();
		for(int i = 0; i < 20; i++) {
			System.out.println("Primer turno: "+turnos.getName());
			turnos = lista.nextTurn(turnos);
		}
		
		lista.addTeam(falla1);
		falla2.setName("Falla2");
		lista.addTeam(falla2);
		falla3.setColor(Color.YELLOW);
		falla3.setName("Falla3");
		lista.addTeam(falla3);
		
		
		for(int i = 0; i < 20; i++) {
			System.out.println("Segunda pasada: "+turnos.getName());
			turnos = lista.nextTurn(turnos);
		}
		
		*/
		
		
		/*
		________________________ QUESTION TESTER ________________________
		String lineaLeida1 = "1;¿Que es el sol?;#Una estrella;Un planeta;Un asteroide;Un artefacto alienigena;Un gato;Ella;No me ama";
		String lineaLeida2 = "2;¿Que pasa si no hay opciones correctas?;Una estrella;Un planeta;Un asteroide;Una luna";
		String lineaLeida3 = "3;¿Que pasa si no hay opciones?;";
		String lineaLeida4 = "4;¿Cual es la ultima opcion?;Esta;Esta;#Esta";
		String lineaLeida5 = "5;¿Que pasa si tengo 2 opciones correctas?;#Nada;#Todo";
		Questions preguntas = new Questions();
		preguntas.createQuestion(lineaLeida1);
		preguntas.createQuestion(lineaLeida2);
		preguntas.createQuestion(lineaLeida3);
		preguntas.createQuestion(lineaLeida4);
		preguntas.createQuestion(lineaLeida5);
		
		ArrayList<Option> lista;
		Question creada;
		
		for(int i = 1; i < 6; i++) {
			creada = preguntas.getQuestion(i);
			System.out.println("Numero: "+creada.getQuestionNumber());
			System.out.println("texto: "+creada.getQuestionText());
			lista = creada.getOptions();
			for (Option e: lista) {
				System.out.println("Opcion: "+e.getOption()+" - Es correcta?: "+e.isCorrect());
			}
		}
		*/
	}
}

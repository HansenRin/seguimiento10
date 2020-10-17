package ui;
import model.*;
import java.util.*;
public class Main{

	public static Scanner sc = new Scanner(System.in);

	static Championship championshipx = new Championship(2020,10); 

	public static void main (String[] args){
		boolean stop = false;
		while (!stop){
			System.out.println(menu());
			stop = selection();
		}
	}

	private static String menu(){
		String message;
		message = " ____________________________________\n";
		message += "|       Menu Principal               |\n";
		message += "|____________________________________|\n";
		message += "|1: registrar campeonato             |\n";
		message += "|2: registrar corredor               |\n";
		message += "|3: mostrar promedios del campeonato |\n";
		message += "|4: terminar                         |\n";
		message += "|____________________________________|\n";
		
		return message;
	}

	private static boolean selection(){
		int option = Integer.parseInt(sc.nextLine());
		switch (option){
			case 1: registerChampionship(); break;
			case 2: registerPilot(); break;
			case 3: showAverage(); break;
			case 4: return true;
		}
		return false;
	}

	private static void registerChampionship(){
		System.out.println("ingresa el año del campeonato");
		int year = Integer.parseInt(sc.nextLine());

		System.out.println("ingresa la cantidad de carreras del campeonato");
		int races = Integer.parseInt(sc.nextLine());

		championshipx = new Championship(year, races);
	}

	private static void registerPilot(){
		System.out.println("ingresa nombre del piloto");
		String name = sc.nextLine();

		System.out.println("ingresa el año del edad del piloto");
		int age = Integer.parseInt(sc.nextLine());

		System.out.println("ingresa la escuderia del piloto");
		System.out.println(showScuderias());
		String team = sc.nextLine();
		
		System.out.println("ingresa los tiempos de la carrera en segundos");
		int[] scores = getScores(championshipx.getRaces());

		championshipx.addPilot(name, age, team, scores);
	}
	
	private static int[] getScores(int races){
		int[] scores = new int[races];
		for (int i = 0; i< races; i++){
			System.out.println("Ingrese el tiempo (en segundos) del piloto en la carrera "+(i+1));
			scores[i] = Integer.parseInt(sc.nextLine());
		}
		return scores;
	}


	private static String showScuderias(){
		String message = "SUCUDERIA_FERRARI \nMCLAREN_F1_TEAM \nRED_BULL_RACING \nMERCEDES_AMG \nRACING_POINT \nALFA_ROMEO \nRENAULT \nWILLIAMS";
		return message;
	}

	private static String showAverage(){
		String message = championshipx.showAverageTimes();
		return message;
	}
}
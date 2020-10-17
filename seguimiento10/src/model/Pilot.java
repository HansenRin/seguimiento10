package model;
public class Pilot{

	//atributos
	private String name;
	private int age;
	private int[] scores;
	private Team team;


	public Pilot(String name, int age, String scuderia, int[] scores){

		this.name = name;
		this.age = age;
		this.team = Team.valueOf(scuderia);
		this.scores = scores;
	}

	public String getName(){
		return this.name;
	}

	public int getAge(){
		return this.age;
	}

	public int[] getScores(){
		return this.scores;
	}

	public String getTeam(){
		return team+"";
	}

	public double calculateAverage(){
		double average=0;
		
		for (int i=0; i<scores.length; i++) {
			average += scores[i];
		}
		average = average/(scores.length);

		return average;
	}
}
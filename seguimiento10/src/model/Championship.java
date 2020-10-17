package model;
public class Championship{
	//constantes
	private static int MAXPILOT=15;
	//atributos
	private int year;
	private int races;

	//relations
	private Pilot[] pilots;

	//metodos
	public Championship(int year, int races){
		this.year = year;
		this.races = races;
		this.pilots = new Pilot[MAXPILOT];
	}

	public void addPilot(String name, int edad, String scuderia, int[] scores){
		boolean finished = false;
		for (int i = 0; i< pilots.length && !finished;i++){
			if (pilots[i] == null){
				pilots[i] = new Pilot(name, edad, scuderia, scores);
				finished = true;
			}
		}

	}	

	public boolean findPilot(String nombre){
		for (int i = 0; i< pilots.length; i++){
			if (pilots[i] != null && pilots[i].getName().equalsIgnoreCase(nombre) ){
				return true;
			}
		}
		return false;
	}

	public String showAverageTimes(){
		String message = "";
		for (int i = 0; i<pilots.length; i++){
			if (pilots[i]!= null){
				message += "nombre: "+pilots[i].getName()+" promedio: "+convertHourMinSec(pilots[i].calculateAverage())+"\n";
			}
		}

		return message;
	}

	public String convertHourMinSec(double time){
		String message = "";
		int hour, min, sec;
		hour = (int)time/3600;
	    min = (int)(time/60)%60;
	    sec = (int)time%60;
	    
	    message += hour+" : "+min+" : "+sec;

	    return message;
	}

	public int getYear(){
		return this.year;
	}

	public int getRaces(){
		return this.races;
	}
}
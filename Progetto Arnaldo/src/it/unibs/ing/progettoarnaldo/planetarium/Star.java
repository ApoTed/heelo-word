package it.unibs.ing.progettoarnaldo.planetarium;

import it.unibs.fp.mylib.InputDati;



public class Star extends HeavenlyBody {

	private static final String START_CREATION = "Crea la stella del tuo sistema stellare.";
	
	private static final String INSERT_STAR_NAME = "Inserire il nome della stella: ";
	private static final String INSERT_STAR_WEIGHT = "Inserire il peso della stella: ";
	
	
	// CONSTRUCTOR INHERITANCE
	public Star(String _name, double _weight, Position _position) {
		super(_name, _weight, _position, null);
		
	}

	// CONSTRUCTOR WITHOUT FORMAL PARAMETERS
	public Star() {
	
	}


	// THIS METHOD CREATES A STAR
	public Star generateStar () 
	{
		System.out.println(START_CREATION);
		String starName = InputDati.leggiStringaNonVuota(INSERT_STAR_NAME);
		double starWeight = InputDati.leggiDouble(INSERT_STAR_WEIGHT);
		
		Position position = new Position (0,0);
		
		Star star = new Star(starName, starWeight, position);
		
		return star;
	}

	
	public void showStar() {
		System.out.println(toString());
	}
	
	
	@Override
	public String toString() {
		StringBuffer description_star = new StringBuffer();
		
		description_star.append("\n NOME: " + this.getName());
		description_star.append("\n PESO: " + this.getWeight());
		description_star.append("\n POSIZIONE: " + this.getPosition());
		
		return description_star.toString();
	}

	
	
	

	
}

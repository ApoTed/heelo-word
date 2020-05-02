package it.unibs.ing.progettoarnaldo.planetarium;

import java.util.ArrayList;



public class HeavenlyBody {
	
	private static final double MIN_WEIGHT = 0.00000001;
	
	public static double getMinWeight() 
	{
		return MIN_WEIGHT;
	}

	
	private String name;
	private double weight;
	private Position position;
	private ArrayList <Satellite> satellites= new ArrayList <Satellite>();
	
	
	// CONSTRUCTOR
	public HeavenlyBody(String _name, double _weight,  Position _position, ArrayList <Satellite> _satellites) {
		super();
		this.weight = _weight;
		this.name = _name;
		this.position = _position;
		this.satellites= _satellites;
	}
	
	
	public HeavenlyBody () {
		
	}

	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public ArrayList<Satellite> getSatellites() {
		return satellites;
	}


	public void setSatellites(ArrayList<Satellite> satellites) {
		this.satellites = satellites;
	}

	
	

	@Override
	public String toString() {
		
		StringBuffer description_HB = new StringBuffer();
		
		description_HB.append("CORPICELESTI");
		description_HB.append("NOME: " + getName());
		description_HB.append("PESO: " + getWeight());
		description_HB.append("POSIZIONE: " + getPosition());
		
		return description_HB.toString();
	}
	
	

}

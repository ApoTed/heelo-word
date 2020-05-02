package it.unibs.ing.progettoarnaldo.planetarium;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;


public class SolarSistem {
	
	private static final String INSERT_SOLARSISTEM_NAME = "Inserire il nome del Sistema Stellare: ";
	
	private static final String INSERT_PLANET_NAME = "Inserire nome del pianeta: ";
	
	private String name;
	private Star star;
	private ArrayList <Planet> planets = new ArrayList <Planet> ();
	
	private Star starMain;
	
	// CONSTRUCTOR INHERITANCE
	public SolarSistem(String _name, Star _star, ArrayList<Planet> _planets) {
		super();
		this.name = _name;
		this.star = _star;
		this.planets = _planets;
	}
	
	// CONSTRUCTOR WITHOUT FORMAL PARAMETERS
	public SolarSistem() {

	}

	

	// THIS METHOD CREATES A SOLARSISTEM
	public SolarSistem generateSolarSistem () 
	{
		name = InputDati.leggiStringaNonVuota(INSERT_SOLARSISTEM_NAME);
		
		System.out.println("");
		
		Star star_method = new Star();
		star_method = star_method.generateStar();
		
		System.out.println("");
		
		Planet planet_method = new Planet();
		planet_method = planet_method.generatePlanet();
	
		this.planets.add(planet_method);
		
		starMain = star_method;
		
		SolarSistem solarSistem = new SolarSistem (name, star_method, planets);
		
		
		return solarSistem;
	}

	
	
	
	// THIS METHOD ADDS A PLANET
	public void addPlanet (Planet newPlanet) 
	{
		newPlanet = newPlanet.generatePlanet();
		
		boolean found = false;
		
		for (int i = 0; i < this.planets.size(); i++) 
		{
			String namePlanTest2 = this.planets.get(i).getName();
			
			if(namePlanTest2.equalsIgnoreCase(newPlanet.getName()))
			{
				System.out.println("Trovato");
				System.out.println("Il pianeta è gia esistente");
				found = true;
			}
	    }
		
		if (found == false) 
		{
			System.out.println("Il pianeta non è già presente e verrà aggiunto all'arrayPlanets");
			this.planets.add(newPlanet);
		}
			
	}
		

	// THIS METHOD REMOVES A PLANET
	public void removePlanet (Planet deletePlanet) 
	{
		deletePlanet.setName(InputDati.leggiStringaNonVuota(INSERT_PLANET_NAME + "da eliminare "));
		
		boolean fuond1 = false;
		
		for (int i = 0; i < this.planets.size(); i++) 
		{
			String namePlanTest2 = this.planets.get(i).getName();
			
			if(namePlanTest2.equalsIgnoreCase(deletePlanet.getName()))
			{
				System.out.println("Trovato");
				int pos = i;
				System.out.println("Il pianeta verrà eliminato");
				this.planets.remove(pos);
				fuond1 = true;
			}
	    }
		
		if (fuond1 == false)
			System.out.println("Pianeta non presente. Impossibile rimuoverlo.");
		
		System.out.println("" + "Lunghezza array Planets: " + this.planets.size());
	}
	
	

	
	
	// THIS METHOD SHOWS A PLANET
	public void showPlanet() 
	{
		String nameP = InputDati.leggiStringaNonVuota("Inserire il nome del pianeta da vedere: ");
		
		boolean fuond2 = false;
		
		for (int i = 0; i < this.getPlanets().size(); i++) 
		{
			Planet pTest = new Planet();
			pTest = this.getPlanets().get(i);
			String namePTest  = pTest.getName();
			
			if(namePTest.equalsIgnoreCase(nameP))
			{
			    System.out.println("Pianeta trovato");
			    pTest.showPlanet();
			    fuond2 = true;
			}
			
		}
		
		if (fuond2 == false)
			System.out.println("Pianeta non trovato");
		
	}
	

	// THIS METHOD FINDS A PLANET
	public boolean findPlanet (Planet p2) 
	{
		boolean fuond3 = false;
		
		for(int i = 0; i < this.planets.size(); i++) 
		{
			if (this.planets.get(i).getName().equalsIgnoreCase(p2.getName())) 
			{
				//System.out.println("Trovato");
				fuond3 = true;
			}
		}
		
		//if (fuond2 == false)
			//System.out.println("Non trovato");
		
		return fuond3;
	}
		
	
	public double totalWeightPlanets () 
	{
		double totWeight = 0;
		
		for (int i = 0; i < this.planets.size(); i++) 
			totWeight = totWeight + this.planets.get(i).getWeight();
	
		totWeight = totWeight + starMain.getWeight();
		
		return totWeight;
	}

	// bisogna sistemare questo metodo
	public double totalWeightSatellites1() 
	{
		double totalWeightSatellites = 0;

		//totalWeightSatellites = totalWeightSatellites + totalWeightSatellites();
		
		return totalWeightSatellites;
	}
	
	
	public double totPositionX () 
	{
		double totPX = 0;
		
		for (int i = 0; i < this.planets.size(); i++) 
			totPX = totPX + this.planets.get(i).getPosition().getX();
		
		return totPX;
	}
	
	
	public double totPositionY () 
	{
		double totPY = 0;
		
		for (int i = 0; i < this.planets.size(); i++) 
			totPY = totPY + this.planets.get(i).getPosition().getY();
		
		return totPY;
	}
	
	
	
	public Position weightCentreCalculator () 
	{
		Position weightCentre = new Position();
		
		double weightTOT = /*totalWeightSatellites1() +*/ totalWeightPlanets();
		
		double xCDM = totPositionX()/weightTOT;
		double yCDM = totPositionY()/weightTOT;
		
		weightCentre.setX(xCDM);
		weightCentre.setY(yCDM);
		
		weightCentre = new Position (xCDM, yCDM);
		
		return weightCentre;
	}
	
	
	
	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Star getStar() {
		return star;
	}
	
	public void setStar(Star star) {
		this.star = star;
	}
	
	public ArrayList<Planet> getPlanets() {
		return planets;
	}
	
	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}
	

	
	public void showSolarSistem () 
	{
		System.out.println("\nSOLAR SISTEM: " + name);
		System.out.println("\nSTELLA PRINCIPALE: " + starMain.toString());
		System.out.println("\nCENTRO DI MASSA: " + weightCentreCalculator()); // bisogna sistemare le cifre significative
		System.out.println("\nPIANETI: " + this.planets);
	}
	

	
		
	@Override
	public String toString() 
	{
		
		StringBuffer description_SS = new StringBuffer();
		
		description_SS.append("SOLAR SISTEM: " + name);
		description_SS.append("STELLA: " + starMain.toString());
		description_SS.append("PIANETI: " + planets);
		
		return description_SS.toString();
	}
	
	
	
}

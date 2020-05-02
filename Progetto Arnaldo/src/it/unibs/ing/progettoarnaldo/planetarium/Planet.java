package it.unibs.ing.progettoarnaldo.planetarium;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;




public class Planet extends HeavenlyBody {
	
	private static final String INSERT_PLANET_NAME = "Inserire nome del pianeta: ";
	private static final String INSERT_PLANET_WEIGHT = "Inserire il peso del pianeta: ";
	private static final String INSERT_POSITION_X = "Inserire coordinata x: ";
	private static final String INSERT_POSITION_Y = "Inserire coordinata y: ";
	
	private static final String INSERT_SATELLITE_NAME = "Inserire nome del satellite: ";

	private static final String PLANET_CREATION = "\nCrea il pianeta del tuo sistema stellare.";
	private static final String MOON_CREATION = "\nVuole inserire una Luna ?\n 1. SÌ \n 2. NO\nDigitale l'opzione scelta: ";
	
	
	// CONSTRUCTOR INEHRITANCE
	public Planet (String _name, double _weight, Position _position, ArrayList<Satellite> _satellites) {
		super(_name, _weight, _position, _satellites);
	}
	
	// CONSTRUCOTR WITHOUT FORMAL PARAMETERS
	public Planet() {
	
	}


	// THIS METHOD CREATES THE PLANET
	public Planet generatePlanet () 
	{
		System.out.println(PLANET_CREATION);
	
		String namePlanet = InputDati.leggiStringaNonVuota(INSERT_PLANET_NAME);
		double weightPlanet = InputDati.leggiDoubleConMinimo(INSERT_PLANET_WEIGHT, getMinWeight());
		
		Position position = new Position();
		position.setX(InputDati.leggiDouble(INSERT_POSITION_X));
		position.setY(InputDati.leggiDouble(INSERT_POSITION_Y));
		
		int temp = 0;
		
		do {
			
			temp = InputDati.leggiIntero(MOON_CREATION, 1, 2);
			
			if (temp == 1) 
			{
				Satellite satellite = new Satellite();
				satellite = satellite.generateSatellite();
				getSatellites().add(satellite);
			}
			
		} while (temp == 1);
		
		
		Planet planet = new Planet(namePlanet, weightPlanet, position, getSatellites());
		
		System.out.println("array satellite lungh (metodo generatePlanet): " + getSatellites().size());
		
		return planet;
		
	}
	
	// THIS METHOD ADDS A SATELLITE
	public void addSatellite (Satellite newSat1) 
	{
		// Inserisce il satellite ai Pianeti che non hanno satelliti
		
		newSat1 = newSat1.generateSatellite();
		
		boolean fuond1 = false;
		
		for (int i = 0; i < this.getSatellites().size(); i++) 
		{
			String nameSatTest1 = this.getSatellites().get(i).getName();
			
			if(nameSatTest1.equalsIgnoreCase(newSat1.getName()))
			{
				System.out.println("Trovato");
				System.out.println("Il satellite è gia esistente");
				fuond1 = true;
			}
	    }
		
		if (fuond1 == false) 
		{
			System.out.println("Il satellite non è già presente e verrà aggiunto all'arraySatellites");
			this.getSatellites().add(newSat1);
		}
		
		System.out.println("array satellite lungh (metodo add): " + getSatellites().size());
	}
	
		
		
		
	// THIS METHOD REMOVES A SATELLITE
	public void removeSatellite (Satellite deleteSatellite) 
	{
		deleteSatellite.setName(InputDati.leggiStringaNonVuota(INSERT_SATELLITE_NAME));
		
		boolean fuond2 = false;
		
		for (int i = 0; i < this.getSatellites().size(); i++) 
		{
			String nameSatTest2 = this.getSatellites().get(i).getName();
			
			if(nameSatTest2.equalsIgnoreCase(deleteSatellite.getName()))
			{
				System.out.println("Trovato");
				int pos = i;
				System.out.println("Il satellite verrà eliminato");
				this.getSatellites().remove(pos);
				fuond2 = true;
			}
	    }
		
		if (fuond2 == false)
			System.out.println("Satellite non presente. Impossibile rimuoverlo.");
		
		System.out.println("" + "Lunghezza arraySatellites: " + getSatellites().size());	
	}

	
	
	// THIS METHOD SHOWS A SATELLITE
	public void showSatellites(Planet p) 
	{
		Satellite s_prova = new Satellite();
		
		String nameP = InputDati.leggiStringaNonVuota("\nInserire il nome del satellite da vedere: ");
		
		boolean fuond3 = false;
		
		for (int i = 0; i < p.getSatellites().size(); i++) 
		{
			s_prova = this.getSatellites().get(i);
			String nameSTest  = s_prova.getName();	
			
			if(nameSTest.equalsIgnoreCase(nameP))
			{
				System.out.println("Trovato");
				s_prova.showSatellite();
				fuond3 = true;
			}
	    }
		
		if (fuond3 == false) 
			System.out.println("Non trovato");
	
	}
	

	public double totalWeightSatellites() 
	{
		double totalWeightSatellites = 0;
		
		for (int i = 0; i < getSatellites().size(); i++)
			totalWeightSatellites = totalWeightSatellites + getSatellites().get(i).getWeight();
		
		return totalWeightSatellites;
	}
	
	
	
	public void showPlanet() 
	{
		System.out.println(toString());
	}
	
	
	
	@Override
	public String toString() {
		
		StringBuffer description_planet = new StringBuffer();
		
		description_planet.append("\nPIANETA");
		description_planet.append("\n NOME: " + this.getName());
		description_planet.append("\n PESO: " + this.getWeight());
		description_planet.append("\n POSIZIONE: " + this.getPosition().toString());;
		description_planet.append("\n SATELLITI: " + getSatellites());
		
		return description_planet.toString();
	}
	
	
	
	
	
}

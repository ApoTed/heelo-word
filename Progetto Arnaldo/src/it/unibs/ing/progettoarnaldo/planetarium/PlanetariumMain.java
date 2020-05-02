package it.unibs.ing.progettoarnaldo.planetarium;


public class PlanetariumMain {
	
	private static final String INITIAL_MESSAGE = "BENVENUTO NEL PLANETARIO !";
	private static final String FINAL_MESSAGE = "\nARRIVEDERCI. ALLA PROSSIMA NOVITA'";	
	
	
	public static void main(String[] args) {
		
		System.out.println(INITIAL_MESSAGE);
		
		SolarSistem solarSistem = new SolarSistem();
		
		System.out.println("\nCREA IL SISTEMA SOLARE" + "");
		solarSistem.generateSolarSistem();
		
		Menu.startStellarSistem(solarSistem);
		
		System.out.println(FINAL_MESSAGE); 
		
	}


	
}

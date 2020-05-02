package it.unibs.ing.progettoarnaldo.planetarium;

import it.unibs.fp.mylib.InputDati;



public class Menu {
	
	private static final String MAIN_MENU = "\nMENU PRINCIPALE\n"
			+ "1. Modificare Sistema Stellare\n"
			+ "2. Visualizzare\n"
			+ "3. Collisioni\n"
			+ "0. Esci\n";
	
	private static final String CHANGE_MENU = "\nMENU DI MODIFICA\n"
			+ "1. Aggiungere Pianeta\n"
			+ "2. Rimuovere Pianeta\n"
			+ "3. Aggiungere Satellite\n"
			+ "4. Rimuovere Satellite\n"
			+ "0. Torna al MENU PRINCIPALE\n";
	
	private static final String DIPLAY_MENU = "\nMENU DI VISUALIZZAZIONE\n"
			+ "1. Sistema Solare\n"
			+ "2. Pianeta\n"
			+ "3. Satellite\n"
			+ "0. Torna al MENU PRINCIPALE\n";
	
			
	public static void startStellarSistem (SolarSistem solarSistem) 
	{
	
		/* MENU DI SCELTA */
		int choice = - 1;
		
		Planet planet_1 = new Planet();
		
		do {
			
			System.out.println(MAIN_MENU);
									
			choice = InputDati.leggiIntero("Digitare l'opzione scelta: ", 0, 3);
										
				
			switch (choice) {
					
				case 1: 
					System.out.println("");
					
					Satellite satellite_1 = new Satellite();
					
					do {
						
						System.out.println(CHANGE_MENU);
						
						choice = InputDati.leggiIntero("Digitare l'opzione scelta: ", 0, 5);
						
						switch (choice) 
						{
							case 1:
								solarSistem.addPlanet(planet_1);
								break;
								
							case 2:
								solarSistem.removePlanet(planet_1);
								break;
								
							case 3:
								planet_1.addSatellite(satellite_1);
								break;
								
							case 4:
								planet_1.removeSatellite(satellite_1);
								break;
		
						}
						
					} while (choice != 0);
					
					choice = - 1;
					
					break;
					
				case 2:
					System.out.println("");
					
					
					do {
						
						System.out.println(DIPLAY_MENU);
						
						choice = InputDati.leggiIntero("Digitare l'opzione scelta: ", 0, 4);
						
						switch (choice) 
						{
							case 1: //toString del SolarSistem
								//solarSistem.toString();
								solarSistem.showSolarSistem();
								break;
								
							case 2: //toString dei Pianeti
								solarSistem.showPlanet();
								break;
								
							case 3: //toString dei Satelliti
								planet_1.showSatellites(planet_1);
								break;
		
						}
						
					} while (choice != 0);
				
					choice = - 1;
					
					break;
					
				case 3:
					break;
			
				default:
						break;
		
			}
						


		} while (choice != 0);
	
	}
	
}

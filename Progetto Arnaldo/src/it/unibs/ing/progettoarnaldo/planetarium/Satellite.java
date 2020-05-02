package it.unibs.ing.progettoarnaldo.planetarium;


import it.unibs.fp.mylib.InputDati;


public class Satellite extends HeavenlyBody {
	
	private static final String SATELLITE_CREATION = "\nCrea il satellite del tuo sistema stellare.";
	
	private static final String INSERT_POSITION_X = "Inserire coordinata x: ";
	private static final String INSERT_POSITION_Y = "Inserire coordinata y: ";
	private static final String INSERT_SATELLITE_WEIGHT = "Inserire il peso del satellite: ";
	private static final String INSERT_SATELLITE_NAME = "Inserire nome del satellite: ";

	
	// CONSTRUCTOR INHERIDANCE
	public Satellite(String _name, double _weight, Position _position) {
		super(_name, _weight, _position, null);
	}

	// CONSTRUCOTR WITHOUT FORMAL PARAMETERS
	public Satellite () {
		
	}
	
	
	public Satellite generateSatellite () 
	{
		System.out.println(SATELLITE_CREATION);
		
		String name = InputDati.leggiStringaNonVuota(INSERT_SATELLITE_NAME);
		double weight = InputDati.leggiDoubleConMinimo(INSERT_SATELLITE_WEIGHT, getMinWeight());
		
		Position position = new Position();
		position.setX(InputDati.leggiDouble(INSERT_POSITION_X));
		position.setY(InputDati.leggiDouble(INSERT_POSITION_Y));
		
		Satellite satellite = new Satellite (name, weight, position);
		
		getSatellites().add(satellite);
		
		System.out.println("array satellites (metodo generateSatellite): " + getSatellites().size());
		
		return satellite;
	}
	
	
	public void showSatellite () {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		
		StringBuffer description_satellite = new StringBuffer();
		
		description_satellite.append("  NOME: " + this.getName() );
		description_satellite.append("  PESO: " + this.getWeight());
		description_satellite.append("  POSIZIONE: " + this.getPosition());;
		
		return description_satellite.toString();
	}
	
	
}

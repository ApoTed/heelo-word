package it.unibs.ing.progettoarnaldo.planetarium;


public class Position {
	
	private double x;
	private double y;
	
	
	public Position(double _x, double _y) {
		super();
		this.x = _x;
		this.y = _y;
	}


	public Position() {
	
	}


	
	
	
	public boolean samePosition (Position p ) 
	{
		if (p.getX() == this.x && p.getY() == this.y)
			return true;
		
		return false;
	}
	
	
	
	
	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}
	
	

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	

}

package fr.newlife.mars.granolita.domain;

/**
 * Cartesian coordinate
 * 
 * @author JM
 *
 */
public class Coordinate {
	
	private int x;
	private int y;
	
	/**
	 * Constructor
	 * @param x pos x
	 * @param y pos y
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public static Coordinate add(Coordinate leftCoord, Coordinate rightCoord) {
		return new Coordinate(leftCoord.x + rightCoord.x, leftCoord.y + rightCoord.y);
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	

}

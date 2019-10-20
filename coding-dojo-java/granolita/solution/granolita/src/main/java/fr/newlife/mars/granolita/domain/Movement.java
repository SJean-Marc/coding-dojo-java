package fr.newlife.mars.granolita.domain;

/**
 * Rocket one movement
 * 
 * @author JM
 *
 */
public class Movement {
	
	/**
	 * X and Y position 
	 */
	private Coordinate coordinate;
	
	/**
	 * Orientation go to the left, to the right, up or down
	 */
	private OrientationEnum orientation;
	
	
	/**
	 * Constructor
	 * 
	 * @param x x cartesian coordinate
	 * @param y y cartesian coordinate
	 * @param orientation movement orientation (left,right,up,down)
	 */
	public Movement(int x, int y, OrientationEnum orientation) {
		this.coordinate = new Coordinate(x, y);
		this.orientation = orientation;
	}
	
	public static Movement sum(Movement left, Movement right) {
		Coordinate newCoord = Coordinate.add(left.coordinate, right.coordinate);
		return new Movement(newCoord.getX(), newCoord.getY(), left.orientation);
	}

	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @return the orientation
	 */
	public OrientationEnum getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(OrientationEnum orientation) {
		this.orientation = orientation;
	}
	
	@Override
	public String toString() {
		return this.orientation.name() + "(" + this.getCoordinate().getX() + ":" 
					+ this.getCoordinate().getY() + ")";
	}

}

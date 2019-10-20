package fr.newlife.mars.granolita.domain;

import java.util.List;

/**
 * 
 * Space rocket launched
 * @author JM
 *
 */
public class Rocket {
	
	/**
	 * List of movement used on the rocket 
	 */
	List<Movement> moves;

	/**
	 * @return the moves
	 */
	public List<Movement> getMoves() {
		return moves;
	}

	/**
	 * @param moves the moves to set
	 */
	public void setMoves(List<Movement> moves) {
		this.moves = moves;
	}
	
}
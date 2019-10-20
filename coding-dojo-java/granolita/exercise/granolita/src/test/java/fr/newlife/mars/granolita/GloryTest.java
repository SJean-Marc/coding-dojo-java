 package fr.newlife.mars.granolita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.newlife.mars.granolita.domain.Movement;
import fr.newlife.mars.granolita.domain.OrientationEnum;
import fr.newlife.mars.granolita.domain.Rocket;
import fr.newlife.mars.granolita.service.GloryService;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Unit test for simple App.
 */
public class GloryTest
{	
	
	@Test
	public void testSuccessMission() {
		/*Get the rocket to save*/
		Rocket rocket = getRocket();
		
		/* Step 1 : Remove UP orientation*/
		
		/* Step 2 : Split list into 2 sub list, 
		 * the first contains elements which respect :  X >= 0 and Y <= 200
		 * and the left one will be on the second list
		 * 
		 * ==> The first list will be called VALID LIST 
		 * and the other one will be INVALID LIST 
		 * */
		
		/* Step 3 : In each list sum each movement group by its orientation, at the end, the 2 list
		 * should be like {(DOWN:X), (LEFT:Y), (RIGHT:Z)}*/
		
		/* Step 4 : Print the result of the two list into a string on the following format
		 * "Valid : DOWN(Z:P),LEFT(M:L),RIGHT(O:R).Invalid : DOWN(Z:P),LEFT(M:L),RIGHT(O:R).
		 * 
		 * 
		 * Hint :
		 * - Movement.toString return the following DOWN(Z:P) for a DOWN movement
		 * - Movement.sum can be useful to sum two Object Movemnt
		 * - The string start with Valid/Invalid
		 * - Each subList string finish with .
		 */

		
		assertThat(GloryService.gloryFunction(rocket))
				.isEqualTo("Valid : DOWN(1000:1550),LEFT(450:1000),RIGHT(450:1000).Invalid : DOWN(400:900),LEFT(-100:400),RIGHT(-100:400).");
		
	}
	
	
	
	private Rocket getRocket() {
		Rocket rocket = new Rocket();
		/*Create movements */
		List<Movement> movements = new ArrayList<>();
		movements.addAll(getHorizontalMovement(OrientationEnum.LEFT));
		movements.addAll(getHorizontalMovement(OrientationEnum.RIGHT));
		movements.addAll(getVerticalMovement(OrientationEnum.UP));
		movements.addAll(getVerticalMovement(OrientationEnum.DOWN));
		
		/*Update rocket*/
		rocket.setMoves(movements);
		
		return rocket;
	}
	
	private List<Movement> getHorizontalMovement(OrientationEnum orieEnum) {
		int initPosX = 100;
		int initPosY = 100;
		
		Movement mov = new Movement(initPosX - 10, initPosY, orieEnum);
		Movement mov2 = new Movement(initPosX - 20, initPosY, orieEnum);
		Movement mov3 = new Movement(initPosX - 30, initPosY, orieEnum);
		Movement mov4 = new Movement(initPosX - 40, initPosY, orieEnum);
		Movement mov5 = new Movement(initPosX - 50, initPosY, orieEnum);
		Movement mov6 = new Movement(initPosX - 60, initPosY, orieEnum);
		Movement mov7 = new Movement(initPosX - 70, initPosY, orieEnum);
		Movement mov8 = new Movement(initPosX - 80, initPosY, orieEnum);
		Movement mov9 = new Movement(initPosX - 90, initPosY, orieEnum);
		Movement mov10 = new Movement(initPosX - 100, initPosY, orieEnum);
		Movement mov11 = new Movement(initPosX - 110, initPosY, orieEnum);
		Movement mov12 = new Movement(initPosX - 120, initPosY, orieEnum);
		Movement mov13 = new Movement(initPosX - 130, initPosY, orieEnum);
		Movement mov14 = new Movement(initPosX - 140, initPosY, orieEnum);
		
		return Arrays.asList(mov, mov2, mov3, mov4, mov5, mov6, mov7, mov8, mov9, mov10,
				mov11, mov12, mov13, mov14);
	}
	
	private List<Movement> getVerticalMovement(OrientationEnum orieEnum) {
		int initPosX = 100;
		int initPosY = 100;
		
		Movement mov = new Movement(initPosX, initPosY + 10, orieEnum);
		Movement mov2 = new Movement(initPosX, initPosY + 20, orieEnum);
		Movement mov3 = new Movement(initPosX, initPosY + 30, orieEnum);
		Movement mov4 = new Movement(initPosX, initPosY + 40, orieEnum);
		Movement mov5 = new Movement(initPosX, initPosY + 50, orieEnum);
		Movement mov6 = new Movement(initPosX, initPosY + 60, orieEnum);
		Movement mov7 = new Movement(initPosX, initPosY + 70, orieEnum);
		Movement mov8 = new Movement(initPosX, initPosY + 80, orieEnum);
		Movement mov9 = new Movement(initPosX, initPosY + 90, orieEnum);
		Movement mov10 = new Movement(initPosX, initPosY + 100, orieEnum);
		Movement mov11 = new Movement(initPosX, initPosY + 110, orieEnum);
		Movement mov12 = new Movement(initPosX, initPosY + 120, orieEnum);
		Movement mov13 = new Movement(initPosX, initPosY + 130, orieEnum);
		Movement mov14 = new Movement(initPosX, initPosY + 140, orieEnum);
		
		return Arrays.asList(mov, mov2, mov3, mov4, mov5, mov6, mov7, mov8, mov9, mov10,
				mov11, mov12, mov13, mov14);
	}



}

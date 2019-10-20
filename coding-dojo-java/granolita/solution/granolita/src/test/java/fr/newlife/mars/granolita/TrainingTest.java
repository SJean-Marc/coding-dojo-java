package fr.newlife.mars.granolita;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import fr.newlife.mars.granolita.domain.Coordinate;
import fr.newlife.mars.granolita.service.TrainingService;

/**
 * Unit test for simple App.
 */
public class TrainingTest {	
	
	/**
	 * From a list of coordinates, 
	 * return a map with all possible value for X coordinate (as the key)
	 * and for each key we have the list for coordinates associated
	 */
	@Test
	public void testGetMapByXPos() {
		Coordinate coord1 = new Coordinate(10, 99);
		Coordinate coord2 = new Coordinate(20, 100);
		Coordinate coord3 = new Coordinate(10, 101);
		Coordinate coord4 = new Coordinate(20, 10);
		Coordinate coord5 = new Coordinate(100, 20);
		Coordinate coord6 = new Coordinate(101, 30);
		
        List<Coordinate> coordinates = asList(coord1, coord2, coord3, coord4, coord5, coord6);
        Map<Integer, List<Coordinate>> result = TrainingService.getMapByXPos(coordinates);
        Assertions.assertThat(result.get(10)).hasSameElementsAs(asList(coord1, coord3));
        Assertions.assertThat(result.get(20)).hasSameElementsAs(asList(coord2, coord4));
        Assertions.assertThat(result.get(100)).hasSameElementsAs(asList(coord5));
        Assertions.assertThat(result.get(101)).hasSameElementsAs(asList(coord6));
	}
	
	/**
	 * Get all X position, sort in order X and concat string
	 */
	@Test
	public void testToString() {
		Coordinate coord1 = new Coordinate(10, 99);
		Coordinate coord2 = new Coordinate(20, 100);
		Coordinate coord3 = new Coordinate(10, 101);
		Coordinate coord4 = new Coordinate(20, 10);
		Coordinate coord5 = new Coordinate(100, 20);
		Coordinate coord6 = new Coordinate(101, 30);
		
        List<Coordinate> coordinates = asList(coord1, coord2, coord3, coord4, coord5, coord6);
        String result = TrainingService.toString(coordinates);
        Assertions.assertThat(result).isEqualTo("[10,10,20,20,100,101]");
	}
	
	/**
	 * Get all Y position and sum them
	 */
	@Test
	public void testSumPosY() {
		Coordinate coord1 = new Coordinate(10, 99);
		Coordinate coord2 = new Coordinate(20, 100);
		Coordinate coord3 = new Coordinate(10, 101);
		Coordinate coord4 = new Coordinate(20, 10);
		Coordinate coord5 = new Coordinate(100, 20);
		Coordinate coord6 = new Coordinate(101, 30);
		
        List<Coordinate> coordinates = asList(coord1, coord2, coord3, coord4, coord5, coord6);
        Integer result = TrainingService.sumPosY(coordinates);
        Assertions.assertThat(result).isEqualTo(360);
	}
	
	
	/**
	 * From a list of coordinate return a map 
	 * with key value true/false :
	 *  - true key return list of coordinates with X >= 100
	 *  - false key return coordinates not present in the first list
	 */
	@Test
	public void testSubList() {
		/*Y around 100*/
		Coordinate coord1 = new Coordinate(10, 99);
		Coordinate coord2 = new Coordinate(20, 100);
		Coordinate coord3 = new Coordinate(30, 101);
		
		/*X around 100*/
		Coordinate coord4 = new Coordinate(99, 10);
		Coordinate coord5 = new Coordinate(100, 20);
		Coordinate coord6 = new Coordinate(101, 30);
		
        List<Coordinate> coordinates = asList(coord1, coord2, coord3, coord4, coord5, coord6);
        Map<Boolean, List<Coordinate>> result = TrainingService.subList(coordinates);
        Assertions.assertThat(result.get(true)).hasSameElementsAs(asList(coord5, coord6));
        Assertions.assertThat(result.get(false)).hasSameElementsAs(asList(coord1, coord2, coord3, coord4));
	}
	
	
	/**
	 * From a list of coordinate return a map 
	 * with key value true/false :
	 *  - true key return list of coordinates with X >= 100
	 *  - false key return coordinates not present in the first list
	 */
	@Test
	public void testCountSubList() {
		/*Y around 100*/
		Coordinate coord1 = new Coordinate(10, 99);
		Coordinate coord2 = new Coordinate(20, 100);
		Coordinate coord3 = new Coordinate(30, 101);
		
		/*X around 100*/
		Coordinate coord4 = new Coordinate(99, 10);
		Coordinate coord5 = new Coordinate(100, 20);
		Coordinate coord6 = new Coordinate(101, 30);
		
        List<Coordinate> coordinates = asList(coord1, coord2, coord3, coord4, coord5, coord6);
        Map<Boolean, Long> result = TrainingService.countSubList(coordinates);
        Assertions.assertThat(result.get(true)).isEqualTo(2L);
        Assertions.assertThat(result.get(false)).isEqualTo(4L);
	}


}

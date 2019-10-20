package fr.newlife.mars.granolita.service;

import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.joining;

import fr.newlife.mars.granolita.domain.Movement;
import fr.newlife.mars.granolita.domain.OrientationEnum;
import fr.newlife.mars.granolita.domain.Rocket;

/**
 * Services for the glory phase
 * 
 * @author JM
 *
 */
public final class GloryService{
	
	public static String gloryFunction(Rocket rocket) {
		Map<Boolean, Map<OrientationEnum, Optional<Movement>>> result = rocket.getMoves()
			.stream()
			//Remove up orientation
			.filter(t -> !OrientationEnum.UP.equals(t.getOrientation()))
			// Separate invalid coordinate with valid one then group by orientation + Sum
			// Hint : Movement.sum can be useful
			.collect(partitioningBy(validCoordinates(), 
					groupingBy(Movement::getOrientation, reducing((t1,t2) -> Movement.sum(t1, t2)))));
			
		
		// Print result
		return formatMap(result.get(true), "Valid") + formatMap(result.get(false), "Invalid");

	}
	
	/**
	 * Predicate for valid coordinates
	 * 
	 * @return Predicate<Movement>
	 */
	private static Predicate<Movement> validCoordinates() {
		return t -> t.getCoordinate().getX() >= 0 && t.getCoordinate().getY() <= 200;
	}
	
	/**
	 * Format map to string
	 * @param map map
	 * @return map to string
	 */
	private static String formatMap(Map<OrientationEnum, Optional<Movement>> map, String prefix) {
		return map.entrySet().stream()
							 .filter(t -> t.getValue().isPresent())
							 .collect(Collectors.toMap(
									 	e -> e.getKey(), 
									 	e -> e.getValue().get()))
							 .entrySet()
							 .stream()
							 .sorted(Map.Entry.comparingByKey((t1, t2) -> t1.name().compareTo(t2.name())))
							 .map(t -> t.getValue().toString())
							 .collect(joining(",", prefix + " : ", "."));
	}


}
	
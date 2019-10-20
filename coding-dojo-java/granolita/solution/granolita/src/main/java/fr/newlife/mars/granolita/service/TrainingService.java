package fr.newlife.mars.granolita.service;

import java.util.Map;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.counting;

import fr.newlife.mars.granolita.domain.Coordinate;

/**
 * Services for the training phase
 * 
 * @author JM
 *
 */
public final class TrainingService{
	
	
    public static Map<Integer, List<Coordinate>> getMapByXPos(List<Coordinate> coordinates) {
    	return coordinates
    			.stream()
    			.collect(groupingBy(Coordinate::getX));
    }
    
    public static Integer sumPosY(List<Coordinate> coordinates) {
    	return coordinates.stream()
    						.map(Coordinate::getY)
    						.reduce(0, (t1, t2) -> t1+t2);
    }
    
    public static String toString(List<Coordinate> coordinates) {
    	return coordinates 
    			.stream()
    			.map(Coordinate::getX)
    			.sorted()
    			.map(t -> Integer.toString(t))
    			.collect(joining(",", "[", "]"));
    }
    
    public static Map<Boolean, List<Coordinate>> subList(List<Coordinate> coordinates) {
    	return coordinates
        		.stream()
        		.collect(partitioningBy(t -> t.getX() >= 100));
    }
    
    public static Map<Boolean, Long> countSubList(List<Coordinate> coordinates) {
    	return coordinates
        		.stream()
        		.collect(partitioningBy(t -> t.getX() >= 100, counting()));
    }


}
	
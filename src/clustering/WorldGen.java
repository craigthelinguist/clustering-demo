package clustering;

import geometry.Circle;
import geometry.Point;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class WorldGen {

	// Constructors.
	// ------------------------------------------------
	private WorldGen(){}
	
	// Class methods.
	// ------------------------------------------------
	
	public static List<Point> makeWorld(int numPoints, Dimension dimensions){
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < numPoints; i++){
			Point point = null;
			boolean intersecting = true;
			while (intersecting){
				intersecting = false;
				int x = (int)(Math.random()*dimensions.getWidth());
				int y = (int)(Math.random()*dimensions.getHeight());
				point = new Point(x,y);
				for (Point pt : list){
					if (Circle.intersecting(point, pt)){
						intersecting = true;
						continue;
					}
				}
			}
			list.add(point);
		}
		return list;
	}
	
}

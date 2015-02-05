package gui;

import geometry.Centroid;
import geometry.Circle;
import geometry.Point;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

/**
 * It's also kind of the model.
 * @author aaroncraig
 */
public class Controller {
	
	// Fields.
	// ------------------------------------------------
	private Gui frame;
	private List<Point> world = new ArrayList<Point>();
	private List<Centroid> centroids = new ArrayList<Centroid>();
	private int numClusters = 5;
	
	// Constructors.
	// ------------------------------------------------
	public Controller(Gui frame){
		this.frame = frame;
	}
	
	// Instance methods.
	// ------------------------------------------------
	public void sendEvent(Signal signal){
		
		switch(signal){
		case MAKE_WORLD:
			//makeWorld(frame.getCanvasDimensions());
			break;
		case INITIALISE:
			initialise();
			break;
		case STEP:
			step();
			break;
		default:
			throw new IllegalStateException("Unknown signal sent to controller: " + signal);
		}
		
	}
	
	public List<Point> getWorld(){
		return world;
	}
	
	public List<Centroid> getCentroids(){
		return centroids;
	}
	
	// Helper methods.
	// ------------------------------------------------
	private void makeWorld(Dimension dimensions, int numPoints){
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
		this.world = list;
	}
	
	private void initialise(){
		if (numClusters < world.size()) throw new IllegalStateException("More centroids than points.");
		for (int i = 0; i < numClusters; i++){
			Centroid centroid = null;
			boolean intersecting = false;
		}
	}
	
	private void step(){
		
	}
	
}

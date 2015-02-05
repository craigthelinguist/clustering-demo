package gui;

import geometry.Centroid;
import geometry.Circle;
import geometry.Point;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tools.ColourWizard;

/**
 * It's also kind of the model.
 * @author aaroncraig
 */
public class Controller {
	
	// Fields.
	// ------------------------------------------------
	private Gui gui;
	private List<Point> world = new ArrayList<Point>();
	private List<Centroid> centroids = new ArrayList<Centroid>();
	
	// Constructors.
	// ------------------------------------------------
	public Controller(){
	}
	
	// Instance methods.
	// ------------------------------------------------
	public void sendEvent(Signal signal){
		if (gui == null) return;		
		switch(signal){
		case MAKE_WORLD:
			int numPoints = gui.getNumberOfPoints();
			makeWorld(gui.getCanvasDimensions(), numPoints);
			break;
		case INITIALISE:
			initialise(gui.getNumberOfClusters());
			break;
		case STEP:
			step();
			break;
		default:
			throw new IllegalStateException("Unknown signal sent to controller: " + signal);
		}
		
		gui.redraw();
	}
	
	public void setGui(Gui gui){
		this.gui = gui;
	}
	
	public List<Point> getWorld(){
		return world;
	}
	
	public List<Centroid> getCentroids(){
		return centroids;
	}
	
	// Helper methods.
	// ------------------------------------------------
	
	/**
	 * Randomly generates points in a new world.
	 * @param dimensions: dimensions of the world
	 * @param numPoints: number of points to generate
	 */
	private void makeWorld(Dimension dimensions, int numPoints){
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < numPoints; i++){
			Point point = null;
			boolean intersecting = true;
			outer: while (intersecting){
				int x = (int)(Math.random()*dimensions.getWidth());
				int y = (int)(Math.random()*dimensions.getHeight());
				point = new Point(x,y);
				if (!point.withinWorld(dimensions)) continue;
				for (Point pt : list){
					if (Circle.intersecting(point, pt)){
 						continue outer;
					}
				}
				intersecting = false;
			}
			list.add(point);
		}
		this.world = list;
		this.centroids = new ArrayList<Centroid>();
	}
	
	/**
	 * Initialises centroids.
	 * @param numClusters: number of centroids.
	 */
	private void initialise(int numClusters){
		if (numClusters > world.size() || world.size() == 0) throw new IllegalStateException("More centroids than points.");
		this.centroids = new ArrayList<Centroid>();
		Set<Integer> randomIndices = new HashSet<Integer>();
		while (randomIndices.size() < numClusters){
			Integer randomIndex = new Integer((int) (Math.random()*world.size()));
			randomIndices.add(randomIndex);
		}
		Color[] colours = ColourWizard.getRandomColours(numClusters);
		int index = 0;
		for (Integer intt : randomIndices){
			Point point = world.get(intt);
			Centroid centroid = new Centroid(point.getX(), point.getY(), colours[index++]);
			this.centroids.add(centroid);
		}
	}

	/**
	 * Perform one iteration of the K-Means algorithm.
	 */
	private void step(){
		
	}
	
	/**
	 * Creates a random colour.
	 * @return Color object
	 */
	private Color randomColour(){
		int r = (int) Math.min(255, Math.random()*255 + 80);
		int g = (int) Math.min(255, Math.random()*255 + 80);
		int b = (int) Math.min(255, Math.random()*255 + 80);
		return new Color(r, g, b);
	}
	
}

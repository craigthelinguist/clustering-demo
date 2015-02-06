package clustering;

import geometry.Centroid;
import geometry.Circle;
import geometry.Point;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tools.ColourWizard;

public class World {
	
	// Enum.
	// ------------------------------------------------
	public enum State{
		INIT_CENTROIDS, ASSIGN_POINTS, REJIG_CENTROIDS;
	}
	
	// Fields.
	// ------------------------------------------------
	private List<Point> points;
	private List<Centroid> centroids;
	private Map<Centroid, List<Point>> clusters;
	private State state;

	// Constructors.
	// ------------------------------------------------
	public World(Dimension dimensions, int numPoints){
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
		this.points = list;
		this.centroids = new ArrayList<Centroid>();
		this.state = State.INIT_CENTROIDS;
	}
	
	// Instance methods.
	// ------------------------------------------------
	
	/**
	 * Initialises centroids.
	 * @param numClusters: number of centroids.
	 */
	public void initCentroids(int numClusters){
		if (numClusters > points.size() || points.size() == 0) throw new IllegalStateException("More centroids than points.");
		this.centroids = new ArrayList<Centroid>();
		Set<Integer> randomIndices = new HashSet<Integer>();
		while (randomIndices.size() < numClusters){
			Integer randomIndex = new Integer((int) (Math.random()*points.size()));
			randomIndices.add(randomIndex);
		}
		Color[] colours = ColourWizard.getRandomColours(numClusters);
		int index = 0;
		for (Integer intt : randomIndices){
			Point point = points.get(intt);
			Centroid centroid = new Centroid(point.getX(), point.getY(), colours[index++]);
			this.centroids.add(centroid);
		}
		initClusters();
		this.state = State.ASSIGN_POINTS;
	}
	

	/**
	 * Perform one iteration of the K-Means algorithm.
	 */
	public void step(){
		switch (state){
		case INIT_CENTROIDS:
			return;
		case ASSIGN_POINTS:
			assignToClusters();
			break;
		case REJIG_CENTROIDS:
			rejigCentroids();
			break;
		default:
			throw new IllegalStateException("Unknown state: " + state);
		}
	}
	
	/**
	 * Initialise the map representing the clusters and its contained points.
	 */
	private void initClusters(){
		this.clusters = new HashMap<Centroid, List<Point>>();
		for (Centroid centroid : centroids){
			clusters.put(centroid, new ArrayList<Point>());
		}
		for (Point point : points){
			point.setCluster(null);
		}
	}

	/**
	 * Recalculate the position of the centroids based on the current clusters.
	 * Initialise the clusters.
	 */
	private void rejigCentroids(){
		List<Centroid> newCentroids = new ArrayList<Centroid>();
		for (Map.Entry<Centroid, List<Point>> cluster : clusters.entrySet()){
			Centroid centroid = cluster.getKey();
			List<Point> points = cluster.getValue();
			int xMean, yMean;
			xMean = yMean = 0;
			if (points.size() == 0) throw new IllegalStateException("taking mean of 0 points");
			for (Point pt : points){
				xMean += pt.getX();
				yMean += pt.getY();
			}
			xMean = (int) (1f * xMean / points.size());
			yMean = (int) (1f * yMean / points.size());
			Centroid newCentroid = new Centroid(xMean, yMean, centroid.getColour());
			newCentroids.add(newCentroid);
		}
		this.centroids = newCentroids;
		initClusters();
		this.state = State.ASSIGN_POINTS;
	}
	
	/**
	 * Look at the current centroids and assign points to clusters based on their
	 * distance.
	 */
	private void assignToClusters(){
		for (Point point : points){
			Centroid closest = null;
			double closestDist = -1.0;
			for (Centroid centroid : centroids){
				double distance = Circle.distance(point, centroid);
				if (closest == null || distance < closestDist){
					closest = centroid;
					closestDist = distance;
				}
			}
			clusters.get(closest).add(point);
			point.setCluster(closest);
		}
		this.state = State.REJIG_CENTROIDS;
	}
	
	public List<Point> getPoints(){
		return this.points;
	}
	
	public List<Centroid> getCentroids(){
		return this.centroids;
	}
	
	public Map<Centroid, List<Point>> getClusters(){
		return this.clusters;
	}
	
	
}



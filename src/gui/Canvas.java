package gui;

import geometry.Centroid;
import geometry.Point;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class Canvas extends JComponent{

	// Constants.
	// ------------------------------------------------
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	// Fields.
	// ------------------------------------------------
	private Controller controller;
	
	// Constructors.
	// ------------------------------------------------
	public Canvas(Controller controller) {
		this.controller = controller;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	// Instance methods.
	// ------------------------------------------------
	@Override
	protected void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight());
		List<Point> world = controller.getWorld();
		for (Point pt : world){
			pt.draw(g);
		}
		List<Centroid> centroids = controller.getCentroids();
		for (Centroid centroid : centroids){
			centroid.draw(g);
		}
	}

}

package gui;

import geometry.Centroid;
import geometry.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class Canvas extends JComponent{

	// Fields.
	// ------------------------------------------------
	private Controller controller;
	
	// Constructors.
	// ------------------------------------------------
	public Canvas(Controller controller) {
		this.controller = controller;
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

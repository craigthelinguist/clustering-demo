package gui;

import geometry.Centroid;
import geometry.Point;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

import clustering.World;

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
		World world = controller.getWorld();
		if (world == null) return;
		List<Point> points = world.getPoints();
		for (Point pt : points) pt.draw(g);
		List<Centroid> centroids = world.getCentroids();
		for (Centroid centroid : centroids) centroid.draw(g);
	}

}

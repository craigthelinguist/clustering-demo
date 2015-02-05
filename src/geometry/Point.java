package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Circle {

	// Fields.
	// ------------------------------------------------
	private Centroid cluster = null;

	// Constructors.
	// ------------------------------------------------
	public Point(int x, int y){
		this.setPos(x,y);
	}

	// Instance methods.
	// ------------------------------------------------
	public void setCluster(Centroid newCluster){
		this.cluster = newCluster;
	}
	
	public Color getColour(){
		if (cluster == null) return Color.WHITE;
		Color colour = cluster.getColour();
		return new Color(colour.getRed(), colour.getGreen(), colour.getBlue(), 120);
	}
	
}

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
	@Override
	public void draw(Graphics g) {
		int x = this.getX();
		int y = this.getY();
		g.setColor(getColour());
		g.fillOval(x, y, RADIUS, RADIUS);
		g.setColor(Color.BLACK);
		g.fillOval(x, y, RADIUS, RADIUS);
	}

	public void setCluster(Centroid newCluster){
		this.cluster = newCluster;
	}
	
	public Color getColour(){
		if (cluster == null) return Color.WHITE;
		Color colour = cluster.getColour();
		return new Color(colour.getRed(), colour.getGreen(), colour.getBlue(), 120);
	}
	
}

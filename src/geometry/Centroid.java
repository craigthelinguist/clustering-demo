package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Centroid extends Circle {
	
	// Fields.
	// ------------------------------------------------
	private final Color colour;
	
	// Constructors.
	// ------------------------------------------------
	public Centroid(int x, int y, Color colour){
		this.setPos(x, y);
		this.colour = colour;
	}
	
	// Instance methods.
	// ------------------------------------------------
	@Override
	public void draw(Graphics g) {
		int x = this.getX() - RADIUS/2;
		int y = this.getY() - RADIUS/2;
		g.setColor(colour);
		g.fillOval(x, y, RADIUS, RADIUS);
		for (int i = 0; i < 3; i++){
			g.setColor(Color.BLACK);
			g.fillOval(x+i, y+i, RADIUS-2*i, RADIUS-2*i);
		}
	}
	
	public Color getColour(){
		return colour;
	}
	
}

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
		super.draw(g);
		int x = this.getX();
		int y = this.getY();
		g.setColor(Color.BLACK);
		g.drawLine(x, y-RADIUS, x, y+RADIUS);
		g.drawLine(x-RADIUS, y, x+RADIUS, y);
	}
	
	public Color getColour(){
		return colour;
	}
	
}

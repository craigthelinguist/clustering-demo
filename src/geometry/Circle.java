package geometry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class Circle {

	// Constants.
	// ------------------------------------------------
	public static final int RADIUS = 10;
	
	// Fields
	// ------------------------------------------------	
	private int y;
	private int x;
	
	// Class Methods
	// ------------------------------------------------
	public static boolean intersecting(Circle c1, Circle c2){
		return distance(c1, c2) < 2*RADIUS;
		//int dx = c1.x - c2.x;
		//int dy = c1.y - c2.y;
		//return Math.sqrt(dx*dx + dy*dy) < 2*RADIUS ;
	}
	
	public static double distance(Circle c1, Circle c2){
		int dx = c1.x - c2.x;
		int dy = c1.y - c2.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	// Instance methods.
	// ------------------------------------------------
	public void setPos(int newX, int newY){
		this.x = newX;
		this.y = newY;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	@Override
	public String toString(){
		return "("+x+","+y+")";
	}
	
	public boolean withinWorld(Dimension dimensions){
		int wd = (int) dimensions.getWidth();
		int ht = (int) dimensions.getHeight();
		if (x - 2*RADIUS < 0) return false;
		if (y - 2*RADIUS < 0) return false;
		if (x + 2*RADIUS >= wd) return false;
		if (y + 2*RADIUS >= ht) return false;
		return true;
	}

	public void draw(Graphics g){
		// bounding box
		//g.setColor(Color.BLACK);
		//g.drawRect(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
		
		int x = this.getX();
		int y = this.getY();

		g.setColor(getColour());
		g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
		g.setColor(Color.BLACK);
		g.drawOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}
	
	public abstract Color getColour();
	
}

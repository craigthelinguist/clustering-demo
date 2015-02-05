package geometry;

import java.awt.Graphics;

public abstract class Circle {

	// Constants.
	// ------------------------------------------------
	public static final int RADIUS = 6;
	
	// Fields
	// ------------------------------------------------	
	private int y;
	private int x;
	
	// Class Methods
	// ------------------------------------------------
	public static boolean intersecting(Circle c1, Circle c2){
		int dx = c1.x - c2.x;
		int dy = c1.y - c2.y;
		return Math.sqrt(dx*dx + dy*dy) < RADIUS;
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
	
	// Abstract methods.
	// ------------------------------------------------
	public abstract void draw(Graphics g);
	
}

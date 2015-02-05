package gui;

import geometry.Circle;
import geometry.Point;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Gui {
	
	// Fields.
	// ------------------------------------------------
	private JFrame frame;
	private Canvas canvas;
	
	// Constructors.
	// ------------------------------------------------
	public Gui(Controller controller){
		this.frame = new JFrame();
		this.canvas = new Canvas(controller);
	}

	// Instance methods.
	// ------------------------------------------------
	public Dimension getCanvasDimensions() {
		return canvas.getSize();
	}
	
}

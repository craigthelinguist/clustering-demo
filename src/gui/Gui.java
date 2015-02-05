package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Gui {
	
	// Fields.
	// ------------------------------------------------
	private JFrame frame;
	private Canvas canvas;
	private ButtonPanel buttonPanel;
	
	// Constructors.
	// ------------------------------------------------
	public Gui(Controller controller){
		this.frame = new JFrame();
		this.canvas = new Canvas(controller);
		this.buttonPanel = new ButtonPanel(this, controller);
		frame.add(canvas, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Instance methods.
	// ------------------------------------------------
	public Dimension getCanvasDimensions() {
		return canvas.getSize();
	}
	
	public int getNumberOfPoints(){
		return buttonPanel.getNumberOfPoints();
	}

	public int getNumberOfClusters() {
		return buttonPanel.getNumberOfClusters();
	}

	public void redraw() {
		frame.repaint();
	}
	
}

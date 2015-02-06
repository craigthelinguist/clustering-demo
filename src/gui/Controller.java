package gui;

import clustering.World;

public class Controller {
	
	// Fields.
	// ------------------------------------------------
	private Gui gui;
	private World world;
	
	// Instance methods.
	// ------------------------------------------------
	public void sendEvent(Signal signal){
		if (gui == null) return;		
		switch(signal){
		case MAKE_WORLD:
			int numPoints = gui.getNumberOfPoints();
			this.world = new World(gui.getCanvasDimensions(), numPoints);
			break;
		case INITIALISE:
			world.initCentroids(gui.getNumberOfClusters());
			break;
		case STEP:
			world.step();
			break;
		default:
			throw new IllegalStateException("Unknown signal sent to controller: " + signal);
		}
		
		gui.redraw();
	}
	
	public void setGui(Gui gui){
		this.gui = gui;
	}
	
	public World getWorld(){
		return world;
	}
	
}

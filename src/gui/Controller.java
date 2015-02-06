package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import utilities.ImageSaver;

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
		case SAVE_IMAGE:
			BufferedImage bi = gui.getImage();
			File file = gui.selectFileToSave();
			if (file == null) return;
			try{
				ImageSaver.save(bi, file);
			}
			catch(IOException ioe){
				return; //TODO  actual error handling
			}
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

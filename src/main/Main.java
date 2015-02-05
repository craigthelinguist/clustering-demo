package main;

import gui.Controller;
import gui.Gui;

public class Main {

	public static void main(String[] args){
		Controller controller = new Controller();
		Gui gui = new Gui(controller);
		controller.setGui(gui);
	}
	
}

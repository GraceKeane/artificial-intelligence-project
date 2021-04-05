package ie.gmit.sw.ai;

import javafx.application.Application;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 * @author Grace Keane
 * 
 * Reads in Fuzzy logic files & starts game.
 * 
 */

public class Runner {
	
	public static FIS fis;
	public static FIS fis2;
	
	public static void main(String[] args) {
		/*
		 * PLEASE READ CAREFULLY
		 * ---------------------
		 * If you need to load FCL functions to the application or
		 * train, configure and load a neural network, then it is 
		 * best to do all of this before loading the UI. Launching
		 * a UI in any language or framework and then starting a 
		 * long running task in the same thread is guaranteed to
		 * freeze the screen and crash the programme.
		 * 
		 * NB: you can assume that the JavaFX 15 API is already
		 * available and configured on the MODULE-PATH (NOT THE 
		 * CLASSPATH). 
		 */
				 		
		// Loading in Fuzzy Logic files first to prevent freezing/ crashing the program
		
		// Fuzzy logic file to determine how far the player is from the exit
		fis = FIS.load("./resources/fuzzy/findExit.fcl", true);
		
		// Fuzzy logic file to determine how far the player is from another enemy
		fis2 = FIS.load("./resources/fuzzy/findEnemy.fcl", true);
		
		
		// Error handling
		if (fis == null || fis2 == null) {
			System.out.println("Unable to load fuzzy logic file");
			System.exit(0);
		}
		 
		
		/*
		 * Launch the JavaFX UI only when all the long-running AI 
		 * configuration tasks have been completed. Use the arrow 
		 * keys to move the player character and the 'Z' key to 
		 * toggle the zoom in / out.
		 */
		Application.launch(GameWindow.class, args);
	}
}
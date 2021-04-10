package ie.gmit.sw.ai;

import javafx.application.Platform;

/**
 * @author Grace Keane
 * 
 * Class which links java to fcl file and specifies which print
 * statement to execute determined by how far the player
 * is from the maze exit.
 * 
 */

public class MazeExitLocator {
	
	// Setting a timer. Determines how long it takes for
	// player to reach the exit
	public static long time = System.currentTimeMillis();
	
	public static void mazeExitLocator() {
		// Creating a new instance
        ExitHelper fc = new ExitHelper();
        // Calling correct params and setting the fuzzy value
        int fuzzyValue = fc.getFuzzyHelper(GameWindow.playerLocation, GameWindow.mazeExit);

        // Fuzzy logic 
	    // Determine how far the player is from the maze exit.
	    // Goes from knowhere near to extremely close.
        if (fuzzyValue >= 180) {
            System.out.println("[EXIT INFO] Player is Knowhere Near Exit");
        } else if (fuzzyValue >= 150) {
            System.out.println("[EXIT INFO] Player is Not So Close to Exit");
        } else if (fuzzyValue >= 120) {
            System.out.println("[EXIT INFO] Player is Closer to Exit");
        } else if (fuzzyValue >= 80) {
            System.out.println("[EXIT INFO] Player is Near Exit");
        } else if (fuzzyValue >= 60) {
            System.out.println("[EXIT INFO] Player is Getting There");
        } else if (fuzzyValue >= 30) {
            System.out.println("[EXIT INFO] Player is So Close to Exit");
        } else if (fuzzyValue >= 20) {
            System.out.println("[EXIT INFO] Player is Very Close to Exit");
        } else if (fuzzyValue >= 10) {
            System.out.println("[EXIT INFO] Player is Extremely Close to Exit");
        }
        
        // if Player is at the exit of the maze (randomly generated) game is won.
        if (GameWindow.playerLocation == GameWindow.mazeExit) {
            System.out.println("Victory! You escaped the Maze! Game Won!");
            // Prints out how long it too for player to win/lose the game
            System.out.println("You completed the maze in: " + (System.currentTimeMillis() - time) + " ms"); 
            Platform.exit(); // Exit GUI.
        }
    }

}

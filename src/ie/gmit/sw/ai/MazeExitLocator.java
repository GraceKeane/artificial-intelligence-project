package ie.gmit.sw.ai;

import javafx.application.Platform;

public class MazeExitLocator {
	
	public static long time = System.currentTimeMillis();
	
	public static void mazeExitLocator() {
        ExitHelper fc = new ExitHelper();
        // Set inputs
        int fuzzyValue = fc.getFuzzyHelper(GameWindow.playerLocation, GameWindow.mazeExit);

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

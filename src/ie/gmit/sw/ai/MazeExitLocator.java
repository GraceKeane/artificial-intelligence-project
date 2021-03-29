package ie.gmit.sw.ai;

import javafx.application.Platform;

public class MazeExitLocator {
	
	public static void mazeExitLocator() {
        ExitHelper fc = new ExitHelper();
        // Set inputs
        int fuzzyValue = fc.getFuzzyHelper(GameWindow.playerLocation, GameWindow.mazeExit);

        if (fuzzyValue >= 180) {
            System.out.println("Player is Knowhere Near");
        } else if (fuzzyValue >= 150) {
            System.out.println("Player is Not So Close");
        } else if (fuzzyValue >= 120) {
            System.out.println("Player is Closer");
        } else if (fuzzyValue >= 80) {
            System.out.println("Player is Near");
        } else if (fuzzyValue >= 60) {
            System.out.println("Player is Getting There");
        } else if (fuzzyValue >= 30) {
            System.out.println("Player is So Close");
        } else if (fuzzyValue >= 20) {
            System.out.println("Player is Very Close");
        } else if (fuzzyValue >= 10) {
            System.out.println("Player is Extremely Close");
        }
        
        // if Player is at the exit of the maze (randomly generated) game is won.
        if (GameWindow.playerLocation == GameWindow.mazeExit) {
            System.out.println("You escaped the Maze! Game Won!");
            Platform.exit(); // Exit GUI.
        }
    }

}

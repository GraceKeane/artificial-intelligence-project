package ie.gmit.sw.ai;

import javafx.application.Platform;

/**
 * @author Grace Keane
 * 
 * Class which links java to fcl file and specifies which print
 * statement to execute determined by how far the player
 * is from an enemy.
 * 
 */
public class MazeEnemyLocator implements Command {
			
		public static void mazeEnemyLocator() {
			FindEnemy fe = new FindEnemy();
			
		    int fuzzyValue = fe.getEnemyHelper(GameWindow.playerLocation, GameModel.enemyLocation);
		    
		    if (fuzzyValue >= 180) {
		        System.out.println("[ENEMY INFO] Enemy Frozen");
		    } else if (fuzzyValue >= 150) {
		        System.out.println("[ENEMY INFO] Enemy Perished");
		    } else if (fuzzyValue >= 120) {
		        System.out.println("[ENEMY INFO] Enemy Cold");
		    } else if (fuzzyValue >= 80) {
		        System.out.println("[ENEMY INFO] Enemy Chill");
		    } else if (fuzzyValue >= 60) {
		        System.out.println("[ENEMY INFO] Enemy Warm");
		    } else if (fuzzyValue >= 30) {
		        System.out.println("[ENEMY INFO] Enemy Hot");
		    } else if (fuzzyValue >= 20) {
		        System.out.println("[ENEMY INFO] Enemy Boiling");
		    } else if (fuzzyValue >= 10) {
		        System.out.println("[ENEMY INFO] Enemy Steaming");
		    }
		
		}

		@Override
		public void execute() {
			// TODO Auto-generated method stub
			
		}
	}

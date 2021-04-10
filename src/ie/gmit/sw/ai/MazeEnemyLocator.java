package ie.gmit.sw.ai;

/**
 * @author Grace Keane
 * 
 * Class which links java to fcl file and specifies which print
 * statement to execute determined by how far the player
 * is from an enemy.
 * 
 */
public class MazeEnemyLocator {
			
		public static void mazeEnemyLocator() {
			// Creating a new instance
			FindEnemy fe = new FindEnemy();
			
			// Calling correct params and setting the fuzzy value
		    int fuzzyValue = fe.getEnemyHelper(GameWindow.playerLocation, CharacterTask.enemyLocation);
		    
		    // Fuzzy logic 
		    // Determine how far the player is from the enemy.
		    // Goes from hot to cold.
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
	}
